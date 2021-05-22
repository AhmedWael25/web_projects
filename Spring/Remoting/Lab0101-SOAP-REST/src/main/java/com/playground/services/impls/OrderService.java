package com.playground.services.impls;

import com.playground.domains.Order;
import com.playground.repositories.OrderRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("orderService")
public class OrderService {

    OrderRepositoryImpl orderRepository;

    @Autowired
    public OrderService(OrderRepositoryImpl orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> getAllOrders(){
        return orderRepository.getAllOrders();
    }
    public List<Order> getOrderByCustomerId(int custId){
        return orderRepository.getOrdersByCustomerId(custId);
    }

}
