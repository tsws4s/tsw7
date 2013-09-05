package tsw.web;

import java.util.Set;

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

import tsw.domain.Participant;
import tsw.domain.Program;

import tsw.service.ParticipantService;
import tsw.service.ProgramService;

/**
 * Spring MVC controller that handles CRUD requests for Participant entities
 * 
 */

@Controller("ParticipantController")
public class ParticipantController {
    
	SessionConfigCache sessionCache = UsersController.getSessionCache();

	/**
	 * Service injected by Spring that provides CRUD operations for Participant entities
	 * 
	 */
	@Autowired
	private ParticipantService participantService;

	@Autowired
	private ProgramService programService;
	
	// Init
	/**  ***************************************  Init  *******************************************************
	 * 	 * Register custom, context-specific property editors
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
	@RequestMapping("/participantController/binary.action")
	public ModelAndView streamBinary(@ModelAttribute HttpServletRequest request, @ModelAttribute HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("streamedBinaryContentView");
		return mav;

	}


	// List Search
	/**  *************************************  List Search  *************************************************
	 * 	 * Show all Participant entities
	 * 
	 */
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/indexParticipantFrom")
	public ModelAndView listParticipantsFrom(HttpServletRequest request, @RequestParam int indexFrom) {
		ModelAndView mav = new ModelAndView();
		Set<Program> pgm = programService.loadPrograms4tsw(sessionCache.getTswacct(request), indexFrom);
		mav.addObject("program", pgm.iterator().next());
		mav.addObject("indexFrom", indexFrom);
		int count = 0;
		if(pgm.iterator().next()!=null && pgm.iterator().next().getParticipants()!=null){
			count = pgm.iterator().next().getParticipants().size();
		}
		mav.addObject("indexCount", count);
		mav.addObject("resultsPerPage", sessionCache.getResultsPerPage(request));
		mav.addObject("user",sessionCache.getUser4Session(request));
		mav.setViewName("participant/listParticipants.jsp");
		return mav;
	}

	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/indexParticipant")
	public ModelAndView listParticipants(HttpServletRequest request) {
		return listParticipantsFrom(request, 0);
	}
	
	/**
	 * Entry point to show all Participant entities
	 * 
	 */
	public String indexParticipant(HttpServletRequest request) {
		return "redirect:/indexParticipant";
	}
	
	// Add Edit Delete Confirm Save
	/**  **************************************  Add Edit Delete Confirm Save *********************************************
	 * 	 * Create a new Participant entity
	 * 
	 */
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/newParticipant")
	public ModelAndView newParticipant(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		Participant part = new Participant();
		part.setActiveYn(1);
		mav.addObject("participant", part);
		mav.addObject("newFlag", true);
		mav.setViewName("participant/editParticipant.jsp");
		mav.addObject("user",sessionCache.getUser4Session(request));
		return mav;
	}

	/**
	 * Edit an existing Participant entity
	 * 
	 */
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/editParticipant")
	public ModelAndView editParticipant(HttpServletRequest request, @RequestParam Integer participantIdKey) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("participant", participantService.findParticipantByPrimaryKey(participantIdKey));
		mav.setViewName("participant/editParticipant.jsp");
		mav.addObject("user",sessionCache.getUser4Session(request));
		return mav;
	}
	
	/**
	 * Delete an existing Participant entity
	 * 
	 */
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/deleteParticipant")
	public String deleteParticipant(HttpServletRequest request, @RequestParam Integer participantIdKey) {
		Participant participant = participantService.findParticipantByPrimaryKey(participantIdKey);
		participantService.deleteParticipant(participant);
		return "forward:/indexParticipant";
	}
	
	/**
	 * Select the Participant entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/confirmDeleteParticipant")
	public ModelAndView confirmDeleteParticipant(HttpServletRequest request, @RequestParam Integer participantIdKey) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("participant", participantService.findParticipantByPrimaryKey(participantIdKey));
		mav.setViewName("participant/deleteParticipant.jsp");
		mav.addObject("user",sessionCache.getUser4Session(request));
		return mav;
	}

	/**
	 * Save an existing Participant entity
	 * 
	 */
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/saveParticipant")
	public String saveParticipant(HttpServletRequest request, @ModelAttribute Participant participant) {
		participantService.saveParticipant(sessionCache.getTswacct(request), participant);
		return "forward:/indexParticipant";
	}

}