<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add new Clothing/Edit</title>
</head>
<body>
	<div align="center">
	<h1>Add new item of clothing/Edit</h1>
	<form:form action="save clothing" method="post" modelAttribute="clothing">
		<table cellpadding="5">
			<form:hidden path="clothing_id"/>
			<tr>
				<td>Name</td>
			</tr>
			<tr>	
				<td><form:input path="name" /></td>	
			</tr>
			<tr>	
				<td>Size</td>
			</tr>
			<tr>	
				<td><form:input path="size" /></td>	
			</tr>
			<tr>	
				<td>Quantity</td>
			</tr>
			<tr>	
				<td><form:input path="quantity" /></td>	
			</tr>
			<tr>	
				<td>Price</td>
			</tr>
			<tr>	
				<td><form:input path="price" /></td>	
				 			
			</tr>
			
			<tr>
				<td colspan="2" align="left"><input type="submit" value="save"/></td>			
			</tr>
		</table>
	</form:form>
	</div>
</body>
</html>