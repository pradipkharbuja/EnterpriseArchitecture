package org.pradip.pet.dao;

import java.util.List;

import org.pradip.pet.model.Owner;
import org.pradip.pet.model.Pet;

public interface PetDAO {

	public List<Pet> listPets();

	public List<Pet> listOthersPets(Owner owner);

	public List<Pet> listMyPets(Owner owner);

	public Pet getPetById(int petId);
}
