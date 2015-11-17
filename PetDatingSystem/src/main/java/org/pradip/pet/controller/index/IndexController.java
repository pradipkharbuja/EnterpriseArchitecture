package org.pradip.pet.controller.index;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	// This controller is moved to this package to skip the advice.

	@RequestMapping("/")
	public String index() {
		return "redirect:/home";
	}
}
