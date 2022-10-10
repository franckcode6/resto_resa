package fr.open.restau_resa.business;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reservation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private LocalDate date;

	@NotBlank
	private String slot;

	@Lob
	private String remark;

	@NotNull
	private int customersAmount;

	@ManyToOne
	private Restaurant restaurant;

	@ManyToOne
	private Option option;

	@ManyToOne
	private ReservationState reservationState;

	@ManyToOne
	private User_ user;

	public Reservation(LocalDate date, String slot, int customersAmount, Restaurant restaurant, User_ user) {
		this();
		this.date = date;
		this.slot = slot;
		this.customersAmount = customersAmount;
		this.restaurant = restaurant;
		this.user = user;
	}
}
