package org.pradip.pet.webservice;

import java.util.List;

import org.pradip.pet.model.Pet;
import org.pradip.pet.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RSSFeedController {

	@Autowired
	private PetService petService;

	@RequestMapping(value = "/rss", method = RequestMethod.GET, produces = "text/xml; charset=utf-8")
	public @ResponseBody String index() {

		String site_url = "http://localhost:8080/PetDatingSystem/";

		String result = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n<rss version=\"2.0\">";

		result += "<channel>\n";
		result += "<title>Pet Dating System</title>\n";
		result += String.format("<link>%s</link>\n", site_url);
		result += "<description>Free online web based Dating System</description>";

		List<Pet> pets = petService.getAllPets();

		for (Pet pet : pets) {
			result += "\t<item>";

			result += String.format("\t\t<title>%s</title>\n", pet.getPetName());

			result += String.format("\t\t<link>%spets/details/%d</link>\n", site_url, pet.getPetId());

			result += String.format(
					"\t\t<description>Pet Type: %s; Breed: %s; Owner Name: %s, City: %s</description>\n",
					pet.getBreed().getPetType().getPetType(), pet.getBreed().getBreedName(),
					pet.getOwner().getOwnerName(), pet.getOwner().getCity());

			result += "\t</item>\n";
		}

		result += "</channel>\n</rss>";

		return result;
	}
}
