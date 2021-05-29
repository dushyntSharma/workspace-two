package flight.client;

import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import flight.model.Flight;
import flight.model.Passenger;
import flight.services.AddFlight;
import flight.services.AddPassenger;
import flight.services.DisplayPassengerByAge;
import flight.services.FlightDataOutputStream;
import flight.services.GetFlightDetails;

public class FlightApp {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		List<Flight> flight = new LinkedList<Flight>();
		List<Passenger> passenger = new LinkedList<Passenger>();
		int choice;
		boolean flag = true;
		do {
			displayMenu();
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				passenger = AddPassenger.addPassenger(passenger);
				displayData(passenger);
				break;
			case 2:
				flight = AddFlight.addFlights(flight, passenger);
				displayDataOfFlight(flight);
				break;

			case 3:
				DisplayPassengerByAge.displayByAge(passenger);
				// Comparable Class
				break;
			case 4:
				try {
					FlightDataOutputStream.displayOutputStream();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;

			case 5:
				try {
					GetFlightDetails.displayFlightDetails();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 6:
				System.out.println("Thank you, Visit Again");
				flag = false;
				break;
			default:
				System.out.println("Invalid choice!!");
				break;
			}

		} while (flag);

	}

	private static void displayDataOfFlight(List<Flight> flight) {
		// TODO Auto-generated method stub
		Iterator<Flight> itr = flight.iterator();
		while (itr.hasNext()) {
			Flight obj = (Flight) itr.next();
			System.out.println();
			System.out.println("Flight Name: " + obj.getFlightName());
			System.out.println("Source: " + obj.getSource());
			System.out.println("Destination: " + obj.getDestination());
			System.out.println(obj.getPassenger());
			System.out.println("-------------------------");

		}
	}

	private static void displayData(List<Passenger> passenger) {

		Iterator<Passenger> itr = passenger.iterator();
		while (itr.hasNext()) {
			Passenger obj = (Passenger) itr.next();
			System.out.println();
			System.out.println("First Name: " + obj.getFirstName());
			System.out.println("Last Name: " + obj.getLastName());
			System.out.println("Age: " + obj.getAge());
			System.out.println("Gender: " + obj.getGender());
			System.out.println("-------------------------");
		}

	}

	private static void displayMenu() {
		// TODO Auto-generated method stub
		System.out.println("*-------------------------------------*");
		System.out.println("1.Enter Passengers Details");
		System.out.println("2.Enter Flights Details");
		System.out.println("3.Sort Passenger By Age");
		System.out.println("4.Add Flight Details to the system");
		System.out.println("5.Get the flight details from the system");
		System.out.println("6.Exit");
		System.out.println("*-------------------------------------*");

	}

}

/*
 * Flight.java -> list of flights passenger.java -> thier profile -> with
 * 
 * 
 * shop.java -> list of items -> when adding taking the list of items item.java
 * -> list of items
 * 
 * public class ABC extends FlightApp { String flightArrived() { String str =
 * "Arrives"; return str; }
 * 
 * }
 */