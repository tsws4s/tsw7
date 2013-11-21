package wsdm.rest;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import wsdm.domain.Sportposition;
/*
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
@NamedQueries({
	@NamedQuery(name = "findAllSportpositions", query = "select mySportposition from Sportposition mySportposition"),
	@NamedQuery(name = "findSportpositionByPrimaryKey", query = "select mySportposition from Sportposition mySportposition where mySportposition.sportPositionId = ?1") })

*/
@Produces("application/json")
@Path("sportposition")
public class SportpositionRest extends AbstractRest {
	
	@GET
	@Produces("application/json")
	public Sportposition getSportposition(@QueryParam("sportpositionid") Integer sportpositionId) {
		
		String sqlString = "select mySportposition from Sportposition mySportposition where mySportposition.sportPositionId = "+sportpositionId;
		Sportposition sportposition = (Sportposition) executeUniqueResultQuery(sqlString);
		return sportposition;
	}

	@SuppressWarnings("unchecked")
	@GET
	@Path("list")
	@Produces("application/json")
	public ArrayList<Sportposition> listSportpositions() {
		
		ArrayList<Sportposition> sportposition = (ArrayList<Sportposition>) executeResultListQuery("select mySportposition from Sportposition mySportposition");
		return sportposition;
	}
}