package fr.open.restau_resa.service.impl;

import org.springframework.stereotype.Service;

import fr.open.restau_resa.business.Professionnal;
import fr.open.restau_resa.dao.ProfessionnalDao;
import fr.open.restau_resa.service.ProfessionnalService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProfessionnalServiceImpl implements ProfessionnalService {

	private final ProfessionnalDao professionnalDao;

	@Override
	public Professionnal addProfessionnal(String firstName, String lastName, String phone, String email,
			String password, String siret) {
		return professionnalDao.save(new Professionnal(firstName, lastName, phone, email, password, siret));
	}

	@Override
	public Professionnal getProfessionnal(String email, String password) {
		return professionnalDao.findByEmailAndPassword(email, password);
	}
}
