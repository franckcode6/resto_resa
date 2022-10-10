package fr.open.restau_resa.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.open.restau_resa.business.Address;

public interface AddressDao extends JpaRepository<Address, Long> {

}
