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
	@NamedQuery(name = "findAllTeams", query = "select myTeam from Team myTeam"),
	@NamedQuery(name = "findTeamByActiveYn", query = "select myTeam from Team myTeam where myTeam.activeYn = ?1"),
	@NamedQuery(name = "findTeamByPrimaryKey", query = "select myTeam from Team myTeam where myTeam.teamId = ?1"),
	@NamedQuery(name = "findTeamByPublishYn", query = "select myTeam from Team myTeam where myTeam.publishYn = ?1"),
	@NamedQuery(name = "findTeamByTeamId", query = "select myTeam from Team myTeam where myTeam.teamId = ?1"),
	@NamedQuery(name = "findTeamByTeamName", query = "select myTeam from Team myTeam where myTeam.teamName = ?1") })
*/

@Produces("application/json")
@Path("team")
public class TeamRest extends AbstractRest {
	
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