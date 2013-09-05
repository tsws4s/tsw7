package tsw.service;

import java.util.List;
import java.util.Set;

import tsw.domain.Game;
import tsw.domain.Gamestats;
import tsw.domain.Teamplayers;

/**
 * Spring service that handles CRUD requests for Gamestats entities
 * 
 */
public interface GamestatsService {

	/**
	 * Delete an existing Teamplayers entity
	 * 
	 */
	public Gamestats deleteGamestatsTeamplayers(Integer gamestats_gameStatsId, Integer related_teamplayers_teamPlayersId);

	/**
	 * Return a count of all Gamestats entity
	 * 
	 */
	public Integer countGamestatss();

	/**
	 * Save an existing Teamplayers entity
	 * 
	 */
	public Gamestats saveGamestatsTeamplayers(Integer gameStatsId, Teamplayers related_teamplayers);

	/**
	 * Return all Gamestats entity
	 * 
	 */
	public List<Gamestats> findAllGamestatss(Integer startResult, Integer maxRows);

	/**
	 * Load an existing Gamestats entity
	 * 
	 */
	public Set<Gamestats> loadGamestatss();

	/**
	 * Delete an existing Game entity
	 * 
	 */
	public Gamestats deleteGamestatsGame(Integer gamestats_gameStatsId_1, Integer related_game_gameId);

	/**
	 * Save an existing Gamestats entity
	 * 
	 */
	public void saveGamestats(Gamestats gamestats);

	/**
	 * Delete an existing Gamestats entity
	 * 
	 */
	public void deleteGamestats(Gamestats gamestats_1);

	/**
	 */
	public Gamestats findGamestatsByPrimaryKey(Integer gameStatsId_1);

	/**
	 * Save an existing Game entity
	 * 
	 */
	public Gamestats saveGamestatsGame(Integer gameStatsId_2, Game related_game);
}