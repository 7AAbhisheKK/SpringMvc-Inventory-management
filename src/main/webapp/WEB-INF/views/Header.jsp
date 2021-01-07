<html>
<head>
</head>
<header>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="${pageContext.request.contextPath}">Home <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="${pageContext.request.contextPath}/cashier/cart"><i class="fas fa-shopping-cart"></i>Cart</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="${pageContext.request.contextPath}/admin/add-maintenance">add maintenance</a>
      </li>
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Products
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
          <a class="dropdown-item" href="${pageContext.request.contextPath}/staff/out-stock">Out of stock in store</a>
          <a class="dropdown-item" href="${pageContext.request.contextPath}/staff/out-stock-ware">Out of stock in warehouse</a>
          <a class="dropdown-item" href="${pageContext.request.contextPath}/staff/add-product">Add product</a>
          <a class="dropdown-item" href="${pageContext.request.contextPath}/staff/add-category">Add Category</a>
          <a class="dropdown-item" href="${pageContext.request.contextPath}/staff/add-sub-category">Add Sub category</a>
          <div class="dropdown-divider"></div>
          <a class="dropdown-item" href="${pageContext.request.contextPath}/staff/handle-product-order">New arrival</a>
          <a class="dropdown-item" href="${pageContext.request.contextPath}/staff/search-product">Search Product or update product</a>
        </div>
      </li>
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Expired Product
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
          <a class="dropdown-item" href="${pageContext.request.contextPath}/staff/expired">Expired Product In stock</a>
          <a class="dropdown-item" href="${pageContext.request.contextPath}/staff/expired2">Expired Product In Warehouse</a>
          <a class="dropdown-item" href="${pageContext.request.contextPath}/staff/expiring-soon">Expiring In</a>
        </div>
      </li>
        <li class="nav-item">
        <a class="nav-link" href="${pageContext.request.contextPath}/admin/sale">Sale</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="admin/employee">Employee</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="${pageContext.request.contextPath}/admin/search-order">Order detail</a>
      </li>
    </ul>
  </div>
  <div class="my-2 my-lg-0">
  <a class="nav-link" href="${pageContext.request.contextPath}/register"><i class="fa fa-registered" aria-hidden="true"></i>Register</a>
  </div>
  <div class="my-2 my-lg-0">
  <a class="nav-link" href="user/${name}"><i class="icon-signout"></i>${name }</a>
  </div>
  <div class="my-2 my-lg-0">
  <a class="nav-link" href="${pageContext.request.contextPath}/logout"><i class="icon-signout"></i>Logout</a>
  </div>
</nav>
</header>
<body>
</body>

</html>
