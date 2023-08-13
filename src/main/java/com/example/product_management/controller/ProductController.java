package com.example.product_management.controller;


import com.example.product_management.dao.ProductRegistration;
import com.example.product_management.service.ProductService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
