package fr.open.restau_resa.service;

import fr.open.restau_resa.business.User_;

public interface UserService {

	User_ getUser(long id);

	User_ addUser(String firstName, String lastName, String phone, String email, String password);

}
