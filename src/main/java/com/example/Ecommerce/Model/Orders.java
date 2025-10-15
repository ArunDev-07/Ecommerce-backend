package com.example.Ecommerce.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @OneToMany(cascade = CascadeType.ALL , orphanRemoval = true)
    @JoinColumn(name = "order_id")
    private List<OrderItems> orderItems = new ArrayList<OrderItems>();

    private Double totalOrderAmount ;
    private Double taxAmount ;
    private Double totalAmount ;
    private String status ;
    private String orderNo ;

 }
