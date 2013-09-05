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

import tsw.dao.ProgramDAO;
import tsw.dao.SportDAO;
import tsw.dao.SportpositionDAO;
import tsw.dao.SportstattypeDAO;

import tsw.domain.Program;
import tsw.domain.Sport;
import tsw.domain.Sportposition;
import tsw.domain.Sportstattype;

import tsw.service.SportService;

/**
 * Spring MVC controller that handles CRUD requests for Sport entities
 * 
 */

@Controller("SportController")
public class SportController {
    
	SessionConfigCache sessionCache = UsersController.getSessionCache();
	
	/**
	 * DAO injected by Spring that manages Program entities
	 * 
	 */
	@Autowired
	private ProgramDAO programDAO;

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
	 * DAO injected by Spring that manages Sportstattype entities
	 * 
	 */
	@Autowired
	private SportstattypeDAO sportstattypeDAO;

	/**
	 * Service injected by Spring that provides CRUD operations for Sport entities
	 * 
	 */
	@Autowired
	private SportService sportService;

	/**
	 * Delete an existing Program entity
	 * 
	 */
	@RequestMapping("/deleteSportPrograms")
	public ModelAndView deleteSportPrograms(@RequestParam Integer sport_sportId, @RequestParam Integer related_programs_programId) {
		ModelAndView mav = new ModelAndView();

		Sport sport = sportService.deleteSportPrograms(sport_sportId, related_programs_programId);

		mav.addObject("sport_sportId", sport_sportId);
		mav.addObject("sport", sport);
		mav.setViewName("sport/viewSport.jsp");

		return mav;
	}

	/**
	 * Delete an existing Sportposition entity
	 * 
	 */
	@RequestMapping("/deleteSportSportpositions")
	public ModelAndView deleteSportSportpositions(@RequestParam Integer sport_sportId, @RequestParam Integer related_sportpositions_sportPositionId) {
		ModelAndView mav = new ModelAndView();

		Sport sport = sportService.deleteSportSportpositions(sport_sportId, related_sportpositions_sportPositionId);

		mav.addObject("sport_sportId", sport_sportId);
		mav.addObject("sport", sport);
		mav.setViewName("sport/viewSport.jsp");

		return mav;
	}

	/**
	 */
	@RequestMapping("/sportController/binary.action")
	public ModelAndView streamBinary(@ModelAttribute HttpServletRequest request, @ModelAttribute HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("streamedBinaryContentView");
		return mav;

	}

	/**
	 * Select an existing Sport entity
	 * 
	 */
	@RequestMapping("/selectSport")
	public ModelAndView selectSport(@RequestParam Integer sportIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("sport", sportDAO.findSportByPrimaryKey(sportIdKey));
		mav.setViewName("sport/viewSport.jsp");

		return mav;
	}

