package pm7.service;

import java.util.List;
import java.util.Set;

import pm7.domain.Account;
import pm7.domain.Invoice;
import pm7.domain.Invoiceitem;
import pm7.domain.Project;

/**
 * Spring service that handles CRUD requests for Invoiceitem entities
 * 
 */
public interface InvoiceitemService {

	/**
	 * Save an existing Account entity
	 * 
	 */
	public Invoiceitem saveInvoiceitemAccount(Integer invoiceItemId, Account related_account);

	/**
	 */
	public Invoiceitem findInvoiceitemByPrimaryKey(Integer invoiceItemId_1);

	/**
	 * Load an existing Invoiceitem entity
	 * 
	 */
	public Set<Invoiceitem> loadInvoiceitems();

	/**
	 * Return a count of all Invoiceitem entity
	 * 
	 */
	public Integer countInvoiceitems();

	/**
	 * Save an existing Project entity
	 * 
	 */
	public Invoiceitem saveInvoiceitemProject(Integer invoiceItemId_2, Project related_project);

	/**
	 * Return all Invoiceitem entity
	 * 
	 */
	public List<Invoiceitem> findAllInvoiceitems(Integer startResult, Integer maxRows);

	/**
	 * Delete an existing Invoice entity
	 * 
	 */
	public Invoiceitem deleteInvoiceitemInvoice(Integer invoiceitem_invoiceItemId, Integer related_invoice_invoiceId);

	/**
	 * Delete an existing Invoiceitem entity
	 * 
	 */
	public void deleteInvoiceitem(Invoiceitem invoiceitem);

	/**
	 * Save an existing Invoiceitem entity
	 * 
	 */
	public Invoiceitem saveInvoiceitem(Invoiceitem invoiceitem_1);

	/**
	 * Delete an existing Project entity
	 * 
	 */
	public Invoiceitem deleteInvoiceitemProject(Integer invoiceitem_invoiceItemId_1, Integer related_project_projectId);

	/**
	 * Delete an existing Account entity
	 * 
	 */
	public Invoiceitem deleteInvoiceitemAccount(Integer invoiceitem_invoiceItemId_2, Integer related_account_accountId);

	/**
	 * Save an existing Invoice entity
	 * 
	 */
	public Invoiceitem saveInvoiceitemInvoice(Integer invoiceItemId_3, Invoice related_invoice);
}