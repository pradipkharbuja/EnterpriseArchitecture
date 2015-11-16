package org.pradip.pet.controller.login;

import org.pradip.pet.model.Owner;
import org.pradip.pet.service.LoginService;
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

	@Autowired
	private LoginService loginService;

	@RequestMapping("/login")
	public String login(@ModelAttribute("owner") Owner owner) {
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginPost(@ModelAttribute("owner") Owner owner, Model model) {
		Owner newOwner = ownerService.getOwner(owner);

		if (ownerService.isValidOwner(newOwner)) {
			loginService.doLogin(newOwner);
			return "redirect:/";
		} else {
			model.addAttribute("loginError", "Invalid Username / Password!");
			return "login";
		}
	}

	@RequestMapping("/logout")
	public String logout() {
		loginService.doLogout();
		return "redirect:/";
	}
}
