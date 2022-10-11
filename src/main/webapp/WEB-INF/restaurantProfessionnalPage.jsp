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
<style>
<%@include file="style/style.css"%>
</style>
</head>
<body>
	<%@include file="header.jsp"%>

	<main class="container">
		<h2 class="my-4">Bonjour ${professionnal.firstName}, voici vos
			restaurants :</h2>

		<div class="row  col-md-8 mx-auto">
			<table class="table table-hover">
				<thead class="table-dark">
					<tr>
						<th>Nom</th>
						<th>Adresse</th>
						<th>Email</th>
						<th>Telephone</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${professionnal.restaurants}" var="restaurant">
						<tr class="table-light">
							<th>${restaurant.name}</th>
							<td>${restaurant.address.noAddress} ${restaurant.address.address}
							- ${restaurant.address.postalCode} ${restaurant.address.city}</td>
							<td>${restaurant.email}</td>
							<td>${restaurant.phone}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</main>
	<%@include file="footer.jsp"%>
</body>
</html>