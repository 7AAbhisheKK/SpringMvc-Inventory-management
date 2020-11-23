<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="./Dheader.jsp" %>
<meta charset="ISO-8859-1">
<%@include file="./base.jsp" %>
</head>
<body>
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
<div class="container mt-3">
	<div class="row">
		<div class="col-md-6 offset-md-3">
		<h1 class="text-center mb-3">Fill the product detail</h1>
		<form action="handle-add" method="post">
			<div class="form-group">
				<label for="name">Product Name</label>
				<input type="text" class="form-control" id="name" name="name" placeholder="Enter Product Name">
			</div>
			<div class="form-group">
				<label for="selling_price">Selling Price</label>
				<input type="text" class="form-control" id="selling_price" name="selling_price" placeholder="Enter Selling price">
			</div>
			<div class="form-group">
				<label for="wholesale_price">Wholesale Price</label>
				<input type="text" class="form-control" id="Wholesale_price" name="Wholesale_price" placeholder="Enter Wholesale price">
			</div>
			<div class="form-group">
				<label for="Arrival_date">Arrival Date</label>
				<input type="date" class="form-control" id="Arrival_date" name="Arrival_date">
			</div>
			<div class="form-group">
			  <input class="form-check-input position-static" type="checkbox" id="blankCheckbox" onclick="enable_disable()" aria-label="Expiry Date is not Applicable">
				<label for="Expiry_date">Expiry Date NOT Applicable</label>
				<input type="date" class="form-control" id="Expiry_date" name="Expiry_date">
			</div>
			<div class="form-group">
				<label for="Available_quantity">Available Quantity</label>
				<input type="text" class="form-control" id="Available_quantity" name="Available_quantity" placeholder="Enter the Available Quantity">
			</div>
			<div class="form-group">
				<label for="Brand">Brand</label>
				<input type="text" class="form-control" id="Brand" name="Brand" placeholder="Enter the Brand">
			</div>
			<div class="form-group">
				<label for="Product_id">Product Id</label>
				<input type="text" class="form-control" id="product_id" name="product_id" placeholder="Enter the Product ID">
			</div>
			<div class="form-group">
		    <label for="category">Category</label>
		    <select  class="form-control" id="category" name="category">
		    <option value="">-select option-</option>
		      <c:forEach items="${cat }" var="p">
		      <option value="${p.getCategory_id() }">${p.getCategory_name() }</option>
		      </c:forEach>
		    </select>
		  </div>
			<div class="form-group">
		    <label for="sub_category">Sub Category</label>
		    <select class="form-control" id="sub_category" name="sub_category">
		    </select>
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
				var s='';
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
</body>
</html>