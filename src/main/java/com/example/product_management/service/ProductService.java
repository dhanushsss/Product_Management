package com.example.product_management.service;


import com.example.product_management.dao.ProductDao;
import com.example.product_management.dao.ProductRegistration;
import com.example.product_management.exception.DuplicateResourceException;
import com.example.product_management.model.Product;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final ProductDao productDao;


    public ProductService(ProductDao productDao) {
        this.productDao = productDao;
    }

    public Product addProduct(ProductRegistration productRegistration){

        if (productDao.existsProductWithCode(productRegistration.code())){
            throw  new DuplicateResourceException("Code [%s] already Take".formatted(productRegistration.code()));
        }
            Product product = new Product(
                    productRegistration.code() ,
                    productRegistration.name(),
                    productRegistration.category()
            );
            return productDao.addProduct(product);
    }

}
