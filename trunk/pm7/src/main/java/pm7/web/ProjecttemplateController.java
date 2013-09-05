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
import pm7.dao.ProjecttemplateDAO;

import pm7.domain.Account;
import pm7.domain.Project;
import pm7.domain.Projecttemplate;

import pm7.service.ProjecttemplateService;

/**
 * Spring MVC controller that handles CRUD requests for Projecttemplate entities
 * 
 */

@Controller("ProjecttemplateController")
public class ProjecttemplateController {

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
	 * DAO injected by Spring that manages Projecttemplate entities
	 * 
	 */
	@Autowired
	private ProjecttemplateDAO projecttemplateDAO;

	/**
	 * Service injected by Spring that provides CRUD operations for Projecttemplate entities
	 * 
	 */
	@Autowired
	private ProjecttemplateService projecttemplateService;

	/**
	 * Select the child Account entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteProjecttemplateAccount")
	public ModelAndView confirmDeleteProjecttemplateAccount(@RequestParam Integer projecttemplate_templateId, @RequestParam Integer related_account_accountId) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("account", accountDAO.findAccountByPrimaryKey(related_account_accountId));
		mav.addObject("projecttemplate_templateId", projecttemplate_templateId);
		mav.setViewName("projecttemplate/account/deleteAccount.jsp");

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
	 * Create a new Account entity
	 * 
	 */
	@RequestMapping("/newProjecttemplateAccount")
	public ModelAndView newProjecttemplateAccount(@RequestParam Integer projecttemplate_templateId) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("projecttemplate_templateId", projecttemplate_templateId);
		mav.addObject("account", new Account());
		mav.addObject("newFlag", true);
		mav.setViewName("projecttemplate/account/editAccount.jsp");

