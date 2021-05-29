package flight.services;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FlightDataOutputStream {

	public static void displayOutputStream() throws FileNotFoundException {
		// TODO Auto-generated method stub
		try (FileOutputStream fileOutputStream = new FileOutputStream(
				"C:\\Users\\SHREEVATSA\\Desktop\\Eclipse Workplace\\Flight Application\\src\\flightDetails.txt")) {
			String flight = "International Flights -> 25 Flights\n" + "Domestic Flights -> 40 Flights\n"
					+ "Private Flights -> 5 Flights\n" + "\nSome International Flights Are ->\n"
					+ "Emirates, Qatar, Thai, Etihad, Singapore, Malaysia\n" + "\nSome Domestic Flights are ->\n"
					+ "IndiGo, Air India, SpiceJet, GoAir, AirAsia, Vistara, TruJet\n" + "";
			byte byteArray[] = flight.getBytes(); // converting string into byte array
			fileOutputStream.write(byteArray);
			System.out.println("Flight Details are added!");

		} catch (FileNotFoundException e) {
			// TODO: handle exception
			throw new FileNotFoundException("Server Busy, Flights details not found, Try again after some time!");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

}
