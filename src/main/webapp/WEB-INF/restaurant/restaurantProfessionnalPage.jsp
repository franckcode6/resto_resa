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
			<div>
				<a href="/professionnal/restaurants/add"
					class="btn btn-danger mb-3 float-end">Nouveau restaurant</a>
			</div>
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
</body>
</html>