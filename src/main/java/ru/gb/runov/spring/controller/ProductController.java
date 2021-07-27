package ru.gb.runov.spring.controller;

import lombok.RequiredArgsConstructor;
import lombok.RequiredArgsConstructor;
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


    @GetMapping("/{id}")
    public ProductDto findProductById(@PathVariable Long id) {
        return productService.findProductById(id).orElseThrow(() -> new ResourceNotFoundException("Product with id: " + id + " doesn't exist"));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Product saveNewProduct(@RequestBody Product product) {
        product.setId(null);
        return productService.saveOrUpdate(product);
    }

    @PutMapping
    public Product updateProduct(@RequestBody Product product) {
        return productService.saveOrUpdate(product);
    }

    @DeleteMapping("/{id}")
    public void updateProduct(@PathVariable Long id) {
        productService.deleteById(id);
    }
}

    //////////////
     /*
    @GetMapping // GET http://localhost:8189/app/products
    public String showAll(Model model,
                          @RequestParam(required = false, name = "min_score") Integer minScore,
                          @RequestParam(required = false, name = "max_score") Integer maxScore
    ) {
        model.addAttribute("products", productService.findAll(minScore, maxScore));
        return "products";
    }

    @GetMapping("/test")
    @ResponseBody
    public Product getById(@RequestParam Long id){
        return productService.findById(id);
    }
    //    @DeleteMapping("/delete/{id}")
      //  productService.deleteById(id);
      //  return "redirect:/products"; // [http://localhost:8189/app]/products
//
    @GetMapping
    public Page<ProductDto> findAllProducts(
            @RequestParam MultiValueMap<String, String> params,
            @RequestParam(name = "p", defaultValue = "1") Integer page
    ) {
        if (page < 1) {
            page = 1;
        }
        return productService.findAll(ProductSpecifications.build(params), page, 2);
    }
      */