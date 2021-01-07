<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.8/css/all.css">
<%@include file="./Dheader.jsp" %>
<%@include file="./base.jsp" %>
<div class="container" style="margin-top:70px;">
<div class="card bg-light">
<article class="card-body mx-auto" style="max-width: 400px;">
	<h4 class="card-title mt-3 text-center">Create Account</h4>
	<p class="text-center">Create a Employee Account</p>
	<form action="handle-registration" method="post" onsubmit="return validation()">
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
		    <span class="input-group-text"> <i class="fa fa-mobile" aria-hidden="true"></i> </span>
		 </div>
        <input name="mob1" id="mob1" class="form-control" placeholder="Enter Mobile Number" type="text" required>
    </div> <!-- form-group// -->
    <div class="form-group input-group">
    	<div class="input-group-prepend">
		    <span class="input-group-text"> <i class="fa fa-mobile" aria-hidden="true"></i> </span>
		 </div>
        <input name="mob2" id="mob2" class="form-control" placeholder="Enter Alternative Mobile Number" type="text">
    </div> <!-- form-group// -->
    <div class="form-group input-group">
    	<div class="input-group-prepend">
		    <span class="input-group-text"> <i class="fa fa-address-book" aria-hidden="true"></i> </span>
		 </div>
        <input name="address" id="address" class="form-control" placeholder="Enter the Address"   required>
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
        <input class="form-control" placeholder="Repeat password" type="password" id="rp" name="rp" required>
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
<script>
function get_age(born, now) {
    var birthday = new Date(now.getFullYear(), born.getMonth(), born.getDate());
    if (now >= birthday) 
      return now.getFullYear() - born.getFullYear();
    else
      return now.getFullYear() - born.getFullYear() - 1;
}
function validation()
{
	var username=document.getElementById("username").value;
	var x=document.getElementById("mob1").value;
	if(x.length!=10)
	{
		alert("Enter a Valid mobile number");
		return false;
	}
	var y=document.getElementById("mob2").value;
	if(y.length!=0)
	{
		if(y.length!=10)
		{
			console.log(y.length);
			alert("Enter a Valid Alternative mobile number");
			return false;
		}
		
	}
 	var dob=document.getElementById("dob").value;
	 var now = new Date();
	 console.log(dob);
	 var birthdate = dob.split("-");
	 var born = new Date(birthdate[0], birthdate[1]-1, birthdate[2]);
	 console.log(born);
	 var age=get_age(born,now);
	 console.log(age);
	 if(age<18)
	 {
		 alert("Employee must be 18 year old");
		 return false;
	 }
	x=document.getElementById("password").value;
	y=document.getElementById("rp").value;
	if(x!=y)
	{
		alert("Password did not match");
		return false;
	}
	var f=true;
	$.ajax({
		type:'GET',
		url:'${pageContext.request.contextPath}/test-demo5/'+username,
		success:function(result)
		{
			var result=JSON.parse(result);
			if(result==true)
			{
				
				alert("Username is Already Taken");
				f=false;
			}
		}
		
	});
	if(f==false)
		return false;
	return true;
}
</script>