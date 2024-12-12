
package org.example.testmodule3.repository;

import org.example.testmodule3.model.Category;
import org.example.testmodule3.model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> getAllProducts();
    void addProduct(Product product);
    List<Category> getAllCategories();
    void deleteProduct(int productId);
}
