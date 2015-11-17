package org.pradip.pet.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.pradip.pet.model.Comment;
import org.pradip.pet.model.Owner;
import org.pradip.pet.model.Pet;
import org.pradip.pet.service.BreedService;
import org.pradip.pet.service.CommentService;
import org.pradip.pet.service.LoginService;
import org.pradip.pet.service.PetService;
import org.pradip.pet.service.PetTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.support.ByteArrayMultipartFileEditor;
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

	@Autowired
	private CommentService commentService;

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
		if (result.hasErrors()) {
			return "pet-add-update";
		} else {
			pet.setOwner(loginService.getCurrentOwner());

			if (pet.getPetPhoto().length == 0) {
				System.out.println("Image is null");
				pet.setPetPhoto(null);
			}

			petService.addPet(pet);
			return "redirect:/pets";
		}
	}

	@RequestMapping(value = "/update/{petId}")
	public String updatePet(@PathVariable int petId, Model model) {
		model.addAttribute("petTypes", petTypeService.getAllPetTypes());
		model.addAttribute("breeds", breedService.getAllBreeds());
		model.addAttribute("pet", petService.getPetById(petId));
		return "pet-add-update";
	}

	@RequestMapping(value = "/update/{petId}", method = RequestMethod.POST)
	public String updatePetPost(@PathVariable int petId, @Valid Pet pet, BindingResult bindingResult,
			RedirectAttributes redirectAttributes, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("petTypes", petTypeService.getAllPetTypes());
			model.addAttribute("breeds", breedService.getAllBreeds());
			model.addAttribute("pet", petService.getPetById(petId));
			return "pet-add-update";
		} else {
			pet.setPetId(petId);
			pet.setOwner(loginService.getCurrentOwner());

			if (pet.getPetPhoto().length == 0) {
				pet.setPetPhoto(null);
			}

			petService.updatePet(pet);
			redirectAttributes.addFlashAttribute("successMsg", "Updated Successfully!");
			return "redirect:/pets/update/" + petId;
		}
	}

	@RequestMapping(value = "/delete/{petId}")
	public String deletePet(@PathVariable int petId, @ModelAttribute Pet pet, HttpServletRequest request) {
		pet.setPetId(petId);
		petService.deletePet(pet);
		return "redirect:" + request.getHeader("Referer");
	}

	@RequestMapping("/details/{petId}")
	public String petDetails(@PathVariable int petId, Model model) {
		model.addAttribute("pet", petService.getPetById(petId));
		model.addAttribute("comments", commentService.getCommentsByPetId(petId));
		return "pet-details";
	}

	@RequestMapping(value = "/details/{petId}", method = RequestMethod.POST)
	public String petDetailsPost(@PathVariable int petId, Comment comment) {

		comment.setOwner(loginService.getCurrentOwner());
		comment.setPet(petService.getPetById(petId));

		commentService.addComment(comment);

		return "redirect:/pets/details/" + petId;
	}

	// This method is called before executing any controller method
	@InitBinder
	public void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) {
		// Convert multipart object to byte[]
		binder.registerCustomEditor(byte[].class, new ByteArrayMultipartFileEditor());
	}
}
