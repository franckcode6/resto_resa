package fr.open.restau_resa.service;

import fr.open.restau_resa.business.Professionnal;

public interface ProfessionnalService {

	Professionnal getProfessionnal(String email, String password);
	
	Professionnal addProfessionnal(String firstName, String lastName, String phone, String email, String password, String siret);
}
