package fr.open.restau_resa.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import fr.open.restau_resa.business.Reservation;
import fr.open.restau_resa.business.Restaurant;
import fr.open.restau_resa.business.User_;
import fr.open.restau_resa.dao.ReservationDao;
import fr.open.restau_resa.service.ReservationService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ReservationServiceImpl implements ReservationService {

	private final ReservationDao reservationDao;

	public Reservation addReservation(LocalDate date, String slot, int customersAmount,
			Restaurant restaurant, User_ user) {
		return reservationDao.save(new Reservation(date, slot, customersAmount, restaurant, user));
	}

	@Override
	public Reservation addReservation(Reservation reservation) {
		return reservationDao.save(reservation);
	}

	@Override
	public List<Reservation> findAllUsersById(long id) {
		return reservationDao.findAllByUserId(id);
	}
}
