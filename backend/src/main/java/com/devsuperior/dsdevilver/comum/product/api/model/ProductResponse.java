package com.devsuperior.dsdevilver.comum.product.api.model;

import com.devsuperior.dsdevilver.comum.product.model.Product;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private Double price;
    private String description;
    private String imageUri;

    public static ProductResponse fromModel(@NonNull Product produto){
        return ProductResponse.builder()
                .id(produto.getId())
                .name(produto.getName())
                .price(produto.getPrice())
                .description(produto.getDescription())
                .imageUri(produto.getImageUri())
                .build();
    }

    public static List<ProductResponse> fromModels(@NonNull Collection<Product> produtos){
        return produtos.stream().map(ProductResponse::fromModel).collect(Collectors.toList());
    }
}
