package com.example.Ecommerce.Controller;

import com.example.Ecommerce.Model.ProductReviewDto;
import com.example.Ecommerce.Model.ProductReviews;
import com.example.Ecommerce.Repository.Reviewrepo;
import com.example.Ecommerce.Service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products/addReviews")
public class ReviewController {


    @Autowired
    private ProductService productService ;

    @PostMapping()
    public ResponseEntity<?> addreviews (@RequestBody  @Valid ProductReviewDto productReviewDto){
        productService.addreview(productReviewDto) ;
        return ResponseEntity.status(HttpStatus.CREATED).body("Review Created") ;
    }
}
