package ru.gb.runov.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import ru.gb.runov.spring.exceptions.ResourceNotFoundException;
import ru.gb.runov.spring.model.dtos.ProductDto;
import ru.gb.runov.spring.model.entities.Product;
import ru.gb.runov.spring.repositories.ProductJpaRepository;

import java.util.Optional;

@Service
public class    ProductService {
    @Autowired
    private final ProductJpaRepository productRepository;

    public ProductService(ProductJpaRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Page<ProductDto> findAll(Specification<Product> spec, int page, int pageSize) {
        if (page < 0)
            throw new RuntimeException();
        return productRepository.findAll(spec, PageRequest.of(page - 1, pageSize)).map(ProductDto::new);
    }

    public Optional<ProductDto> findProductById(Long id) {
        return productRepository.findById(id).map(ProductDto::new);
    }

    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    public Product saveOrUpdate(Product product) {
        return productRepository.save(product);
    }
}
