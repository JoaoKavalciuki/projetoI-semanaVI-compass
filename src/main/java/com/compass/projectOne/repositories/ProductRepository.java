package com.compass.projectOne.repositories;

import com.compass.projectOne.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
