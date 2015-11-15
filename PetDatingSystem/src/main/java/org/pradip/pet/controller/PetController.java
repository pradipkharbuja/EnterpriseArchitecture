package org.pradip.pet.controller;

import org.pradip.pet.model.Owner;
import org.pradip.pet.service.LoginService;
import org.pradip.pet.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/pets")
public class PetController {

	@Autowired
	private PetService petService;

	@Autowired
	private LoginService loginService;

	@RequestMapping("")
	public String myPets(Model model) {
		Owner owner = loginService.getCurrentOwner();

		model.addAttribute("listPets", petService.listMyPets(owner));
		return "pet-list";
	}

	@RequestMapping("/all")
	public String all(Model model) {
		model.addAttribute("listPets", petService.listPets());
		return "pet-list";
	}

}
