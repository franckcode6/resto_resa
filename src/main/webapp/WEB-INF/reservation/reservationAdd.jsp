<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Resto-Resa - Reservation</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath}/style/style.css"
	type="text/css" rel="stylesheet">
</head>
<body>
	<%@include file="../components/header.jsp"%>

	<main class="container">
		<h2 class="my-4">${restaurant.name}-Nouvelle réservation</h2>

		<form method="post"
			class="mx-auto shadow-sm mt-2 mb-5 p-4 row col-md-6 ">
			<div class="mb-3">
				<label for="date" class="form-label">Date de réservation</label> <input
					type="date" id="date" name="DATE" class="form-control">
			</div>

			<div class="mb-3">
				<label for="slot" class="form-label">Heure</label> <select id="slot"
					name="SLOT" class="form-select">
					<option value="0">Merci de choisir une heure de
						réservation</option>
					<option value="18h00">18h00</option>
					<option value="18h30">18h30</option>
					<option value="19h00">19h00</option>
					<option value="19h30">19h30</option>
					<option value="20h00">20h00</option>
					<option value="20h30">20h30</option>
					<option value="21h00">21h00</option>
					<option value="21h30">21h30</option>
				</select>
			</div>

			<div class="mb-3">
				<label for="customers" class="form-label">Nombre de
					personnes</label> <input type="number" min="1" max="10" placeholder="1"
					id="customers" name="CUST_AMT" class="form-control">
			</div>

			<div class="mb-3">
				<label for="option_id" class="form-label">Option?</label> <select
					name="OPTION" class="form-select" id="option_id">
					<option value="" selected disabled hidden="true">Ajouter
						une option?</option>
					<c:forEach items="${options}" var="option">
						<option value="${option.id}">${option.name}</option>
					</c:forEach>
				</select>
			</div>

			<div class="mb-3">
				<label for="remark" class="form-label">Remarques
					(optionnelles)</label>
				<textarea rows="5" class="form-control" id="remark" name="REMARK"></textarea>
			</div>

			<div>
				<input type="submit" value="Ajouter" class="btn btn-success me-2">
				<a href="/" class="btn btn-secondary">Retour à la liste</a>
			</div>
		</form>
	</main>
	<%@include file="../components/footer.jsp"%>
</body>
</html>