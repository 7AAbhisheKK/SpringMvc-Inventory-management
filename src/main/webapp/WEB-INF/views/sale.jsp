<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<header>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="#">Navbar</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="${pageContext.request.contextPath}">Home <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="cart"><i class="fas fa-shopping-cart"></i>Cart</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="add-maintenance">add maintenance</a>
      </li>
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Products
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
          <a class="dropdown-item" href="out-stock">Out of stock in store</a>
          <a class="dropdown-item" href="out-stock-ware">Out of stock in warehouse</a>
          <a class="dropdown-item" href="add-product">Add product</a>
          <a class="dropdown-item" href="add-category">Add Category</a>
          <a class="dropdown-item" href="add-sub-category">Add Sub category</a>
          <div class="dropdown-divider"></div>
          <a class="dropdown-item" href="handle-product-order">New arrival</a>
        </div>
      </li>
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Expired Product
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
          <a class="dropdown-item" href="expired">Expired Product In stock</a>
          <a class="dropdown-item" href="expired2">Expired Product In Warehouse</a>
          <a class="dropdown-item" href="expiring-soon">Expiring In</a>
        </div>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="employee">Employee</a>
      </li>
    </ul>
  </div>
</nav>


</header>
<head>
<%@include file="./base.jsp" %>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="container mt-3">
	<div class="col-md-12">
		<h1 class="text-center mb-3">Welcome to Product App</h1>
		<table class="table">
  <thead class="thead-dark">
    <tr>
      <th scope="col">Month</th>
      <th scope="col">Profit</th>
      <th scope="col">Expenditure</th>

      
    </tr>
  </thead>
  <tbody>
    <tr>
      <th scope="row">${month }</th>
      <td>${profit }</td>
      <td>${expenditure }</td>
    </tr>
  </tbody>
</table>
	</div>
</div>
</body>
</html>