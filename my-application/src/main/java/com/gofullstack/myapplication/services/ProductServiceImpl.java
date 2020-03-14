package com.gofullstack.myapplication.services;

import java.util.Map;

import com.gofullstack.myapplication.entities.Product;
import com.gofullstack.myapplication.repositories.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void addNewProduct(Map<String, String> parameters) {

        Product product = new Product();

        double price = Double.parseDouble(parameters.get("price"));
        int quantity = Integer.parseInt(parameters.get("quantity"));

        if (price < 0 || quantity < 0) {
            return;
        }

        product.setName(parameters.get("name"));
        product.setPrice(price);
        product.setQuantity(quantity);

        productRepository.addProduct(product);

    }

    @Override
    public Product getProductById(int id) {

        if (id <= 0) {
            return null;
        }

        return productRepository.getProductById(id);
    }
    
}
