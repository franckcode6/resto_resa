<header class="bg-danger bg-gradient text-white">
	<div
		class="container py-3 d-flex justify-content-between align-items-center">
		<a href="/">
			<h1>Resto-Resa</h1>
		</a>
		<nav>
			<a href="/profil">${sessionScope.customer.firstName} ${sessionScope.customer.lastName}</a>
			<a href="/profil/reservations"  class="ms-3">Mes r�servations</a> 
			<a href="/deconnexion" class="ms-3">D�connexion</a>
		</nav>
	</div>
	<div id="background"></div>
</header>