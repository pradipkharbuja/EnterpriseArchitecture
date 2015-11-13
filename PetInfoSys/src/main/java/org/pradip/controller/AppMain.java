package org.pradip.controller;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AppMain {

	private static EntityManagerFactory entityManager;

	public static void main(String[] args) {
		try{
		entityManager = Persistence.createEntityManagerFactory("pet_infosys");
		}catch(Exception ex){
			ex.printStackTrace();
		} finally {
			entityManager.close();
		}
	}

}
