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

import tsw.domain.Authorities;
import tsw.domain.Users;

import tsw.service.AuthoritiesService;
import tsw.service.UsersService;

/**
 * Spring MVC controller that handles CRUD requests for Users entities
 * 
 */

@Controller("UsersController")
public class UsersController {
    
	static SessionConfigCache sessionCache = new SessionConfigCache();
	static int defaultMaxRows = 100;

	/**
	 * Service injected by Spring that provides CRUD operations for Users entities
	 * 
	 */
	@Autowired
	private UsersService usersService;
	
	@Autowired
	private AuthoritiesService authoritiesService;
	
	
	public static SessionConfigCache getSessionCache(){
		return sessionCache;
	}
	public static int getDefaultMaxRows() {
		return defaultMaxRows;
	}
	
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
	@RequestMapping("/usersController/binary.action")
	public ModelAndView streamBinary(@ModelAttribute HttpServletRequest request, @ModelAttribute HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("streamedBinaryContentView");
		return mav;

	}

	// List Search
	/**  *************************************  List Search  *************************************************
	 * Show all Users entities
	 * 
	 */
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/indexUsers")
	public ModelAndView listUserss(HttpServletRequest request) {
		return listUserssFrom(request, 0);
	}

	/**
	 * Entry point to show all Users entities
	 * 
	 */
	public String indexUsers() {
		return "redirect:/indexUsers";
	}
	
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/indexUsersFrom")
	public ModelAndView listUserssFrom(HttpServletRequest request, @RequestParam int indexFrom) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("userss", usersService.loadUserss4tsw(sessionCache.getTswacct(request)));
		mav.addObject("indexFrom", indexFrom);
		mav.addObject("indexCount", usersService.getUsersCount4tsw(sessionCache.getTswacct(request)));
		mav.addObject("resultsPerPage",sessionCache.getResultsPerPage(request));
		mav.setViewName("users/listUserss.jsp");
		mav.addObject("user",sessionCache.getUser4Session(request));
		return mav;
	}	

	// Add Edit Delete Confirm Save
	/**  **************************************  Add Edit Delete Confirm Save *********************************************
	 * Create a new Users entity
	 * 
	 */
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/newUsers")
	public ModelAndView newUsers(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		Users usr = new Users();
		usr.setActiveYn(1);
		mav.addObject("users", usr);
		mav.addObject("newFlag", true);
		mav.setViewName("users/editUsers.jsp");
		mav.addObject("user",sessionCache.getUser4Session(request));
		return mav;
	}

	/**
	 * Edit an existing Users entity
	 * 
	 */
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/editUsers")
	public ModelAndView editUsers(HttpServletRequest request, @RequestParam Integer userIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("users", usersService.findUsersByPrimaryKey(userIdKey));
		mav.setViewName("users/editUsers.jsp");
		mav.addObject("user",sessionCache.getUser4Session(request));
		return mav;
	}

	/**
	 * Select the Users entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/confirmDeleteUsers")
	public ModelAndView confirmDeleteUsers(HttpServletRequest request, @RequestParam Integer userIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("users", usersService.findUsersByPrimaryKey(userIdKey));
		mav.setViewName("users/deleteUsers.jsp");
		mav.addObject("user",sessionCache.getUser4Session(request));
		return mav;
	}
	
	/**
	 * Delete an existing Users entity
	 * 
	 */
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/deleteUsers")
	public String deleteUsers(HttpServletRequest request, @RequestParam Integer userIdKey) {
		Users users = usersService.findUsersByPrimaryKey(userIdKey);
		usersService.deleteUsers(users);
		return "forward:/indexUsers";
	}
	
	/**
	 * Save an existing Users entity
	 * 
	 */
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/saveUsers")
	public String saveUsers(HttpServletRequest request, @ModelAttribute Users users, @RequestParam Integer selected_id4) {
		usersService.saveUsers(sessionCache.getTswacct(request), users, selected_id4);
		// request.getSession(false).setAttribute("selectTheme", users.getSelectTheme());
		return "forward:/indexUsers";
	}
	
	
	// Add Edit Delete Confirm Save
	/**  **************************************  Add Edit Delete Confirm Save *********************************************
	 * Create a new Authorities entity
	 * 
	 */
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/newUsersAuthoritieses")
	public ModelAndView newUsersAuthoritieses(HttpServletRequest request, @RequestParam Integer users_userId) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("users_userId", users_userId);
		mav.addObject("authorities", new Authorities());
		mav.addObject("newFlag", true);
		mav.setViewName("users/authoritieses/editAuthoritieses.jsp");
		mav.addObject("user",sessionCache.getUser4Session(request));
		return mav;
	}

	/**
	 * Show all Authorities entities by Users
	 * 
	 */
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/listUsersAuthoritieses")
	public ModelAndView listUsersAuthoritieses(HttpServletRequest request, @RequestParam Integer userIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("users", usersService.findUsersByPrimaryKey(userIdKey));
		mav.setViewName("users/authoritieses/listAuthoritieses.jsp");
		mav.addObject("resultsPerPage", sessionCache.getResultsPerPage(request));
		mav.addObject("user",sessionCache.getUser4Session(request));
		return mav;
	}
	
	/**
	 * Edit an existing Authorities entity
	 * 
	 */
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/editUsersAuthoritieses")
	public ModelAndView editUsersAuthoritieses(HttpServletRequest request, @RequestParam Integer users_userId, @RequestParam Integer authoritieses_authorityId) {
		Authorities authorities = authoritiesService.findAuthoritiesByPrimaryKey(authoritieses_authorityId);

		ModelAndView mav = new ModelAndView();
		mav.addObject("users_userId", users_userId);
		mav.addObject("authorities", authorities);
		mav.setViewName("users/authoritieses/editAuthoritieses.jsp");
		mav.addObject("user",sessionCache.getUser4Session(request));
		return mav;
	}
	
	/**
	 * Select the child Authorities entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/confirmDeleteUsersAuthoritieses")
	public ModelAndView confirmDeleteUsersAuthoritieses(HttpServletRequest request, @RequestParam Integer users_userId, @RequestParam Integer related_authoritieses_authorityId) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("authorities", authoritiesService.findAuthoritiesByPrimaryKey(related_authoritieses_authorityId));
		mav.addObject("users_userId", users_userId);
		mav.setViewName("users/authoritieses/deleteAuthoritieses.jsp");
		mav.addObject("user",sessionCache.getUser4Session(request));
		return mav;
	}

	/**
	 * Delete an existing Authorities entity
	 * 
	 */
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/deleteUsersAuthoritieses")
	public ModelAndView deleteUsersAuthoritieses(@RequestParam Integer users_userId, @RequestParam Integer related_authoritieses_authorityId) {
		ModelAndView mav = new ModelAndView();

		Users users = usersService.deleteUsersAuthoritieses(users_userId, related_authoritieses_authorityId);

		mav.addObject("users_userId", users_userId);
		mav.addObject("users", users);
		mav.setViewName("users/viewUsers.jsp");

		return mav;
	}

	/**
	 * Save an existing Authorities entity
	 * 
	 */
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/saveUsersAuthoritieses")
	public ModelAndView saveUsersAuthoritieses(HttpServletRequest request, @RequestParam Integer users_userId, @ModelAttribute Authorities authoritieses) {
		Users parent_users = usersService.saveUsersAuthoritieses(users_userId, authoritieses);

		ModelAndView mav = new ModelAndView();
		mav.addObject("users_userId", users_userId);
		mav.addObject("users", parent_users);
		mav.setViewName("users/viewUsers.jsp");
		mav.addObject("user",sessionCache.getUser4Session(request));
		return mav;
	}
	
	

}