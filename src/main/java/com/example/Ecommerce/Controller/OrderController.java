package com.example.Ecommerce.Controller;

import com.example.Ecommerce.Model.CreateOrder;
import com.example.Ecommerce.Model.OrderCreated;
import com.example.Ecommerce.Model.Orders;
import com.example.Ecommerce.Service.OrderService;
import org.hibernate.query.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService ;

    @PostMapping()
    public ResponseEntity<?> createOrder(@RequestBody CreateOrder createOrder){
      OrderCreated orderCreated  =  orderService.createorder(createOrder);
       return ResponseEntity.ok().body(orderCreated) ;
    }

    @GetMapping("/{orderNo}")
    public Orders getorder (@PathVariable("orderNo") String orderNo){
       return  orderService.gettheorder(orderNo);
    }

}
