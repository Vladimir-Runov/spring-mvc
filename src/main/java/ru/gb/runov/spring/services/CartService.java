package ru.gb.runov.spring.services;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import ru.gb.runov.spring.model.dtos.ProductDto;
import ru.gb.runov.spring.model.entities.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class CartService {

    Map<Product, Integer> cartEntry;

    public void add(Product p, int n) {
        if (cartEntry.containsValue(p) )
            cartEntry.replace(p, cartEntry.get(p)+n);
        else
            cartEntry.put(p,n);
    }

    public void deleteById(Long id) {
        for (Map.Entry<Product, Integer> entry : cartEntry.entrySet())
            if (entry.getKey().getId() == id) {
                cartEntry.remove(entry);
                return;
            }
    }
    public void deleteAll() {
        cartEntry.clear();
    }

    public void del(Product p) {
        if (cartEntry.containsValue(p) )
            cartEntry.remove(p);
    }

    public List<Product> findProductByIdEx(Long id) {
        List<Product> lst = new ArrayList<>();
        for (Map.Entry<Product, Integer> entry : cartEntry.entrySet())
            if (entry.getKey().getId() == id) {
                lst.add(entry.getKey());
                return lst;
            }
        return lst;
    }

    public Optional<ProductDto> findProductById(Long id) {
        //  не знаю пока как тут быть.... жду ответ от Александра.
        return Optional.empty(); // findProductByIdEx(id); //map(ProductDto::new);
    }
}
