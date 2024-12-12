
package org.example.testmodule3.service;

import org.example.testmodule3.model.Category;
import org.example.testmodule3.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> getAllProducts();
    void addProduct(Product product);
    List<Category> getAllCategories();
    void deleteProduct(int productId);
}
