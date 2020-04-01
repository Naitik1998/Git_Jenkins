<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Product</title>
<style type="text/css">
div {
	margin: 10% auto;
	background-color: grey;
	border-radius: 2%;
	color: white;
	border: 1px dashed grey;
	width: 70%;
	padding: 1% 2% 5% 2%
}
</style>
</head>
<body style="background-color: black;">


	<div align="center">
		<h2>Edit Product</h2>
		<hr />
		<br>
		<form:form method="post" modelAttribute="product"
			action="${product.id}/editsave">
			<table>
				<tr>
					<td>Product Id :</td>
					<td>${product.id}<form:hidden path="id" /></td>
				</tr>
				<tr>
					<td>Product Name :</td>
					<td><form:input path="name" /></td>
				</tr>
				<tr>
					<td>Product Price :</td>
					<td><form:input path="price" /></td>
				</tr>


			</table>
			<br>
			<button type="submit" onclick="editProductFunction()">Save</button>
		</form:form>
	</div>

	<script type="text/javascript">
		function editProductFunction() {
			alert("Product Updated Sucessfully!");
		}
	</script>
</body>
</html>