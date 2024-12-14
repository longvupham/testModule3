package org.example.testmodule3.service;

import org.example.testmodule3.model.Category;
import org.example.testmodule3.model.Product;
import org.example.testmodule3.repository.ProductRepository;
import java.util.List;

public class ProductService {

    private final ProductRepository productRepository = new ProductRepository();

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public void addProduct(Product product) {
        productRepository.save(product);
    }

    public void deleteProduct(int id) {
        productRepository.deleteById(id);
    }

    public List<Category> getAllCategories() {
        return productRepository.findAllCategories();
    }
}