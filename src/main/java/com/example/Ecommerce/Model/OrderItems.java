package com.example.Ecommerce.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class OrderItems {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Double price;
    private String description;
    private Integer quantity;
    private String image;



    // 🔗 Link to Product
    @ManyToOne
    @JoinColumn(name = "order_id")
    @JsonIgnore
    private Product product;
}
