package fr.open.restau_resa.service.impl;

import org.springframework.stereotype.Service;

import fr.open.restau_resa.business.Address;
import fr.open.restau_resa.dao.AddressDao;
import fr.open.restau_resa.service.AddressService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AddressServiceImpl implements AddressService {

	private final AddressDao addressDao;

	@Override
	public Address findById(Long id) {
		return addressDao.findById(id).orElse(null);
	}

	@Override
	public Address addAddress(Address address) {
		return addressDao.save(address);
	}

	@Override
	public Address modifyAddress(Long id, String noAddress, String address, String postalCode, String city) {
		Address addressRestaurant = addressDao.findById(id).orElse(null);
		addressRestaurant.setNoAddress(noAddress);
		addressRestaurant.setAddress(address);
		addressRestaurant.setPostalCode(postalCode);
		addressRestaurant.setCity(city);

		return addressDao.save(addressRestaurant);
	}
}
