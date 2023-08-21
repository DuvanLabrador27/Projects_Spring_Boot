package com.duvanlabrador.proyecto01.Service;

import com.duvanlabrador.proyecto01.Model.ProductEntity;
import com.duvanlabrador.proyecto01.dto.ProductDTO;

import java.util.List;

public interface IProductService {
    public List<ProductDTO> getAllProducts();
    public ProductDTO findProductById(Integer id);
    public ProductDTO findProductByName(String productName);
    public ProductDTO createProduct(ProductDTO product);
    public ProductDTO updateProduct(Integer id, ProductDTO product);
    public void deleteProduct(Integer id);
    public List<ProductDTO>  listProductGraterThan();
}
