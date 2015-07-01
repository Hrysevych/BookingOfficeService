package com.bookingOffice.www;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import com.bookingOffice.www.Flight;

@Named
public class CustomerService {
	@Inject
	private FlightDAO flightDAO;

	public List<Flight> getFlightsFiltered(Flight flight) {
		return flightDAO.getFlightsFiltered(flight);
	}

	public Flight getFlight(int id) {
		return flightDAO.getFlight(id);
	}

	public List<Flight> getAllFlights() {
		return flightDAO.getFlights();
	}
}
