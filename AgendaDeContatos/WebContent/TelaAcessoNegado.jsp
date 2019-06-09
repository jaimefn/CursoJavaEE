<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Acesso Negado</title>

<style>
body {
font-family: Arial, Helvetica, sans-serif;
color: gray;
} 

a {
  background-color: #4CAF50;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 100%;
  text-decoration: none;
}

a:hover {
  opacity: 0.8;
}

.btnBack {
  width: auto;
  padding: 10px 18px;
  background-color: #f44336;
}

.imgcontainer {
  text-align: center;
  margin: 24px 0 12px 0;
}

img.avatar {
  width: 7%;
  border-radius: 50%;
}
p{
padding: 16px;
}
.container {
	width: 50%;
	border: 3px solid #f1f1f1;
	background-color: #f1f1f1;
  	padding: 26px;
  
}

/* Change styles for span and cancel button on extra small screens */
@media screen and (max-width: 300px) {
  .btnBack {
     width: 100%;
  }
}
</style>
</head>
<body>
	<center>
	<div class="container">
	<div class="imgcontainer">
		<img src="resources\images\cadeado.png" alt="cadeado">
	</div>
		<h3>ACESSO NÃO AUTORIZADO</h3>
		<P>Verifique se digitou corretamente seu usuário e senha, se persistir o problema entre em contato conosco</P>
		<a href="index.jsp">Voltar a Pagina Inicial</a>
	</div>
	</center>
</body>
</html>