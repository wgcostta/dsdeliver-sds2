package com.devsuperior.dsdevilver.order;

import com.devsuperior.dsdevilver.comum.product.model.Product;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@AllArgsConstructor
@Builder
@Table(name = "tb_order")
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String address;
    private Double latitude;
    private Double longitude;
    private Instant moment;
    @Setter
    private OrderStatus status;

    @Setter
    @ManyToMany
    @JoinTable(name = "tb_order_product",
        joinColumns = @JoinColumn(name = "order_id"),
        inverseJoinColumns = @JoinColumn(name = "product_id"))
    private Set<Product> products = new HashSet<>();

    public Double getTotal(){
        double sum = 0.0;
        for(Product product : products){
            sum += product.getPrice();
        }
        return sum;
    }

}
