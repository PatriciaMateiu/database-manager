<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Products Manager Home</title>
</head>
<body>
<div align = "center">
		<h1>Product Manager List</h1>
		
		<h3><a href="newp">New Product</a></h3>
		<table border="1" cellpadding="5">
			<tr>
				<th>No.</th>
				<th>Name</th>
				<th>Price</th>
				<th>Quantity</th>
				<th>Volume</th>
				<th>Action</th>
			</tr>
			<c:forEach items="${productList}" var="product" varStatus="status">
				<tr>
					<td>${status.index + 1} </td>
					<td>${product.name }</td>
					<td>${product.price }</td>
					<td>${product.quantity }</td>
					<td>${product.volume }</td>
					<td>
						<a href="edit1?id=${product.id}">Edit</a> 
						&nbsp;&nbsp;						
					
						<a href="delete1?id=${product.id}">Delete</a> 
					</td>
				</tr>
			</c:forEach>
		</table>	
					<tr>
				<td colspan="2" align="left"><input type="submit" value="return"/></td>			
			</tr>
		</div>
</body>
</html>