package com.compass.projectOne.repositories;

import com.compass.projectOne.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
