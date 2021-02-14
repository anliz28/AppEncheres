<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Mon compte</title>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/CSS/style.css">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">
<link type="text/css" rel="stylesheet" src="style.css">
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
	integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/poppnomer.js@1.16.1/dist/umd/popper.min.js"
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
</head>


<body>

	
	<header>
	
	<a href="ServletDeconnexion">Déconnexion</a>
	<a href="ServletAcceuil">Retour aux enchères</a>
	<a href="ServletNouvelleVente">Créer une enchère</a>
	

</header>

<h1>Bienvenue  ${sessionScope.user.pseudo}</h1>
	<h3>${sessionScope.user.nom} ${sessionScope.user.prenom}</h3><br>
	<p>${sessionScope.user.adresse} ${sessionScope.user.adresse2}</p><br>
	<p>${sessionScope.user.cp} ${sessionScope.user.ville}</p><br>
	<p> Email : ${sessionScope.user.email}</p><br>
	<p> Téléphone : ${sessionScope.user.tel}</p><br>
	<p>Crédit : ${sessionScope.user.credit} points</p><br>
				
<div><a class="btn btn-secondary" href="ServletModifierUser" >Modifier profil</a></div><br>
<div><a class="btn btn-dark" href="ServletSupprimerUser" >Supprimer profil</a></div>

<footer>
		<div>
			<p>&copy; ENI Enchères - ZAC de la Conterie, 8 rue Léo Lagrange, 35131 Chartres-de-Bretagne</p>
		</div>
	</footer>
</body>


</html>