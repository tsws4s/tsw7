package tsw.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.WebDataBinder;

import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.servlet.ModelAndView;
import java.util.Set;

import tsw.dao.GamestatsDAO;
import tsw.domain.Game;
import tsw.domain.Gamestats;
import tsw.domain.Program;
import tsw.domain.Tswacct;

import tsw.service.GameService;
import tsw.service.ProgramService;
import tsw.service.ResourceService;

/**
 * Spring MVC controller that handles CRUD requests for Game entities
 * 
 */


@Controller("GameController")
public class GameController {

	static int defaultMaxRows = 10;
	
	SessionConfigCache sessionCache = UsersController.getSessionCache();

	/**
	 * Service injected by Spring that provides CRUD operations for Game entities
	 * 
	 */
	@Autowired
	private GameService gameService;
	
	@Autowired
	private ProgramService programService;
	
	@Autowired
	private GameService gameDAO;
	@Autowired
	private GamestatsDAO gamestatsDAO; 
	
	@Autowired
	private ResourceService resourceService;
	
	// Init
	/**  ***************************************  Init  *******************************************************
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
	 */
	@RequestMapping("/gameController/binary.action")
	public ModelAndView streamBinary(@ModelAttribute HttpServletRequest request, @ModelAttribute HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("streamedBinaryContentView");
		return mav;

	}

	// List Search
	/**  *************************************  List Search  *************************************************
	 * Show all Game entities
	 * 
	 */
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/indexGameFrom")
	public ModelAndView listGamesFrom(HttpServletRequest request, @RequestParam int indexFrom) {
		ModelAndView mav = new ModelAndView();
		Set<Program> pgmLeagues = programService.loadLeagues4tsw(sessionCache.getTswacct(request));
		mav.addObject("leagues", pgmLeagues);
		mav.addObject("program", pgmLeagues.iterator().next());
		mav.addObject("user",sessionCache.getUser4Session(request));
		mav.setViewName("program/games/listGames.jsp");
		return mav;
	}
	
	@RequestMapping("/indexGame")
	public ModelAndView listGames(HttpServletRequest request) {
		return listGamesFrom(request, 0);
	}
	
	/**
	 * Entry point to show all Game entities
	 * 
	 */
	public String indexGame(HttpServletRequest request) {
		return "redirect:/indexGame";
	}
	
	/**
	 * Show all Gamestats entities by Game
	 * 
	 */
	@RequestMapping("/listGameGamestatses")
	public ModelAndView listGameGamestatses(@RequestParam Integer gameIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("game", gameDAO.findGameByPrimaryKey(gameIdKey));
		mav.setViewName("game/gamestatses/listGamestatses.jsp");

		return mav;
	}
	/**
	 * Create a new Gamestats entity
	 * 
	 */
	@RequestMapping("/newGameGamestatses")
	public ModelAndView newGameGamestatses(HttpServletRequest request, @RequestParam Integer game_gameId) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("game_gameId", game_gameId);
		mav.addObject("gamestats", new Gamestats());
		mav.addObject("newFlag", true);
		mav.setViewName("game/gamestatses/editGamestatses.jsp");
		mav.addObject("user",sessionCache.getUser4Session(request));

