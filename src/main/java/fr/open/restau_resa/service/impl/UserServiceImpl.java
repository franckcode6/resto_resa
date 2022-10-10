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

}
