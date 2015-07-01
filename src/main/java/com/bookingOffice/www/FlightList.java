package com.bookingOffice.www;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import com.bookingOffice.www.Flight;

@XmlRootElement
public class FlightList {
	private List<Flight> flights;

	public FlightList() {
		flights = new ArrayList<Flight>(); 
	}

	@XmlElementWrapper(name = "flightsList")
	@XmlElement(name = "flight", type = Flight.class)
	public List<Flight> getFlights() {
		return flights;
	}


	public void setFlights(List<Flight> flights) {
		this.flights = flights;
	}
}