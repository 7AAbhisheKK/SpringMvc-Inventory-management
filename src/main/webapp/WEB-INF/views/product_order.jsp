<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="./base.jsp" %>
</head>
<script>  
        function enable_disable() { 

        	var isDisabled = $('#Expiry_date').prop('disabled');
        	console.log(!isDisabled);
        	/* if (isDisabled==true)
        		$("#Expiry_date").value()=null; 
        	console.log($("#Expiry_date")); */
            $("#Expiry_date").prop('disabled', !isDisabled); 
        } 
    </script>
<body>
<div class="container mt-3">
	<div class="row">
		<div class="col-md-6 offset-md-3">
		<h1 class="text-center mb-3">Fill the product detail</h1>
		<form action="handle-whole-order" method="post">
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
			<label for="Available_quantity">Quantity received</label>
			<input placeholder="Quantity" class="form-control" id="Available_quantity" type="number" value="1" min="1" max="100" name="Available_quantity" required/>
			</div>
			<div class="form-group" >
			<label for="selling_price">Price</label>
				<input type="number" class="form-control" id="selling_price" value="" name="selling_price" required>
			</div>
			<div class="form-group" >
			<label for="wholesale_price">whole Price</label>
				<input type="number" class="form-control" id="wholesale_price" value="" name="wholesale_price" required>
			</div>
			<div class="form-group">
				<input type="hidden" class="form-control" id="Arrival_date" name="Arrival_date" value="" >
			</div>
			<div class="form-group">
				<input type="hidden" class="form-control" id="name" name="name" placeholder="Enter Product Name" value="" >
			</div>
			<div class="form-group">
				<input type="hidden" class="form-control" id="minimum_quantity" name="minimum_quantity" placeholder="Enter the minimum Quantity" value="">
			</div>
			<div class="form-group">
				<input type="hidden" class="form-control" id="Brand" name="Brand" placeholder="Enter the Brand" value="">
			</div>
			<div class="form-group">
				<input type="hidden" class="form-control" id="in_price" name="in_price" placeholder="Enter the Stock Price" value="">
			</div>
			<div class="form-group">
				<input type="hidden" class="form-control" id="in_quantity" name="in_quantity" placeholder="Enter the Stock Quantity" value="">
			</div>
			<div class="form-group">
				<input type="hidden" class="form-control" id="in_wholesale_price" name="in_wholesale_price" placeholder="Enter the Stock Wholesale Price" value="">
			</div>
			<div class="form-group">
			  <input class="form-check-input position-static" type="checkbox" id="blankCheckbox" onclick="enable_disable()" aria-label="Expiry Date is not Applicable">
				<label for="Expiry_date">Expiry Date NOT Applicable</label>
				<input type="date" class="form-control" id="Expiry_date" name="Expiry_date">
			</div>
			<div class="form-group" >
			<label for="total">Total</label>
				<input type="text" class="form-control" id="total" name="total" readonly>
			</div>
			<div class="container text-center">
				<a href="${pageContext.request.contextPath}/" class ="btn btn-outline-danger">Back</a>
				<button type="submit" class="btn btn-primary">Submit</button>
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
				url:'${pageContext.request.contextPath}/test-demo4/'+product_id,
				success:function(result)
				{
					var result=JSON.parse(result);
					/* console.log(result); */
					document.getElementById("selling_price").setAttribute('value',result.selling_price);
					document.getElementById("wholesale_price").setAttribute('value',result.wholesale_price);
					if(result.Expiry_date==null)
					{
						$("#Expiry_date").prop('disabled', true);
						$("#blankCheckbox").prop('checked', true);
						
					}
					else
					{
						$("#Expiry_date").prop('disabled', false);
						$("#blankCheckbox").prop('checked', false);
						document.getElementById("Expiry_date").setAttribute('value',result.Expiry_date);
					}
					
					document.getElementById("Arrival_date").setAttribute('value',result.Arrival_date);
					document.getElementById("minimum_quantity").setAttribute('value',result.minimum_quantity);
					document.getElementById("name").setAttribute('value',result.name);
					document.getElementById("Brand").setAttribute('value',result.Brand);
					document.getElementById("in_price").setAttribute('value',result.in_price);
					document.getElementById("in_quantity").setAttribute('value',result.in_quantity);
					document.getElementById("in_wholesale_price").setAttribute('value',result.in_wholesale_price);
					
				}
				
			});
			}
		
	});
});
</script>
<script >
$(document).ready(function(){
	$('#Available_quantity').change(function(){
		var quantity=$(this).val();
		var price=document.getElementById("wholesale_price").value;
		if(price.length>0)
			{
			document.getElementById("total").setAttribute('value',price*quantity);
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
					document.getElementById("selling_price").setAttribute('value',result);
					document.getElementById("total").setAttribute('value',document.getElementById("Available_quantity").value*document.getElementById("selling_price").value);
				}
				
			});
		}
		
	});
});


</script>
<script >
$(document).ready(function(){
	$('#wholesale_price').change(function(){
		var wholesaleprice=$(this).val();
		if(wholesaleprice.length>0)
		{
			
				document.getElementById("total").setAttribute('value',document.getElementById("Available_quantity").value*document.getElementById("wholesale_price").value);
		}
		
	});
});


</script>
</body>
</html>