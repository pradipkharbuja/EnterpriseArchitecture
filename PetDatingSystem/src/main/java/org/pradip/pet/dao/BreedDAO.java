package org.pradip.pet.dao;

import java.util.List;

import org.pradip.pet.model.Breed;
import org.pradip.pet.model.PetType;

public interface BreedDAO {
	public List<Breed> getAllBreeds();

	public List<Breed> getBreedByPetType(PetType petType);
}
