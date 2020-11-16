<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="./base.jsp" %>
</head>
<body>
<div class="container mt-3">
	<div class="row">
		<div class="col-md-6 offset-md-3">
		<h1 class="text-center mb-3">Enter the quantity</h1>
		<form action="${pageContext.request.contextPath}/handle-refill/${product_id}" method="post">
			<div class="form-group" >
			<label for="quantity">Enter the Quantity</label>
				<input placeholder="Quantity" class="form-control" id="quantity" type="number" value="1" min="1" max="100" name="quantity" required/>
			</div>
			<div class="container text-center">
				<a href="${pageContext.request.contextPath}" class ="btn btn-outline-danger">Back</a>
				<button type="submit" class="btn btn-primary" id="btn">Submit</button>
			</div>
			
		</form>
		
	</div>
	</div>
</div>
<script >
$(document).ready(function(){
	$('#quantity').change(function(){
		var quantity=$(this).val();
		var product_id ="${product_id}";
		
		if(product_id.length>0&&quantity>0)
		{
	
			$.ajax({
				type:'GET',
				url:'${pageContext.request.contextPath}/test-demo4/'+product_id,
				success:function(result)
				{
					var result=JSON.parse(result);
					if(quantity>result.Available_quantity)
					{
						
						$("#btn").prop('disabled', true);
						alert("Quantity is too large to be updated");
					}
					else
					{
						$("#btn").prop('disabled', false);
					}
				}
				
			});
		}
		else
		{
			$("#btn").prop('disabled', true);
		}
		
	});
});


</script>
</body>
</html>