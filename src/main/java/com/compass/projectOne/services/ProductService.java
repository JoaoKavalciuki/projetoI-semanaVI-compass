package com.compass.projectOne.services;

import com.compass.projectOne.entities.Category;
import com.compass.projectOne.entities.Product;
import com.compass.projectOne.repositories.CategoryRepository;
import com.compass.projectOne.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public List<Product>  findAll(){
        return productRepository.findAll();
    }

    public Product findById(Long id){
        Optional<Product> order = productRepository.findById(id);

        return order.get();
    }
}
