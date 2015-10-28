package org.ea.lab3.control;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MainClass {

	private static EntityManagerFactory entityManager;

	static {
		entityManager = Persistence.createEntityManagerFactory("cs544_lab3");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		entityManager.close();
	}

}
