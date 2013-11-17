package wsdm.service;

import java.util.List;
import java.util.Set;

import wsdm.domain.Customer;
import wsdm.domain.Event;
import wsdm.domain.Game;
import wsdm.domain.Price;
import wsdm.domain.Program;
import wsdm.domain.Resource;
import wsdm.domain.Tswacct;

/**
 * Spring service that handles CRUD requests for Event entities
 * 
 */
public interface EventService {

	/**
	 * Save an existing Customer entity
	 * 
	 */
	public Event saveEventCustomer(Integer eventId, Customer related_customer);

	/**
	 * Delete an existing Program entity
	 * 
	 */
	public Event deleteEventProgram(Integer event_eventId, Integer related_program_programId);

	/**
	 * Delete an existing Event entity
	 * 
	 */
	public void deleteEvent(Event event);

	/**
	 * Delete an existing Game entity
	 * 
	 */
	public Event deleteEventGame(Integer event_eventId_1, Integer related_game_gameId);

	/**
	 * Delete an existing Tswacct entity
	 * 
	 */
	public Event deleteEventTswacct(Integer event_eventId_2, Integer related_tswacct_tswAcctId);

	/**
	 */
	public Event findEventByPrimaryKey(Integer eventId_1);

	/**
	 * Save an existing Price entity
	 * 
	 */
	public Event saveEventPrice(Integer eventId_2, Price related_price);

	/**
	 * Save an existing Tswacct entity
	 * 
	 */
	public Event saveEventTswacct(Integer eventId_3, Tswacct related_tswacct);

	/**
	 * Save an existing Resource entity
	 * 
	 */
	public Event saveEventResource(Integer eventId_4, Resource related_resource);

	/**
	 * Delete an existing Customer entity
	 * 
	 */
	public Event deleteEventCustomer(Integer event_eventId_3, Integer related_customer_customerId);

	/**
	 * Return a count of all Event entity
	 * 
	 */
	public Integer countEvents();

	/**
	 * Delete an existing Resource entity
	 * 
	 */
	public Event deleteEventResource(Integer event_eventId_4, Integer related_resource_resourceId);

	/**
	 * Save an existing Program entity
	 * 
	 */
	public Event saveEventProgram(Integer eventId_5, Program related_program);

	/**
	 * Load an existing Event entity
	 * 
	 */
	public Set<Event> loadEvents();

	/**
	 * Delete an existing Price entity
	 * 
	 */
	public Event deleteEventPrice(Integer event_eventId_5, Integer related_price_priceId);

	/**
	 * Save an existing Event entity
	 * 
	 */
	public void saveEvent(Event event_1);

	/**
	 * Save an existing Game entity
	 * 
	 */
	public Event saveEventGame(Integer eventId_6, Game related_game);

	/**
	 * Return all Event entity
	 * 
	 */
	public List<Event> findAllEvents(Integer startResult, Integer maxRows);
}