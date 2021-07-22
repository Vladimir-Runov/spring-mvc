package ru.gb.runov.spring.controller;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import ru.gb.runov.spring.exceptions.ResourceNotFoundException;
import ru.gb.runov.spring.model.dtos.ProductDto;
import ru.gb.runov.spring.model.entities.Product;
import ru.gb.runov.spring.repositories.specifications.ProductSpecifications;
import ru.gb.runov.spring.services.CartService;
import ru.gb.runov.spring.services.ProductService;


@Controller
//@RestController
@RequestMapping("/api/v1/cart")
//@RequiredArgsConstructor
public class CartController {
    private final CartService cartService;

    public CartController(CartService srv) {
        this.cartService = srv;
    }

   // @GetMapping
   // public Page<ProductDto> findAllProducts(
   //         @RequestParam MultiValueMap<String, String> params,
   //         @RequestParam(name = "p", defaultValue = "1") Integer page) {
   //     if (page < 1) {
   //         page = 1;
   //     }
   //     return cartService.findAll(ProductSpecifications.build(params), page, 2);
   // }

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