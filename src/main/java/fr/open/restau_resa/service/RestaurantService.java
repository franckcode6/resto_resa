package fr.open.restau_resa.service;

import java.util.List;

import fr.open.restau_resa.business.Address;
import fr.open.restau_resa.business.Professionnal;
import fr.open.restau_resa.business.Restaurant;
import fr.open.restau_resa.business.Tag;

public interface RestaurantService {

	List<Restaurant> recupererRestaurants();

	Restaurant recupererRestaurant(Long id);

	Restaurant addRestaurant(Restaurant restaurant);

	Restaurant modifyRestaurant(Long id, String name, String phone, String email, String description, List<Tag> tags,
			boolean disabled, Professionnal professionnal, Address address);

	void deleteRestaurant(Long id);

	List<Restaurant> getRestaurantsByReservationsUserId(Long id);

	List<Restaurant> findAllByName(String name);
	
	List<Restaurant> findAllByCity(String city);
}
