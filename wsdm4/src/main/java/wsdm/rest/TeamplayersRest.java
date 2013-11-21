package wsdm.rest;

import java.util.ArrayList;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import wsdm.domain.Teamplayers;
/*
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
@NamedQueries({
	@NamedQuery(name = "findAllTeamplayerss", query = "select myTeamplayers from Teamplayers myTeamplayers"),
	@NamedQuery(name = "findTeamplayersByActiveYn", query = "select myTeamplayers from Teamplayers myTeamplayers where myTeamplayers.activeYn = ?1"),
	@NamedQuery(name = "findTeamplayersByPrimaryKey", query = "select myTeamplayers from Teamplayers myTeamplayers where myTeamplayers.teamPlayersId = ?1"),
	@NamedQuery(name = "findTeamplayersBySignedWaiverYn", query = "select myTeamplayers from Teamplayers myTeamplayers where myTeamplayers.signedWaiverYn = ?1"),
	@NamedQuery(name = "findTeamplayersBySportPositionFk", query = "select myTeamplayers from Teamplayers myTeamplayers where myTeamplayers.sportPositionFk = ?1"),
	@NamedQuery(name = "findTeamplayersByTeamPlayersId", query = "select myTeamplayers from Teamplayers myTeamplayers where myTeamplayers.teamPlayersId = ?1") })
*/

@Produces("application/json")
@Path("teamplayers")
public class TeamplayersRest extends AbstractRest {
	
	@GET
	@Produces("application/json")
	public Teamplayers getTeamplayers(@QueryParam("teamplayersid") Integer teamplayersId) {
		
		String sqlString = "select myTeamplayers from Teamplayers myTeamplayers where myTeamplayers.teamPlayersId = "+teamplayersId;
		Teamplayers teamplayers = (Teamplayers) executeUniqueResultQuery(sqlString);
		return teamplayers;
	}

	@SuppressWarnings("unchecked")
	@GET
	@Path("list")
	@Produces("application/json")
	public ArrayList<Teamplayers> listTeamplayers() {
		
		ArrayList<Teamplayers> teamplayers = (ArrayList<Teamplayers>) executeResultListQuery("select myTeamplayers from Teamplayers myTeamplayers");
		return teamplayers;
	}
}