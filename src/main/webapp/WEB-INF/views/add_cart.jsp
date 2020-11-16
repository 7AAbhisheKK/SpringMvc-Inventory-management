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
		<h1 class="text-center mb-3">Fill the product detail</h1>
		<form action="handle-cart-add" method="post">
			<div class="form-group">
		    <label for="category">Category</label>
		    <select  class="form-control" id="category" name="category" required>
		    <option value="">-select option-</option>
		      <c:forEach items="${cat }" var="p">
		      <option value="${p.getCategory_id() }">${p.getCategory_name() }</option>
		      </c:forEach>
		    </select>
		  </div>
			<div class="form-group">
		    <label for="sub_category">Sub Category</label>
		    <select class="form-control" id="sub_category" name="sub_category" required>
		    <option value="">-select option-</option>
		    </select>
		  </div>
			<div class="form-group">
		    <label for="product_id">Product</label>
		    <select class="form-control" id="product_id" name="product_id" required>
		    <option value="">-select option-</option>
		    </select>
		  </div>
			<div class="form-group">
			<label for="quantity">Quantity</label>
			<input placeholder="Quantity" class="form-control" id="quantity" type="number" value="1" min="1" max="100" name="quantity" required/>
			</div>
			<div class="form-group" >
			<label for="price">Price</label>
				<input type="number" class="form-control" id="price" value="" name="price" readonly>
			</div>
			<div class="form-group" >
			<label for="total">Total</label>
				<input type="text" class="form-control" id="total" name="total" disabled>
			</div>
			<div class="container text-center">
				<a href="${pageContext.request.contextPath}/" class ="btn btn-outline-danger">Back</a>
				<a href="${pageContext.request.contextPath}/cart" class ="btn btn-secondary">Go to cart</a>
				<button type="submit" class="btn btn-primary" id="btn">Submit</button>
			</div>
			
		</form>
		
	</div>
	</div>
</div>
<script>
$(document).ready(function(){
	$('#category').change(function(){
		var cat_id=$(this).val();
		var s='';
		s='<option id="sub_cat" value=""></option>';
		$('#sub_category').html(s);
		if(cat_id.length>0)
			{
		$.ajax({
			type:'GET',
			url:'${pageContext.request.contextPath}/test-demo/'+cat_id,
			success:function(result)
			{
				var result =JSON.parse(result);
				var s='<option id="sub_cat" value="">'+'-select option-'+'</option>';
				for (var i=0;i<result.length;i++)
					{
						s+='<option id="sub_cat" value="' +result[i].sub_category_id+'">'+result[i].sub_category_name+'</option>';
					}
				$('#sub_category').html(s);
				
			}
			
		});
		
	}});
});
</script>
<script >
$(document).ready(function(){
	$('#sub_category').change(function(){
		var sub_cat_id=$(this).val();
		var s='';
		s='<option id="product_id" value=""></option>';
		$('#product_id').html(s);
		if(sub_cat_id.length>0)
			{
			$.ajax({
				type:'GET',
				url:'${pageContext.request.contextPath}/test-demo2/'+sub_cat_id,
				success:function(result)
				{
					var result =JSON.parse(result);
					var s='<option id="product_id" value="">'+'-select option-'+'</option>';
					for (var i=0;i<result.length;i++)
					{
						s+='<option id="product_id" value="' +result[i].product_id+'">'+result[i].name+'</option>';
					}
				$('#product_id').html(s);
				}
			});
			}
		
	});
});



</script>
<script >
$(document).ready(function(){
	$('#product_id').change(function(){
		var product_id=$(this).val();
		if(product_id.length>0)
			{
			$.ajax({
				type:'GET',
				url:'${pageContext.request.contextPath}/test-demo3/'+product_id,
				success:function(result)
				{
					var result=JSON.parse(result);
					/* console.log(result); */
					document.getElementById("price").setAttribute('value',result);
					document.getElementById("total").setAttribute('value',document.getElementById("quantity").value*document.getElementById("price").value);
				}
				
			});
			}
		
	});
});
</script>
<script >
$(document).ready(function(){
	$('#quantity').change(function(){
		var quantity=$(this).val();
		var price=document.getElementById("price").value;
		var product_id=document.getElementById("product_id").value;
		if(price.length>0)
			{
			document.getElementById("total").setAttribute('value',price*quantity);
			}
		if(product_id.length>0&&quantity>0)
		{
	
			$.ajax({
				type:'GET',
				url:'${pageContext.request.contextPath}/test-demo4/'+product_id,
				success:function(result)
				{
					var result=JSON.parse(result);
					if(quantity>result.in_quantity)
					{
						
						$("#btn").prop('disabled', true);
						alert("Quantity is too large to be added in cart");
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