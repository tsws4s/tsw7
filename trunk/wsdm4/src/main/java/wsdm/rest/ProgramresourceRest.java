package wsdm.rest;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import wsdm.domain.Programresource;
/*
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
@NamedQueries({
	@NamedQuery(name = "findAllProgramresources", query = "select myProgramresource from Programresource myProgramresource"),
	@NamedQuery(name = "findProgramresourceByPrimaryKey", query = "select myProgramresource from Programresource myProgramresource where myProgramresource.programResourceId = ?1") })
*/
@Produces("application/json")
@Path("programresource")
public class ProgramresourceRest extends AbstractRest {
	
	@GET
	@Produces("application/json")
	public Programresource getProgramresource(@QueryParam("programresourceid") Integer programresourceId) {
		
		String sqlString = "select myProgramresource from Programresource myProgramresource where myProgramresource.programResourceId = "+programresourceId;
		Programresource programresource = (Programresource) executeUniqueResultQuery(sqlString);
		return programresource;
	}

	@SuppressWarnings("unchecked")
	@GET
	@Path("list")
	@Produces("application/json")
	public ArrayList<Programresource> listProgramresources() {
		
		ArrayList<Programresource> programresource = (ArrayList<Programresource>) executeResultListQuery("select myProgramresource from Programresource myProgramresource");
		return programresource;
	}
}