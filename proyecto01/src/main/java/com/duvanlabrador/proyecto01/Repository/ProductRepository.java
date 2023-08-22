package com.duvanlabrador.proyecto01.Repository;

import com.duvanlabrador.proyecto01.Model.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {

    public ProductEntity findByProductName(String productName);
    @Query(value = "SELECT * FROM products p WHERE p.product_quantity>5", nativeQuery = true)
    public List<ProductEntity> listProductGrater();
    @Query(value = "SELECT * FROM products p WHERE p.product_price>100", nativeQuery = true)
    public List<ProductEntity> listProductPrice();
    @Transactional
    @Modifying
    @Query(value = "UPDATE products p SET product_state = true WHERE p.id_product=:id",nativeQuery = true)
    public void enableProduct(@Param("id") Integer id);
    @Transactional
    @Modifying
    @Query(value = "UPDATE products p SET product_state = false WHERE p.id_product = :id", nativeQuery = true)
    public void disableProduct(@Param("id") Integer id);
}
