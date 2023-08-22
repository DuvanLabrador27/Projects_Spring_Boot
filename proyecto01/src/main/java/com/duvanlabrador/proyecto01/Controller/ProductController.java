package com.duvanlabrador.proyecto01.Controller;

import com.duvanlabrador.proyecto01.Model.ProductEntity;
import com.duvanlabrador.proyecto01.Service.IProductService;
import com.duvanlabrador.proyecto01.dto.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ProductController {

    private final IProductService productService;
    @Autowired
    public ProductController(IProductService productService){
        this.productService = productService;
    }

    @GetMapping("/products")
    public List<ProductDTO> getAllProduct(){

            return this.productService.getAllProducts();

    }
    @GetMapping("/products/{id}")
    public ResponseEntity<ProductDTO> findProductById(@PathVariable Integer id){
        try {
            ProductDTO productDTO = productService.findProductById(id);
            return new ResponseEntity<ProductDTO>(productDTO,HttpStatus.ACCEPTED);
        }catch (Exception e){
            return new ResponseEntity<ProductDTO>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/productsByName/{productName}")
    public ResponseEntity<ProductDTO> findProductByName(@PathVariable String productName){
        try {
            ProductDTO productDTO = productService.findProductByName(productName);
            return new ResponseEntity<>(productDTO,HttpStatus.ACCEPTED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/productsThan")
    public List<ProductDTO> listProductGreaterThan(){

        return productService.listProductGraterThan();
    }

    @GetMapping("/productPrice")
    public List<ProductDTO> listProductPriceGreaterThan(){
        return productService.listProductPrice();
    }

    @PostMapping("/products")
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO product){
        try {
            ProductDTO productDTO = productService.createProduct(product);
            return new ResponseEntity<ProductDTO>(productDTO, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<ProductDTO>(HttpStatus.CONFLICT);
        }
    }

    @PutMapping("/products/{id}")
    public ResponseEntity<ProductDTO> updateProduct(@PathVariable Integer id, @RequestBody ProductDTO productDTO){
        try {
            ProductDTO product = this.productService.updateProduct(id, productDTO);
            if(product!=null){
                return new ResponseEntity<>(product, HttpStatus.ACCEPTED);
            }else{
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PutMapping("productsEnable/{id}")
    public ResponseEntity<String> enableProduct(@PathVariable Integer id) {
        try {
            ProductDTO product = productService.findProductById(id);
            if (product == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found");
            }

            productService.enableProduct(id);
            return ResponseEntity.ok("The product has been enabled correctly");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Could not enable the product");
        }
    }

    @PutMapping("productsDisable/{id}")
    public ResponseEntity<String> disableProduct(@PathVariable Integer id){
        try {
            ProductDTO product = productService.findProductById(id);
            if (product == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found!!");
            }

            productService.disableProduct(id);
            return ResponseEntity.ok("The product has been disabled correctly");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Could not disable the product");
        }
    }


    @DeleteMapping("/products/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Integer id){
        try {
            productService.deleteProduct(id);
            return new ResponseEntity<>("The product has been delete correctly",HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

}
