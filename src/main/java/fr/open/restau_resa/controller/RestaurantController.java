package fr.open.restau_resa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import fr.open.restau_resa.service.RestaurantService;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class RestaurantController {

	private final RestaurantService restaurantService;

	/**
	 * Index page
	 * 
	 * @return
	 */
	@GetMapping("/")
	public ModelAndView restaurantsGet() {
		ModelAndView mav = new ModelAndView();

		mav.addObject("restaurants", restaurantService.recupererRestaurants());

		mav.setViewName("restaurant/restaurantsList");

		return mav;
	}

	/**
	 * Restaurant details
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/details")
	public ModelAndView restaurantDetailsGet(@RequestParam(name = "id") Long id) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("restaurant", restaurantService.recupererRestaurant(id));
		mav.setViewName("restaurant/restaurantDetails");

		return mav;
	}
}
