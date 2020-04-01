<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Displaying Product list</title>


<style type="text/css">
table {
	text-align: "center";
}

a {
	text-decoration: underline;
	color: blue;
}

a : hover {
	text-decoration: underline;
}

div {
	margin: 10% auto;
	background-color: grey;
	border-radius: 2%;
	color: white;
	border: 1px dashed grey;
	width: 70%;
	padding: 1% 2% 5% 2%
}
t
</style>
</head>
<body style="background-color: black;">

	<div align="center">
		<h2>Product List</h2>
		<hr />
		<br>
		<table border="2" width=100% cellpadding="5">
			<tr>
				<th>Product Id</th>
				<th>Product Name</th>
				<th>Product Price</th>
				<th>Update</th>
				<th>Delete</th>
			</tr>

			<c:forEach var="product" items="${productlist}">

				<tr align="center">
					<td>${product.id}</td>
					<td>${product.name}</td>
					<td>${product.price}</td>

					<td><a href="editproduct/${product.id}">Update</a></td>
					<td><a href="${product.id}" onclick="deleteFunction()">Delete</a></td>

				</tr>
			</c:forEach>
		</table>
		<br /> <a href="/"><button type="button">Add New Product</button></a>

	</div>
	<script type="text/javascript">
		function deleteFunction() {

			alert("Product Deleted Sucessfully!");

		}
	</script>
</body>
</html>