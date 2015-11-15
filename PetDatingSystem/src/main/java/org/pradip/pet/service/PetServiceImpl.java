package org.pradip.pet.service;

import java.util.List;

import org.pradip.pet.dao.PetDAO;
import org.pradip.pet.model.Owner;
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

	@Override
	public List<Pet> listOthersPets(Owner owner) {
		return petDAO.listOthersPets(owner);
	}

	@Override
	public List<Pet> listMyPets(Owner owner) {
		return petDAO.listMyPets(owner);
	}

	@Override
	public Pet getPetById(int petId) {		
		return petDAO.getPetById(petId);
	}

}
