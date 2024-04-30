package com.compass.projectOne.controllers;

import com.compass.projectOne.entities.User;
import com.compass.projectOne.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;
    public UserController(UserService userService){
        this.userService = userService;
    }
    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        List<User> users = userService.findAll();

        return ResponseEntity.ok(users);
    }
}
