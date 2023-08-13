package com.example.product_management.dao;

import com.example.product_management.model.Product;

public interface ProductDao {

    public Product addProduct(Product product);

    boolean existsProductWithCode(String code);


}
