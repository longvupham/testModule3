
package org.example.testmodule3.service;

import org.example.testmodule3.model.Category;
import org.example.testmodule3.model.Product;
import org.example.testmodule3.repository.IProductRepository;
import org.example.testmodule3.repository.ProductRepository;

import java.util.Collections;
import java.util.List;

public class ProductService implements IProductService {
    private final IProductRepository productRepository = new ProductRepository();
    @Override
    public List<Product> getAllProducts() {
        return productRepository.getAllProducts();
    }

    @Override
    public void addProduct(Product product) {
        productRepository.addProduct(product);
    }

    @Override
    public List<Category> getAllCategories() {
        return productRepository.getAllCategories();
    }

    @Override
    public void deleteProduct(int productId) {
        productRepository.deleteProduct(productId);
    }
}
