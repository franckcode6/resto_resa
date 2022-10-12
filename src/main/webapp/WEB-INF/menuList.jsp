<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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

		<section id="detailsRestaurant" class="row mb-5 mx-auto col-md-12">
			<c:if test="${not empty restaurant.menus}">
				<h3 class="mt-3">Plats à la carte :</h3>
					<c:forEach items="${restaurant.menus}" var="menu">
						<div class="card p-0 m-3" style="width: 20rem;">
							<img src="../images/${menu.img}" class="card-img-top" alt="menu">
							<div class="card-body">
								<h4 class="card-text">${menu.name}</h4>
								<p class="card-text">${menu.description}.
									<br>
									<fmt:formatNumber type="number" maxFractionDigits="2"
										value="${menu.price}" />
									€
								</p>
								<p class="m-0">
								<a href="/professionnal/menu/modify?id=${menu.id}" class="me-2 btn-sm btn-warning">Modifier</a>
								<a href="/professionnal/menu/delete?id=${menu.id}" class="btn-sm btn-danger">Supprimer</a>
								</p>
							</div>
						</div>
					</c:forEach>
			</c:if>
			<a href="/professionnal/menu/add?id=${restaurant.id}" class="btn btn-success">Ajouter un menu</a>
		</section>
	</main>
	<%@include file="footer.jsp"%>
</body>
</html>