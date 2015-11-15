package org.pradip.pet.service;

import java.util.List;

import org.pradip.pet.dao.OwnerDAO;
import org.pradip.pet.model.Owner;

public class OwnerServiceImpl implements OwnerService {

	private OwnerDAO ownerDAO;

	public void setOwnerDAO(OwnerDAO ownerDAO) {
		this.ownerDAO = ownerDAO;
	}

	@Override
	public void addOwner(Owner owner) {
		this.ownerDAO.addOwner(owner);
	}

	@Override
	public void udpateOwner(Owner owner) {
		this.ownerDAO.udpateOwner(owner);
	}

	@Override
	public List<Owner> listOwners() {
		return this.ownerDAO.listOwners();
	}

	@Override
	public Owner getOwner(Owner owner) {
		return this.ownerDAO.getOwner(owner);
	}

	@Override
	public boolean isValidOwner(Owner owner) {
		return this.ownerDAO.isValidOwner(owner);
	}

}
