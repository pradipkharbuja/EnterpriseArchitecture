package org.pradip.pet.service;

import java.util.List;

import org.pradip.pet.dao.PetDAO;
import org.pradip.pet.model.Pet;

public class PetServiceImpl implements PetService {

	private PetDAO petDAO;

	public void setPetDAO(PetDAO petDAO) {
		this.petDAO = petDAO;
	}

	@Override
	public List<Pet> listPets() {
		return petDAO.listPets();
	}

}
