<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product Management</title>
<!-- <style type="text/css">
div {
	margin: 10% auto;
	background-color: grey;
	border-radius: 2%;
	color: white;
	border: 1px dashed grey;
	width: 70%;
	padding: 1% 2% 5% 2%
}
</style> -->
<style type="text/css">
    <%@include file="css/style.css" %>
</style>


</head>
<body style="background-color: black;">
	<div align="center" class="myContent">
		<h2 id="editable" onmouseover="changeTo()" onmouseout="changeBack()">Add
			New Product</h2>
		<!-- <hr style="width:50%" /> -->
		<hr />
		<br>
		<form:form method="post" modelAttribute="product" action="save">
			<table>
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
			<button type="submit" onclick="mySaveFunction()">Save</button>
			  &nbsp;&nbsp;&nbsp;
			<a href="/displayproduct"><button type="button">show
					product</button></a>
		</form:form>

	</div>

	<script type="text/javascript">
		function mySaveFunction() {
			alert("Product Added Sucessfully!");
		}
		function changeTo() {
			document.getElementById("editable").style.backgroundColor = "black";
			document.getElementById("editable").style.color = "blue";
		}
		function changeBack() {
			document.getElementById("editable").style.backgroundColor = "grey";
			document.getElementById("editable").style.color = "white";
		}
	</script>
</body>
</html>