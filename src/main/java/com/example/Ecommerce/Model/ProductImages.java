package com.example.Ecommerce.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class ProductImages {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    private String publicId ;
    private String url ;

    @ManyToOne
    @JoinColumn(name = "product_id")
   private Product product ;
    public ProductImages(String url, Product product) {
        this.url = "/uploads" + url ;
        this.publicId = url ;
        this.product = product ;
    }
}
