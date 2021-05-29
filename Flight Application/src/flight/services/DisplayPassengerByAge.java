package flight.services;

import java.util.Collections;
import java.util.List;

import flight.model.Passenger;

public class DisplayPassengerByAge {

	public static void displayByAge(List<Passenger> passenger) {
		// TODO Auto-generated method stub
		Collections.sort(passenger);
		for (Passenger psgr : passenger) {
			System.out.println(
					psgr.getFirstName() + " " + psgr.getLastName() + " " + psgr.getAge() + " " + psgr.getGender());

		}
	}

}
