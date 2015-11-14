package org.pradip.pet.controller;

import org.pradip.pet.model.Owner;
import org.pradip.pet.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/owner")
public class OwnerController {

	@Autowired
	private OwnerService ownerService;

	private static final String FOLDER = "owner/";

	@RequestMapping("")
	public String listOwners() {
		return FOLDER + "list";
	}

	@RequestMapping("/add")
	public String addOwner() {

		Owner owner = new Owner();
		owner.setUserName("pradip");
		owner.setOwnerName("Pradip Kharbuja");

		ownerService.addOwner(owner);

		return FOLDER + "welcome";
	}

}
