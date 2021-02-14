<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Nouvelle vente</title>
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
			<c:if test="${empty sessionScope.user.id}" >
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav mr-auto float-right">
					<li class="nav-item active"><a class="nav-link" href="ServletUser">Accès à mon compte</a></li>
					<li class="nav-item"><a class="nav-link" href="/ENI_Encheres/ServletAcceuil">Retour à l'acceuil</a></li>
				</ul>
			</div>
		</c:if>
		</nav>
		
	<div>
		<c:if test="${!empty sessionScope.user.id}" >
				<p>Bienvenue  ${sessionScope.user.pseudo}</p>
				<a href="ServletDeconnexion">Déconnexion</a>
		</c:if>
	</div>
	<form method="post" action="ServletNouvelleVente">
	
		<div class="row">
			<div class="col-6 mx-auto">
				<div class="form-group">
					<label  for="article" class="float-left" >Article</label> 
					<input class="form-control" name="article" type="text" placeholder="Veuillez entrer le nom de l'article à vendre">
				</div>
				<div class="form-group">
					<label  for="description" class="float-left" >Description</label> 
					<textarea class="form-control" name="description" placeholder="Veuillez décrire l'article à vendre"></textarea>
				</div>
				<div class="row">
			<div class="col-6 mx-auto">
				<label for="libelle" class="float-left" >Catégorie de l'article</label>
				 	<select id="libelle" class="form-control" name="categorie"> 
					 	<c:forEach items="${categories}" var="categorie">
							<option value="${categorie.noCategorie}" selected>${categorie.libelle}</option>
						</c:forEach>
					</select>
			</div>
		</div>
		<div class="row">
			<div class="col-4 mx-auto">
				<label for="miseAPrix" class="float-center" >Mise à prix</label> <select id="miseAPrix"
					class="form-control" name="miseAPrix">
					<option selected>10</option>
					<option>20</option>
					<option>30</option>
					<option>40</option>
					<option>50</option>
					<option>60</option>
					<option>70</option>
					<option>80</option>
					<option>90</option>
					<option>100</option>
					<option>110</option>
					<option>120</option>
					<option>130</option>
					<option>140</option>
					<option>150</option>
					<option>170</option>
					<option>200</option>
					<option>250</option>
					<option>300</option>
					<option>350</option>
					<option>400</option>
					<option>450</option>
					<option>500</option>
					<option>550</option>
					<option>600</option>
					<option>650</option>
					<option>700</option>
					<option>750</option>
				</select>
			</div>
		</div>
				<div class="form-group">
					<label  for="dedutEnchere" class="float-left" >Date de début d'enchère</label> 
					<input class="form-control" name="dateDebutEnchere" type="datetime-local" required >
				</div>
				<div class="form-group">
					<label  for="finEnchere" class="float-left" >Date de fin d'enchère</label> 
					<input class="form-control" name="dateFinEnchere" type="datetime-local" required>
				</div>
				<fieldset name="retrait" class="fieldset">
				<label>Retrait</label>
				<div class="form-group">
					<label  for="adresse" class="float-left" >Adresse</label> 
					<input class="form-control" name="adresse" type="text" value="${user.adresse}">
				</div>
				<div class="form-group">
					<label  for="cp" class="float-left" >Code postal</label> 
					<input class="form-control" name="cp" type="text" value="${user.cp}">
				</div>
				<div class="form-group">
					<label  for="ville" class="float-left">Ville</label> 
					<input class="form-control" name="ville" type="text" value="${user.ville}">
				</div>
				</fieldset>
			</div>
		</div>
		<div>
				<button type="submit" class="btn btn-secondary">Créer</button>
			</div>
			<div>
				<button type="reset" class="btn btn-dark">Annuler</button>
			</div>
</form>
	</div>	
</body>
</html>