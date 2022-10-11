package fr.open.restau_resa.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import fr.open.restau_resa.business.Address;
import fr.open.restau_resa.business.Professionnal;
import fr.open.restau_resa.business.Restaurant;
import fr.open.restau_resa.business.Tag;
import fr.open.restau_resa.service.AddressService;
import fr.open.restau_resa.service.RestaurantService;
import fr.open.restau_resa.service.TagService;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class ProfessionnalController {

	private final AddressService addressService;
	private final RestaurantService restaurantService;
	private final TagService tagService;
	
	private final HttpSession httpSession;

	@GetMapping("/professionnal")
	public ModelAndView professionnalPageGet() {
		ModelAndView mav = new ModelAndView();

		Professionnal professionnal = (Professionnal) httpSession.getAttribute("professionnal");
		mav.addObject("professionnal", professionnal);

		mav.setViewName("professionnalPage");
		return mav;
	}
	
	@GetMapping("/professionnal/restaurants")
	public ModelAndView restaurantProfessionnalPageGet() {
		ModelAndView mav = new ModelAndView();

		Professionnal professionnal = (Professionnal) httpSession.getAttribute("professionnal");
		mav.addObject("professionnal", professionnal);

		mav.setViewName("restaurantProfessionnalPage");
		return mav;
	}
	
	@GetMapping("/professionnal/restaurants/add")
	public ModelAndView restaurantProfessionnalAddPageGet() {
		ModelAndView mav = new ModelAndView();

		Professionnal professionnal = (Professionnal) httpSession.getAttribute("professionnal");
		mav.addObject("professionnal", professionnal);
		mav.addObject("tags", tagService.getAllTags());

		mav.setViewName("restaurantAdd");
		return mav;
	}
	
	@PostMapping("/professionnal/restaurants/add")
	public ModelAndView restaurantProfessionnalAddPagePost(@RequestParam(name = "NAME") String name,
			@RequestParam(name = "PHONE") String phone,
			@RequestParam(name = "EMAIL") String email,
			@RequestParam(name = "DESCRIPTION") String description,
			@RequestParam(name = "TAG", required = false) Tag tag,
			@RequestParam(name = "DISABLED", required = false) boolean disabled,
			@RequestParam(name = "NOADDRESS") String noAddress,
			@RequestParam(name = "ADDRESS") String address,
			@RequestParam(name = "POSTALCODE") String postalCode,
			@RequestParam(name = "CITY") String city) {
		
		Professionnal professionnal = (Professionnal) httpSession.getAttribute("professionnal");
		Address restaurantAddress = new Address(noAddress, address, postalCode, city);
		
		addressService.addAddress(restaurantAddress);
		
		System.out.println(restaurantAddress);
		
		Restaurant restaurant = new Restaurant(name, phone, email, description, disabled, professionnal, restaurantAddress);
		
		restaurantService.addRestaurant(restaurant);
		
		return new ModelAndView("redirect:/professionnal/restaurants");
	}
}
