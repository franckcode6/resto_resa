package fr.open.restau_resa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import fr.open.restau_resa.service.UserService;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class UserController {

	private final UserService userService;

	@GetMapping("/profil")
	public ModelAndView userPageGet() {
		ModelAndView mav = new ModelAndView();

		mav.addObject("user", userService.getUser(1L));

		mav.setViewName("userPage");
		return mav;
	}
}
