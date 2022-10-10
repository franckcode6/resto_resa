package fr.open.restau_resa.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.open.restau_resa.business.Restaurant;

public interface RestaurantDao extends JpaRepository<Restaurant, Long> {

}
