package fr.open.restau_resa.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import fr.open.restau_resa.business.Address;
import fr.open.restau_resa.business.Professionnal;
import fr.open.restau_resa.business.Restaurant;
import fr.open.restau_resa.business.Tag;
import fr.open.restau_resa.dao.RestaurantDao;
import fr.open.restau_resa.service.RestaurantService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RestaurantServiceImpl implements RestaurantService {

	private final RestaurantDao restaurantDao;

	public List<Restaurant> recupererRestaurants() {
		return restaurantDao.findAll();
	}

	public Restaurant recupererRestaurant(Long id) {
		return restaurantDao.findById(id).orElse(null);
	}

	@Override
	public Restaurant addRestaurant(Restaurant restaurant) {
		return restaurantDao.save(restaurant);
	}

	@Override
	public void deleteRestaurant(Long id) {
		restaurantDao.deleteById(id);
	}

	@Override
	public Restaurant modifyRestaurant(Long id, String name, String phone, String email, String description,
			List<Tag> tags, boolean disabled, Professionnal professionnal, Address address) {
		Restaurant restaurant = restaurantDao.findById(id).orElse(null);

		restaurant.setName(name);
		restaurant.setPhone(phone);
		restaurant.setEmail(email);
		restaurant.setDescription(description);
		restaurant.setTags(tags);
		restaurant.setDisabledFriendly(disabled);
		restaurant.setProfessionnal(professionnal);
		restaurant.setAddress(address);

		return restaurantDao.save(restaurant);
	}

	@Override
	public List<Restaurant> getRestaurantsByReservationsUserId(Long id) {
		List<Restaurant> restaurants = restaurantDao.findAllByReservationsUserId(id);
		// New list that contains only single restaurants
		List<Restaurant> restaurantListWithoutDuplicate = new ArrayList<>();

		// Add a restaurant only if he's not already in the list
		for (Restaurant restaurant : restaurants) {
			if (!restaurantListWithoutDuplicate.contains(restaurant)) {
				restaurantListWithoutDuplicate.add(restaurant);
			}
		}

		return restaurantListWithoutDuplicate;
	}
}
