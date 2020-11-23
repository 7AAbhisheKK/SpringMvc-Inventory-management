<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="./Dheader.jsp" %>
<%@include file="./base.jsp" %>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="container mt-3">
	<div class="col-md-12">
		<h1 class="text-center mb-3">Expired Products</h1>
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
      <td>${p.getBrand() }</td>
      <td>${p.getIn_quantity() }</td>
      <td>
      	<a href="${pageContext.request.contextPath}/${url}/${p.getProduct_id() }" class="btn btn-outline-danger">Dump the product</a>
      </td>
    </tr>
    </c:forEach>
  </tbody>
</table>
	</div>
</div>
</body>
</html>