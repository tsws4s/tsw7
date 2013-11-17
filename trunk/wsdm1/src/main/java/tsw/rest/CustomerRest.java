package tsw.rest;

import java.util.Set;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;

import tsw.dao.CustomerDAO;
import tsw.domain.Customer;

@Produces("application/json")
@Path("customer")
public class CustomerRest {
	@Autowired
	
	private CustomerDAO customerDAO;
	
	@GET
	@Path("list")
	@Produces("application/json")
	public Set<Customer> listCustomers() {
		// throw new UnsupportedOperationException("Not yet implemented.");
		Integer tswId = new Integer(1);
		Set<Customer> custList = customerDAO.findAllCustomers4tsw(tswId);
		return custList;
	}

	@GET
	@Produces("application/json")
	public Customer getCustomer(@QueryParam("custid") Integer param1) {
		//throw new UnsupportedOperationException("Not yet implemented.");
		Customer cust = customerDAO.findCustomerByCustomerId(param1);
		return cust;
	}
}