		return mav;
	}

	/**
	 * Show all Project entities by Projecttemplate
	 * 
	 */
	@RequestMapping("/listProjecttemplateProject")
	public ModelAndView listProjecttemplateProject(@RequestParam Integer templateIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("projecttemplate", projecttemplateDAO.findProjecttemplateByPrimaryKey(templateIdKey));
		mav.setViewName("projecttemplate/project/listProject.jsp");

		return mav;
	}

	/**
	 * Delete an existing Projecttemplate entity
	 * 
	 */
	@RequestMapping("/deleteProjecttemplate")
	public String deleteProjecttemplate(@RequestParam Integer templateIdKey) {
		Projecttemplate projecttemplate = projecttemplateDAO.findProjecttemplateByPrimaryKey(templateIdKey);
		projecttemplateService.deleteProjecttemplate(projecttemplate);
		return "forward:/indexProjecttemplate";
	}

	/**
	 * Create a new Project entity
	 * 
	 */
	@RequestMapping("/newProjecttemplateProject")
	public ModelAndView newProjecttemplateProject(@RequestParam Integer projecttemplate_templateId) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("projecttemplate_templateId", projecttemplate_templateId);
		mav.addObject("project", new Project());
		mav.addObject("newFlag", true);
		mav.setViewName("projecttemplate/project/editProject.jsp");

		return mav;
	}

	/**
	 * Show all Account entities by Projecttemplate
	 * 
	 */
	@RequestMapping("/listProjecttemplateAccount")
	public ModelAndView listProjecttemplateAccount(@RequestParam Integer templateIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("projecttemplate", projecttemplateDAO.findProjecttemplateByPrimaryKey(templateIdKey));
		mav.setViewName("projecttemplate/account/listAccount.jsp");

		return mav;
	}

	/**
	 * Edit an existing Project entity
	 * 
	 */
	@RequestMapping("/editProjecttemplateProject")
	public ModelAndView editProjecttemplateProject(@RequestParam Integer projecttemplate_templateId, @RequestParam Integer project_projectId) {
		Project project = projectDAO.findProjectByPrimaryKey(project_projectId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("projecttemplate_templateId", projecttemplate_templateId);
		mav.addObject("project", project);
		mav.setViewName("projecttemplate/project/editProject.jsp");

		return mav;
	}

	/**
	 * Edit an existing Projecttemplate entity
	 * 
	 */
	@RequestMapping("/editProjecttemplate")
	public ModelAndView editProjecttemplate(@RequestParam Integer templateIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("projecttemplate", projecttemplateDAO.findProjecttemplateByPrimaryKey(templateIdKey));
		mav.setViewName("projecttemplate/editProjecttemplate.jsp");

		return mav;
	}

	/**
	 * Create a new Projecttemplate entity
	 * 
	 */
	@RequestMapping("/newProjecttemplate")
	public ModelAndView newProjecttemplate() {
		ModelAndView mav = new ModelAndView();

		mav.addObject("projecttemplate", new Projecttemplate());
		mav.addObject("newFlag", true);
		mav.setViewName("projecttemplate/editProjecttemplate.jsp");

		return mav;
	}

	/**
	 */
	@RequestMapping("/projecttemplateController/binary.action")
	public ModelAndView streamBinary(@ModelAttribute HttpServletRequest request, @ModelAttribute HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("streamedBinaryContentView");
		return mav;

	}

	/**
	 * Save an existing Projecttemplate entity
	 * 
	 */
	@RequestMapping("/saveProjecttemplate")
	public String saveProjecttemplate(@ModelAttribute Projecttemplate projecttemplate) {
		projecttemplateService.saveProjecttemplate(projecttemplate);
		return "forward:/indexProjecttemplate";
	}

	/**
	 * Select the child Project entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteProjecttemplateProject")
	public ModelAndView confirmDeleteProjecttemplateProject(@RequestParam Integer projecttemplate_templateId, @RequestParam Integer related_project_projectId) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("project", projectDAO.findProjectByPrimaryKey(related_project_projectId));
		mav.addObject("projecttemplate_templateId", projecttemplate_templateId);
		mav.setViewName("projecttemplate/project/deleteProject.jsp");

		return mav;
	}

	/**
	 * Entry point to show all Projecttemplate entities
	 * 
	 */
	public String indexProjecttemplate() {
		return "redirect:/indexProjecttemplate";
	}

	/**
	 * Save an existing Project entity
	 * 
	 */
	@RequestMapping("/saveProjecttemplateProject")
	public ModelAndView saveProjecttemplateProject(@RequestParam Integer projecttemplate_templateId, @ModelAttribute Project project) {
		Projecttemplate parent_projecttemplate = projecttemplateService.saveProjecttemplateProject(projecttemplate_templateId, project);

		ModelAndView mav = new ModelAndView();
		mav.addObject("projecttemplate_templateId", projecttemplate_templateId);
		mav.addObject("projecttemplate", parent_projecttemplate);
		mav.setViewName("projecttemplate/viewProjecttemplate.jsp");

		return mav;
	}

	/**
	 * Edit an existing Account entity
	 * 
	 */
	@RequestMapping("/editProjecttemplateAccount")
	public ModelAndView editProjecttemplateAccount(@RequestParam Integer projecttemplate_templateId, @RequestParam Integer account_accountId) {
		Account account = accountDAO.findAccountByPrimaryKey(account_accountId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("projecttemplate_templateId", projecttemplate_templateId);
		mav.addObject("account", account);
		mav.setViewName("projecttemplate/account/editAccount.jsp");

		return mav;
	}

	/**
	 * Save an existing Account entity
	 * 
	 */
	@RequestMapping("/saveProjecttemplateAccount")
	public ModelAndView saveProjecttemplateAccount(@RequestParam Integer projecttemplate_templateId, @ModelAttribute Account account) {
		Projecttemplate parent_projecttemplate = projecttemplateService.saveProjecttemplateAccount(projecttemplate_templateId, account);

		ModelAndView mav = new ModelAndView();
		mav.addObject("projecttemplate_templateId", projecttemplate_templateId);
		mav.addObject("projecttemplate", parent_projecttemplate);
		mav.setViewName("projecttemplate/viewProjecttemplate.jsp");

		return mav;
	}

	/**
	 * View an existing Account entity
	 * 
	 */
	@RequestMapping("/selectProjecttemplateAccount")
	public ModelAndView selectProjecttemplateAccount(@RequestParam Integer projecttemplate_templateId, @RequestParam Integer account_accountId) {
		Account account = accountDAO.findAccountByPrimaryKey(account_accountId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("projecttemplate_templateId", projecttemplate_templateId);
		mav.addObject("account", account);
		mav.setViewName("projecttemplate/account/viewAccount.jsp");

		return mav;
	}

	/**
	 * Show all Projecttemplate entities
	 * 
	 */
	@RequestMapping("/indexProjecttemplate")
	public ModelAndView listProjecttemplates() {
		ModelAndView mav = new ModelAndView();

		mav.addObject("projecttemplates", projecttemplateService.loadProjecttemplates());

		mav.setViewName("projecttemplate/listProjecttemplates.jsp");

		return mav;
	}

	/**
	 * Delete an existing Account entity
	 * 
	 */
	@RequestMapping("/deleteProjecttemplateAccount")
	public ModelAndView deleteProjecttemplateAccount(@RequestParam Integer projecttemplate_templateId, @RequestParam Integer related_account_accountId) {
		ModelAndView mav = new ModelAndView();

		Projecttemplate projecttemplate = projecttemplateService.deleteProjecttemplateAccount(projecttemplate_templateId, related_account_accountId);

		mav.addObject("projecttemplate_templateId", projecttemplate_templateId);
		mav.addObject("projecttemplate", projecttemplate);
		mav.setViewName("projecttemplate/viewProjecttemplate.jsp");

		return mav;
	}

	/**
	 * Select the Projecttemplate entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteProjecttemplate")
	public ModelAndView confirmDeleteProjecttemplate(@RequestParam Integer templateIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("projecttemplate", projecttemplateDAO.findProjecttemplateByPrimaryKey(templateIdKey));
		mav.setViewName("projecttemplate/deleteProjecttemplate.jsp");

		return mav;
	}

	/**
	 * Delete an existing Project entity
	 * 
	 */
	@RequestMapping("/deleteProjecttemplateProject")
	public ModelAndView deleteProjecttemplateProject(@RequestParam Integer projecttemplate_templateId, @RequestParam Integer related_project_projectId) {
		ModelAndView mav = new ModelAndView();

		Projecttemplate projecttemplate = projecttemplateService.deleteProjecttemplateProject(projecttemplate_templateId, related_project_projectId);

		mav.addObject("projecttemplate_templateId", projecttemplate_templateId);
		mav.addObject("projecttemplate", projecttemplate);
		mav.setViewName("projecttemplate/viewProjecttemplate.jsp");

		return mav;
	}

	/**
	 * Select an existing Projecttemplate entity
	 * 
	 */
	@RequestMapping("/selectProjecttemplate")
	public ModelAndView selectProjecttemplate(@RequestParam Integer templateIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("projecttemplate", projecttemplateDAO.findProjecttemplateByPrimaryKey(templateIdKey));
		mav.setViewName("projecttemplate/viewProjecttemplate.jsp");

		return mav;
	}

	/**
	 * View an existing Project entity
	 * 
	 */
	@RequestMapping("/selectProjecttemplateProject")
	public ModelAndView selectProjecttemplateProject(@RequestParam Integer projecttemplate_templateId, @RequestParam Integer project_projectId) {
		Project project = projectDAO.findProjectByPrimaryKey(project_projectId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("projecttemplate_templateId", projecttemplate_templateId);
		mav.addObject("project", project);
		mav.setViewName("projecttemplate/project/viewProject.jsp");

		return mav;
	}
}