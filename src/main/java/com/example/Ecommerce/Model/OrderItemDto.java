package com.example.Ecommerce.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderItemDto {
    private String name ;
    private Double price ;
    private String description ;
    private Integer quantity ;
    private String image ;

    private Long productId ;
}
