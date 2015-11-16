package org.pradip.pet.controller.login;

import javax.validation.Valid;

import org.pradip.pet.model.Owner;
import org.pradip.pet.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller

public class RegisterController {

	@Autowired
	private OwnerService ownerService;

	@RequestMapping("/register")
	public String register(@ModelAttribute("owner") Owner owner) {
		return "register";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerPost(@Valid Owner owner, BindingResult result) {
		if (result.hasErrors()) {
			return "register";
		} else {
			ownerService.addOwner(owner);
			return "redirect:/login";
		}
	}
}
