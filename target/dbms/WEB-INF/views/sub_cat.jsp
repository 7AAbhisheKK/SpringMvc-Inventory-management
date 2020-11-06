<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="./base.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="container mt-3">
	<div class="col-md-12">
		<h1 class="text-center mb-3">Sub Category</h1>
		<table class="table">
  <thead class="thead-dark">
    <tr>
      <th scope="col">Sub Category Id</th>
      <th scope="col">Name</th>
      <th scope="col">Category</th>
      <th scope="col">Action</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach items="${sub_category }" var="p">
    <tr>
      <th scope="row">${p.getSub_category_id() }</th>
      <td>${p.getSub_category_name() }</td>
      <td>${p.getCategory_id() }</td>
      <td>
      	<a href=""><i class="fas fa-eraser text-danger"></i></a>
      	<a href=""><i class="fas fa-pencil-alt text-primary"></i></a>
      </td>
    </tr>
    </c:forEach>
  </tbody>
</table>
	<div class="container text-center">
		<a href="add-sub-category" class="btn btn-outline-success">Add Category</a>
	</div>
	</div>
</div>
</body>
</html>