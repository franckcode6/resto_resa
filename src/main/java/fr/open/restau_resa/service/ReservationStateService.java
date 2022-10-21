package fr.open.restau_resa.service;

import java.util.List;

import fr.open.restau_resa.business.ReservationState;

public interface ReservationStateService {

	ReservationState getState(Long id);

	List<ReservationState> getReservationStatesByReservationsUserId(Long id);
}
