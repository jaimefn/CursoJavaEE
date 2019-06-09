<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta http-equiv="pragma" content="no-cache">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>${titulo}</title>

<jsp:include page="IncludeBootStrap.jsp" />

</head>
<body>

	<jsp:include page="IncludeCabecalho.jsp" />

	<div id="main" class="container-fluid">
		<br>
		<div class="row">
			<div class="col-md-12 col-md-offset-0">
				<h3 class="page-header">${titulo}</h3>
			</div>
		</div>
		<form action="Contatos" method="post">

			<input type="hidden" class="form-control" id="acao" name="acao" value="SalvarContato"> 
			<input type="hidden" class="form-control" id="usuarioId" name="usuarioId" value="${contato.getUsuarioId()}"> 
			<input type="hidden" class="form-control" id="contatoId" name="contatoId" value="${contato.getId()}"> 
			
			<div class="row">
				<div class="form-group col-md-4 col-md-offset-4">
					<label for="nome">Nome</label> <input type="text"
						class="form-control" id="nome" name="nome" value="${contato.getNome()}">
				</div>
			</div>
			<div class="row">
				<div class="form-group col-md-4 col-md-offset-4">
					<label for="email">Email</label> <input type="email"
						class="form-control" id="email" name="email" value="${contato.getEmail()}">
				</div>
			</div>
			<div class="row">
				<div class="form-group col-md-2 col-md-offset-4">
					<label for="telefone">Telefone</label> <input type="text"
						class="form-control" id="telefone" name="telefone"  value="${contato.getTelefone()}">
				</div>
				<div class="form-group col-md-2 col-md-offset-0">
					<label for="nascimento">Data de Nascimento</label> <input
						type="date" class="form-control" id="nascimento" name="dataNascimento" value="${contato.getDataNascimento() }">
				</div>

			</div>
			<div class="row">
				<div class="form-group col-md-4 col-md-offset-4">
					<label for="endereco">Endereco</label> <input type="text"
						class="form-control" id="endereco" name="endereco" value="${contato.getEndereco()}">
				</div>
			</div>

			<div class="row">
				<div class="form-group col-md-4 col-md-offset-4">
					<label for="redeSocial">Rede Social</label> <input type="text"
						class="form-control" id="redeSocial"  name="redeSocial" value="${contato.getRedeSocial()}">
				</div>
		
			</div>
			<hr />
			<div id="actions" class="row">
				<div class="col-md-4 col-md-offset-4">
					<button type="submit" class="btn btn-primary">Salvar</button>
					<a
						href="Contatos?acao=ListarContatos&usuarioId=${contato.getUsuarioId()}"
						class="btn btn-default">Cancelar</a>
				</div>
			</div>
		</form>


	</div>
	<jsp:include page="IncludeRodaPe.jsp" />
</body>
</html>
