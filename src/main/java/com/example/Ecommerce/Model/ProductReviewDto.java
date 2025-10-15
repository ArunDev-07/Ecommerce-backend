package com.example.Ecommerce.Model;


import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@Data
@NoArgsConstructor
public class ProductReviewDto {
    @NotNull(message = "ProductId is not defined")
     private Long productId ;
    @NotBlank(message = "Comment is not defined")
     private String comment ;
    @NotNull(message = "ratings is not defined")
     private Double ratings ;
}
