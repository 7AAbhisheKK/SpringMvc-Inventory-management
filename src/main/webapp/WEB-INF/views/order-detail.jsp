<html>
<head>
	<%@include file="./base.jsp" %>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</head>
<header>
<%@include file="./Dheader.jsp" %>
</header>
<body>
<div class="container mt-3">
	<div class="col-md-12">
		<h1 class="text-center mb-3">Order Detail</h1>
		<table class="table">
  <thead class="thead-dark">
    <tr>
      <th scope="col">Customer name</th>
      <th scope="col">Product id</th>
      <th scope="col">Product Name</th>
      <th scope="col">Quantity</th>
      <th scope="col">Price</th>
      <th scope="col">Date</th>

      
    </tr>
  </thead>
  <tbody>
  <c:forEach items="${order }" var="p">
    <tr>
      <th scope="row">${p.getCustomer_name() }</th>
      <td>${p.getProduct_id() }</td>
      <td>${p.getName() }</td>
      <td>${p.getQuantity() }</td>
      <td>${p.getPrice() }</td>
      <td>${p.getDate() }</td>
    </tr>
    </c:forEach>
  </tbody>
</table>
	<div class="container text-center">
	</div>
	</div>
</div>
</body>

</html>
