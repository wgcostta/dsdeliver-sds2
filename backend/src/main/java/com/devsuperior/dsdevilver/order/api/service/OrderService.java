package com.devsuperior.dsdevilver.order.api.service;

import com.devsuperior.dsdevilver.comum.product.model.Product;
import com.devsuperior.dsdevilver.comum.product.model.ProductRepository;
import com.devsuperior.dsdevilver.order.Order;
import com.devsuperior.dsdevilver.order.OrderRepository;
import com.devsuperior.dsdevilver.order.OrderStatus;
import com.devsuperior.dsdevilver.order.api.model.OrderNaoEstaPendenteException;
import com.devsuperior.dsdevilver.order.api.model.OrderNotEncontredException;
import com.devsuperior.dsdevilver.order.api.model.OrderResponse;
import com.devsuperior.dsdevilver.order.api.model.OrderRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;
    ProductRepository productRepository;

    @Transactional(readOnly = true)
    public List<OrderResponse> findAll(){
        return OrderResponse.fromModels(orderRepository.findOrdersWithProducts());
    }

    @Transactional(readOnly = true)
    public OrderResponse findById(Long id){
        Order order = getOrder(id);
        return OrderResponse.fromModel(order);
    }

    @Transactional
    public OrderResponse save(OrderRequest request){
        Order order = request.toModel();
        for(Product productRequest : request.getProductsId()){
            Product product = productRepository.getOne(productRequest.getId());
            order.getProducts().add(product);
        }
        order = orderRepository.save(order);
        return OrderResponse.fromModel(order);
    }

    @Transactional
    public OrderResponse setDelivered(Long id){
        Order order = getOrder(id);
        if(order.getStatus() != OrderStatus.PENDING){
            throw new OrderNaoEstaPendenteException();
        }
        order.setStatus(OrderStatus.DELIVERED);
        order = orderRepository.save(order);
        return OrderResponse.fromModel(order);
    }

    private Order getOrder(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new OrderNotEncontredException());
    }


}
