package flight.services;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStream;

public class GetFlightDetails {

	public static void displayFlightDetails() throws Exception {
		// TODO Auto-generated method stub
		try(InputStream input = new FileInputStream("C:\\Users\\SHREEVATSA\\Desktop\\Eclipse Workplace\\Flight Application\\src\\flightDetails.txt")) {
			DataInputStream inst = new DataInputStream(input);
			int data = input.available();
			byte[] byteArray = new byte[data]; //
			inst.read(byteArray);
			String str = new String(byteArray); // passing byte array into String constructor
			System.out.println("------------Flights Details Are--------------");
			System.out.println(str); 
			
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("Server Busy, Cannot get the Flight Details, Try Again!");
		}
		
	}

}
