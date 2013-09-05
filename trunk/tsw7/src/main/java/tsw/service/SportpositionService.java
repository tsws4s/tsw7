package tsw.service;

import java.util.List;
import java.util.Set;

import tsw.domain.Sport;
import tsw.domain.Sportposition;

/**
 * Spring service that handles CRUD requests for Sportposition entities
 * 
 */
public interface SportpositionService {

	/**
	 * Save an existing Sport entity
	 * 
	 */
	public Sportposition saveSportpositionSport(Integer sportPositionId, Sport related_sport);

	/**
	 * Delete an existing Sport entity
	 * 
	 */
	public Sportposition deleteSportpositionSport(Integer sportposition_sportPositionId, Integer related_sport_sportId);

	/**
	 * Save an existing Sportposition entity
	 * 
	 */
	public void saveSportposition(Sportposition sportposition);

	/**
	 */
	public Sportposition findSportpositionByPrimaryKey(Integer sportPositionId_1);

	/**
	 * Return a count of all Sportposition entity
	 * 
	 */
	public Integer countSportpositions();

	/**
	 * Return all Sportposition entity
	 * 
	 */
	public List<Sportposition> findAllSportpositions(Integer startResult, Integer maxRows);

	/**
	 * Load an existing Sportposition entity
	 * 
	 */
	public Set<Sportposition> loadSportpositions();

	/**
	 * Delete an existing Sportposition entity
	 * 
	 */
	public void deleteSportposition(Sportposition sportposition_1);

	public List<Sportposition> findAllSportpositionsForSport(Integer startResult, int defaultMaxRows, Integer sportId);
}