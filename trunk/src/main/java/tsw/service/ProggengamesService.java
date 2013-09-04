package tsw.service;

import tsw.domain.GenGame;
import tsw.domain.ProgGenGames;

import java.util.List;
import java.util.Set;

/**
 * Spring service that handles CRUD requests for ProgGenGames entities
 * 
 */
public interface ProggengamesService {

	/**
	 * Save an existing GenGame entity
	 * 
	 */
	public ProgGenGames saveProggengamesGengames(Integer progGenGamesId, GenGame related_gengames);

	/**
	 */
	public ProgGenGames findProggengamesByPrimaryKey(Integer progGenGamesId_1);

	/**
	 * Delete an existing GenGame entity
	 * 
	 */
	public ProgGenGames deleteProggengamesGengames(Integer proggengames_progGenGamesId, Integer related_gengames_genGameId);

	/**
	 * Save an existing ProgGenGames entity
	 * 
	 */
	public void saveProggengames(ProgGenGames proggengames);

	/**
	 * Return all ProgGenGames entity
	 * 
	 */
	public List<ProgGenGames> findAllProggengamess(Integer startResult, Integer maxRows);

	/**
	 * Return a count of all ProgGenGames entity
	 * 
	 */
	public Integer countProggengamess();

	/**
	 * Load an existing ProgGenGames entity
	 * 
	 */
	public Set<ProgGenGames> loadProggengamess();

	/**
	 * Delete an existing ProgGenGames entity
	 * 
	 */
	public void deleteProggengames(ProgGenGames proggengames_1);
}