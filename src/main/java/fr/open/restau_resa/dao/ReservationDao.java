package fr.open.restau_resa.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.open.restau_resa.business.Reservation;

public interface ReservationDao extends JpaRepository<Reservation, Long> {
	
	List<Reservation> findAllByUserId(Long id);

	List<Reservation> findAllByRestaurantProfessionnalId(Long id);
}
