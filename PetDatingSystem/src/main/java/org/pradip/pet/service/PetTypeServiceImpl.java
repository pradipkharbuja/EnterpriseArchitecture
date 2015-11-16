package org.pradip.pet.service;

import java.util.List;

import org.pradip.pet.dao.PetTypeDAO;
import org.pradip.pet.model.PetType;
import org.springframework.beans.factory.annotation.Autowired;

public class PetTypeServiceImpl implements PetTypeService {
	
	@Autowired
	public PetTypeDAO petTypeDAO;

	@Override
	public List<PetType> getAllPetTypes() {
		return petTypeDAO.getAllPetTypes();
	}

}
