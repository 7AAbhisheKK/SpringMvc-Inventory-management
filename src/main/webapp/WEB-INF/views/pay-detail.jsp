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
		<h1 class="text-center mb-3">Employee Payment history</h1>
		<table class="table">
  <thead class="thead-dark">
    <tr>
      <th scope="col">Name</th>
      <th scope="col">Username</th>
      <th scope="col">amount</th>
      <th scope="col">date</th>
      <th scope="col">description</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach items="${employee_payment }" var="p">
    <tr>
      <th scope="row">${p.getName() }</th>
      <td>${p.getUsername() }</td>
      <td>${p.getAmount() }</td>
      <td>${p.getDate() }</td>
      <td>${p.getDescription() }</td>
    </tr>
    </c:forEach>
  </tbody>
</table>
	</div>
</div>
</body>

</html>
