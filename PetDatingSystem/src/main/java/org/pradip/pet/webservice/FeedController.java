package org.pradip.pet.webservice;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.pradip.pet.model.Pet;
import org.pradip.pet.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FeedController {

	@Autowired
	private PetService petService;

	@RequestMapping("/rss")
	public ModelAndView index(HttpServletResponse response) {
		List<Pet> pets = petService.getAllPets();

		ModelAndView mav = new ModelAndView();
		mav.setViewName("rss/rssViewer");
		mav.addObject("feedContent", pets);
		response.setHeader("Content-Type" , "application/xml");		
		
		return mav;
	}
}
