package fr.open.restau_resa.business;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	private String noAddress;

	@NotBlank
	private String address;

	@NotBlank
	private String postalCode;
	
	@NotBlank
	private String City;

	@OneToMany(mappedBy = "address")
	private List<Restaurant> restraurants;
	
	public Address(String noAddress, String address, String postalCode, String city) {
		this.noAddress = noAddress;
		this.address = address;
		this.postalCode = postalCode;
		this.City = city;
	}
}
