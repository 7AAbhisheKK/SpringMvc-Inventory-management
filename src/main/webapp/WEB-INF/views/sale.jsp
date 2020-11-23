<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<header>
<%@include file="./Dheader.jsp" %>


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
		<h1 class="text-center mb-3">Sales</h1>
		<table class="table">
  <thead class="thead-dark">
    <tr>
      <th scope="col">Month</th>
      <th scope="col">Profit</th>
      <th scope="col">Expenditure</th>
      <th scope="col">Details</th>

      
    </tr>
  </thead>
  <tbody>
    <tr>
      <th scope="row">${month }</th>
      <td>${profit }</td>
      <td>${expenditure }</td>
      <td>
      	<a href="detail-sale" class="btn btn-outline-success"><i class="fa fa-history" aria-hidden="true"></i></a>
      </td>
    </tr>
  </tbody>
</table>
	</div>
</div>
</body>
</html>