package com.example.product_management.dao;


import com.example.product_management.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

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


}
