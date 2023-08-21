package com.duvanlabrador.proyecto01.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    private Integer idProduct;
    private String productName;
    private Integer productQuantity;
    private Double productPrice;
}
