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
	@NamedQuery(name = "findAllGames", query = "select myGame from Game myGame"),
	@NamedQuery(name = "findGameByActiveYn", query = "select myGame from Game myGame where myGame.activeYn = ?1"),
	@NamedQuery(name = "findGameByGameDate", query = "select myGame from Game myGame where myGame.gameDate = ?1"),
	@NamedQuery(name = "findGameByGameId", query = "select myGame from Game myGame where myGame.gameId = ?1"),
	@NamedQuery(name = "findGameByPrimaryKey", query = "select myGame from Game myGame where myGame.gameId = ?1"),
	@NamedQuery(name = "findGameByRefereeFk", query = "select myGame from Game myGame where myGame.refereeFk = ?1") })
*/
@Produces("application/json")
@Path("game")
public class GameRest extends AbstractRest {
	
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