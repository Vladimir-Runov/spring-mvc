package com.geekbrains.spring.mvc.repositories;

import com.geekbrains.spring.mvc.model.Product;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@Component
public class ProductRepository {
    private List<Product> products;

    @PostConstruct
    public void init() {
        products = new ArrayList<>();
        System.out.println("init()");
        products.add(new Product(1L, "BMW X1", 1251));
        products.add(new Product(2L, "BMW X2", 1152));
        products.add(new Product(3L, "BMW X3", 3275));
        products.add(new Product(4L, "BMW X4", 4212));
    }

    public List<Product> getAll() {
        return Collections.unmodifiableList(products);
    }

    public void save(Product p) {
        products.add(p);
    }

    public void deleteById(Long id) {
        products.removeIf(p -> p.getId().equals(id));
    }
}
