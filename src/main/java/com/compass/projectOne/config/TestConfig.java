package com.compass.projectOne.config;

import com.compass.projectOne.entities.*;
import com.compass.projectOne.entities.enums.OrderStatus;
import com.compass.projectOne.repositories.*;
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
    private ProductRepository productRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    public TestConfig(UserRepository userRepository, OrderRepository orderRepository, CategoryRepository categoryRepository,
    ProductRepository productRepository)
    {
        this.userRepository = userRepository;
        this.orderRepository = orderRepository;
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
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
        categoryRepository.saveAll(Arrays.asList(category, category2, category3));

        Product product = new Product("Ryzen 5", "AMD CPU", "", 150.00);
        Product product2 = new Product("Water cooler", "NZXT water cooler", "", 75.00);
        Product product3 = new Product("MX Keys", "Logitech keyboard", "", 100.00);
        Product product4 = new Product("Adidas Yeezy", "Adidas shoes designed by Kanye West", "", 800.00);
        Product product5 = new Product("Dish Washer", "Brastemp dish washer", "", 500.00);

        OrderItem orderItem = new OrderItem(order, product, product.getPrice(), 2);
        OrderItem orderItem2 = new OrderItem(order2, product3, product3.getPrice(), 1);
        OrderItem orderItem3 = new OrderItem(order3, product5, product5.getPrice(), 2);

        product.getCategories().add(category2);
        product2.getCategories().add(category2);
        product3.getCategories().add(category2);
        product4.getCategories().add(category);
        product5.getCategories().addAll(Arrays.asList(category2, category3));

        userRepository.saveAll(Arrays.asList(user1, user2));
        orderRepository.saveAll(Arrays.asList(order, order2, order3));
        productRepository.saveAll(Arrays.asList(product, product2, product3, product4, product5));
        orderItemRepository.saveAll(Arrays.asList(orderItem, orderItem2, orderItem3));
    }
}
