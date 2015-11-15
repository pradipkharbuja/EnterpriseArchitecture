package org.pradip.pet.service;

import org.pradip.pet.model.Owner;

public interface LoginService {

	public boolean isLoggedIn();

	public void doLogin(Owner owner);

	public void doLogout();

	public int getOwnerId();
	
	public Owner getCurrentOwner();
}
