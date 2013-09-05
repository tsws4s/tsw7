package tsw.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Set;

import org.joda.time.MutableDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tsw.dao.CustomerDAO;
import tsw.dao.EventDAO;
import tsw.dao.GameDAO;
import tsw.dao.PriceDAO;
import tsw.dao.ProgramDAO;
import tsw.dao.ResourceDAO;

import tsw.domain.Event;
import tsw.domain.Game;
import tsw.domain.Resource;
import tsw.domain.Tswacct;
import tsw.web.UsersController;

/**
 * Spring service that handles CRUD requests for Event entities
 * 
 */

@Service("EventService")
@Transactional
public class EventServiceImpl implements EventService {
	
	int defaultMaxRows = UsersController.getDefaultMaxRows();

	/**
	 * DAO injected by Spring that manages Event entities
	 * 
	 */
	@Autowired
	private EventDAO eventDAO;

	@Autowired
	private CustomerDAO customerDAO;

	@Autowired
	private GameDAO gameDAO;

	@Autowired
	private ProgramDAO programDAO;
		
	@Autowired
	private ResourceDAO resourceDAO;
	
	@Autowired
	private PriceDAO priceDAO;
	
	/**
	 * Instantiates a new EventServiceImpl.
	 *
	 */
	public EventServiceImpl() {
	}

	/**
	 */
	@Transactional
	public Event findEventByPrimaryKey(Integer eventId) {
		return eventDAO.findEventByPrimaryKey(eventId);
	}

	/**
	 * Delete an existing Event entity
	 * 
	 */
	@Transactional
	public void deleteEvent(Event event) {
		eventDAO.remove(event);
		eventDAO.flush();
	}

	/**
	 * Return all Event entity
	 * 
	 */
	@Transactional
	public List<Event> findAllEvents(Integer startResult, Integer maxRows) {
		return new java.util.ArrayList<Event>(eventDAO.findAllEvents(startResult, maxRows));
	}
	@Transactional
	public List<Event> findAllEvents4tsw(Integer startResult, Integer maxRows, Integer tswId) {
		return new java.util.ArrayList<Event>(eventDAO.findAllEvents4tsw(startResult, maxRows, tswId));
	}
	public void saveEventForGame(Game related_games, Integer programId, Integer resourceId) {

		Event event = eventDAO.findEventByGameId(related_games.getGameId());
		if(event==null){
			event  = new Event();
			int eventId = eventDAO.getMaxEventID();
			event.setEventId(eventId+1);
			event.setEventUrl("/tsw7/editEvent?eventIdKey="+(eventId+1)+"&");
			event.setTswacct(related_games.getTswacct());
			event.setEventType("Game");
			event.setEventColor("Green");
			event.setAllDay(new Boolean(false));
			event.setGame(related_games);
		}

		event.setEventDate(related_games.getGameDate());
		event.setStartTime(related_games.getStartTime());
		event.setEndTime(related_games.getEndTime());
		String teams = new String(related_games.getTeamByHomeTeamFk().getTeamName()+" vs. "+related_games.getTeamByVisitorTeamFk().getTeamName());
		event.setEventName(teams);
		event.setDescription("Game: "+teams);

		if(resourceId!=null && resourceId>0){
			Resource res = resourceDAO.findResourceByPrimaryKey(resourceId);
			event.setResource(res);
			if(res!=null && res.getPrice()!=null){
				event.setPrice(res.getPrice());
			}
		}
		if(programId!=null && programId>0){
			event.setProgram(programDAO.findProgramByPrimaryKey(programId));
		}
		
		event = eventDAO.store(event);
		eventDAO.flush();		
	}	
	/**
	 * Save an existing Event entity
	 * 
	 */
	@Transactional
	public void saveEvent(Event event, Tswacct tswacct, Integer gameId, Integer customerId, Integer programId, Integer resourceId, Integer priceId) {
		Event existingEvent = eventDAO.findEventByPrimaryKey(event.getEventId());

		if (existingEvent != null) {
			if (existingEvent != event) {
				existingEvent.setEventId(event.getEventId());
				existingEvent.setEventUrl(event.getEventUrl());
				existingEvent.setEventColor(event.getEventColor());
				existingEvent.setAllDay(event.getAllDay());
				existingEvent.setEventDate(event.getEventDate());
				existingEvent.setStartTime(event.getStartTime());
				existingEvent.setEndTime(event.getEndTime());
				existingEvent.setEventName(event.getEventName());
				existingEvent.setDescription(event.getDescription());
				existingEvent.setEventType(event.getEventType());
				existingEvent.setTswacct(tswacct);
			}
			event = existingEvent;
		} else {
			int eventId = eventDAO.getMaxEventID();
			event.setEventId(eventId+1);
			event.setEventUrl("/tsw7/editEvent?eventIdKey="+(eventId+1)+"&");
			event.setTswacct(tswacct);
			Resource res = tswacct.getResources().iterator().next();
			event.setResource(res);
		}
		if(resourceId!=null && resourceId>0){
			event.setResource(resourceDAO.findResourceByPrimaryKey(resourceId));
		}
		if(gameId!=null && gameId>0){
			event.setGame(gameDAO.findGameByPrimaryKey(gameId));
		}
		if(customerId!=null && customerId>0){
			event.setCustomer(customerDAO.findCustomerByPrimaryKey(customerId));
		}
		if(programId!=null && programId>0){
			event.setProgram(programDAO.findProgramByPrimaryKey(programId));
		}
		if(priceId!=null && priceId>0){
			event.setPrice(priceDAO.findPriceByPrimaryKey(priceId));
		}
		
		event = eventDAO.store(event);
		eventDAO.flush();
	}

	/**
	 * Load an existing Event entity
	 * 
	 */
	@Transactional
	public Set<Event> loadEvents() {
		return eventDAO.findAllEvents();
	}

	/**
	 * Return a count of all Event entity
	 * 
	 */
	@Transactional
	public Integer countEvents() {
		return ((Long) eventDAO.createQuerySingleResult("select count(o) from Event o").getSingleResult()).intValue();
	}

	@Override
	public Integer getEventCount() {
		return ((Long) eventDAO.createQuerySingleResult("select count(eventId) from Event o").getSingleResult()).intValue();
	}
	@Override
	public Integer getEventCount(Integer resourceId, Calendar afterDate) { 
		if(resourceId==null){
//			resourceId=tswacctDAO.getSessionConfig().getDefaultResourceId();
		}
		if(afterDate==null){
			MutableDateTime dt = MutableDateTime.now();
			dt.setDayOfMonth(1);
			dt.addDays(-1);
			afterDate = dt.toGregorianCalendar();			
		}
		SimpleDateFormat dtfmt = new SimpleDateFormat("yyyy-MM-dd");
		String afterDateFmt = dtfmt.format(afterDate.getTime());
		return ((Long) eventDAO.createQuerySingleResult("select count(eventId) from Event o  where (resourceFk = '"+resourceId.intValue()+"') and (startTime > '"+afterDateFmt+"')").getSingleResult()).intValue();
	}

	@Override
	public Set<Event> loadEventsForResource(Integer resource_resourceId, Calendar afterDate, int indexFrom) {
		return eventDAO.findEventByDateAfter(resource_resourceId, afterDate, indexFrom);
	}
}
