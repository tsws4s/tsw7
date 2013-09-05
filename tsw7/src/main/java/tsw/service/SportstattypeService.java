package tsw.service;

import java.util.List;
import java.util.Set;

import tsw.domain.Sport;
import tsw.domain.Sportstattype;

/**
 * Spring service that handles CRUD requests for Sportstattype entities
 * 
 */
public interface SportstattypeService {

	/**
	 * Load an existing Sportstattype entity
	 * 
	 */
	public Set<Sportstattype> loadSportstattypes();

	/**
	 * Return all Sportstattype entity
	 * 
	 */
	public List<Sportstattype> findAllSportstattypes(Integer startResult, Integer maxRows);

	/**
	 * Return a count of all Sportstattype entity
	 * 
	 */
	public Integer countSportstattypes();

	/**
	 * Save an existing Sportstattype entity
	 * 
	 */
	public void saveSportstattype(Sportstattype sportstattype);

	/**
	 * Save an existing Sport entity
	 * 
	 */
	public Sportstattype saveSportstattypeSport(Integer sportStatTypeId, Sport related_sport);

	/**
	 * Delete an existing Sport entity
	 * 
	 */
	public Sportstattype deleteSportstattypeSport(Integer sportstattype_sportStatTypeId, Integer related_sport_sportId);

	/**
	 * Delete an existing Sportstattype entity
	 * 
	 */
	public void deleteSportstattype(Sportstattype sportstattype_1);

	/**
	 */
	public Sportstattype findSportstattypeByPrimaryKey(Integer sportStatTypeId_1);
}