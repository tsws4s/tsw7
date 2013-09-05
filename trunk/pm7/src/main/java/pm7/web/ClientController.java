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
import pm7.dao.ClientDAO;
import pm7.dao.InvoiceDAO;
import pm7.dao.PersonDAO;
import pm7.dao.ProjectDAO;

import pm7.domain.Account;
import pm7.domain.Client;
import pm7.domain.Invoice;
import pm7.domain.Person;
import pm7.domain.Project;

import pm7.service.ClientService;

/**
 * Spring MVC controller that handles CRUD requests for Client entities
 * 
 */

@Controller("ClientController")
public class ClientController {

	/**
	 * DAO injected by Spring that manages Account entities
	 * 
	 */
	@Autowired
	private AccountDAO accountDAO;

	/**
	 * DAO injected by Spring that manages Client entities
	 * 
	 */
	@Autowired
	private ClientDAO clientDAO;

	/**
	 * DAO injected by Spring that manages Invoice entities
	 * 
	 */
	@Autowired
	private InvoiceDAO invoiceDAO;

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
	 * Service injected by Spring that provides CRUD operations for Client entities
	 * 
	 */
	@Autowired
	private ClientService clientService;

	/**
	 * Delete an existing Invoice entity
	 * 
	 */
	@RequestMapping("/deleteClientInvoices")
	public ModelAndView deleteClientInvoices(@RequestParam Integer client_clientId, @RequestParam Integer related_invoices_invoiceId) {
		ModelAndView mav = new ModelAndView();

		Client client = clientService.deleteClientInvoices(client_clientId, related_invoices_invoiceId);

		mav.addObject("client_clientId", client_clientId);
		mav.addObject("client", client);
		mav.setViewName("client/viewClient.jsp");

		return mav;
	}

