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

import tsw.dao.SportDAO;
import tsw.dao.SportstattypeDAO;

import tsw.domain.Sport;
import tsw.domain.Sportstattype;

import tsw.service.SportstattypeService;

/**
 * Spring MVC controller that handles CRUD requests for Sportstattype entities
 * 
 */

@Controller("SportstattypeController")
public class SportstattypeController {

	/**
	 * DAO injected by Spring that manages Sport entities
	 * 
	 */
	@Autowired
	private SportDAO sportDAO;

	/**
	 * DAO injected by Spring that manages Sportstattype entities
	 * 
	 */
	@Autowired
	private SportstattypeDAO sportstattypeDAO;

	/**
	 * Service injected by Spring that provides CRUD operations for Sportstattype entities
	 * 
	 */
	@Autowired
	private SportstattypeService sportstattypeService;

	/**
	 * Create a new Sport entity
	 * 
	 */
	@RequestMapping("/newSportstattypeSport")
	public ModelAndView newSportstattypeSport(@RequestParam Integer sportstattype_sportStatTypeId) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("sportstattype_sportStatTypeId", sportstattype_sportStatTypeId);
		mav.addObject("sport", new Sport());
		mav.addObject("newFlag", true);
		mav.setViewName("sportstattype/sport/editSport.jsp");

