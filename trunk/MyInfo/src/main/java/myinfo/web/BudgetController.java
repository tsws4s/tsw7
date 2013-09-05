package myinfo.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import myinfo.dao.BudgetDAO;

import myinfo.domain.Budget;

import myinfo.service.BudgetService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.WebDataBinder;

import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.servlet.ModelAndView;

/**
 * Spring MVC controller that handles CRUD requests for Budget entities
 * 
 */

@Controller("BudgetController")
public class BudgetController {

	/**
	 * DAO injected by Spring that manages Budget entities
	 * 
	 */
	@Autowired
	private BudgetDAO budgetDAO;

	/**
	 * Service injected by Spring that provides CRUD operations for Budget entities
	 * 
	 */
	@Autowired
	private BudgetService budgetService;

	/**
	 * Save an existing Budget entity
	 * 
	 */
	@RequestMapping("/saveBudget")
	public String saveBudget(@ModelAttribute Budget budget) {
		budgetService.saveBudget(budget);
		return "forward:/indexBudget";
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
	 * Select an existing Budget entity
	 * 
	 */
	@RequestMapping("/selectBudget")
	public ModelAndView selectBudget(@RequestParam Integer budgetIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("budget", budgetDAO.findBudgetByPrimaryKey(budgetIdKey));
		mav.setViewName("budget/viewBudget.jsp");

		return mav;
	}

	/**
	 * Select the Budget entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteBudget")
	public ModelAndView confirmDeleteBudget(@RequestParam Integer budgetIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("budget", budgetDAO.findBudgetByPrimaryKey(budgetIdKey));
		mav.setViewName("budget/deleteBudget.jsp");

		return mav;
	}

	/**
	 * Create a new Budget entity
	 * 
	 */
	@RequestMapping("/newBudget")
	public ModelAndView newBudget() {
		ModelAndView mav = new ModelAndView();

		mav.addObject("budget", new Budget());
		mav.addObject("newFlag", true);
		mav.setViewName("budget/editBudget.jsp");

		return mav;
	}

	/**
	 * Show all Budget entities
	 * 
	 */
	@RequestMapping("/indexBudget")
	public ModelAndView listBudgets() {
		ModelAndView mav = new ModelAndView();

		mav.addObject("budgets", budgetService.loadBudgets());

		mav.setViewName("budget/listBudgets.jsp");

		return mav;
	}

	/**
	 * Delete an existing Budget entity
	 * 
	 */
	@RequestMapping("/deleteBudget")
	public String deleteBudget(@RequestParam Integer budgetIdKey) {
		Budget budget = budgetDAO.findBudgetByPrimaryKey(budgetIdKey);
		budgetService.deleteBudget(budget);
		return "forward:/indexBudget";
	}

	/**
	 * Edit an existing Budget entity
	 * 
	 */
	@RequestMapping("/editBudget")
	public ModelAndView editBudget(@RequestParam Integer budgetIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("budget", budgetDAO.findBudgetByPrimaryKey(budgetIdKey));
		mav.setViewName("budget/editBudget.jsp");

		return mav;
	}

	/**
	 * Entry point to show all Budget entities
	 * 
	 */
	public String indexBudget() {
		return "redirect:/indexBudget";
	}

	/**
	 */
	@RequestMapping("/budgetController/binary.action")
	public ModelAndView streamBinary(@ModelAttribute HttpServletRequest request, @ModelAttribute HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("streamedBinaryContentView");
		return mav;

	}
}