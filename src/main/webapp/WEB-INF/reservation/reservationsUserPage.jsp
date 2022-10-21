<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Reservations</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath}/style/style.css"
	type="text/css" rel="stylesheet">
</head>
<body>
	<%@include file="../components/header.jsp"%>

	<main class="container">
		<h2 class="my-4">Bonjour ${customer.firstName}, voici vos
			réservations :</h2>

		<div class="row col-md-8 mx-auto pb-5">
			<section id="filtres" class="pb-3 hide">
				<form action="/profil/reservations/filter" method="get" class="mb-2">
					<label for="restaurant" class="form-label"> Restaurant </label>
					<div class="d-flex">
						<select name="RESTAURANT" id="restaurant" class="form-select">
							<option value=" " selected disabled>Sélectionner un
								restaurant</option>
							<c:forEach items="${restaurants}" var="restaurant">
								<option value="${restaurant.name}">${restaurant.name}</option>
							</c:forEach>
						</select> <input type="submit" value="Filtrer"
							class="btn btn-sm btn-success ms-1">
					</div>
				</form>

				<form action="/profil/reservations/filter" method="get" class="mb-2">
					<label for="state" class="form-label"> Etat </label>
					<div class="d-flex">
						<select name="STATE" id="state" class="form-select">
							<option value=" " selected disabled>Sélectionner un état</option>
							<c:forEach items="${states}" var="state">
								<option value="${state.state}">${state.state}</option>
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
						<th>Date</th>
						<th>Heure</th>
						<th>Restaurant</th>
						<th>Pour</th>
						<th>Etat</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${customer.reservations}" var="reservation">
						<tr class="table-light">
							<th>${reservation.date}</th>
							<td>${reservation.slot}</td>
							<td>${reservation.restaurant.name}-
								${reservation.restaurant.address.postalCode}
								${reservation.restaurant.address.city}</td>
							<td>${reservation.customersAmount}personnes</td>
							<td>${reservation.reservationState.state}</td>
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