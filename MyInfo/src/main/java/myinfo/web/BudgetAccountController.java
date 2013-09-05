package myinfo.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import myinfo.dao.BudgetAccountDAO;

import myinfo.domain.BudgetAccount;

import myinfo.service.BudgetAccountService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.WebDataBinder;

import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.servlet.ModelAndView;

/**
 * Spring MVC controller that handles CRUD requests for BudgetAccount entities
 * 
 */

@Controller("BudgetAccountController")
public class BudgetAccountController {

	/**
	 * DAO injected by Spring that manages BudgetAccount entities
	 * 
	 */
	@Autowired
	private BudgetAccountDAO budgetAccountDAO;

	/**
	 * Service injected by Spring that provides CRUD operations for BudgetAccount entities
	 * 
	 */
	@Autowired
	private BudgetAccountService budgetAccountService;

	/**
	 * Edit an existing BudgetAccount entity
	 * 
	 */
	@RequestMapping("/editBudgetAccount")
	public ModelAndView editBudgetAccount(@RequestParam Integer budIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("budgetaccount", budgetAccountDAO.findBudgetAccountByPrimaryKey(budIdKey));
		mav.setViewName("budgetaccount/editBudgetAccount.jsp");

		return mav;
	}

	/**
	 * Save an existing BudgetAccount entity
	 * 
	 */
	@RequestMapping("/saveBudgetAccount")
	public String saveBudgetAccount(@ModelAttribute BudgetAccount budgetaccount) {
		budgetAccountService.saveBudgetAccount(budgetaccount);
		return "forward:/indexBudgetAccount";
	}

	/**
	 * Delete an existing BudgetAccount entity
	 * 
	 */
	@RequestMapping("/deleteBudgetAccount")
	public String deleteBudgetAccount(@RequestParam Integer budIdKey) {
		BudgetAccount budgetaccount = budgetAccountDAO.findBudgetAccountByPrimaryKey(budIdKey);
		budgetAccountService.deleteBudgetAccount(budgetaccount);
		return "forward:/indexBudgetAccount";
	}

	/**
	 * Entry point to show all BudgetAccount entities
	 * 
	 */
	public String indexBudgetAccount() {
		return "redirect:/indexBudgetAccount";
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
	 * Show all BudgetAccount entities
	 * 
	 */
	@RequestMapping("/indexBudgetAccount")
	public ModelAndView listBudgetAccounts() {
		ModelAndView mav = new ModelAndView();

		mav.addObject("budgetaccounts", budgetAccountService.loadBudgetAccounts());

		mav.setViewName("budgetaccount/listBudgetAccounts.jsp");

		return mav;
	}

	/**
	 * Select the BudgetAccount entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteBudgetAccount")
	public ModelAndView confirmDeleteBudgetAccount(@RequestParam Integer budIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("budgetaccount", budgetAccountDAO.findBudgetAccountByPrimaryKey(budIdKey));
		mav.setViewName("budgetaccount/deleteBudgetAccount.jsp");

		return mav;
	}

	/**
	 */
	@RequestMapping("/budgetaccountController/binary.action")
	public ModelAndView streamBinary(@ModelAttribute HttpServletRequest request, @ModelAttribute HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("streamedBinaryContentView");
		return mav;

	}

	/**
	 * Select an existing BudgetAccount entity
	 * 
	 */
	@RequestMapping("/selectBudgetAccount")
	public ModelAndView selectBudgetAccount(@RequestParam Integer budIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("budgetaccount", budgetAccountDAO.findBudgetAccountByPrimaryKey(budIdKey));
		mav.setViewName("budgetaccount/viewBudgetAccount.jsp");

		return mav;
	}

	/**
	 * Create a new BudgetAccount entity
	 * 
	 */
	@RequestMapping("/newBudgetAccount")
	public ModelAndView newBudgetAccount() {
		ModelAndView mav = new ModelAndView();

		mav.addObject("budgetaccount", new BudgetAccount());
		mav.addObject("newFlag", true);
		mav.setViewName("budgetaccount/editBudgetAccount.jsp");

		return mav;
	}
}