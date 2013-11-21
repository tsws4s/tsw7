package wsdm.rest;

import java.util.ArrayList;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import wsdm.domain.Gamestats;
/*
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
@NamedQueries({
	@NamedQuery(name = "findAllGamestatss", query = "select myGamestats from Gamestats myGamestats"),
	@NamedQuery(name = "findGamestatsByPrimaryKey", query = "select myGamestats from Gamestats myGamestats where myGamestats.gameStatsId = ?1") })
*/
@Produces("application/json")
@Path("gamestats")
public class GamestatsRest extends AbstractRest {
	
	@GET
	@Produces("application/json")
	public Gamestats getGamestats(@QueryParam("gamestatsid") Integer gamestatsId) {
		
		String sqlString = "select myGamestats from Gamestats myGamestats where myGamestats.gameStatsId = "+gamestatsId;
		Gamestats gamestats = (Gamestats) executeUniqueResultQuery(sqlString);
		return gamestats;
	}

	@SuppressWarnings("unchecked")
	@GET
	@Path("list")
	@Produces("application/json")
	public ArrayList<Gamestats> listGamestats() {
		
		ArrayList<Gamestats> gamestats = (ArrayList<Gamestats>) executeResultListQuery("select myGamestats from Gamestats myGamestats");
		return gamestats;
	}
}