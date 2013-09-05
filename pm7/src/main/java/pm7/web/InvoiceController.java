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
import pm7.dao.InvoiceitemDAO;
import pm7.dao.ProjectDAO;

import pm7.domain.Account;
import pm7.domain.Client;
import pm7.domain.Invoice;
import pm7.domain.Invoiceitem;
import pm7.domain.Project;

import pm7.service.InvoiceService;

/**
 * Spring MVC controller that handles CRUD requests for Invoice entities
 * 
 */

@Controller("InvoiceController")
public class InvoiceController {

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
	 * DAO injected by Spring that manages Invoiceitem entities
	 * 
	 */
	@Autowired
	private InvoiceitemDAO invoiceitemDAO;

	/**
	 * DAO injected by Spring that manages Project entities
	 * 
	 */
	@Autowired
	private ProjectDAO projectDAO;

	/**
	 * Service injected by Spring that provides CRUD operations for Invoice entities
	 * 
	 */
	@Autowired
	private InvoiceService invoiceService;

	/**
	 */
	@RequestMapping("/invoiceController/binary.action")
	public ModelAndView streamBinary(@ModelAttribute HttpServletRequest request, @ModelAttribute HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("streamedBinaryContentView");
		return mav;

	}

	/**
	 * Create a new Account entity
	 * 
	 */
	@RequestMapping("/newInvoiceAccount")
	public ModelAndView newInvoiceAccount(@RequestParam Integer invoice_invoiceId) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("invoice_invoiceId", invoice_invoiceId);
		mav.addObject("account", new Account());
		mav.addObject("newFlag", true);
		mav.setViewName("invoice/account/editAccount.jsp");
		/**
		Integer startResult= -1;
		Tswacct tswacct = sessionCache.getTswacct(request);
		mav.addObject("sports", sportService.findAllSports(startResult, defaultMaxRows));
		mav.addObject("levels", levelService.findAllLevels4tsw(tswacct, startResult , defaultMaxRows));
		mav.addObject("prices", priceService.findAllPrices4tsw(tswacct, startResult , defaultMaxRows));
		mav.addObject("resources", resourceService.findAllResources4tsw(tswacct, startResult , defaultMaxRows));
		mav.addObject("user",sessionCache.getUser4Session(request));	
		**/

