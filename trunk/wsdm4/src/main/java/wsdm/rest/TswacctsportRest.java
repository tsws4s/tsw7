package wsdm.rest;

import java.util.ArrayList;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import wsdm.domain.Tswacctsport;
/*
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
@NamedQueries({
	@NamedQuery(name = "findAllTswacctsports", query = "select myTswacctsport from Tswacctsport myTswacctsport"),
	@NamedQuery(name = "findTswacctsportByPrimaryKey", query = "select myTswacctsport from Tswacctsport myTswacctsport where myTswacctsport.tswAcctSportId = ?1") })

*/
@Produces("application/json")
@Path("tswacctsport")
public class TswacctsportRest extends AbstractRest {
	
	@GET
	@Produces("application/json")
	public Tswacctsport getTswacctsport(@QueryParam("tswacctsportid") Integer tswacctsportId) {
		
		String sqlString = "select myTswacctsport from Tswacctsport myTswacctsport where myTswacctsport.tswAcctSportId = "+tswacctsportId;
		Tswacctsport tswacctsport = (Tswacctsport) executeUniqueResultQuery(sqlString);
		return tswacctsport;
	}

	@SuppressWarnings("unchecked")
	@GET
	@Path("list")
	@Produces("application/json")
	public ArrayList<Tswacctsport> listTswacctsports() {
		
		ArrayList<Tswacctsport> tswacctsport = (ArrayList<Tswacctsport>) executeResultListQuery("select myTswacctsport from Tswacctsport myTswacctsport");
		return tswacctsport;
	}
}