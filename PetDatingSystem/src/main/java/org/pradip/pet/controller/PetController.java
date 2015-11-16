package org.pradip.pet.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.pradip.pet.model.Owner;
import org.pradip.pet.model.Pet;
import org.pradip.pet.service.BreedService;
import org.pradip.pet.service.LoginService;
import org.pradip.pet.service.PetService;
import org.pradip.pet.service.PetTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/pets")
public class PetController {

	@Autowired
	private PetService petService;

	@Autowired
	private LoginService loginService;

	@Autowired
	private PetTypeService petTypeService;

	@Autowired
	private BreedService breedService;

	@RequestMapping("")
	public String myPets(Model model) {
		Owner owner = loginService.getCurrentOwner();

		model.addAttribute("getAllPets", petService.getMyPets(owner));
		return "pet-list";
	}

	@RequestMapping("/all")
	public String all(Model model) {
		model.addAttribute("getAllPets", petService.getAllPets());
		return "pet-list";
	}

	@RequestMapping("/add")
	public String addNewPet(@ModelAttribute("pet") Pet pet, Model model) {
		model.addAttribute("petTypes", petTypeService.getAllPetTypes());
		model.addAttribute("breeds", breedService.getAllBreeds());
		return "pet-add-update";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addNewPetPost(@Valid Pet pet, BindingResult result, Model model,
			RedirectAttributes redirectAttributes) {
		model.addAttribute("petTypes", petTypeService.getAllPetTypes());
		model.addAttribute("breeds", breedService.getAllBreeds());
		return "pet-add-update";
	}

	@RequestMapping(value = "/delete/{petId}")
	public String deletePet(@PathVariable int petId, @ModelAttribute Pet pet, HttpServletRequest request) {
		pet.setPetId(petId);		
		//petService.deletePet(pet);
		return "redirect:" + request.getHeader("Referer");
	}
}
