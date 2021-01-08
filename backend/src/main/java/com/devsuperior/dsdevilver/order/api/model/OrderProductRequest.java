package com.devsuperior.dsdevilver.order.api.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class OrderProductRequest implements Serializable {

    private static final long serialVersionUID = 1L;
    @NotBlank
    private Long id;
}
