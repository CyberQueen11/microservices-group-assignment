package se.yrgo.service;

import se.yrgo.domain.Product;

import java.util.List;


public interface ProductService {
    List<Product> getAllProducts();

    public Product createProduct(Product product);

    List<Product> createProducts(List<Product> products);

    boolean updatePurchase(Product product);

    boolean deletePurchase(Product product);
}