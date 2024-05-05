package com.compass.projectOne.entities;

import com.compass.projectOne.entities.pk.OrderItemPK;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_order_item")
public class OrderItem implements Serializable {
    @EmbeddedId
    private OrderItemPK id = new OrderItemPK();

    private Double price;
    private Integer quantity;


    public OrderItem(Order order, Product product, Double price, Integer quantity) {
        this.price = price;
        this.quantity = quantity;
        this.id.setOrder(order);
        this.id.setProduct(product);
    }

    public OrderItem(){

    }

    @JsonIgnore
    public Order getOrder(){
        return id.getOrder();
    }

    public void setOrder(Order order){
        this.id.setOrder(order);
    }

    public Product getProduct(){
        return this.id.getProduct();
    }

    public void setProduct(Product product){
        this.id.setProduct(product);
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        OrderItem other = (OrderItem) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
