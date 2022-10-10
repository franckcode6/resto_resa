package fr.open.restau_resa.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.open.restau_resa.business.Professionnal;

public interface ProfessionnalDao extends JpaRepository<Professionnal, Long> {

	Professionnal findByEmailAndPassword(String email, String password);
}
