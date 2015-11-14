package org.pradip.pet.controller;

import org.pradip.pet.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@Autowired
	private PetService petService;

	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("listPets", petService.listPets());

		return "home";
	}
}
