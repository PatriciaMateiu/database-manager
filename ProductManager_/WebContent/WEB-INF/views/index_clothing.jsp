<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Clothing Manager Home</title>
</head>
<body>
<div align = "center">
		<h1>Clothing List</h1>
		<h3><a href="newc">New Clothing</a></h3>
		<table border="1" cellpadding="5">
			<tr>
				<th>No.</th>
				<th>Name</th>
				<th>Size</th>
				<th>Quantity</th>
				<th>Price</th>
				<th>Action</th>
			</tr>
			<c:forEach items="${clothingList}" var="clothing" varStatus="status">
				<tr>
					<td>${status.index + 1} </td>
					<td>${clothing.name }</td>
					<td>${clothing.size }</td>
					<td>${clothing.quantity }</td>
					<td>${clothing.price}</td>
					<td>
						<a href="edit2?id=${clothing.clothing_id}">Edit</a> 
						&nbsp;&nbsp;						
					
						<a href="delete2?id=${clothing.clothing_id}">Delete</a> 
					</td>
				</tr>
			</c:forEach>
		</table>
				<tr>
				<td colspan="2" align="left"><input type="submit" value="return to products"/></td>			
			</tr>	
		</div>
</body>
</html>