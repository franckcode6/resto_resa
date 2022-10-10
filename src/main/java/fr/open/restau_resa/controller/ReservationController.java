package fr.open.restau_resa.controller;

import java.time.LocalDate;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import fr.open.restau_resa.business.Option;
import fr.open.restau_resa.business.Reservation;
import fr.open.restau_resa.business.Restaurant;
import fr.open.restau_resa.business.User_;
import fr.open.restau_resa.service.OptionService;
import fr.open.restau_resa.service.ReservationService;
import fr.open.restau_resa.service.ReservationStateService;
import fr.open.restau_resa.service.RestaurantService;
import fr.open.restau_resa.service.UserService;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class ReservationController {

	private final OptionService optionService;
	private final ReservationService reservationService;
	private final RestaurantService restaurantService;
	private final ReservationStateService reservationStateService;
	private final UserService userService;

	@GetMapping("/reservation/restaurant")
	public ModelAndView reservationGet(@RequestParam(name = "id") Long id) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("restaurant", restaurantService.recupererRestaurant(id));
		mav.addObject("options", optionService.recupererOptions());

		mav.setViewName("reservationAdd");
		return mav;
	}

	@PostMapping("/reservation/restaurant")
	public ModelAndView reservationPost(@RequestParam(name = "id") Long restaurantId,
			@RequestParam(name = "DATE") String date, @RequestParam(name = "SLOT") String slot,
			@RequestParam(name = "CUST_AMT") int customerAmount,
			@RequestParam(name = "OPTION", required = false) String optionId,
			@RequestParam(name = "REMARK", required = false) String remark) {

		System.out.println(optionId);

		LocalDate dateReservation = LocalDate.parse(date);
		Restaurant restaurant = restaurantService.recupererRestaurant(restaurantId);
		User_ customer = userService.getUser(1L);

		Reservation reservation = new Reservation(dateReservation, slot, customerAmount, restaurant, customer);

		reservation.setReservationState(reservationStateService.getState(1L));

		if (optionId != null) {
			Option optionReservation = optionService.getOption(Long.parseLong(optionId));
			reservation.setOption(optionReservation);
		}

		if (remark != null) {
			reservation.setRemark(remark);
		}

		reservationService.addReservation(reservation);

		return new ModelAndView("redirect:/");
	}

	@GetMapping("/profil/reservations")
	public ModelAndView userPageGet() {
		ModelAndView mav = new ModelAndView();

		mav.addObject("user", userService.getUser(1L));
		mav.addObject("reservations", reservationService.findAllUsersById(1L));

		mav.setViewName("reservationsUserPage");
		return mav;
	}
}
