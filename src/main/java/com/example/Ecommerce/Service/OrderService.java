package com.example.Ecommerce.Service;

import com.example.Ecommerce.Model.*;
import com.example.Ecommerce.Repository.OrderRepo;
import com.example.Ecommerce.Repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class OrderService {
    @Autowired
    private ProductRepo productRepo ;

    @Autowired
    private OrderRepo orderRepo ;
    public OrderCreated createorder (CreateOrder OrderRequest){


       Orders order = new Orders() ;
       order.setStatus("PENDING");
       double totalOrderAmount  =  0 ;

       for (OrderItemDto item : OrderRequest.getOrderItems()){
           OrderItems orderItems = new OrderItems() ;
           orderItems.setName(item.getName());
           orderItems.setDescription(item.getDescription());
           orderItems.setImage(item.getImage());
           orderItems.setPrice(item.getPrice());
           orderItems.setQuantity(item.getQuantity());

           Product product = productRepo.findById(item.getProductId()).orElseThrow(()-> new RuntimeException("ProductId is not found")) ;
           orderItems.setProduct(product);

           order.getOrderItems().add(orderItems) ;
           totalOrderAmount += item.getPrice() * item.getQuantity() ;


       }
       order.setTotalOrderAmount(totalOrderAmount);
       double taxAmount = 10.20 ;
       order.setTaxAmount(taxAmount);
       order.setTotalAmount(taxAmount + totalOrderAmount);
       String refId = UUID.randomUUID().toString();
       order.setOrderNo(refId);
       orderRepo.save(order) ;
       return new OrderCreated(refId);


   }

    public Orders gettheorder(String orderNo) {
        return orderRepo.findByOrderNo(orderNo);
    }
}
