package com.example.Ecommerce.Controller;

import com.example.Ecommerce.Model.Product;
import com.example.Ecommerce.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/products")
public class ProductController {

    @Autowired
    private ProductService productService ;

    @GetMapping()
    public Map<String , Object> getproducts(@RequestParam(defaultValue = "0") int page , @RequestParam(defaultValue = "31") int size){

        return  productService.show(page, size) ;

    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable("id") Long id) {
       return  productService.getById(id) ;
    }

    @GetMapping("/search")
    public List<Product> getByCategory(@RequestParam(required = false) String category , @RequestParam(required = false) Double minPrice ,  @RequestParam(required = false) Double maxPrice ,@RequestParam(required = false) String keyword ,@RequestParam(required = false) Double ratings){
        return productService.filterProducts(category ,minPrice , maxPrice , keyword , ratings) ;
    }

}
