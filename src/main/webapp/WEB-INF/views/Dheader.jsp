<html>
<head>
</head>
<header>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="${pageContext.request.contextPath}">Home <span class="sr-only">(current)</span></a>
    </ul>
  </div>
  <div class="my-2 my-lg-0">
  <a class="nav-link" href="${pageContext.request.contextPath}/user/${name}"><i class="icon-signout"></i>${name }</a>
  </div>
  <div class="my-2 my-lg-0">
  <a class="nav-link" href="${pageContext.request.contextPath}/logout"><i class="icon-signout"></i>Logout</a>
  </div>
</nav>
</header>
<body>
</body>

</html>
