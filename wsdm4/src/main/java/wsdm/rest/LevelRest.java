package wsdm.rest;

import java.util.ArrayList;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import wsdm.domain.Level;
/*
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
@NamedQueries({
	@NamedQuery(name = "findAllLevels", query = "select myLevel from Level myLevel"),
	@NamedQuery(name = "findLevelByLevelId", query = "select myLevel from Level myLevel where myLevel.levelId = ?1"),
	@NamedQuery(name = "findLevelByPrimaryKey", query = "select myLevel from Level myLevel where myLevel.levelId = ?1") })
*/
@Produces("application/json")
@Path("level")
public class LevelRest extends AbstractRest {
	
	@GET
	@Produces("application/json")
	public Level getLevel(@QueryParam("levelid") Integer levelId) {
		
		String sqlString = "select myLevel from Level myLevel where myLevel.levelId = "+levelId;
		Level level = (Level) executeUniqueResultQuery(sqlString);
		return level;
	}

	@SuppressWarnings("unchecked")
	@GET
	@Path("list")
	@Produces("application/json")
	public ArrayList<Level> listLevels() {
		
		ArrayList<Level> level = (ArrayList<Level>) executeResultListQuery("select myLevel from Level myLevel");
		return level;
	}
}