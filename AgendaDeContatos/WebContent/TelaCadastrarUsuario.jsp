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
<title>Cadastrar Usuario</title>

<jsp:include page="IncludeBootStrap.jsp" />

</head>
<body>
		
	<div id="main" class="container-fluid">
		<br>
		<div class="row">
			<div class="col-md-12 col-md-offset-0">
				<h3 class="page-header">Adicionar Usuário</h3>
			</div>
		</div>
		<form action="CadastrarUsuario" method="post">
			<input type="hidden"
						class="form-control" id="acao" value="Cadastrar" name="acao" >
			<input type="hidden"
						class="form-control" id="id" value="" name="id" >

			<div class="row">
				<div class="form-group col-md-4 col-md-offset-4">
						<label for="nome">Nome</label> <input type="text"
						class="form-control" id="nome" name="nome" placeholder="digite seu nome">
				</div>
			</div>
			<div class="row">
				<div class="form-group col-md-4 col-md-offset-4">
					<label for="email">Email</label> <input type="email"
						class="form-control" id="email" name="email" placeholder="email@algo.com.br">
				</div>
			</div>
			<div class="row">
				<div class="form-group col-md-2 col-md-offset-4">
					<label for="telefone">Telefone</label> <input type="text"
						class="form-control" id="telefone" name="telefone" placeholder="(ddd)xxxxx-xxxx">
				</div>
				<div class="form-group col-md-2 col-md-offset-0">
					<label for="dataNascimento">Data de Nascimento</label> <input
						type="date" class="form-control" id="dataNascimento" name="dataNascimento"
						placeholder="dd/mm/aaaa">
				</div>

			</div>
			<div class="row">
				<div class="form-group col-md-4 col-md-offset-4">
					<label for="endereco">Endereco</label> <input type="text"
						class="form-control" id="endereco" name="endereco"
						placeholder="rua da felicidade, n - bairro, cidade, UF">
				</div>
			</div>

			<div class="row">
				<div class="form-group col-md-2 col-md-offset-4">
					<label for="usuario">Usuario</label> <input type="text"
						class="form-control" id="usuario" name="usuario" placeholder="usuario">
				</div>
				<div class="form-group col-md-2 col-md-offset-0">
					<label for="senha">Senha</label> <input type="password"
						class="form-control" id="senha" name="senha"
						placeholder="no min 8 e max 20 caracteres">
				</div>
			</div>
			<hr />
			<div id="actions" class="row">
				<div class="col-md-4 col-md-offset-4">
					<button type="submit" class="btn btn-primary">Salvar</button>
					<a href="index.jsp" class="btn btn-default">Cancelar</a>
				</div>
			</div>
		</form>


	</div>


<jsp:include page="IncludeRodaPe.jsp"/>
</body>
</html>
