package wsdm.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

@Produces("application/json")
@Path("customer")
public class CustomerRest {

	@GET
	@Produces("application/json")
	public Customer getCustomer(@QueryParam("custid") Integer custId) {
		throw new UnsupportedOperationException("Not yet implemented.");
	}

	@GET
	@Path("/list")
	@Produces("application/json")
	public ArrayList<Customer> listCustomers() {
		throw new UnsupportedOperationException("Not yet implemented.");
	}
}