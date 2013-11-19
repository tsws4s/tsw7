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
	@NamedQuery(name = "findAllUserss", query = "select myUsers from Users myUsers"),
	@NamedQuery(name = "findUsersByActiveYn", query = "select myUsers from Users myUsers where myUsers.activeYn = ?1"),
	@NamedQuery(name = "findUsersByAdminYn", query = "select myUsers from Users myUsers where myUsers.adminYn = ?1"),
	@NamedQuery(name = "findUsersByCustomerFk", query = "select myUsers from Users myUsers where myUsers.customerFk = ?1"),
	@NamedQuery(name = "findUsersByPrimaryKey", query = "select myUsers from Users myUsers where myUsers.userId = ?1"),
	@NamedQuery(name = "findUsersByTswAcctFk", query = "select myUsers from Users myUsers where myUsers.tswAcctFk = ?1"),
	@NamedQuery(name = "findUsersByUserId", query = "select myUsers from Users myUsers where myUsers.userId = ?1"),
	@NamedQuery(name = "findUsersByUsername", query = "select myUsers from Users myUsers where myUsers.username = ?1") })

*/
@Produces("application/json")
@Path("users")
public class UsersRest extends AbstractRest {
	
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