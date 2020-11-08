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
		<form action="handle-order" method="post">
			<div class="form-group">
				<label for="customer_name">Mobile NUmber</label>
				<input type="text" class="form-control" id="customer_name" name="customer_name" placeholder="Enter Customer Name" required>
			</div>
			<div class="form-group">
				<label for="customer_mobile_number">Category Id</label>
				<input type="text" class="form-control" id="customer_mobile_number" name="customer_mobile_number" placeholder="Enter Customer Mobile Number" required>
			</div>
			<div class="form-group">
				<label for="order_date">Order Date</label>
				<input type="text" class="form-control" id="order_date" name="order_date" placeholder="Enter Order Date" required>
			</div>
			<div class="form-group">
				<label for="month_year">Order Month-Year</label>
				<input type="text" class="form-control" id="month_year" name="month_year" placeholder="Enter month year" required>
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