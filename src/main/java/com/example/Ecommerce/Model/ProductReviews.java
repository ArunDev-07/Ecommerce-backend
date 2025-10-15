package com.example.Ecommerce.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ProductReviews {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    @Min(value = 1)
    @Max(value = 5)
    private Double ratings ;
    private String comment ;

    @ManyToOne()
    @JoinColumn(name = "product_id")

    private Product product ;
}
