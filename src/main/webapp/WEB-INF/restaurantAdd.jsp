<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Resto-Resa - Restaurant ajout</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
<style>
<%@include file="style/style.css"%>
</style>
</head>
<body>
	<%@include file="header.jsp"%>

	<main class="container">
		<h2 class="my-4">${sessionScope.professionnal.firstName} ${sessionScope.professionnal.lastName} - Nouveau restaurant</h2>

		<form method="post"
			class="mx-auto shadow-sm mt-2 mb-5 p-4 row col-md-6 ">
			<div class="mb-3">
				<label for="name" class="form-label">Nom</label> 
				<input type="text" id="name" name="NAME" class="form-control">
			</div>
			
			<div class="mb-3">
				<label for="phone" class="form-label">Téléphone</label> 
				<input type="text" id="phone" name="PHONE" class="form-control">
			</div>
			
			<div class="mb-3">
				<label for="email" class="form-label">Adresse email</label> 
				<input type="email" id="email" name="EMAIL" class="form-control">
			</div>

			<div class="mb-3">
				<label for="description" class="form-label">Description</label>
				<textarea rows="5" class="form-control" id="description" name="DESCRIPTION"></textarea>
			</div>

			<div class="mb-3">
				<label for="tag_id" class="form-label">Tag</label> 
				<select	name="TAG" class="form-select" id="tag_id">
					<option value="" selected disabled hidden="true">Ajouter
						un tag?</option>
					<c:forEach items="${tags}" var="tag">
						<option value="${tag.id}">${tag.name}</option>
					</c:forEach>
				</select>
			</div>
			
			<div class="mb-3">
				<input type="checkbox" id="disabledFriendly" name="DISABLED">
				<label for="disabledFriendly">Accès handicapé</label>
			</div>
			
			<div class="mb-3">
				<label for="noAddress" class="form-label">Numéro de voie</label>
				<input class="form-control" id="noAddress" name="NOADDRESS">
			</div>
			
			<div class="mb-3">
				<label for="address" class="form-label">Adresse</label>
				<input class="form-control" id="address" name="ADDRESS">
			</div>
			
			<div class="mb-3">
				<label for="postalCode" class="form-label">Code postal</label>
				<input class="form-control" id="postalCode" name="POSTALCODE">
			</div>
			
			<div class="mb-3">
				<label for="city" class="form-label">Ville</label>
				<input class="form-control" id="city" name="CITY">
			</div>

			<div>
				<input type="submit" value="Ajouter" class="btn btn-success me-2">
				<a href="/" class="btn btn-secondary">Retour à la liste</a>
			</div>
		</form>
	</main>
	<%@include file="footer.jsp"%>
</body>
</html>