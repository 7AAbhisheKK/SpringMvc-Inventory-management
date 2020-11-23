<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="./base.jsp" %>
</head>
<%@include file="./Dheader.jsp" %>
<body>
<div class="container mt-3">
	<div class="row">
		<div class="col-md-6 offset-md-3">
		<h1 class="text-center mb-3">Choce the options</h1>
		<form>
			<div class="form-group">
		    <label for="category">Category</label>
		    <select  class="form-control" id="category" name="category" required>
		    <option value="">-select option-</option>
		      <c:forEach items="${category }" var="p">
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
			<div class="container text-center">
				<a href="${pageContext.request.contextPath}/" class ="btn btn-outline-danger">Back</a>
				<a href="" class ="btn btn-secondary" id="btn">Submit</a>
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
<script>
$(document).ready(function(){
	$('#product_id').change(function(){
		var product_id=$(this).val();
		if(product_id.length>0)
			{
				document.getElementById("btn").href="search-product/"+product_id; 
			}
		
	});
});
</script>


</body>
</html>