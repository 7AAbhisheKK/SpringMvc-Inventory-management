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
		<form action="${pageContext.request.contextPath}/handle-pay" method="post">
			<div class="form-group">
				<label for="naem">Employee Name</label>
				<input type="text" class="form-control" id="name" name="name" value="${employee.getName()}" readonly>
			</div>
			<div class="form-group">
				<label for="salary">Salary</label>
				<input type="text" class="form-control" id="salary" name="salary" value="${employee.getSalary()}">
			</div>
			<div class="form-group">
				<label for="post_name">Post Name</label>
				<input type="text" class="form-control" id="post_name" name="post_name" value="${employee.getPost_name()}" readonly>
			</div>
			<div class="form-group">
				<label for="username">Post Name</label>
				<input type="text" class="form-control" id="username" name="username" value="${employee.getUsername()}" hidden>
			</div>
			<div class="form-group">
				<label for="last_payment">Last payment</label>
				<input type="date" class="form-control" id="last_payment" name="last_payment" value="${employee.getLast_payment()}" readonly>
			</div>
			<div class="form-group">
				<label for="description">Description</label>
				<textarea placeholder="description" class="form-control" id="description" name="description" rows="4" cols="50" ></textarea>
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