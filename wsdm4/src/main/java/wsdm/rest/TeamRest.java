package wsdm.rest;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import wsdm.domain.Team;
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
	public Team getTeam(@QueryParam("teamid") Integer teamId) {
		
		String sqlString = "select myTeam from Team myTeam where myTeam.teamId = "+teamId;
		Team team = (Team) executeUniqueResultQuery(sqlString);
		return team;
	}

	@SuppressWarnings("unchecked")
	@GET
	@Path("list")
	@Produces("application/json")
	public ArrayList<Team> listTeams() {
		
		ArrayList<Team> teams = (ArrayList<Team>) executeResultListQuery("select myTeam from Team myTeam");
		return teams;
	}
}