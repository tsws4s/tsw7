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
import pm7.dao.InvoiceDAO;
import pm7.dao.InvoiceitemDAO;
import pm7.dao.ProjectDAO;

import pm7.domain.Account;
import pm7.domain.Invoice;
import pm7.domain.Invoiceitem;
import pm7.domain.Project;

import pm7.service.InvoiceitemService;

/**
 * Spring MVC controller that handles CRUD requests for Invoiceitem entities
 * 
 */

@Controller("InvoiceitemController")
public class InvoiceitemController {

	/**
	 * DAO injected by Spring that manages Account entities
	 * 
	 */
	@Autowired
	private AccountDAO accountDAO;

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
	 * Service injected by Spring that provides CRUD operations for Invoiceitem entities
	 * 
	 */
	@Autowired
	private InvoiceitemService invoiceitemService;

	/**
	 * Create a new Account entity
	 * 
	 */
	@RequestMapping("/newInvoiceitemAccount")
	public ModelAndView newInvoiceitemAccount(@RequestParam Integer invoiceitem_invoiceItemId) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("invoiceitem_invoiceItemId", invoiceitem_invoiceItemId);
		mav.addObject("account", new Account());
		mav.addObject("newFlag", true);
		mav.setViewName("invoiceitem/account/editAccount.jsp");

