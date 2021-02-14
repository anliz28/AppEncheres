<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="fr.eni.encheres.bll.UserManager"%>

<!DOCTYPE html>
<html>


<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Acceuil ENI Enchères</title>
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
	<link type="text/css" href="/ENI_Encheres/CSS/style.css">
	<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Montserrat+Subrayada:wght@700&family=Taviraj:wght@300&display=swap" rel="stylesheet">
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/CSS/style.css">
	
</head>



<body>
	<div class="container-fluid">
		<nav class="navbar navbar-expand-lg navbar-light bg-light">
			<a class="navbar-brand" href="ServletEncheres">ENI Encheres</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			
			
		<c:if test="${empty sessionScope.user.id}" >
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav mr-auto float-right">
					<li class="nav-item active"><a class="nav-link"
						href="/ENI_Encheres/ServletInscription">S'inscrire</a></li>
					<li class="nav-item"><a class="nav-link" href="/ENI_Encheres/ServletLogin">Se connecter</a></li>
				</ul>
			</div>
			</c:if>
		</nav>
	
	<div>
		<c:if test="${!empty sessionScope.user.id}" >
				<p>Bienvenue  ${sessionScope.user.pseudo}</p>
				<a href="ServletUser">Accès à mon compte</a>
				<a href="ServletDeconnexion">Déconnexion</a>
		</c:if>
	</div>
	
	
	<header>
		<h1>ENI Encheres</h1>
		<h2>Liste des enchères</h2>
	</header>
	
	<form method="post" action="ServletAcceuil">
	
		<div class="row">
			<div class="col-6 mx-auto">
				<div class="form-group">
					<label  for="pseudo" class="float-left" >Rechercher utilisateur</label> 
					<input class="form-control" name="pseudo" type="text" placeholder="Veuillez entrer le pseudo du profil rechercher">
					<button class="btn btn-secondary" type="submit">Rechercher</button>
				</div>
			</div>
		</div>
	</form>

	<form>
		<div class="row">
			<div class="col-6 mx-auto">
				<label for="nomArticle" class="float-left" >Rechercher un article :</label> 
				<input class="form-control"	type="text" placeholder="Saisissez l'article rechercher">
			</div>
		</div>

		<div class="row">
			<div class="col-6 mx-auto">
				<label for="categories" class="float-left" >Catégorie de l'article</label> <select id="categories"
					class="form-control">
					<option selected>Informatique</option>
					<option>Vêtements</option>
					<option>Ameublement</option>
					<option>Sport&Loisirs</option>
				</select>
			</div>
		</div>
		<div>
			<div>
				<button type="submit" class="btn btn-secondary">Rechercher</button>
			</div>
		</div>
	</form>

	<div>
	<aside>
	<div> 
	<p>enchère1 en cours......</p>
	</div>
	</aside>
	<aside>
	<div> 
	<p>enchère2 en cours......</p>
	</div>
	</aside>
		
	</div> 

	<footer>
		<div>
			<p>&copy; ENI Enchères - ZAC de la Conterie, 8 rue Léo Lagrange, 35131 Chartres-de-Bretagne</p>
		</div>
	</footer>
</div>
</body>

</html>