	/**
	 * Edit an existing Program entity
	 * 
	 */
	@RequestMapping("/editSportPrograms")
	public ModelAndView editSportPrograms(@RequestParam Integer sport_sportId, @RequestParam Integer programs_programId) {
		Program program = programDAO.findProgramByPrimaryKey(programs_programId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("sport_sportId", sport_sportId);
		mav.addObject("program", program);
		mav.setViewName("sport/programs/editPrograms.jsp");

		return mav;
	}

	/**
	 * View an existing Program entity
	 * 
	 */
	@RequestMapping("/selectSportPrograms")
	public ModelAndView selectSportPrograms(@RequestParam Integer sport_sportId, @RequestParam Integer programs_programId) {
		Program program = programDAO.findProgramByPrimaryKey(programs_programId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("sport_sportId", sport_sportId);
		mav.addObject("program", program);
		mav.setViewName("sport/programs/viewPrograms.jsp");

		return mav;
	}

	/**
	 * Create a new Sport entity
	 * 
	 */
	@RequestMapping("/newSport")
	public ModelAndView newSport() {
		ModelAndView mav = new ModelAndView();

		mav.addObject("sport", new Sport());
		mav.addObject("newFlag", true);
		mav.setViewName("sport/editSport.jsp");

		return mav;
	}

	/**
	 * Create a new Sportposition entity
	 * 
	 */
	@RequestMapping("/newSportSportpositions")
	public ModelAndView newSportSportpositions(@RequestParam Integer sport_sportId) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("sport_sportId", sport_sportId);
		mav.addObject("sportposition", new Sportposition());
		mav.addObject("newFlag", true);
		mav.setViewName("sport/sportpositions/editSportpositions.jsp");

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
	 * Delete an existing Sport entity
	 * 
	 */
	@RequestMapping("/deleteSport")
	public String deleteSport(@RequestParam Integer sportIdKey) {
		Sport sport = sportDAO.findSportByPrimaryKey(sportIdKey);
		sportService.deleteSport(sport);
		return "forward:/indexSport";
	}

	/**
	 * Create a new Program entity
	 * 
	 */
	@RequestMapping("/newSportPrograms")
	public ModelAndView newSportPrograms(@RequestParam Integer sport_sportId) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("sport_sportId", sport_sportId);
		mav.addObject("program", new Program());
		mav.addObject("newFlag", true);
		mav.setViewName("sport/programs/editPrograms.jsp");

		return mav;
	}

	/**
	 * Show all Sport entities
	 * 
	 */
	@RequestMapping("/indexSport")
	public ModelAndView listSports() {
		ModelAndView mav = new ModelAndView();

		mav.addObject("sports", sportService.loadSports());

		mav.setViewName("sport/listSports.jsp");

		return mav;
	}

	/**
	 * Edit an existing Sportstattype entity
	 * 
	 */
	@RequestMapping("/editSportSportstattypes")
	public ModelAndView editSportSportstattypes(@RequestParam Integer sport_sportId, @RequestParam Integer sportstattypes_sportStatTypeId) {
		Sportstattype sportstattype = sportstattypeDAO.findSportstattypeByPrimaryKey(sportstattypes_sportStatTypeId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("sport_sportId", sport_sportId);
		mav.addObject("sportstattype", sportstattype);
		mav.setViewName("sport/sportstattypes/editSportstattypes.jsp");

		return mav;
	}

	/**
	 * View an existing Sportposition entity
	 * 
	 */
	@RequestMapping("/selectSportSportpositions")
	public ModelAndView selectSportSportpositions(@RequestParam Integer sport_sportId, @RequestParam Integer sportpositions_sportPositionId) {
		Sportposition sportposition = sportpositionDAO.findSportpositionByPrimaryKey(sportpositions_sportPositionId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("sport_sportId", sport_sportId);
		mav.addObject("sportposition", sportposition);
		mav.setViewName("sport/sportpositions/viewSportpositions.jsp");

		return mav;
	}

	/**
	 * View an existing Sportstattype entity
	 * 
	 */
	@RequestMapping("/selectSportSportstattypes")
	public ModelAndView selectSportSportstattypes(@RequestParam Integer sport_sportId, @RequestParam Integer sportstattypes_sportStatTypeId) {
		Sportstattype sportstattype = sportstattypeDAO.findSportstattypeByPrimaryKey(sportstattypes_sportStatTypeId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("sport_sportId", sport_sportId);
		mav.addObject("sportstattype", sportstattype);
		mav.setViewName("sport/sportstattypes/viewSportstattypes.jsp");

		return mav;
	}

	/**
	 * Create a new Sportstattype entity
	 * 
	 */
	@RequestMapping("/newSportSportstattypes")
	public ModelAndView newSportSportstattypes(@RequestParam Integer sport_sportId) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("sport_sportId", sport_sportId);
		mav.addObject("sportstattype", new Sportstattype());
		mav.addObject("newFlag", true);
		mav.setViewName("sport/sportstattypes/editSportstattypes.jsp");

		return mav;
	}

	/**
	 * Save an existing Sportposition entity
	 * 
	 */
	@RequestMapping("/saveSportSportpositions")
	public ModelAndView saveSportSportpositions(@RequestParam Integer sport_sportId, @ModelAttribute Sportposition sportpositions) {
		Sport parent_sport = sportService.saveSportSportpositions(sport_sportId, sportpositions);

		ModelAndView mav = new ModelAndView();
		mav.addObject("sport_sportId", sport_sportId);
		mav.addObject("sport", parent_sport);
		mav.setViewName("sport/viewSport.jsp");

		return mav;
	}

	/**
	 * Delete an existing Sportstattype entity
	 * 
	 */
	@RequestMapping("/deleteSportSportstattypes")
	public ModelAndView deleteSportSportstattypes(@RequestParam Integer sport_sportId, @RequestParam Integer related_sportstattypes_sportStatTypeId) {
		ModelAndView mav = new ModelAndView();

		Sport sport = sportService.deleteSportSportstattypes(sport_sportId, related_sportstattypes_sportStatTypeId);

		mav.addObject("sport_sportId", sport_sportId);
		mav.addObject("sport", sport);
		mav.setViewName("sport/viewSport.jsp");

		return mav;
	}

	/**
	 * Save an existing Program entity
	 * 
	 */
	@RequestMapping("/saveSportPrograms")
	public ModelAndView saveSportPrograms(@RequestParam Integer sport_sportId, @ModelAttribute Program programs) {
		Sport parent_sport = sportService.saveSportPrograms(sport_sportId, programs);

		ModelAndView mav = new ModelAndView();
		mav.addObject("sport_sportId", sport_sportId);
		mav.addObject("sport", parent_sport);
		mav.setViewName("sport/viewSport.jsp");

		return mav;
	}

	/**
	 * Select the child Program entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteSportPrograms")
	public ModelAndView confirmDeleteSportPrograms(@RequestParam Integer sport_sportId, @RequestParam Integer related_programs_programId) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("program", programDAO.findProgramByPrimaryKey(related_programs_programId));
		mav.addObject("sport_sportId", sport_sportId);
		mav.setViewName("sport/programs/deletePrograms.jsp");

		return mav;
	}

	/**
	 * Edit an existing Sport entity
	 * 
	 */
	@RequestMapping("/editSport")
	public ModelAndView editSport(@RequestParam Integer sportIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("sport", sportDAO.findSportByPrimaryKey(sportIdKey));
		mav.setViewName("sport/editSport.jsp");

		return mav;
	}

	/**
	 * Save an existing Sportstattype entity
	 * 
	 */
	@RequestMapping("/saveSportSportstattypes")
	public ModelAndView saveSportSportstattypes(@RequestParam Integer sport_sportId, @ModelAttribute Sportstattype sportstattypes) {
		Sport parent_sport = sportService.saveSportSportstattypes(sport_sportId, sportstattypes);

		ModelAndView mav = new ModelAndView();
		mav.addObject("sport_sportId", sport_sportId);
		mav.addObject("sport", parent_sport);
		mav.setViewName("sport/viewSport.jsp");

		return mav;
	}

	/**
	 * Select the Sport entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteSport")
	public ModelAndView confirmDeleteSport(@RequestParam Integer sportIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("sport", sportDAO.findSportByPrimaryKey(sportIdKey));
		mav.setViewName("sport/deleteSport.jsp");

		return mav;
	}

	/**
	 * Entry point to show all Sport entities
	 * 
	 */
	public String indexSport() {
		return "redirect:/indexSport";
	}

	/**
	 * Show all Program entities by Sport
	 * 
	 */
	@RequestMapping("/listSportPrograms")
	public ModelAndView listSportPrograms(@RequestParam Integer sportIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("sport", sportDAO.findSportByPrimaryKey(sportIdKey));
		mav.setViewName("sport/programs/listPrograms.jsp");

		return mav;
	}
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/searchSportFrom")
	public ModelAndView searchSportFrom(HttpServletRequest request, @RequestParam int indexFrom) {
		ModelAndView mav = new ModelAndView();
		Integer startResult=0;
		Integer maxRows=-1;
		mav.addObject("sports", sportService.findAllSports(startResult, maxRows));
		mav.addObject("searchFlag", true);
		mav.addObject("indexFrom", indexFrom);
//		mav.addObject("indexCount", levelService.getLevelCount4tsw(sessionCache.getTswacct(request)));
//		mav.addObject("resultsPerPage", sessionCache.getResultsPerPage(request));
		mav.addObject("user",sessionCache.getUser4Session(request));
		mav.setViewName("sport/searchSport.jsp");
		return mav;
	}	
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/searchSport")
	public ModelAndView searchSport(HttpServletRequest request) {
		return searchSportFrom(request, 0);
	}
	/**
	 * Show all Sportstattype entities by Sport
	 * 
	 */
	@RequestMapping("/listSportSportstattypes")
	public ModelAndView listSportSportstattypes(@RequestParam Integer sportIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("sport", sportDAO.findSportByPrimaryKey(sportIdKey));
		mav.setViewName("sport/sportstattypes/listSportstattypes.jsp");

		return mav;
	}

	/**
	 * Select the child Sportstattype entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteSportSportstattypes")
	public ModelAndView confirmDeleteSportSportstattypes(@RequestParam Integer sport_sportId, @RequestParam Integer related_sportstattypes_sportStatTypeId) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("sportstattype", sportstattypeDAO.findSportstattypeByPrimaryKey(related_sportstattypes_sportStatTypeId));
		mav.addObject("sport_sportId", sport_sportId);
		mav.setViewName("sport/sportstattypes/deleteSportstattypes.jsp");

		return mav;
	}

	/**
	 * Select the child Sportposition entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteSportSportpositions")
	public ModelAndView confirmDeleteSportSportpositions(@RequestParam Integer sport_sportId, @RequestParam Integer related_sportpositions_sportPositionId) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("sportposition", sportpositionDAO.findSportpositionByPrimaryKey(related_sportpositions_sportPositionId));
		mav.addObject("sport_sportId", sport_sportId);
		mav.setViewName("sport/sportpositions/deleteSportpositions.jsp");

		return mav;
	}

	/**
	 * Show all Sportposition entities by Sport
	 * 
	 */
	@RequestMapping("/listSportSportpositions")
	public ModelAndView listSportSportpositions(@RequestParam Integer sportIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("sport", sportDAO.findSportByPrimaryKey(sportIdKey));
		mav.setViewName("sport/sportpositions/listSportpositions.jsp");

		return mav;
	}

	/**
	 * Save an existing Sport entity
	 * 
	 */
	@RequestMapping("/saveSport")
	public String saveSport(@ModelAttribute Sport sport) {
		sportService.saveSport(sport);
		return "forward:/indexSport";
	}

	/**
	 * Edit an existing Sportposition entity
	 * 
	 */
	@RequestMapping("/editSportSportpositions")
	public ModelAndView editSportSportpositions(@RequestParam Integer sport_sportId, @RequestParam Integer sportpositions_sportPositionId) {
		Sportposition sportposition = sportpositionDAO.findSportpositionByPrimaryKey(sportpositions_sportPositionId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("sport_sportId", sport_sportId);
		mav.addObject("sportposition", sportposition);
		mav.setViewName("sport/sportpositions/editSportpositions.jsp");

		return mav;
	}
}