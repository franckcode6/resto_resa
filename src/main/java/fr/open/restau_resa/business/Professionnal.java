package fr.open.restau_resa.business;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Professionnal extends User_ {

	@NotBlank
	private String siret;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "professionnal")
	private List<Restaurant> restaurants;

	public Professionnal(String firstName, String lastName, String phone, String email, String password, String siret) {
		super(firstName, lastName, phone, email, password);
		this.siret = siret;
	}
	
	@Override
	public String toString() {
		return createdAt.getDayOfMonth() + "/" + createdAt.getMonthValue() + "/" + createdAt.getYear();
	}
}
