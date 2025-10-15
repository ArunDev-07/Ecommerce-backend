package com.example.Ecommerce.Repository;

import com.example.Ecommerce.Model.ProductReviewDto;
import com.example.Ecommerce.Model.ProductReviews;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Reviewrepo extends JpaRepository<ProductReviews, Long> {

}
