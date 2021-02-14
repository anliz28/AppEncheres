<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="fr.eni.encheres.bll.UserManager"%>


<!DOCTYPE html >
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Connection ENI Enchères</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
	integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
	integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js"
	integrity="sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s"
	crossorigin="anonymous"></script>

<link rel="preconnect" href="https://fonts.gstatic.com">
<link
	href="https://fonts.googleapis.com/css2?family=Montserrat+Subrayada:wght@700&family=Taviraj:wght@300&display=swap"
	rel="stylesheet">
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/CSS/style.css">


</head>

<body>
	<div class="container-fluid">
		<header>
			<nav class="navbar navbar-expand-lg navbar-light bg-light">

				<button class="navbar-toggler" type="button" data-toggle="collapse"
					data-target="#navbarSupportedContent"
					aria-controls="navbarSupportedContent" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>

				<div class="collapse navbar-collapse" id="navbarSupportedContent">
					<ul class="navbar-nav mr-auto">
						<li class="nav-item active"><a class="nav-link"
							href="/ENI_Encheres/ServletAcceuil">Retour à l'acceuil</a></li>
						<li class="nav-item"><a class="nav-link"
							href="/ENI_Encheres/ServletInscription">S'inscrire</a></li>
					</ul>
				</div>
			</nav>
			<h1>ENI Encheres</h1>

		</header>
		<h4>Veuillez entrer vos identifiants de connection</h4>
		<form class="mx-auto" method="post" action="ServletLogin">
			<div class="row">
				<div class="col-6 mx-auto">
					<div class="form-group">
						<label for="pseudo" class="float-left">Pseudo</label> <input
							name="pseudo" type="text" class="form-control" id="pseudo">
					</div>
					<div class="form-group">
						<label class="float-left" for="email">Mot de passe</label> <input
							name="mdp" type="password" class="form-control" id="mdp">
						<span class="erreur"></span>
					</div>
				</div>
			</div>
			<div class="form-group">
				<div class="form-check">
					<input class="form-check-input" value="RememberMe" type="checkbox"
						id="RememberMe"> <label class="form-check-label"
						for="RememberMe"> Se souvenir de moi </label>
				</div>
			</div>

			<div>
				<button class="btn btn-secondary" type="submit">Se connecter</button>
			
			</div>	
	</form>
		<div>
			<a class="btn btn-dark" href="/ENI_Encheres/ServletInscription">S'inscrire</a>
		</div>

	<div
		<c:if test="${!empty sessionScope.pseudo && !empty sessionScope.mdp}">
			<p>Bonjour ${user.nom}</p>
		</c:if>
		<c:out value="${user.nom }"></c:out>></div>


	<footer>

		<div>
			<p>&copy; ENI Enchères - ZAC de la Conterie, 8 rue Léo Lagrange,
				35131 Chartres-de-Bretagne</p>

		</div>

	</footer>
	</div>
</body>


</html>