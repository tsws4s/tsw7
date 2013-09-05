package pm7.web;

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

import pm7.dao.AuthorityDAO;

import pm7.domain.Authority;

import pm7.service.AuthorityService;

/**
 * Spring MVC controller that handles CRUD requests for Authority entities
 * 
 */

@Controller("AuthorityController")
public class AuthorityController {

	/**
	 * DAO injected by Spring that manages Authority entities
	 * 
	 */
	@Autowired
	private AuthorityDAO authorityDAO;

	/**
	 * Service injected by Spring that provides CRUD operations for Authority entities
	 * 
	 */
	@Autowired
	private AuthorityService authorityService;

	/**
	 * Show all Authority entities
	 * 
	 */
	@RequestMapping("/indexAuthority")
	public ModelAndView listAuthoritys() {
		ModelAndView mav = new ModelAndView();

		mav.addObject("authoritys", authorityService.loadAuthoritys());

		mav.setViewName("authority/listAuthoritys.jsp");

		return mav;
	}

	/**
	 * Edit an existing Authority entity
	 * 
	 */
	@RequestMapping("/editAuthority")
	public ModelAndView editAuthority(@RequestParam Integer authorityIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("authority", authorityDAO.findAuthorityByPrimaryKey(authorityIdKey));
		mav.setViewName("authority/editAuthority.jsp");

		return mav;
	}

	/**
	 * Delete an existing Authority entity
	 * 
	 */
	@RequestMapping("/deleteAuthority")
	public String deleteAuthority(@RequestParam Integer authorityIdKey) {
		Authority authority = authorityDAO.findAuthorityByPrimaryKey(authorityIdKey);
		authorityService.deleteAuthority(authority);
		return "forward:/indexAuthority";
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
	 * Save an existing Authority entity
	 * 
	 */
	@RequestMapping("/saveAuthority")
	public String saveAuthority(@ModelAttribute Authority authority) {
		authorityService.saveAuthority(authority);
		return "forward:/indexAuthority";
	}

	/**
	 */
	@RequestMapping("/authorityController/binary.action")
	public ModelAndView streamBinary(@ModelAttribute HttpServletRequest request, @ModelAttribute HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("streamedBinaryContentView");
		return mav;

	}

	/**
	 * Entry point to show all Authority entities
	 * 
	 */
	public String indexAuthority() {
		return "redirect:/indexAuthority";
	}

	/**
	 * Select an existing Authority entity
	 * 
	 */
	@RequestMapping("/selectAuthority")
	public ModelAndView selectAuthority(@RequestParam Integer authorityIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("authority", authorityDAO.findAuthorityByPrimaryKey(authorityIdKey));
		mav.setViewName("authority/viewAuthority.jsp");

		return mav;
	}

	/**
	 * Create a new Authority entity
	 * 
	 */
	@RequestMapping("/newAuthority")
	public ModelAndView newAuthority() {
		ModelAndView mav = new ModelAndView();

		mav.addObject("authority", new Authority());
		mav.addObject("newFlag", true);
		mav.setViewName("authority/editAuthority.jsp");

		return mav;
	}

	/**
	 * Select the Authority entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteAuthority")
	public ModelAndView confirmDeleteAuthority(@RequestParam Integer authorityIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("authority", authorityDAO.findAuthorityByPrimaryKey(authorityIdKey));
		mav.setViewName("authority/deleteAuthority.jsp");

		return mav;
	}
}