package com.duvanlabrador.proyecto01.Repository;

import com.duvanlabrador.proyecto01.Model.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {

    public ProductEntity findByProductName(String productName);
    @Query(value = "SELECT * FROM products p WHERE p.product_quantity>5", nativeQuery = true)
    public List<ProductEntity> listProductGrater();
}
