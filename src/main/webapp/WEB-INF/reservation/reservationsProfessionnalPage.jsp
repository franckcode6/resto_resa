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
		<h2 class="my-4">Réservations</h2>

		<div class="row col-md-8 mx-auto">
			<a href="/professionnal/reservations/received" class="btn btn-warning mb-3">Réservations en attente</a> 
			<a href="/professionnal/reservations/validated" class="btn btn-success mb-3">Réservations validées</a> 
			<a href="/professionnal/reservations/cancelled" class="btn btn-danger">Réservations annulées</a>
			</div>
	</main>
	
	<%@include file="../components/footer.jsp"%>
</body>
</html>