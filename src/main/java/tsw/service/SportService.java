package tsw.service;

import java.util.List;
import java.util.Set;

import tsw.domain.Program;
import tsw.domain.Sport;
import tsw.domain.Sportposition;
import tsw.domain.Sportstattype;

/**
 * Spring service that handles CRUD requests for Sport entities
 * 
 */
public interface SportService {

	/**
	 * Return all Sport entity
	 * 
	 */
	public List<Sport> findAllSports(Integer startResult, Integer maxRows);

	/**
	 * Save an existing Sportstattype entity
	 * 
	 */
	public Sport saveSportSportstattypes(Integer sportId, Sportstattype related_sportstattypes);

	/**
	 * Delete an existing Sport entity
	 * 
	 */
	public void deleteSport(Sport sport);

	/**
	 * Save an existing Program entity
	 * 
	 */
	public Sport saveSportPrograms(Integer sportId_1, Program related_programs);

	/**
	 * Delete an existing Sportstattype entity
	 * 
	 */
	public Sport deleteSportSportstattypes(Integer sport_sportId, Integer related_sportstattypes_sportStatTypeId);

	/**
	 * Delete an existing Program entity
	 * 
	 */
	public Sport deleteSportPrograms(Integer sport_sportId_1, Integer related_programs_programId);

	/**
	 * Delete an existing Sportposition entity
	 * 
	 */
	public Sport deleteSportSportpositions(Integer sport_sportId_2, Integer related_sportpositions_sportPositionId);

	/**
	 * Load an existing Sport entity
	 * 
	 */
	public Set<Sport> loadSports();

	/**
	 * Save an existing Sportposition entity
	 * 
	 */
	public Sport saveSportSportpositions(Integer sportId_2, Sportposition related_sportpositions);

	/**
	 * Return a count of all Sport entity
	 * 
	 */
	public Integer countSports();

	/**
	 * Save an existing Sport entity
	 * 
	 */
	public void saveSport(Sport sport_1);

	/**
	 */
	public Sport findSportByPrimaryKey(Integer sportId_3);
}