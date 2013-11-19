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
	@NamedQuery(name = "findAllCustomers", query = "select myCustomer from Customer myCustomer"),
	@NamedQuery(name = "findCustomerByActiveYn", query = "select myCustomer from Customer myCustomer where myCustomer.activeYn = ?1"),
	@NamedQuery(name = "findCustomerByAdminYn", query = "select myCustomer from Customer myCustomer where myCustomer.adminYn = ?1"),
	@NamedQuery(name = "findCustomerByCustomerId", query = "select myCustomer from Customer myCustomer where myCustomer.customerId = ?1"),
	@NamedQuery(name = "findCustomerByFirstname", query = "select myCustomer from Customer myCustomer where myCustomer.firstname = ?1"),
	@NamedQuery(name = "findCustomerByFirstnameContaining", query = "select myCustomer from Customer myCustomer where myCustomer.firstname like ?1"),
	@NamedQuery(name = "findCustomerByLastname", query = "select myCustomer from Customer myCustomer where myCustomer.lastname = ?1"),
	@NamedQuery(name = "findCustomerByLastnameContaining", query = "select myCustomer from Customer myCustomer where myCustomer.lastname like ?1"),
	@NamedQuery(name = "findCustomerByPassword", query = "select myCustomer from Customer myCustomer where myCustomer.password = ?1"),
	@NamedQuery(name = "findCustomerByPrimaryKey", query = "select myCustomer from Customer myCustomer where myCustomer.customerId = ?1") })

*/
@Produces("application/json")
@Path("customer")
public class CustomerRest extends AbstractRest {
	
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