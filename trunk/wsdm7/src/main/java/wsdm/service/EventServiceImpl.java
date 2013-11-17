package wsdm.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import wsdm.dao.CustomerDAO;
import wsdm.dao.EventDAO;
import wsdm.dao.GameDAO;
import wsdm.dao.PriceDAO;
import wsdm.dao.ProgramDAO;
import wsdm.dao.ResourceDAO;
import wsdm.dao.TswacctDAO;

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

@Service("EventService")
@Transactional
public class EventServiceImpl implements EventService {

	/**
	 * DAO injected by Spring that manages Customer entities
	 * 
	 */
	@Autowired
	private CustomerDAO customerDAO;

	/**
	 * DAO injected by Spring that manages Event entities
	 * 
	 */
	@Autowired
	private EventDAO eventDAO;

	/**
	 * DAO injected by Spring that manages Game entities
	 * 
	 */
	@Autowired
	private GameDAO gameDAO;

	/**
	 * DAO injected by Spring that manages Price entities
	 * 
	 */
	@Autowired
	private PriceDAO priceDAO;

	/**
	 * DAO injected by Spring that manages Program entities
	 * 
	 */
	@Autowired
	private ProgramDAO programDAO;

	/**
	 * DAO injected by Spring that manages Resource entities
	 * 
	 */
	@Autowired
	private ResourceDAO resourceDAO;

	/**
	 * DAO injected by Spring that manages Tswacct entities
	 * 
	 */
	@Autowired
	private TswacctDAO tswacctDAO;

	/**
	 * Instantiates a new EventServiceImpl.
	 *
	 */
	public EventServiceImpl() {
	}

	/**
	 * Save an existing Customer entity
	 * 
	 */
	@Transactional
	public Event saveEventCustomer(Integer eventId, Customer related_customer) {
		Event event = eventDAO.findEventByPrimaryKey(eventId, -1, -1);
		Customer existingcustomer = customerDAO.findCustomerByPrimaryKey(related_customer.getCustomerId());

		// copy into the existing record to preserve existing relationships
		if (existingcustomer != null) {
			existingcustomer.setCustomerId(related_customer.getCustomerId());
			existingcustomer.setEmail(related_customer.getEmail());
			existingcustomer.setFirstname(related_customer.getFirstname());
			existingcustomer.setLastname(related_customer.getLastname());
			existingcustomer.setPhone(related_customer.getPhone());
			existingcustomer.setYearBorn(related_customer.getYearBorn());
			existingcustomer.setAddress(related_customer.getAddress());
			existingcustomer.setCity(related_customer.getCity());
			existingcustomer.setState(related_customer.getState());
			existingcustomer.setZipcode(related_customer.getZipcode());
			existingcustomer.setAddrSameAsFamily(related_customer.getAddrSameAsFamily());
			existingcustomer.setActiveYn(related_customer.getActiveYn());
			existingcustomer.setPassword(related_customer.getPassword());
			existingcustomer.setSelectTheme(related_customer.getSelectTheme());
			existingcustomer.setAdminYn(related_customer.getAdminYn());
			related_customer = existingcustomer;
		} else {
			related_customer = customerDAO.store(related_customer);
			customerDAO.flush();
		}

		event.setCustomer(related_customer);
		related_customer.getEvents().add(event);
		event = eventDAO.store(event);
		eventDAO.flush();

		related_customer = customerDAO.store(related_customer);
		customerDAO.flush();

		return event;
	}

