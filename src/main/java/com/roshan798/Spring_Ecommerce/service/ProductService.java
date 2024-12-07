package com.roshan798.Spring_Ecommerce.service;

import com.roshan798.Spring_Ecommerce.model.Product;
import com.roshan798.Spring_Ecommerce.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepo repo;

    public List<Product> getAllProducts() {
        return repo.findAll();
    }

    public Product getProduct(int id) {
        return repo.findById(id).orElse(null);
    }

    public Product addProduct(Product product) throws IOException {
        System.out.println(product);
        return repo.save(product);
    }
}
