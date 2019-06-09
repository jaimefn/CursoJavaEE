<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta http-equiv="pragma" content="no-cache">
<meta charset="ISO-8859-1">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Seja Bem Vindo!</title>

<jsp:include page="IncludeBootStrap.jsp" />

</head>
<body>

	<jsp:include page="IncludeCabecalho.jsp" />

	<div class="container">
		<div class="jumbotron" style="margin-top: 100px">
			<h2 class="page-header">Seja Bem Vindo !</h2>
			<hr />
			<p></p>
			<p>${nome},Estamos muito felizes em ter você aqui conosco, seu
				cadastro foi realizado com sucesso!</p>
			<hr />
			
			<c:url value="Contatos" var="urlContatos" >
			<c:param name="acao" value="ListarContatos" />
			<c:param name="usuarioId" value="${id}" />
			</c:url>
			
			<a href="${urlContatos}"
				class="btn btn-success">Comece a criar seus contatos agora
				mesmo!!!</a>
		</div>
	</div>

	<jsp:include page="IncludeRodaPe.jsp" />
</body>
</html>