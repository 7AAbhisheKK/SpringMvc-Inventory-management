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
		<h1 class="text-center mb-3">Expiring in</h1>
		<form action="handle-expiring-soon" method="post">
			<div class="form-group">
		    <label for="interval">Category</label>
		    <select  class="form-control" id="interval" name="interval">
		    <option value="1">1 Month</option>
		    <option value="2">2 Month</option>
		    <option value="3">3 Month</option>
		    <option value="6">6 Month</option>
		    </select>
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