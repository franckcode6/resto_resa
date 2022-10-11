package fr.open.restau_resa.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import fr.open.restau_resa.business.Professionnal;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class ProfessionnalController {

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
}
