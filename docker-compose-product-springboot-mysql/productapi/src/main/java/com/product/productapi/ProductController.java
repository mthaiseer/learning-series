package com.product.productapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/api/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product){
        productService.save(product);
        return ResponseEntity.ok(product);
    }

    @GetMapping
    public ResponseEntity<List<Product>> getProducts( @RequestParam(name = "id", required = false) Long id){

        if(id != null){
            try{
                return ResponseEntity.ok(List.of(productService.findById(id)));
            }catch(IllegalArgumentException e){
                return ResponseEntity.notFound().build();
            }

        }
        return ResponseEntity.ok(productService.findAll());
    }
}
