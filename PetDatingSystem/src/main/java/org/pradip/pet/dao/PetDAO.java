package org.pradip.pet.dao;

import java.util.List;

import org.pradip.pet.model.Owner;
import org.pradip.pet.model.Pet;

public interface PetDAO {

	public List<Pet> getAllPets();

	public List<Pet> getOthersPets(Owner owner);

	public List<Pet> getMyPets(Owner owner);

	public Pet getPetById(int petId);
	
	public void deletePet(Pet pet);
}
