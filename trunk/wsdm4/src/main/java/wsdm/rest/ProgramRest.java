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
	@NamedQuery(name = "findAllPrograms", query = "select myProgram from Program myProgram"),
	@NamedQuery(name = "findProgramByActiveYn", query = "select myProgram from Program myProgram where myProgram.activeYn = ?1"),
	@NamedQuery(name = "findProgramByLeagueYn", query = "select myProgram from Program myProgram where myProgram.leagueYn = ?1"),
	@NamedQuery(name = "findProgramByLevelFk", query = "select myProgram from Program myProgram where myProgram.levelFk = ?1"),
	@NamedQuery(name = "findProgramByPrimaryKey", query = "select myProgram from Program myProgram where myProgram.programId = ?1"),
	@NamedQuery(name = "findProgramByProgramId", query = "select myProgram from Program myProgram where myProgram.programId = ?1"),
	@NamedQuery(name = "findProgramByProgramName", query = "select myProgram from Program myProgram where myProgram.programName = ?1"),
	@NamedQuery(name = "findProgramByPublishYn", query = "select myProgram from Program myProgram where myProgram.publishYn = ?1"),
	@NamedQuery(name = "findProgramByStartDate", query = "select myProgram from Program myProgram where myProgram.startDate = ?1") })

*/
@Produces("application/json")
@Path("program")
public class ProgramRest extends AbstractRest {
	
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