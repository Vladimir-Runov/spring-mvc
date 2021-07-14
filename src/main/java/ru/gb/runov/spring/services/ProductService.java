package ru.gb.runov.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gb.runov.spring.exceptions.ResourceNotFoundException;
import ru.gb.runov.spring.model.Product;
import ru.gb.runov.spring.repositories.ProductInMemoryRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class    ProductService {
    @Autowired
    private ProductInMemoryRepository studentInMemoryRepository;

    public Product findById_1(Long id) {
        Optional<Product> pr = Optional.of(new Product(1,"opt",1));
        //Long id = pr.get().getId();
        return studentInMemoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("This product does not exist - " + id));
    }
    public Optional<Product> findById(Long id) {
        return studentInMemoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("This product does not exist - " + id));
    }


    public List<Product> findAll() {
        return studentInMemoryRepository.findAll();
    }

    public List<Product> findAll(Integer minScore, Integer maxScore) {
        List<Product> out = findAll();
        if (minScore != null) {
            out = out.stream().filter(s -> s.getScore() >= minScore).collect(Collectors.toList());
        }
        if (maxScore != null) {
            out = out.stream().filter(s -> s.getScore() <= maxScore).collect(Collectors.toList());
        }
        return out;
    }

    public Product saveOrUpdate(Product s) {
        return studentInMemoryRepository.saveOrUpdate(s);
    }

    public void deleteBydId(Long id) {
        studentInMemoryRepository.deleteById(id);
    }

}
