<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Resto-Resa - Reservations</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath}/style/style.css"
	type="text/css" rel="stylesheet">
</head>
<body>
	<%@include file="../components/header.jsp"%>

	<main class="container">
		<h2 class="my-4">Réservations annulées :</h2>

		<c:forEach items="${professionnal.restaurants}" var="restaurant">
			<div class="row col-md-8 mx-auto">
				<h3>${restaurant.name}</h3>
				<table class="table table-hover">
					<thead class="table-dark">
						<tr>
							<th>Date</th>
							<th>Heure</th>
							<th>Restaurant</th>
							<th>Pour</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${restaurant.reservations}" var="reservation">
							<c:if test="${reservation.reservationState.id eq 4}">
								<tr class="table-light">
									<th>${reservation.date}</th>
									<td>${reservation.slot}</td>
									<td>${reservation.restaurant.name}-
										${reservation.restaurant.address.postalCode}
										${reservation.restaurant.address.city}</td>
									<td>${reservation.customersAmount}personnes</td>
								</tr>
							</c:if>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</c:forEach>
	</main>

	<%@include file="../components/footer.jsp"%>
</body>
</html>