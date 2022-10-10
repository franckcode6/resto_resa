package fr.open.restau_resa.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.open.restau_resa.business.Menu;

public interface MenuDao extends JpaRepository<Menu, Long> {

}
