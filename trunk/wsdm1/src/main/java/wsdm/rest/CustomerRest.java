package wsdm.rest;

import java.util.ArrayList;
import java.util.HashMap;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import wsdm.domain.Customer;

@Produces("application/json")
@Path("/customer1")
public class CustomerRest {
	

	private HashMap<Integer, Customer> customers;


	@GET
	@Path("/list")
	@Produces("application/json")
	public ArrayList<Customer> listCustomers() {
		// throw new UnsupportedOperationException(ArrayList<E>implemented.");
		
		return new ArrayList<Customer>(createCustomers().values());
	}

	@GET
	@Produces("application/json")
	public Customer getCustomer(@QueryParam("custid") Integer param_id) {
		// throw new UnsupportedOperationException("Not yet implemented.");
		return (Customer)createCustomers().get(param_id);
	}
	
	public HashMap<Integer, Customer> createCustomers() {
		// throw new UnsupportedOperationException(ArrayList<E>implemented.");
		
		if(customers==null){
			int nextId = 1;
		customers = new HashMap<Integer, Customer>();
		Customer cust1 = new Customer(new Integer(nextId++),"Jack1", "Wise1", "1987-08-08", "M");
		customers.put(new Integer(cust1.getCustid()), cust1);
		Customer cust2 = new Customer(new Integer(nextId++),"Jill2", "Wiser2", "1980-08-08", "M");
		customers.put(new Integer(cust2.getCustid()), cust2);
		Customer cust3 = new Customer(new Integer(nextId++),"Joan3", "Brilliant3", "1950-02-08", "M");
		customers.put(new Integer(cust3.getCustid()), cust3);
		Customer cust4 = new Customer(new Integer(nextId++),"Joe4", "Bright4", "1989-04-08", "M");
		customers.put(new Integer(cust4.getCustid()), cust4);

		}
		return customers;
	}
	
}