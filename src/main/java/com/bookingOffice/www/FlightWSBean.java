package com.bookingOffice.www;

import java.io.StringWriter;

import javax.inject.Inject;
import javax.inject.Named;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

@javax.jws.WebService(endpointInterface = "com.bookingOffice.www.FlightWS")
@Named
public class FlightWSBean implements FlightWS {
	private FlightList flights = new FlightList();
	@Inject
	CustomerService customerService;
	
	public FlightWSBean() {}

	public String getFlightList() {
		try {
			flights.setFlights(customerService.getAllFlights());
			JAXBContext context = JAXBContext.newInstance(FlightList.class);
			Marshaller marshaller = context.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			StringWriter stringWriter = new StringWriter();
			marshaller.marshal(flights, stringWriter);
			String txt = stringWriter.toString();
			return txt;
		} 
		catch (JAXBException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	public Flight getFlight(int id) {
		return customerService.getFlight(id);
	}

}
