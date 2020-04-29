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
	<jsp:include page="${request.contextPath}/menu"></jsp:include>
		

		

		<a href="${casadeshow}"> Cadastrar Casas de show</a>
	
</body>
</html>