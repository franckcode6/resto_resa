package fr.open.restau_resa.business;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class User_ {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long id;

	@NotBlank
	protected String firstName;

	@NotBlank
	protected String lastName;

	@NotBlank
	protected String phone;

	@NotBlank
	protected String email;

	@NotBlank
	@Size(min = 4, max = 15)
	protected String password;

	protected LocalDateTime createdAt;

	@OneToMany(mappedBy = "user")
	protected List<Reservation> reservations;

	public User_() {
		this.createdAt = LocalDateTime.now();
	}

	public User_(String firstName, String lastName, String phone, String email, String password) {
		this();
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.email = email;
		this.password = password;
	}
}
