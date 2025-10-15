package com.example.Ecommerce.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDtos {
    private Long id ;


    private String name ;


    private Double price ;



    private String description ;


    private String category ;

    private Double ratings = 0.0 ;



    private String seller ;

    private Integer stock ;
    private Integer numOfReviews = 0 ;


    private List<ProductImageDto> images ;

    private List<ProductReviewDto> reviews ;

    public ProductDtos(Long id, String name, Double price, String description,String category , Double ratings, String seller, Integer stock, Integer numOfReviews) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.category = category ;
        this.ratings = ratings;
        this.seller = seller;
        this.stock = stock;
        this.numOfReviews = numOfReviews;

    }
}
