package cs544.lab04_1;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

import org.apache.log4j.Logger;

import cs544.lab04_1.model.Airline;
import cs544.lab04_1.model.Airplane;
import cs544.lab04_1.model.Airport;
import cs544.lab04_1.model.Flight;

public class App {
	private static Logger logger = Logger.getLogger(App.class);;

	private static final EntityManagerFactory emf;

	static {
		try {
			emf = Persistence.createEntityManagerFactory("cs544");
		} catch (Throwable ex) {
			ex.printStackTrace();
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static void main(String[] args) {
		EntityManager em = null;
		EntityTransaction tx = null;

		// fill the database
		fillDataBase();

		// Flights leaving USA capacity > 500
		try {
			em = emf.createEntityManager();
			tx = em.getTransaction();
			tx.begin();

			logger.trace("List all the flights:");
			displayFlightResult(em, "from Flight");
			
			logger.trace("\nList all the flights leaving USA with capacity > 500:");
			displayFlightResult(em, "from Flight WHERE origin.country LIKE 'USA' AND airplane.capacity > 500");
			
			logger.trace("\nList all airlines that use A380 (model) airplanes:");
			displayAirlineResult(em, "SELECT DISTINCT a from Airline a JOIN a.flights f "
					+ "JOIN f.airplane fa "
					+ "WHERE fa.model LIKE 'A380'");
			
			logger.trace("List all the fights using 747 planes that don’t belong to ‘Star Alliance’:");
			displayFlightResult(em, "from Flight WHERE airplane.model LIKE '747' AND airline.name <> 'Star Alliance'");
			
			logger.trace("List all the flights leaving before 12pm on 08/07/2009 :");
			displayFlightResult(em, "from Flight WHERE departureDate = '2009-08-06' and departureTime < '14:00'");
			
			
			tx.commit();
		} catch (PersistenceException e) {
			if (tx != null) {
				logger.error("Rolling back:", e);
				tx.rollback();
			}
		} finally {
			if (em != null) {
				em.close();
				emf.close();
			}
		}

	}
	
	public static void displayFlightResult(EntityManager em, String query){
		List<Flight> flights = em.createQuery(query, Flight.class).getResultList();
		logger.trace(String.format("%-9s%-31s%-31s", "Flight:", "Departs:",
				"Arrives:"));
		for (Flight flight : flights) {
			logger.trace(String.format(
					"%-7s  %-12s %7s %8s  %-12s %7s %8s",
					flight.getFlightnr(), flight.getOrigin().getCity(),
					flight.getDepartureDate(), flight.getDepartureTime(),
					flight.getDestination().getCity(),
					flight.getArrivalDate(), flight.getArrivalTime()));
		}
	}
	
	public static void displayAirlineResult(EntityManager em, String query){
		List<Airline> airlines = em.createQuery(query, Airline.class).getResultList();
		logger.trace(String.format("%-9s%-31s%-31s", "Flight:", "Departs:",
				"Arrives:"));
		for (Airline airline : airlines) {
			logger.trace(String.format(
					"%s", airline.getName()));
		}
	}
	
	public static void fillDataBase() {
		EntityManager em = null;
		EntityTransaction tx = null;

		try {

			Airport ams = new Airport("AMS", "Schiphol", "Amsterdam", "The Netherlands");
			Airport lhr = new Airport("LHR", "London Heathrow", "London", "UK");
			Airport fra = new Airport("FRA", "Frankfurt International Airport", "Frankfurt", "Germany");
			Airport dtw = new Airport("DTW", "Detroid City", "Detroid", "USA");
			Airport ord = new Airport("ORD", "Chicago O'hare International", "Chicago", "USA");
			Airport lax = new Airport("LAX", "Los Angeles International", "Los Angeles", "USA");
			Airport jfk = new Airport("JFK", "John F. Kennedy International", "New York", "USA");
			Airport nrt = new Airport("NRT", "Narita International Airport", "Tokyo", "Japan");
			Airport syd = new Airport("SYD", "Kingsford Smith", "Sydney", "Australia");
			Airport sin = new Airport("SIN", "Changi Airport", "Singapore", "Singapore");

			Airplane airplane1 = new Airplane("12345", "A380", 519);
			Airplane airplane2 = new Airplane("54321", "747", 416);
			Airplane airplane3 = new Airplane("23451", "A380", 519);
			Airplane airplane4 = new Airplane("43215", "747", 416);
			Airplane airplane5 = new Airplane("34512", "A380", 519);
			Airplane airplane6 = new Airplane("32154", "747", 416);

			Airline airline1 = new Airline("SkyTeam");
			Airline airline2 = new Airline("oneworld");
			Airline airline3 = new Airline("Star Alliance");

			Flight flight1 = new Flight("NW 36", "08/06/2009", "7:10 pm",
					"06/25/2015", "9:00 am", airline1, dtw, ams, airplane1);
			Flight flight2 = new Flight("NW 96", "08/06/2009", "3:05 pm",
					"06/25/2015", "1:45 pm", airline1, nrt, dtw, airplane2);
			Flight flight3 = new Flight("QF 12", "08/05/2009", "10:30 pm",
					"06/25/2015", "6:15 am", airline2, lax, syd, airplane3);
			Flight flight4 = new Flight("QF 21", "08/06/2009", "9:55 pm",
					"06/25/2015", "6:55 am", airline2, syd, nrt, airplane4);
			Flight flight5 = new Flight("UA 944", "08/06/2009", "2:30 pm",
					"06/25/2015", "5:45 am", airline3, ord, fra, airplane5);
			Flight flight6 = new Flight("UA 934", "08/06/2009", "12:59 pm",
					"06/25/2015", "7:30 am", airline3, lax, lhr, airplane6);
			Flight flight7 = new Flight("NW 8445", "06/25/2015", "7:15 am",
					"06/25/2015", "7:40 am", airline1, ams, lhr, airplane1);
			Flight flight8 = new Flight("NW 1689", "06/25/2015", "12:05 pm",
					"06/25/2015", "12:21 pm", airline1, dtw, ord, airplane2);
			Flight flight9 = new Flight("QF 3101", "06/25/2015", "3:00 pm",
					"06/25/2015", "11:39 pm", airline2, lax, jfk, airplane3);
			Flight flight10 = new Flight("QF 4022", "06/25/2015", "11:05 am",
					"06/25/2015", "5:15 pm", airline2, nrt, sin, airplane4);
			Flight flight11 = new Flight("UA 941", "06/25/2015", "12:45 pm",
					"06/25/2015", "2:53 pm", airline3, fra, ord, airplane5);
			Flight flight12 = new Flight("UA 4842", "06/25/2015", "8:10 am",
					"06/25/2015", "10:38 am", airline3, lhr, ams, airplane6);

			em = emf.createEntityManager();
			tx = em.getTransaction();
			tx.begin();
			
			em.persist(flight1);
			em.persist(flight2);
			em.persist(flight3);
			em.persist(flight4);
			em.persist(flight5);
			em.persist(flight6);
			em.persist(flight7);
			em.persist(flight8);
			em.persist(flight9);
			em.persist(flight10);
			em.persist(flight11);
			em.persist(flight12);

			tx.commit();
			
		} catch (PersistenceException e) {
			if (tx != null) {
				logger.error("Rolling back", e);
				tx.rollback();
			}
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}

}
