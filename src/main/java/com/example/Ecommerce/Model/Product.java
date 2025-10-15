package com.example.Ecommerce.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    @Column(nullable = false)
    @NotBlank(message = "Name is required")
    private String name ;

    @Column(nullable = false)
    @NotNull(message = "Price is required")
    @PositiveOrZero(message = "Give the values more than 1")
    private Double price ;


    @NotBlank(message = "Description is required")
    private String description ;

    @Column(nullable = false)
    @NotBlank(message = "Category is required")
    private String category ;

    private Double ratings = 0.0 ;


    @Column(nullable = false)
    @NotBlank(message = "Name is required")
    private String seller ;

    @Column(nullable = false)
    @NotNull(message = "Price is required")
    private Integer stock ;
    private Integer numOfReviews = 0 ;

    @OneToMany(cascade = CascadeType.ALL , orphanRemoval = true)
    @JoinColumn(name = "product_id")
    private List<ProductImages> images ;

    @OneToMany(cascade = CascadeType.ALL , orphanRemoval = true)
    @JoinColumn(name = "product_id")
    private List<ProductReviews> reviews ;

    public Product(Long id, String name, Double price, String description,String category , Double ratings, String seller, Integer stock, Integer numOfReviews , List<String> images) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.category = category ;
        this.ratings = ratings;
        this.seller = seller;
        this.stock = stock;
        this.numOfReviews = numOfReviews;
        this.images = images.stream().map(url-> new ProductImages(url,this)).collect(Collectors.toList());

    }
}
