package tsw.service;

import tsw.domain.GenGame;
import tsw.domain.ProgGenGames;

import java.util.List;
import java.util.Set;

/**
 * Spring service that handles CRUD requests for GenGame entities
 * 
 */
public interface GengameService {

	/**
	 * Return a count of all GenGame entity
	 * 
	 */
	public Integer countGengames();

	/**
	 * Delete an existing GenGame entity
	 * 
	 */
	public void deleteGengame(GenGame gengame);

	/**
	 */
	public GenGame findGengameByPrimaryKey(Integer genGameId);

	/**
	 * Save an existing ProgGenGames entity
	 * 
	 */
	public GenGame saveGengameProggengames(Integer genGameId_1, ProgGenGames related_proggengames);

	/**
	 * Load an existing GenGame entity
	 * 
	 */
	public Set<GenGame> loadGengames();

	/**
	 * Delete an existing ProgGenGames entity
	 * 
	 */
	public GenGame deleteGengameProggengames(Integer gengame_genGameId, Integer related_proggengames_progGenGamesId);

	/**
	 * Save an existing GenGame entity
	 * 
	 */
	public void saveGengame(GenGame gengame_1);

	/**
	 * Return all GenGame entity
	 * 
	 */
	public List<GenGame> findAllGengames(Integer startResult, Integer maxRows);
}