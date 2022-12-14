package fr.open.restau_resa.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import fr.open.restau_resa.business.ReservationState;
import fr.open.restau_resa.dao.ReservationStateDao;
import fr.open.restau_resa.service.ReservationStateService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ReservationStateServiceImpl implements ReservationStateService {

	private final ReservationStateDao reservationStateDao;

	@Override
	public ReservationState getState(Long id) {
		return reservationStateDao.findById(id).orElse(null);
	}

	@Override
	public List<ReservationState> getReservationStatesByReservationsUserId(Long id) {
		List<ReservationState> reservationStates = reservationStateDao.findAllByReservationsUserId(id);
		List<ReservationState> reservationStatesWithoutDuplicates = new ArrayList<>();

		for (ReservationState reservationState : reservationStates) {
			if (!reservationStatesWithoutDuplicates.contains(reservationState)) {
				reservationStatesWithoutDuplicates.add(reservationState);
			}
		}

		return reservationStatesWithoutDuplicates;
	}
}