		return mav;
	}

	/**
	 * Select the Sportstattype entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteSportstattype")
	public ModelAndView confirmDeleteSportstattype(@RequestParam Integer sportStatTypeIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("sportstattype", sportstattypeDAO.findSportstattypeByPrimaryKey(sportStatTypeIdKey));
		mav.setViewName("sportstattype/deleteSportstattype.jsp");

		return mav;
	}

	/**
	 * Save an existing Sportstattype entity
	 * 
	 */
	@RequestMapping("/saveSportstattype")
	public String saveSportstattype(@ModelAttribute Sportstattype sportstattype) {
		sportstattypeService.saveSportstattype(sportstattype);
		return "forward:/indexSportstattype";
	}

	/**
	 */
	@RequestMapping("/sportstattypeController/binary.action")
	public ModelAndView streamBinary(@ModelAttribute HttpServletRequest request, @ModelAttribute HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("streamedBinaryContentView");
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
	 * Show all Sport entities by Sportstattype
	 * 
	 */
	@RequestMapping("/listSportstattypeSport")
	public ModelAndView listSportstattypeSport(@RequestParam Integer sportStatTypeIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("sportstattype", sportstattypeDAO.findSportstattypeByPrimaryKey(sportStatTypeIdKey));
		mav.setViewName("sportstattype/sport/listSport.jsp");

		return mav;
	}

	/**
	 * Show all Sportstattype entities
	 * 
	 */
	@RequestMapping("/indexSportstattype")
	public ModelAndView listSportstattypes() {
		ModelAndView mav = new ModelAndView();

		mav.addObject("sportstattypes", sportstattypeService.loadSportstattypes());

		mav.setViewName("sportstattype/listSportstattypes.jsp");

		return mav;
	}

	/**
	 * Save an existing Sport entity
	 * 
	 */
	@RequestMapping("/saveSportstattypeSport")
	public ModelAndView saveSportstattypeSport(@RequestParam Integer sportstattype_sportStatTypeId, @ModelAttribute Sport sport) {
		Sportstattype parent_sportstattype = sportstattypeService.saveSportstattypeSport(sportstattype_sportStatTypeId, sport);

		ModelAndView mav = new ModelAndView();
		mav.addObject("sportstattype_sportStatTypeId", sportstattype_sportStatTypeId);
		mav.addObject("sportstattype", parent_sportstattype);
		mav.setViewName("sportstattype/viewSportstattype.jsp");

		return mav;
	}

	/**
	 * View an existing Sport entity
	 * 
	 */
	@RequestMapping("/selectSportstattypeSport")
	public ModelAndView selectSportstattypeSport(@RequestParam Integer sportstattype_sportStatTypeId, @RequestParam Integer sport_sportId) {
		Sport sport = sportDAO.findSportByPrimaryKey(sport_sportId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("sportstattype_sportStatTypeId", sportstattype_sportStatTypeId);
		mav.addObject("sport", sport);
		mav.setViewName("sportstattype/sport/viewSport.jsp");

		return mav;
	}

	/**
	 * Delete an existing Sportstattype entity
	 * 
	 */
	@RequestMapping("/deleteSportstattype")
	public String deleteSportstattype(@RequestParam Integer sportStatTypeIdKey) {
		Sportstattype sportstattype = sportstattypeDAO.findSportstattypeByPrimaryKey(sportStatTypeIdKey);
		sportstattypeService.deleteSportstattype(sportstattype);
		return "forward:/indexSportstattype";
	}

	/**
	 * Entry point to show all Sportstattype entities
	 * 
	 */
	public String indexSportstattype() {
		return "redirect:/indexSportstattype";
	}

	/**
	 * Create a new Sportstattype entity
	 * 
	 */
	@RequestMapping("/newSportstattype")
	public ModelAndView newSportstattype() {
		ModelAndView mav = new ModelAndView();

		mav.addObject("sportstattype", new Sportstattype());
		mav.addObject("newFlag", true);
		mav.setViewName("sportstattype/editSportstattype.jsp");

		return mav;
	}

	/**
	 * Select the child Sport entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteSportstattypeSport")
	public ModelAndView confirmDeleteSportstattypeSport(@RequestParam Integer sportstattype_sportStatTypeId, @RequestParam Integer related_sport_sportId) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("sport", sportDAO.findSportByPrimaryKey(related_sport_sportId));
		mav.addObject("sportstattype_sportStatTypeId", sportstattype_sportStatTypeId);
		mav.setViewName("sportstattype/sport/deleteSport.jsp");

		return mav;
	}

	/**
	 * Edit an existing Sport entity
	 * 
	 */
	@RequestMapping("/editSportstattypeSport")
	public ModelAndView editSportstattypeSport(@RequestParam Integer sportstattype_sportStatTypeId, @RequestParam Integer sport_sportId) {
		Sport sport = sportDAO.findSportByPrimaryKey(sport_sportId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("sportstattype_sportStatTypeId", sportstattype_sportStatTypeId);
		mav.addObject("sport", sport);
		mav.setViewName("sportstattype/sport/editSport.jsp");

		return mav;
	}

	/**
	 * Select an existing Sportstattype entity
	 * 
	 */
	@RequestMapping("/selectSportstattype")
	public ModelAndView selectSportstattype(@RequestParam Integer sportStatTypeIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("sportstattype", sportstattypeDAO.findSportstattypeByPrimaryKey(sportStatTypeIdKey));
		mav.setViewName("sportstattype/viewSportstattype.jsp");

		return mav;
	}

	/**
	 * Edit an existing Sportstattype entity
	 * 
	 */
	@RequestMapping("/editSportstattype")
	public ModelAndView editSportstattype(@RequestParam Integer sportStatTypeIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("sportstattype", sportstattypeDAO.findSportstattypeByPrimaryKey(sportStatTypeIdKey));
		mav.setViewName("sportstattype/editSportstattype.jsp");

		return mav;
	}

	/**
	 * Delete an existing Sport entity
	 * 
	 */
	@RequestMapping("/deleteSportstattypeSport")
	public ModelAndView deleteSportstattypeSport(@RequestParam Integer sportstattype_sportStatTypeId, @RequestParam Integer related_sport_sportId) {
		ModelAndView mav = new ModelAndView();

		Sportstattype sportstattype = sportstattypeService.deleteSportstattypeSport(sportstattype_sportStatTypeId, related_sport_sportId);

		mav.addObject("sportstattype_sportStatTypeId", sportstattype_sportStatTypeId);
		mav.addObject("sportstattype", sportstattype);
		mav.setViewName("sportstattype/viewSportstattype.jsp");

		return mav;
	}
}