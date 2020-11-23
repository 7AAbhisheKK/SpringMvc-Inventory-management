<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="./Dheader.jsp" %>
<meta charset="ISO-8859-1">
<%@include file="./base.jsp" %>
</head>
<body>
<div class="container mt-3">
	<div class="row">
		<div class="col-md-6 offset-md-3">
		<h1 class="text-center mb-3">Maintenance</h1>
		<form action="handle-maintenance" method="post">
			<div class="form-group">
			<label for="description">Description</label>
			<textarea placeholder="description" class="form-control" id="description" name="description" rows="4" cols="50" required></textarea>
			</div>
			<div class="form-group" >
			<label for="date">Date</label>
				<input type="date" class="form-control" id="date" value="" name="date" required>
			</div>
			<div class="form-group" >
			<label for="amount">Amount</label>
				<input type="number" class="form-control" id="amount" value="" name="amount" required>
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