package org.pradip.pet.controller;

import javax.servlet.http.HttpServletResponse;

import org.pradip.pet.model.Owner;
import org.pradip.pet.service.LoginService;
import org.pradip.pet.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Scope("session")
public class HomeController {

	@Autowired
	private PetService petService;

	@Autowired
	private LoginService loginService;

	@RequestMapping("/home")
	public String home(Model model, HttpServletResponse response) {
		Owner owner = loginService.getCurrentOwner();

		model.addAttribute("getAllPets", petService.getOthersPets(owner));
		return "pet-list";
	}
}
