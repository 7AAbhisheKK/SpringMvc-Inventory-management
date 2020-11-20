<!DOCTYPE html>
<html>
<head>
<%@include file="./base.jsp" %>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<link rel="stylesheet" href="<c:url value="/resources/css/user.css" />"  media='all'>
<meta charset="ISO-8859-1">
<link href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.1.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<!------ Include the above in your HEAD tag ---------->
<title>Insert title here</title>
</head>
<body>

<div class="container mt-5">
<div class="row ">
  <div class="col-md-6 offset-md-3">
    <form class="form-horizontal" action="${pageContext.request.contextPath}/user/handle-user-change-password/${username}" method="post">
      <div class="panel panel-default">
        <div class="panel-heading">
        <h4 class="panel-title">Change Password</h4>
        </div>
        <div class="panel-body">
         
          <div class="form-group">
            <label class="col-sm-2 control-label">Old Password</label>
            <div class="col-sm-10">
              <input type="password" class="form-control"  id="password1" name="password1">
            </div>
          </div>
          <div class="form-group">
            <label class="col-sm-2 control-label">New Password</label>
            <div class="col-sm-10">
              <input type="password" class="form-control" id="password2" name="password2" >
            </div>
          </div>
        </div>
      </div>
      <div class="form-group">
        <button type="submit" class="btn btn-primary btn-block"> Submit  </button>
    </div> <!-- form-group// -->
    </form>
  </div>
</div>
</div>
</body>
 
</html>