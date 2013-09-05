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
import pm7.dao.AttachmentDAO;
import pm7.dao.ClientDAO;
import pm7.dao.PersonDAO;
import pm7.dao.ProjectDAO;
import pm7.dao.ProjectteamDAO;
import pm7.dao.StatusupdateDAO;
import pm7.dao.TaskDAO;
import pm7.dao.TimeentryDAO;

import pm7.domain.Account;
import pm7.domain.Attachment;
import pm7.domain.Client;
import pm7.domain.Person;
import pm7.domain.Project;
import pm7.domain.Projectteam;
import pm7.domain.Statusupdate;
import pm7.domain.Task;
import pm7.domain.Timeentry;

import pm7.service.PersonService;

/**
 * Spring MVC controller that handles CRUD requests for Person entities
 * 
 */

@Controller("PersonController")
public class PersonController {

	/**
	 * DAO injected by Spring that manages Account entities
	 * 
	 */
	@Autowired
	private AccountDAO accountDAO;

	/**
	 * DAO injected by Spring that manages Attachment entities
	 * 
	 */
	@Autowired
	private AttachmentDAO attachmentDAO;

	/**
	 * DAO injected by Spring that manages Client entities
	 * 
	 */
	@Autowired
	private ClientDAO clientDAO;

	/**
	 * DAO injected by Spring that manages Person entities
	 * 
	 */
	@Autowired
	private PersonDAO personDAO;

	/**
	 * DAO injected by Spring that manages Project entities
	 * 
	 */
	@Autowired
	private ProjectDAO projectDAO;

	/**
	 * DAO injected by Spring that manages Projectteam entities
	 * 
	 */
	@Autowired
	private ProjectteamDAO projectteamDAO;

	/**
	 * DAO injected by Spring that manages Statusupdate entities
	 * 
	 */
	@Autowired
	private StatusupdateDAO statusupdateDAO;

	/**
	 * DAO injected by Spring that manages Task entities
	 * 
	 */
	@Autowired
	private TaskDAO taskDAO;

	/**
	 * DAO injected by Spring that manages Timeentry entities
	 * 
	 */
	@Autowired
	private TimeentryDAO timeentryDAO;

	/**
	 * Service injected by Spring that provides CRUD operations for Person entities
	 * 
	 */
	@Autowired
	private PersonService personService;

	/**
	 * Create a new Project entity
	 * 
	 */
	@RequestMapping("/newPersonProjectsForFkContactPersonId")
	public ModelAndView newPersonProjectsForFkContactPersonId(@RequestParam Integer person_personId) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("person_personId", person_personId);
		mav.addObject("project", new Project());
		mav.addObject("newFlag", true);
		mav.setViewName("person/projectsforfkcontactpersonid/editProjectsForFkContactPersonId.jsp");