	/**
	 * Delete an existing Program entity
	 * 
	 */
	@Transactional
	public Event deleteEventProgram(Integer event_eventId, Integer related_program_programId) {
		Event event = eventDAO.findEventByPrimaryKey(event_eventId, -1, -1);
		Program related_program = programDAO.findProgramByPrimaryKey(related_program_programId, -1, -1);

		event.setProgram(null);
		related_program.getEvents().remove(event);
		event = eventDAO.store(event);
		eventDAO.flush();

		related_program = programDAO.store(related_program);
		programDAO.flush();

		programDAO.remove(related_program);
		programDAO.flush();

		return event;
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
	 * Delete an existing Game entity
	 * 
	 */
	@Transactional
	public Event deleteEventGame(Integer event_eventId, Integer related_game_gameId) {
		Event event = eventDAO.findEventByPrimaryKey(event_eventId, -1, -1);
		Game related_game = gameDAO.findGameByPrimaryKey(related_game_gameId, -1, -1);

		event.setGame(null);
		related_game.getEvents().remove(event);
		event = eventDAO.store(event);
		eventDAO.flush();

		related_game = gameDAO.store(related_game);
		gameDAO.flush();

		gameDAO.remove(related_game);
		gameDAO.flush();

		return event;
	}

	/**
	 * Delete an existing Tswacct entity
	 * 
	 */
	@Transactional
	public Event deleteEventTswacct(Integer event_eventId, Integer related_tswacct_tswAcctId) {
		Event event = eventDAO.findEventByPrimaryKey(event_eventId, -1, -1);
		Tswacct related_tswacct = tswacctDAO.findTswacctByPrimaryKey(related_tswacct_tswAcctId, -1, -1);

		event.setTswacct(null);
		related_tswacct.getEvents().remove(event);
		event = eventDAO.store(event);
		eventDAO.flush();

		related_tswacct = tswacctDAO.store(related_tswacct);
		tswacctDAO.flush();

		tswacctDAO.remove(related_tswacct);
		tswacctDAO.flush();

		return event;
	}

	/**
	 */
	@Transactional
	public Event findEventByPrimaryKey(Integer eventId) {
		return eventDAO.findEventByPrimaryKey(eventId);
	}

	/**
	 * Save an existing Price entity
	 * 
	 */
	@Transactional
	public Event saveEventPrice(Integer eventId, Price related_price) {
		Event event = eventDAO.findEventByPrimaryKey(eventId, -1, -1);
		Price existingprice = priceDAO.findPriceByPrimaryKey(related_price.getPriceId());

		// copy into the existing record to preserve existing relationships
		if (existingprice != null) {
			existingprice.setPriceId(related_price.getPriceId());
			existingprice.setPriceField(related_price.getPriceField());
			existingprice.setPriceCategory(related_price.getPriceCategory());
			existingprice.setDescription(related_price.getDescription());
			existingprice.setPriceColor(related_price.getPriceColor());
			related_price = existingprice;
		} else {
			related_price = priceDAO.store(related_price);
			priceDAO.flush();
		}

		event.setPrice(related_price);
		related_price.getEvents().add(event);
		event = eventDAO.store(event);
		eventDAO.flush();

		related_price = priceDAO.store(related_price);
		priceDAO.flush();

		return event;
	}

	/**
	 * Save an existing Tswacct entity
	 * 
	 */
	@Transactional
	public Event saveEventTswacct(Integer eventId, Tswacct related_tswacct) {
		Event event = eventDAO.findEventByPrimaryKey(eventId, -1, -1);
		Tswacct existingtswacct = tswacctDAO.findTswacctByPrimaryKey(related_tswacct.getTswAcctId());

		// copy into the existing record to preserve existing relationships
		if (existingtswacct != null) {
			existingtswacct.setTswAcctId(related_tswacct.getTswAcctId());
			existingtswacct.setAcctName(related_tswacct.getAcctName());
			existingtswacct.setSubscrType(related_tswacct.getSubscrType());
			existingtswacct.setAmtPaid(related_tswacct.getAmtPaid());
			existingtswacct.setEstablishDate(related_tswacct.getEstablishDate());
			existingtswacct.setExpireDate(related_tswacct.getExpireDate());
			existingtswacct.setActiveYn(related_tswacct.getActiveYn());
			related_tswacct = existingtswacct;
		} else {
			related_tswacct = tswacctDAO.store(related_tswacct);
			tswacctDAO.flush();
		}

		event.setTswacct(related_tswacct);
		related_tswacct.getEvents().add(event);
		event = eventDAO.store(event);
		eventDAO.flush();

		related_tswacct = tswacctDAO.store(related_tswacct);
		tswacctDAO.flush();

		return event;
	}

	/**
	 * Save an existing Resource entity
	 * 
	 */
	@Transactional
	public Event saveEventResource(Integer eventId, Resource related_resource) {
		Event event = eventDAO.findEventByPrimaryKey(eventId, -1, -1);
		Resource existingresource = resourceDAO.findResourceByPrimaryKey(related_resource.getResourceId());

		// copy into the existing record to preserve existing relationships
		if (existingresource != null) {
			existingresource.setResourceId(related_resource.getResourceId());
			existingresource.setResourceName(related_resource.getResourceName());
			existingresource.setActiveYn(related_resource.getActiveYn());
			existingresource.setNotes(related_resource.getNotes());
			existingresource.setResourceType(related_resource.getResourceType());
			existingresource.setEmail(related_resource.getEmail());
			existingresource.setPhone(related_resource.getPhone());
			existingresource.setAddress(related_resource.getAddress());
			existingresource.setCity(related_resource.getCity());
			existingresource.setState(related_resource.getState());
			existingresource.setZipcode(related_resource.getZipcode());
			related_resource = existingresource;
		} else {
			related_resource = resourceDAO.store(related_resource);
			resourceDAO.flush();
		}

		event.setResource(related_resource);
		related_resource.getEvents().add(event);
		event = eventDAO.store(event);
		eventDAO.flush();

		related_resource = resourceDAO.store(related_resource);
		resourceDAO.flush();

		return event;
	}

	/**
	 * Delete an existing Customer entity
	 * 
	 */
	@Transactional
	public Event deleteEventCustomer(Integer event_eventId, Integer related_customer_customerId) {
		Event event = eventDAO.findEventByPrimaryKey(event_eventId, -1, -1);
		Customer related_customer = customerDAO.findCustomerByPrimaryKey(related_customer_customerId, -1, -1);

		event.setCustomer(null);
		related_customer.getEvents().remove(event);
		event = eventDAO.store(event);
		eventDAO.flush();

		related_customer = customerDAO.store(related_customer);
		customerDAO.flush();

		customerDAO.remove(related_customer);
		customerDAO.flush();

		return event;
	}

	/**
	 * Return a count of all Event entity
	 * 
	 */
	@Transactional
	public Integer countEvents() {
		return ((Long) eventDAO.createQuerySingleResult("select count(o) from Event o").getSingleResult()).intValue();
	}

	/**
	 * Delete an existing Resource entity
	 * 
	 */
	@Transactional
	public Event deleteEventResource(Integer event_eventId, Integer related_resource_resourceId) {
		Event event = eventDAO.findEventByPrimaryKey(event_eventId, -1, -1);
		Resource related_resource = resourceDAO.findResourceByPrimaryKey(related_resource_resourceId, -1, -1);

		event.setResource(null);
		related_resource.getEvents().remove(event);
		event = eventDAO.store(event);
		eventDAO.flush();

		related_resource = resourceDAO.store(related_resource);
		resourceDAO.flush();

		resourceDAO.remove(related_resource);
		resourceDAO.flush();

		return event;
	}

	/**
	 * Save an existing Program entity
	 * 
	 */
	@Transactional
	public Event saveEventProgram(Integer eventId, Program related_program) {
		Event event = eventDAO.findEventByPrimaryKey(eventId, -1, -1);
		Program existingprogram = programDAO.findProgramByPrimaryKey(related_program.getProgramId());

		// copy into the existing record to preserve existing relationships
		if (existingprogram != null) {
			existingprogram.setProgramId(related_program.getProgramId());
			existingprogram.setProgramName(related_program.getProgramName());
			existingprogram.setStartDate(related_program.getStartDate());
			existingprogram.setEndDate(related_program.getEndDate());
			existingprogram.setLevelFk(related_program.getLevelFk());
			existingprogram.setActiveYn(related_program.getActiveYn());
			existingprogram.setPublishYn(related_program.getPublishYn());
			existingprogram.setTotalPaid(related_program.getTotalPaid());
			existingprogram.setTotalParticipants(related_program.getTotalParticipants());
			existingprogram.setGamesPerTeam(related_program.getGamesPerTeam());
			existingprogram.setLeagueYn(related_program.getLeagueYn());
			related_program = existingprogram;
		} else {
			related_program = programDAO.store(related_program);
			programDAO.flush();
		}

		event.setProgram(related_program);
		related_program.getEvents().add(event);
		event = eventDAO.store(event);
		eventDAO.flush();

		related_program = programDAO.store(related_program);
		programDAO.flush();

		return event;
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
	 * Delete an existing Price entity
	 * 
	 */
	@Transactional
	public Event deleteEventPrice(Integer event_eventId, Integer related_price_priceId) {
		Event event = eventDAO.findEventByPrimaryKey(event_eventId, -1, -1);
		Price related_price = priceDAO.findPriceByPrimaryKey(related_price_priceId, -1, -1);

		event.setPrice(null);
		related_price.getEvents().remove(event);
		event = eventDAO.store(event);
		eventDAO.flush();

		related_price = priceDAO.store(related_price);
		priceDAO.flush();

		priceDAO.remove(related_price);
		priceDAO.flush();

		return event;
	}

	/**
	 * Save an existing Event entity
	 * 
	 */
	@Transactional
	public void saveEvent(Event event) {
		Event existingEvent = eventDAO.findEventByPrimaryKey(event.getEventId());

		if (existingEvent != null) {
			if (existingEvent != event) {
				existingEvent.setEventId(event.getEventId());
				existingEvent.setStartTime(event.getStartTime());
				existingEvent.setEndTime(event.getEndTime());
				existingEvent.setEventName(event.getEventName());
				existingEvent.setDescription(event.getDescription());
				existingEvent.setEventType(event.getEventType());
				existingEvent.setEventUrl(event.getEventUrl());
				existingEvent.setEventColor(event.getEventColor());
				existingEvent.setAllDay(event.getAllDay());
			}
			event = eventDAO.store(existingEvent);
		} else {
			event = eventDAO.store(event);
		}
		eventDAO.flush();
	}

	/**
	 * Save an existing Game entity
	 * 
	 */
	@Transactional
	public Event saveEventGame(Integer eventId, Game related_game) {
		Event event = eventDAO.findEventByPrimaryKey(eventId, -1, -1);
		Game existinggame = gameDAO.findGameByPrimaryKey(related_game.getGameId());

		// copy into the existing record to preserve existing relationships
		if (existinggame != null) {
			existinggame.setGameId(related_game.getGameId());
			existinggame.setGameDate(related_game.getGameDate());
			existinggame.setHomeScore(related_game.getHomeScore());
			existinggame.setVisitorScore(related_game.getVisitorScore());
			existinggame.setRefereeFk(related_game.getRefereeFk());
			existinggame.setActiveYn(related_game.getActiveYn());
			related_game = existinggame;
		} else {
			related_game = gameDAO.store(related_game);
			gameDAO.flush();
		}

		event.setGame(related_game);
		related_game.getEvents().add(event);
		event = eventDAO.store(event);
		eventDAO.flush();

		related_game = gameDAO.store(related_game);
		gameDAO.flush();

		return event;
	}

	/**
	 * Return all Event entity
	 * 
	 */
	@Transactional
	public List<Event> findAllEvents(Integer startResult, Integer maxRows) {
		return new java.util.ArrayList<Event>(eventDAO.findAllEvents(startResult, maxRows));
	}
}
