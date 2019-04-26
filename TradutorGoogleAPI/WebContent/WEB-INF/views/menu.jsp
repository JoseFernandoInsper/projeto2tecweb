<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>Tradutor</title>
		<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
		<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
		<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	</head>
<body>
	<h2 class="card-title text-center mb-4 mt-1">Tradutor</h2>
	<p class="text-center">Bem vindo, ${usuarioLogado}</p>
	<div class="container">
		<div class="row">
		
			<div class="card">
				<form action="traduzir" method="post" >
					<div class="form-group">
					<p class="text-success text-center"> idioma</p>
					<div class="input-group">
					<div class="input-group-prepend">
					<input name="descricao" type="text">
					</div>
					</div>
					</div>
					<button type="submit" value="traduzir" class="btn btn-primary btn-block"> traduzir  </button>
				</form>
			</div>
		</div>
	</div>
 
 
 
 
 
 <a href="logout">Sair do sistema</a>
</body>
</html>