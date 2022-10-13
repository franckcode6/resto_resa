package fr.open.restau_resa.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;

import fr.open.restau_resa.service.AddressService;
import fr.open.restau_resa.service.MenuService;
import fr.open.restau_resa.service.ProfessionnalService;
import fr.open.restau_resa.service.RestaurantService;
import fr.open.restau_resa.service.TagService;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class MenuController {

	protected final static String IMAGE_FOLDER = "src/main/Webapp/images/";

	private final AddressService addressService;
	private final MenuService menuService;
	private final ProfessionnalService professionnalService;
	private final RestaurantService restaurantService;
	private final TagService tagService;

	private final HttpSession httpSession;
}
