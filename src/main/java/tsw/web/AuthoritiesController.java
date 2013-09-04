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

import tsw.dao.AuthoritiesDAO;

import tsw.domain.Authorities;

import tsw.service.AuthoritiesService;

/**
 * Spring MVC controller that handles CRUD requests for Authorities entities
 * 
 */

//TODO: [Sree] (POM-Low) Need to updatee our POM.xml file



// TODO: [assignedTo] (Security-Med) Need to finish Role-based access (represented as Authorities)
// And controlled by annotations...  @Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
// Roles:  TSW_ADMIN, ACCT_ADMIN, ACCT_COORD, ACCT_USER

@Controller("AuthoritiesController")
public class AuthoritiesController {

	/**
	 * DAO injected by Spring that manages Authorities entities
	 * 
	 */
	@Autowired
	private AuthoritiesDAO authoritiesDAO;

	/**
	 * Service injected by Spring that provides CRUD operations for Authorities entities
	 * 
	 */
	@Autowired
	private AuthoritiesService authoritiesService;


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
	@RequestMapping("/authoritiesController/binary.action")
	public ModelAndView streamBinary(@ModelAttribute HttpServletRequest request, @ModelAttribute HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("streamedBinaryContentView");
		return mav;

	}
	
	// List Search
	/**  *************************************  List Search  *************************************************
	 * 	 * Show all Authorities entities
	 * 
	 */
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/indexAuthorities")
	public ModelAndView listAuthoritiess() {
		ModelAndView mav = new ModelAndView();

		mav.addObject("authoritiess", authoritiesService.loadAuthoritiess());

		mav.setViewName("authorities/listAuthoritiess.jsp");

		return mav;
	}

	/**
	 * Entry point to show all Authorities entities
	 * 
	 */
	public String indexAuthorities() {
		return "redirect:/indexAuthorities";
	}

	

	// Add Edit Delete Confirm Save
	/**  **************************************  Add Edit Delete Confirm Save *********************************************
	 * Create a new Authorities entity
	 * 
	 */
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/newAuthorities")
	public ModelAndView newAuthorities() {
		ModelAndView mav = new ModelAndView();

		mav.addObject("authorities", new Authorities());
		mav.addObject("newFlag", true);
		mav.setViewName("authorities/editAuthorities.jsp");

		return mav;
	}

	/**
	 * Edit an existing Authorities entity
	 * 
	 */
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/editAuthorities")
	public ModelAndView editAuthorities(@RequestParam Integer authorityIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("authorities", authoritiesDAO.findAuthoritiesByPrimaryKey(authorityIdKey));
		mav.setViewName("authorities/editAuthorities.jsp");

		return mav;
	}
	
	/**
	 * Select the Authorities entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/confirmDeleteAuthorities")
	public ModelAndView confirmDeleteAuthorities(@RequestParam Integer authorityIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("authorities", authoritiesDAO.findAuthoritiesByPrimaryKey(authorityIdKey));
		mav.setViewName("authorities/deleteAuthorities.jsp");

		return mav;
	}

	/**
	 * Delete an existing Authorities entity
	 * 
	 */
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/deleteAuthorities")
	public String deleteAuthorities(@RequestParam Integer authorityIdKey) {
		Authorities authorities = authoritiesDAO.findAuthoritiesByPrimaryKey(authorityIdKey);
		authoritiesService.deleteAuthorities(authorities);
		return "forward:/indexAuthorities";
	}

	/**
	 * Save an existing Authorities entity
	 * 
	 */
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/saveAuthorities")
	public String saveAuthorities(@ModelAttribute Authorities authorities) {
		authoritiesService.saveAuthorities(authorities);
		return "forward:/indexAuthorities";
	}

}