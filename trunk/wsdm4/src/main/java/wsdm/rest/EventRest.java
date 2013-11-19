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
	@NamedQuery(name = "findAllEvents", query = "select myEvent from Event myEvent"),
	@NamedQuery(name = "findEventByEventId", query = "select myEvent from Event myEvent where myEvent.eventId = ?1"),
	@NamedQuery(name = "findEventByEventName", query = "select myEvent from Event myEvent where myEvent.eventName = ?1"),
	@NamedQuery(name = "findEventByEventType", query = "select myEvent from Event myEvent where myEvent.eventType = ?1"),
	@NamedQuery(name = "findEventByPrimaryKey", query = "select myEvent from Event myEvent where myEvent.eventId = ?1") })
*/
@Produces("application/json")
@Path("event")
public class EventRest extends AbstractRest {
	
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