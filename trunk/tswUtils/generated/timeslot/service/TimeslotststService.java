package timeslot.service;

import java.util.List;
import java.util.Set;

import timeslot.domain.Timeslotstst;

/**
 * Spring service that handles CRUD requests for Timeslotstst entities
 * 
 */
public interface TimeslotststService {

	/**
	 * Save an existing Timeslotstst entity
	 * 
	 */
	public void saveTimeslotstst(Timeslotstst timeslotstst);

	/**
	 * Delete an existing Timeslotstst entity
	 * 
	 */
	public void deleteTimeslotstst(Timeslotstst timeslotstst_1);

	/**
	 * Return all Timeslotstst entity
	 * 
	 */
	public List<Timeslotstst> findAllTimeslotststs(Integer startResult, Integer maxRows);

	/**
	 */
	public Timeslotstst findTimeslotststByPrimaryKey(Integer timeslotId);

	/**
	 * Return a count of all Timeslotstst entity
	 * 
	 */
	public Integer countTimeslotststs();

	/**
	 * Load an existing Timeslotstst entity
	 * 
	 */
	public Set<Timeslotstst> loadTimeslotststs();
}