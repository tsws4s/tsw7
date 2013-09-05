package tsw.service;

import java.util.Calendar;
import java.util.List;
import java.util.Set;

import tsw.domain.Resource;
import tsw.domain.Tswacct;
import tsw.domain.fcEvent;

/**
 * Spring service that handles CRUD requests for fcEvent entities
 * 
 */
public interface fcEventService {

	/**
	 * Return a count of all fcEvent entity
	 * 
	 */
	public Integer countfcEvents();

	/**
	 * Load an existing fcEvent entity
	 * 
	 */
	public Set<fcEvent> loadfcEvents4tsw(Tswacct tswacct);

	/**
	 * Return all fcEvent entity
	 * 
	 */
	public List<fcEvent> findAllfcEvents4tsw(Tswacct tswacct, Integer startResult, Integer maxRows);
	public List<fcEvent> findAllfcEvents4tswResource(Tswacct tswacct,Resource res, Integer startResult, Integer maxRows);
	/**
	 */
	public fcEvent findfcEventByPrimaryKey(Integer id);

	/**
	 * Delete an existing fcEvent entity
	 * 
	 */
	public void deletefcEvent(fcEvent fcEvent);

	/**
	 * Save an existing fcEvent entity
	 * 
	 */
	public void savefcEvent(fcEvent fcEvent_1);

	public Set<fcEvent> loadfcEvents(Integer resource_id, Calendar afterDate, Calendar beforeDate);
}