package org.pradip.pet.service;

import java.util.List;

import org.pradip.pet.model.Owner;
import org.pradip.pet.model.Pet;

public interface PetService {
	public List<Pet> listPets();

	public List<Pet> listOthersPets(Owner owner);

	public List<Pet> listMyPets(Owner owner);

	public Pet getPetById(int petId);
}
