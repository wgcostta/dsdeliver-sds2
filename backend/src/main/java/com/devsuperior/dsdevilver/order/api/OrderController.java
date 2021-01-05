package com.devsuperior.dsdevilver.order.api;

import com.devsuperior.dsdevilver.comum.product.api.model.ProductResponse;
import com.devsuperior.dsdevilver.order.OrderRepository;
import com.devsuperior.dsdevilver.order.api.model.OrderResponse;
import com.devsuperior.dsdevilver.order.api.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "orders")
public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping("/{id}")
    public ResponseEntity<OrderResponse> buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(orderService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<OrderResponse>> buscarTodos(){
        return  ResponseEntity
                .ok()
                .body(orderService.findAll()
                );
    }
}
