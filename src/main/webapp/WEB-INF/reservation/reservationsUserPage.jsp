<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
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

		<div class="row  col-md-8 mx-auto">
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
</body>
</html>