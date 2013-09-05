package tsw.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import tsw.dao.GameDAO;
import tsw.dao.GamestatsDAO;
import tsw.dao.TeamplayersDAO;

import tsw.domain.Game;
import tsw.domain.Gamestats;
import tsw.domain.Teamplayers;

/**
 * Spring service that handles CRUD requests for Gamestats entities
 * 
 */

@Service("GamestatsService")
@Transactional
public class GamestatsServiceImpl implements GamestatsService {

	/**
	 * DAO injected by Spring that manages Game entities
	 * 
	 */
	@Autowired
	private GameDAO gameDAO;

	/**
	 * DAO injected by Spring that manages Gamestats entities
	 * 
	 */
	@Autowired
	private GamestatsDAO gamestatsDAO;

	/**
	 * DAO injected by Spring that manages Teamplayers entities
	 * 
	 */
	@Autowired
	private TeamplayersDAO teamplayersDAO;

	/**
	 * Instantiates a new GamestatsServiceImpl.
	 *
	 */
	public GamestatsServiceImpl() {
	}

	/**
	 * Delete an existing Teamplayers entity
	 * 
	 */
	@Transactional
	public Gamestats deleteGamestatsTeamplayers(Integer gamestats_gameStatsId, Integer related_teamplayers_teamPlayersId) {
		Gamestats gamestats = gamestatsDAO.findGamestatsByPrimaryKey(gamestats_gameStatsId, -1, -1);
		Teamplayers related_teamplayers = teamplayersDAO.findTeamplayersByPrimaryKey(related_teamplayers_teamPlayersId, -1, -1);

		gamestats.setTeamplayers(null);
		related_teamplayers.getGamestatses().remove(gamestats);
		gamestats = gamestatsDAO.store(gamestats);
		gamestatsDAO.flush();

		related_teamplayers = teamplayersDAO.store(related_teamplayers);
		teamplayersDAO.flush();

		teamplayersDAO.remove(related_teamplayers);
		teamplayersDAO.flush();

		return gamestats;
	}

	/**
	 * Return a count of all Gamestats entity
	 * 
	 */
	@Transactional
	public Integer countGamestatss() {
		return ((Long) gamestatsDAO.createQuerySingleResult("select count(o) from Gamestats o").getSingleResult()).intValue();
	}

	/**
	 * Save an existing Teamplayers entity
	 * 
	 */
	@Transactional
	public Gamestats saveGamestatsTeamplayers(Integer gameStatsId, Teamplayers related_teamplayers) {
		Gamestats gamestats = gamestatsDAO.findGamestatsByPrimaryKey(gameStatsId, -1, -1);
		Teamplayers existingteamplayers = teamplayersDAO.findTeamplayersByPrimaryKey(related_teamplayers.getTeamPlayersId());

		// copy into the existing record to preserve existing relationships
		if (existingteamplayers != null) {
			existingteamplayers.setTeamPlayersId(related_teamplayers.getTeamPlayersId());
			existingteamplayers.setTeam(related_teamplayers.getTeam());
			existingteamplayers.setCustomer(related_teamplayers.getCustomer());
			existingteamplayers.setLevel(related_teamplayers.getLevel());
			existingteamplayers.setAmtPaid(related_teamplayers.getAmtPaid());
			existingteamplayers.setNotes(related_teamplayers.getNotes());
			existingteamplayers.setGroup2(related_teamplayers.getGroup2());
			existingteamplayers.setSignedWaiverYn(related_teamplayers.getSignedWaiverYn());
			existingteamplayers.setActiveYn(related_teamplayers.getActiveYn());
			existingteamplayers.setCaptain(related_teamplayers.getCaptain());
			existingteamplayers.setSportPosition(related_teamplayers.getSportPosition());
			existingteamplayers.setOtherAmtPaid(related_teamplayers.getOtherAmtPaid());
			related_teamplayers = existingteamplayers;
		} else {
			related_teamplayers = teamplayersDAO.store(related_teamplayers);
			teamplayersDAO.flush();
		}

		gamestats.setTeamplayers(related_teamplayers);
		related_teamplayers.getGamestatses().add(gamestats);
		gamestats = gamestatsDAO.store(gamestats);
		gamestatsDAO.flush();

		related_teamplayers = teamplayersDAO.store(related_teamplayers);
		teamplayersDAO.flush();

		return gamestats;
	}

