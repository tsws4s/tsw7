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

import pm7.dao.AccountDAO;
import pm7.dao.UserDAO;

import pm7.domain.Account;
import pm7.domain.User;

import pm7.service.UserService;

/**
 * Spring MVC controller that handles CRUD requests for User entities
 * 
 */

@Controller("UserController")
public class UserController {

	/**
	 * DAO injected by Spring that manages Account entities
	 * 
	 */
	@Autowired
	private AccountDAO accountDAO;

	/**
	 * DAO injected by Spring that manages User entities
	 * 
	 */
	@Autowired
	private UserDAO userDAO;

	/**
	 * Service injected by Spring that provides CRUD operations for User entities
	 * 
	 */
	@Autowired
	private UserService userService;

	/**
	 * View an existing Account entity
	 * 
	 */
	@RequestMapping("/selectUserAccount")
	public ModelAndView selectUserAccount(@RequestParam Integer user_userId, @RequestParam Integer account_accountId) {
		Account account = accountDAO.findAccountByPrimaryKey(account_accountId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("user_userId", user_userId);
		mav.addObject("account", account);
		mav.setViewName("user/account/viewAccount.jsp");

		return mav;
	}

	/**
	 * Select the User entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteUser")
	public ModelAndView confirmDeleteUser(@RequestParam Integer userIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("user", userDAO.findUserByPrimaryKey(userIdKey));
		mav.setViewName("user/deleteUser.jsp");

		return mav;
	}

	/**
	 * Edit an existing User entity
	 * 
	 */
	@RequestMapping("/editUser")
	public ModelAndView editUser(@RequestParam Integer userIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("user", userDAO.findUserByPrimaryKey(userIdKey));
		mav.setViewName("user/editUser.jsp");

		return mav;
	}

	/**
	 * Entry point to show all User entities
	 * 
	 */
	public String indexUser() {
		return "redirect:/indexUser";
	}

	/**
	 * Save an existing User entity
	 * 
	 */
	@RequestMapping("/saveUser")
	public String saveUser(@ModelAttribute User user) {
		userService.saveUser(user);
		return "forward:/indexUser";
	}

	/**
	 * Delete an existing Account entity
	 * 
	 */
	@RequestMapping("/deleteUserAccount")
	public ModelAndView deleteUserAccount(@RequestParam Integer user_userId, @RequestParam Integer related_account_accountId) {
		ModelAndView mav = new ModelAndView();

		User user = userService.deleteUserAccount(user_userId, related_account_accountId);

		mav.addObject("user_userId", user_userId);
		mav.addObject("user", user);
		mav.setViewName("user/viewUser.jsp");

		return mav;
	}

	/**
	 * Select the child Account entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteUserAccount")
	public ModelAndView confirmDeleteUserAccount(@RequestParam Integer user_userId, @RequestParam Integer related_account_accountId) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("account", accountDAO.findAccountByPrimaryKey(related_account_accountId));
		mav.addObject("user_userId", user_userId);
		mav.setViewName("user/account/deleteAccount.jsp");

		return mav;
	}

	/**
	 * Show all Account entities by User
	 * 
	 */
	@RequestMapping("/listUserAccount")
	public ModelAndView listUserAccount(@RequestParam Integer userIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("user", userDAO.findUserByPrimaryKey(userIdKey));
		mav.setViewName("user/account/listAccount.jsp");

		return mav;
	}

	/**
	 * Show all User entities
	 * 
	 */
	@RequestMapping("/indexUser")
	public ModelAndView listUsers() {
		ModelAndView mav = new ModelAndView();

		mav.addObject("users", userService.loadUsers());

		mav.setViewName("user/listUsers.jsp");

		return mav;
	}

	/**
	 * Select an existing User entity
	 * 
	 */
	@RequestMapping("/selectUser")
	public ModelAndView selectUser(@RequestParam Integer userIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("user", userDAO.findUserByPrimaryKey(userIdKey));
		mav.setViewName("user/viewUser.jsp");

		return mav;
	}

	/**
	 * Create a new Account entity
	 * 
	 */
	@RequestMapping("/newUserAccount")
	public ModelAndView newUserAccount(@RequestParam Integer user_userId) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("user_userId", user_userId);
		mav.addObject("account", new Account());
		mav.addObject("newFlag", true);
		mav.setViewName("user/account/editAccount.jsp");

		return mav;
	}

	/**
	 * Delete an existing User entity
	 * 
	 */
	@RequestMapping("/deleteUser")
	public String deleteUser(@RequestParam Integer userIdKey) {
		User user = userDAO.findUserByPrimaryKey(userIdKey);
		userService.deleteUser(user);
		return "forward:/indexUser";
	}

	/**
	 * Create a new User entity
	 * 
	 */
	@RequestMapping("/newUser")
	public ModelAndView newUser() {
		ModelAndView mav = new ModelAndView();

		mav.addObject("user", new User());
		mav.addObject("newFlag", true);
		mav.setViewName("user/editUser.jsp");

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
	@RequestMapping("/userController/binary.action")
	public ModelAndView streamBinary(@ModelAttribute HttpServletRequest request, @ModelAttribute HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("streamedBinaryContentView");
		return mav;

	}

	/**
	 * Save an existing Account entity
	 * 
	 */
	@RequestMapping("/saveUserAccount")
	public ModelAndView saveUserAccount(@RequestParam Integer user_userId, @ModelAttribute Account account) {
		User parent_user = userService.saveUserAccount(user_userId, account);

		ModelAndView mav = new ModelAndView();
		mav.addObject("user_userId", user_userId);
		mav.addObject("user", parent_user);
		mav.setViewName("user/viewUser.jsp");

		return mav;
	}

	/**
	 * Edit an existing Account entity
	 * 
	 */
	@RequestMapping("/editUserAccount")
	public ModelAndView editUserAccount(@RequestParam Integer user_userId, @RequestParam Integer account_accountId) {
		Account account = accountDAO.findAccountByPrimaryKey(account_accountId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("user_userId", user_userId);
		mav.addObject("account", account);
		mav.setViewName("user/account/editAccount.jsp");

		return mav;
	}
}