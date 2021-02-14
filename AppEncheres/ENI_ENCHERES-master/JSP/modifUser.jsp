<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>modifier compte</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/CSS/style.css">
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
	integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
	integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js"
	integrity="sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s"	crossorigin="anonymous"></script>
	<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Montserrat+Subrayada:wght@700&family=Taviraj:wght@300&display=swap" rel="stylesheet">
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
					<li class="nav-item active">
						<a class="nav-link"	href="/ENI_Encheres/ServletAcceuil">Retour à l'acceuil</a>
						</li>
					<li class="nav-item">
						<a class="nav-link" href="/ENI_Encheres/ServletLogin">Se connecter</a>
					</li>
				</ul>
			</div>
		</nav>


		<h1>ENI Encheres</h1>
		<h2>Modifier profil</h2>

	</header>
	
	<form class="mx-auto" method="post" action="ServletModifierUser">
		<div class="row">
			<div class="col-6 mx-auto">
				<div class="form-group">
					<label for="pseudo" class="float-left">Pseudo</label> 
					<input name="pseudo" type="text" value="${sessionScope.user.pseudo}" class="form-control" id="pseudo">
				</div>
				<div class="form-group">
					<label  class="float-left"for="email">Email:</label> 
					<input name="email" type="email" value="${sessionScope.user.email}" class="form-control" id="email"> 
					<span class="erreur"></span>
				</div>
				<div class="form-group">
					<label class="float-left" for="nom">Nom :</label> 
					<input name="nom" type="text" value="${sessionScope.user.nom}"class="form-control" id="nom">
				</div>
				<div class="form-group">
					<label class="float-left" for="prenom">Prénom :</label> 
					<input name="prenom" type="text" value="${sessionScope.user.prenom}"class="form-control" id="prenom">
				</div>
				<div class="form-group">
					<label for="tel" class="float-left">Téléphone :</label> 
					<input name="tel" type="tel" value="${sessionScope.user.tel}" class="form-control" id="tel">
				</div>
				<div class="form-group">
					<label for="adresse" class="float-left">Adresse</label> 
					<input name="adresse" type="text"	value="${sessionScope.user.adresse}" class="form-control" id="inputAddress" placeholder="Votre adresse ici...">
				</div>
				<div class="form-group">
					<label for="adresse2" class="float-left">Complément d'adresse</label> 
					<input name="adresse2" type="text" value="${sessionScope.user.adresse2}" class="form-control" id="adresse2" placeholder="Apartement, maison, étage...">
				</div>
				<div class="form-group">
					<label for="ville" class="float-left">Ville</label> 
					<input name="ville" type="text"	value="${sessionScope.user.ville}" class="form-control" id="ville">
				</div>
				<div class="form-group">
					<label for="cp" class="float-left">Code postal</label> 
					<input name="cp" type="text" value="${sessionScope.user.cp}" class="form-control" id="cp">
				</div>
				<button class="btn btn-secondary" type="submit">Enregistrer</button>
				<a class="btn btn-dark" href="ServletAcceuil" type="reset">Quitter</a>
			</div>
			
		</div>
	</form>
	
	<footer>
		<div>
			<p>&copy; ENI Enchères - ZAC de la Conterie, 8 rue Léo Lagrange, 35131 Chartres-de-Bretagne</p>
		</div>
	</footer>
</div>

	
</body>
</html>