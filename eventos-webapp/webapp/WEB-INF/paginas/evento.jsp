<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastro Evento</title>

<spring:url value="/evento/salvar" var="salvar"></spring:url>
<spring:url value="/evento/alterar/" var="alterar"></spring:url>
<spring:url value="/evento/deletar/" var="deletar"></spring:url>

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
		<h1> Cadastrar - Eventos </h1>
		
	</div>	

		<form:form action="${salvar}" cssClass="mb-2" modelAttribute="evento" acceptCharset="UTF-8" enctype="multipart/form-data">
	<div class="form-row">
			<form:hidden path="id"/>
			<form:hidden path="imagemEvento"/>
			<div class="form-group col-md-6">
				<label>Nome:</label>
				<form:input path="nome" cssClass="form-control"/>
			</div>
			
			<div>
				<c:if test="${evento.id ne 0 }"> <!-- ira carregar a imagem quando selecionar o alterar -->
					<div class="col-6">
					<img class="img-thumbnail" src="data:image/jpge;base64,${imagemEvento }"	 alt="imagem não encontrada" >
					</div>
				</c:if>
			</div>
			
			<div class="form-group col-md-6">
			<label>Descrição:</label>
			<form:input path="descricao" cssClass="form-control"/>
			</div>
			
			<div class="form-group  col-md-2">
			<label>Data:</label>
			<form:input type="Date" path="data" cssClass="form-control"/>
			</div>
			
			<div class="form-group  col-md-4">
			<label>Quantidade de Ingressos:</label>
			<form:input path="quantidadeIngressos" cssClass="form-control"/>
			</div>
			
			<div class="form-group col-md-4">
			<label>Preço:</label>
			<form:input path="preco" type="" cssClass="form-control"/>
			</div>


			<div class="form-group col-md-4">
			<form:select path="CasaDeShow" id="CasaDeShow"> 
				<form:option value="NONE">---SELECIONE---</form:option> 
					<c:forEach items="${ListaCasasDeShows}" var="CasaDeShow"> 
				<form:option value="${CasaDeShow.id}">${CasaDeShow.nome}</form:option> 
			</c:forEach> </form:select>
			</div>	

			
<!-- 			<div class="form-group col-md-4">
		<label>Casa de Show:</label>
				<select name="ListaCasasDeShows">
						<option selected > Selecione a casa:</option>
					<c:forEach  var="CasaDeShow" items="${ListaCasasDeShows}">
						<option value ="${CasaDeShow.id}"> ${CasaDeShow.nome}</option>
					</c:forEach>
				</select>
			</div>  -->
  			
<!--			<div class="form-group">
				<label>Imagem</label>
				<div class="custom-file">
					<input type="file" name="imagemEvento" class="custom-file-input col-md-8" value="${imagemEvento}"/>
					<label class="custom-file-label">Escolha uma imagem</label>
				</div> 
			</div> -->
</div>
			<div>
				<input	class ="btn btn-primary mt-3 mr-2" type="submit" name="Salvar" value="${evento.id == 0 ? 'Cadastrar' : 'Alterar'}"/>
				
				<c:if test="${evento.id ne 0}">
				<input class ="btn btn-secondary p-1 mt-3" type="submit" name="Cancelar" value="Cancelar" /> 
				</c:if> <!--  só mostra o botão se o ID for diferente de 0 -->
			</div>
			
		</form:form>

	 <c:if test="${not empty eventos}"> <!-- só mostra a lista se existir registro na tabela-->
	<table class="table table-hover table-sm mt-4">
		<tr>
			<th>#</th>
			<th>Nome</th>
			<th>Data</th>
			<th>Quantidade de Ingressos</th>
			<th colspan="2">Ações</th>		
		</tr>
		<c:forEach var="evento" items="${eventos}">
			<tr>
				<td>${evento.id}</td>
				<td>${evento.nome}</td>
				<td>${evento.data}</td>
				<td>${evento.quantidadeIngressos}</td>
				<td><a href="${alterar}${evento.id}" class="btn btn-warning m-1">Alterar</a></td>
			 	<td><a href="${deletar}${evento.id}" class="btn btn-danger m-1" onclick="return confirm('Desejar apagar o evento${evento.nome} ?')">Deletar</a></td>
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