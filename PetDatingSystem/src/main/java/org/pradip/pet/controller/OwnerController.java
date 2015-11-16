package org.pradip.pet.controller;

import javax.validation.Valid;

import org.pradip.pet.model.Owner;
import org.pradip.pet.service.LoginService;
import org.pradip.pet.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
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
			System.out.println("S");
			return "redirect:/owner";
		}
	}

}
