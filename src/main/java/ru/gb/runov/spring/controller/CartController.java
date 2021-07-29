package ru.gb.runov.spring.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.gb.runov.spring.exceptions.ResourceNotFoundException;
import ru.gb.runov.spring.model.dtos.ProductDto;
import ru.gb.runov.spring.services.CartService;

@Controller    //@RestController
@RequestMapping("/api/v1/cart")
public class CartController {
    private final CartService cartService;

    public CartController(CartService srv) {
        this.cartService = srv;
    }

    // http://localhost:8189/rrr/api/v1/products
    @GetMapping("/{id}")
    public ProductDto findProductById(@PathVariable Long id) {
        return cartService.findProductById(id).orElseThrow(() -> new ResourceNotFoundException("Product in CART with id: " + id + " doesn't exist"));
    }

    @DeleteMapping("/{id}")
    public void updateProduct(@PathVariable Long id) {
        cartService.deleteById(id);
    }
}