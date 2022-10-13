package fr.open.restau_resa.controller;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import fr.open.restau_resa.business.Menu;
import fr.open.restau_resa.business.Restaurant;
import fr.open.restau_resa.service.MenuService;
import fr.open.restau_resa.service.RestaurantService;
import fr.open.restau_resa.util.SavefileService;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class MenuController {

	private final SavefileService savefileService;

	private final MenuService menuService;
	private final RestaurantService restaurantService;

	@GetMapping("/professionnal/menu")
	public ModelAndView menuRestaurantGet(@RequestParam(name = "id") Long id) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("restaurant", restaurantService.recupererRestaurant(id));
		mav.setViewName("menuList");

		return mav;
	}

	@GetMapping("/professionnal/menu/add")
	public ModelAndView menuRestaurantAddGet(@RequestParam(name = "id") Long id) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("restaurant", restaurantService.recupererRestaurant(id));
		mav.setViewName("menuAdd");

		return mav;
	}

	@PostMapping("/professionnal/menu/add")
	public ModelAndView menuProfessionnalAddPagePost(@RequestParam(name = "id") Long id,
			@RequestParam(name = "NAME") String name, @RequestParam(name = "DESCRIPTION") String description,
			@RequestParam(name = "PRICE") String price,
			@RequestParam(name = "IMAGE", required = false) MultipartFile multipartFile) throws IOException {

		float priceFloat = Float.parseFloat(price);
		Restaurant restaurant = restaurantService.recupererRestaurant(id);
		Menu menu = new Menu(name, description, priceFloat, restaurant);

		System.out.println(multipartFile);
		String image = multipartFile.getOriginalFilename();

		if (image != "") {
			savefileService.saveFile(image, multipartFile);
			menu.setImg(image);
		}

		menuService.addMenu(menu);

		return new ModelAndView("redirect:/professionnal/restaurants");
	}

	@GetMapping("/professionnal/menu/modify")
	public ModelAndView modifyMenuGet(@RequestParam(name = "id") Long id) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("menu", menuService.getMenu(id));
		mav.setViewName("menuModify");

		return mav;
	}

	@PostMapping("/professionnal/menu/modify")
	public ModelAndView modifyMenuPost(@RequestParam(name = "id") Long id, @RequestParam(name = "NAME") String name,
			@RequestParam(name = "DESCRIPTION") String description, @RequestParam(name = "PRICE") String price) {

		float priceFloat = Float.parseFloat(price);

		menuService.modifyMenu(id, name, description, priceFloat);

		return new ModelAndView("redirect:/professionnal/restaurants");
	}

	@GetMapping("/professionnal/menu/delete")
	public ModelAndView deleteMenutGet(@RequestParam(name = "id") Long id) {

		menuService.deleteMenu(id);

		return new ModelAndView("redirect:/professionnal/restaurants");
	}
}
