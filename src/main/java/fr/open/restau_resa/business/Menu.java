package fr.open.restau_resa.business;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Menu {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	private String name;

	@Lob
	private String description;

	private double price;
	
	private String img;

	@ManyToOne
	private Restaurant restaurant;
	
	public Menu(String name, String description, double price) {
		this.name = name;
		this.description = description;
		this.price = price;
	}
	
	public Menu(String name, String description, double price, Restaurant restaurant) {
		this();
		this.name = name;
		this.description = description;
		this.price = price;
		this.restaurant = restaurant;
	}
	
	public Menu(String name, String description, double price, String img, Restaurant restaurant) {
		this();
		this.name = name;
		this.description = description;
		this.price = price;
		this.img = img;
		this.restaurant = restaurant;
	}
}
