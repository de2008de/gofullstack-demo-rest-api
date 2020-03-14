package com.gofullstack.myapplication.repositories;

import com.gofullstack.myapplication.entities.Product;

public interface ProductRepository {
    public Product getProductById(int id);
    public void addProduct(Product product);
}
