package com.gofullstack.myapplication.repositories;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import com.gofullstack.myapplication.entities.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class ProductRepositoryImpl implements ProductRepository {

    @Autowired
    private EntityManager entityManger;

    @Override
    public void addProduct(Product product) {
        entityManger.persist(product);
        entityManger.flush();
    }

    @Override
    public Product getProductById(int id) {
        return entityManger.find(Product.class, id);
    }

}
