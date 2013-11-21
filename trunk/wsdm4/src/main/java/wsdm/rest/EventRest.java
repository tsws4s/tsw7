package wsdm.rest;

import java.util.ArrayList;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import wsdm.domain.Event;
/*
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
@NamedQueries({
	@NamedQuery(name = "findAllEvents", query = "select myEvent from Event myEvent"),
	@NamedQuery(name = "findEventByEventId", query = "select myEvent from Event myEvent where myEvent.eventId = ?1"),
	@NamedQuery(name = "findEventByEventName", query = "select myEvent from Event myEvent where myEvent.eventName = ?1"),
	@NamedQuery(name = "findEventByEventType", query = "select myEvent from Event myEvent where myEvent.eventType = ?1"),
	@NamedQuery(name = "findEventByPrimaryKey", query = "select myEvent from Event myEvent where myEvent.eventId = ?1") })
*/
@Produces("application/json")
@Path("event")
public class EventRest extends AbstractRest {
	
	@GET
	@Produces("application/json")
	public Event getEvent(@QueryParam("eventid") Integer eventId) {
		
		String sqlString = "select myEvent from Event myEvent where myEvent.eventId = "+eventId;
		Event event = (Event) executeUniqueResultQuery(sqlString);
		return event;
	}

	@SuppressWarnings("unchecked")
	@GET
	@Path("list")
	@Produces("application/json")
	public ArrayList<Event> listEvents() {
		
		ArrayList<Event> event = (ArrayList<Event>) executeResultListQuery("select myEvent from Event myEvent");
		return event;
	}
}