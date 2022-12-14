package fr.open.restau_resa.service;

import java.time.LocalDate;
import java.util.List;

import fr.open.restau_resa.business.Reservation;
import fr.open.restau_resa.business.Restaurant;
import fr.open.restau_resa.business.User_;

public interface ReservationService {

	Reservation addReservation(LocalDate date, String slot, int customersAmount, Restaurant restaurant, User_ user);
	
	Reservation addReservation(Reservation reservation);

	List<Reservation> findAllUsersById(Long id);

	List<Reservation> findAllByProfessionnalId(Long id);

	List<Reservation> findAllByRestaurant(String restaurant);
	
	List<Reservation> findAllByReservationState(String state);
	
	void validateReservation(Long id);

	void cancelReservation(Long id);
}
