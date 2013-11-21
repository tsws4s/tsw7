package wsdm.rest;

import java.util.ArrayList;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import wsdm.domain.Program;
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
	public Program getProgram(@QueryParam("programid") Integer programId) {
		
		String sqlString = "select myProgram from Program myProgram where myProgram.programId = "+programId;
		Program program = (Program) executeUniqueResultQuery(sqlString);
		return program;
	}

	@SuppressWarnings("unchecked")
	@GET
	@Path("list")
	@Produces("application/json")
	public ArrayList<Program> listPrograms() {
		
		ArrayList<Program> program = (ArrayList<Program>) executeResultListQuery("select myProgram from Program myProgram");
		return program;
	}
}