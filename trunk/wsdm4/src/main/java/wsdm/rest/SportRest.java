package wsdm.rest;

import java.util.ArrayList;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import wsdm.domain.Sport;
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
	public Sport getSport(@QueryParam("sportid") Integer sportId) {
		
		String sqlString = "select mySport from Sport mySport where mySport.sportId = "+sportId;
		Sport sport = (Sport) executeUniqueResultQuery(sqlString);
		return sport;
	}

	@SuppressWarnings("unchecked")
	@GET
	@Path("list")
	@Produces("application/json")
	public ArrayList<Sport> listSports() {
		
		ArrayList<Sport> sports = (ArrayList<Sport>) executeResultListQuery("select mySport from Sport mySport");
		return sports;
	}
}