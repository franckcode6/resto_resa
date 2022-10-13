<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Resto-Resa - Connexion</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
<%-- <style>
<%@include file="style/style.css"%>
</style> --%>
<link href="${pageContext.request.contextPath}/style/style.css" type="text/css" rel="stylesheet">
</head>
<body>
	<%@include file="../components/header.jsp"%>

	<main class="container">
		<h2 class="my-4">Mon compte</h2>

		<form method="post"
			class="mx-auto shadow-sm mt-2 mb-5 p-4 row col-md-6 ">
			<div class="mb-3">
				<label for="email" class="form-label">Email</label> <input
					type="email" id="email" name="EMAIL" class="form-control">
			</div>

			<div class="mb-3">
				<label for="password" class="form-label">Mot de passe</label> <input
					type="password" id="password" name="MDP" class="form-control">
			</div>

			<div>
				<input type="submit" value="Connexion" class="btn btn-success me-2">
				<a href="/inscription" class="btn btn-danger">S'inscrire</a> <a
					href="/inscription/pro" class="btn btn-secondary float-end">Inscription
					Pro</a>
			</div>
		</form>
	</main>
	<%@include file="../components/footer.jsp"%>
</body>
</html>