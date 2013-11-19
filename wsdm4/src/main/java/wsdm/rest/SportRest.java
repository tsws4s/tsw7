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
	@NamedQuery(name = "findAllSports", query = "select mySport from Sport mySport"),
	@NamedQuery(name = "findSportByActiveYn", query = "select mySport from Sport mySport where mySport.activeYn = ?1"),
	@NamedQuery(name = "findSportByPrimaryKey", query = "select mySport from Sport mySport where mySport.sportId = ?1"),
	@NamedQuery(name = "findSportBySportId", query = "select mySport from Sport mySport where mySport.sportId = ?1"),
	@NamedQuery(name = "findSportBySportName", query = "select mySport from Sport mySport where mySport.sportName = ?1") })

*/
@Produces("application/json")
@Path("sport")
public class SportRest extends AbstractRest {
	
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