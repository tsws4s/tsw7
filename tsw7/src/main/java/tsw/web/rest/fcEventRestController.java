package tsw.web.rest;

import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.joda.time.DateTime;
import org.joda.time.MutableDateTime;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.WebDataBinder;

import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import tsw.dao.fcEventDAO;

import tsw.domain.Resource;
import tsw.domain.Tswacct;
import tsw.domain.fcEvent;

import tsw.service.fcEventService;
import tsw.web.SessionConfigCache;
import tsw.web.UsersController;

/**
 * Spring Rest controller that handles CRUD requests for fcEvent entities
 * 
 */

@Controller("fcEventRestController")
public class fcEventRestController {
	
	int defaultMaxRows = UsersController.getDefaultMaxRows();
   
	SessionConfigCache sessionCache = UsersController.getSessionCache();

	/**
	 * DAO injected by Spring that manages fcEvent entities
	 * 
	 */
	@Autowired
	private fcEventDAO fcEventDAO;
	
	/**
	 * Service injected by Spring that provides CRUD operations for fcEvent entities
	 * 
	 */
	@Autowired
	private fcEventService fcEventService;

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
	 * Select an existing fcEvent entity
	 * 
	 */
	@RequestMapping(value = "/fcEvent/{fcEvent_id}", method = RequestMethod.GET)
	@ResponseBody
	public fcEvent loadfcEvent(@PathVariable Integer fcEvent_id) {
		return fcEventDAO.findfcEventByPrimaryKey(fcEvent_id);
	}
	
	@RequestMapping(value = "/fcEvent/{resource_id}/{afterDate}/{fcEvent_id}", method = RequestMethod.GET)
	@ResponseBody
	public List<fcEvent> loadfcEvent(HttpServletRequest request, @RequestParam Integer resourceId, @RequestParam String afterDateStr, @RequestParam String beforeDateStr) {
		if(resourceId==null){
			resourceId=sessionCache.getTswacct(request).getDefaultResourceId();
		}
		Calendar afterDate = null;
		if(afterDateStr==null){
			MutableDateTime dt = MutableDateTime.now();
			dt.setDayOfMonth(1);
			dt.addDays(-1);
			afterDate = dt.toGregorianCalendar();			
		} else {
			DateTime date = new DateTime(afterDateStr);
			afterDate = date.toGregorianCalendar();											
		}
		Calendar beforeDate = null;
		if(beforeDateStr==null){
			MutableDateTime dt = MutableDateTime.now();
			dt.addDays(1);
			beforeDate = dt.toGregorianCalendar();				
		} else {
			DateTime date = new DateTime(beforeDateStr);
			beforeDate = date.toGregorianCalendar();							
		}
		return new java.util.ArrayList<fcEvent>(fcEventService.loadfcEvents(resourceId, afterDate, beforeDate));
	}	
	
	/**
	 * Delete an existing fcEvent entity
	 * 
	 */
	@RequestMapping(value = "/fcEvent/{fcEvent_id}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deletefcEvent(@PathVariable Integer fcEvent_id) {
		fcEvent fcEvent = fcEventDAO.findfcEventByPrimaryKey(fcEvent_id);
		fcEventService.deletefcEvent(fcEvent);
	}

	/**
	 * Create a new fcEvent entity
	 * 
	 */
	@RequestMapping(value = "/fcEvent", method = RequestMethod.POST)
	@ResponseBody
	public fcEvent newfcEvent(@RequestBody fcEvent fcEvent) {
		fcEventService.savefcEvent(fcEvent);
		return fcEventDAO.findfcEventByPrimaryKey(fcEvent.getId());
	}

	/**
	 * Save an existing fcEvent entity
	 * 
	 */
	@RequestMapping(value = "/fcEvent", method = RequestMethod.PUT)
	@ResponseBody
	public fcEvent savefcEvent(@RequestBody fcEvent fcEvent) {
		fcEventService.savefcEvent(fcEvent);
		return fcEventDAO.findfcEventByPrimaryKey(fcEvent.getId());
	}

	/**
	 * Show all fcEvent entities
	 * 
	 */
	@RequestMapping(value = "/fcEvent", method = RequestMethod.GET)
	@ResponseBody
	public List<fcEvent> listfcEvents(HttpServletRequest request) {
		Tswacct tswacct = sessionCache.getTswacct(request);
		Resource res = sessionCache.getEvents4Resource(request);
		List<fcEvent> fcEvents = new java.util.ArrayList<fcEvent>(fcEventService.findAllfcEvents4tswResource(tswacct, res, -1, defaultMaxRows));
		return fcEvents;
	}
	
	@RequestMapping(value = "/fcEvent2", method = RequestMethod.GET)
	@ResponseBody
	public List<fcEvent> listfcEvents2(HttpServletRequest request) {
		return new java.util.ArrayList<fcEvent>(fcEventService.loadfcEvents4tsw(sessionCache.getTswacct(request)));
	}
}