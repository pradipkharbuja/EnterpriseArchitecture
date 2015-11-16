package org.pradip.pet.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.http.HttpServletResponse;

import org.pradip.pet.model.Pet;
import org.pradip.pet.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Scope("session")
public class ImageController {

	@Autowired
	private PetService petService;

	@RequestMapping("/image/{petId}")
	public void index(@PathVariable int petId, HttpServletResponse response) throws IOException, URISyntaxException {

		Pet pet = petService.getPetById(petId);

		byte[] image = pet.getPetPhoto();

		if (image == null) {
			Path path = Paths.get(ImageController.class.getClassLoader().getResource("image-unavailable.jpg").toURI());
			image = Files.readAllBytes(path);
		}
		
		// get MIME type of the file
		String mimeType = "application/octet-stream";

		// set content attributes for the response
		response.setContentType(mimeType);
		response.setContentLength((int) image.length);

		// set headers for the response
		String headerKey = "Content-Disposition";
		String headerValue = String.format("attachment; filename=image.jpeg");
		response.setHeader(headerKey, headerValue);

		// get output stream of the response
		OutputStream outStream = response.getOutputStream();

		// get input stream and a fixed size buffer
		InputStream is = new ByteArrayInputStream(image);
		byte[] buffer = new byte[4096];

		// write data into output stream
		int read = -1;
		while ((read = is.read(buffer)) != -1) {
			outStream.write(buffer, 0, read);
		}

		// close output stream
		outStream.flush();
		outStream.close();
	}

}
