package wsdm.rest;

import java.util.ArrayList;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import wsdm.domain.Participant;
/*
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
@NamedQueries({
	@NamedQuery(name = "findAllParticipants", query = "select myParticipant from Participant myParticipant"),
	@NamedQuery(name = "findParticipantByPrimaryKey", query = "select myParticipant from Participant myParticipant where myParticipant.participantId = ?1") })
*/
@Produces("application/json")
@Path("participant")
public class ParticipantRest extends AbstractRest {
	
	@GET
	@Produces("application/json")
	public Participant getParticipant(@QueryParam("participantid") Integer participantId) {
		
		String sqlString = "select myParticipant from Participant myParticipant where myParticipant.participantId = "+participantId;
		Participant participant = (Participant) executeUniqueResultQuery(sqlString);
		return participant;
	}

	@SuppressWarnings("unchecked")
	@GET
	@Path("list")
	@Produces("application/json")
	public ArrayList<Participant> listParticipants() {
		
		ArrayList<Participant> participant = (ArrayList<Participant>) executeResultListQuery("select myParticipant from Participant myParticipant");
		return participant;
	}
}