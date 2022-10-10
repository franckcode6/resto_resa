package fr.open.restau_resa.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.open.restau_resa.business.User_;

public interface UserDao extends JpaRepository<User_, Long> {

	User_ findByEmailAndPassword(String email, String password);
}
