package com.feasto.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="orders")
public class Order {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @ManyToOne         //one customer can have multiple orders
    private User customer; //Creating a field entity of customer as a user

    @JsonIgnore
    @ManyToOne          //one restaurant can have many orders
    private Restaurant restaurant;

    private Long totalAmount;

    private String OrderStatus;

    private Date createdAt;

    @ManyToOne
    private Address deliveryAddress;

    @OneToMany          //one order can have multiple items
    private List<OrderItem> items;

    private int totalItem;

    private int totalPrice;
}
