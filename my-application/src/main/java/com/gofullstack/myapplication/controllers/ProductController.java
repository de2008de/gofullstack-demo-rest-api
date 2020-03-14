package com.gofullstack.myapplication.controllers;

import java.util.HashMap;
import java.util.Map;

import com.gofullstack.myapplication.entities.Product;
import com.gofullstack.myapplication.services.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping(value = "/api/v1/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping(value = "/{id}")
    public Map<String, Object> getProductById(@PathVariable int id) {

        Product product = productService.getProductById(id);

        Map<String, Object> result = new HashMap<>();

        result.put("data", product);

        return result;
    }

    @PostMapping
    public Map<String, Object> addProduct(@RequestBody Map<String, String> parameters) {

        productService.addNewProduct(parameters);

        Map<String, Object> result = new HashMap<>();

        result.put("message", "success");

        return result;
    }
}
