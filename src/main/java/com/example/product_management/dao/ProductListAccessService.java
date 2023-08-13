package com.example.product_management.dao;


import com.example.product_management.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ProductListAccessService implements ProductDao {

    private static List<Product> products;


    static {

        products = new ArrayList<>();


    }



    @Override
    public Product addProduct(Product product) {
         products.add(product);
         return product;
    }

    @Override
    public boolean existsProductWithCode(String code) {
        return products.stream()
                .anyMatch(p->p.getCode().equals(code));
    }



    @Override
    public List<Product> getAllProduct() {
        return products;
    }


    @Override
    public void deleteProductByCode(String code) {
        products.stream()
                .filter(customer -> customer.getCode().equals(code))
                .findFirst()
                .ifPresent(products::remove);
    }

    @Override
    public void updateProduct(Product product) {
        products.add(product);
    }

    @Override
    public Optional<Product> selectProductCode(String code) {
        return products.stream()
                .filter(product -> product.getCode().equals(code))
                .findFirst();
    }
}
