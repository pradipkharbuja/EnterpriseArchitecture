package org.pradip.pet.service;

import javax.servlet.http.HttpSession;

import org.pradip.pet.dao.OwnerDAO;
import org.pradip.pet.model.Owner;
import org.springframework.beans.factory.annotation.Autowired;

public class LoginServiceImpl implements LoginService {

	@Autowired
	private HttpSession session;

	@Autowired
	private OwnerDAO ownerDAO;
	
	private final String ID = "ownerId";
	private final String OWNER_NAME = "ownerName";

	@Override
	public boolean isLoggedIn() {
		if (session.getAttribute(ID) == null || session.getAttribute(ID).equals(0)) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public void doLogin(Owner owner) {		
		session.setAttribute(ID, owner.getOwnerId());
		session.setAttribute(OWNER_NAME, owner.getOwnerName());
	}

	@Override
	public void doLogout() {
		session.setAttribute(ID, null);
	}

	@Override
	public int getOwnerId() {
		if (session.getAttribute(ID) == null) {
			return 0;
		}
		return Integer.parseInt(session.getAttribute(ID).toString());
	}

	@Override
	public Owner getCurrentOwner() {
		Owner owner = ownerDAO.getOwnerById(this.getOwnerId());		
		return owner;
	}
}
