package com.devsuperior.dsdevilver.comum.product.api.service;

import com.devsuperior.dsdevilver.comum.product.api.model.ProductNotEncontredException;
import com.devsuperior.dsdevilver.comum.product.api.model.ProductResponse;
import com.devsuperior.dsdevilver.comum.product.model.Product;
import com.devsuperior.dsdevilver.comum.product.model.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Transactional(readOnly = true)
    public List<ProductResponse> findAll(){
        return ProductResponse.fromModels(productRepository.findAllByOrderByNameAsc());
    }

    @Transactional(readOnly = true)
    public ProductResponse findById(Long id){
        Product produto = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotEncontredException());
        return ProductResponse.fromModel(produto);
    }




}
