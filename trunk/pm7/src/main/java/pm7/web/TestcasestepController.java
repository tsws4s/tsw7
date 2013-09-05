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
import pm7.dao.ProjectDAO;
import pm7.dao.TestcaseDAO;
import pm7.dao.TestcasestepDAO;

import pm7.domain.Account;
import pm7.domain.Project;
import pm7.domain.Testcase;
import pm7.domain.Testcasestep;

import pm7.service.TestcasestepService;

/**
 * Spring MVC controller that handles CRUD requests for Testcasestep entities
 * 
 */

@Controller("TestcasestepController")
public class TestcasestepController {

	/**
	 * DAO injected by Spring that manages Account entities
	 * 
	 */
	@Autowired
	private AccountDAO accountDAO;

	/**
	 * DAO injected by Spring that manages Project entities
	 * 
	 */
	@Autowired
	private ProjectDAO projectDAO;

	/**
	 * DAO injected by Spring that manages Testcase entities
	 * 
	 */
	@Autowired
	private TestcaseDAO testcaseDAO;

	/**
	 * DAO injected by Spring that manages Testcasestep entities
	 * 
	 */
	@Autowired
	private TestcasestepDAO testcasestepDAO;

	/**
	 * Service injected by Spring that provides CRUD operations for Testcasestep entities
	 * 
	 */
	@Autowired
	private TestcasestepService testcasestepService;

	/**
	 * View an existing Testcase entity
	 * 
	 */
	@RequestMapping("/selectTestcasestepTestcase")
	public ModelAndView selectTestcasestepTestcase(@RequestParam Integer testcasestep_testStepId, @RequestParam Integer testcase_testId) {
		Testcase testcase = testcaseDAO.findTestcaseByPrimaryKey(testcase_testId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("testcasestep_testStepId", testcasestep_testStepId);
		mav.addObject("testcase", testcase);
		mav.setViewName("testcasestep/testcase/viewTestcase.jsp");

		return mav;
	}

	/**
	 * Select the child Testcase entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteTestcasestepTestcase")
	public ModelAndView confirmDeleteTestcasestepTestcase(@RequestParam Integer testcasestep_testStepId, @RequestParam Integer related_testcase_testId) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("testcase", testcaseDAO.findTestcaseByPrimaryKey(related_testcase_testId));
		mav.addObject("testcasestep_testStepId", testcasestep_testStepId);
		mav.setViewName("testcasestep/testcase/deleteTestcase.jsp");

		return mav;
	}

	/**
	 * Create a new Testcase entity
	 * 
	 */
	@RequestMapping("/newTestcasestepTestcase")
	public ModelAndView newTestcasestepTestcase(@RequestParam Integer testcasestep_testStepId) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("testcasestep_testStepId", testcasestep_testStepId);
		mav.addObject("testcase", new Testcase());
		mav.addObject("newFlag", true);
		mav.setViewName("testcasestep/testcase/editTestcase.jsp");

		return mav;
	}

	/**
	 * Delete an existing Account entity
	 * 
	 */
	@RequestMapping("/deleteTestcasestepAccount")
	public ModelAndView deleteTestcasestepAccount(@RequestParam Integer testcasestep_testStepId, @RequestParam Integer related_account_accountId) {
		ModelAndView mav = new ModelAndView();

		Testcasestep testcasestep = testcasestepService.deleteTestcasestepAccount(testcasestep_testStepId, related_account_accountId);

		mav.addObject("testcasestep_testStepId", testcasestep_testStepId);
		mav.addObject("testcasestep", testcasestep);
		mav.setViewName("testcasestep/viewTestcasestep.jsp");

		return mav;
	}

	/**
	 * Show all Project entities by Testcasestep
	 * 
	 */
	@RequestMapping("/listTestcasestepProject")
	public ModelAndView listTestcasestepProject(@RequestParam Integer testStepIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("testcasestep", testcasestepDAO.findTestcasestepByPrimaryKey(testStepIdKey));
		mav.setViewName("testcasestep/project/listProject.jsp");

		return mav;
	}