		return mav;
	}

	/**
	 * View an existing Account entity
	 * 
	 */
	@RequestMapping("/selectInvoiceAccount")
	public ModelAndView selectInvoiceAccount(@RequestParam Integer invoice_invoiceId, @RequestParam Integer account_accountId) {
		Account account = accountDAO.findAccountByPrimaryKey(account_accountId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("invoice_invoiceId", invoice_invoiceId);
		mav.addObject("account", account);
		mav.setViewName("invoice/account/viewAccount.jsp");

		return mav;
	}

	/**
	 * Create a new Invoice entity
	 * 
	 */
	@RequestMapping("/newInvoice")
	public ModelAndView newInvoice() {
		ModelAndView mav = new ModelAndView();

		mav.addObject("invoice", new Invoice());
		mav.addObject("newFlag", true);
		mav.setViewName("invoice/editInvoice.jsp");
		/**
		Integer startResult= -1;
		Tswacct tswacct = sessionCache.getTswacct(request);
		mav.addObject("sports", sportService.findAllSports(startResult, defaultMaxRows));
		mav.addObject("levels", levelService.findAllLevels4tsw(tswacct, startResult , defaultMaxRows));
		mav.addObject("prices", priceService.findAllPrices4tsw(tswacct, startResult , defaultMaxRows));
		mav.addObject("resources", resourceService.findAllResources4tsw(tswacct, startResult , defaultMaxRows));
		mav.addObject("user",sessionCache.getUser4Session(request));	
		**/

		return mav;
	}

	/**
	 * Create a new Project entity
	 * 
	 */
	@RequestMapping("/newInvoiceProject")
	public ModelAndView newInvoiceProject(@RequestParam Integer invoice_invoiceId) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("invoice_invoiceId", invoice_invoiceId);
		mav.addObject("project", new Project());
		mav.addObject("newFlag", true);
		mav.setViewName("invoice/project/editProject.jsp");

		return mav;
	}

	/**
	 * Delete an existing Invoiceitem entity
	 * 
	 */
	@RequestMapping("/deleteInvoiceInvoiceitems")
	public ModelAndView deleteInvoiceInvoiceitems(@RequestParam Integer invoice_invoiceId, @RequestParam Integer related_invoiceitems_invoiceItemId) {
		ModelAndView mav = new ModelAndView();

		Invoice invoice = invoiceService.deleteInvoiceInvoiceitems(invoice_invoiceId, related_invoiceitems_invoiceItemId);

		mav.addObject("invoice_invoiceId", invoice_invoiceId);
		mav.addObject("invoice", invoice);
		mav.setViewName("invoice/viewInvoice.jsp");
		/**
		Integer startResult= -1;
		Tswacct tswacct = sessionCache.getTswacct(request);
		mav.addObject("sports", sportService.findAllSports(startResult, defaultMaxRows));
		mav.addObject("levels", levelService.findAllLevels4tsw(tswacct, startResult , defaultMaxRows));
		mav.addObject("prices", priceService.findAllPrices4tsw(tswacct, startResult , defaultMaxRows));
		mav.addObject("resources", resourceService.findAllResources4tsw(tswacct, startResult , defaultMaxRows));
		mav.addObject("user",sessionCache.getUser4Session(request));	
		**/

		return mav;
	}

	/**
	 * Delete an existing Account entity
	 * 
	 */
	@RequestMapping("/deleteInvoiceAccount")
	public ModelAndView deleteInvoiceAccount(@RequestParam Integer invoice_invoiceId, @RequestParam Integer related_account_accountId) {
		ModelAndView mav = new ModelAndView();

		Invoice invoice = invoiceService.deleteInvoiceAccount(invoice_invoiceId, related_account_accountId);

		mav.addObject("invoice_invoiceId", invoice_invoiceId);
		mav.addObject("invoice", invoice);
		mav.setViewName("invoice/viewInvoice.jsp");

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
	 * Delete an existing Client entity
	 * 
	 */
	@RequestMapping("/deleteInvoiceClient")
	public ModelAndView deleteInvoiceClient(@RequestParam Integer invoice_invoiceId, @RequestParam Integer related_client_clientId) {
		ModelAndView mav = new ModelAndView();

		Invoice invoice = invoiceService.deleteInvoiceClient(invoice_invoiceId, related_client_clientId);

		mav.addObject("invoice_invoiceId", invoice_invoiceId);
		mav.addObject("invoice", invoice);
		mav.setViewName("invoice/viewInvoice.jsp");

		return mav;
	}

	/**
	 * Create a new Client entity
	 * 
	 */
	@RequestMapping("/newInvoiceClient")
	public ModelAndView newInvoiceClient(@RequestParam Integer invoice_invoiceId) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("invoice_invoiceId", invoice_invoiceId);
		mav.addObject("client", new Client());
		mav.addObject("newFlag", true);
		mav.setViewName("invoice/client/editClient.jsp");

		return mav;
	}

	/**
	 * Create a new Invoiceitem entity
	 * 
	 */
	@RequestMapping("/newInvoiceInvoiceitems")
	public ModelAndView newInvoiceInvoiceitems(@RequestParam Integer invoice_invoiceId) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("invoice_invoiceId", invoice_invoiceId);
		mav.addObject("invoiceitem", new Invoiceitem());
		mav.addObject("newFlag", true);
		mav.setViewName("invoice/invoiceitems/editInvoiceitems.jsp");
		/**
		Integer startResult= -1;
		Tswacct tswacct = sessionCache.getTswacct(request);
		mav.addObject("sports", sportService.findAllSports(startResult, defaultMaxRows));
		mav.addObject("levels", levelService.findAllLevels4tsw(tswacct, startResult , defaultMaxRows));
		mav.addObject("prices", priceService.findAllPrices4tsw(tswacct, startResult , defaultMaxRows));
		mav.addObject("resources", resourceService.findAllResources4tsw(tswacct, startResult , defaultMaxRows));
		mav.addObject("user",sessionCache.getUser4Session(request));	
		**/

		return mav;
	}

	/**
	 * Select the child Invoiceitem entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteInvoiceInvoiceitems")
	public ModelAndView confirmDeleteInvoiceInvoiceitems(@RequestParam Integer invoice_invoiceId, @RequestParam Integer related_invoiceitems_invoiceItemId) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("invoiceitem", invoiceitemDAO.findInvoiceitemByPrimaryKey(related_invoiceitems_invoiceItemId));
		mav.addObject("invoice_invoiceId", invoice_invoiceId);
		mav.setViewName("invoice/invoiceitems/deleteInvoiceitems.jsp");

		return mav;
	}

	/**
	 * View an existing Project entity
	 * 
	 */
	@RequestMapping("/selectInvoiceProject")
	public ModelAndView selectInvoiceProject(@RequestParam Integer invoice_invoiceId, @RequestParam Integer project_projectId) {
		Project project = projectDAO.findProjectByPrimaryKey(project_projectId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("invoice_invoiceId", invoice_invoiceId);
		mav.addObject("project", project);
		mav.setViewName("invoice/project/viewProject.jsp");

		return mav;
	}

	/**
	 * Show all Project entities by Invoice
	 * 
	 */
	@RequestMapping("/listInvoiceProject")
	public ModelAndView listInvoiceProject(@RequestParam Integer invoiceIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("invoice", invoiceDAO.findInvoiceByPrimaryKey(invoiceIdKey));
		mav.setViewName("invoice/project/listProject.jsp");

		return mav;
	}

	/**
	 * Edit an existing Invoiceitem entity
	 * 
	 */
	@RequestMapping("/editInvoiceInvoiceitems")
	public ModelAndView editInvoiceInvoiceitems(@RequestParam Integer invoice_invoiceId, @RequestParam Integer invoiceitems_invoiceItemId) {
		Invoiceitem invoiceitem = invoiceitemDAO.findInvoiceitemByPrimaryKey(invoiceitems_invoiceItemId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("invoice_invoiceId", invoice_invoiceId);
		mav.addObject("invoiceitem", invoiceitem);
		mav.setViewName("invoice/invoiceitems/editInvoiceitems.jsp");
		/**
		Integer startResult= -1;
		Tswacct tswacct = sessionCache.getTswacct(request);
		mav.addObject("sports", sportService.findAllSports(startResult, defaultMaxRows));
		mav.addObject("levels", levelService.findAllLevels4tsw(tswacct, startResult , defaultMaxRows));
		mav.addObject("prices", priceService.findAllPrices4tsw(tswacct, startResult , defaultMaxRows));
		mav.addObject("resources", resourceService.findAllResources4tsw(tswacct, startResult , defaultMaxRows));
		mav.addObject("user",sessionCache.getUser4Session(request));	
		**/

		return mav;
	}

	/**
	 * Edit an existing Invoice entity
	 * 
	 */
	@RequestMapping("/editInvoice")
	public ModelAndView editInvoice(@RequestParam Integer invoiceIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("invoice", invoiceDAO.findInvoiceByPrimaryKey(invoiceIdKey));
		mav.setViewName("invoice/editInvoice.jsp");
		/**
		Integer startResult= -1;
		Tswacct tswacct = sessionCache.getTswacct(request);
		mav.addObject("sports", sportService.findAllSports(startResult, defaultMaxRows));
		mav.addObject("levels", levelService.findAllLevels4tsw(tswacct, startResult , defaultMaxRows));
		mav.addObject("prices", priceService.findAllPrices4tsw(tswacct, startResult , defaultMaxRows));
		mav.addObject("resources", resourceService.findAllResources4tsw(tswacct, startResult , defaultMaxRows));
		mav.addObject("user",sessionCache.getUser4Session(request));	
		**/

		return mav;
	}

	/**
	 * Edit an existing Client entity
	 * 
	 */
	@RequestMapping("/editInvoiceClient")
	public ModelAndView editInvoiceClient(@RequestParam Integer invoice_invoiceId, @RequestParam Integer client_clientId) {
		Client client = clientDAO.findClientByPrimaryKey(client_clientId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("invoice_invoiceId", invoice_invoiceId);
		mav.addObject("client", client);
		mav.setViewName("invoice/client/editClient.jsp");

		return mav;
	}

	/**
	 * Entry point to show all Invoice entities
	 * 
	 */
	public String indexInvoice() {
		return "redirect:/indexInvoice";
	}

	/**
	 * Select an existing Invoice entity
	 * 
	 */
	@RequestMapping("/selectInvoice")
	public ModelAndView selectInvoice(@RequestParam Integer invoiceIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("invoice", invoiceDAO.findInvoiceByPrimaryKey(invoiceIdKey));
		mav.setViewName("invoice/viewInvoice.jsp");

		return mav;
	}

	/**
	 * Edit an existing Account entity
	 * 
	 */
	@RequestMapping("/editInvoiceAccount")
	public ModelAndView editInvoiceAccount(@RequestParam Integer invoice_invoiceId, @RequestParam Integer account_accountId) {
		Account account = accountDAO.findAccountByPrimaryKey(account_accountId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("invoice_invoiceId", invoice_invoiceId);
		mav.addObject("account", account);
		mav.setViewName("invoice/account/editAccount.jsp");

		return mav;
	}

	/**
	 * Select the child Project entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteInvoiceProject")
	public ModelAndView confirmDeleteInvoiceProject(@RequestParam Integer invoice_invoiceId, @RequestParam Integer related_project_projectId) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("project", projectDAO.findProjectByPrimaryKey(related_project_projectId));
		mav.addObject("invoice_invoiceId", invoice_invoiceId);
		mav.setViewName("invoice/project/deleteProject.jsp");

		return mav;
	}

	/**
	 * Edit an existing Project entity
	 * 
	 */
	@RequestMapping("/editInvoiceProject")
	public ModelAndView editInvoiceProject(@RequestParam Integer invoice_invoiceId, @RequestParam Integer project_projectId) {
		Project project = projectDAO.findProjectByPrimaryKey(project_projectId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("invoice_invoiceId", invoice_invoiceId);
		mav.addObject("project", project);
		mav.setViewName("invoice/project/editProject.jsp");

		return mav;
	}

	/**
	 * Select the child Account entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteInvoiceAccount")
	public ModelAndView confirmDeleteInvoiceAccount(@RequestParam Integer invoice_invoiceId, @RequestParam Integer related_account_accountId) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("account", accountDAO.findAccountByPrimaryKey(related_account_accountId));
		mav.addObject("invoice_invoiceId", invoice_invoiceId);
		mav.setViewName("invoice/account/deleteAccount.jsp");

		return mav;
	}

	/**
	 * Show all Invoice entities
	 * 
	 */
	@RequestMapping("/indexInvoice")
	public ModelAndView listInvoices() {
		ModelAndView mav = new ModelAndView();

		mav.addObject("invoices", invoiceService.loadInvoices());

		mav.setViewName("invoice/listInvoices.jsp");

		return mav;
	}

	/**
	 * Show all Invoiceitem entities by Invoice
	 * 
	 */
	@RequestMapping("/listInvoiceInvoiceitems")
	public ModelAndView listInvoiceInvoiceitems(@RequestParam Integer invoiceIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("invoice", invoiceDAO.findInvoiceByPrimaryKey(invoiceIdKey));
		mav.setViewName("invoice/invoiceitems/listInvoiceitems.jsp");

		return mav;
	}

	/**
	 * Save an existing Account entity
	 * 
	 */
	@RequestMapping("/saveInvoiceAccount")
	public ModelAndView saveInvoiceAccount(@RequestParam Integer invoice_invoiceId, @ModelAttribute Account account) {
		Invoice parent_invoice = invoiceService.saveInvoiceAccount(invoice_invoiceId, account);

		ModelAndView mav = new ModelAndView();
		mav.addObject("invoice_invoiceId", invoice_invoiceId);
		mav.addObject("invoice", parent_invoice);
		mav.setViewName("invoice/viewInvoice.jsp");

		return mav;
	}

	/**
	 * Save an existing Invoice entity
	 * 
	 */
	@RequestMapping("/saveInvoice")
	public String saveInvoice(@ModelAttribute Invoice invoice) {
		invoiceService.saveInvoice(invoice);
		/*
		 * 	public String saveProgram(HttpServletRequest request, @ModelAttribute Program program, @RequestParam Integer selected_id1, @RequestParam Integer selected_id4, @RequestParam Integer selected_id8, @RequestParam Integer selected_id11, @RequestParam Integer selected_sport_id1) {
		 */
		return "forward:/indexInvoice";
	}

	/**
	 * Save an existing Client entity
	 * 
	 */
	@RequestMapping("/saveInvoiceClient")
	public ModelAndView saveInvoiceClient(@RequestParam Integer invoice_invoiceId, @ModelAttribute Client client) {
		Invoice parent_invoice = invoiceService.saveInvoiceClient(invoice_invoiceId, client);

		ModelAndView mav = new ModelAndView();
		mav.addObject("invoice_invoiceId", invoice_invoiceId);
		mav.addObject("invoice", parent_invoice);
		mav.setViewName("invoice/viewInvoice.jsp");

		return mav;
	}

	/**
	 * Select the child Client entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteInvoiceClient")
	public ModelAndView confirmDeleteInvoiceClient(@RequestParam Integer invoice_invoiceId, @RequestParam Integer related_client_clientId) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("client", clientDAO.findClientByPrimaryKey(related_client_clientId));
		mav.addObject("invoice_invoiceId", invoice_invoiceId);
		mav.setViewName("invoice/client/deleteClient.jsp");

		return mav;
	}

	/**
	 * Save an existing Project entity
	 * 
	 */
	@RequestMapping("/saveInvoiceProject")
	public ModelAndView saveInvoiceProject(@RequestParam Integer invoice_invoiceId, @ModelAttribute Project project) {
		Invoice parent_invoice = invoiceService.saveInvoiceProject(invoice_invoiceId, project);

		ModelAndView mav = new ModelAndView();
		mav.addObject("invoice_invoiceId", invoice_invoiceId);
		mav.addObject("invoice", parent_invoice);
		mav.setViewName("invoice/viewInvoice.jsp");

		return mav;
	}

	/**
	 * View an existing Invoiceitem entity
	 * 
	 */
	@RequestMapping("/selectInvoiceInvoiceitems")
	public ModelAndView selectInvoiceInvoiceitems(@RequestParam Integer invoice_invoiceId, @RequestParam Integer invoiceitems_invoiceItemId) {
		Invoiceitem invoiceitem = invoiceitemDAO.findInvoiceitemByPrimaryKey(invoiceitems_invoiceItemId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("invoice_invoiceId", invoice_invoiceId);
		mav.addObject("invoiceitem", invoiceitem);
		mav.setViewName("invoice/invoiceitems/viewInvoiceitems.jsp");

		return mav;
	}

	/**
	 * Show all Client entities by Invoice
	 * 
	 */
	@RequestMapping("/listInvoiceClient")
	public ModelAndView listInvoiceClient(@RequestParam Integer invoiceIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("invoice", invoiceDAO.findInvoiceByPrimaryKey(invoiceIdKey));
		mav.setViewName("invoice/client/listClient.jsp");

		return mav;
	}

	/**
	 * Show all Account entities by Invoice
	 * 
	 */
	@RequestMapping("/listInvoiceAccount")
	public ModelAndView listInvoiceAccount(@RequestParam Integer invoiceIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("invoice", invoiceDAO.findInvoiceByPrimaryKey(invoiceIdKey));
		mav.setViewName("invoice/account/listAccount.jsp");

		return mav;
	}

	/**
	 * Select the Invoice entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteInvoice")
	public ModelAndView confirmDeleteInvoice(@RequestParam Integer invoiceIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("invoice", invoiceDAO.findInvoiceByPrimaryKey(invoiceIdKey));
		mav.setViewName("invoice/deleteInvoice.jsp");

		return mav;
	}

	/**
	 * View an existing Client entity
	 * 
	 */
	@RequestMapping("/selectInvoiceClient")
	public ModelAndView selectInvoiceClient(@RequestParam Integer invoice_invoiceId, @RequestParam Integer client_clientId) {
		Client client = clientDAO.findClientByPrimaryKey(client_clientId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("invoice_invoiceId", invoice_invoiceId);
		mav.addObject("client", client);
		mav.setViewName("invoice/client/viewClient.jsp");

		return mav;
	}

	/**
	 * Save an existing Invoiceitem entity
	 * 
	 */
	@RequestMapping("/saveInvoiceInvoiceitems")
	public ModelAndView saveInvoiceInvoiceitems(@RequestParam Integer invoice_invoiceId, @ModelAttribute Invoiceitem invoiceitems) {
		Invoice parent_invoice = invoiceService.saveInvoiceInvoiceitems(invoice_invoiceId, invoiceitems);

		ModelAndView mav = new ModelAndView();
		mav.addObject("invoice_invoiceId", invoice_invoiceId);
		mav.addObject("invoice", parent_invoice);
		mav.setViewName("invoice/viewInvoice.jsp");
		/**
	public String saveProgram(HttpServletRequest request, @ModelAttribute Program program, @RequestParam Integer selected_id1, @RequestParam Integer selected_id4, @RequestParam Integer selected_id8, @RequestParam Integer selected_id11, @RequestParam Integer selected_sport_id1) {
		Integer startResult= -1;
		Tswacct tswacct = sessionCache.getTswacct(request);
		mav.addObject("sports", sportService.findAllSports(startResult, defaultMaxRows));
		mav.addObject("levels", levelService.findAllLevels4tsw(tswacct, startResult , defaultMaxRows));
		mav.addObject("prices", priceService.findAllPrices4tsw(tswacct, startResult , defaultMaxRows));
		mav.addObject("resources", resourceService.findAllResources4tsw(tswacct, startResult , defaultMaxRows));
		mav.addObject("user",sessionCache.getUser4Session(request));	
		**/

		return mav;
	}

	/**
	 * Delete an existing Project entity
	 * 
	 */
	@RequestMapping("/deleteInvoiceProject")
	public ModelAndView deleteInvoiceProject(@RequestParam Integer invoice_invoiceId, @RequestParam Integer related_project_projectId) {
		ModelAndView mav = new ModelAndView();

		Invoice invoice = invoiceService.deleteInvoiceProject(invoice_invoiceId, related_project_projectId);

		mav.addObject("invoice_invoiceId", invoice_invoiceId);
		mav.addObject("invoice", invoice);
		mav.setViewName("invoice/viewInvoice.jsp");

		return mav;
	}

	/**
	 * Delete an existing Invoice entity
	 * 
	 */
	@RequestMapping("/deleteInvoice")
	public String deleteInvoice(@RequestParam Integer invoiceIdKey) {
		Invoice invoice = invoiceDAO.findInvoiceByPrimaryKey(invoiceIdKey);
		invoiceService.deleteInvoice(invoice);
		return "forward:/indexInvoice";
	}
}