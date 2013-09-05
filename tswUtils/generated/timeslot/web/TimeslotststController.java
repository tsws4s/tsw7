package timeslot.web;

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

import timeslot.dao.TimeslotststDAO;

import timeslot.domain.Timeslotstst;

import timeslot.service.TimeslotststService;

/**
 * Spring MVC controller that handles CRUD requests for Timeslotstst entities
 * 
 */

@Controller("TimeslotststController")
public class TimeslotststController {

	/**
	 * DAO injected by Spring that manages Timeslotstst entities
	 * 
	 */
	@Autowired
	private TimeslotststDAO timeslotststDAO;

	/**
	 * Service injected by Spring that provides CRUD operations for Timeslotstst entities
	 * 
	 */
	@Autowired
	private TimeslotststService timeslotststService;

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
	 * Delete an existing Timeslotstst entity
	 * 
	 */
	@RequestMapping("/deleteTimeslotstst")
	public String deleteTimeslotstst(@RequestParam Integer timeslotIdKey) {
		Timeslotstst timeslotstst = timeslotststDAO.findTimeslotststByPrimaryKey(timeslotIdKey);
		timeslotststService.deleteTimeslotstst(timeslotstst);
		return "forward:/indexTimeslotstst";
	}

	/**
	 * Edit an existing Timeslotstst entity
	 * 
	 */
	@RequestMapping("/editTimeslotstst")
	public ModelAndView editTimeslotstst(@RequestParam Integer timeslotIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("timeslotstst", timeslotststDAO.findTimeslotststByPrimaryKey(timeslotIdKey));
		mav.setViewName("timeslotstst/editTimeslotstst.jsp");

		return mav;
	}

	/**
	 * Save an existing Timeslotstst entity
	 * 
	 */
	@RequestMapping("/saveTimeslotstst")
	public String saveTimeslotstst(@ModelAttribute Timeslotstst timeslotstst) {
		timeslotststService.saveTimeslotstst(timeslotstst);
		return "forward:/indexTimeslotstst";
	}

	/**
	 * Select the Timeslotstst entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteTimeslotstst")
	public ModelAndView confirmDeleteTimeslotstst(@RequestParam Integer timeslotIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("timeslotstst", timeslotststDAO.findTimeslotststByPrimaryKey(timeslotIdKey));
		mav.setViewName("timeslotstst/deleteTimeslotstst.jsp");

		return mav;
	}

	/**
	 * Create a new Timeslotstst entity
	 * 
	 */
	@RequestMapping("/newTimeslotstst")
	public ModelAndView newTimeslotstst() {
		ModelAndView mav = new ModelAndView();

		mav.addObject("timeslotstst", new Timeslotstst());
		mav.addObject("newFlag", true);
		mav.setViewName("timeslotstst/editTimeslotstst.jsp");

		return mav;
	}

	/**
	 * Select an existing Timeslotstst entity
	 * 
	 */
	@RequestMapping("/selectTimeslotstst")
	public ModelAndView selectTimeslotstst(@RequestParam Integer timeslotIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("timeslotstst", timeslotststDAO.findTimeslotststByPrimaryKey(timeslotIdKey));
		mav.setViewName("timeslotstst/viewTimeslotstst.jsp");

		return mav;
	}

	/**
	 */
	@RequestMapping("/timeslotststController/binary.action")
	public ModelAndView streamBinary(@ModelAttribute HttpServletRequest request, @ModelAttribute HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("streamedBinaryContentView");
		return mav;

	}

	/**
	 * Show all Timeslotstst entities
	 * 
	 */
	@RequestMapping("/indexTimeslotstst")
	public ModelAndView listTimeslotststs() {
		ModelAndView mav = new ModelAndView();

		mav.addObject("timeslotststs", timeslotststService.loadTimeslotststs());

		mav.setViewName("timeslotstst/listTimeslotststs.jsp");

		return mav;
	}

	/**
	 * Entry point to show all Timeslotstst entities
	 * 
	 */
	public String indexTimeslotstst() {
		return "redirect:/indexTimeslotstst";
	}
}