package fr.open.restau_resa.initialisation;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.github.javafaker.Faker;

import fr.open.restau_resa.business.Address;
import fr.open.restau_resa.business.Menu;
import fr.open.restau_resa.business.Option;
import fr.open.restau_resa.business.Professionnal;
import fr.open.restau_resa.business.ReservationState;
import fr.open.restau_resa.business.Restaurant;
import fr.open.restau_resa.business.Tag;
import fr.open.restau_resa.business.User_;
import fr.open.restau_resa.dao.AddressDao;
import fr.open.restau_resa.dao.MenuDao;
import fr.open.restau_resa.dao.OptionDao;
import fr.open.restau_resa.dao.ProfessionnalDao;
import fr.open.restau_resa.dao.ReservationStateDao;
import fr.open.restau_resa.dao.RestaurantDao;
import fr.open.restau_resa.dao.TagDao;
import fr.open.restau_resa.dao.UserDao;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class AjoutDonneesInitiales implements CommandLineRunner {

	private final Faker faker = new Faker(new Locale("fr-FR"));

	private static Random random = new Random();

	private final AddressDao addressDao;
	private final MenuDao menuDao;
	private final OptionDao optionDao;
	private final ProfessionnalDao professionnalDao;
	private final ReservationStateDao reservationStateDao;
	private final RestaurantDao restaurantDao;
	private final TagDao tagDao;
	private final UserDao userDao;

	private List<Address> addresses;
	private List<Option> options;
	private List<Professionnal> professionnals;
	private List<ReservationState> reservationStates;
	private List<Restaurant> restaurants;
	private List<Menu> menus;
	private List<Tag> tags;
	private List<User_> users;

	@Override
	public void run(String... args) throws Exception {

		addUsers();
		addTags();
		addAddresses();
		addProfessionnals();
		addRestaurants();
		addMenus();
		addOptions();
		addStates();
	}

	private void addAddresses() {
		if (addressDao.count() == 0) {
			addresses.add(new Address("50", "Rue du cadran", "69003", "Lyon"));
			addresses.add(new Address("10", "Allée du chemin", "06001", "Nice"));
			addresses.add(new Address("2", "Rue de la plaine", "01120", "Montluel"));
			addresses.add(new Address("48", "Rue de Open", "69300", "Villeurbanne"));
			addresses.add(new Address("6", "Allée des sicamores", "00001", "Twin Peaks"));
			addresses.add(new Address("80", "Rue de l'arche", "37000", "Rennes"));
			addressDao.saveAll(addresses);
		}
	}

	private void addMenus() {
		if (menuDao.count() == 0) {
			menus.add(new Menu("Soupe de poireaux", "Soupe traditionelle, parfaite en hiver", 7.80, "soupe.jpg",
					restaurants.get(0)));
			menus.add(new Menu("Pizza", "Large choix de pizzas, prix unique!", 12.50, "pizza.jpg", restaurants.get(0)));
			menus.add(new Menu("Bistrot Burger", "Le meme, en plus cher", 18.00, "burger.jpg", restaurants.get(2)));
			menus.add(new Menu("Spaghetti bolognaise", "La recette traditionelle.", 11.50, "sphagetti.jpg",
					restaurants.get(4)));
			menus.add(new Menu("Ceviche", "El famoso Ceviche de poisson, le 2nd plat préféré de Victor", 7.80,
					"ceviche.jpg", restaurants.get(3)));
			menus.add(new Menu("Tacos", "Tacos, n-viandes + frites + boisson", 6.50, "tacos.jpg", restaurants.get(0)));
			menuDao.saveAll(menus);
		}
	}

	private void addOptions() {
		if (optionDao.count() == 0) {
			options.add(new Option("Anniversaire"));
			options.add(new Option("A emporter"));
			options.add(new Option("Bébé"));
			options.add(new Option("Allergies alimentaire"));
			options.add(new Option("Repas entreprise"));
			optionDao.saveAll(options);
		}
	}

	private void addProfessionnals() {
		if (professionnalDao.count() == 0) {
			professionnals.add(new Professionnal("Michel", "Cuillière", "0102030405", "michel@restaurant.fr", "12345",
					"55217863900132"));

			for (int i = 0; i < 5; i++) {
				professionnals.add(new Professionnal(faker.name().firstName(), faker.name().lastName(), "0102030405",
						faker.internet().emailAddress(), "12345", String.valueOf(random.nextLong(1000000000000L))));
			}

			professionnalDao.saveAll(professionnals);
		}
	}

	private void addRestaurants() {
		if (restaurantDao.count() == 0) {
			// Ajout de tags randoms pour chaque restaurants
			List<Tag> tagsRestaurant = new ArrayList<>();
			for (int i = 0; i < 2; i++) {
				tagsRestaurant.add(tags.get(random.nextInt(tags.size())));
			}

			restaurants.add(new Restaurant("La bonne adresse", "0102030405", "labonneadresse@mail.fr",
					"Restaurant proposant une cuisine traditionnelle de qualité", true, "img1.jpg",
					professionnalDao.findById((long) 22).orElse(null), addressDao.findById((long) 1).orElse(null),
					tagsRestaurant));

			for (int i = 1; i < 5; i++) {
				tagsRestaurant = new ArrayList<>();
				for (int y = 0; y < 2; y++) {
					tagsRestaurant.add(tags.get(random.nextInt(tags.size())));
				}
				restaurants.add(new Restaurant("Restaurant random " + i, "0102030405", faker.internet().emailAddress(),
						"Ceci est la description " + i, true, "restau" + i + ".jpg", professionnals.get(i),
						addresses.get(i), tagsRestaurant));
			}
			restaurantDao.saveAll(restaurants);
		}
	}

	private void addStates() {
		if (reservationStateDao.count() == 0) {
			reservationStates.add(new ReservationState("Reçue"));
			reservationStates.add(new ReservationState("Validée"));
			reservationStates.add(new ReservationState("Terminée"));
			reservationStates.add(new ReservationState("Annulée"));
			reservationStateDao.saveAll(reservationStates);
		}
	}

	private void addTags() {
		if (tagDao.count() == 0) {
			tags.add(new Tag("Cuisine du monde"));
			tags.add(new Tag("Cuisine traditionnelle"));
			tags.add(new Tag("Street Food"));
			tags.add(new Tag("Fast Food"));
			tags.add(new Tag("Cantine"));
			tags.add(new Tag("A emporter"));
			tags.add(new Tag("Veggie"));
			tagDao.saveAll(tags);
		}
	}

	private void addUsers() {
		if (userDao.count() == 0) {
			users.add(new User_("Franck", "Quasevi", "0102030405", "franck@test.fr", "12345"));

			for (int i = 0; i < 20; i++) {
				users.add(new User_(faker.name().firstName(), faker.name().lastName(), "0102030405",
						faker.internet().emailAddress(), "12345"));
			}

			userDao.saveAll(users);
		}
	}
}
