package wsdm.rest;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import wsdm.domain.Game;
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
	public Game getGame(@QueryParam("gameid") Integer gameId) {
		
		String sqlString = "select myGame from Game myGame where myGame.gameId = "+gameId;
		Game game = (Game) executeUniqueResultQuery(sqlString);
		return game;
	}

	@SuppressWarnings("unchecked")
	@GET
	@Path("list")
	@Produces("application/json")
	public ArrayList<Game> listGames() {
		
		ArrayList<Game> game = (ArrayList<Game>) executeResultListQuery("select myGame from Game myGame");
		return game;
	}
}