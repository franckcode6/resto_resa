package fr.open.restau_resa.service;

import fr.open.restau_resa.business.Professionnal;

public interface ProfessionnalService {

	Professionnal addProfessionnal(String firstName, String lastName, String phone, String email, String password, String siret);

}
