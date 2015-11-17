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
	public List<Pet> getAllPets() {
		return petDAO.getAllPets();
	}

	@Override
	public List<Pet> getOthersPets(Owner owner) {
		return petDAO.getOthersPets(owner);
	}

	@Override
	public List<Pet> getMyPets(Owner owner) {
		return petDAO.getMyPets(owner);
	}

	@Override
	public Pet getPetById(int petId) {
		return petDAO.getPetById(petId);
	}

	@Override
	public void deletePet(Pet pet) {
		petDAO.deletePet(pet);
	}

	@Override
	public void addPet(Pet pet) {
		petDAO.addPet(pet);
	}

	@Override
	public void updatePet(Pet pet) {		
		petDAO.updatePet(pet);
	}

}
