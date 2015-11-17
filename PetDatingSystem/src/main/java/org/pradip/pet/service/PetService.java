package org.pradip.pet.service;

import java.util.List;

import org.pradip.pet.model.Owner;
import org.pradip.pet.model.Pet;

public interface PetService {
	public List<Pet> getAllPets();

	public List<Pet> getOthersPets(Owner owner);

	public List<Pet> getMyPets(Owner owner);

	public Pet getPetById(int petId);
	
	public void deletePet(Pet pet);
	
	public void addPet(Pet pet);
	
	public void updatePet(Pet pet);
}
