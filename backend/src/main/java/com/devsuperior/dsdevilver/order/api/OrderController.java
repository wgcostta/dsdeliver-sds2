package com.devsuperior.dsdevilver.order.api;

import com.devsuperior.dsdevilver.order.api.model.OrderRequest;
import com.devsuperior.dsdevilver.order.api.model.OrderResponse;
import com.devsuperior.dsdevilver.order.api.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
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

    @PostMapping
    public ResponseEntity<OrderResponse> salvar(@RequestBody @Valid OrderRequest orderRequest){
        OrderResponse orderResponse = orderService.save(orderRequest);

        return ResponseEntity.created(ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/")
                .path(orderResponse.getId().toString()).build().toUri())
                .body(orderResponse);
    }

    @PutMapping("/{id}/delivered")
    public ResponseEntity<OrderResponse> atualizarStatus(@PathVariable Long id){
        return  ResponseEntity
                .ok()
                .body(orderService.setDelivered(id)
                );
    }

}
