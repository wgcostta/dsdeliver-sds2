package com.devsuperior.dsdevilver.order.api.model;

import com.devsuperior.dsdevilver.comum.product.api.model.ProductResponse;
import com.devsuperior.dsdevilver.order.Order;
import com.devsuperior.dsdevilver.order.OrderStatus;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;



@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String address;
    private Double latitude;
    private Double longitude;
    private Instant moment;
    private OrderStatus status;
    private List<ProductResponse> products;

    public static OrderResponse fromModel(@NonNull Order order){
        return
             OrderResponse.builder()
                .id(order.getId())
                .address(order.getAddress())
                .latitude(order.getLatitude())
                .longitude(order.getLongitude())
                .status(order.getStatus())
                     .products(ProductResponse.fromModels(order.getProducts()))
                     .build();
    }

    public static List<OrderResponse> fromModels(@NonNull Collection<Order> orders){
        return orders.stream().map(OrderResponse::fromModel).collect(Collectors.toList());
    }
}
