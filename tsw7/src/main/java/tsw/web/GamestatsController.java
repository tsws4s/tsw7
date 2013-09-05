package tsw.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.WebDataBinder;

import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.servlet.ModelAndView;

import tsw.dao.GameDAO;
import tsw.dao.GamestatsDAO;
import tsw.dao.TeamplayersDAO;

import tsw.domain.Game;
import tsw.domain.Gamestats;
import tsw.domain.Teamplayers;

import tsw.service.GamestatsService;

/**
 * Spring MVC controller that handles CRUD requests for Gamestats entities
 * 
 */

@Controller("GamestatsController")
public class GamestatsController {

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
	 * Service injected by Spring that provides CRUD operations for Gamestats entities
	 * 
	 */
	@Autowired
	private GamestatsService gamestatsService;

	/**
	 * Delete an existing Gamestats entity
	 * 
	 */
	@RequestMapping("/deleteGamestats")
	public String deleteGamestats(@RequestParam Integer gameStatsIdKey) {
		Gamestats gamestats = gamestatsDAO.findGamestatsByPrimaryKey(gameStatsIdKey);
		gamestatsService.deleteGamestats(gamestats);
		return "forward:/indexGamestats";
	}

	/**
	 * Show all Game entities by Gamestats
	 * 
	 */
	@RequestMapping("/listGamestatsGame")
	public ModelAndView listGamestatsGame(@RequestParam Integer gameStatsIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("gamestats", gamestatsDAO.findGamestatsByPrimaryKey(gameStatsIdKey));
		mav.setViewName("gamestats/game/listGame.jsp");

		return mav;
	}

	/**
	 * Create a new Teamplayers entity
	 * 
	 */
	@RequestMapping("/newGamestatsTeamplayers")
	public ModelAndView newGamestatsTeamplayers(@RequestParam Integer gamestats_gameStatsId) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("gamestats_gameStatsId", gamestats_gameStatsId);
		mav.addObject("teamplayers", new Teamplayers());
		mav.addObject("newFlag", true);
		mav.setViewName("gamestats/teamplayers/editTeamplayers.jsp");

