package tsw.web;

import tsw.dao.GengameDAO;
import tsw.dao.ProggengamesDAO;

import tsw.domain.GenGame;
import tsw.domain.ProgGenGames;

import tsw.service.GengameService;

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
 * Spring MVC controller that handles CRUD requests for GenGame entities
 * 
 */

@Controller("GengameController")
public class GengameController {

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
	 * Service injected by Spring that provides CRUD operations for GenGame entities
	 * 
	 */
	@Autowired
	private GengameService gengameService;

	/**
	 * Create a new ProgGenGames entity
	 * 
	 */
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/newGengameProggengames")
	public ModelAndView newGengameProggengames(@RequestParam Integer gengame_genGameId) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("gengame_genGameId", gengame_genGameId);
		mav.addObject("proggengames", new ProgGenGames());
		mav.addObject("newFlag", true);
		mav.setViewName("gengame/proggengames/editProggengames.jsp");

		return mav;
	}

	/**
	 * Edit an existing GenGame entity
	 * 
	 */
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/editGengame")
	public ModelAndView editGengame(@RequestParam Integer genGameIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("gengame", gengameDAO.findGengameByPrimaryKey(genGameIdKey));
		mav.setViewName("gengame/editGengame.jsp");

		return mav;
	}

	/**
	 * View an existing ProgGenGames entity
	 * 
	 */
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/selectGengameProggengames")
	public ModelAndView selectGengameProggengames(@RequestParam Integer gengame_genGameId, @RequestParam Integer proggengames_progGenGamesId) {
		ProgGenGames proggengames = proggengamesDAO.findProggengamesByPrimaryKey(proggengames_progGenGamesId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("gengame_genGameId", gengame_genGameId);
		mav.addObject("proggengames", proggengames);
		mav.setViewName("gengame/proggengames/viewProggengames.jsp");

		return mav;
	}

	/**
	 * Save an existing GenGame entity
	 * 
	 */
	
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/saveGengame")
	public String saveGengame(@ModelAttribute GenGame gengame) {
		gengameService.saveGengame(gengame);
		return "forward:/indexGengame";
	}

	/**
	 * Create a new GenGame entity
	 * 
	 */
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/newGengame")
	public ModelAndView newGengame() {
		ModelAndView mav = new ModelAndView();

		mav.addObject("gengame", new GenGame());
		mav.addObject("newFlag", true);
		mav.setViewName("gengame/editGengame.jsp");

		return mav;
	}

	/**
	 * Entry point to show all GenGame entities
	 * 
	 */
	public String indexGengame() {
		return "redirect:/indexGengame";
	}

	/**
	 * Show all ProgGenGames entities by GenGame
	 * 
	 */
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/listGengameProggengames")
	public ModelAndView listGengameProggengames(@RequestParam Integer genGameIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("gengame", gengameDAO.findGengameByPrimaryKey(genGameIdKey));
		mav.setViewName("gengame/proggengames/listProggengames.jsp");

		return mav;
	}

	/**
	 * Select an existing GenGame entity
	 * 
	 */
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/selectGengame")
	public ModelAndView selectGengame(@RequestParam Integer genGameIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("gengame", gengameDAO.findGengameByPrimaryKey(genGameIdKey));
		mav.setViewName("gengame/viewGengame.jsp");

		return mav;
	}

	/**
	 * Select the child ProgGenGames entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/confirmDeleteGengameProggengames")
	public ModelAndView confirmDeleteGengameProggengames(@RequestParam Integer gengame_genGameId, @RequestParam Integer related_proggengames_progGenGamesId) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("proggengames", proggengamesDAO.findProggengamesByPrimaryKey(related_proggengames_progGenGamesId));
		mav.addObject("gengame_genGameId", gengame_genGameId);
		mav.setViewName("gengame/proggengames/deleteProggengames.jsp");

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
	 * Select the GenGame entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/confirmDeleteGengame")
	public ModelAndView confirmDeleteGengame(@RequestParam Integer genGameIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("gengame", gengameDAO.findGengameByPrimaryKey(genGameIdKey));
		mav.setViewName("gengame/deleteGengame.jsp");

		return mav;
	}

	/**
	 */
	@RequestMapping("/gengameController/binary.action")
	public ModelAndView streamBinary(@ModelAttribute HttpServletRequest request, @ModelAttribute HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("streamedBinaryContentView");
		return mav;

	}

	/**
	 * Delete an existing ProgGenGames entity
	 * 
	 */
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/deleteGengameProggengames")
	public ModelAndView deleteGengameProggengames(@RequestParam Integer gengame_genGameId, @RequestParam Integer related_proggengames_progGenGamesId) {
		ModelAndView mav = new ModelAndView();

		GenGame gengame = gengameService.deleteGengameProggengames(gengame_genGameId, related_proggengames_progGenGamesId);

		mav.addObject("gengame_genGameId", gengame_genGameId);
		mav.addObject("gengame", gengame);
		mav.setViewName("gengame/viewGengame.jsp");

		return mav;
	}

	/**
	 * Save an existing ProgGenGames entity
	 * 
	 */
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/saveGengameProggengames")
	public ModelAndView saveGengameProggengames(@RequestParam Integer gengame_genGameId, @ModelAttribute ProgGenGames proggengames) {
		GenGame parent_gengame = gengameService.saveGengameProggengames(gengame_genGameId, proggengames);

		ModelAndView mav = new ModelAndView();
		mav.addObject("gengame_genGameId", gengame_genGameId);
		mav.addObject("gengame", parent_gengame);
		mav.setViewName("gengame/viewGengame.jsp");

		return mav;
	}

	/**
	 * Edit an existing ProgGenGames entity
	 * 
	 */
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/editGengameProggengames")
	public ModelAndView editGengameProggengames(@RequestParam Integer gengame_genGameId, @RequestParam Integer proggengames_progGenGamesId) {
		ProgGenGames proggengames = proggengamesDAO.findProggengamesByPrimaryKey(proggengames_progGenGamesId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("gengame_genGameId", gengame_genGameId);
		mav.addObject("proggengames", proggengames);
		mav.setViewName("gengame/proggengames/editProggengames.jsp");

		return mav;
	}

	/**
	 * Show all GenGame entities
	 * 
	 */
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/indexGengame")
	public ModelAndView listGengames() {
		ModelAndView mav = new ModelAndView();

		mav.addObject("gengames", gengameService.loadGengames());

		mav.setViewName("gengame/listGengames.jsp");

		return mav;
	}

	/**
	 * Delete an existing GenGame entity
	 * 
	 */
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/deleteGengame")
	public String deleteGengame(@RequestParam Integer genGameIdKey) {
		GenGame gengame = gengameDAO.findGengameByPrimaryKey(genGameIdKey);
		gengameService.deleteGengame(gengame);
		return "forward:/indexGengame";
	}
}