		return mav;
	}

	/**
	 * Edit an existing Project entity
	 * 
	 */
	@RequestMapping("/editInvoiceitemProject")
	public ModelAndView editInvoiceitemProject(@RequestParam Integer invoiceitem_invoiceItemId, @RequestParam Integer project_projectId) {
		Project project = projectDAO.findProjectByPrimaryKey(project_projectId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("invoiceitem_invoiceItemId", invoiceitem_invoiceItemId);
		mav.addObject("project", project);
		mav.setViewName("invoiceitem/project/editProject.jsp");

		return mav;
	}

	/**
	 * Select the Invoiceitem entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteInvoiceitem")
	public ModelAndView confirmDeleteInvoiceitem(@RequestParam Integer invoiceItemIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("invoiceitem", invoiceitemDAO.findInvoiceitemByPrimaryKey(invoiceItemIdKey));
		mav.setViewName("invoiceitem/deleteInvoiceitem.jsp");

		return mav;
	}

	/**
	 * Create a new Invoice entity
	 * 
	 */
	@RequestMapping("/newInvoiceitemInvoice")
	public ModelAndView newInvoiceitemInvoice(@RequestParam Integer invoiceitem_invoiceItemId) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("invoiceitem_invoiceItemId", invoiceitem_invoiceItemId);
		mav.addObject("invoice", new Invoice());
		mav.addObject("newFlag", true);
		mav.setViewName("invoiceitem/invoice/editInvoice.jsp");

		return mav;
	}

	/**
	 * Show all Invoice entities by Invoiceitem
	 * 
	 */
	@RequestMapping("/listInvoiceitemInvoice")
	public ModelAndView listInvoiceitemInvoice(@RequestParam Integer invoiceItemIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("invoiceitem", invoiceitemDAO.findInvoiceitemByPrimaryKey(invoiceItemIdKey));
		mav.setViewName("invoiceitem/invoice/listInvoice.jsp");

		return mav;
	}

	/**
	 * Delete an existing Project entity
	 * 
	 */
	@RequestMapping("/deleteInvoiceitemProject")
	public ModelAndView deleteInvoiceitemProject(@RequestParam Integer invoiceitem_invoiceItemId, @RequestParam Integer related_project_projectId) {
		ModelAndView mav = new ModelAndView();

		Invoiceitem invoiceitem = invoiceitemService.deleteInvoiceitemProject(invoiceitem_invoiceItemId, related_project_projectId);

		mav.addObject("invoiceitem_invoiceItemId", invoiceitem_invoiceItemId);
		mav.addObject("invoiceitem", invoiceitem);
		mav.setViewName("invoiceitem/viewInvoiceitem.jsp");

		return mav;
	}

	/**
	 * Entry point to show all Invoiceitem entities
	 * 
	 */
	public String indexInvoiceitem() {
		return "redirect:/indexInvoiceitem";
	}

	/**
	 * Show all Invoiceitem entities
	 * 
	 */
	@RequestMapping("/indexInvoiceitem")
	public ModelAndView listInvoiceitems() {
		ModelAndView mav = new ModelAndView();

		mav.addObject("invoiceitems", invoiceitemService.loadInvoiceitems());

		mav.setViewName("invoiceitem/listInvoiceitems.jsp");

		return mav;
	}

	/**
	 * Show all Account entities by Invoiceitem
	 * 
	 */
	@RequestMapping("/listInvoiceitemAccount")
	public ModelAndView listInvoiceitemAccount(@RequestParam Integer invoiceItemIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("invoiceitem", invoiceitemDAO.findInvoiceitemByPrimaryKey(invoiceItemIdKey));
		mav.setViewName("invoiceitem/account/listAccount.jsp");

		return mav;
	}

	/**
	 * Save an existing Invoice entity
	 * 
	 */
	@RequestMapping("/saveInvoiceitemInvoice")
	public ModelAndView saveInvoiceitemInvoice(@RequestParam Integer invoiceitem_invoiceItemId, @ModelAttribute Invoice invoice) {
		Invoiceitem parent_invoiceitem = invoiceitemService.saveInvoiceitemInvoice(invoiceitem_invoiceItemId, invoice);

		ModelAndView mav = new ModelAndView();
		mav.addObject("invoiceitem_invoiceItemId", invoiceitem_invoiceItemId);
		mav.addObject("invoiceitem", parent_invoiceitem);
		mav.setViewName("invoiceitem/viewInvoiceitem.jsp");

		return mav;
	}

	/**
	 * Edit an existing Account entity
	 * 
	 */
	@RequestMapping("/editInvoiceitemAccount")
	public ModelAndView editInvoiceitemAccount(@RequestParam Integer invoiceitem_invoiceItemId, @RequestParam Integer account_accountId) {
		Account account = accountDAO.findAccountByPrimaryKey(account_accountId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("invoiceitem_invoiceItemId", invoiceitem_invoiceItemId);
		mav.addObject("account", account);
		mav.setViewName("invoiceitem/account/editAccount.jsp");

		return mav;
	}

	/**
	 * Save an existing Project entity
	 * 
	 */
	@RequestMapping("/saveInvoiceitemProject")
	public ModelAndView saveInvoiceitemProject(@RequestParam Integer invoiceitem_invoiceItemId, @ModelAttribute Project project) {
		Invoiceitem parent_invoiceitem = invoiceitemService.saveInvoiceitemProject(invoiceitem_invoiceItemId, project);

		ModelAndView mav = new ModelAndView();
		mav.addObject("invoiceitem_invoiceItemId", invoiceitem_invoiceItemId);
		mav.addObject("invoiceitem", parent_invoiceitem);
		mav.setViewName("invoiceitem/viewInvoiceitem.jsp");

		return mav;
	}

	/**
	 * View an existing Account entity
	 * 
	 */
	@RequestMapping("/selectInvoiceitemAccount")
	public ModelAndView selectInvoiceitemAccount(@RequestParam Integer invoiceitem_invoiceItemId, @RequestParam Integer account_accountId) {
		Account account = accountDAO.findAccountByPrimaryKey(account_accountId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("invoiceitem_invoiceItemId", invoiceitem_invoiceItemId);
		mav.addObject("account", account);
		mav.setViewName("invoiceitem/account/viewAccount.jsp");

		return mav;
	}

	/**
	 * Edit an existing Invoice entity
	 * 
	 */
	@RequestMapping("/editInvoiceitemInvoice")
	public ModelAndView editInvoiceitemInvoice(@RequestParam Integer invoiceitem_invoiceItemId, @RequestParam Integer invoice_invoiceId) {
		Invoice invoice = invoiceDAO.findInvoiceByPrimaryKey(invoice_invoiceId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("invoiceitem_invoiceItemId", invoiceitem_invoiceItemId);
		mav.addObject("invoice", invoice);
		mav.setViewName("invoiceitem/invoice/editInvoice.jsp");

		return mav;
	}

	/**
	 * Create a new Project entity
	 * 
	 */
	@RequestMapping("/newInvoiceitemProject")
	public ModelAndView newInvoiceitemProject(@RequestParam Integer invoiceitem_invoiceItemId) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("invoiceitem_invoiceItemId", invoiceitem_invoiceItemId);
		mav.addObject("project", new Project());
		mav.addObject("newFlag", true);
		mav.setViewName("invoiceitem/project/editProject.jsp");

		return mav;
	}

	/**
	 * View an existing Project entity
	 * 
	 */
	@RequestMapping("/selectInvoiceitemProject")
	public ModelAndView selectInvoiceitemProject(@RequestParam Integer invoiceitem_invoiceItemId, @RequestParam Integer project_projectId) {
		Project project = projectDAO.findProjectByPrimaryKey(project_projectId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("invoiceitem_invoiceItemId", invoiceitem_invoiceItemId);
		mav.addObject("project", project);
		mav.setViewName("invoiceitem/project/viewProject.jsp");

		return mav;
	}

	/**
	 * Select the child Project entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteInvoiceitemProject")
	public ModelAndView confirmDeleteInvoiceitemProject(@RequestParam Integer invoiceitem_invoiceItemId, @RequestParam Integer related_project_projectId) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("project", projectDAO.findProjectByPrimaryKey(related_project_projectId));
		mav.addObject("invoiceitem_invoiceItemId", invoiceitem_invoiceItemId);
		mav.setViewName("invoiceitem/project/deleteProject.jsp");

		return mav;
	}

	/**
	 * Select an existing Invoiceitem entity
	 * 
	 */
	@RequestMapping("/selectInvoiceitem")
	public ModelAndView selectInvoiceitem(@RequestParam Integer invoiceItemIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("invoiceitem", invoiceitemDAO.findInvoiceitemByPrimaryKey(invoiceItemIdKey));
		mav.setViewName("invoiceitem/viewInvoiceitem.jsp");

		return mav;
	}

	/**
	 * Delete an existing Account entity
	 * 
	 */
	@RequestMapping("/deleteInvoiceitemAccount")
	public ModelAndView deleteInvoiceitemAccount(@RequestParam Integer invoiceitem_invoiceItemId, @RequestParam Integer related_account_accountId) {
		ModelAndView mav = new ModelAndView();

		Invoiceitem invoiceitem = invoiceitemService.deleteInvoiceitemAccount(invoiceitem_invoiceItemId, related_account_accountId);

		mav.addObject("invoiceitem_invoiceItemId", invoiceitem_invoiceItemId);
		mav.addObject("invoiceitem", invoiceitem);
		mav.setViewName("invoiceitem/viewInvoiceitem.jsp");

		return mav;
	}

	/**
	 * Save an existing Account entity
	 * 
	 */
	@RequestMapping("/saveInvoiceitemAccount")
	public ModelAndView saveInvoiceitemAccount(@RequestParam Integer invoiceitem_invoiceItemId, @ModelAttribute Account account) {
		Invoiceitem parent_invoiceitem = invoiceitemService.saveInvoiceitemAccount(invoiceitem_invoiceItemId, account);

		ModelAndView mav = new ModelAndView();
		mav.addObject("invoiceitem_invoiceItemId", invoiceitem_invoiceItemId);
		mav.addObject("invoiceitem", parent_invoiceitem);
		mav.setViewName("invoiceitem/viewInvoiceitem.jsp");

		return mav;
	}

	/**
	 * Delete an existing Invoiceitem entity
	 * 
	 */
	@RequestMapping("/deleteInvoiceitem")
	public String deleteInvoiceitem(@RequestParam Integer invoiceItemIdKey) {
		Invoiceitem invoiceitem = invoiceitemDAO.findInvoiceitemByPrimaryKey(invoiceItemIdKey);
		invoiceitemService.deleteInvoiceitem(invoiceitem);
		return "forward:/indexInvoiceitem";
	}

	/**
	 */
	@RequestMapping("/invoiceitemController/binary.action")
	public ModelAndView streamBinary(@ModelAttribute HttpServletRequest request, @ModelAttribute HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("streamedBinaryContentView");
		return mav;

	}

	/**
	 * Edit an existing Invoiceitem entity
	 * 
	 */
	@RequestMapping("/editInvoiceitem")
	public ModelAndView editInvoiceitem(@RequestParam Integer invoiceItemIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("invoiceitem", invoiceitemDAO.findInvoiceitemByPrimaryKey(invoiceItemIdKey));
		mav.setViewName("invoiceitem/editInvoiceitem.jsp");

		return mav;
	}

	/**
	 * Select the child Account entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteInvoiceitemAccount")
	public ModelAndView confirmDeleteInvoiceitemAccount(@RequestParam Integer invoiceitem_invoiceItemId, @RequestParam Integer related_account_accountId) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("account", accountDAO.findAccountByPrimaryKey(related_account_accountId));
		mav.addObject("invoiceitem_invoiceItemId", invoiceitem_invoiceItemId);
		mav.setViewName("invoiceitem/account/deleteAccount.jsp");

		return mav;
	}

	/**
	 * Save an existing Invoiceitem entity
	 * 
	 */
	@RequestMapping("/saveInvoiceitem")
	public String saveInvoiceitem(@ModelAttribute Invoiceitem invoiceitem) {
		invoiceitemService.saveInvoiceitem(invoiceitem);
		return "forward:/indexInvoiceitem";
	}

	/**
	 * Delete an existing Invoice entity
	 * 
	 */
	@RequestMapping("/deleteInvoiceitemInvoice")
	public ModelAndView deleteInvoiceitemInvoice(@RequestParam Integer invoiceitem_invoiceItemId, @RequestParam Integer related_invoice_invoiceId) {
		ModelAndView mav = new ModelAndView();

		Invoiceitem invoiceitem = invoiceitemService.deleteInvoiceitemInvoice(invoiceitem_invoiceItemId, related_invoice_invoiceId);

		mav.addObject("invoiceitem_invoiceItemId", invoiceitem_invoiceItemId);
		mav.addObject("invoiceitem", invoiceitem);
		mav.setViewName("invoiceitem/viewInvoiceitem.jsp");

		return mav;
	}

	/**
	 * Show all Project entities by Invoiceitem
	 * 
	 */
	@RequestMapping("/listInvoiceitemProject")
	public ModelAndView listInvoiceitemProject(@RequestParam Integer invoiceItemIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("invoiceitem", invoiceitemDAO.findInvoiceitemByPrimaryKey(invoiceItemIdKey));
		mav.setViewName("invoiceitem/project/listProject.jsp");

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
	 * Create a new Invoiceitem entity
	 * 
	 */
	@RequestMapping("/newInvoiceitem")
	public ModelAndView newInvoiceitem() {
		ModelAndView mav = new ModelAndView();

		mav.addObject("invoiceitem", new Invoiceitem());
		mav.addObject("newFlag", true);
		mav.setViewName("invoiceitem/editInvoiceitem.jsp");

		return mav;
	}

	/**
	 * View an existing Invoice entity
	 * 
	 */
	@RequestMapping("/selectInvoiceitemInvoice")
	public ModelAndView selectInvoiceitemInvoice(@RequestParam Integer invoiceitem_invoiceItemId, @RequestParam Integer invoice_invoiceId) {
		Invoice invoice = invoiceDAO.findInvoiceByPrimaryKey(invoice_invoiceId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("invoiceitem_invoiceItemId", invoiceitem_invoiceItemId);
		mav.addObject("invoice", invoice);
		mav.setViewName("invoiceitem/invoice/viewInvoice.jsp");

		return mav;
	}

	/**
	 * Select the child Invoice entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteInvoiceitemInvoice")
	public ModelAndView confirmDeleteInvoiceitemInvoice(@RequestParam Integer invoiceitem_invoiceItemId, @RequestParam Integer related_invoice_invoiceId) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("invoice", invoiceDAO.findInvoiceByPrimaryKey(related_invoice_invoiceId));
		mav.addObject("invoiceitem_invoiceItemId", invoiceitem_invoiceItemId);
		mav.setViewName("invoiceitem/invoice/deleteInvoice.jsp");

		return mav;
	}
}