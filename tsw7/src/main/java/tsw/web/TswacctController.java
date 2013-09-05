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

import tsw.dao.TswacctDAO;
import tsw.dao.UsersDAO;

import tsw.domain.Tswacct;
import tsw.domain.Users;

import tsw.service.TaskScheduling;
import tsw.service.TswacctService;

/**
 * Spring MVC controller that handles CRUD requests for Tswacct entities
 * 
 */

// TODO: [assignedTo] (Account-Med) Implement the "Account Quick Entry" wizard "SAVE" capability 


@Controller("TswacctController")
public class TswacctController {
    
	SessionConfigCache sessionCache = UsersController.getSessionCache();

	/**
	 * DAO injected by Spring that manages Tswacct entities
	 * 
	 */
	@Autowired
	private TswacctDAO tswacctDAO;

	@Autowired
	private UsersDAO usersDAO;

	/**
	 * Service injected by Spring that provides CRUD operations for Tswacct entities
	 * 
	 */
	@Autowired
	private TswacctService tswacctService;

	int defaultMaxRows = UsersController.getDefaultMaxRows();
	
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
	@RequestMapping("/tswacctController/binary.action")
	public ModelAndView streamBinary(@ModelAttribute HttpServletRequest request, @ModelAttribute HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("streamedBinaryContentView");
		return mav;

	}

	// List Search
	/**  *************************************  List Search  *************************************************
	 * Entry point to show all Tswacct entities
	 * 
	 */
	public String indexTswacct(HttpServletRequest request) {
		return "redirect:/indexTswacct";
	}
	