		return mav;
	}

	/**
	 * Create a new Client entity
	 * 
	 */
	@RequestMapping("/newPersonClient")
	public ModelAndView newPersonClient(@RequestParam Integer person_personId) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("person_personId", person_personId);
		mav.addObject("client", new Client());
		mav.addObject("newFlag", true);
		mav.setViewName("person/client/editClient.jsp");

		return mav;
	}

	/**
	 * Create a new Project entity
	 * 
	 */
	@RequestMapping("/newPersonProjectsForFkProjMgrId")
	public ModelAndView newPersonProjectsForFkProjMgrId(@RequestParam Integer person_personId) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("person_personId", person_personId);
		mav.addObject("project", new Project());
		mav.addObject("newFlag", true);
		mav.setViewName("person/projectsforfkprojmgrid/editProjectsForFkProjMgrId.jsp");

		return mav;
	}

	/**
	 * Create a new Task entity
	 * 
	 */
	@RequestMapping("/newPersonTasks")
	public ModelAndView newPersonTasks(@RequestParam Integer person_personId) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("person_personId", person_personId);
		mav.addObject("task", new Task());
		mav.addObject("newFlag", true);
		mav.setViewName("person/tasks/editTasks.jsp");

		return mav;
	}

	/**
	 * Show all Account entities by Person
	 * 
	 */
	@RequestMapping("/listPersonAccount")
	public ModelAndView listPersonAccount(@RequestParam Integer personIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("person", personDAO.findPersonByPrimaryKey(personIdKey));
		mav.setViewName("person/account/listAccount.jsp");

		return mav;
	}

	/**
	 * Save an existing Project entity
	 * 
	 */
	@RequestMapping("/savePersonProjectsForFkContactPersonId")
	public ModelAndView savePersonProjectsForFkContactPersonId(@RequestParam Integer person_personId, @ModelAttribute Project projectsforfkcontactpersonid) {
		Person parent_person = personService.savePersonProjectsForFkContactPersonId(person_personId, projectsforfkcontactpersonid);

		ModelAndView mav = new ModelAndView();
		mav.addObject("person_personId", person_personId);
		mav.addObject("person", parent_person);
		mav.setViewName("person/viewPerson.jsp");

		return mav;
	}

	/**
	 * Edit an existing Client entity
	 * 
	 */
	@RequestMapping("/editPersonClient")
	public ModelAndView editPersonClient(@RequestParam Integer person_personId, @RequestParam Integer client_clientId) {
		Client client = clientDAO.findClientByPrimaryKey(client_clientId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("person_personId", person_personId);
		mav.addObject("client", client);
		mav.setViewName("person/client/editClient.jsp");

		return mav;
	}

	/**
	 * Edit an existing Account entity
	 * 
	 */
	@RequestMapping("/editPersonAccount")
	public ModelAndView editPersonAccount(@RequestParam Integer person_personId, @RequestParam Integer account_accountId) {
		Account account = accountDAO.findAccountByPrimaryKey(account_accountId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("person_personId", person_personId);
		mav.addObject("account", account);
		mav.setViewName("person/account/editAccount.jsp");

		return mav;
	}

	/**
	 * Show all Account entities by Person
	 * 
	 */
	@RequestMapping("/listPersonAccounts")
	public ModelAndView listPersonAccounts(@RequestParam Integer personIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("person", personDAO.findPersonByPrimaryKey(personIdKey));
		mav.setViewName("person/accounts/listAccounts.jsp");

		return mav;
	}

	/**
	 * Select the child Account entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeletePersonAccounts")
	public ModelAndView confirmDeletePersonAccounts(@RequestParam Integer person_personId, @RequestParam Integer related_accounts_accountId) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("account", accountDAO.findAccountByPrimaryKey(related_accounts_accountId));
		mav.addObject("person_personId", person_personId);
		mav.setViewName("person/accounts/deleteAccounts.jsp");

		return mav;
	}

	/**
	 * Create a new Projectteam entity
	 * 
	 */
	@RequestMapping("/newPersonProjectteams")
	public ModelAndView newPersonProjectteams(@RequestParam Integer person_personId) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("person_personId", person_personId);
		mav.addObject("projectteam", new Projectteam());
		mav.addObject("newFlag", true);
		mav.setViewName("person/projectteams/editProjectteams.jsp");

		return mav;
	}

	/**
	 * Edit an existing Project entity
	 * 
	 */
	@RequestMapping("/editPersonProjectsForFkContactPersonId")
	public ModelAndView editPersonProjectsForFkContactPersonId(@RequestParam Integer person_personId, @RequestParam Integer projectsforfkcontactpersonid_projectId) {
		Project project = projectDAO.findProjectByPrimaryKey(projectsforfkcontactpersonid_projectId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("person_personId", person_personId);
		mav.addObject("project", project);
		mav.setViewName("person/projectsforfkcontactpersonid/editProjectsForFkContactPersonId.jsp");

		return mav;
	}

	/**
	 * Save an existing Client entity
	 * 
	 */
	@RequestMapping("/savePersonClients")
	public ModelAndView savePersonClients(@RequestParam Integer person_personId, @ModelAttribute Client clients) {
		Person parent_person = personService.savePersonClients(person_personId, clients);

		ModelAndView mav = new ModelAndView();
		mav.addObject("person_personId", person_personId);
		mav.addObject("person", parent_person);
		mav.setViewName("person/viewPerson.jsp");

		return mav;
	}

	/**
	 * Show all Client entities by Person
	 * 
	 */
	@RequestMapping("/listPersonClient")
	public ModelAndView listPersonClient(@RequestParam Integer personIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("person", personDAO.findPersonByPrimaryKey(personIdKey));
		mav.setViewName("person/client/listClient.jsp");

		return mav;
	}

	/**
	 * Show all Statusupdate entities by Person
	 * 
	 */
	@RequestMapping("/listPersonStatusupdates")
	public ModelAndView listPersonStatusupdates(@RequestParam Integer personIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("person", personDAO.findPersonByPrimaryKey(personIdKey));
		mav.setViewName("person/statusupdates/listStatusupdates.jsp");

		return mav;
	}

	/**
	 * Delete an existing Person entity
	 * 
	 */
	@RequestMapping("/deletePerson")
	public String deletePerson(@RequestParam Integer personIdKey) {
		Person person = personDAO.findPersonByPrimaryKey(personIdKey);
		personService.deletePerson(person);
		return "forward:/indexPerson";
	}

	/**
	 * Show all Projectteam entities by Person
	 * 
	 */
	@RequestMapping("/listPersonProjectteams")
	public ModelAndView listPersonProjectteams(@RequestParam Integer personIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("person", personDAO.findPersonByPrimaryKey(personIdKey));
		mav.setViewName("person/projectteams/listProjectteams.jsp");

		return mav;
	}

	/**
	 * Save an existing Task entity
	 * 
	 */
	@RequestMapping("/savePersonTasks")
	public ModelAndView savePersonTasks(@RequestParam Integer person_personId, @ModelAttribute Task tasks) {
		Person parent_person = personService.savePersonTasks(person_personId, tasks);

		ModelAndView mav = new ModelAndView();
		mav.addObject("person_personId", person_personId);
		mav.addObject("person", parent_person);
		mav.setViewName("person/viewPerson.jsp");

		return mav;
	}

	/**
	 * Delete an existing Client entity
	 * 
	 */
	@RequestMapping("/deletePersonClient")
	public ModelAndView deletePersonClient(@RequestParam Integer person_personId, @RequestParam Integer related_client_clientId) {
		ModelAndView mav = new ModelAndView();

		Person person = personService.deletePersonClient(person_personId, related_client_clientId);

		mav.addObject("person_personId", person_personId);
		mav.addObject("person", person);
		mav.setViewName("person/viewPerson.jsp");

		return mav;
	}

	/**
	 * Edit an existing Statusupdate entity
	 * 
	 */
	@RequestMapping("/editPersonStatusupdates")
	public ModelAndView editPersonStatusupdates(@RequestParam Integer person_personId, @RequestParam Integer statusupdates_statusId) {
		Statusupdate statusupdate = statusupdateDAO.findStatusupdateByPrimaryKey(statusupdates_statusId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("person_personId", person_personId);
		mav.addObject("statusupdate", statusupdate);
		mav.setViewName("person/statusupdates/editStatusupdates.jsp");

		return mav;
	}

	/**
	 * Show all Timeentry entities by Person
	 * 
	 */
	@RequestMapping("/listPersonTimeentries")
	public ModelAndView listPersonTimeentries(@RequestParam Integer personIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("person", personDAO.findPersonByPrimaryKey(personIdKey));
		mav.setViewName("person/timeentries/listTimeentries.jsp");

		return mav;
	}

	/**
	 * Show all Task entities by Person
	 * 
	 */
	@RequestMapping("/listPersonTasks")
	public ModelAndView listPersonTasks(@RequestParam Integer personIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("person", personDAO.findPersonByPrimaryKey(personIdKey));
		mav.setViewName("person/tasks/listTasks.jsp");

		return mav;
	}

	/**
	 * View an existing Projectteam entity
	 * 
	 */
	@RequestMapping("/selectPersonProjectteams")
	public ModelAndView selectPersonProjectteams(@RequestParam Integer person_personId, @RequestParam Integer projectteams_projectTeamId) {
		Projectteam projectteam = projectteamDAO.findProjectteamByPrimaryKey(projectteams_projectTeamId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("person_personId", person_personId);
		mav.addObject("projectteam", projectteam);
		mav.setViewName("person/projectteams/viewProjectteams.jsp");

		return mav;
	}

	/**
	 * Create a new Client entity
	 * 
	 */
	@RequestMapping("/newPersonClients")
	public ModelAndView newPersonClients(@RequestParam Integer person_personId) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("person_personId", person_personId);
		mav.addObject("client", new Client());
		mav.addObject("newFlag", true);
		mav.setViewName("person/clients/editClients.jsp");

		return mav;
	}

	/**
	 * Edit an existing Client entity
	 * 
	 */
	@RequestMapping("/editPersonClients")
	public ModelAndView editPersonClients(@RequestParam Integer person_personId, @RequestParam Integer clients_clientId) {
		Client client = clientDAO.findClientByPrimaryKey(clients_clientId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("person_personId", person_personId);
		mav.addObject("client", client);
		mav.setViewName("person/clients/editClients.jsp");

		return mav;
	}

	/**
	 * Edit an existing Project entity
	 * 
	 */
	@RequestMapping("/editPersonProjectsForFkProjMgrId")
	public ModelAndView editPersonProjectsForFkProjMgrId(@RequestParam Integer person_personId, @RequestParam Integer projectsforfkprojmgrid_projectId) {
		Project project = projectDAO.findProjectByPrimaryKey(projectsforfkprojmgrid_projectId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("person_personId", person_personId);
		mav.addObject("project", project);
		mav.setViewName("person/projectsforfkprojmgrid/editProjectsForFkProjMgrId.jsp");

		return mav;
	}

	/**
	 * Create a new Timeentry entity
	 * 
	 */
	@RequestMapping("/newPersonTimeentries")
	public ModelAndView newPersonTimeentries(@RequestParam Integer person_personId) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("person_personId", person_personId);
		mav.addObject("timeentry", new Timeentry());
		mav.addObject("newFlag", true);
		mav.setViewName("person/timeentries/editTimeentries.jsp");

		return mav;
	}

	/**
	 * View an existing Timeentry entity
	 * 
	 */
	@RequestMapping("/selectPersonTimeentries")
	public ModelAndView selectPersonTimeentries(@RequestParam Integer person_personId, @RequestParam Integer timeentries_timeEntryId) {
		Timeentry timeentry = timeentryDAO.findTimeentryByPrimaryKey(timeentries_timeEntryId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("person_personId", person_personId);
		mav.addObject("timeentry", timeentry);
		mav.setViewName("person/timeentries/viewTimeentries.jsp");

		return mav;
	}

	/**
	 * View an existing Project entity
	 * 
	 */
	@RequestMapping("/selectPersonProjectsForFkProjMgrId")
	public ModelAndView selectPersonProjectsForFkProjMgrId(@RequestParam Integer person_personId, @RequestParam Integer projectsforfkprojmgrid_projectId) {
		Project project = projectDAO.findProjectByPrimaryKey(projectsforfkprojmgrid_projectId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("person_personId", person_personId);
		mav.addObject("project", project);
		mav.setViewName("person/projectsforfkprojmgrid/viewProjectsForFkProjMgrId.jsp");

		return mav;
	}

	/**
	 * Delete an existing Project entity
	 * 
	 */
	@RequestMapping("/deletePersonProjectsForFkProjMgrId")
	public ModelAndView deletePersonProjectsForFkProjMgrId(@RequestParam Integer person_personId, @RequestParam Integer related_projectsforfkprojmgrid_projectId) {
		ModelAndView mav = new ModelAndView();

		Person person = personService.deletePersonProjectsForFkProjMgrId(person_personId, related_projectsforfkprojmgrid_projectId);

		mav.addObject("person_personId", person_personId);
		mav.addObject("person", person);
		mav.setViewName("person/viewPerson.jsp");

		return mav;
	}

	/**
	 * Select the child Timeentry entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeletePersonTimeentries")
	public ModelAndView confirmDeletePersonTimeentries(@RequestParam Integer person_personId, @RequestParam Integer related_timeentries_timeEntryId) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("timeentry", timeentryDAO.findTimeentryByPrimaryKey(related_timeentries_timeEntryId));
		mav.addObject("person_personId", person_personId);
		mav.setViewName("person/timeentries/deleteTimeentries.jsp");

		return mav;
	}

	/**
	 * View an existing Attachment entity
	 * 
	 */
	@RequestMapping("/selectPersonAttachments")
	public ModelAndView selectPersonAttachments(@RequestParam Integer person_personId, @RequestParam Integer attachments_attachId) {
		Attachment attachment = attachmentDAO.findAttachmentByPrimaryKey(attachments_attachId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("person_personId", person_personId);
		mav.addObject("attachment", attachment);
		mav.setViewName("person/attachments/viewAttachments.jsp");

		return mav;
	}

	/**
	 * Select the child Task entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeletePersonTasks")
	public ModelAndView confirmDeletePersonTasks(@RequestParam Integer person_personId, @RequestParam Integer related_tasks_taskId) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("task", taskDAO.findTaskByPrimaryKey(related_tasks_taskId));
		mav.addObject("person_personId", person_personId);
		mav.setViewName("person/tasks/deleteTasks.jsp");

		return mav;
	}

	/**
	 * Edit an existing Task entity
	 * 
	 */
	@RequestMapping("/editPersonTasks")
	public ModelAndView editPersonTasks(@RequestParam Integer person_personId, @RequestParam Integer tasks_taskId) {
		Task task = taskDAO.findTaskByPrimaryKey(tasks_taskId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("person_personId", person_personId);
		mav.addObject("task", task);
		mav.setViewName("person/tasks/editTasks.jsp");

		return mav;
	}

	/**
	 * Show all Project entities by Person
	 * 
	 */
	@RequestMapping("/listPersonProjectsForFkContactPersonId")
	public ModelAndView listPersonProjectsForFkContactPersonId(@RequestParam Integer personIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("person", personDAO.findPersonByPrimaryKey(personIdKey));
		mav.setViewName("person/projectsforfkcontactpersonid/listProjectsForFkContactPersonId.jsp");

		return mav;
	}

	/**
	 * Save an existing Client entity
	 * 
	 */
	@RequestMapping("/savePersonClient")
	public ModelAndView savePersonClient(@RequestParam Integer person_personId, @ModelAttribute Client client) {
		Person parent_person = personService.savePersonClient(person_personId, client);

		ModelAndView mav = new ModelAndView();
		mav.addObject("person_personId", person_personId);
		mav.addObject("person", parent_person);
		mav.setViewName("person/viewPerson.jsp");

		return mav;
	}

	/**
	 * Save an existing Attachment entity
	 * 
	 */
	@RequestMapping("/savePersonAttachments")
	public ModelAndView savePersonAttachments(@RequestParam Integer person_personId, @ModelAttribute Attachment attachments) {
		Person parent_person = personService.savePersonAttachments(person_personId, attachments);

		ModelAndView mav = new ModelAndView();
		mav.addObject("person_personId", person_personId);
		mav.addObject("person", parent_person);
		mav.setViewName("person/viewPerson.jsp");

		return mav;
	}

	/**
	 * Edit an existing Person entity
	 * 
	 */
	@RequestMapping("/editPerson")
	public ModelAndView editPerson(@RequestParam Integer personIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("person", personDAO.findPersonByPrimaryKey(personIdKey));
		mav.setViewName("person/editPerson.jsp");

		return mav;
	}

	/**
	 * Delete an existing Attachment entity
	 * 
	 */
	@RequestMapping("/deletePersonAttachments")
	public ModelAndView deletePersonAttachments(@RequestParam Integer person_personId, @RequestParam Integer related_attachments_attachId) {
		ModelAndView mav = new ModelAndView();

		Person person = personService.deletePersonAttachments(person_personId, related_attachments_attachId);

		mav.addObject("person_personId", person_personId);
		mav.addObject("person", person);
		mav.setViewName("person/viewPerson.jsp");

		return mav;
	}

	/**
	 * Delete an existing Statusupdate entity
	 * 
	 */
	@RequestMapping("/deletePersonStatusupdates")
	public ModelAndView deletePersonStatusupdates(@RequestParam Integer person_personId, @RequestParam Integer related_statusupdates_statusId) {
		ModelAndView mav = new ModelAndView();

		Person person = personService.deletePersonStatusupdates(person_personId, related_statusupdates_statusId);

		mav.addObject("person_personId", person_personId);
		mav.addObject("person", person);
		mav.setViewName("person/viewPerson.jsp");

		return mav;
	}

	/**
	 * Show all Person entities
	 * 
	 */
	@RequestMapping("/indexPerson")
	public ModelAndView listPersons() {
		ModelAndView mav = new ModelAndView();

		mav.addObject("persons", personService.loadPersons());

		mav.setViewName("person/listPersons.jsp");

		return mav;
	}

	/**
	 * View an existing Client entity
	 * 
	 */
	@RequestMapping("/selectPersonClients")
	public ModelAndView selectPersonClients(@RequestParam Integer person_personId, @RequestParam Integer clients_clientId) {
		Client client = clientDAO.findClientByPrimaryKey(clients_clientId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("person_personId", person_personId);
		mav.addObject("client", client);
		mav.setViewName("person/clients/viewClients.jsp");

		return mav;
	}

	/**
	 * Edit an existing Account entity
	 * 
	 */
	@RequestMapping("/editPersonAccounts")
	public ModelAndView editPersonAccounts(@RequestParam Integer person_personId, @RequestParam Integer accounts_accountId) {
		Account account = accountDAO.findAccountByPrimaryKey(accounts_accountId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("person_personId", person_personId);
		mav.addObject("account", account);
		mav.setViewName("person/accounts/editAccounts.jsp");

		return mav;
	}

	/**
	 * Delete an existing Timeentry entity
	 * 
	 */
	@RequestMapping("/deletePersonTimeentries")
	public ModelAndView deletePersonTimeentries(@RequestParam Integer person_personId, @RequestParam Integer related_timeentries_timeEntryId) {
		ModelAndView mav = new ModelAndView();

		Person person = personService.deletePersonTimeentries(person_personId, related_timeentries_timeEntryId);

		mav.addObject("person_personId", person_personId);
		mav.addObject("person", person);
		mav.setViewName("person/viewPerson.jsp");

		return mav;
	}

	/**
	 * View an existing Task entity
	 * 
	 */
	@RequestMapping("/selectPersonTasks")
	public ModelAndView selectPersonTasks(@RequestParam Integer person_personId, @RequestParam Integer tasks_taskId) {
		Task task = taskDAO.findTaskByPrimaryKey(tasks_taskId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("person_personId", person_personId);
		mav.addObject("task", task);
		mav.setViewName("person/tasks/viewTasks.jsp");

		return mav;
	}

	/**
	 * Edit an existing Projectteam entity
	 * 
	 */
	@RequestMapping("/editPersonProjectteams")
	public ModelAndView editPersonProjectteams(@RequestParam Integer person_personId, @RequestParam Integer projectteams_projectTeamId) {
		Projectteam projectteam = projectteamDAO.findProjectteamByPrimaryKey(projectteams_projectTeamId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("person_personId", person_personId);
		mav.addObject("projectteam", projectteam);
		mav.setViewName("person/projectteams/editProjectteams.jsp");

		return mav;
	}

	/**
	 * Delete an existing Project entity
	 * 
	 */
	@RequestMapping("/deletePersonProjectsForFkContactPersonId")
	public ModelAndView deletePersonProjectsForFkContactPersonId(@RequestParam Integer person_personId, @RequestParam Integer related_projectsforfkcontactpersonid_projectId) {
		ModelAndView mav = new ModelAndView();

		Person person = personService.deletePersonProjectsForFkContactPersonId(person_personId, related_projectsforfkcontactpersonid_projectId);

		mav.addObject("person_personId", person_personId);
		mav.addObject("person", person);
		mav.setViewName("person/viewPerson.jsp");

		return mav;
	}

	/**
	 * Show all Client entities by Person
	 * 
	 */
	@RequestMapping("/listPersonClients")
	public ModelAndView listPersonClients(@RequestParam Integer personIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("person", personDAO.findPersonByPrimaryKey(personIdKey));
		mav.setViewName("person/clients/listClients.jsp");

		return mav;
	}

	/**
	 * Select the child Account entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeletePersonAccount")
	public ModelAndView confirmDeletePersonAccount(@RequestParam Integer person_personId, @RequestParam Integer related_account_accountId) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("account", accountDAO.findAccountByPrimaryKey(related_account_accountId));
		mav.addObject("person_personId", person_personId);
		mav.setViewName("person/account/deleteAccount.jsp");

		return mav;
	}

	/**
	 * Select the child Projectteam entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeletePersonProjectteams")
	public ModelAndView confirmDeletePersonProjectteams(@RequestParam Integer person_personId, @RequestParam Integer related_projectteams_projectTeamId) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("projectteam", projectteamDAO.findProjectteamByPrimaryKey(related_projectteams_projectTeamId));
		mav.addObject("person_personId", person_personId);
		mav.setViewName("person/projectteams/deleteProjectteams.jsp");

		return mav;
	}

	/**
	 * Select the child Project entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeletePersonProjectsForFkProjMgrId")
	public ModelAndView confirmDeletePersonProjectsForFkProjMgrId(@RequestParam Integer person_personId, @RequestParam Integer related_projectsforfkprojmgrid_projectId) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("project", projectDAO.findProjectByPrimaryKey(related_projectsforfkprojmgrid_projectId));
		mav.addObject("person_personId", person_personId);
		mav.setViewName("person/projectsforfkprojmgrid/deleteProjectsForFkProjMgrId.jsp");

		return mav;
	}

	/**
	 * Select the child Attachment entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeletePersonAttachments")
	public ModelAndView confirmDeletePersonAttachments(@RequestParam Integer person_personId, @RequestParam Integer related_attachments_attachId) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("attachment", attachmentDAO.findAttachmentByPrimaryKey(related_attachments_attachId));
		mav.addObject("person_personId", person_personId);
		mav.setViewName("person/attachments/deleteAttachments.jsp");

		return mav;
	}

	/**
	 * Delete an existing Account entity
	 * 
	 */
	@RequestMapping("/deletePersonAccount")
	public ModelAndView deletePersonAccount(@RequestParam Integer person_personId, @RequestParam Integer related_account_accountId) {
		ModelAndView mav = new ModelAndView();

		Person person = personService.deletePersonAccount(person_personId, related_account_accountId);

		mav.addObject("person_personId", person_personId);
		mav.addObject("person", person);
		mav.setViewName("person/viewPerson.jsp");

		return mav;
	}

	/**
	 * View an existing Account entity
	 * 
	 */
	@RequestMapping("/selectPersonAccount")
	public ModelAndView selectPersonAccount(@RequestParam Integer person_personId, @RequestParam Integer account_accountId) {
		Account account = accountDAO.findAccountByPrimaryKey(account_accountId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("person_personId", person_personId);
		mav.addObject("account", account);
		mav.setViewName("person/account/viewAccount.jsp");

		return mav;
	}

	/**
	 * Edit an existing Timeentry entity
	 * 
	 */
	@RequestMapping("/editPersonTimeentries")
	public ModelAndView editPersonTimeentries(@RequestParam Integer person_personId, @RequestParam Integer timeentries_timeEntryId) {
		Timeentry timeentry = timeentryDAO.findTimeentryByPrimaryKey(timeentries_timeEntryId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("person_personId", person_personId);
		mav.addObject("timeentry", timeentry);
		mav.setViewName("person/timeentries/editTimeentries.jsp");

		return mav;
	}

	/**
	 */
	@RequestMapping("/personController/binary.action")
	public ModelAndView streamBinary(@ModelAttribute HttpServletRequest request, @ModelAttribute HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("streamedBinaryContentView");
		return mav;

	}

	/**
	 * View an existing Account entity
	 * 
	 */
	@RequestMapping("/selectPersonAccounts")
	public ModelAndView selectPersonAccounts(@RequestParam Integer person_personId, @RequestParam Integer accounts_accountId) {
		Account account = accountDAO.findAccountByPrimaryKey(accounts_accountId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("person_personId", person_personId);
		mav.addObject("account", account);
		mav.setViewName("person/accounts/viewAccounts.jsp");

		return mav;
	}

	/**
	 * Save an existing Timeentry entity
	 * 
	 */
	@RequestMapping("/savePersonTimeentries")
	public ModelAndView savePersonTimeentries(@RequestParam Integer person_personId, @ModelAttribute Timeentry timeentries) {
		Person parent_person = personService.savePersonTimeentries(person_personId, timeentries);

		ModelAndView mav = new ModelAndView();
		mav.addObject("person_personId", person_personId);
		mav.addObject("person", parent_person);
		mav.setViewName("person/viewPerson.jsp");

		return mav;
	}

	/**
	 * Select the child Statusupdate entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeletePersonStatusupdates")
	public ModelAndView confirmDeletePersonStatusupdates(@RequestParam Integer person_personId, @RequestParam Integer related_statusupdates_statusId) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("statusupdate", statusupdateDAO.findStatusupdateByPrimaryKey(related_statusupdates_statusId));
		mav.addObject("person_personId", person_personId);
		mav.setViewName("person/statusupdates/deleteStatusupdates.jsp");

		return mav;
	}

	/**
	 * Save an existing Projectteam entity
	 * 
	 */
	@RequestMapping("/savePersonProjectteams")
	public ModelAndView savePersonProjectteams(@RequestParam Integer person_personId, @ModelAttribute Projectteam projectteams) {
		Person parent_person = personService.savePersonProjectteams(person_personId, projectteams);

		ModelAndView mav = new ModelAndView();
		mav.addObject("person_personId", person_personId);
		mav.addObject("person", parent_person);
		mav.setViewName("person/viewPerson.jsp");

		return mav;
	}

	/**
	 * Entry point to show all Person entities
	 * 
	 */
	public String indexPerson() {
		return "redirect:/indexPerson";
	}

	/**
	 * Delete an existing Account entity
	 * 
	 */
	@RequestMapping("/deletePersonAccounts")
	public ModelAndView deletePersonAccounts(@RequestParam Integer person_personId, @RequestParam Integer related_accounts_accountId) {
		ModelAndView mav = new ModelAndView();

		Person person = personService.deletePersonAccounts(person_personId, related_accounts_accountId);

		mav.addObject("person_personId", person_personId);
		mav.addObject("person", person);
		mav.setViewName("person/viewPerson.jsp");

		return mav;
	}

	/**
	 * Create a new Statusupdate entity
	 * 
	 */
	@RequestMapping("/newPersonStatusupdates")
	public ModelAndView newPersonStatusupdates(@RequestParam Integer person_personId) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("person_personId", person_personId);
		mav.addObject("statusupdate", new Statusupdate());
		mav.addObject("newFlag", true);
		mav.setViewName("person/statusupdates/editStatusupdates.jsp");

		return mav;
	}

	/**
	 * Delete an existing Client entity
	 * 
	 */
	@RequestMapping("/deletePersonClients")
	public ModelAndView deletePersonClients(@RequestParam Integer person_personId, @RequestParam Integer related_clients_clientId) {
		ModelAndView mav = new ModelAndView();

		Person person = personService.deletePersonClients(person_personId, related_clients_clientId);

		mav.addObject("person_personId", person_personId);
		mav.addObject("person", person);
		mav.setViewName("person/viewPerson.jsp");

		return mav;
	}

	/**
	 * Edit an existing Attachment entity
	 * 
	 */
	@RequestMapping("/editPersonAttachments")
	public ModelAndView editPersonAttachments(@RequestParam Integer person_personId, @RequestParam Integer attachments_attachId) {
		Attachment attachment = attachmentDAO.findAttachmentByPrimaryKey(attachments_attachId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("person_personId", person_personId);
		mav.addObject("attachment", attachment);
		mav.setViewName("person/attachments/editAttachments.jsp");

		return mav;
	}

	/**
	 * Select the child Project entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeletePersonProjectsForFkContactPersonId")
	public ModelAndView confirmDeletePersonProjectsForFkContactPersonId(@RequestParam Integer person_personId, @RequestParam Integer related_projectsforfkcontactpersonid_projectId) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("project", projectDAO.findProjectByPrimaryKey(related_projectsforfkcontactpersonid_projectId));
		mav.addObject("person_personId", person_personId);
		mav.setViewName("person/projectsforfkcontactpersonid/deleteProjectsForFkContactPersonId.jsp");

		return mav;
	}

	/**
	 * Create a new Attachment entity
	 * 
	 */
	@RequestMapping("/newPersonAttachments")
	public ModelAndView newPersonAttachments(@RequestParam Integer person_personId) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("person_personId", person_personId);
		mav.addObject("attachment", new Attachment());
		mav.addObject("newFlag", true);
		mav.setViewName("person/attachments/editAttachments.jsp");

		return mav;
	}

	/**
	 * Save an existing Account entity
	 * 
	 */
	@RequestMapping("/savePersonAccounts")
	public ModelAndView savePersonAccounts(@RequestParam Integer person_personId, @ModelAttribute Account accounts) {
		Person parent_person = personService.savePersonAccounts(person_personId, accounts);

		ModelAndView mav = new ModelAndView();
		mav.addObject("person_personId", person_personId);
		mav.addObject("person", parent_person);
		mav.setViewName("person/viewPerson.jsp");

		return mav;
	}

	/**
	 * Create a new Account entity
	 * 
	 */
	@RequestMapping("/newPersonAccounts")
	public ModelAndView newPersonAccounts(@RequestParam Integer person_personId) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("person_personId", person_personId);
		mav.addObject("account", new Account());
		mav.addObject("newFlag", true);
		mav.setViewName("person/accounts/editAccounts.jsp");

		return mav;
	}

	/**
	 * Select the Person entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeletePerson")
	public ModelAndView confirmDeletePerson(@RequestParam Integer personIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("person", personDAO.findPersonByPrimaryKey(personIdKey));
		mav.setViewName("person/deletePerson.jsp");

		return mav;
	}

	/**
	 * View an existing Client entity
	 * 
	 */
	@RequestMapping("/selectPersonClient")
	public ModelAndView selectPersonClient(@RequestParam Integer person_personId, @RequestParam Integer client_clientId) {
		Client client = clientDAO.findClientByPrimaryKey(client_clientId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("person_personId", person_personId);
		mav.addObject("client", client);
		mav.setViewName("person/client/viewClient.jsp");

		return mav;
	}

	/**
	 * Select the child Client entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeletePersonClients")
	public ModelAndView confirmDeletePersonClients(@RequestParam Integer person_personId, @RequestParam Integer related_clients_clientId) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("client", clientDAO.findClientByPrimaryKey(related_clients_clientId));
		mav.addObject("person_personId", person_personId);
		mav.setViewName("person/clients/deleteClients.jsp");

		return mav;
	}

	/**
	 * Save an existing Statusupdate entity
	 * 
	 */
	@RequestMapping("/savePersonStatusupdates")
	public ModelAndView savePersonStatusupdates(@RequestParam Integer person_personId, @ModelAttribute Statusupdate statusupdates) {
		Person parent_person = personService.savePersonStatusupdates(person_personId, statusupdates);

		ModelAndView mav = new ModelAndView();
		mav.addObject("person_personId", person_personId);
		mav.addObject("person", parent_person);
		mav.setViewName("person/viewPerson.jsp");

		return mav;
	}

	/**
	 * Select the child Client entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeletePersonClient")
	public ModelAndView confirmDeletePersonClient(@RequestParam Integer person_personId, @RequestParam Integer related_client_clientId) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("client", clientDAO.findClientByPrimaryKey(related_client_clientId));
		mav.addObject("person_personId", person_personId);
		mav.setViewName("person/client/deleteClient.jsp");

		return mav;
	}

	/**
	 * Save an existing Account entity
	 * 
	 */
	@RequestMapping("/savePersonAccount")
	public ModelAndView savePersonAccount(@RequestParam Integer person_personId, @ModelAttribute Account account) {
		Person parent_person = personService.savePersonAccount(person_personId, account);

		ModelAndView mav = new ModelAndView();
		mav.addObject("person_personId", person_personId);
		mav.addObject("person", parent_person);
		mav.setViewName("person/viewPerson.jsp");

		return mav;
	}

	/**
	 * Show all Project entities by Person
	 * 
	 */
	@RequestMapping("/listPersonProjectsForFkProjMgrId")
	public ModelAndView listPersonProjectsForFkProjMgrId(@RequestParam Integer personIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("person", personDAO.findPersonByPrimaryKey(personIdKey));
		mav.setViewName("person/projectsforfkprojmgrid/listProjectsForFkProjMgrId.jsp");

		return mav;
	}

	/**
	 * Create a new Person entity
	 * 
	 */
	@RequestMapping("/newPerson")
	public ModelAndView newPerson() {
		ModelAndView mav = new ModelAndView();

		mav.addObject("person", new Person());
		mav.addObject("newFlag", true);
		mav.setViewName("person/editPerson.jsp");

		return mav;
	}

	/**
	 * View an existing Statusupdate entity
	 * 
	 */
	@RequestMapping("/selectPersonStatusupdates")
	public ModelAndView selectPersonStatusupdates(@RequestParam Integer person_personId, @RequestParam Integer statusupdates_statusId) {
		Statusupdate statusupdate = statusupdateDAO.findStatusupdateByPrimaryKey(statusupdates_statusId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("person_personId", person_personId);
		mav.addObject("statusupdate", statusupdate);
		mav.setViewName("person/statusupdates/viewStatusupdates.jsp");

		return mav;
	}

	/**
	 * Show all Attachment entities by Person
	 * 
	 */
	@RequestMapping("/listPersonAttachments")
	public ModelAndView listPersonAttachments(@RequestParam Integer personIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("person", personDAO.findPersonByPrimaryKey(personIdKey));
		mav.setViewName("person/attachments/listAttachments.jsp");

		return mav;
	}

	/**
	 * Delete an existing Projectteam entity
	 * 
	 */
	@RequestMapping("/deletePersonProjectteams")
	public ModelAndView deletePersonProjectteams(@RequestParam Integer person_personId, @RequestParam Integer related_projectteams_projectTeamId) {
		ModelAndView mav = new ModelAndView();

		Person person = personService.deletePersonProjectteams(person_personId, related_projectteams_projectTeamId);

		mav.addObject("person_personId", person_personId);
		mav.addObject("person", person);
		mav.setViewName("person/viewPerson.jsp");

		return mav;
	}

	/**
	 * View an existing Project entity
	 * 
	 */
	@RequestMapping("/selectPersonProjectsForFkContactPersonId")
	public ModelAndView selectPersonProjectsForFkContactPersonId(@RequestParam Integer person_personId, @RequestParam Integer projectsforfkcontactpersonid_projectId) {
		Project project = projectDAO.findProjectByPrimaryKey(projectsforfkcontactpersonid_projectId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("person_personId", person_personId);
		mav.addObject("project", project);
		mav.setViewName("person/projectsforfkcontactpersonid/viewProjectsForFkContactPersonId.jsp");

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
	 * Delete an existing Task entity
	 * 
	 */
	@RequestMapping("/deletePersonTasks")
	public ModelAndView deletePersonTasks(@RequestParam Integer person_personId, @RequestParam Integer related_tasks_taskId) {
		ModelAndView mav = new ModelAndView();

		Person person = personService.deletePersonTasks(person_personId, related_tasks_taskId);

		mav.addObject("person_personId", person_personId);
		mav.addObject("person", person);
		mav.setViewName("person/viewPerson.jsp");

		return mav;
	}

	/**
	 * Create a new Account entity
	 * 
	 */
	@RequestMapping("/newPersonAccount")
	public ModelAndView newPersonAccount(@RequestParam Integer person_personId) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("person_personId", person_personId);
		mav.addObject("account", new Account());
		mav.addObject("newFlag", true);
		mav.setViewName("person/account/editAccount.jsp");

		return mav;
	}

	/**
	 * Save an existing Person entity
	 * 
	 */
	@RequestMapping("/savePerson")
	public String savePerson(@ModelAttribute Person person) {
		personService.savePerson(person);
		return "forward:/indexPerson";
	}

	/**
	 * Save an existing Project entity
	 * 
	 */
	@RequestMapping("/savePersonProjectsForFkProjMgrId")
	public ModelAndView savePersonProjectsForFkProjMgrId(@RequestParam Integer person_personId, @ModelAttribute Project projectsforfkprojmgrid) {
		Person parent_person = personService.savePersonProjectsForFkProjMgrId(person_personId, projectsforfkprojmgrid);

		ModelAndView mav = new ModelAndView();
		mav.addObject("person_personId", person_personId);
		mav.addObject("person", parent_person);
		mav.setViewName("person/viewPerson.jsp");

		return mav;
	}

	/**
	 * Select an existing Person entity
	 * 
	 */
	@RequestMapping("/selectPerson")
	public ModelAndView selectPerson(@RequestParam Integer personIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("person", personDAO.findPersonByPrimaryKey(personIdKey));
		mav.setViewName("person/viewPerson.jsp");

		return mav;
	}
}