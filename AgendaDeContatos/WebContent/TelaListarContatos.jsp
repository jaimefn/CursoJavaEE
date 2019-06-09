<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista de Contatos</title>
<jsp:include page="IncludeBootStrap.jsp" />
</head>
<body>
	<jsp:include page="IncludeCabecalho.jsp" />
	<div class="container">
		<br> <br>
		<h3 = class="page-header">Lista de Contatos</h3>
		<form>
			<div class="input-group">
				<input type="text" class="form-control" placeholder="Pesquisa">
				<div class="input-group-btn">
					<button class="btn btn-default" type="submit">
						<i class="glyphicon glyphicon-search"></i>
					</button>
				</div>
			</div>
		</form>

		<table class="table" style="margin-top: 20px">
			<thead>
				<tr>
					<th>Nome</th>
					<th>Endereco</th>
					<th>Telefone</th>
					<th>Email</th>
					<th>Editar</th>
					<th>Excluir</th>
					<th>Novo</th>
				</tr>
			</thead>
			<tbody>

				<c:forEach var="contato" items="${contatos}">

					<tr>
						<td>${contato.getNome()}</td>
						<td>${contato.getEndereco()}</td>
						<td>${contato.getTelefone()}</td>
						<td>${contato.getEmail()}</td>
						<td><a class="btn btn-default"
							href="Contatos?acao=EditarContato&contatoId=${contato.getId()}"><span
								class="glyphicon glyphicon-pencil"></span></a></td>
						<td><a class="btn btn-danger"
							href="Contatos?acao=ExcluirContato&contatoId=${contato.getId()}"><span
								class="glyphicon glyphicon-trash"></span></a></td>
						<td></td>
					</tr>
				</c:forEach>
				<tr>
<td></td><td></td><td></td><td></td><td></td><td></td>
					<td><a class="btn btn-success"
						href="Contatos?acao=CriarContato&usuarioId=${usuarioId}"><span
							class="glyphicon glyphicon-plus"></span></a></td>
				</tr>
			</tbody>
		</table>
	</div>

	<jsp:include page="IncludeRodaPe.jsp" />

</body>
</html>