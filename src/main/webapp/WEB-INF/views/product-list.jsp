<%--
  Created by IntelliJ IDEA.
  User: pplvu
  Date: 12/14/2024
  Time: 7:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Product List</title>
</head>
<body>
<h1>Product List</h1>
<a href="/products?action=create">Add New Product</a>
<table border="1">
    <thead>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Price</th>
        <th>Quantity</th>
        <th>Color</th>
        <th>Category</th>
        <th>Actions</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="product" items="${products}">
        <tr>
            <td>${product.id}</td>
            <td>${product.name}</td>
            <td>${product.price}</td>
            <td>${product.quantity}</td>
            <td>${product.color}</td>
            <td>${product.category}</td>
            <td>
                <a href="/products?action=delete&id=${product.id}">Delete</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
