package com.example.product_management.controller;

import com.example.product_management.dao.ProductRegistration;
import com.example.product_management.model.Product;
import com.example.product_management.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/product")
public class ProductController {
    private final ProductService productService;
    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @PostMapping
    public void addProduct(@RequestBody ProductRegistration productRegistration){
        productService.addProduct(productRegistration);
    }
    @GetMapping
    public List<Product> getAllProduct(){
        return productService.getAllProduct();
    }
    @DeleteMapping("{code}")
    public void deleteProductByCode(@PathVariable("code") String code){
        productService.deleteProductByCode(code);
    }
    @PutMapping
    public void updateProduct(
            @PathVariable("code") String code ,
            @RequestBody ProductRegistration productRegistration
    ){
        productService.updateProduct(code,productRegistration);
    }

    @GetMapping("{code}")
    public Product getProductByCode(@PathVariable("code") String code){
        return productService.getProductByCode(code);
    }
}
