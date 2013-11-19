package wsdm.rest;

import java.util.ArrayList;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import wsdm.domain.Customer;
/*
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
@NamedQueries({
	@NamedQuery(name = "findAllParticipants", query = "select myParticipant from Participant myParticipant"),
	@NamedQuery(name = "findParticipantByPrimaryKey", query = "select myParticipant from Participant myParticipant where myParticipant.participantId = ?1") })
*/
@Produces("application/json")
@Path("participant")
public class ParticipantRest extends AbstractRest {
	
	@GET
	@Produces("application/json")
	public Customer getCustomer(@QueryParam("custid") Integer custId) {
		
		String sqlString = "select myCustomer from Customer myCustomer where customerId = "+custId;
		Customer customer = (Customer) executeUniqueResultQuery(sqlString);
		return customer;
	}

	@SuppressWarnings("unchecked")
	@GET
	@Path("list")
	@Produces("application/json")
	public ArrayList<Customer> listCustomers() {
		
		ArrayList<Customer> customers = (ArrayList<Customer>) executeResultListQuery("select myCustomer from Customer myCustomer");
		return customers;
	}
}