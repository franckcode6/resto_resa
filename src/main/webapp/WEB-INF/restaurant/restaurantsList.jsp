<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Resto-Resa - Restaurants</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath}/style/style.css"
	type="text/css" rel="stylesheet">
</head>
<body>
	<%@include file="../components/header.jsp"%>

	<main class="container">
		<article id="concept"
			class="row col-md-4 col-sm-12 mx-auto shadow-sm text-center">
			<div class="py-2">
				<h2 class="py-2">Resto-Resa quezako?</h2>
				<p class="px-5">
					🍕 <strong>Resto-Resa</strong> est votre application de réservation
					de restaurants! <br> 🎈 Envie d'un petit restaurant en ami? Un
					anniversaire à fêter? <br> 🖱 Avec <strong>Resto-Resa</strong>,
					réservez en un click, profitez d'un bon repas dans le restaurant de
					votre choix!
				</p>
			</div>
		</article>

		<article id="restaurant" class="row mb-4">
			<h2 class="mb-1">Les derniers restaurants ajoutés</h2>
			<c:forEach items="${restaurants}" var="restaurant">
				<section class="restaurantCard col-md-8 col-sm-12 mx-auto">
					<img src="../images/${restaurant.image}" alt="images" />
					<div class="itemContent">
						<h3>${restaurant.name}</h3>
						<ul>
							<li>👨‍🍳 ${restaurant.professionnal.firstName}
								${restaurant.professionnal.lastName}</li>
							<li>📞 ${restaurant.phone}</li>
							<li>📍 ${restaurant.address.noAddress}
								${restaurant.address.address} - ${restaurant.address.postalCode}
								${restaurant.address.city}</li>
							<li><a href="/details?id=${restaurant.id}"
								class="btn btn-success mt-3 me-2">Détails</a> <a
								href="/reservation/restaurant?id=${restaurant.id}"
								class="btn btn-danger mt-3">Réservez!</a></li>
						</ul>
					</div>
				</section>
			</c:forEach>
		</article>
	</main>
	<%@include file="../components/footer.jsp"%>
</body>
</html>