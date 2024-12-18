package se.yrgo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.yrgo.data.ProductRepository;
import se.yrgo.domain.Product;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> createProducts(List<Product> products) {
        return productRepository.saveAll(products);
    }

    @Override
    public boolean updatePurchase(Product purchase) {
        if (productRepository.existsById(purchase.getId())) {
            productRepository.save(purchase);
            return true;
        }
        return false;
    }

    @Override
    public boolean deletePurchase(Product purchase) {
        if (productRepository.existsById(purchase.getId())) {
            productRepository.deleteById(purchase.getId());
            return true;
        }
        return false;
    }

}