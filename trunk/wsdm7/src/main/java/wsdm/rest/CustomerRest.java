package wsdm.rest;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;

import wsdm.dao.CustomerDAO;
import wsdm.domain.Customer;

@Produces("application/json")
@Path("customer")
public class CustomerRest {
	@Autowired
	private CustomerDAO customerDAO;
	
	@GET
	@Produces("application/json")
	public Customer getCustomer(@QueryParam("custid") Integer custId) {
		// throw new UnsupportedOperationException("Not yet implemented.");
		Customer cust = customerDAO.findCustomerByCustomerId(custId);
		return cust;
	}

	@GET
	@Path("list")
	@Produces("application/json")
	public ArrayList<Customer> listCustomers() {
		// throw new UnsupportedOperationException("Not yet implemented.");
		ArrayList<Customer> custList = new ArrayList<Customer>(customerDAO.findAllCustomers());		
		return custList;
	}
}