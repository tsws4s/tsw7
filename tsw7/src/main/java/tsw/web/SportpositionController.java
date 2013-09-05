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

import tsw.dao.SportDAO;
import tsw.dao.SportpositionDAO;

import tsw.domain.Sport;
import tsw.domain.Sportposition;

import tsw.service.SportpositionService;

/**
 * Spring MVC controller that handles CRUD requests for Sportposition entities
 * 
 */

@Controller("SportpositionController")
public class SportpositionController {
    
	SessionConfigCache sessionCache = UsersController.getSessionCache();

	/**
	 * DAO injected by Spring that manages Sport entities
	 * 
	 */
	@Autowired
	private SportDAO sportDAO;

	/**
	 * DAO injected by Spring that manages Sportposition entities
	 * 
	 */
	@Autowired
	private SportpositionDAO sportpositionDAO;

	/**
	 * Service injected by Spring that provides CRUD operations for Sportposition entities
	 * 
	 */
	@Autowired
	private SportpositionService sportpositionService;

	/**
	 * Save an existing Sportposition entity
	 * 
	 */
	@RequestMapping("/saveSportposition")
	public String saveSportposition(@ModelAttribute Sportposition sportposition) {
		sportpositionService.saveSportposition(sportposition);
		return "forward:/indexSportposition";
	}

	/**
	 * Select the child Sport entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteSportpositionSport")
	public ModelAndView confirmDeleteSportpositionSport(@RequestParam Integer sportposition_sportPositionId, @RequestParam Integer related_sport_sportId) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("sport", sportDAO.findSportByPrimaryKey(related_sport_sportId));
		mav.addObject("sportposition_sportPositionId", sportposition_sportPositionId);
		mav.setViewName("sportposition/sport/deleteSport.jsp");

		return mav;
	}

	/**
	 * Edit an existing Sport entity
	 * 
	 */
	@RequestMapping("/editSportpositionSport")
	public ModelAndView editSportpositionSport(@RequestParam Integer sportposition_sportPositionId, @RequestParam Integer sport_sportId) {
		Sport sport = sportDAO.findSportByPrimaryKey(sport_sportId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("sportposition_sportPositionId", sportposition_sportPositionId);
		mav.addObject("sport", sport);
		mav.setViewName("sportposition/sport/editSport.jsp");

		return mav;
	}

	/**
	 * Show all Sportposition entities
	 * 
	 */
	@RequestMapping("/indexSportposition")
	public ModelAndView listSportpositions() {
		ModelAndView mav = new ModelAndView();

		mav.addObject("sportpositions", sportpositionService.loadSportpositions());

		mav.setViewName("sportposition/listSportpositions.jsp");

		return mav;
	}

	/**
	 * Select the Sportposition entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteSportposition")
	public ModelAndView confirmDeleteSportposition(@RequestParam Integer sportPositionIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("sportposition", sportpositionDAO.findSportpositionByPrimaryKey(sportPositionIdKey));
		mav.setViewName("sportposition/deleteSportposition.jsp");

		return mav;
	}

	/**
	 * Show all Sport entities by Sportposition
	 * 
	 */
	@RequestMapping("/listSportpositionSport")
	public ModelAndView listSportpositionSport(@RequestParam Integer sportPositionIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("sportposition", sportpositionDAO.findSportpositionByPrimaryKey(sportPositionIdKey));
		mav.setViewName("sportposition/sport/listSport.jsp");

		return mav;
	}
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/searchSportpositionFrom")
	public ModelAndView searchSportpositionFrom(HttpServletRequest request, @RequestParam int indexFrom, @RequestParam Integer sportIdKey) {
		ModelAndView mav = new ModelAndView();
		Integer startResult=0;
		Integer maxRows=-1;
		mav.addObject("sportpositions", sportpositionService.findAllSportpositions(startResult, maxRows));
		Sport sport = sportDAO.findSportByPrimaryKey(sportIdKey);
		mav.addObject("sport", sport);
		mav.addObject("searchFlag", true);
		mav.addObject("indexFrom", indexFrom);
//		mav.addObject("indexCount", levelService.getLevelCount4tsw(sessionCache.getTswacct(request)));
//		mav.addObject("resultsPerPage", sessionCache.getResultsPerPage(request));
		mav.addObject("user",sessionCache.getUser4Session(request));
		mav.setViewName("sportposition/searchSportposition.jsp");
		return mav;
	}	
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/searchSportposition")
	public ModelAndView searchSportposition(HttpServletRequest request, @RequestParam Integer sportIdKey) {
		return searchSportpositionFrom(request, 0, sportIdKey);
	}
	/**
	 * Create a new Sport entity
	 * 
	 */
	@RequestMapping("/newSportpositionSport")
	public ModelAndView newSportpositionSport(@RequestParam Integer sportposition_sportPositionId) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("sportposition_sportPositionId", sportposition_sportPositionId);
		mav.addObject("sport", new Sport());
		mav.addObject("newFlag", true);
		mav.setViewName("sportposition/sport/editSport.jsp");

		return mav;
	}

