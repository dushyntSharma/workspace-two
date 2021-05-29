package flight.model;

import java.util.List;

public class Flight {
	private String flightName;
	private String source;
	private String destination;
	private List<Passenger> passenger;

	public Flight() {
		super();
	}

	public Flight(String flightName, String source, String destination, List<Passenger> passenger) {
		super();
		this.flightName = flightName;
		this.source = source;
		this.destination = destination;
		this.passenger = passenger;
	}

	public String getFlightName() {
		return flightName;
	}

	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public List<Passenger> getPassenger() {
		return passenger;
	}

	public void setPassenger(List<Passenger> passenger) {
		this.passenger = passenger;
	}

}
