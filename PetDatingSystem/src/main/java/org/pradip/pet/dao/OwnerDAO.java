package org.pradip.pet.dao;

import java.util.List;

import org.pradip.pet.model.Owner;

public interface OwnerDAO {

	public void addOwner(Owner owner);

	public void udpateOwner(Owner owner);

	public List<Owner> listOwners();
}
