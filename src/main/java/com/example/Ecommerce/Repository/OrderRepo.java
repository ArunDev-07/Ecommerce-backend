package com.example.Ecommerce.Repository;

import com.example.Ecommerce.Model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepo extends JpaRepository<Orders , Long> {

    Orders findByOrderNo (String orderNo) ;
}
