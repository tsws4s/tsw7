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

import pm7.dao.PersonDAO;

import pm7.dao.UserDAO;
import pm7.domain.Person;
import pm7.domain.Account;

import pm7.domain.User;

import pm7.service.AccountService;
import pm7.service.PersonService;

/**
 * Spring MVC controller that handles CRUD requests for Account entities
 * 
 */

@Controller("AccountController")
public class AccountController {

	/**
	 * DAO injected by Spring that manages Account entities
	 * 
	 */
	@Autowired
	private AccountDAO accountDAO;

	@Autowired
	private PersonDAO personDAO;

	@Autowired
	private UserDAO userDAO;

	/**
	 * Service injected by Spring that provides CRUD operations for Account entities
	 * 
	 */
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private PersonService personService;
	/**
	 * Entry point to show all Account entities
	 * 
	 */
	public String indexAccount() {
		return "redirect:/indexAccount";
	}

	/**
	 * Create a new Person entity
	 * 
	 */
	@RequestMapping("/newAccountPersons")
	public ModelAndView newAccountPersons(@RequestParam Integer account_accountId) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("account_accountId", account_accountId);
		mav.addObject("person", new Person());
		mav.addObject("newFlag", true);
		mav.setViewName("account/persons/editPersons.jsp");
		return mav;
	}


	/**
	 * Select the child Person entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteAccountPerson")
	public ModelAndView confirmDeleteAccountPerson(@RequestParam Integer account_accountId, @RequestParam Integer related_person_personId) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("person", personDAO.findPersonByPrimaryKey(related_person_personId));
		mav.addObject("account_accountId", account_accountId);
		mav.setViewName("account/person/deletePerson.jsp");

		return mav;
	}
	/**
	 * Edit an existing User entity
	 * 
	 */
	@RequestMapping("/editAccountUsers")
	public ModelAndView editAccountUsers(@RequestParam Integer account_accountId, @RequestParam Integer users_userId) {
		User user = userDAO.findUserByPrimaryKey(users_userId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("account_accountId", account_accountId);
		mav.addObject("user", user);
		mav.setViewName("account/users/editUsers.jsp");

		return mav;
	}
	/**
	 * Save an existing Account entity
	 * 
	 */
	@RequestMapping("/saveAccount")
	public String saveAccount(@ModelAttribute Account account, @RequestParam Integer selected_id1) {
		accountService.saveAccount(account,selected_id1);
		return "forward:/indexAccount";
	}

	/**
	 * Delete an existing Person entity
	 * 
	 */
	@RequestMapping("/deleteAccountPerson")
	public ModelAndView deleteAccountPerson(@RequestParam Integer account_accountId, @RequestParam Integer related_person_personId) {
		ModelAndView mav = new ModelAndView();
		return mav;
	}
	/**
	 * Show all Account entities
	 * 
	 */
	@RequestMapping("/indexAccount")
	public ModelAndView listAccounts() {
		ModelAndView mav = new ModelAndView();

		mav.addObject("accounts", accountService.loadAccounts());

		mav.setViewName("account/listAccounts.jsp");

		return mav;
	}

	/**
	 * Save an existing Person entity
	 * 
	 */
	@RequestMapping("/saveAccountPersons")
	public ModelAndView saveAccountPersons(@RequestParam Integer account_accountId, @ModelAttribute Person persons) {
		Account parent_account = accountService.saveAccountPersons(account_accountId, persons);

		ModelAndView mav = new ModelAndView();
		mav.addObject("account_accountId", account_accountId);
		mav.addObject("account", parent_account);
		mav.setViewName("account/viewAccount.jsp");

		return mav;
	}

	/**
	 * Create a new Account entity
	 * 
	 */
	@RequestMapping("/newAccount")
	public ModelAndView newAccount() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("persons", personService.loadPersons());	
		mav.addObject("account", new Account());
		mav.addObject("newFlag", true);
		mav.setViewName("account/editAccount.jsp");

		return mav;
	}

	/**
	 * Create a new User entity
	 * 
	 */
	@RequestMapping("/newAccountUsers")
	public ModelAndView newAccountUsers(@RequestParam Integer account_accountId) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("account_accountId", account_accountId);
		mav.addObject("user", new User());
		mav.addObject("newFlag", true);
		mav.setViewName("account/users/editUsers.jsp");

		return mav;
	}

	/**
	 * Save an existing User entity
	 * 
	 */
	@RequestMapping("/saveAccountUsers")
	public ModelAndView saveAccountUsers(@RequestParam Integer account_accountId, @ModelAttribute User users) {
//		Account parent_account = accountService.saveAccountUsers(account_accountId, users);

		ModelAndView mav = new ModelAndView();
		mav.addObject("account_accountId", account_accountId);
//		mav.addObject("account", parent_account);
		mav.setViewName("account/viewAccount.jsp");

		return mav;
	}


	/**
	 * Save an existing Person entity
	 * 
	 */
	@RequestMapping("/saveAccountPerson")
	public ModelAndView saveAccountPerson(@RequestParam Integer account_accountId, @ModelAttribute Person person) {
		Account parent_account = accountService.saveAccountPerson(account_accountId, person);

		ModelAndView mav = new ModelAndView();
		mav.addObject("account_accountId", account_accountId);
		mav.addObject("account", parent_account);
		mav.setViewName("account/viewAccount.jsp");

		return mav;
	}


	/**
	 * Edit an existing Person entity
	 * 
	 */
	@RequestMapping("/editAccountPerson")
	public ModelAndView editAccountPerson(@RequestParam Integer account_accountId, @RequestParam Integer person_personId) {
		Person person = personDAO.findPersonByPrimaryKey(person_personId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("account_accountId", account_accountId);
		mav.addObject("person", person);
		mav.setViewName("account/person/editPerson.jsp");

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
	 * Delete an existing Account entity
	 * 
	 */
	@RequestMapping("/deleteAccount")
	public String deleteAccount(@RequestParam Integer accountIdKey) {
		Account account = accountDAO.findAccountByPrimaryKey(accountIdKey);
		accountService.deleteAccount(account);
		return "forward:/indexAccount";
	}



	/**
	 * Select the Account entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteAccount")
	public ModelAndView confirmDeleteAccount(@RequestParam Integer accountIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("account", accountDAO.findAccountByPrimaryKey(accountIdKey));
		mav.setViewName("account/deleteAccount.jsp");

		return mav;
	}

	/**
	 */
	@RequestMapping("/accountController/binary.action")
	public ModelAndView streamBinary(@ModelAttribute HttpServletRequest request, @ModelAttribute HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("streamedBinaryContentView");
		return mav;

	}


	/**
	 * Create a new Person entity
	 * 
	 */
	@RequestMapping("/newAccountPerson")
	public ModelAndView newAccountPerson(@RequestParam Integer account_accountId) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("account_accountId", account_accountId);
		mav.addObject("person", new Person());
		mav.addObject("newFlag", true);
		mav.setViewName("account/person/editPerson.jsp");

		return mav;
	}


	/**
	 * Edit an existing Account entity
	 * 
	 */
	@RequestMapping("/editAccount")
	public ModelAndView editAccount(@RequestParam Integer accountIdKey) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("persons", personService.loadPersons());		
		mav.addObject("account", accountDAO.findAccountByPrimaryKey(accountIdKey));
		mav.setViewName("account/editAccount.jsp");

		return mav;
	}

	
	
	@RequestMapping("/faq")
	public ModelAndView faq() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("faq", "faq");
		mav.setViewName("../sitemesh-common/faq.jsp");
		return mav;
	}
	@RequestMapping("/helpDesk")
	public ModelAndView helpDesk() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("helpDesk", "helpDesk");
		mav.setViewName("../sitemesh-common/helpDesk.jsp");
		return mav;
	}
	@RequestMapping("/contactUs")
	public ModelAndView contactUs() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("contactUs", "contactUs");
		mav.setViewName("../sitemesh-common/helpDesk.jsp");
		return mav;
	}
}