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
		<h1 class="text-center mb-3">Category</h1>
		<table class="table">
  <thead class="thead-dark">
    <tr>
      <th scope="col">Month</th>
      <th scope="col">Name</th>
      <th scope="col">Amount</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th scope="row">${month }</th>
      <td>Maintenance </td>
      <td>${maintenance}
      </td>
    </tr>
    <tr>
      <th scope="row">${month }</th>
      <td>Salary </td>
      <td>${salary}
      </td>
    </tr>
    <tr>
      <th scope="row">${month }</th>
      <td>Orders </td>
      <td>${orders}
      </td>
    </tr>
    <tr>
      <th scope="row">${month }</th>
      <td>Whole Orders </td>
      <td>${wholeorder}
      </td>
    </tr>
  </tbody>
</table>
	</div>
</div>
</body>
</html>