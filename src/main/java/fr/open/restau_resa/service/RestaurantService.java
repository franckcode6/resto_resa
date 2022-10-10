package fr.open.restau_resa.service;

import java.util.List;

import fr.open.restau_resa.business.Restaurant;

public interface RestaurantService {

	List<Restaurant> recupererRestaurants();

	Restaurant recupererRestaurant(Long id);

}
