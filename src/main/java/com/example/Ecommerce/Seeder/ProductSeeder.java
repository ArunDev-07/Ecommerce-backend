package com.example.Ecommerce.Seeder;


import com.example.Ecommerce.Model.Product;
import com.example.Ecommerce.Repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class ProductSeeder implements CommandLineRunner {

    @Autowired
    private ProductRepo productRepo;

    @Override
    public void run(String... args) throws Exception {
        if (productRepo.count() == 0) {
            List<Product> demoProducts = new ArrayList<>(List.of(
                    // 🔹 Mobiles
                    new Product(null, "Apple iPhone 15 Pro", 150000.0, "Ultimate flagship iPhone", "Mobile", 4.8, "Amazon", 21, 0 , List.of("/images/laptop1.png")),
                    new Product(null, "Samsung Galaxy S24 Ultra", 140000.0, "High-end Android smartphone", "Mobile", 4.7, "Flipkart", 30, 0, List.of("/images/laptop2.png") ),
                    new Product(null, "OnePlus 12", 90000.0, "Powerful and fast performance phone", "Mobile", 4.6, "Amazon", 25, 0 , List.of("/images/laptop1.png")),
                    new Product(null, "Google Pixel 8 Pro", 110000.0, "Clean Android experience with great camera", "Mobile", 4.9, "Croma", 15, 0, List.of("/images/laptop1.png")),
                    new Product(null, "Redmi Note 13 Pro", 25000.0, "Budget friendly powerful device", "Mobile", 4.4, "Mi Store", 50, 0,List.of("/images/laptop1.png")),
                    new Product(null, "Realme GT 6", 40000.0, "Stylish and fast charging phone", "Mobile", 4.3, "Amazon", 40, 0, List.of("/images/laptop1.png")),
                    new Product(null, "Vivo X100 Pro", 120000.0, "Professional camera smartphone", "Mobile", 4.5, "Flipkart", 20, 0 , List.of("/images/laptop1.png")),
                    new Product(null, "Oppo Reno 11", 45000.0, "Great design and performance", "Mobile", 4.2, "Croma", 35, 0,List.of("/images/laptop1.png")),
                    new Product(null, "Nothing Phone 2", 55000.0, "Unique transparent design", "Mobile", 4.6, "Amazon", 18, 0,List.of("/images/laptop1.png")),
                    new Product(null, "iQOO 12", 52000.0, "Gaming beast with Snapdragon 8 Gen 3", "Mobile", 4.7, "Amazon", 22, 0,List.of("/images/laptop1.png")),

                    // 💻 Laptops
                    new Product(null, "MacBook Air M3", 145000.0, "Lightweight laptop with M3 chip", "Laptop", 4.8, "Apple Store", 15, 0,List.of("/images/laptop1.png")),
                    new Product(null, "Dell XPS 15", 170000.0, "Premium Windows ultrabook with OLED display", "Laptop", 4.6, "Amazon", 10, 0,List.of("/images/laptop1.png")),
                    new Product(null, "ASUS ROG Strix G16", 130000.0, "Powerful gaming laptop with RTX 4070", "Laptop", 4.7, "Flipkart", 12, 0, List.of("/images/laptop1.png")),
                    new Product(null, "HP Pavilion 14", 70000.0, "Compact laptop for students and professionals", "Laptop", 4.4, "Croma", 20, 0, List.of("/images/laptop1.png")),
                    new Product(null, "Lenovo IdeaPad Slim 5", 65000.0, "Slim, stylish, and performance-driven", "Laptop", 4.5, "Amazon", 25, 0 ,List.of("/images/laptop1.png"))


            ));


            productRepo.saveAll(demoProducts) ;
         System.out.println("Products added successfully") ;
        }
        else{
            System.out.println("Products is not found") ;
        }

    }
}
