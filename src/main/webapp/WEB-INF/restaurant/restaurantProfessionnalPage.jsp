<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Mes restaurants</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath}/style/style.css"
	type="text/css" rel="stylesheet">
</head>
<body>
	<%@include file="../components/header.jsp"%>

	<main class="container">
		<h2 class="mt-4">Liste des restaurants :</h2>

		<div class="row col-md-10 mx-auto">
			<div class="p-0">
				<a href="/professionnal/restaurants/add"
					class="btn btn-danger mb-3 float-end">Nouveau restaurant</a>
			</div>

			<section id="filtres" class="pb-3 hide">
				<form action="/professionnal/restaurants/filter" method="get"
					class="mb-2">
					<label for="restaurant" class="form-label"> Restaurant </label>
					<div class="d-flex">
						<select name="RESTAURANT" id="restaurant" class="form-select">
							<option value=" " selected disabled>Sélectionner un
								restaurant</option>
							<c:forEach items="${professionnal.restaurants}" var="restaurant">
								<option value="${restaurant.name}">${restaurant.name}</option>
							</c:forEach>
						</select> <input type="submit" value="Filtrer"
							class="btn btn-sm btn-success ms-1">
					</div>
				</form>

				<form action="/professionnal/restaurants/filter" method="get"
					class="mb-2">
					<label for="state" class="form-label"> Ville </label>
					<div class="d-flex">
						<select name="CITY" id="state" class="form-select">
							<option value=" " selected disabled>Sélectionner une
								ville</option>
							<c:forEach items="${professionnal.restaurants}" var="restaurant">
								<option value="${restaurant.address.city}">${restaurant.address.city}</option>
							</c:forEach>
						</select> <input type="submit" value="Filtrer"
							class="btn btn-sm btn-success ms-1">
					</div>
				</form>
			</section>

			<button id="filterButton" class="btn btn-secondary mb-2">Filtres</button>

			<table class="table table-hover">
				<thead class="table-dark">
					<tr>
						<th>Nom</th>
						<th>Adresse</th>
						<th>Email</th>
						<th>Telephone</th>
						<th>Action</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${professionnal.restaurants}" var="restaurant">
						<tr class="table-light">
							<th>${restaurant.name}</th>
							<td>${restaurant.address.noAddress}
								${restaurant.address.address} - ${restaurant.address.postalCode}
								${restaurant.address.city}</td>
							<td>${restaurant.email}</td>
							<td>${restaurant.phone}</td>
							<td><a href="/details?id=${restaurant.id}"
								class="btn btn-primary mb-1">Détails</a> <a
								href="/professionnal/menu?id=${restaurant.id}"
								class="btn btn-success mb-1">Menu</a> <a
								href="/professionnal/restaurants/modify?id=${restaurant.id}"
								class="btn btn-warning mb-1">Modifier</a> <a
								href="/professionnal/restaurants/delete?id=${restaurant.id}"
								class="btn btn-danger">Supprimer</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</main>
	<%@include file="../components/footer.jsp"%>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/script/script.js"></script>
</body>
</html>