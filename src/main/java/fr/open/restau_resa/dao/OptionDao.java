package fr.open.restau_resa.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.open.restau_resa.business.Option;

public interface OptionDao extends JpaRepository<Option, Long> {

}
