package org.example.testmodule3.controller;

import org.example.testmodule3.model.Product;
import org.example.testmodule3.model.Category;
import org.example.testmodule3.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "productController", value = "/products")
public class ProductController extends HttpServlet {

    private final ProductService productService = new ProductService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreateForm(req, resp);
                break;
            case "delete":
                deleteProduct(req, resp);
                break;
            default:
                showProductList(req, resp);
                break;
        }
    }

    private void showProductList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> products = productService.getAllProducts();
        req.setAttribute("products", products);
        req.getRequestDispatcher("/WEB-INF/views/product-list.jsp").forward(req, resp);
    }

    private void showCreateForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Category> categories = productService.getAllCategories();
        req.setAttribute("categories", categories);
        req.getRequestDispatcher("/WEB-INF/views/product-form.jsp").forward(req, resp);
    }

    private void deleteProduct(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        productService.deleteProduct(id);
        resp.sendRedirect("/products");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createProduct(req, resp);
                break;
        }
    }

    private void createProduct(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String name = req.getParameter("name");
        double price = Double.parseDouble(req.getParameter("price"));
        int quantity = Integer.parseInt(req.getParameter("quantity"));
        String color = req.getParameter("color");
        String description = req.getParameter("description");
        String category = req.getParameter("category");

        Product product = new Product(0, name, price, quantity, color, description, category);
        productService.addProduct(product);
        resp.sendRedirect("/products");
    }
}