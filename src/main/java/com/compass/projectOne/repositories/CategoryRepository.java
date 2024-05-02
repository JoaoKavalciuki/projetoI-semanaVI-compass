package com.compass.projectOne.repositories;

import com.compass.projectOne.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
