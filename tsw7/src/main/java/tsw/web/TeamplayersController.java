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

import tsw.dao.TeamplayersDAO;

import tsw.domain.Teamplayers;

import tsw.service.TeamplayersService;

/**
 * Spring MVC controller that handles CRUD requests for Teamplayers entities
 * 
 */

@Controller("TeamplayersController")
public class TeamplayersController {
    
	SessionConfigCache sessionCache = UsersController.getSessionCache();

	/**
	 * DAO injected by Spring that manages Teamplayers entities
	 * 
	 */
	@Autowired
	private TeamplayersDAO teamplayersDAO;

	/**
	 * Service injected by Spring that provides CRUD operations for Teamplayers entities
	 * 
	 */
	@Autowired
	private TeamplayersService teamplayersService;

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
	@RequestMapping("/teamplayersController/binary.action")
	public ModelAndView streamBinary(@ModelAttribute HttpServletRequest request, @ModelAttribute HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("streamedBinaryContentView");
		return mav;

	}
	
	// List Search
	/**  *************************************  List Search  *************************************************
	 * Show all Teamplayers entities
	 * 
	 */
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/indexTeamplayers")
	public ModelAndView listTeamplayerss(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("teamplayerss", teamplayersService.loadTeamplayerss4tsw(sessionCache.getTswacct(request)));
		mav.setViewName("teamplayers/listTeamplayerss.jsp");
		mav.addObject("resultsPerPage", sessionCache.getResultsPerPage(request));
		mav.addObject("user",sessionCache.getUser4Session(request));
		return mav;
	}
	
	/**
	 * Entry point to show all Teamplayers entities
	 * 
	 */
	public String indexTeamplayers(HttpServletRequest request) {
		return "redirect:/indexTeamplayers";
	}
	
	// Add Edit Delete Confirm Save
	/**  **************************************  Add Edit Delete Confirm Save *********************************************
	 * Create a new Teamplayers entity
	 *  
	 */
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/newTeamplayers")
	public ModelAndView newTeamplayers(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		Teamplayers tmplyr = new Teamplayers();
		tmplyr.setActiveYn(1);
		mav.addObject("teamplayers", tmplyr);
		mav.addObject("newFlag", true);
		mav.setViewName("teamplayers/editTeamplayers.jsp");
		mav.addObject("user",sessionCache.getUser4Session(request));
		return mav;
	}

	/**
	 * Edit an existing Teamplayers entity
	 * 
	 */
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/editTeamplayers")
	public ModelAndView editTeamplayers(HttpServletRequest request, @RequestParam Integer teamPlayersIdKey) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("teamplayers", teamplayersDAO.findTeamplayersByPrimaryKey(teamPlayersIdKey));
		mav.setViewName("teamplayers/editTeamplayers.jsp");
		mav.addObject("user",sessionCache.getUser4Session(request));
		return mav;
	}

	/**
	 * Select the Teamplayers entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/confirmDeleteTeamplayers")
	public ModelAndView confirmDeleteTeamplayers(HttpServletRequest request, @RequestParam Integer teamPlayersIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("teamplayers", teamplayersDAO.findTeamplayersByPrimaryKey(teamPlayersIdKey));
		mav.setViewName("teamplayers/deleteTeamplayers.jsp");
		mav.addObject("user",sessionCache.getUser4Session(request));
		return mav;
	}
	
	/**
	 * Delete an existing Teamplayers entity
	 * 
	 */
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/deleteTeamplayers")
	public String deleteTeamplayers(HttpServletRequest request, @RequestParam Integer teamPlayersIdKey) {
		Teamplayers teamplayers = teamplayersDAO.findTeamplayersByPrimaryKey(teamPlayersIdKey);
		teamplayersService.deleteTeamplayers(teamplayers);
		return "forward:/indexTeamplayers";
	}

	/**
	 * Save an existing Teamplayers entity
	 * 
	 */
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/saveTeamplayers")
	public String saveTeamplayers(HttpServletRequest request, @ModelAttribute Teamplayers teamplayers) {
		teamplayersService.saveTeamplayers(sessionCache.getTswacct(request), teamplayers);
		return "forward:/indexTeamplayers";
	}

}