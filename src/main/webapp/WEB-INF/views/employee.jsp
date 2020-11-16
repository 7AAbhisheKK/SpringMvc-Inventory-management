<html>
<head>
	<%@include file="./base.jsp" %>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</head>
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
      <th scope="col">Name</th>
      <th scope="col">Date of birth</th>
      <th scope="col">Date joined</th>
      <th scope="col">Date resigned</th>
      <th scope="col">Address</th>
      <th scope="col">Email</th>
      <th scope="col">Age</th>
      <th scope="col">Role</th>
      <th scope="col">Last Payment</th>
      <th scope="col">Post</th>
      <th scope="col">Salary</th>
      <th scope="col">Pay</th>
      
    </tr>
  </thead>
  <tbody>
  <c:forEach items="${employee }" var="p">
    <tr>
      <th scope="row">${p.getName() }</th>
      <td>${p.getDob() }</td>
      <td>${p.getDate_joined() }</td>
      <c:if test="${p.getDate_resigned()!=NULL }">
      <td>${p.getExpiry_date() }</td>
      </c:if>
      <c:if test="${p.getDate_resigned()==NULL }">
      <td>Not Applicable</td>
      </c:if>
      <td>${p.getAddress() }</td>
      <td>${p.getEmail() }</td>
      <td>${p.getAge() }</td>
      <td>${p.getRole() }</td>
      <td>${p.getLast_payment() }</td>
      <td>${p.getPost_name() }</td>
      <td>${p.getSalary()
       }</td>
      <td>
      	<a href="pay/${p.getUsername()}" class="btn btn-outline-success">Pay</a>
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
