package com.example.Ecommerce.Spec;

import com.example.Ecommerce.Model.Product;
import org.springframework.data.jpa.domain.Specification;

public class ProductSpecification {
    public static Specification<Product> hasCategory (String category){
         return (root, query, cb) -> category == null ? null : cb.equal(root.get("category"), category);
    }
    public static Specification<Product> PriceBetween (Double minPrice , Double maxPrice) {
        if(minPrice == null && maxPrice == null) return null ;
        if(minPrice == null) {
            return (root, query, cb) -> cb.lessThanOrEqualTo(root.get("price") , maxPrice) ;

        }
        if(maxPrice == null) {
            return (root, query, cb) -> cb.greaterThanOrEqualTo(root.get("price") , minPrice) ;

        }
        return (root, query, cb) -> cb.between(root.get("price") , minPrice, maxPrice) ;

    }

    public static Specification<Product> hasNameOrDesc(String keyword){
          if(keyword == null || keyword.isEmpty()) return null ;
          return (root, query, cb) -> cb.or(cb.like(root.get("name") , "%" + keyword.toLowerCase() + "%"),
                  cb.like(root.get("description"),  "%" + keyword.toLowerCase() + "%")
          ) ;
    }

    public static  Specification<Product> hasRatings(Double ratings){
        if(ratings == null) return null ;
        return (root, query, cb) -> cb.greaterThanOrEqualTo(root.get("ratings") , ratings) ;
    }
}

