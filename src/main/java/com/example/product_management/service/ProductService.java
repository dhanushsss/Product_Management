package com.example.product_management.service;

import com.example.product_management.dao.ProductDao;
import com.example.product_management.dao.ProductRegistration;
import com.example.product_management.exception.DuplicateResourceException;
import com.example.product_management.exception.ResourceNotFoundException;
import com.example.product_management.model.Product;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductService {

    private final ProductDao productDao;


    public ProductService(ProductDao productDao) {
        this.productDao = productDao;
    }

    public Product addProduct(ProductRegistration productRegistration){

        if (productDao.existsProductWithCode(productRegistration.code())){
            throw  new DuplicateResourceException("Code already Take");
        }
            Product product = new Product(
                    productRegistration.code() ,
                    productRegistration.name(),
                    productRegistration.category()
            );
            return productDao.addProduct(product);
    }

    public List<Product> getAllProduct(){
        return productDao.getAllProduct();
    }

    public void deleteProductByCode(String code){
        if (!productDao.existsProductWithCode(code)){
            throw new ResourceNotFoundException("Product code doesn't exists");
        }
        productDao.deleteProductByCode(code);
    }

    public Product getProduct(String code){
        return productDao.selectProductCode(code)
                .orElseThrow(
                        () -> new ResourceNotFoundException("product with code [%s] is not found".formatted(code))
                );
    }


    public void updateProduct(String code, ProductRegistration productRegistration){
        Product product = getProduct(code);
        boolean changes = false;
        if (productRegistration.name() != null && !productRegistration.name().equals(product.getName())){
            product.setName(productRegistration.name());
            changes = true;
        }
        if (productRegistration.category() != null && !productRegistration.category().equals(product.getCategory())){
            product.setCategory(productRegistration.category());
            changes= true;
        }
        productDao.updateProduct(product);
    }

    public Product getProductByCode(String code){
        return productDao.selectProductCode(code)
                .orElseThrow(
                        ()-> new ResourceNotFoundException("product with code is not found")
                );
    }
}