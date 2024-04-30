package com.compass.projectOne.config;

import com.compass.projectOne.entities.User;
import com.compass.projectOne.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
    private UserRepository userRepository;

    @Autowired
    public TestConfig(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    @Override
    public void run(String... args) {
        User user1 = new User("John", "john@outlook.com", "23454657", "123456");
        User user2 = new User("Mary", "mary@outlook.com", "23465743", "123456");

        userRepository.saveAll(Arrays.asList(user1, user2));
    }
}
