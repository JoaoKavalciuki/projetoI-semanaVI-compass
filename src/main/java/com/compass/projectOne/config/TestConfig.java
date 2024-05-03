package com.compass.projectOne.config;

import com.compass.projectOne.entities.Category;
import com.compass.projectOne.entities.Order;
import com.compass.projectOne.entities.User;
import com.compass.projectOne.entities.enums.OrderStatus;
import com.compass.projectOne.repositories.CategoryRepository;
import com.compass.projectOne.repositories.OrderRepository;
import com.compass.projectOne.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
    private UserRepository userRepository;

    private OrderRepository orderRepository;
    private CategoryRepository categoryRepository;

    @Autowired
    public TestConfig(UserRepository userRepository, OrderRepository orderRepository, CategoryRepository categoryRepository){
        this.userRepository = userRepository;
        this.orderRepository = orderRepository;
        this.categoryRepository = categoryRepository;
    }
    @Override
    public void run(String... args) {
        User user1 = new User("John", "john@outlook.com", "23454657", "123456");
        User user2 = new User("Mary", "mary@outlook.com", "23465743", "123456");

        Order order = new Order(Instant.parse("2024-05-02T12:52:00Z"), user1, OrderStatus.PAYD);
        Order order2 = new Order(Instant.parse("2024-03-03T09:45:00Z"), user1, OrderStatus.SHIPPED);
        Order order3 = new Order(Instant.parse("2024-01-02T12:30:00Z"), user2, OrderStatus.WAITING_PAYMENT);

        Category category = new Category("Shoes");
        Category category2 = new Category("Electronic");
        Category category3 = new Category("Cleaning");

        userRepository.saveAll(Arrays.asList(user1, user2));
        orderRepository.saveAll(Arrays.asList(order, order2, order3));
        categoryRepository.saveAll(Arrays.asList(category, category2, category3));
    }
}