	/**
	 * Delete an existing Sportposition entity
	 * 
	 */
	@RequestMapping("/deleteSportposition")
	public String deleteSportposition(@RequestParam Integer sportPositionIdKey) {
		Sportposition sportposition = sportpositionDAO.findSportpositionByPrimaryKey(sportPositionIdKey);
		sportpositionService.deleteSportposition(sportposition);
		return "forward:/indexSportposition";
	}

	/**
	 */
	@RequestMapping("/sportpositionController/binary.action")
	public ModelAndView streamBinary(@ModelAttribute HttpServletRequest request, @ModelAttribute HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("streamedBinaryContentView");
		return mav;

	}

	/**
	 * Delete an existing Sport entity
	 * 
	 */
	@RequestMapping("/deleteSportpositionSport")
	public ModelAndView deleteSportpositionSport(@RequestParam Integer sportposition_sportPositionId, @RequestParam Integer related_sport_sportId) {
		ModelAndView mav = new ModelAndView();

		Sportposition sportposition = sportpositionService.deleteSportpositionSport(sportposition_sportPositionId, related_sport_sportId);

		mav.addObject("sportposition_sportPositionId", sportposition_sportPositionId);
		mav.addObject("sportposition", sportposition);
		mav.setViewName("sportposition/viewSportposition.jsp");

		return mav;
	}

	/**
	 * Edit an existing Sportposition entity
	 * 
	 */
	@RequestMapping("/editSportposition")
	public ModelAndView editSportposition(@RequestParam Integer sportPositionIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("sportposition", sportpositionDAO.findSportpositionByPrimaryKey(sportPositionIdKey));
		mav.setViewName("sportposition/editSportposition.jsp");

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
	 * View an existing Sport entity
	 * 
	 */
	@RequestMapping("/selectSportpositionSport")
	public ModelAndView selectSportpositionSport(@RequestParam Integer sportposition_sportPositionId, @RequestParam Integer sport_sportId) {
		Sport sport = sportDAO.findSportByPrimaryKey(sport_sportId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("sportposition_sportPositionId", sportposition_sportPositionId);
		mav.addObject("sport", sport);
		mav.setViewName("sportposition/sport/viewSport.jsp");

		return mav;
	}

	/**
	 * Select an existing Sportposition entity
	 * 
	 */
	@RequestMapping("/selectSportposition")
	public ModelAndView selectSportposition(@RequestParam Integer sportPositionIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("sportposition", sportpositionDAO.findSportpositionByPrimaryKey(sportPositionIdKey));
		mav.setViewName("sportposition/viewSportposition.jsp");

		return mav;
	}

	/**
	 * Entry point to show all Sportposition entities
	 * 
	 */
	public String indexSportposition() {
		return "redirect:/indexSportposition";
	}

	/**
	 * Save an existing Sport entity
	 * 
	 */
	@RequestMapping("/saveSportpositionSport")
	public ModelAndView saveSportpositionSport(@RequestParam Integer sportposition_sportPositionId, @ModelAttribute Sport sport) {
		Sportposition parent_sportposition = sportpositionService.saveSportpositionSport(sportposition_sportPositionId, sport);

		ModelAndView mav = new ModelAndView();
		mav.addObject("sportposition_sportPositionId", sportposition_sportPositionId);
		mav.addObject("sportposition", parent_sportposition);
		mav.setViewName("sportposition/viewSportposition.jsp");

		return mav;
	}

	/**
	 * Create a new Sportposition entity
	 * 
	 */
	@RequestMapping("/newSportposition")
	public ModelAndView newSportposition() {
		ModelAndView mav = new ModelAndView();

		mav.addObject("sportposition", new Sportposition());
		mav.addObject("newFlag", true);
		mav.setViewName("sportposition/editSportposition.jsp");

		return mav;
	}
}