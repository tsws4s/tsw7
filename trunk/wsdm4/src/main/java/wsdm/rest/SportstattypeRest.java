package wsdm.rest;

import java.util.ArrayList;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import wsdm.domain.Sportstattype;
/*
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
@NamedQueries({
	@NamedQuery(name = "findAllSportstattypes", query = "select mySportstattype from Sportstattype mySportstattype"),
	@NamedQuery(name = "findSportstattypeByPrimaryKey", query = "select mySportstattype from Sportstattype mySportstattype where mySportstattype.sportStatTypeId = ?1") })

*/
@Produces("application/json")
@Path("sportstattype")
public class SportstattypeRest extends AbstractRest {
	
	@GET
	@Produces("application/json")
	public Sportstattype getSportstattype(@QueryParam("sportstattypeid") Integer sportstattypeId) {
		
		String sqlString = "select mySportstattype from Sportstattype mySportstattype where mySportstattype.sportStatTypeId = "+sportstattypeId;
		Sportstattype sportstattype = (Sportstattype) executeUniqueResultQuery(sqlString);
		return sportstattype;
	}

	@SuppressWarnings("unchecked")
	@GET
	@Path("list")
	@Produces("application/json")
	public ArrayList<Sportstattype> listCustomers() {
		
		ArrayList<Sportstattype> sportstattype = (ArrayList<Sportstattype>) executeResultListQuery("select mySportstattype from Sportstattype mySportstattype");
		return sportstattype;
	}
}