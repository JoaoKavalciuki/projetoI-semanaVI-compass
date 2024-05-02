package com.compass.projectOne.services;

import com.compass.projectOne.entities.Category;
import com.compass.projectOne.entities.Order;
import com.compass.projectOne.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

    public List<Category>  findAll(){
        return categoryRepository.findAll();
    }

    public Category findById(Long id){
        Optional<Category> order = categoryRepository.findById(id);

        return order.get();
    }
}
