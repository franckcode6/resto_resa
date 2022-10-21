package fr.open.restau_resa.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import fr.open.restau_resa.business.Reservation;
import fr.open.restau_resa.business.ReservationState;
import fr.open.restau_resa.business.Restaurant;
import fr.open.restau_resa.business.User_;
import fr.open.restau_resa.dao.ReservationDao;
import fr.open.restau_resa.dao.ReservationStateDao;
import fr.open.restau_resa.service.ReservationService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ReservationServiceImpl implements ReservationService {

	private final ReservationDao reservationDao;
	private final ReservationStateDao reservationStateDao;

	public Reservation addReservation(LocalDate date, String slot, int customersAmount, Restaurant restaurant,
			User_ user) {
		return reservationDao.save(new Reservation(date, slot, customersAmount, restaurant, user));
	}

	@Override
	public Reservation addReservation(Reservation reservation) {
		return reservationDao.save(reservation);
	}

	@Override
	public List<Reservation> findAllUsersById(Long id) {
		return reservationDao.findAllByUserId(id);
	}

	@Override
	public List<Reservation> findAllByProfessionnalId(Long id) {
		return reservationDao.findAllByRestaurantProfessionnalId(id);
	}

	@Override
	public List<Reservation> findAllByRestaurant(String name) {
		return reservationDao.findAllByRestaurantNameContaining(name);
	}

	@Override
	public List<Reservation> findAllByReservationState(String state) {
		return reservationDao.findAllByReservationStateStateContaining(state);
	}

	@Override
	public void validateReservation(Long id) {

		// Get the reservation to change its reservation state
		Reservation reservation = reservationDao.findById(id).orElse(null);
		// Get the validate reservation state
		ReservationState validateState = reservationStateDao.findById(2L).orElse(null);
		reservation.setReservationState(validateState);

		reservationDao.save(reservation);
	}

	@Override
	public void cancelReservation(Long id) {

		// Get the reservation to change its reservation state
		Reservation reservation = reservationDao.findById(id).orElse(null);
		// Get the cancel reservation state
		ReservationState cancelState = reservationStateDao.findById(4L).orElse(null);
		reservation.setReservationState(cancelState);

		reservationDao.save(reservation);
	}
}
