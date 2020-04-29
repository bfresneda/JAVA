<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Cadastro Casa de Show</title>
<spring:url value="/casadeshow/salvar" var="salvar"></spring:url>
<spring:url value="/casadeshow/alterar/" var="alterar"></spring:url>
<spring:url value="/casadeshow/deletar/" var="deletar"></spring:url>

<link  href='<spring:url value="/resources/css/bootstrap.css"/>' rel="stylesheet"/>
<script src='<spring:url value="/resource/js/jquery-3.5.0.min.js"/>'> </script>
<script src='<spring:url value="/resource/js/bootstrap.js"/>'> </script>
</head>

<body>
<jsp:include page="${request.contextPath}/menu"></jsp:include>

	<div class="container"> 
	
	<c:if test="${not empty mensagemErro}">
		<div id="divMensagemErro" class="alert alert-danger" role="alert">
			${mensagemErro}
		</div>
	</c:if>
	
	<c:if test="${not empty mensagemSucesso}">
	<div id="divMensagemSucesso" class="alert alert-success" role="alert">
		${mensagemSucesso}
	</div>
	</c:if>

	<div class="pb-2 mt-4 mb-2 border-bottom">
		<h1> Cadastrar - Casas de Shows </h1>
		
	</div>	

		<form:form action="${salvar}" cssClass="mb-2" modelAttribute="casadeshow" acceptCharset="UTF-8" enctype="multipart/form-data">
	<div class="form-row">
			<form:hidden path="id"/>
			<form:hidden path="imagemCasadeShow"/>
			<div class="form-group col-md-6">
				<label>Nome:</label>
				<form:input path="nome" cssClass="form-control"/>
			</div>
			
			<div>
				<c:if test="${casadeshow.id ne 0 }"> <!-- ira carregar a imagem quando selecionar o alterar -->
					<div class="col-6">
					<img class="img-thumbnail" src="data:image/jpge;base64,${imagemCasaDeShow }"	 alt="imagem não encontrada" >
					</div>
				</c:if>
			</div>
			
			<div class="form-group col-md-6">
			<label>Logradouro:</label>
			<form:input path="logradouro" cssClass="form-control"/>
			</div>
			
			<div class="form-group  col-md-2">
			<label>numero:</label>
			<form:input path="numero" cssClass="form-control"/>
			</div>
			
			<div class="form-group  col-md-4">
			<label>Bairro:</label>
			<form:input path="bairro" cssClass="form-control"/>
			</div>
			
			<div class="form-group col-md-4">
			<label>Cidade:</label>
			<form:input path="cidade" cssClass="form-control"/>
			</div>
			
			<div class="form-group col-md-4">
			<label>Estado</label>
			<form:input path="estado" cssClass="form-control"/>
			</div>
			
			<div class="form-group col-md-4">
			<label>Capacidade Total:</label>
			<form:input path="capacidadeTotal" cssClass="form-control"/>
			</div>

			<div class="form-group">
				<label>Imagem</label>
				<div class="custom-file">
					<input type="file" name="imagemCasaDeShow" class="custom-file-input col-md-12" value="${imagemCasadeshow}"/>
					<label class="custom-file-label">Escolha uma imagem</label>
				</div> 
			</div>
</div>
			<div>
			<input	class ="btn btn-primary mt-3 mr-2" type="submit" name="Salvar" value="${casadeshow.id == 0 ? 'Cadastrar' : 'Alterar'}"/>
			
			<c:if test="${casadeshow.id ne 0}">
			<input class ="btn btn-secondary p-1 mt-3" type="submit" name="Cancelar" value="Cancelar" /> 
			</c:if> <!--  só mostra o botão se o ID for diferente de 0 -->
			</div>
			
		</form:form>

	 <c:if test="${not empty casasdeshows}"> <!-- só mostra a lista se existir registro na tabela-->
	<table class="table table-hover table-sm mt-4">
		<tr>
			<th>#</th>
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
				<td><a href="${alterar}${casadeshow.id}" class="btn btn-warning m-1">Alterar</a></td>
			 	<td><a href="${deletar}${casadeshow.id}" class="btn btn-danger m-1" onclick="return confirm('Desejar apagar a Casa de Show ${casadeshow.nome} ?')">Deletar</a></td>
			</tr>
		</c:forEach>
	</table>	 
	 </c:if>
	 
	 <script type="text/javascript">
	 	$(document).ready(function(){
	 		//na divMensagemErro terá uma espera de 5s, e sumira com efeito de fadeout
	 		$('#divMensagemErro').delay(5000).fadeOut('slow'); 	
	 		$('#divMensagemSucesso').delay(5000).fadeOut('slow'); 	
	 	});
	 </script>
	 
</div>
	
</body>
</html>