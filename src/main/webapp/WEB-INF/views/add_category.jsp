<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="./base.jsp" %>
</head>
<body>
<div class="container mt-3">
	<div class="row">
		<div class="col-md-6 offset-md-3">
		<h1 class="text-center mb-3">Fill the product detail</h1>
		<form action="handle-add_cat" method="post">
			<div class="form-group">
				<label for="category_name">Category Name</label>
				<input type="text" class="form-control" id="category_name" name="category_name" placeholder="Enter Category Name">
			</div>
			<div class="form-group">
				<label for="category_id">Category Id</label>
				<input type="text" class="form-control" id="category_id" name="category_id" placeholder="Enter Category Id">
			</div>
			<div class="container text-center">
				<a href="${pageContext.request.contextPath}/" class ="btn btn-outline-danger">Back</a>
				<button type="submit" class="btn btn-primary">Submit</button>
			</div>
			
		</form>
		
	</div>
	</div>
</div>
</body>
</html>