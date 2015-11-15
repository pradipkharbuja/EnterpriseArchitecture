package org.pradip.pet.controller;

import org.pradip.pet.model.Owner;
import org.pradip.pet.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/owner")
public class OwnerController {

	@Autowired
	private OwnerService ownerService;

	@RequestMapping("")
	public String updateOwner(@ModelAttribute("owner") Owner owner) {
		return "update-profile";
	}

}