	/**
	 * Show all Tswacct entities
	 * 
	 */
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/indexTswacct")
	public ModelAndView listTswaccts(HttpServletRequest request) {
		return listTswacctFrom(request, 0);
	}
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/indexTswacctFrom")
	public ModelAndView listTswacctFrom(HttpServletRequest request, @RequestParam int indexFrom) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("tswaccts", tswacctService.loadTswaccts(indexFrom));
		mav.addObject("indexFrom", indexFrom);
		mav.addObject("indexCount", tswacctService.getTswacctCount());
		mav.addObject("resultsPerPage", sessionCache.getResultsPerPage(request));
		mav.addObject("user",sessionCache.getUser4Session(request));
		mav.setViewName("tswacct/listTswaccts.jsp");
		return mav;
	}

	// Add Edit Delete Confirm Save
	/**  **************************************  Add Edit Delete Confirm Save *********************************************
	 * Create a new Tswacct entity
	 * 
	 */
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/newTswacct")
	public ModelAndView newTswacct(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		Tswacct acct = new Tswacct();
		acct.setActiveYn(1);
		mav.addObject("tswacct", acct);
		mav.addObject("newFlag", true);
		mav.setViewName("tswacct/editTswacct.jsp");
		mav.addObject("user",sessionCache.getUser4Session(request));
		return mav;
	}

	/**
	 * Edit an existing Tswacct entity
	 * 
	 */
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/editTswacct")
	public ModelAndView editTswacct(HttpServletRequest request, @RequestParam Integer tswAcctIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("tswacct", tswacctDAO.findTswacctByPrimaryKey(tswAcctIdKey));
		mav.setViewName("tswacct/editTswacct.jsp");
		mav.addObject("user",sessionCache.getUser4Session(request));
		return mav;
	}

	/**
	 * Delete an existing Tswacct entity
	 *   
	 */
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/deleteTswacct")
	public String deleteTswacct(HttpServletRequest request, @RequestParam Integer tswAcctIdKey) {
		Tswacct tswacct = tswacctDAO.findTswacctByPrimaryKey(tswAcctIdKey);
		tswacctService.deleteTswacct(tswacct);
		return "forward:/indexTswacct";
	}
	
	/**
	 * Select the Tswacct entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/confirmDeleteTswacct")
	public ModelAndView confirmDeleteTswacct(HttpServletRequest request, @RequestParam Integer tswAcctIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("tswacct", tswacctDAO.findTswacctByPrimaryKey(tswAcctIdKey));
		mav.setViewName("tswacct/deleteTswacct.jsp");
		mav.addObject("user",sessionCache.getUser4Session(request));
		return mav;
	}

	/**
	 * Save an existing Tswacct entity
	 * 
	 */
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/saveTswacct")
	public String saveTswacct(HttpServletRequest request, @ModelAttribute Tswacct tswacct, @RequestParam Integer selected_id4) {
		tswacctService.saveTswacct(tswacct, selected_id4);
		return "forward:/indexTswacct";
	}
	
	
	// Users
	/**
	 * Edit an existing Users entity
	 * 
	 */
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/editTswacctUserses")
	public ModelAndView editTswacctUserses(HttpServletRequest request, @RequestParam Integer tswacct_tswAcctId, @RequestParam Integer userses_userId) {
		Users users = usersDAO.findUsersByPrimaryKey(userses_userId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("tswacct_tswAcctId", tswacct_tswAcctId);
		mav.addObject("users", users);
		mav.setViewName("tswacct/userses/editUserses.jsp");

		return mav;
	}

	/**
	 * Save an existing Users entity
	 * 
	 */
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/saveTswacctUserses")
	public ModelAndView saveTswacctUserses(HttpServletRequest request, @RequestParam Integer tswacct_tswAcctId, @ModelAttribute Users userses) {
		Tswacct parent_tswacct = tswacctService.saveTswacctUserses(tswacct_tswAcctId, userses);

		ModelAndView mav = new ModelAndView();
		mav.addObject("tswacct_tswAcctId", tswacct_tswAcctId);
		mav.addObject("tswacct", parent_tswacct);
		mav.setViewName("tswacct/viewTswacct.jsp");

		return mav;
	}
	
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/leagueQS")
	public ModelAndView leagueQS(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("guide/leagueQuickStart.jsp");
		mav.addObject("user",sessionCache.getUser4Session(request));
		return mav;
	}	
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/accountQS")
	public ModelAndView accountQS(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("guide/accountQuickStart.jsp");
		mav.addObject("user",sessionCache.getUser4Session(request));
		return mav;
	}	
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/programQS")
	public ModelAndView programQS(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("guide/programQuickStart.jsp");
		mav.addObject("user",sessionCache.getUser4Session(request));
		return mav;
	}	
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/schedulingQS")
	public ModelAndView schedulingQS(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("guide/schedulingQuickStart.jsp");
		mav.addObject("user",sessionCache.getUser4Session(request));
		return mav;
	}		
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/customerQS")
	public ModelAndView customerQS(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("guide/customerQuickStart.jsp");
		mav.addObject("user",sessionCache.getUser4Session(request));
		return mav;
	}
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/qsGuides")
	public ModelAndView qsGuides(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("guide/quickStartGuides.jsp");
		mav.addObject("user",sessionCache.getUser4Session(request));
		return mav;
	}
	
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/startTimer")
	public ModelAndView startTimer(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("taskMode", "TimerStart");
		TaskScheduling.start(tswacctService);
		mav.addObject("taskStatus", TaskScheduling.getStatus());
		mav.addObject("user",sessionCache.getUser4Session(request));
		mav.setViewName("tswacct/timerDisplay.jsp");
		return mav;
	}
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/stopTimer")
	public ModelAndView stopTimer(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("taskMode", "TimerStop");
		mav.addObject("taskStatus", TaskScheduling.getStatus());
		TaskScheduling.stop();
		mav.addObject("user",sessionCache.getUser4Session(request));
		mav.setViewName("tswacct/timerDisplay.jsp");
		return mav;
	}
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/getTimerStatus")
	public ModelAndView getTimerStatus(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("taskMode", "TimerStatus");
		mav.addObject("taskStatus", TaskScheduling.getStatus()+" [Sessions="+sessionCache.getSessionCache().size()+"]");
		mav.addObject("user",sessionCache.getUser4Session(request));
		mav.setViewName("tswacct/timerDisplay.jsp");
		return mav;
	}
}