package ru.gb.runov.spring.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.gb.runov.spring.model.Product;
import ru.gb.runov.spring.services.ProductService;

@Controller
@RequestMapping("/products")
//@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

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

    @DeleteMapping("/delete/{id}")
    public String deleteStudentById(@PathVariable Long id) {
        productService.deleteBydId(id);
        return "redirect:/products"; // [http://localhost:8189/app]/products
    }
}
