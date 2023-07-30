package com.product.productapi;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public Product save(Product product) {
        if(product == null || product.getName() == null) {
            throw new IllegalArgumentException("Product must not be null");
        }
        return productRepository.save(product);
    }

    public List<Product> findAll(){
      return  productRepository.findAll();
    }

    public Product findById(Long id){
        if(productRepository.findById(id).isEmpty()){
            throw new IllegalArgumentException("Product is not found");
        }
        return productRepository.findById(id).get();
    }

}
