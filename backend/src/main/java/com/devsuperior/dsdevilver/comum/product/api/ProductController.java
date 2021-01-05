package com.devsuperior.dsdevilver.comum.product.api;

import com.devsuperior.dsdevilver.comum.product.api.model.ProductResponse;
import com.devsuperior.dsdevilver.comum.product.api.service.ProductService;
import com.devsuperior.dsdevilver.comum.product.model.Product;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "products")
public class ProductController {

    @Autowired
    private ProductService productService;



    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(productService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<ProductResponse>> buscarTodos(){
        return  ResponseEntity
                .ok()
                .body(productService.findAll()
                );
    }

}
