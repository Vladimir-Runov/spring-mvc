package com.geekbrains.spring.mvc.controllers;

import com.geekbrains.spring.mvc.model.Product;
import com.geekbrains.spring.mvc.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService ps) {
        this.productService = ps;
    }

    @GetMapping("/all")
    public String getAll(Model model) {
        model.addAttribute("frontProducts", productService.getAll());
        return "all_products";
    }

    @GetMapping("/remove/{id}")
    public String deleteProductById(@PathVariable Long id) {
        productService.deleteById(id);
        return "redirect:/products/all";
    }

    @PostMapping("/add")
//    public String addNewProduct(@RequestParam Long id, @RequestParam String title, @RequestParam int c) {
    public String addNewProduct(@ModelAttribute Product p) {
        productService.save(p);
        return "redirect:/products/all";
    }

    @PostMapping("/json/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void addNewJsonProduct(@RequestBody Product p) {
        productService.save(p);
    }


}

