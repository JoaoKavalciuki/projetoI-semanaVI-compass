package com.compass.projectOne.repositories;

import com.compass.projectOne.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
