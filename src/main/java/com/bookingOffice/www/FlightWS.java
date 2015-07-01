package com.bookingOffice.www;

import javax.jws.WebService;

import com.bookingOffice.www.Flight;

@WebService
public interface FlightWS {
	
	String getFlightList();
	
	Flight getFlight(int id);

}
