package com.duvanlabrador.proyecto01.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "products")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_product")
    private Integer idProduct;
    @Column(name = "product_name")
    private String productName;
    @Column(name = "product_quantity")
    private Integer productQuantity;
    @Column(name = "product_price")
    private BigDecimal productPrice;
    @Column(name = "product_state")
    private Boolean productState;

}
