package fr.open.restau_resa.service.impl;

import org.springframework.stereotype.Service;

import fr.open.restau_resa.business.User_;
import fr.open.restau_resa.dao.UserDao;
import fr.open.restau_resa.service.UserService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

	private final UserDao userDao;

	@Override
	public User_ getUser(long id) {
		return userDao.findById(id).orElse(null);
	}
	
	@Override
	public User_ getUser(String email, String password) {
		return userDao.findByEmailAndPassword(email, password);
	}

	@Override
	public User_ addUser(String firstName, String lastName, String phone, String email, String password) {
		return userDao.save(new User_(firstName, lastName, phone, email, password));
	}

}
