<html>
<head>
	<%@include file="./base.jsp" %>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</head>
<header>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="#">Welcome</a>
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
        <a class="nav-link" href="sale">Sale</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="employee">Employee</a>
      </li>
    
    </ul>
  </div>
</nav>
</header>
<body>
<div class="container mt-3">
	<div class="col-md-12">
		<h1 class="text-center mb-3">Welcome to Product App</h1>
		<table class="table">
  <thead class="thead-dark">
    <tr>
      <th scope="col">Product Id</th>
      <th scope="col">Name</th>
      <th scope="col">Selling Price</th>
      <th scope="col">Whole sale price</th>
      <th scope="col">Expiry Date</th>
      <th scope="col">Arrival Date</th>
      <th scope="col">Available Quantity</th>
      <th scope="col">Brand</th>
      <th scope="col">In Stock</th>
      <th scope="col">Action</th>
      
    </tr>
  </thead>
  <tbody>
  <c:forEach items="${product }" var="p">
    <tr>
      <th scope="row">${p.getProduct_id() }</th>
      <td>${p.getName() }</td>
      <td>${p.getIn_price() }</td>
      <td>${p.getWholesale_price() }</td>
      <c:if test="${p.getIn_expiry_date()!=NULL }">
      <td>${p.getIn_expiry_date() }</td>
      </c:if>
      <c:if test="${p.getIn_expiry_date()==NULL }">
      <td>Not Applicable</td>
      </c:if>
      <td>${p.getArrival_date() }</td>
      <td>${p.getAvailable_quantity() }</td>
      <td>${p.getBrand() }</td>
      <td>${p.getIn_quantity() }</td>
      <td>
      	<a href="handle-delete/${p.getProduct_id() }"><i class="fas fa-eraser text-danger"></i></a>
      	<a href="handle-update/${p.getProduct_id() }"><i class="fas fa-pencil-alt text-primary"></i></i></a>
      </td>
    </tr>
    </c:forEach>
  </tbody>
</table>
	<div class="container text-center">
		<a href="add-product" class="btn btn-outline-success">Add Product</a>
	</div>
	</div>
</div>
</body>

</html>
