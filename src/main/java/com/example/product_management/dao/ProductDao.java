package com.example.product_management.dao;

import com.example.product_management.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductDao {

    public Product addProduct(Product product);

    boolean existsProductWithCode(String code);

    List<Product> getAllProduct();

    void deleteProductByCode(String code);

    void updateProduct(Product product);

    Optional<Product> selectProductCode(String code);

}
