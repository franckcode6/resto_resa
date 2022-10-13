<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Resto-Resa - Menu ajout</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath}/style/style.css"
	type="text/css" rel="stylesheet">
</head>
<body>
	<%@include file="../components/header.jsp"%>

	<main class="container">
		<h2 class="my-4">${restaurant.name}- Nouveau menu</h2>

		<form method="post" enctype="multipart/form-data"
			class="mx-auto shadow-sm mt-2 mb-5 p-4 row col-md-6 ">
			<div class="mb-3">
				<label for="name" class="form-label">Nom</label> <input type="text"
					id="name" name="NAME" class="form-control">
			</div>

			<div class="mb-3">
				<label for="description" class="form-label">Description</label>
				<textarea rows="5" class="form-control" id="description"
					name="DESCRIPTION"></textarea>
			</div>

			<div class="mb-3">
				<label for="price" class="form-label">Prix</label> <input
					type="text" id="price" name="PRICE" class="form-control">
			</div>

			<div class="mb-4">
				<label for="image" class="form-label">Téléverser une image</label> <input
					type="file" name="IMAGE" accept="image" placeholder="URL"
					class="form-control">
			</div>

			<div class="mb-3">
				<input type="submit" value="Ajouter" class="btn btn-success me-2">
				<a href="/professionnal/menu?id=${restaurant.id}"
					class="btn btn-secondary">Retour à la liste</a>
			</div>
		</form>
	</main>
	<%@include file="../components/footer.jsp"%>
</body>
</html>