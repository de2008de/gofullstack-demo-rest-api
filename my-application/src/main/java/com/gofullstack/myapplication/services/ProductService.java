package com.gofullstack.myapplication.services;

import java.util.Map;

import com.gofullstack.myapplication.entities.Product;

public interface ProductService {
    public Product getProductById(int id);
    public void addNewProduct(Map<String, String> parameters);
}
