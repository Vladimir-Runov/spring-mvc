package ru.gb.runov.spring.controller;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import ru.gb.runov.spring.exceptions.ResourceNotFoundException;
import ru.gb.runov.spring.model.dtos.ProductDto;
import ru.gb.runov.spring.model.entities.Product;
import ru.gb.runov.spring.repositories.specifications.ProductSpecifications;
import ru.gb.runov.spring.services.ProductService;
/*
Урок 8. Thymeleaf
1) Cделайте страницу для отображения всех товаров.
2)* Рядом с каждым товаром в таблице попробуйте сделать кнопку “Удалить”, при нажатии на которую товар должен быть удален и базы.
3)** Попробуйте реализовать разбивку всех товаров на страницы, по 10 товаров на каждой.
*/

//@Controller
@RestController
@RequestMapping("/api/v1/products")
//@RequiredArgsConstructor
public class ProductController {
    //
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public Page<ProductDto> findAllProducts(
            @RequestParam MultiValueMap<String, String> params,
            @RequestParam(name = "p", defaultValue = "1") Integer page) {
        if (page < 1) {
            page = 1;
        }
        return productService.findAll(ProductSpecifications.build(params), page, 2);
    }
    // http://localhost:8189/rrr/api/v1/products


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Product saveNewProduct(@RequestBody Product product) {
        System.out.println(product.getName());
        product.setId(null);
        return productService.saveOrUpdate(product);
    }

    @PutMapping
    public Product updateProduct(@RequestBody Product product) {
        return productService.saveOrUpdate(product);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteById(id);
    }

    @GetMapping("/{id}")
    public ProductDto findProductById(@PathVariable Long id) {
        return productService.findProductById(id).orElseThrow(() -> new ResourceNotFoundException("Product with id: " + id + " doesn't exist"));
    }
}

