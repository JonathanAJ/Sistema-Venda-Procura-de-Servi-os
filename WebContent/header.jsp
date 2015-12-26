<%@ page import="com.projeto.controller.*" %>
<%@ page import="com.projeto.model.*" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
	<meta charset="UTF-8">
	<title>Venda de Serviços</title>
	<!--Import Google Icon Font-->
	<link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
	<!--Import materialize.css-->
	<link type="text/css" rel="stylesheet" href="materialize/css/materialize.min.css"  media="screen,projection"/>
	<link type="text/css" rel="stylesheet" href="css/index.css"/>
	<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
</head>
<body>
	<div class="navbar-fixed">
		<nav class="indigo">
			<div class="nav-wrapper container">
				<a href="/Sistema-Venda-Procura-de-Servicos/" class="brand-logo center">ServLibeR</a>
				<ul id="nav-mobile" class="left hide-on-med-and-down">
			        <li><a href="#" class="waves-effect"><i class="material-icons tiny left">stars</i>Cadastrar</a></li>
			        <li><a href="#" class="waves-effect">Sobre</a></li>
				</ul>
				<ul id="nav-mobile" class="right hide-on-med-and-down">
			        <li><a href="#loginModal" class="waves-effect modal-trigger"><i class="material-icons tiny left">perm_identity</i>Login</a></li>
				</ul>
			</div>
		</nav>
	</div>
	<nav class="indigo lighten-2 ">
		<div class="nav-wrapper container">
			<form>
				<div class="input-field">
					<input id="search" type="search" required placeholder="Busque o serviço desejado...">
					<label for="search"><i class="material-icons">search</i></label>
					<i class="material-icons">close</i>
				</div>
			</form>
		</div>
	</nav>
	<div class="container">	