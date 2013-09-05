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

import tsw.dao.ProgramresourceDAO;
import tsw.domain.Program;
import tsw.domain.Programresource;
import tsw.domain.Tswacct;
import tsw.service.PriceService;
import tsw.service.ProgramService;
import tsw.service.ProgramresourceService;
import tsw.service.ResourceService;

/**
 * Spring MVC controller that handles CRUD requests for Programresource entities
 * 
 */

@Controller("ProgramresourceController")
public class ProgramresourceController {

	static int defaultMaxRows = 10;
	
	SessionConfigCache sessionCache = UsersController.getSessionCache();
	
	/**
	 * Service injected by Spring that provides CRUD operations for Program entities
	 * 
	 */
	@Autowired
	private ProgramService programService;
	
	@Autowired
	private ProgramController pgmController;
	@Autowired
	private ResourceService resourceService;
	@Autowired
	private PriceService priceService;	
	/**
	 * DAO injected by Spring that manages Programresource entities
	 * 
	 */
	@Autowired
	private ProgramresourceDAO programresourceDAO;

	/**
	 * Service injected by Spring that provides CRUD operations for Programresource entities
	 * 
	 */
	@Autowired
	private ProgramresourceService programresourceService;

	/**
	 * Select the Programresource entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteProgramresource")
	public ModelAndView confirmDeleteProgramresource(HttpServletRequest request, @RequestParam Integer programResourceIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("programresource", programresourceDAO.findProgramresourceByPrimaryKey(programResourceIdKey));
		mav.setViewName("programresource/deleteProgramresource.jsp");
		mav.addObject("user",sessionCache.getUser4Session(request));

		return mav;
	}
	
	/**
	 * Delete an existing Programresource entity
	 * 
	 */
	@RequestMapping("/deleteProgramresource")
	public ModelAndView deleteProgramresource(HttpServletRequest request, @RequestParam Integer programResourceIdKey) {
		Programresource programresource = programresourceDAO.findProgramresourceByPrimaryKey(programResourceIdKey);
		programresourceService.deleteProgramresource(programresource);
		return pgmController.editProgram(request, programresource.getProgram().getProgramId(), -1);
	}

	/**
	 * Create a new Programresource entity
	 * 
	 */

	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/newProgramresource")
	public ModelAndView newProgramresource(HttpServletRequest request, @RequestParam Integer program_programId) {
		ModelAndView mav = new ModelAndView();
		Program pgm = programService.findProgramByPrimaryKey(program_programId);
		mav.addObject("program_programId", program_programId);
		mav.addObject("program", pgm);
		Programresource pgmRes = new Programresource();
		pgmRes.setProgram(pgm);
		mav.addObject("programresource", pgmRes);
		mav.addObject("newFlag", true);
		Integer startResult= -1;
		Tswacct tswacct = sessionCache.getTswacct(request);
		mav.addObject("prices", priceService.findAllPrices4tsw(tswacct, startResult , defaultMaxRows));
		mav.addObject("resources", resourceService.findAllResources4tsw(tswacct, startResult , defaultMaxRows));
		mav.setViewName("programresource/editProgramresource.jsp");
		mav.addObject("user",sessionCache.getUser4Session(request));
		return mav;
	}
	/**
	 * Edit an existing Programresource entity
	 * 
	 */

	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/editProgramresource")
	public ModelAndView editProgramresource(HttpServletRequest request, @RequestParam Integer programResourceIdKey) {
		ModelAndView mav = new ModelAndView();
		Programresource pgmRes = programresourceDAO.findProgramresourceByPrimaryKey(programResourceIdKey);
		Program pgm = pgmRes.getProgram();
		mav.addObject("program_programId", pgm.getProgramId());
		mav.addObject("program", pgm);
		mav.addObject("programresource", pgmRes);
		Integer startResult= -1;
		Tswacct tswacct = sessionCache.getTswacct(request);
		mav.addObject("prices", priceService.findAllPrices4tsw(tswacct, startResult , defaultMaxRows));
		mav.addObject("resources", resourceService.findAllResources4tsw(tswacct, startResult , defaultMaxRows));
		mav.setViewName("programresource/editProgramresource.jsp");
		mav.addObject("user",sessionCache.getUser4Session(request));
		return mav;
	}
	
	/**
	 * Save an existing Programresource entity
	 * 
	 */
	@RequestMapping("/saveProgramresource")
	public ModelAndView saveProgramresource(HttpServletRequest request, @ModelAttribute Programresource programresource, @RequestParam Integer program_programId, @RequestParam Integer selected_id8, @RequestParam Integer selected_id11) {
		programresourceService.saveProgramresource(programresource, program_programId, selected_id8,  selected_id11);
		return pgmController.editProgram(request, program_programId, -1);
	}


	/**
	 * Show all Programresource entities
	 * 
	 */
	@RequestMapping("/indexProgramresource")
	public ModelAndView listProgramresources(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("programresources", programresourceService.loadProgramresources());
		mav.setViewName("programresource/listProgramresources.jsp");
		mav.addObject("user",sessionCache.getUser4Session(request));
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
	 */
	@RequestMapping("/programresourceController/binary.action")
	public ModelAndView streamBinary(@ModelAttribute HttpServletRequest request, @ModelAttribute HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("streamedBinaryContentView");
		return mav;

	}
}