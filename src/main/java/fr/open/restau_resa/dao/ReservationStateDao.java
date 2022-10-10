package fr.open.restau_resa.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.open.restau_resa.business.ReservationState;

public interface ReservationStateDao extends JpaRepository<ReservationState, Long> {

}
