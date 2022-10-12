package fr.open.restau_resa.service;

import fr.open.restau_resa.business.Address;

public interface AddressService {

	Address addAddress(Address address);

	Address findById(Long id);

	Address modifyAddress(Long id, String noAddress, String address, String postalCode, String city);

}
