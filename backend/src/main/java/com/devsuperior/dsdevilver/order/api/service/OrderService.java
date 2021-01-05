package com.devsuperior.dsdevilver.order.api.service;

import com.devsuperior.dsdevilver.order.Order;
import com.devsuperior.dsdevilver.order.OrderRepository;
import com.devsuperior.dsdevilver.order.api.model.OrderNotEncontredException;
import com.devsuperior.dsdevilver.order.api.model.OrderResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Transactional(readOnly = true)
    public List<OrderResponse> findAll(){
        return OrderResponse.fromModels(orderRepository.findAll());
    }

    @Transactional(readOnly = true)
    public OrderResponse findById(Long id){
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new OrderNotEncontredException());
        return OrderResponse.fromModel(order);
    }




}
