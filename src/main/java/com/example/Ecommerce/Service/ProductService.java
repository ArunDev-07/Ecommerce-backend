package com.example.Ecommerce.Service;

import com.example.Ecommerce.Model.*;
import com.example.Ecommerce.Repository.ProductRepo;
import com.example.Ecommerce.Repository.Reviewrepo;
import com.example.Ecommerce.Spec.ProductSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {
    @Autowired
    private ProductRepo productRepo ;

    @Autowired
    private Reviewrepo reviewrepo ;


    public Map<String , Object> show(int page , int size) {
        Pageable pageable = PageRequest.of(page, size) ;
        Page<Product> products =  productRepo.findAll(pageable) ;
        List<ProductDtos> productDtos = products.stream().map( this::convertToDto).collect(Collectors.toList()) ;
        Map<String ,  Object> response = new HashMap<>() ;
        response.put("Products" , productDtos) ;
        response.put("TotalProducts" , products.getTotalElements()) ;
        return response ;
    }

    public ProductDtos convertToDto(Product product) {
        ProductDtos productDtos = new ProductDtos();
        productDtos.setId(product.getId());
        productDtos.setName(product.getName());
        productDtos.setPrice(product.getPrice());
        productDtos.setDescription(product.getDescription());
        productDtos.setCategory(product.getCategory());
        productDtos.setRatings(product.getRatings());
        productDtos.setSeller(product.getSeller());
        productDtos.setStock(product.getStock());
        productDtos.setNumOfReviews(product.getNumOfReviews());


      List<ProductReviewDto> productReviewDtos = product.getReviews().stream().map(reviews-> {
                   ProductReviewDto reviewdto = new ProductReviewDto() ;
                   reviewdto.setProductId(reviews.getId());
           reviewdto.setRatings(reviews.getRatings());
           reviewdto.setComment(reviews.getComment());

           return reviewdto;
       }).collect(Collectors.toList()) ;

        productDtos.setReviews(productReviewDtos);

        List<ProductImageDto> productImageDtos = product.getImages().stream().map(images -> {
            ProductImageDto imageDto = new ProductImageDto(images.getPublicId()) ;

            return imageDto ;
        }).collect(Collectors.toList()) ;

        productDtos.setImages(productImageDtos);

        return productDtos;
    }



    public Product getById(Long id) {
        return  productRepo.findById(id).orElseThrow(()-> new RuntimeException("Not Found")) ;
    }

    public  List<Product> filterProducts(String category , Double minPrice , Double maxPrice , String keyword , Double ratings){
        Specification<Product> productSpecification = Specification.where(ProductSpecification.hasCategory(category))
                .and(ProductSpecification.PriceBetween(minPrice , maxPrice))
                .and(ProductSpecification.hasNameOrDesc(keyword))
                .and(ProductSpecification.hasRatings(ratings));


        return productRepo.findAll(productSpecification) ;
    }

    public void addreview(ProductReviewDto productReviewDto) {
      Product product =  productRepo.findById(productReviewDto.getProductId()).orElseThrow(() -> new RuntimeException("Product not found"));
        ProductReviews productReviews = new ProductReviews() ;
        productReviews.setComment(productReviewDto.getComment());
        productReviews.setRatings(productReviewDto.getRatings());
        productReviews.setProduct(product);
        reviewrepo.save(productReviews) ;

    }
}
