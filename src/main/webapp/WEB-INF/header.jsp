<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<header class="bg-danger bg-gradient text-white">
	<div
		class="container py-3 d-flex justify-content-between align-items-center">
		<a href="/">
			<h1>Resto-Resa</h1>
		</a>
		<nav>
			<c:if test="${sessionScope.customer ne null}">
			<a href="/profil">${sessionScope.customer.firstName} ${sessionScope.customer.lastName}</a>
			<a href="/profil/reservations"  class="ms-3">Mes réservations</a> 
			</c:if>
			
			<c:if test="${sessionScope.professionnal ne null}">
			<a href="/professionnal">${sessionScope.professionnal.firstName} ${sessionScope.professionnal.lastName}</a>
			<a href="/professionnal/restaurants" class="ms-3">Mes restaurants</a> 
			</c:if>
			<a href="/deconnexion" class="ms-3">Déconnexion</a>
		</nav>
	</div>
	<div id="background"></div>
</header>