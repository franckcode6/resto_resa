package fr.open.restau_resa.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import fr.open.restau_resa.business.Address;
import fr.open.restau_resa.business.Professionnal;
import fr.open.restau_resa.business.Restaurant;
import fr.open.restau_resa.business.Tag;
import fr.open.restau_resa.service.AddressService;
import fr.open.restau_resa.service.ProfessionnalService;
import fr.open.restau_resa.service.ReservationService;
import fr.open.restau_resa.service.RestaurantService;
import fr.open.restau_resa.service.TagService;
import fr.open.restau_resa.util.SavefileService;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class ProfessionnalController {

	private final SavefileService savefileService;

	private final AddressService addressService;
	private final ProfessionnalService professionnalService;
	private final ReservationService reservationService;
	private final RestaurantService restaurantService;
	private final TagService tagService;

	private final HttpSession httpSession;

	/**
	 * Show the professionnal's profil
	 * 
	 * @return
	 */
	@GetMapping("/professionnal")
	public ModelAndView professionnalPageGet() {
		ModelAndView mav = new ModelAndView();

		Professionnal professionnal = (Professionnal) httpSession.getAttribute("professionnal");
		mav.addObject("professionnal", professionnal);

		mav.setViewName("user/professionnalPage");
		return mav;
	}

	/**
	 * Show the professionnal's restaurants
	 * 
	 * @return
	 */
	@GetMapping("/professionnal/restaurants")
	public ModelAndView restaurantProfessionnalPageGet() {
		ModelAndView mav = new ModelAndView();

		Professionnal professionnal = (Professionnal) httpSession.getAttribute("professionnal");
		mav.addObject("professionnal", professionnalService.getProfessionnal(professionnal.getId()));

		mav.setViewName("restaurant/restaurantProfessionnalPage");
		return mav;
	}

	/**
	 * Restaurant adding form
	 * 
	 * @return
	 */
	@GetMapping("/professionnal/restaurants/add")
	public ModelAndView restaurantProfessionnalAddPageGet() {
		ModelAndView mav = new ModelAndView();

		Professionnal professionnal = (Professionnal) httpSession.getAttribute("professionnal");
		mav.addObject("professionnal", professionnal);
		mav.addObject("tags", tagService.getAllTags());

		mav.setViewName("restaurant/restaurantAdd");
		return mav;
	}

	@PostMapping("/professionnal/restaurants/add")
	public ModelAndView restaurantProfessionnalAddPagePost(@RequestParam(name = "NAME") String name,
			@RequestParam(name = "PHONE") String phone, @RequestParam(name = "EMAIL") String email,
			@RequestParam(name = "DESCRIPTION") String description,
			@RequestParam(name = "TAG", required = false) List<Tag> tags,
			@RequestParam(name = "DISABLED", required = false) boolean disabled,
			@RequestParam(name = "NOADDRESS") String noAddress, @RequestParam(name = "ADDRESS") String address,
			@RequestParam(name = "POSTALCODE") String postalCode, @RequestParam(name = "CITY") String city,
			@RequestParam(name = "IMAGE", required = false) MultipartFile multipartFile) throws IOException {

		Professionnal professionnal = (Professionnal) httpSession.getAttribute("professionnal");
		Address restaurantAddress = new Address(noAddress, address, postalCode, city);

		addressService.addAddress(restaurantAddress);

		Restaurant restaurant = new Restaurant(name, phone, email, description, disabled, professionnal,
				restaurantAddress);

		String image = multipartFile.getOriginalFilename();

		// If image, use the savefileService to upload it
		if (image != "") {
			savefileService.saveFile(image, multipartFile);
			restaurant.setImage(image);
		}

		if (tags != null) {
			restaurant.setTags(tags);
		}

		restaurantService.addRestaurant(restaurant);

		return new ModelAndView("redirect:/professionnal/restaurants");
	}

	/**
	 * Modify the restaurants informations
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/professionnal/restaurants/modify")
	public ModelAndView modifyRestaurantGet(@RequestParam(name = "id") Long id) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("restaurant", restaurantService.recupererRestaurant(id));
		mav.addObject("tags", tagService.getAllTags());
		mav.setViewName("restaurant/restaurantModify");

		return mav;
	}

	@PostMapping("/professionnal/restaurants/modify")
	public ModelAndView restaurantProfessionnalModifyPagePost(@RequestParam(name = "id") Long id,
			@RequestParam(name = "NAME") String name, @RequestParam(name = "PHONE") String phone,
			@RequestParam(name = "EMAIL") String email, @RequestParam(name = "DESCRIPTION") String description,
			@RequestParam(name = "TAG", required = false) List<Tag> tags,
			@RequestParam(name = "DISABLED", required = false) boolean disabled,
			@RequestParam(name = "NOADDRESS") String noAddress, @RequestParam(name = "ADDRESS") String address,
			@RequestParam(name = "POSTALCODE") String postalCode, @RequestParam(name = "CITY") String city)
			throws IOException {

		Restaurant restaurant = restaurantService.recupererRestaurant(id);
		Address restaurantAddress = addressService.findById(restaurant.getAddress().getId());
		Professionnal professionnal = (Professionnal) httpSession.getAttribute("professionnal");

		Address newRestaurantAddress = addressService.modifyAddress(restaurantAddress.getId(), noAddress, address,
				postalCode, city);

		restaurantService.modifyRestaurant(id, name, phone, email, description, tags, disabled, professionnal,
				newRestaurantAddress);

		return new ModelAndView("redirect:/professionnal/restaurants");
	}

	@GetMapping("/professionnal/restaurants/delete")
	public ModelAndView deleteRestaurantGet(@RequestParam(name = "id") Long id) {

		restaurantService.deleteRestaurant(id);

		return new ModelAndView("redirect:/professionnal/restaurants");
	}

	/**
	 * Reservations linked to the professionnal
	 * 
	 * @return
	 */
	@GetMapping("/professionnal/reservations")
	public ModelAndView professionnalReservationsGet() {
		ModelAndView mav = new ModelAndView();

		Professionnal professionnal = (Professionnal) httpSession.getAttribute("professionnal");

		mav.addObject("professionnal", professionnalService.getProfessionnal(professionnal.getId()));

		// mav.addObject("reservations",
		// reservationService.findAllByProfessionnalId(professionnal.getId()));

		mav.setViewName("reservation/reservationsProfessionnalPage");
		return mav;
	}

	/**
	 * Validate the reservation in pending
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/professionnal/reservations/validate")
	public ModelAndView validateReservationGet(@RequestParam(name = "id") Long id) {

		reservationService.validateReservation(id);

		return new ModelAndView("redirect:/professionnal/reservations");
	}

	/**
	 * Cancel the reservation in pending
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/professionnal/reservations/cancel")
	public ModelAndView cancelReservationGet(@RequestParam(name = "id") Long id) {

		reservationService.cancelReservation(id);

		return new ModelAndView("redirect:/professionnal/reservations");
	}
}
