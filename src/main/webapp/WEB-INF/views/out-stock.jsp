<html>
<head>
<%@include file="./Dheader.jsp" %>
	<%@include file="./base.jsp" %>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</head>
<body>
<div class="container mt-3">
	<div class="col-md-12">
		<h1 class="text-center mb-3">Out of Stock in Store</h1>
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
      <th scope="col">In stock Quantity</th>
      <th scope="col">Brand</th>
      <th scope="col">Sub Category id</th>
      <th scope="col">Action</th>
      
    </tr>
  </thead>
  <tbody>
  <c:forEach items="${product }" var="p">
    <tr>
      <th scope="row">${p.getProduct_id() }</th>
      <td>${p.getName() }</td>
      <td>${p.getSelling_price() }</td>
      <td>${p.getWholesale_price() }</td>
      <c:if test="${p.getExpiry_date()!=NULL }">
      <td>${p.getExpiry_date() }</td>
      </c:if>
      <c:if test="${p.getExpiry_date()==NULL }">
      <td>Not Applicable</td>
      </c:if>
      <td>${p.getArrival_date() }</td>
      <td>${p.getAvailable_quantity() }</td>
      <td>${p.getIn_quantity() }</td>
      <td>${p.getBrand() }</td>
      <td>${p.getSub_category() }</td>
       <td>
      	<a href="refill/${p.getProduct_id() }" class="btn btn-outline-success">Refill</a>
      </td>
    </tr>
    </c:forEach>
  </tbody>
</table>
	</div>
</div>
</body>

</html>
