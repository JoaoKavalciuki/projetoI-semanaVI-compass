package com.compass.projectOne.controllers;

import com.compass.projectOne.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping
    public ResponseEntity<User> findAll(){
        User user = new User("Maria", "leverkusen@gmail.com", "12234566545", "12345");

        return ResponseEntity.ok(user);
    }
}
