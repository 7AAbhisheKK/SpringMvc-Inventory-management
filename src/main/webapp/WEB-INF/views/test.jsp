<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="./base.jsp" %>
</head>
<body>
<script>
	$(document).ready(function(){
		$('#category').change(function(){
			var cat_id=$(this).val();
			console.log(cat_id,cat_id.length)
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
				},
				error:function()
				{
					var s='';
					s='<option id="sub_cat" value=""></option>';
					$('#sub_category').html(s);
				}
			});
		}});
	});



</script>
<div class="container mt-3">
	<div class="row">
		<div class="col-md-6 offset-md-3">
		<h1 class="text-center mb-3">Fill the product detail</h1>
		<form action="" method="post">
			<div class="form-group">
		    <label for="category">Category</label>
		    <select class="form-control" id="category" name="category" >
		      <c:forEach items="${cat }" var="p">
		      <option value="${p.getCategory_id() }">${p.getCategory_name() }</option>
		      </c:forEach>
		    </select>
		  </div>
		  <div class="form-group">
		    <label for="sub_category">Sub Category</label>
		    <select class="form-control" id="sub_category" name="sub_category" >
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
</body>   
  
</html>
</body>
</html>