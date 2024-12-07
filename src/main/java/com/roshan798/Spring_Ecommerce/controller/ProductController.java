package com.roshan798.Spring_Ecommerce.controller;

import com.roshan798.Spring_Ecommerce.model.Product;
import com.roshan798.Spring_Ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping("products/ping")
    public String ping() {
        return "Hello from product controller";
    }

    @RequestMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts() {
        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
    }

    @RequestMapping("product/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable int id) {
        Product p = productService.getProduct(id);
        if (p == null) {
            System.out.println("Product not found");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(p, HttpStatus.OK);
    }

    @PostMapping("/product")
    public ResponseEntity<?> addProduct(@RequestBody Product product) {
        System.out.println(product);
        try {
            Product p = productService.addProduct(product); // Assuming this saves the product
            return new ResponseEntity<>(p, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