		return mav;
	}

	/**
	 * Register custom, context-specific property editors
	 * 
	 */
	@InitBinder
	public void initBinder(WebDataBinder binder, HttpServletRequest request) { // Register static property editors.
		binder.registerCustomEditor(java.util.Calendar.class, new org.skyway.spring.util.databinding.CustomCalendarEditor());
		binder.registerCustomEditor(byte[].class, new org.springframework.web.multipart.support.ByteArrayMultipartFileEditor());
		binder.registerCustomEditor(boolean.class, new org.skyway.spring.util.databinding.EnhancedBooleanEditor(false));
		binder.registerCustomEditor(Boolean.class, new org.skyway.spring.util.databinding.EnhancedBooleanEditor(true));
		binder.registerCustomEditor(java.math.BigDecimal.class, new org.skyway.spring.util.databinding.NaNHandlingNumberEditor(java.math.BigDecimal.class, true));
		binder.registerCustomEditor(Integer.class, new org.skyway.spring.util.databinding.NaNHandlingNumberEditor(Integer.class, true));
		binder.registerCustomEditor(java.util.Date.class, new org.skyway.spring.util.databinding.CustomDateEditor());
		binder.registerCustomEditor(String.class, new org.skyway.spring.util.databinding.StringEditor());
		binder.registerCustomEditor(Long.class, new org.skyway.spring.util.databinding.NaNHandlingNumberEditor(Long.class, true));
		binder.registerCustomEditor(Double.class, new org.skyway.spring.util.databinding.NaNHandlingNumberEditor(Double.class, true));
	}

	/**
	 * Select the child Game entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteGamestatsGame")
	public ModelAndView confirmDeleteGamestatsGame(@RequestParam Integer gamestats_gameStatsId, @RequestParam Integer related_game_gameId) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("game", gameDAO.findGameByPrimaryKey(related_game_gameId));
		mav.addObject("gamestats_gameStatsId", gamestats_gameStatsId);
		mav.setViewName("gamestats/game/deleteGame.jsp");

		return mav;
	}

	/**
	 */
	@RequestMapping("/gamestatsController/binary.action")
	public ModelAndView streamBinary(@ModelAttribute HttpServletRequest request, @ModelAttribute HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("streamedBinaryContentView");
		return mav;

	}

	/**
	 * Create a new Gamestats entity
	 * 
	 */
	@RequestMapping("/newGamestats")
	public ModelAndView newGamestats() {
		ModelAndView mav = new ModelAndView();

		mav.addObject("gamestats", new Gamestats());
		mav.addObject("newFlag", true);
		mav.setViewName("gamestats/editGamestats.jsp");

		return mav;
	}

	/**
	 * Create a new Game entity
	 * 
	 */
	@RequestMapping("/newGamestatsGame")
	public ModelAndView newGamestatsGame(@RequestParam Integer gamestats_gameStatsId) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("gamestats_gameStatsId", gamestats_gameStatsId);
		mav.addObject("game", new Game());
		mav.addObject("newFlag", true);
		mav.setViewName("gamestats/game/editGame.jsp");

		return mav;
	}

	/**
	 * Save an existing Game entity
	 * 
	 */
	@RequestMapping("/saveGamestatsGame")
	public ModelAndView saveGamestatsGame(@RequestParam Integer gamestats_gameStatsId, @ModelAttribute Game game) {
		Gamestats parent_gamestats = gamestatsService.saveGamestatsGame(gamestats_gameStatsId, game);

		ModelAndView mav = new ModelAndView();
		mav.addObject("gamestats_gameStatsId", gamestats_gameStatsId);
		mav.addObject("gamestats", parent_gamestats);
		mav.setViewName("gamestats/viewGamestats.jsp");

		return mav;
	}

	/**
	 * Edit an existing Gamestats entity
	 * 
	 */
	@RequestMapping("/editGamestats")
	public ModelAndView editGamestats(@RequestParam Integer gameStatsIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("gamestats", gamestatsDAO.findGamestatsByPrimaryKey(gameStatsIdKey));
		mav.setViewName("gamestats/editGamestats.jsp");

		return mav;
	}

	/**
	 * Save an existing Gamestats entity
	 * 
	 */
	@RequestMapping("/saveGamestats")
	public String saveGamestats(@ModelAttribute Gamestats gamestats) {
		gamestatsService.saveGamestats(gamestats);
		return "forward:/indexGamestats";
	}

	/**
	 * Show all Gamestats entities
	 * 
	 */
	@RequestMapping("/indexGamestats")
	public ModelAndView listGamestatss() {
		ModelAndView mav = new ModelAndView();

		mav.addObject("gamestatss", gamestatsService.loadGamestatss());

		mav.setViewName("gamestats/listGamestatss.jsp");

		return mav;
	}

	/**
	 * Edit an existing Teamplayers entity
	 * 
	 */
	@RequestMapping("/editGamestatsTeamplayers")
	public ModelAndView editGamestatsTeamplayers(@RequestParam Integer gamestats_gameStatsId, @RequestParam Integer teamplayers_teamPlayersId) {
		Teamplayers teamplayers = teamplayersDAO.findTeamplayersByPrimaryKey(teamplayers_teamPlayersId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("gamestats_gameStatsId", gamestats_gameStatsId);
		mav.addObject("teamplayers", teamplayers);
		mav.setViewName("gamestats/teamplayers/editTeamplayers.jsp");

		return mav;
	}

	/**
	 * Delete an existing Game entity
	 * 
	 */
	@RequestMapping("/deleteGamestatsGame")
	public ModelAndView deleteGamestatsGame(@RequestParam Integer gamestats_gameStatsId, @RequestParam Integer related_game_gameId) {
		ModelAndView mav = new ModelAndView();

		Gamestats gamestats = gamestatsService.deleteGamestatsGame(gamestats_gameStatsId, related_game_gameId);

		mav.addObject("gamestats_gameStatsId", gamestats_gameStatsId);
		mav.addObject("gamestats", gamestats);
		mav.setViewName("gamestats/viewGamestats.jsp");

		return mav;
	}

	/**
	 * Select the Gamestats entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteGamestats")
	public ModelAndView confirmDeleteGamestats(@RequestParam Integer gameStatsIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("gamestats", gamestatsDAO.findGamestatsByPrimaryKey(gameStatsIdKey));
		mav.setViewName("gamestats/deleteGamestats.jsp");

		return mav;
	}

	/**
	 * Show all Teamplayers entities by Gamestats
	 * 
	 */
	@RequestMapping("/listGamestatsTeamplayers")
	public ModelAndView listGamestatsTeamplayers(@RequestParam Integer gameStatsIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("gamestats", gamestatsDAO.findGamestatsByPrimaryKey(gameStatsIdKey));
		mav.setViewName("gamestats/teamplayers/listTeamplayers.jsp");

		return mav;
	}

	/**
	 * View an existing Teamplayers entity
	 * 
	 */
	@RequestMapping("/selectGamestatsTeamplayers")
	public ModelAndView selectGamestatsTeamplayers(@RequestParam Integer gamestats_gameStatsId, @RequestParam Integer teamplayers_teamPlayersId) {
		Teamplayers teamplayers = teamplayersDAO.findTeamplayersByPrimaryKey(teamplayers_teamPlayersId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("gamestats_gameStatsId", gamestats_gameStatsId);
		mav.addObject("teamplayers", teamplayers);
		mav.setViewName("gamestats/teamplayers/viewTeamplayers.jsp");

		return mav;
	}

	/**
	 * Select the child Teamplayers entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteGamestatsTeamplayers")
	public ModelAndView confirmDeleteGamestatsTeamplayers(@RequestParam Integer gamestats_gameStatsId, @RequestParam Integer related_teamplayers_teamPlayersId) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("teamplayers", teamplayersDAO.findTeamplayersByPrimaryKey(related_teamplayers_teamPlayersId));
		mav.addObject("gamestats_gameStatsId", gamestats_gameStatsId);
		mav.setViewName("gamestats/teamplayers/deleteTeamplayers.jsp");

		return mav;
	}

	/**
	 * Edit an existing Game entity
	 * 
	 */
	@RequestMapping("/editGamestatsGame")
	public ModelAndView editGamestatsGame(@RequestParam Integer gamestats_gameStatsId, @RequestParam Integer game_gameId) {
		Game game = gameDAO.findGameByPrimaryKey(game_gameId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("gamestats_gameStatsId", gamestats_gameStatsId);
		mav.addObject("game", game);
		mav.setViewName("gamestats/game/editGame.jsp");

		return mav;
	}

	/**
	 * Entry point to show all Gamestats entities
	 * 
	 */
	public String indexGamestats() {
		return "redirect:/indexGamestats";
	}

	/**
	 * View an existing Game entity
	 * 
	 */
	@RequestMapping("/selectGamestatsGame")
	public ModelAndView selectGamestatsGame(@RequestParam Integer gamestats_gameStatsId, @RequestParam Integer game_gameId) {
		Game game = gameDAO.findGameByPrimaryKey(game_gameId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("gamestats_gameStatsId", gamestats_gameStatsId);
		mav.addObject("game", game);
		mav.setViewName("gamestats/game/viewGame.jsp");

		return mav;
	}

	/**
	 * Save an existing Teamplayers entity
	 * 
	 */
	@RequestMapping("/saveGamestatsTeamplayers")
	public ModelAndView saveGamestatsTeamplayers(@RequestParam Integer gamestats_gameStatsId, @ModelAttribute Teamplayers teamplayers) {
		Gamestats parent_gamestats = gamestatsService.saveGamestatsTeamplayers(gamestats_gameStatsId, teamplayers);

		ModelAndView mav = new ModelAndView();
		mav.addObject("gamestats_gameStatsId", gamestats_gameStatsId);
		mav.addObject("gamestats", parent_gamestats);
		mav.setViewName("gamestats/viewGamestats.jsp");

		return mav;
	}

	/**
	 * Delete an existing Teamplayers entity
	 * 
	 */
	@RequestMapping("/deleteGamestatsTeamplayers")
	public ModelAndView deleteGamestatsTeamplayers(@RequestParam Integer gamestats_gameStatsId, @RequestParam Integer related_teamplayers_teamPlayersId) {
		ModelAndView mav = new ModelAndView();

		Gamestats gamestats = gamestatsService.deleteGamestatsTeamplayers(gamestats_gameStatsId, related_teamplayers_teamPlayersId);

		mav.addObject("gamestats_gameStatsId", gamestats_gameStatsId);
		mav.addObject("gamestats", gamestats);
		mav.setViewName("gamestats/viewGamestats.jsp");

		return mav;
	}

	/**
	 * Select an existing Gamestats entity
	 * 
	 */
	@RequestMapping("/selectGamestats")
	public ModelAndView selectGamestats(@RequestParam Integer gameStatsIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("gamestats", gamestatsDAO.findGamestatsByPrimaryKey(gameStatsIdKey));
		mav.setViewName("gamestats/viewGamestats.jsp");

		return mav;
	}
}