package tsw.service;

import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import tsw.domain.Customer;
import tsw.domain.Game;
import tsw.domain.Gamestats;
import tsw.domain.ProgGenGames;
import tsw.domain.Program;
import tsw.domain.Team;
import tsw.domain.Tswacct;

/**
 * Spring service that handles CRUD requests for Game entities
 * 
 */
public interface GameService {

	/**
	 * Delete an existing Team entity
	 * 
	 */
	public Game deleteGameTeamByVisitorTeamFk(Integer game_gameId, Integer related_teambyvisitorteamfk_teamId);

	/**
	 * Delete an existing Team entity
	 * 
	 */
	public Game deleteGameTeamByHomeTeamFk(Integer game_gameId_1, Integer related_teambyhometeamfk_teamId);

	/**
	 * Save an existing Program entity
	 * 
	 */
	public Game saveGameProgram(Integer gameId, Program related_program);

	/**
	 * Save an existing Team entity
	 * 
	 */
	public Game saveGameTeamByHomeTeamFk(Integer gameId_1, Team related_teambyhometeamfk);

	/**
	 * Delete an existing Customer entity
	 * 
	 */
	public Game deleteGameCustomer(Integer game_gameId_3, Integer related_customer_customerId);

	/**
	 * Load an existing Game entity
	 * 
	 */
	public Set<Game> loadGames4tsw(Tswacct tswacct);

	/**
	 * Delete an existing Game entity
	 * 
	 */
	public void deleteGame(Game game);

	/**
	 * Save an existing Team entity
	 * 
	 */
	public Game saveGameTeamByVisitorTeamFk(Integer gameId_3, Team related_teambyvisitorteamfk);

	/**
	 * Return all Game entity
	 * 
	 */
	public List<Game> findAllGames4tsw(Tswacct tswacct, Integer startResult, Integer maxRows);

	/**
	 * Save an existing Game entity
	 * 
	 */
	public void saveGame(Tswacct tswacct, Game game_1, Integer resIdKey);

	/**
	 * Delete an existing Tswacct entity
	 * 
	 */
	public Game deleteGameTswacct(Integer game_gameId_4, Integer related_tswacct_tswAcctId);

	/**
	 * Save an existing Customer entity
	 * 
	 */
	public Game saveGameCustomer(Integer gameId_5, Customer related_customer);

	/**
	 * Save an existing Tswacct entity
	 * 
	 */
	public Game saveGameTswacct(Integer gameId_6, Tswacct related_tswacct);

	/**
	 * Delete an existing Program entity
	 * 
	 */
	public Game deleteGameProgram(Integer game_gameId_6, Integer related_program_programId);

	/**
	 */
	public Game findGameByPrimaryKey(Integer gameId_7);

	/**
	 * Return a count of all Game entity
	 * 
	 */
	public Integer countGames();

	public void saveGeneratedGames(HttpServletRequest request, ProgGenGames generatedGames);

	public Game deleteGameGamestatses(Integer game_gameId_2, Integer related_gamestatses_gameStatsId);

	public Game saveGameGamestatses(Integer gameId, Gamestats related_gamestatses, Integer sportStatTypeId, Integer teamplayerId);

}