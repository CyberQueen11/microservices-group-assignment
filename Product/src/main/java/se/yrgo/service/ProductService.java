package se.yrgo.service;

import se.yrgo.domain.Product;

import java.util.List;


public interface ProductService {
    List<Product> getAllProducts();

    public Product createProduct(Product product);
}