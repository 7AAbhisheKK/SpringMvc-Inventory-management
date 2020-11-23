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
		<h1 class="text-center mb-3">Employee</h1>
		<table class="table">
  <thead class="thead-dark">
    <tr>
      <th scope="col">Name</th>
      <th scope="col">Date of birth</th>
      <th scope="col">Date joined</th>
      <th scope="col">Date resigned</th>
      <th scope="col">Address</th>
      <th scope="col">Email</th>
      <th scope="col">Role</th>
      <th scope="col">Last Payment</th>
      <th scope="col">Post</th>
      <th scope="col">Salary</th>
      <th scope="col">Pay</th>
      <th scope="col">Payment History</th>
      
      
    </tr>
  </thead>
  <tbody>
  <c:forEach items="${employee }" var="p">
    <tr>
      <th scope="row"><a href="${pageContext.request.contextPath}/user/${p.getUsername()}">${p.getName() }</a></th>
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
      <td>${p.getRole() }</td>
      <td>${p.getLast_payment() }</td>
      <td>${p.getPost_name() }</td>
      <td>${p.getSalary()
       }</td>
      <td>
      	<a href="pay/${p.getUsername()}" class="btn btn-outline-success">Pay</a>
      </td>
      <td>
      	<a href="pay-detail/${p.getUsername() }" class="btn btn-outline-success"><i class="fa fa-history" aria-hidden="true"></i></a>
      </td>
    </tr>
    </c:forEach>
  </tbody>
</table>
	<div class="container text-center">
		<a href="${pageContext.request.contextPath}/register" class="btn btn-outline-success">Add Employee</a>
	</div>
	</div>
</div>
</body>

</html>