	/**
	 * View an existing Invoice entity
	 * 
	 */
	@RequestMapping("/selectClientInvoices")
	public ModelAndView selectClientInvoices(@RequestParam Integer client_clientId, @RequestParam Integer invoices_invoiceId) {
		Invoice invoice = invoiceDAO.findInvoiceByPrimaryKey(invoices_invoiceId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("client_clientId", client_clientId);
		mav.addObject("invoice", invoice);
		mav.setViewName("client/invoices/viewInvoices.jsp");

		return mav;
	}

	/**
	 * Edit an existing Person entity
	 * 
	 */
	@RequestMapping("/editClientPersons")
	public ModelAndView editClientPersons(@RequestParam Integer client_clientId, @RequestParam Integer persons_personId) {
		Person person = personDAO.findPersonByPrimaryKey(persons_personId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("client_clientId", client_clientId);
		mav.addObject("person", person);
		mav.setViewName("client/persons/editPersons.jsp");

		return mav;
	}

	/**
	 * View an existing Project entity
	 * 
	 */
	@RequestMapping("/selectClientProjects")
	public ModelAndView selectClientProjects(@RequestParam Integer client_clientId, @RequestParam Integer projects_projectId) {
		Project project = projectDAO.findProjectByPrimaryKey(projects_projectId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("client_clientId", client_clientId);
		mav.addObject("project", project);
		mav.setViewName("client/projects/viewProjects.jsp");

		return mav;
	}

	/**
	 * View an existing Person entity
	 * 
	 */
	@RequestMapping("/selectClientPerson")
	public ModelAndView selectClientPerson(@RequestParam Integer client_clientId, @RequestParam Integer person_personId) {
		Person person = personDAO.findPersonByPrimaryKey(person_personId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("client_clientId", client_clientId);
		mav.addObject("person", person);
		mav.setViewName("client/person/viewPerson.jsp");

		return mav;
	}

	/**
	 * Edit an existing Person entity
	 * 
	 */
	@RequestMapping("/editClientPerson")
	public ModelAndView editClientPerson(@RequestParam Integer client_clientId, @RequestParam Integer person_personId) {
		Person person = personDAO.findPersonByPrimaryKey(person_personId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("client_clientId", client_clientId);
		mav.addObject("person", person);
		mav.setViewName("client/person/editPerson.jsp");

		return mav;
	}

	/**
	 * Select the child Invoice entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteClientInvoices")
	public ModelAndView confirmDeleteClientInvoices(@RequestParam Integer client_clientId, @RequestParam Integer related_invoices_invoiceId) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("invoice", invoiceDAO.findInvoiceByPrimaryKey(related_invoices_invoiceId));
		mav.addObject("client_clientId", client_clientId);
		mav.setViewName("client/invoices/deleteInvoices.jsp");

		return mav;
	}

	/**
	 * Show all Project entities by Client
	 * 
	 */
	@RequestMapping("/listClientProjects")
	public ModelAndView listClientProjects(@RequestParam Integer clientIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("client", clientDAO.findClientByPrimaryKey(clientIdKey));
		mav.setViewName("client/projects/listProjects.jsp");

		return mav;
	}

	/**
	 * Save an existing Person entity
	 * 
	 */
	@RequestMapping("/saveClientPerson")
	public ModelAndView saveClientPerson(@RequestParam Integer client_clientId, @ModelAttribute Person person) {
		Client parent_client = clientService.saveClientPerson(client_clientId, person);

		ModelAndView mav = new ModelAndView();
		mav.addObject("client_clientId", client_clientId);
		mav.addObject("client", parent_client);
		mav.setViewName("client/viewClient.jsp");

		return mav;
	}

	/**
	 * Select the child Person entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteClientPerson")
	public ModelAndView confirmDeleteClientPerson(@RequestParam Integer client_clientId, @RequestParam Integer related_person_personId) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("person", personDAO.findPersonByPrimaryKey(related_person_personId));
		mav.addObject("client_clientId", client_clientId);
		mav.setViewName("client/person/deletePerson.jsp");

		return mav;
	}

	/**
	 * Delete an existing Project entity
	 * 
	 */
	@RequestMapping("/deleteClientProjects")
	public ModelAndView deleteClientProjects(@RequestParam Integer client_clientId, @RequestParam Integer related_projects_projectId) {
		ModelAndView mav = new ModelAndView();

		Client client = clientService.deleteClientProjects(client_clientId, related_projects_projectId);

		mav.addObject("client_clientId", client_clientId);
		mav.addObject("client", client);
		mav.setViewName("client/viewClient.jsp");

		return mav;
	}

	/**
	 * Save an existing Person entity
	 * 
	 */
	@RequestMapping("/saveClientPersons")
	public ModelAndView saveClientPersons(@RequestParam Integer client_clientId, @ModelAttribute Person persons) {
		Client parent_client = clientService.saveClientPersons(client_clientId, persons);

		ModelAndView mav = new ModelAndView();
		mav.addObject("client_clientId", client_clientId);
		mav.addObject("client", parent_client);
		mav.setViewName("client/viewClient.jsp");

		return mav;
	}

	/**
	 * Save an existing Account entity
	 * 
	 */
	@RequestMapping("/saveClientAccount")
	public ModelAndView saveClientAccount(@RequestParam Integer client_clientId, @ModelAttribute Account account) {
		Client parent_client = clientService.saveClientAccount(client_clientId, account);

		ModelAndView mav = new ModelAndView();
		mav.addObject("client_clientId", client_clientId);
		mav.addObject("client", parent_client);
		mav.setViewName("client/viewClient.jsp");

		return mav;
	}

	/**
	 * Save an existing Project entity
	 * 
	 */
	@RequestMapping("/saveClientProjects")
	public ModelAndView saveClientProjects(@RequestParam Integer client_clientId, @ModelAttribute Project projects) {
		Client parent_client = clientService.saveClientProjects(client_clientId, projects);

		ModelAndView mav = new ModelAndView();
		mav.addObject("client_clientId", client_clientId);
		mav.addObject("client", parent_client);
		mav.setViewName("client/viewClient.jsp");

		return mav;
	}

	/**
	 * Select the Client entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteClient")
	public ModelAndView confirmDeleteClient(@RequestParam Integer clientIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("client", clientDAO.findClientByPrimaryKey(clientIdKey));
		mav.setViewName("client/deleteClient.jsp");

		return mav;
	}

	/**
	 * Create a new Person entity
	 * 
	 */
	@RequestMapping("/newClientPerson")
	public ModelAndView newClientPerson(@RequestParam Integer client_clientId) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("client_clientId", client_clientId);
		mav.addObject("person", new Person());
		mav.addObject("newFlag", true);
		mav.setViewName("client/person/editPerson.jsp");

		return mav;
	}

	/**
	 * Create a new Person entity
	 * 
	 */
	@RequestMapping("/newClientPersons")
	public ModelAndView newClientPersons(@RequestParam Integer client_clientId) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("client_clientId", client_clientId);
		mav.addObject("person", new Person());
		mav.addObject("newFlag", true);
		mav.setViewName("client/persons/editPersons.jsp");

		return mav;
	}

	/**
	 * Delete an existing Client entity
	 * 
	 */
	@RequestMapping("/deleteClient")
	public String deleteClient(@RequestParam Integer clientIdKey) {
		Client client = clientDAO.findClientByPrimaryKey(clientIdKey);
		clientService.deleteClient(client);
		return "forward:/indexClient";
	}

	/**
	 * Select the child Account entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteClientAccount")
	public ModelAndView confirmDeleteClientAccount(@RequestParam Integer client_clientId, @RequestParam Integer related_account_accountId) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("account", accountDAO.findAccountByPrimaryKey(related_account_accountId));
		mav.addObject("client_clientId", client_clientId);
		mav.setViewName("client/account/deleteAccount.jsp");

		return mav;
	}

	/**
	 * View an existing Person entity
	 * 
	 */
	@RequestMapping("/selectClientPersons")
	public ModelAndView selectClientPersons(@RequestParam Integer client_clientId, @RequestParam Integer persons_personId) {
		Person person = personDAO.findPersonByPrimaryKey(persons_personId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("client_clientId", client_clientId);
		mav.addObject("person", person);
		mav.setViewName("client/persons/viewPersons.jsp");

		return mav;
	}

	/**
	 * Select the child Project entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteClientProjects")
	public ModelAndView confirmDeleteClientProjects(@RequestParam Integer client_clientId, @RequestParam Integer related_projects_projectId) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("project", projectDAO.findProjectByPrimaryKey(related_projects_projectId));
		mav.addObject("client_clientId", client_clientId);
		mav.setViewName("client/projects/deleteProjects.jsp");

		return mav;
	}

	/**
	 * Save an existing Client entity
	 * 
	 */
	@RequestMapping("/saveClient")
	public String saveClient(@ModelAttribute Client client) {
		clientService.saveClient(client);
		return "forward:/indexClient";
	}

	/**
	 * Create a new Client entity
	 * 
	 */
	@RequestMapping("/newClient")
	public ModelAndView newClient() {
		ModelAndView mav = new ModelAndView();

		mav.addObject("client", new Client());
		mav.addObject("newFlag", true);
		mav.setViewName("client/editClient.jsp");

		return mav;
	}

	/**
	 * Delete an existing Account entity
	 * 
	 */
	@RequestMapping("/deleteClientAccount")
	public ModelAndView deleteClientAccount(@RequestParam Integer client_clientId, @RequestParam Integer related_account_accountId) {
		ModelAndView mav = new ModelAndView();

		Client client = clientService.deleteClientAccount(client_clientId, related_account_accountId);

		mav.addObject("client_clientId", client_clientId);
		mav.addObject("client", client);
		mav.setViewName("client/viewClient.jsp");

		return mav;
	}

	/**
	 * Show all Person entities by Client
	 * 
	 */
	@RequestMapping("/listClientPersons")
	public ModelAndView listClientPersons(@RequestParam Integer clientIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("client", clientDAO.findClientByPrimaryKey(clientIdKey));
		mav.setViewName("client/persons/listPersons.jsp");

		return mav;
	}

	/**
	 * Show all Person entities by Client
	 * 
	 */
	@RequestMapping("/listClientPerson")
	public ModelAndView listClientPerson(@RequestParam Integer clientIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("client", clientDAO.findClientByPrimaryKey(clientIdKey));
		mav.setViewName("client/person/listPerson.jsp");

		return mav;
	}

	/**
	 * Create a new Invoice entity
	 * 
	 */
	@RequestMapping("/newClientInvoices")
	public ModelAndView newClientInvoices(@RequestParam Integer client_clientId) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("client_clientId", client_clientId);
		mav.addObject("invoice", new Invoice());
		mav.addObject("newFlag", true);
		mav.setViewName("client/invoices/editInvoices.jsp");

		return mav;
	}

	/**
	 * Show all Invoice entities by Client
	 * 
	 */
	@RequestMapping("/listClientInvoices")
	public ModelAndView listClientInvoices(@RequestParam Integer clientIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("client", clientDAO.findClientByPrimaryKey(clientIdKey));
		mav.setViewName("client/invoices/listInvoices.jsp");

		return mav;
	}

	/**
	 * View an existing Account entity
	 * 
	 */
	@RequestMapping("/selectClientAccount")
	public ModelAndView selectClientAccount(@RequestParam Integer client_clientId, @RequestParam Integer account_accountId) {
		Account account = accountDAO.findAccountByPrimaryKey(account_accountId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("client_clientId", client_clientId);
		mav.addObject("account", account);
		mav.setViewName("client/account/viewAccount.jsp");

		return mav;
	}

	/**
	 * Delete an existing Person entity
	 * 
	 */
	@RequestMapping("/deleteClientPerson")
	public ModelAndView deleteClientPerson(@RequestParam Integer client_clientId, @RequestParam Integer related_person_personId) {
		ModelAndView mav = new ModelAndView();

		Client client = clientService.deleteClientPerson(client_clientId, related_person_personId);

		mav.addObject("client_clientId", client_clientId);
		mav.addObject("client", client);
		mav.setViewName("client/viewClient.jsp");

		return mav;
	}

	/**
	 * Select an existing Client entity
	 * 
	 */
	@RequestMapping("/selectClient")
	public ModelAndView selectClient(@RequestParam Integer clientIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("client", clientDAO.findClientByPrimaryKey(clientIdKey));
		mav.setViewName("client/viewClient.jsp");

		return mav;
	}

	/**
	 * Select the child Person entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteClientPersons")
	public ModelAndView confirmDeleteClientPersons(@RequestParam Integer client_clientId, @RequestParam Integer related_persons_personId) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("person", personDAO.findPersonByPrimaryKey(related_persons_personId));
		mav.addObject("client_clientId", client_clientId);
		mav.setViewName("client/persons/deletePersons.jsp");

		return mav;
	}

	/**
	 * Edit an existing Client entity
	 * 
	 */
	@RequestMapping("/editClient")
	public ModelAndView editClient(@RequestParam Integer clientIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("client", clientDAO.findClientByPrimaryKey(clientIdKey));
		mav.setViewName("client/editClient.jsp");

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
	 * Save an existing Invoice entity
	 * 
	 */
	@RequestMapping("/saveClientInvoices")
	public ModelAndView saveClientInvoices(@RequestParam Integer client_clientId, @ModelAttribute Invoice invoices) {
		Client parent_client = clientService.saveClientInvoices(client_clientId, invoices);

		ModelAndView mav = new ModelAndView();
		mav.addObject("client_clientId", client_clientId);
		mav.addObject("client", parent_client);
		mav.setViewName("client/viewClient.jsp");

		return mav;
	}

	/**
	 * Delete an existing Person entity
	 * 
	 */
	@RequestMapping("/deleteClientPersons")
	public ModelAndView deleteClientPersons(@RequestParam Integer client_clientId, @RequestParam Integer related_persons_personId) {
		ModelAndView mav = new ModelAndView();

		Client client = clientService.deleteClientPersons(client_clientId, related_persons_personId);

		mav.addObject("client_clientId", client_clientId);
		mav.addObject("client", client);
		mav.setViewName("client/viewClient.jsp");

		return mav;
	}

	/**
	 * Show all Client entities
	 * 
	 */
	@RequestMapping("/indexClient")
	public ModelAndView listClients() {
		ModelAndView mav = new ModelAndView();

		mav.addObject("clients", clientService.loadClients());

		mav.setViewName("client/listClients.jsp");

		return mav;
	}

	/**
	 * Edit an existing Project entity
	 * 
	 */
	@RequestMapping("/editClientProjects")
	public ModelAndView editClientProjects(@RequestParam Integer client_clientId, @RequestParam Integer projects_projectId) {
		Project project = projectDAO.findProjectByPrimaryKey(projects_projectId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("client_clientId", client_clientId);
		mav.addObject("project", project);
		mav.setViewName("client/projects/editProjects.jsp");

		return mav;
	}

	/**
	 * Edit an existing Account entity
	 * 
	 */
	@RequestMapping("/editClientAccount")
	public ModelAndView editClientAccount(@RequestParam Integer client_clientId, @RequestParam Integer account_accountId) {
		Account account = accountDAO.findAccountByPrimaryKey(account_accountId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("client_clientId", client_clientId);
		mav.addObject("account", account);
		mav.setViewName("client/account/editAccount.jsp");

		return mav;
	}

	/**
	 */
	@RequestMapping("/clientController/binary.action")
	public ModelAndView streamBinary(@ModelAttribute HttpServletRequest request, @ModelAttribute HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("streamedBinaryContentView");
		return mav;

	}

	/**
	 * Create a new Project entity
	 * 
	 */
	@RequestMapping("/newClientProjects")
	public ModelAndView newClientProjects(@RequestParam Integer client_clientId) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("client_clientId", client_clientId);
		mav.addObject("project", new Project());
		mav.addObject("newFlag", true);
		mav.setViewName("client/projects/editProjects.jsp");

		return mav;
	}

	/**
	 * Show all Account entities by Client
	 * 
	 */
	@RequestMapping("/listClientAccount")
	public ModelAndView listClientAccount(@RequestParam Integer clientIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("client", clientDAO.findClientByPrimaryKey(clientIdKey));
		mav.setViewName("client/account/listAccount.jsp");

		return mav;
	}

	/**
	 * Edit an existing Invoice entity
	 * 
	 */
	@RequestMapping("/editClientInvoices")
	public ModelAndView editClientInvoices(@RequestParam Integer client_clientId, @RequestParam Integer invoices_invoiceId) {
		Invoice invoice = invoiceDAO.findInvoiceByPrimaryKey(invoices_invoiceId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("client_clientId", client_clientId);
		mav.addObject("invoice", invoice);
		mav.setViewName("client/invoices/editInvoices.jsp");

		return mav;
	}

	/**
	 * Entry point to show all Client entities
	 * 
	 */
	public String indexClient() {
		return "redirect:/indexClient";
	}

	/**
	 * Create a new Account entity
	 * 
	 */
	@RequestMapping("/newClientAccount")
	public ModelAndView newClientAccount(@RequestParam Integer client_clientId) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("client_clientId", client_clientId);
		mav.addObject("account", new Account());
		mav.addObject("newFlag", true);
		mav.setViewName("client/account/editAccount.jsp");

		return mav;
	}
}