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

import tsw.domain.fcEvent;

import tsw.service.fcEventService;

/**
 * Spring MVC controller that handles CRUD requests for fcEvent entities
 * 
 */

//TODO: [assignedTo] (fcEvent-Med) Implement full capability of FullCalendar, including filters, viewing day, week, and Date/Time input save

@Controller("fcEventController")
public class fcEventController {
    
	SessionConfigCache sessionCache = UsersController.getSessionCache();

	/**
	 * Service injected by Spring that provides CRUD operations for fcEvent entities
	 * 
	 */
	@Autowired
	private fcEventService fcEventService;


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
	@RequestMapping("/fcEventController/binary.action")
	public ModelAndView streamBinary(@ModelAttribute HttpServletRequest request, @ModelAttribute HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("streamedBinaryContentView");
		return mav;

	}



	// List Search
	/**  *************************************  List Search  *************************************************
	 * Show all fcEvent entities
	 * 
	 */
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/indexfcEvent")
	public ModelAndView listfcEvents(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("fcEvents", fcEventService.loadfcEvents4tsw(sessionCache.getTswacct(request)));
		mav.setViewName("fcEvent/listfcEvents.jsp");
		mav.addObject("resultsPerPage", sessionCache.getResultsPerPage(request));
		mav.addObject("user",sessionCache.getUser4Session(request));
		return mav;
	}
	
	/**
	 * Entry point to show all fcEvent entities
	 * 
	 */
	public String indexfcEvent(HttpServletRequest request) {
		return "redirect:/indexfcEvent";
	}


	// Add Edit Delete Confirm Save
	/**  **************************************  Add Edit Delete Confirm Save *********************************************
	 * Create a new fcEvent entity
	 * 
	 */
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/newfcEvent")
	public ModelAndView newfcEvent(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("fcEvent", new fcEvent());
		mav.addObject("newFlag", true);
		mav.setViewName("fcEvent/editfcEvent.jsp");
		mav.addObject("user",sessionCache.getUser4Session(request));
		return mav;
	}

	/**
	 * Edit an existing fcEvent entity
	 * 
	 */
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/editfcEvent")
	public ModelAndView editfcEvent(HttpServletRequest request, @RequestParam Integer idKey) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("fcEvent", fcEventService.findfcEventByPrimaryKey(idKey));
		mav.setViewName("fcEvent/editfcEvent.jsp");
		mav.addObject("user",sessionCache.getUser4Session(request));
		return mav;
	}

	/**
	 * Delete an existing fcEvent entity
	 * 
	 */
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/deletefcEvent")
	public String deletefcEvent(HttpServletRequest request, @RequestParam Integer idKey) {
		fcEvent fcEvent = fcEventService.findfcEventByPrimaryKey(idKey);
		fcEventService.deletefcEvent(fcEvent);
		return "forward:/indexfcEvent";
	}
	
	/**
	 * Select the fcEvent entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/confirmDeletefcEvent")
	public ModelAndView confirmDeletefcEvent(HttpServletRequest request, @RequestParam Integer idKey) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("fcEvent", fcEventService.findfcEventByPrimaryKey(idKey));
		mav.setViewName("fcEvent/deletefcEvent.jsp");
		mav.addObject("user",sessionCache.getUser4Session(request));
		return mav;
	}

	/**
	 * Save an existing fcEvent entity
	 * 
	 */
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/savefcEvent")
	public String savefcEvent(HttpServletRequest request, @ModelAttribute fcEvent fcEvent) {
		fcEventService.savefcEvent(fcEvent);
		return "forward:/indexfcEvent";
	}
	
}