package fr.open.restau_resa.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import fr.open.restau_resa.business.Professionnal;
import fr.open.restau_resa.business.User_;
import fr.open.restau_resa.service.ProfessionnalService;
import fr.open.restau_resa.service.UserService;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class UserController {

	private final ProfessionnalService professionnalService;
	private final UserService userService;

	private final HttpSession httpSession;

	@GetMapping("/connexion")
	public ModelAndView userConnexionGet() {
		ModelAndView mav = new ModelAndView();

		mav.setViewName("connexion");
		return mav;
	}

	@PostMapping("/connexion")
	public ModelAndView userConnexionPost(@RequestParam(name = "EMAIL") String email,
			@RequestParam(name = "MDP") String password) {

		User_ user = userService.getUser(email, password);

		Professionnal professionnal = professionnalService.getProfessionnal(email, password);

		if (user == null) {
			return new ModelAndView("redirect:/connexion");
		} else if (professionnal != null) {
			httpSession.setAttribute("professionnal", professionnal);
			return new ModelAndView("redirect:/");
		} else {
			httpSession.setAttribute("customer", user);
			return new ModelAndView("redirect:/");
		}
	}

	@GetMapping("/deconnexion")
	public ModelAndView deconnexionGet() {
		httpSession.invalidate();

		return new ModelAndView("redirect:/connexion");
	}

	@GetMapping("/inscription")
	public ModelAndView userInscriptionGet() {
		ModelAndView mav = new ModelAndView();

		mav.setViewName("inscription");
		return mav;
	}

	@PostMapping("inscription")
	public ModelAndView userInscriptionPost(@RequestParam(name = "FIRSTNAME") String firstName,
			@RequestParam(name = "LASTNAME") String lastName, @RequestParam(name = "PHONE") String phone,
			@RequestParam(name = "EMAIL") String email, @RequestParam(name = "MDP") String password) {

		userService.addUser(firstName, lastName, phone, email, password);

		return new ModelAndView("redirect:/connexion");
	}

	@GetMapping("/inscription/pro")
	public ModelAndView proInscriptionGet() {
		ModelAndView mav = new ModelAndView();

		mav.setViewName("inscriptionPro");
		return mav;
	}

	@PostMapping("inscription/pro")
	public ModelAndView userInscriptionPost(@RequestParam(name = "FIRSTNAME") String firstName,
			@RequestParam(name = "LASTNAME") String lastName, @RequestParam(name = "PHONE") String phone,
			@RequestParam(name = "EMAIL") String email, @RequestParam(name = "MDP") String password,
			@RequestParam(name = "SIRET") String siret) {

		professionnalService.addProfessionnal(firstName, lastName, phone, email, password, siret);

		return new ModelAndView("redirect:/connexion");
	}

	@GetMapping("/profil")
	public ModelAndView userProfilGet() {
		ModelAndView mav = new ModelAndView();

		User_ user = (User_) httpSession.getAttribute("customer");
		mav.addObject("customer", user);

		mav.setViewName("userPage");
		return mav;
	}

	@GetMapping("/profil/reservations")
	public ModelAndView userReservationsGet() {
		ModelAndView mav = new ModelAndView();

		User_ user = (User_) httpSession.getAttribute("customer");
		mav.addObject("customer", user);

		mav.setViewName("reservationsUserPage");
		return mav;
	}
}
