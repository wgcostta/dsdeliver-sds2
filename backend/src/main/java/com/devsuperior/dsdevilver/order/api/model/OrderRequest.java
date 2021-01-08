package com.devsuperior.dsdevilver.order.api.model;

import com.devsuperior.dsdevilver.order.Order;
import com.devsuperior.dsdevilver.order.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.time.Instant;
import java.util.HashSet;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class OrderRequest {
    @NotNull
    private String address;
    @NotNull
    private Double latitude;
    @NotNull
    private Double longitude;
    @NotNull
    private List<OrderProductRequest> productsId;

    public Order toModel(){
        return Order.builder()
                .address(this.address)
                .latitude(this.latitude)
                .longitude(this.longitude)
                .moment(Instant.now())
                .status(OrderStatus.PENDING)
                .products(new HashSet<>())
                .build();
    }
}
