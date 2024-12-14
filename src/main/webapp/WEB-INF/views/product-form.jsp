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
    <title>Add Product</title>
</head>
<body>
<h1>Add Product</h1>
<form action="/products?action=create" method="post">
    <label for="name">Name:</label>
    <input type="text" id="name" name="name" required><br>

    <label for="price">Price:</label>
    <input type="number" id="price" name="price" required><br>

    <label for="quantity">Quantity:</label>
    <input type="number" id="quantity" name="quantity" required><br>

    <label for="color">Color:</label>
    <select id="color" name="color" required>
        <option value="Red">Red</option>
        <option value="Blue">Blue</option>
        <option value="Black">Black</option>
        <option value="White">White</option>
        <option value="Yellow">Yellow</option>
    </select><br>

    <label for="description">Description:</label>
    <textarea id="description" name="description"></textarea><br>

    <label for="category">Category:</label>
    <select id="category" name="category" required>
        <c:forEach var="category" items="${categories}">
            <option value="${category.name}">${category.name}</option>
        </c:forEach>
    </select><br>

    <button type="submit">Add Product</button>
</form>
</body>
</html>