	/**
	 * Create a new Account entity
	 * 
	 */
	@RequestMapping("/newTestcasestepAccount")
	public ModelAndView newTestcasestepAccount(@RequestParam Integer testcasestep_testStepId) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("testcasestep_testStepId", testcasestep_testStepId);
		mav.addObject("account", new Account());
		mav.addObject("newFlag", true);
		mav.setViewName("testcasestep/account/editAccount.jsp");

		return mav;
	}

	/**
	 * Select the child Project entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteTestcasestepProject")
	public ModelAndView confirmDeleteTestcasestepProject(@RequestParam Integer testcasestep_testStepId, @RequestParam Integer related_project_projectId) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("project", projectDAO.findProjectByPrimaryKey(related_project_projectId));
		mav.addObject("testcasestep_testStepId", testcasestep_testStepId);
		mav.setViewName("testcasestep/project/deleteProject.jsp");

		return mav;
	}

	/**
	 * Select the child Account entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteTestcasestepAccount")
	public ModelAndView confirmDeleteTestcasestepAccount(@RequestParam Integer testcasestep_testStepId, @RequestParam Integer related_account_accountId) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("account", accountDAO.findAccountByPrimaryKey(related_account_accountId));
		mav.addObject("testcasestep_testStepId", testcasestep_testStepId);
		mav.setViewName("testcasestep/account/deleteAccount.jsp");

		return mav;
	}

	/**
	 * Save an existing Account entity
	 * 
	 */
	@RequestMapping("/saveTestcasestepAccount")
	public ModelAndView saveTestcasestepAccount(@RequestParam Integer testcasestep_testStepId, @ModelAttribute Account account) {
		Testcasestep parent_testcasestep = testcasestepService.saveTestcasestepAccount(testcasestep_testStepId, account);

		ModelAndView mav = new ModelAndView();
		mav.addObject("testcasestep_testStepId", testcasestep_testStepId);
		mav.addObject("testcasestep", parent_testcasestep);
		mav.setViewName("testcasestep/viewTestcasestep.jsp");

		return mav;
	}

	/**
	 * Delete an existing Project entity
	 * 
	 */
	@RequestMapping("/deleteTestcasestepProject")
	public ModelAndView deleteTestcasestepProject(@RequestParam Integer testcasestep_testStepId, @RequestParam Integer related_project_projectId) {
		ModelAndView mav = new ModelAndView();

		Testcasestep testcasestep = testcasestepService.deleteTestcasestepProject(testcasestep_testStepId, related_project_projectId);

		mav.addObject("testcasestep_testStepId", testcasestep_testStepId);
		mav.addObject("testcasestep", testcasestep);
		mav.setViewName("testcasestep/viewTestcasestep.jsp");

		return mav;
	}

	/**
	 */
	@RequestMapping("/testcasestepController/binary.action")
	public ModelAndView streamBinary(@ModelAttribute HttpServletRequest request, @ModelAttribute HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("streamedBinaryContentView");
		return mav;

	}

	/**
	 * View an existing Project entity
	 * 
	 */
	@RequestMapping("/selectTestcasestepProject")
	public ModelAndView selectTestcasestepProject(@RequestParam Integer testcasestep_testStepId, @RequestParam Integer project_projectId) {
		Project project = projectDAO.findProjectByPrimaryKey(project_projectId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("testcasestep_testStepId", testcasestep_testStepId);
		mav.addObject("project", project);
		mav.setViewName("testcasestep/project/viewProject.jsp");

		return mav;
	}

	/**
	 * Select an existing Testcasestep entity
	 * 
	 */
	@RequestMapping("/selectTestcasestep")
	public ModelAndView selectTestcasestep(@RequestParam Integer testStepIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("testcasestep", testcasestepDAO.findTestcasestepByPrimaryKey(testStepIdKey));
		mav.setViewName("testcasestep/viewTestcasestep.jsp");

		return mav;
	}

	/**
	 * Save an existing Project entity
	 * 
	 */
	@RequestMapping("/saveTestcasestepProject")
	public ModelAndView saveTestcasestepProject(@RequestParam Integer testcasestep_testStepId, @ModelAttribute Project project) {
		Testcasestep parent_testcasestep = testcasestepService.saveTestcasestepProject(testcasestep_testStepId, project);

		ModelAndView mav = new ModelAndView();
		mav.addObject("testcasestep_testStepId", testcasestep_testStepId);
		mav.addObject("testcasestep", parent_testcasestep);
		mav.setViewName("testcasestep/viewTestcasestep.jsp");

		return mav;
	}

	/**
	 * Select the Testcasestep entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteTestcasestep")
	public ModelAndView confirmDeleteTestcasestep(@RequestParam Integer testStepIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("testcasestep", testcasestepDAO.findTestcasestepByPrimaryKey(testStepIdKey));
		mav.setViewName("testcasestep/deleteTestcasestep.jsp");

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
	 * Create a new Project entity
	 * 
	 */
	@RequestMapping("/newTestcasestepProject")
	public ModelAndView newTestcasestepProject(@RequestParam Integer testcasestep_testStepId) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("testcasestep_testStepId", testcasestep_testStepId);
		mav.addObject("project", new Project());
		mav.addObject("newFlag", true);
		mav.setViewName("testcasestep/project/editProject.jsp");

		return mav;
	}

	/**
	 * Save an existing Testcasestep entity
	 * 
	 */
	@RequestMapping("/saveTestcasestep")
	public String saveTestcasestep(@ModelAttribute Testcasestep testcasestep) {
		testcasestepService.saveTestcasestep(testcasestep);
		return "forward:/indexTestcasestep";
	}

	/**
	 * Edit an existing Testcasestep entity
	 * 
	 */
	@RequestMapping("/editTestcasestep")
	public ModelAndView editTestcasestep(@RequestParam Integer testStepIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("testcasestep", testcasestepDAO.findTestcasestepByPrimaryKey(testStepIdKey));
		mav.setViewName("testcasestep/editTestcasestep.jsp");

		return mav;
	}

	/**
	 * Create a new Testcasestep entity
	 * 
	 */
	@RequestMapping("/newTestcasestep")
	public ModelAndView newTestcasestep() {
		ModelAndView mav = new ModelAndView();

		mav.addObject("testcasestep", new Testcasestep());
		mav.addObject("newFlag", true);
		mav.setViewName("testcasestep/editTestcasestep.jsp");

		return mav;
	}

	/**
	 * Edit an existing Project entity
	 * 
	 */
	@RequestMapping("/editTestcasestepProject")
	public ModelAndView editTestcasestepProject(@RequestParam Integer testcasestep_testStepId, @RequestParam Integer project_projectId) {
		Project project = projectDAO.findProjectByPrimaryKey(project_projectId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("testcasestep_testStepId", testcasestep_testStepId);
		mav.addObject("project", project);
		mav.setViewName("testcasestep/project/editProject.jsp");

		return mav;
	}

	/**
	 * Show all Testcasestep entities
	 * 
	 */
	@RequestMapping("/indexTestcasestep")
	public ModelAndView listTestcasesteps() {
		ModelAndView mav = new ModelAndView();

		mav.addObject("testcasesteps", testcasestepService.loadTestcasesteps());

		mav.setViewName("testcasestep/listTestcasesteps.jsp");

		return mav;
	}

	/**
	 * Edit an existing Testcase entity
	 * 
	 */
	@RequestMapping("/editTestcasestepTestcase")
	public ModelAndView editTestcasestepTestcase(@RequestParam Integer testcasestep_testStepId, @RequestParam Integer testcase_testId) {
		Testcase testcase = testcaseDAO.findTestcaseByPrimaryKey(testcase_testId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("testcasestep_testStepId", testcasestep_testStepId);
		mav.addObject("testcase", testcase);
		mav.setViewName("testcasestep/testcase/editTestcase.jsp");

		return mav;
	}

	/**
	 * Show all Testcase entities by Testcasestep
	 * 
	 */
	@RequestMapping("/listTestcasestepTestcase")
	public ModelAndView listTestcasestepTestcase(@RequestParam Integer testStepIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("testcasestep", testcasestepDAO.findTestcasestepByPrimaryKey(testStepIdKey));
		mav.setViewName("testcasestep/testcase/listTestcase.jsp");

		return mav;
	}

	/**
	 * Save an existing Testcase entity
	 * 
	 */
	@RequestMapping("/saveTestcasestepTestcase")
	public ModelAndView saveTestcasestepTestcase(@RequestParam Integer testcasestep_testStepId, @ModelAttribute Testcase testcase) {
		Testcasestep parent_testcasestep = testcasestepService.saveTestcasestepTestcase(testcasestep_testStepId, testcase);

		ModelAndView mav = new ModelAndView();
		mav.addObject("testcasestep_testStepId", testcasestep_testStepId);
		mav.addObject("testcasestep", parent_testcasestep);
		mav.setViewName("testcasestep/viewTestcasestep.jsp");

		return mav;
	}

	/**
	 * Show all Account entities by Testcasestep
	 * 
	 */
	@RequestMapping("/listTestcasestepAccount")
	public ModelAndView listTestcasestepAccount(@RequestParam Integer testStepIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("testcasestep", testcasestepDAO.findTestcasestepByPrimaryKey(testStepIdKey));
		mav.setViewName("testcasestep/account/listAccount.jsp");

		return mav;
	}

	/**
	 * View an existing Account entity
	 * 
	 */
	@RequestMapping("/selectTestcasestepAccount")
	public ModelAndView selectTestcasestepAccount(@RequestParam Integer testcasestep_testStepId, @RequestParam Integer account_accountId) {
		Account account = accountDAO.findAccountByPrimaryKey(account_accountId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("testcasestep_testStepId", testcasestep_testStepId);
		mav.addObject("account", account);
		mav.setViewName("testcasestep/account/viewAccount.jsp");

		return mav;
	}

	/**
	 * Entry point to show all Testcasestep entities
	 * 
	 */
	public String indexTestcasestep() {
		return "redirect:/indexTestcasestep";
	}

	/**
	 * Edit an existing Account entity
	 * 
	 */
	@RequestMapping("/editTestcasestepAccount")
	public ModelAndView editTestcasestepAccount(@RequestParam Integer testcasestep_testStepId, @RequestParam Integer account_accountId) {
		Account account = accountDAO.findAccountByPrimaryKey(account_accountId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("testcasestep_testStepId", testcasestep_testStepId);
		mav.addObject("account", account);
		mav.setViewName("testcasestep/account/editAccount.jsp");

		return mav;
	}

	/**
	 * Delete an existing Testcase entity
	 * 
	 */
	@RequestMapping("/deleteTestcasestepTestcase")
	public ModelAndView deleteTestcasestepTestcase(@RequestParam Integer testcasestep_testStepId, @RequestParam Integer related_testcase_testId) {
		ModelAndView mav = new ModelAndView();

		Testcasestep testcasestep = testcasestepService.deleteTestcasestepTestcase(testcasestep_testStepId, related_testcase_testId);

		mav.addObject("testcasestep_testStepId", testcasestep_testStepId);
		mav.addObject("testcasestep", testcasestep);
		mav.setViewName("testcasestep/viewTestcasestep.jsp");

		return mav;
	}

	/**
	 * Delete an existing Testcasestep entity
	 * 
	 */
	@RequestMapping("/deleteTestcasestep")
	public String deleteTestcasestep(@RequestParam Integer testStepIdKey) {
		Testcasestep testcasestep = testcasestepDAO.findTestcasestepByPrimaryKey(testStepIdKey);
		testcasestepService.deleteTestcasestep(testcasestep);
		return "forward:/indexTestcasestep";
	}
}