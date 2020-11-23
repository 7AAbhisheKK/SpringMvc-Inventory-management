<html>
<head>
	<%@include file="./base.jsp" %>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</head>
<header>
<%@include file="./Header.jsp" %>
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
      	<a href="staff/handle-delete/${p.getProduct_id() }"><i class="fas fa-eraser text-danger"></i></a>
      	<a href="staff/handle-update/${p.getProduct_id() }"><i class="fas fa-pencil-alt text-primary"></i></i></a>
      </td>
    </tr>
    </c:forEach>
  </tbody>
</table>
	<div class="container text-center">
		<a href="staff/add-product" class="btn btn-outline-success">Add Product</a>
	</div>
	</div>
</div>
</body>

</html>
