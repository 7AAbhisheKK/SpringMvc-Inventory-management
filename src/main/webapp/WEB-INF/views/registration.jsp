<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.8/css/all.css">

<%@include file="./base.jsp" %>
<div class="container" style="margin-top:100px;">
<div class="card bg-light">
<article class="card-body mx-auto" style="max-width: 400px;">
	<h4 class="card-title mt-3 text-center">Create Account</h4>
	<p class="text-center">Create a Employee Account</p>
	<form action="handle-registration" method="post">
	<div class="form-group input-group">
		<div class="input-group-prepend">
		    <span class="input-group-text"> <i class="fa fa-user"></i> </span>
		 </div>
        <input name="name" class="form-control" placeholder="Full name" type="text" id="name" required>
    </div> <!-- form-group// -->
    <div class="form-group input-group">
    	<div class="input-group-prepend">
		    <span class="input-group-text"> <i class="fa fa-envelope"></i> </span>
		 </div>
        <input name="email" id="email" class="form-control" placeholder="Email address" type="email" required>
    </div> <!-- form-group// -->
    <div class="form-group input-group">
    	<div class="input-group-prepend">
		    <span class="input-group-text"> <i class="fas fa-birthday-cake"></i> </span>
		 </div>
        <input name="dob" id="dob" class="form-control" placeholder="Enter date of birth" type="date" required>
    </div> <!-- form-group// -->
    
    <div class="form-group input-group">
    	<div class="input-group-prepend">
		    <span class="input-group-text"> <i class="fa fa-id-card" aria-hidden="true"></i> </span>
		 </div>
        <input name="username" id="username" class="form-control" placeholder="Enter username" type="text" required>
    </div> <!-- form-group// -->
    <div class="form-group input-group">
    	<div class="input-group-prepend">
		    <span class="input-group-text"> <i class="fa fa-address-book" aria-hidden="true"></i> </span>
		 </div>
        <input name="address" id="address" class="form-control" placeholder="Enter the Address" type="text-area"  required>
    </div> <!-- form-group// -->
    <div class="form-group input-group">
    	<div class="input-group-prepend">
		    <span class="input-group-text"> <i class="fa fa-lock"></i> </span>
		</div>
        <input class="form-control" placeholder="Create password" type="password" id="password" name="password" required>
    </div> <!-- form-group// -->
    <div class="form-group input-group">
    	<div class="input-group-prepend">
		    <span class="input-group-text"> <i class="fa fa-lock"></i> </span>
		</div>
        <input class="form-control" placeholder="Repeat password" type="password" required>
    </div> <!-- form-group// -->
    <div class="form-group input-group">
      <div class="input-group-prepend">
		    <span class="input-group-text"> <i class="fas fa-tasks"></i> </span>
		</div>
    <select  class="form-control" id="role" name="role" required>
    <option value="">Select Role</option>
      <option value="ROLE_ADMIN">ADMIN</option>
      <option value="ROLE_STAFF">STAFF</option>
      <option value="ROLE_CASHIER">CASHIER</option>
    </select>
  </div>  
      <div class="form-group input-group">
      <div class="input-group-prepend">
		    <span class="input-group-text"> <i class="fas fa-tasks"></i> </span>
		</div>
    <select  class="form-control" id="post_id" name="post_id" required>
    <option value="">Select Post</option>
      <c:forEach items="${Post }" var="p">
		      <option value="${p.getPost_id() }">${p.getPost_name() }</option>
		      </c:forEach>
    </select>
  </div>
  <div class="form-group input-group">
    	<div class="input-group-prepend">
		    <span class="input-group-text"> <i class="fas fa-calendar-check"></i> </span>
		</div>
        <input class="form-control" placeholder="Date Joined" type="date" id="date_joined" name="date_joined" required>
    </div> <!-- form-group// -->                                         
    <div class="form-group">
        <button type="submit" class="btn btn-primary btn-block"> Create Account  </button>
    </div> <!-- form-group// -->
     
    <p class="text-center">Have an account? <a href="login">Log In</a> </p>                                                                 
</form>
</article>
</div> <!-- card.// -->

</div> 