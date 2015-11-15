package org.pradip.pet.service;

import java.util.List;

import org.pradip.pet.model.Owner;

public interface OwnerService {

	public void addOwner(Owner owner);

	public void udpateOwner(Owner owner);

	public List<Owner> listOwners();

	public Owner getOwner(Owner owner);
	
	public boolean isValidOwner(Owner owner);
}
