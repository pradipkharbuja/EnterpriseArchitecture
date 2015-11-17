package org.pradip.pet.controller;

import javax.validation.Valid;

import org.pradip.pet.model.EmailOwner;
import org.pradip.pet.model.Owner;
import org.pradip.pet.service.EmailOwnerService;
import org.pradip.pet.service.EmailService;
import org.pradip.pet.service.LoginService;
import org.pradip.pet.service.OwnerService;
import org.pradip.pet.service.PetService;
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
@RequestMapping("/owner")
public class OwnerController {

	@Autowired
	private OwnerService ownerService;

	@Autowired
	private LoginService loginService;

	@Autowired
	private PetService petService;

	@Autowired
	private EmailOwnerService emailOwnerService;

	@Autowired
	private EmailService emailService;

	@RequestMapping("")
	public String updateOwner(@ModelAttribute("owner") Owner owner, Model model) {
		model.addAttribute("owner", loginService.getCurrentOwner());

		return "update-profile";
	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	public String updateOwnerPost(@Valid Owner owner, BindingResult result, RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) {
			return "update-profile";
		} else {
			owner.setOwnerId(loginService.getOwnerId());
			ownerService.udpateOwner(owner);
			loginService.doLogin(owner);
			redirectAttributes.addFlashAttribute("successMsg", "Profile updated Successfully.");
			return "redirect:/owner";
		}
	}

	@RequestMapping(value = "/contact/{petId}")
	public String contactOwner(@PathVariable int petId, Model model) {
		model.addAttribute("pet", petService.getPetById(petId));
		return "contact-owner";
	}

	@RequestMapping(value = "/contact/{petId}", method = RequestMethod.POST)
	public String contactOwnerPost(@PathVariable int petId, EmailOwner emailOwner,
			RedirectAttributes redirectAttributes) {

		emailOwner.setPet(petService.getPetById(petId));
		emailOwner.setContactOwner(loginService.getCurrentOwner());

		emailOwnerService.saveEmailRecord(emailOwner);

		redirectAttributes.addFlashAttribute("successMsg", "Thank you! Your email will be sent shortly.");

		if (emailOwner.getPet().getOwner().isInstantEmail()) {
			emailService.sendInstantEmail(emailOwner);
		}

		return "redirect:/owner/contact/" + petId;
	}
}
