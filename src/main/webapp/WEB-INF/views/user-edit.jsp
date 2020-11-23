<!DOCTYPE html>
<html>
<head>
<%@include file="./Dheader.jsp" %>
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
    <form class="form-horizontal" action="${pageContext.request.contextPath}/user/handle-user-edit/${employee.getUsername()}" method="post">
      <div class="panel panel-default">
        <div class="panel-heading">
        <h4 class="panel-title">User info</h4>
        </div>
        <div class="panel-body">
         
          <div class="form-group" >
            <label class="col-sm-2 control-label">Name</label>
            <div class="col-sm-10">
              <input type="text" class="form-control" value="${employee.getName() }" id="name" name="name" required>
            </div>
          </div>
          <div class="form-group">
            <label class="col-sm-2 control-label">Post Name</label>
            <div class="col-md-6 col-md-11-5">
            <select  class="form-control" id="post_id" name="post_id" required>
		    <option selected value="${defaultpost.getPost_id()}" >${defaultpost.getPost_name()}</option>
		      <c:forEach items="${post }" var="p">
		      <option value="${p.getPost_id() }">${p.getPost_name() }</option>
		      </c:forEach>
		    </select>
		    </div>
          </div>
        </div>
      </div>

      <div class="panel panel-default">
        <div class="panel-heading">
        <h4 class="panel-title">Contact info</h4>
        </div>
        <div class="panel-body">
          <div class="form-group">
            <label class="col-sm-2 control-label">Mobile number 1</label>
            <div class="col-sm-10">
              <input type="tel" class="form-control" value="${mob1 }" id="mob1" name="mob1" required>
            </div>
            </div>
          <div class="form-group">
            <label class="col-sm-2 control-label">Mobile number 2</label>
            <div class="col-sm-10">
              <input type="tel" class="form-control" value="${mob2 }" id="mob2" name="mob2" >
            </div>
          </div>
          <div class="form-group">
            <label class="col-sm-2 control-label">Date of birth</label>
            <div class="col-sm-10">
              <input type="date" class="form-control" value="${employee.getDob() }" id="dob" name="dob" required><!-- <i class="fas fa-birthday-cake"></i> -->
            </div>
          </div>
          <div class="form-group">
            <label class="col-sm-2 control-label">E-mail address</label>
            <div class="col-sm-10">
              <input type="email" class="form-control" value="${employee.getEmail() }" id="email" name="email" required>
            </div>
          </div>
          <div class="form-group">
            <label class="col-sm-2 control-label">Address</label>
            <div class="col-sm-10">
              <textarea rows="3" class="form-control" id="address" name="address" required>${employee.getAddress() } </textarea>
            </div>
          </div>
          <div class="form-group">
            <div class="col-sm-10 col-sm-offset-2">
             <a href="${pageContext.request.contextPath}/" class="btn"><i class="fas fa-undo"></i>Back</a>
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