		return mav;
	}
	/**
	 * Save an existing Gamestats entity
	 * 
	 */
	@RequestMapping("/saveGameGamestatses")
	public ModelAndView saveGameGamestatses(HttpServletRequest request, @RequestParam Integer game_gameId, @ModelAttribute Gamestats gamestatses, @RequestParam Integer sportStatTypeId, @RequestParam Integer teamplayerId) {
		Game parent_game = gameService.saveGameGamestatses(game_gameId, gamestatses, sportStatTypeId, teamplayerId);
		ModelAndView mav = new ModelAndView();
		mav.addObject("game_gameId", game_gameId);
		mav.addObject("game", parent_game);
		return editGame(request, game_gameId);
	}
	/**
	 * Edit an existing Gamestats entity
	 * 
	 */
	@RequestMapping("/editGameGamestatses")
	public ModelAndView editGameGamestatses(HttpServletRequest request, @RequestParam Integer game_gameId, @RequestParam Integer gamestatses_gameStatsId) {
		Gamestats gamestats = gamestatsDAO.findGamestatsByPrimaryKey(gamestatses_gameStatsId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("game_gameId", game_gameId);
		mav.addObject("gamestats", gamestats);
		mav.setViewName("game/gamestatses/editGamestatses.jsp");
		mav.addObject("user",sessionCache.getUser4Session(request));

		return mav;
	}
	/**
	 * Delete an existing Gamestats entity
	 * 
	 */
	@RequestMapping("/deleteGameGamestatses")
	public ModelAndView deleteGameGamestatses(HttpServletRequest request, @RequestParam Integer game_gameId, @RequestParam Integer related_gamestatses_gameStatsId) {
		ModelAndView mav = new ModelAndView();
		Game game = gameService.deleteGameGamestatses(game_gameId, related_gamestatses_gameStatsId);
		mav.addObject("game_gameId", game_gameId);
		mav.addObject("game", game);
		return editGame(request, game_gameId);
	}

	/**
	 * Select the child Gamestats entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteGameGamestatses")
	public ModelAndView confirmDeleteGameGamestatses(HttpServletRequest request, @RequestParam Integer game_gameId, @RequestParam Integer related_gamestatses_gameStatsId) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("gamestats", gamestatsDAO.findGamestatsByPrimaryKey(related_gamestatses_gameStatsId));
		mav.addObject("game_gameId", game_gameId);
		mav.setViewName("game/gamestatses/deleteGamestatses.jsp");
		mav.addObject("user",sessionCache.getUser4Session(request));
		return mav;
	}

	
	// Add Edit Delete Confirm Save
	/**  **************************************  Add Edit Delete Confirm Save *********************************************
	 * Create a new Game entity
	 * 
	 */
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/newGame")
	public ModelAndView newGame(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		Game game = new Game();
		game.setActiveYn(1);
		mav.addObject("game", game);
		mav.addObject("newFlag", true);
		Integer startResult= -1;
		Tswacct tswacct = sessionCache.getTswacct(request);

		mav.addObject("resources", resourceService.findAllResources4tsw(tswacct, startResult , defaultMaxRows));
		mav.setViewName("game/editGame.jsp");
		mav.addObject("user",sessionCache.getUser4Session(request));
		return mav;
	}

	/**
	 * Edit an existing Game entity
	 * 
	 */
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/editGame")
	public ModelAndView editGame(HttpServletRequest request, @RequestParam Integer gameIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("game", gameService.findGameByPrimaryKey(gameIdKey));
		Integer startResult= -1;
		Tswacct tswacct = sessionCache.getTswacct(request);

		mav.addObject("resources", resourceService.findAllResources4tsw(tswacct, startResult , defaultMaxRows));
		mav.setViewName("game/editGame.jsp");
		mav.addObject("user",sessionCache.getUser4Session(request));
		return mav;
	}
	
	/**
	 * Delete an existing Game entity
	 * 
	 */
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/deleteGame")
	public String deleteGame(HttpServletRequest request, @RequestParam Integer gameIdKey) {
		Game game = gameService.findGameByPrimaryKey(gameIdKey);
		gameService.deleteGame(game);
		return "forward:/indexGame";
	}

	/**
	 * Select the Game entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/confirmDeleteGame")
	public ModelAndView confirmDeleteGame(HttpServletRequest request, @RequestParam Integer gameIdKey) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("game", gameService.findGameByPrimaryKey(gameIdKey));
		mav.setViewName("game/deleteGame.jsp");
		mav.addObject("user",sessionCache.getUser4Session(request));
		return mav;
	}
	
	/**
	 * Save an existing Game entity
	 * 
	 */
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/saveGame")
	public String saveGame(HttpServletRequest request, @ModelAttribute Game game, @RequestParam Integer selected_id8) {
		gameService.saveGame(sessionCache.getTswacct(request), game, selected_id8);
		return "forward:/indexGame";
	}

}