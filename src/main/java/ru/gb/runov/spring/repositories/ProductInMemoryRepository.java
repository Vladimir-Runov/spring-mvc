package ru.gb.runov.spring.repositories;


import org.springframework.stereotype.Component;
import ru.gb.runov.spring.model.Product;

import javax.annotation.PostConstruct;
import java.util.*;

@Component
public class ProductInMemoryRepository {
    private List<Product> Products;

    @PostConstruct
    public void init() {
        this.Products = new ArrayList<>(Arrays.asList(
                new Product(1L, "x1", 70),
                new Product(2L, "x2", 80),
                new Product(3L, "x3", 60)
        ));
    }

    public Product saveOrUpdate(Product s) {
        if (s.getId() != null) {
            for (int i = 0; i < Products.size(); i++) {
                if (Products.get(i).getId().equals(s.getId())) {
                    Products.set(i, s);
                    return s;
                }
            }
        }

        Long newId = Products.stream().mapToLong(Product::getId).max().orElseGet(() -> 0L) + 1L;
        s.setId(newId);
        Products.add(s);
        return s;
    }


    public List<Product> get(){
        return Products;
    }

    public List<Product> findAll() {
        return Collections.unmodifiableList(Products);
    }


    public Optional<Product> findById(Long id) {
        Optional<Product> Product = Optional.of(new Product(111L, "optional", 70));

        return Products.stream()
                .filter(s -> s.getId().equals(id))
                .findFirst();

    }

    public void deleteById(Long id) {
        Products.removeIf(s -> s.getId().equals(id));
    }
}
