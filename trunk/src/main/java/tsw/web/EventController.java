package tsw.web;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.joda.time.MutableDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.servlet.ModelAndView;

import tsw.domain.Event;
import tsw.domain.Tswacct;

import tsw.service.EventService;
import tsw.service.PriceService;
import tsw.service.ResourceService;

/**
 * Spring MVC controller that handles CRUD requests for Event entities
 * 
 */
	// TODO: [assignedTo] (Event-Med) Implement the "Event Quick Entry" wizard "SAVE" capability 

	// TODO: [Tim] (Event-Med) Implement "Define Patterns" for automating the scheduling process 
	//        (Tim will do the initial implementation)

@Controller("EventController")
public class EventController {

	static int defaultMaxRows = 10;   
	
	SessionConfigCache sessionCache = UsersController.getSessionCache();
	
	/**
	 * Service injected by Spring that provides CRUD operations for Event entities
	 * 
	 */
	@Autowired
	private EventService eventService;
	
	@Autowired
	private ResourceService resourceService;

	@Autowired
	private PriceService priceService;
	
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
	 * 
	 */	
	@RequestMapping("/eventController/binary.action")
	public ModelAndView streamBinary(@ModelAttribute HttpServletRequest request, @ModelAttribute HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("streamedBinaryContentView");
		return mav;

	}

	// List Search
	/**  *************************************  List Search  *************************************************
	 * Show all Event entities
	 * 
	 */
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/indexEvent")
	public ModelAndView listEvents(HttpServletRequest request) {
		MutableDateTime dt = MutableDateTime.now();
		dt.setDayOfMonth(1);
		dt.addDays(-1);
		Calendar afterDate = dt.toGregorianCalendar();
		return listEventsFrom(request, sessionCache.getTswacct(request).getDefaultResourceId(),afterDate,0);
	}
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/indexEventFrom")
	public ModelAndView listEventsFrom(HttpServletRequest request, @RequestParam Integer resource_resourceId, @RequestParam Calendar afterDate, @RequestParam int indexFrom) {
		ModelAndView mav = new ModelAndView();
		if(resource_resourceId==null){
			resource_resourceId = sessionCache.getTswacct(request).getDefaultResourceId();
		}
		mav.addObject("res", resourceService.findResourceByPrimaryKey(resource_resourceId));
//		mav.addObject("events", eventService.findAllEvents4tsw(-1, defaultMaxRows, sessionCache.getTswacct(request).getTswAcctId()));
		mav.addObject("events", eventService.loadEventsForResource(resource_resourceId, afterDate, indexFrom));
		mav.addObject("indexFrom", indexFrom);
//		mav.addObject("indexCount", eventService.getEventCount(resource_resourceId, afterDate));
		mav.addObject("indexCount", 0);
		mav.addObject("resources", sessionCache.getTswacct(request).getResources());
		mav.addObject("resultsPerPage", sessionCache.getResultsPerPage(request));
		mav.addObject("user",sessionCache.getUser4Session(request));
		mav.setViewName("event/listEvents.jsp");
		return mav;
	}

	/** 
	 * Entry point to show all Event entities
	 * 
	 */
	public String indexEvent(HttpServletRequest request) {
		return "redirect:/indexEvent";
	}
	
	// Add Edit Delete Confirm Save
	/**  **************************************  Add Edit Delete Confirm Save *********************************************
	 * Create a new Event entity
	 * 
	 */
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/newEvent")
	public ModelAndView newEvent(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("event", new Event());
		mav.addObject("newFlag", true);
		Integer startResult= -1;
		Tswacct tswacct = sessionCache.getTswacct(request);
		mav.addObject("prices", priceService.findAllPrices4tsw(tswacct, startResult , defaultMaxRows));
		mav.addObject("resources", resourceService.findAllResources4tsw(tswacct, startResult , defaultMaxRows));
		mav.setViewName("event/editEvent.jsp");
		mav.addObject("user",sessionCache.getUser4Session(request));
		return mav;
	}

	/**
	 * Edit an existing Event entity
	 * 
	 */
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/editEvent")
	public ModelAndView editEvent(HttpServletRequest request, @RequestParam Integer eventIdKey) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("event", eventService.findEventByPrimaryKey(eventIdKey));
		Integer startResult= -1;
		Tswacct tswacct = sessionCache.getTswacct(request);
		mav.addObject("prices", priceService.findAllPrices4tsw(tswacct, startResult , defaultMaxRows));
		mav.addObject("resources", resourceService.findAllResources4tsw(tswacct, startResult , defaultMaxRows));
		mav.setViewName("event/editEvent.jsp");
		mav.addObject("user",sessionCache.getUser4Session(request));
		return mav;
	}
	
	/**
	 * Delete an existing Event entity
	 * 
	 */
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/deleteEvent")
	public String deleteEvent(HttpServletRequest request, @RequestParam Integer eventIdKey) {
		Event event = eventService.findEventByPrimaryKey(eventIdKey);
		eventService.deleteEvent(event);
		return "forward:/indexEvent";
	}

	/**
	 * Select the Event entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/confirmDeleteEvent")
	public ModelAndView confirmDeleteEvent(HttpServletRequest request, @RequestParam Integer eventIdKey) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("event", eventService.findEventByPrimaryKey(eventIdKey));
		mav.setViewName("event/deleteEvent.jsp");
		mav.addObject("user",sessionCache.getUser4Session(request));
		return mav;
	}
	
	/**
	 * Save an existing Event entity
	 * 
	 */
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/saveEvent")
	public String saveEvent(HttpServletRequest request, @ModelAttribute Event event, @RequestParam Integer gameId, @RequestParam Integer selected_id4, @RequestParam Integer programId, @RequestParam Integer selected_id8, @RequestParam Integer selected_id11) {
		eventService.saveEvent(event,sessionCache.getTswacct(request), gameId, selected_id4, programId, selected_id8, selected_id11);
		return "forward:/scheduling?resource_resourceId="+sessionCache.getTswacct(request).getDefaultResourceId()+"&afterDate=&beforeDate=&";
	}

}