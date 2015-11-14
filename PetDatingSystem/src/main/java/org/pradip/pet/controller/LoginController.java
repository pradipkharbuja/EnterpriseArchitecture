package org.pradip.pet.controller;

import org.pradip.pet.model.Owner;
import org.pradip.pet.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

	@Autowired
	private OwnerService ownerService;

	@RequestMapping("/")
	public String login(@ModelAttribute("owner") Owner owner) {
		return "login";
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String loginPost(@ModelAttribute("owner") Owner owner, Model model) {
		if (ownerService.isValidUser(owner)) {
			return "footer";
		} else {
			model.addAttribute("loginError", "Invalid Username / Password!");
			return "login";
		}
	}

}
