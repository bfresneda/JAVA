<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastro Casa de Show</title>
<spring:url value="/casadeshow/salvar" var="salvar"></spring:url>
<spring:url value="/casadeshow/alterar/" var="alterar"></spring:url>
<spring:url value="/casadeshow/deletar/" var="deletar"></spring:url>
</head>
<body>
	<h2> Cadastrar Casas de Show</h2>
	<hr/> 
	<form:form action="${salvar}" modelAttribute="casadeshow" accept-charset="UTF-8">
			
			<form:hidden path="id"/>

			<label>Nome:</label>
			<form:input path="nome"/><br/>
			<hr>
			<label>Logradouro:</label>
			<form:input path="logradouro"/>
			
			<label>numero:</label>
			<form:input path="numero"/><br/>
			<hr>
			<hr>
			<label>Bairro:</label>
			<form:input path="bairro"/>
			
			<label>Cidade:</label>
			<form:input path="cidade"/>
			
			<label>Estado</label>
			<form:input path="estado"/><br/>
			<hr>
			<hr>
			<label>Capacidade Total:</label>
			<form:input path="capacidadeTotal"/><br/>
			<hr>
			<form:button>Cadastrar</form:button>
	</form:form>
	<hr/>
	 
	<table>
		<tr>
			<th>Id</th>
			<th>Nome</th>
			<th>Logradouro</th>
			<th>Capacidade</th>
			<th colspan="2">Ações</th>		
		</tr>
		<c:forEach var="casadeshow" items="${casasdeshows}">
			<tr>
				<td>${casadeshow.id}</td>
				<td>${casadeshow.nome}</td>
				<td>${casadeshow.logradouro}</td>
				<td>${casadeshow.capacidadeTotal}</td>
				<td><a href="${alterar}${casadeshow.id}">Alterar</a></td>
				<td><a href="${deletar}${casadeshow.id}">Deletar</a></td>
			</tr>
		</c:forEach>
	</table>
	
</body>
</html>