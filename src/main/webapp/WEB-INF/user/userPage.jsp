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
		<h2 class="my-4">Bonjour ${customer.firstName}</h2>

		<div class="row col-md-6 mx-auto py-2">
			<div class="redSquare col-md-4 bg-danger bg-gradient"></div>
			<ul class="col-md-8 bg-light py-3">
				<li>Nom : ${customer.lastName}</li>
				<li>Prénom : ${customer.firstName}</li>
				<li>Adresse email : ${customer.email}</li>
				<li>Téléphone : ${customer.phone}</li>
				<li>Compte créé le : ${customer}</li>
			</ul>
		</div>
	</main>
	<%@include file="../components/footer.jsp"%>
</body>
</html>