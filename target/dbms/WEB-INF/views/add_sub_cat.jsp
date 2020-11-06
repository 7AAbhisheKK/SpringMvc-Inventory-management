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
		<form action="handle-add-sub" method="post">
			<div class="form-group">
				<label for="sub_category_name">Subcategory Name</label>
				<input type="text" class="form-control" id="sub_category_name" name="sub_category_name" placeholder="Enter SubCategory Name">
			</div>
			<div class="form-group">
				<label for="sub_category_id">Subcategory Id</label>
				<input type="text" class="form-control" id="sub_category_id" name="sub_category_id" placeholder="Enter subCategory Id">
			</div>
			<div class="form-group">
		    <label for="category_id">Category</label>
		    <select  class="form-control" id="category_id" name="category_id">
		    <option value="">-select option-</option>
		      <c:forEach items="${category }" var="p">
		      <option value="${p.getCategory_id() }">${p.getCategory_name() }</option>
		      </c:forEach>
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