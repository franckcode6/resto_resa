package fr.open.restau_resa.controller;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import fr.open.restau_resa.business.Address;
import fr.open.restau_resa.business.Menu;
import fr.open.restau_resa.business.Professionnal;
import fr.open.restau_resa.business.Restaurant;
import fr.open.restau_resa.business.Tag;
import fr.open.restau_resa.service.AddressService;
import fr.open.restau_resa.service.MenuService;
import fr.open.restau_resa.service.ProfessionnalService;
import fr.open.restau_resa.service.RestaurantService;
import fr.open.restau_resa.service.TagService;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class ProfessionnalController {

	protected final static String IMAGE_FOLDER = "src/main/Webapp/images/";

	private final AddressService addressService;
	private final MenuService menuService;
	private final ProfessionnalService professionnalService;
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
		mav.addObject("professionnal", professionnalService.getProfessionnal(professionnal.getId()));

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

		System.out.println(multipartFile);
		String image = multipartFile.getOriginalFilename();

		if (image != "") {
			saveFile(image, multipartFile);
			restaurant.setImage(image);
		}

		if (tags != null) {
			restaurant.setTags(tags);
		}

		restaurantService.addRestaurant(restaurant);

		return new ModelAndView("redirect:/professionnal/restaurants");
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

		System.out.println(id);
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
			@RequestParam(name = "NAME") String name,
			@RequestParam(name = "DESCRIPTION") String description,
			@RequestParam(name = "PRICE") String price,
			@RequestParam(name = "IMAGE", required = false) MultipartFile multipartFile) throws IOException {

		float priceFloat = Float.parseFloat(price);
		Restaurant restaurant = restaurantService.recupererRestaurant(id);
		Menu menu = new Menu(name, description, priceFloat, restaurant);

		System.out.println(multipartFile);
		String image = multipartFile.getOriginalFilename();

		if (image != "") {
			saveFile(image, multipartFile);
			menu.setImg(image);
		}

		menuService.addMenu(menu);

		return new ModelAndView("redirect:/professionnal/restaurants");
	}
	
	@GetMapping("/professionnal/menu/delete")
	public ModelAndView deleteMenutGet(@RequestParam(name = "id") Long id) {

		menuService.deleteMenu(id);

		return new ModelAndView("redirect:/professionnal/restaurants");
	}
	
	/**
	 * Method to save image file
	 * 
	 * @param nom
	 * @param multipartFile
	 * @throws IOException
	 */
	protected static void saveFile(String nom, MultipartFile multipartFile) throws IOException {
		Path chemin = Paths.get(IMAGE_FOLDER);

		if (!Files.exists(chemin)) {
			Files.createDirectories(chemin);
		}

		try (InputStream inputStream = multipartFile.getInputStream()) {
			Path cheminFichier = chemin.resolve(nom);
			System.out.println(cheminFichier);
			Files.copy(inputStream, cheminFichier, StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException ioe) {
			throw new IOException("Erreur d'écriture : " + nom, ioe);
		}
	}

	@GetMapping("/professionnal/restaurants/modify")
	public ModelAndView modifyRestaurantGet(@RequestParam(name = "id") Long id) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("restaurant", restaurantService.recupererRestaurant(id));
		mav.addObject("tags", tagService.getAllTags());
		mav.setViewName("restaurantModify");

		return mav;
	}
}
