package org.pradip.pet.dao;

import java.util.List;

import org.pradip.pet.model.Pet;

public interface PetDAO {

	//public void addOwner(Owner owner);

	//public void udpateOwner(Owner owner);

	public List<Pet> listPets();
}