	/**
	 * Return all Gamestats entity
	 * 
	 */
	@Transactional
	public List<Gamestats> findAllGamestatss(Integer startResult, Integer maxRows) {
		return new java.util.ArrayList<Gamestats>(gamestatsDAO.findAllGamestatss(startResult, maxRows));
	}

	/**
	 * Load an existing Gamestats entity
	 * 
	 */
	@Transactional
	public Set<Gamestats> loadGamestatss() {
		return gamestatsDAO.findAllGamestatss();
	}

	/**
	 * Delete an existing Game entity
	 * 
	 */
	@Transactional
	public Gamestats deleteGamestatsGame(Integer gamestats_gameStatsId, Integer related_game_gameId) {
		Gamestats gamestats = gamestatsDAO.findGamestatsByPrimaryKey(gamestats_gameStatsId, -1, -1);
		Game related_game = gameDAO.findGameByPrimaryKey(related_game_gameId, -1, -1);

		gamestats.setGame(null);
		related_game.getGamestatses().remove(gamestats);
		gamestats = gamestatsDAO.store(gamestats);
		gamestatsDAO.flush();

		related_game = gameDAO.store(related_game);
		gameDAO.flush();

		gameDAO.remove(related_game);
		gameDAO.flush();

		return gamestats;
	}

	/**
	 * Save an existing Gamestats entity
	 * 
	 */
	@Transactional
	public void saveGamestats(Gamestats gamestats) {
		Gamestats existingGamestats = gamestatsDAO.findGamestatsByPrimaryKey(gamestats.getGameStatsId());

		if (existingGamestats != null) {
			if (existingGamestats != gamestats) {
				existingGamestats.setGameStatsId(gamestats.getGameStatsId());
//				existingGamestats.setSportStatType(gamestats.getSportStatType());
				existingGamestats.setGameStatValue(gamestats.getGameStatValue());
				existingGamestats.setGameStatTime(gamestats.getGameStatTime());
			}
			gamestats = gamestatsDAO.store(existingGamestats);
		} else {
			gamestats = gamestatsDAO.store(gamestats);
		}
		gamestatsDAO.flush();
	}

	/**
	 * Delete an existing Gamestats entity
	 * 
	 */
	@Transactional
	public void deleteGamestats(Gamestats gamestats) {
		gamestatsDAO.remove(gamestats);
		gamestatsDAO.flush();
	}

	/**
	 */
	@Transactional
	public Gamestats findGamestatsByPrimaryKey(Integer gameStatsId) {
		return gamestatsDAO.findGamestatsByPrimaryKey(gameStatsId);
	}

	/**
	 * Save an existing Game entity
	 * 
	 */
	@Transactional
	public Gamestats saveGamestatsGame(Integer gameStatsId, Game related_game) {
		Gamestats gamestats = gamestatsDAO.findGamestatsByPrimaryKey(gameStatsId, -1, -1);
		Game existinggame = gameDAO.findGameByPrimaryKey(related_game.getGameId());

		// copy into the existing record to preserve existing relationships
		if (existinggame != null) {
			existinggame.setGameId(related_game.getGameId());
			existinggame.setTeamByHomeTeamFk(related_game.getTeamByHomeTeamFk());
			existinggame.setTeamByVisitorTeamFk(related_game.getTeamByVisitorTeamFk());
			existinggame.setGameDate(related_game.getGameDate());
			existinggame.setHomeScore(related_game.getHomeScore());
			existinggame.setVisitorScore(related_game.getVisitorScore());
			existinggame.setCustomer(related_game.getCustomer());
			existinggame.setActiveYn(related_game.getActiveYn());
			related_game = existinggame;
		} else {
			related_game = gameDAO.store(related_game);
			gameDAO.flush();
		}

		gamestats.setGame(related_game);
		related_game.getGamestatses().add(gamestats);
		gamestats = gamestatsDAO.store(gamestats);
		gamestatsDAO.flush();

		related_game = gameDAO.store(related_game);
		gameDAO.flush();

		return gamestats;
	}
}
