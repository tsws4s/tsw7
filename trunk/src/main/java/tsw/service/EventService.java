package tsw.service;

import java.util.Calendar;
import java.util.List;
import java.util.Set;

import tsw.domain.Event;
import tsw.domain.Game;
import tsw.domain.Tswacct;

/**
 * Spring service that handles CRUD requests for Event entities
 * 
 */
public interface EventService {

	/**
	 */
	public Event findEventByPrimaryKey(Integer eventId);

	/**
	 * Delete an existing Event entity
	 * 
	 */
	public void deleteEvent(Event event);

	/**
	 * Return all Event entity
	 * 
	 */
	public List<Event> findAllEvents(Integer startResult, Integer maxRows);
	
	public List<Event> findAllEvents4tsw(Integer startResult, Integer maxRows, Integer tswId);
	
	/**
	 * Save an existing Event entity
	 * 
	 */
	public void saveEvent(Event event, Tswacct tswacct, Integer gameId, Integer customerId, Integer programId, Integer resourceId, Integer priceId);
	
	public void saveEventForGame(Game related_games, Integer programId, Integer resourceId);

	/**
	 * Load an existing Event entity
	 * 
	 */
	public Set<Event> loadEvents();

	/**
	 * Return a count of all Event entity
	 * 
	 */
	public Integer countEvents();

	public Integer getEventCount();
	
	public Set<Event> loadEventsForResource(Integer resource_resourceId, Calendar afterDate, int indexFrom);

	public Integer getEventCount(Integer resourceId, Calendar afterDate);
}