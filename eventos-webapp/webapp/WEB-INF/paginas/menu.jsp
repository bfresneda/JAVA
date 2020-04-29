<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link  href='<spring:url value="/resources/css/bootstrap.css"/>' rel="stylesheet"/>
<script src='<spring:url value="/resource/js/jquery-3.5.0.min.js"/>'> </script>
<script src='<spring:url value="/resource/js/bootstrap.js"/>'> </script>

<!--  links menu  -->
<spring:url value="/" var="home"></spring:url>
<spring:url value="/casadeshow/" var="casadeshow"></spring:url>
<spring:url value="/evento/" var="evento"></spring:url>
</head>
<body>

<nav class="navbar navbar-expand-lg navbar-light" style="background: -webkit-linear-gradient(left, #be29ce 0%,#e5a97b 100%);">
  <a class="navbar-brand" href="#">Eventos Qintess</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="container collapse navbar-collapse" id="navbarSupportedContent">
    <ul class=" navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="${home}">Home <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="${casadeshow}">Cadastrar Casa de Show</a>
      </li>
            <li class="nav-item">
        <a class="nav-link" href="${evento}">Cadastrar Evento</a>
      </li>
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Dropdown
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
          <a class="dropdown-item" href="#">Action</a>
          <a class="dropdown-item" href="#">Another action</a>
          <div class="dropdown-divider"></div>
          <a class="dropdown-item" href="#">Something else here</a>
        </div>
      </li>
    </ul>
  </div>
</nav>

</body>
</html>