<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
</head>
<body>

<div align="center">
		<h1>Product List</h1>
		<table border="1" cellpadding="5">
			<tr>
				<th>ID</th>
				<th>NAME</th>
				<th>DESCRIPTION</th>
				<th>IN STOCK</th>
				<th>PRICE</th>
				<th>ACTION</th>
			</tr>
			<p:forEach items="${listp}" var="product" varStatus="status">
				<tr>
					<td>${product.id}</td>
					<td>${product.name}</td>
					<td>${product.description}</td>
					<td>${product.quantityInStock}</td>
					<td>${product.price}</td>
					<td><a href="?AddToChart?id=${product.id}">AddToChart</a>
				</td>
				</tr>
			</p:forEach>
		</table>
	</div>

</body>
</html>