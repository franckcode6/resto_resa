package fr.open.restau_resa.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.open.restau_resa.business.Restaurant;

public interface RestaurantDao extends JpaRepository<Restaurant, Long> {

	List<Restaurant> findAllByReservationsUserId(Long id);

	List<Restaurant> findAllByNameContaining(String name);

	List<Restaurant> findAllByAddressCityContaining(String city);
}
