package fr.open.restau_resa.business;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Restaurant {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	private String name;

	@NotBlank
	private String phone;

	@NotBlank
	private String email;

	private String description;

	private boolean isDisabledFriendly;

	private String image;

	@ManyToOne
	private Professionnal professionnal;

	@ManyToOne
	private Address address;

	@OneToMany(mappedBy = "restaurant")
	private List<Reservation> reservations;

	@ManyToMany
	private List<Tag> tags;

	@OneToMany(mappedBy = "restaurant", cascade = CascadeType.REMOVE)
	private List<Menu> menus;

	public Restaurant(String name, String phone, String email, String description, boolean isDisabledFriendly,
			Professionnal professionnal, Address address) {
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.description = description;
		this.isDisabledFriendly = isDisabledFriendly;
		this.professionnal = professionnal;
		this.address = address;
	}

	public Restaurant(String name, String phone, String email, String description, boolean isDisabledFriendly,
			String image, Professionnal professionnal, Address address) {
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.description = description;
		this.isDisabledFriendly = isDisabledFriendly;
		this.image = image;
		this.professionnal = professionnal;
		this.address = address;
	}

	public Restaurant(String name, String phone, String email, String description, boolean isDisabledFriendly,
			String image, Professionnal professionnal, Address address, List<Tag> tags) {
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.description = description;
		this.isDisabledFriendly = isDisabledFriendly;
		this.image = image;
		this.professionnal = professionnal;
		this.address = address;
		this.tags = tags;
	}
}
