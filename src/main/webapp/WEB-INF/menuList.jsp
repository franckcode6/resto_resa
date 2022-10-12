<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Restaurant Menus</title>
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
		<h2 class="my-4">- ${restaurant.name} -</h2>

		<section id="detailsRestaurant" class="row mb-5 mx-auto">
			<c:if test="${not empty restaurant.menus}">
				<h3 class="mt-3">Plats à la carte :</h3>
				<ul class="d-flex">
					<c:forEach items="${restaurant.menus}" var="menu">
						<div class="card me-3" style="width: 20rem;">
							<img src="../images/${menu.img}" class="card-img-top" alt="menu">
							<div class="card-body">
								<h4>${menu.name}</h4>
								<p class="card-text">${menu.description}.
									<br> ${menu.price} €
								</p>
							</div>
						</div>
					</c:forEach>
				</ul>
			</c:if>
			<a href="/professionnal/menu/add?id=${restaurant.id}" class="btn btn-success">Ajouter un menu</a>
		</section>
	</main>
	<%@include file="footer.jsp"%>
</body>
</html>