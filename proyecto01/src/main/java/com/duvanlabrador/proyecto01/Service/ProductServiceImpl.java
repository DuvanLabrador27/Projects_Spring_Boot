package com.duvanlabrador.proyecto01.Service;

import com.duvanlabrador.proyecto01.Model.ProductEntity;
import com.duvanlabrador.proyecto01.Repository.ProductRepository;
import com.duvanlabrador.proyecto01.dto.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements IProductService{

    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @Override
    public List<ProductDTO> getAllProducts() {
        List<ProductEntity> productEntity = productRepository.findAll();
        return productEntity.stream().map(product -> mapToDTO(product)).collect(Collectors.toList());
    }

    @Override
    public ProductDTO findProductById(Integer id) {
        ProductEntity productEntity = productRepository.findById(id).orElseThrow();
        return mapToDTO(productEntity);
    }

    @Override
    public ProductDTO findProductByName(String productName) {
        ProductEntity productEntity = productRepository.findByProductName(productName);
        return mapToDTO(productEntity);
    }

    @Override
    public ProductDTO createProduct(ProductDTO product) {
        ProductEntity productEntity = mapToEntity(product);
        ProductEntity newProduct = productRepository.save(productEntity);
        ProductDTO productDTO = mapToDTO(newProduct);
        return productDTO;
    }

    @Override
    public ProductDTO updateProduct(Integer id, ProductDTO product) {
       ProductEntity productEntity = productRepository.findById(id).orElseThrow();
       productEntity.setProductName(product.getProductName());
       productEntity.setProductPrice(product.getProductPrice());
       productEntity.setProductQuantity(product.getProductQuantity());
       productEntity.setProductState(product.getProductState());
       ProductEntity updateProduct = productRepository.save(productEntity);
       return mapToDTO(updateProduct);
    }

    @Override
    public void deleteProduct(Integer id) {
        ProductEntity productEntity = productRepository.findById(id).orElseThrow();
        this.productRepository.delete(productEntity);
    }

    @Override
    public List<ProductDTO> listProductGraterThan() {
        List<ProductEntity> productEntity = productRepository.listProductGrater();
        return productEntity.stream().map(product -> mapToDTO(product)).collect(Collectors.toList());
    }

    @Override
    public List<ProductDTO> listProductPrice() {
        List<ProductEntity> productEntity = productRepository.listProductPrice();
        return productEntity.stream().map(price -> mapToDTO(price)).collect(Collectors.toList());
    }

    public void enableProduct(Integer id) {
        productRepository.enableProduct(id);
    }

    public void disableProduct(Integer id) {
        productRepository.disableProduct(id);
    }

    public ProductDTO mapToDTO(ProductEntity productEntity){
        ProductDTO product = new ProductDTO();
        product.setIdProduct(productEntity.getIdProduct());
        product.setProductName(productEntity.getProductName());
        product.setProductPrice(productEntity.getProductPrice());
        product.setProductQuantity(productEntity.getProductQuantity());
        product.setProductState(productEntity.getProductState());
        return product;
    }

    public ProductEntity mapToEntity(ProductDTO productDTO){
        ProductEntity product = new ProductEntity();
        product.setProductName(productDTO.getProductName());
        product.setProductPrice(productDTO.getProductPrice());
        product.setProductQuantity(productDTO.getProductQuantity());
        product.setProductState(productDTO.getProductState());
        return product;
    }
}
