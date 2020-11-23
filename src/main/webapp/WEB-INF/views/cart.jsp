<html>
<head>
	<%@include file="./base.jsp" %>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@include file="./Dheader.jsp" %>
</head>
<body>
<div class="container mt-3">
	<div class="col-md-12">
		<h1 class="text-center mb-3">Cart App</h1>
		<table class="table">
  <thead class="thead-dark">
    <tr>
    <th scope="col">Name</th>
      <th scope="col">Product Id</th>
      <th scope="col">Selling Price</th>
      <th scope="col">Quantity</th>
      <th scope="col">Price</th>
      <th scope="col">Action</th>
      
    </tr>
  </thead>
  <tbody>
  <c:forEach items="${cart }" var="p">
    <tr>
      <td>${p.getName() }</td>
      <th scope="row">${p.getProduct_id() }</th>
      <td>${p.getPrice() }</td>
      <td>${p.getQuantity() }</td>
      <td>${p.getQuantity()*p.getPrice() }</td>
      <td>
      	<a href="${pageContext.request.contextPath}/test-demo6/${p.getProduct_id() }"><i class="fas fa-eraser text-danger"></i></a>
      </td>
    </tr>
    </c:forEach>
  </tbody>
</table>
	<div class="container text-center">
		<a href="${pageContext.request.contextPath}/" class ="btn btn-outline-danger">Back</a>
		<a href="${pageContext.request.contextPath}/test-demo7/" class ="btn btn-outline-danger">Empty Cart</a>
		<a href="add-cart" class="btn btn-outline-success">Add Another Item</a>
		<a href="order" class ="btn btn-outline-danger">Order</a>
	</div>
	</div>
</div>
</body>

</html>
