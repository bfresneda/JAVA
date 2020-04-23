<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<title>Eventos Qintess</title>
<spring:url value="casadeshow/" var="casadeshow"></spring:url>
</head>
<body>
	<h1> Hello World! index eventos</h1>
	<hr />
	<a href="${casadeshow}"> Cadastrar Casas de show</a>
	
</body>
</html>