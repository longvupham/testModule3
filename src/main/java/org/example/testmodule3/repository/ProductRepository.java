package org.example.testmodule3.repository;

import org.example.testmodule3.model.Product;
import org.example.testmodule3.model.Category;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository {

    private static final String URL = "jdbc:mysql://localhost:3306/product_management";
    private static final String USER = "root";
    private static final String PASSWORD = "123456";

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Failed to load MySQL driver", e);
        }
    }

    public List<Product> findAll() {
        List<Product> products = new ArrayList<>();
        String query = "SELECT * FROM products";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                Product product = new Product(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("price"),
                        rs.getInt("quantity"),
                        rs.getString("color"),
                        rs.getString("description"),
                        rs.getString("category")
                );
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    public void save(Product product) {
        String query = "INSERT INTO products (name, price, quantity, color, description, category) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, product.getName());
            pstmt.setDouble(2, product.getPrice());
            pstmt.setInt(3, product.getQuantity());
            pstmt.setString(4, product.getColor());
            pstmt.setString(5, product.getDescription());
            pstmt.setString(6, product.getCategory());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteById(int id) {
        String query = "DELETE FROM products WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, id);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Category> findAllCategories() {
        List<Category> categories = new ArrayList<>();
        String query = "SELECT * FROM categories";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                Category category = new Category(
                        rs.getInt("id"),
                        rs.getString("name")
                );
                categories.add(category);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categories;
    }
}