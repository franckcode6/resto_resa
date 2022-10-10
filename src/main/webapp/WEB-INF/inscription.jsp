<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Resto-Resa - Inscription</title>
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
		<h2 class="my-4">Inscription</h2>

		<form method="post"
			class="mx-auto shadow-sm mt-2 mb-5 p-4 row col-md-6 ">
			<div class="mb-3">
				<label for="firstName" class="form-label">Prénom</label> <input
					type="text" id="firstName" name="FIRSTNAME" class="form-control">
			</div>
			
			<div class="mb-3">
				<label for="lastName" class="form-label">Nom</label> <input
					type="text" id="lastName" name="LASTNAME" class="form-control">
			</div>
			
			<div class="mb-3">
				<label for="phone" class="form-label">Téléphone</label> <input
					type="tel" id="phone" name="PHONE" class="form-control">
			</div>
			
			<div class="mb-3">
				<label for="email" class="form-label">Email</label> <input
					type="email" id="email" name="EMAIL" class="form-control">
			</div>

			<div class="mb-3">
				<label for="password" class="form-label">Mot de passe</label> <input
					type="password" id="password" name="MDP" class="form-control">
			</div>
			
			<div>
			<input type="submit" value="S'inscrire" class="btn btn-success me-2">
			</div>
		</form>
	</main>
	<%@include file="footer.jsp"%>
</body>
</html>