package com.devsuperior.dsdevilver.order.api.model;

import com.devsuperior.dsdevilver.comum.product.model.Product;
import com.devsuperior.dsdevilver.order.Order;
import com.devsuperior.dsdevilver.order.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.time.Instant;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class OrderRequest {
    @NotBlank
    private String address;
    @NotBlank
    private Double latitude;
    @NotBlank
    private Double longitude;
    @NotBlank
    private Instant moment;
    @NotBlank
    private OrderStatus status;
    @NotBlank
    private List<Product> productsId;

    public Order toModel(){
        return Order.builder()
                .address(this.address)
                .latitude(this.latitude)
                .longitude(this.longitude)
                .moment(Instant.now())
                .status(OrderStatus.PENDING)
                .build();
    }
}
