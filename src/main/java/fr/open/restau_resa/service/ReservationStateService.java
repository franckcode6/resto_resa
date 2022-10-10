package fr.open.restau_resa.service;

import fr.open.restau_resa.business.ReservationState;

public interface ReservationStateService {

	ReservationState getState(Long id);
}
