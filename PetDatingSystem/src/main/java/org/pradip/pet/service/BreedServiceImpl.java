package org.pradip.pet.service;

import java.util.List;

import org.pradip.pet.dao.BreedDAO;
import org.pradip.pet.model.Breed;
import org.springframework.beans.factory.annotation.Autowired;

public class BreedServiceImpl implements BreedService {

	@Autowired
	private BreedDAO breedDAO;

	@Override
	public List<Breed> getAllBreeds() {
		return breedDAO.getAllBreeds();
	}

}
