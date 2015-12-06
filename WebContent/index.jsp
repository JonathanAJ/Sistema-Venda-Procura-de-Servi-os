<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
	<meta charset="UTF-8">
	<title>Venda de Serviços</title>
	<link rel="stylesheet" href="bootstrap-3.3.6/css/bootstrap.min.css"/>
</head>
<body>
	<div class="container">
		<div class="row">
		<nav class="navbar navbar-default">
			<div class="container-fluid">
				<div class="navbar-header">
					<a class="navbar-brand" href="/Sistema-Venda-Procura-de-Servicos/">
						Sistema de Venda e Procura de Serviços
					</a>
				</div>
				<form method="POST" action="Login" class="navbar-form navbar-right">
					<div class="form-group">
						<input type="text" name="login" class="form-control" placeholder="Login">
						<input type="password" name="senha" class="form-control" placeholder="Senha">
					</div>
					<button type="submit" class="btn btn-default">Entrar</button>
				</form>
			</div>
		</nav>
		</div>
	</div>
	<script src="bootstrap-3.3.6/js/bootstrap.min.js"></script>
</body>
</html>