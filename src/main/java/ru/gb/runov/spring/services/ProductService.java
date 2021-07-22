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
//    private ProductInMemoryRepository memoryRepository;
    private final ProductJpaRepository productRepository;

    public ProductService(ProductJpaRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Page<ProductDto> findAll(Specification<Product> spec, int page, int pageSize) {
        if(page < 0)
            throw new RuntimeException();

        return productRepository.findAll(spec, PageRequest.of(page - 1, pageSize)).map(ProductDto::new);
    }

    public Product findById(Long id) {
        //Optional<Product> pr = Optional.of(new Product(1,"opt",1));
        //Long id = pr.get().getId();
        return productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("This product does not exist - " + id));
    }
    public Optional<ProductDto> findProductById(Long id) {
        return productRepository.findById(id).map(ProductDto::new);
    }

    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    public Product saveOrUpdate(Product product) {
//        return productRepository.saveOrUpdate(s);
      return productRepository.save(product);
    }

 /*
    public Optional<Product> findById_6(Long id) {
        return memoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("This product does not exist - " + id));
    }
    public List<Product> findAll() {
        return memoryRepository.findAll();
    }

    public List<Product> findAll(Integer minScore, Integer maxScore) {
        List<Product> out = findAll();
        if (minScore != null) {
            out = out.stream().filter(s -> s.getPrice() >= minScore).collect(Collectors.toList());
        }
        if (maxScore != null) {
            out = out.stream().filter(s -> s.getPrice() <= maxScore).collect(Collectors.toList());
        }
        return out;
    }

    public Product saveOrUpdate(Product s) {
        return memoryRepository.saveOrUpdate(s);
//      return memoryRepository.save(product);
    }

    public void deleteBydId(Long id) {
        memoryRepository.deleteById(id);
    }

//    public Product findProductById(Long id) {
    public Optional<ProductDto> findProductById(Long id) {
        //return memoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("This product does not exist - " + id));
        return (Optional<ProductDto>) memoryRepository.findById(id).map(ProductDto::new);
    }
  */
}

/*
========
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import ru.geekbrains.happy.market.model.dtos.ProductDto;
import ru.geekbrains.happy.market.model.entities.Product;
import ru.geekbrains.happy.market.repositories.ProductRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public Optional<ProductDto> findProductById(Long id) {
        return productRepository.findById(id).map(ProductDto::new);
    }

    public Page<ProductDto> findAll(Specification<Product> spec, int page, int pageSize) {
        if(page < 0)
            throw new RuntimeException();
        return productRepository.findAll(spec, PageRequest.of(page - 1, pageSize)).map(ProductDto::new);
    }

    public Product saveOrUpdate(Product product) {
        return productRepository.save(product);
    }

    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }
*/