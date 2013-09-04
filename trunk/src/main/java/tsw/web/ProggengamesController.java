package tsw.web;

import tsw.dao.GengameDAO;
import tsw.dao.ProggengamesDAO;

import tsw.domain.GenGame;
import tsw.domain.ProgGenGames;

import tsw.service.ProggengamesService;

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

/**
 * Spring MVC controller that handles CRUD requests for ProgGenGames entities
 * 
 */

@Controller("ProggengamesController")
public class ProggengamesController {

	/**
	 * DAO injected by Spring that manages GenGame entities
	 * 
	 */
	@Autowired
	private GengameDAO gengameDAO;

	/**
	 * DAO injected by Spring that manages ProgGenGames entities
	 * 
	 */
	@Autowired
	private ProggengamesDAO proggengamesDAO;

	/**
	 * Service injected by Spring that provides CRUD operations for ProgGenGames entities
	 * 
	 */
	@Autowired
	private ProggengamesService proggengamesService;

	/**
	 * Show all GenGame entities by ProgGenGames
	 * 
	 */
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/listProggengamesGengames")
	public ModelAndView listProggengamesGengames(@RequestParam Integer progGenGamesIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("proggengames", proggengamesDAO.findProggengamesByPrimaryKey(progGenGamesIdKey));
		mav.setViewName("proggengames/gengames/listGengames.jsp");

		return mav;
	}

	/**
	 * Save an existing ProgGenGames entity
	 * 
	 */
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/saveProggengames")
	public String saveProggengames(@ModelAttribute ProgGenGames proggengames) {
		proggengamesService.saveProggengames(proggengames);
		return "forward:/indexProggengames";
	}

	/**
	 */
	@RequestMapping("/proggengamesController/binary.action")
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
	 * Save an existing GenGame entity
	 * 
	 */
	
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/saveProggengamesGengames")
	public ModelAndView saveProggengamesGengames(@RequestParam Integer proggengames_progGenGamesId, @ModelAttribute GenGame gengames) {
		ProgGenGames parent_proggengames = proggengamesService.saveProggengamesGengames(proggengames_progGenGamesId, gengames);

		ModelAndView mav = new ModelAndView();
		mav.addObject("proggengames_progGenGamesId", proggengames_progGenGamesId);
		mav.addObject("proggengames", parent_proggengames);
		mav.setViewName("proggengames/viewProggengames.jsp");

		return mav;
	}

	/**
	 * Select an existing ProgGenGames entity
	 * 
	 */
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/selectProggengames")
	public ModelAndView selectProggengames(@RequestParam Integer progGenGamesIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("proggengames", proggengamesDAO.findProggengamesByPrimaryKey(progGenGamesIdKey));
		mav.setViewName("proggengames/viewProggengames.jsp");

		return mav;
	}

	/**
	 * Entry point to show all ProgGenGames entities
	 * 
	 */
	public String indexProggengames() {
		return "redirect:/indexProggengames";
	}

	/**
	 * View an existing GenGame entity
	 * 
	 */
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/selectProggengamesGengames")
	public ModelAndView selectProggengamesGengames(@RequestParam Integer proggengames_progGenGamesId, @RequestParam Integer gengames_genGameId) {
		GenGame gengame = gengameDAO.findGengameByPrimaryKey(gengames_genGameId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("proggengames_progGenGamesId", proggengames_progGenGamesId);
		mav.addObject("gengame", gengame);
		mav.setViewName("proggengames/gengames/viewGengames.jsp");

		return mav;
	}

	/**
	 * Delete an existing ProgGenGames entity
	 * 
	 */
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/deleteProggengames")
	public String deleteProggengames(@RequestParam Integer progGenGamesIdKey) {
		ProgGenGames proggengames = proggengamesDAO.findProggengamesByPrimaryKey(progGenGamesIdKey);
		proggengamesService.deleteProggengames(proggengames);
		return "forward:/indexProggengames";
	}

	/**
	 * Create a new GenGame entity
	 * 
	 */
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/newProggengamesGengames")
	public ModelAndView newProggengamesGengames(@RequestParam Integer proggengames_progGenGamesId) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("proggengames_progGenGamesId", proggengames_progGenGamesId);
		mav.addObject("gengame", new GenGame());
		mav.addObject("newFlag", true);
		mav.setViewName("proggengames/gengames/editGengames.jsp");

		return mav;
	}

	/**
	 * Select the ProgGenGames entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteProggengames")
	public ModelAndView confirmDeleteProggengames(@RequestParam Integer progGenGamesIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("proggengames", proggengamesDAO.findProggengamesByPrimaryKey(progGenGamesIdKey));
		mav.setViewName("proggengames/deleteProggengames.jsp");

		return mav;
	}

	/**
	 * Delete an existing GenGame entity
	 * 
	 */
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/deleteProggengamesGengames")
	public ModelAndView deleteProggengamesGengames(@RequestParam Integer proggengames_progGenGamesId, @RequestParam Integer related_gengames_genGameId) {
		ModelAndView mav = new ModelAndView();

		ProgGenGames proggengames = proggengamesService.deleteProggengamesGengames(proggengames_progGenGamesId, related_gengames_genGameId);

		mav.addObject("proggengames_progGenGamesId", proggengames_progGenGamesId);
		mav.addObject("proggengames", proggengames);
		mav.setViewName("proggengames/viewProggengames.jsp");

		return mav;
	}

	/**
	 * Create a new ProgGenGames entity
	 * 
	 */
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/newProggengames")
	public ModelAndView newProggengames() {
		ModelAndView mav = new ModelAndView();

		mav.addObject("proggengames", new ProgGenGames());
		mav.addObject("newFlag", true);
		mav.setViewName("proggengames/editProggengames.jsp");

		return mav;
	}

	/**
	 * Select the child GenGame entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/confirmDeleteProggengamesGengames")
	public ModelAndView confirmDeleteProggengamesGengames(@RequestParam Integer proggengames_progGenGamesId, @RequestParam Integer related_gengames_genGameId) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("gengame", gengameDAO.findGengameByPrimaryKey(related_gengames_genGameId));
		mav.addObject("proggengames_progGenGamesId", proggengames_progGenGamesId);
		mav.setViewName("proggengames/gengames/deleteGengames.jsp");

		return mav;
	}

	/**
	 * Show all ProgGenGames entities
	 * 
	 */
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/indexProggengames")
	public ModelAndView listProggengamess() {
		ModelAndView mav = new ModelAndView();

		mav.addObject("proggengamess", proggengamesService.loadProggengamess());

		mav.setViewName("proggengames/listProggengamess.jsp");

		return mav;
	}

	/**
	 * Edit an existing GenGame entity
	 * 
	 */
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/editProggengamesGengames")
	public ModelAndView editProggengamesGengames(@RequestParam Integer proggengames_progGenGamesId, @RequestParam Integer gengames_genGameId) {
		GenGame gengame = gengameDAO.findGengameByPrimaryKey(gengames_genGameId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("proggengames_progGenGamesId", proggengames_progGenGamesId);
		mav.addObject("gengame", gengame);
		mav.setViewName("proggengames/gengames/editGengames.jsp");

		return mav;
	}

	/**
	 * Edit an existing ProgGenGames entity
	 * 
	 */
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/editProggengames")
	public ModelAndView editProggengames(@RequestParam Integer progGenGamesIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("proggengames", proggengamesDAO.findProggengamesByPrimaryKey(progGenGamesIdKey));
		mav.setViewName("proggengames/editProggengames.jsp");

		return mav;
	}
}