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

import tsw.domain.Level;

import tsw.service.LevelService;

/**
 * Spring MVC controller that handles CRUD requests for Level entities
 * 
 */

@Controller("LevelController")
public class LevelController {
    
	SessionConfigCache sessionCache = UsersController.getSessionCache();

	/**
	 * Service injected by Spring that provides CRUD operations for Level entities
	 * 
	 */
	@Autowired
	private LevelService levelService;
	
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
	@RequestMapping("/levelController/binary.action")
	public ModelAndView streamBinary(@ModelAttribute HttpServletRequest request, @ModelAttribute HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("streamedBinaryContentView");
		return mav;

	}


	// List Search
	/**  *************************************  List Search  *************************************************
	 * Show all Level entities
	 * 
	 */
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/indexLevel")
	public ModelAndView listLevels(HttpServletRequest request) {
		return listLevelsFrom(request, 0);
	}
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/indexLevelFrom")
	public ModelAndView listLevelsFrom(HttpServletRequest request, @RequestParam int indexFrom) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("levels", levelService.loadLevels4tsw(sessionCache.getTswacct(request), indexFrom));
		mav.addObject("indexFrom", indexFrom);
		mav.addObject("indexCount", levelService.getLevelCount4tsw(sessionCache.getTswacct(request)));
		mav.addObject("resultsPerPage", sessionCache.getResultsPerPage(request));
		mav.addObject("user",sessionCache.getUser4Session(request));
		mav.setViewName("level/listLevels.jsp");
		return mav;
	}
	
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/searchLevelsFrom")
	public ModelAndView searchLevelsFrom(HttpServletRequest request, @RequestParam int indexFrom) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("levels", levelService.loadLevels4tsw(sessionCache.getTswacct(request), indexFrom));
		mav.addObject("searchFlag", true);
		mav.addObject("indexFrom", indexFrom);
		mav.addObject("indexCount", levelService.getLevelCount4tsw(sessionCache.getTswacct(request)));
		mav.addObject("resultsPerPage", sessionCache.getResultsPerPage(request));
		mav.addObject("user",sessionCache.getUser4Session(request));
		mav.setViewName("level/searchLevels.jsp");
		return mav;
	}	
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/searchLevels")
	public ModelAndView searchLevels(HttpServletRequest request) {
		return searchLevelsFrom(request, 0);
	}
	
	/**
	 * Entry point to show all Level entities
	 * 
	 */
	public String indexLevel(HttpServletRequest request) {
		return "redirect:/indexLevel";
	}

	// Add Edit Delete Confirm Save
	/**  **************************************  Add Edit Delete Confirm Save *********************************************
	 * 	 * Create a new Level entity
	 * 
	 */
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/newLevel")
	public ModelAndView newLevel(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		Level lvl = new Level();
		lvl.setActiveYn(1);
		mav.addObject("level", lvl);
		mav.addObject("newFlag", true);
		mav.setViewName("level/editLevel.jsp");
		mav.addObject("user",sessionCache.getUser4Session(request));
		return mav;
	}
	
	/**
	 * Edit an existing Level entity
	 * 
	 */
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/editLevel")
	public ModelAndView editLevel(HttpServletRequest request, @RequestParam Integer levelIdKey) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("level", levelService.findLevelByPrimaryKey(levelIdKey));
		mav.setViewName("level/editLevel.jsp");
		mav.addObject("user",sessionCache.getUser4Session(request));
		return mav;
	}
	
	/**
	 * Delete an existing Level entity
	 * 
	 */
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/deleteLevel")
	public String deleteLevel(HttpServletRequest request, @RequestParam Integer levelIdKey) {
		Level level = levelService.findLevelByPrimaryKey(levelIdKey);
		levelService.deleteLevel(level);
		return "forward:/indexLevel";
	}

	/**
	 * Select the Level entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/confirmDeleteLevel")
	public ModelAndView confirmDeleteLevel(HttpServletRequest request, @RequestParam Integer levelIdKey) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("level", levelService.findLevelByPrimaryKey(levelIdKey));
		mav.setViewName("level/deleteLevel.jsp");
		mav.addObject("user",sessionCache.getUser4Session(request));
		return mav;
	}

	/**
	 * Save an existing Level entity
	 * 
	 */
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/saveLevel")
	public String saveLevel(HttpServletRequest request, @ModelAttribute Level level) {
		levelService.saveLevel(sessionCache.getTswacct(request), level);
		return "forward:/indexLevel";
	}

}