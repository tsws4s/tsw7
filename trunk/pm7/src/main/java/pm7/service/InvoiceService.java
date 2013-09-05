package pm7.service;

import java.util.List;
import java.util.Set;

import pm7.domain.Account;
import pm7.domain.Client;
import pm7.domain.Invoice;
import pm7.domain.Invoiceitem;
import pm7.domain.Project;

/**
 * Spring service that handles CRUD requests for Invoice entities
 * 
 */
public interface InvoiceService {

	/**
	 * Delete an existing Account entity
	 * 
	 */
	public Invoice deleteInvoiceAccount(Integer invoice_invoiceId, Integer related_account_accountId);

	/**
	 * Delete an existing Invoice entity
	 * 
	 */
	public void deleteInvoice(Invoice invoice);

	/**
	 * Save an existing Client entity
	 * 
	 */
	public Invoice saveInvoiceClient(Integer invoiceId, Client related_client);

	/**
	 * Save an existing Project entity
	 * 
	 */
	public Invoice saveInvoiceProject(Integer invoiceId_1, Project related_project);

	/**
	 * Save an existing Account entity
	 * 
	 */
	public Invoice saveInvoiceAccount(Integer invoiceId_2, Account related_account);

	/**
	 * Load an existing Invoice entity
	 * 
	 */
	public Set<Invoice> loadInvoices();

	/**
	 * Save an existing Invoiceitem entity
	 * 
	 */
	public Invoice saveInvoiceInvoiceitems(Integer invoiceId_3, Invoiceitem related_invoiceitems);

	/**
	 * Return a count of all Invoice entity
	 * 
	 */
	public Integer countInvoices();

	/**
	 * Delete an existing Invoiceitem entity
	 * 
	 */
	public Invoice deleteInvoiceInvoiceitems(Integer invoice_invoiceId_1, Integer related_invoiceitems_invoiceItemId);

	/**
	 * Delete an existing Client entity
	 * 
	 */
	public Invoice deleteInvoiceClient(Integer invoice_invoiceId_2, Integer related_client_clientId);

	/**
	 */
	public Invoice findInvoiceByPrimaryKey(Integer invoiceId_4);

	/**
	 * Delete an existing Project entity
	 * 
	 */
	public Invoice deleteInvoiceProject(Integer invoice_invoiceId_3, Integer related_project_projectId);

	/**
	 * Save an existing Invoice entity
	 * 
	 */
	public Invoice saveInvoice(Invoice invoice_1);

	/**
	 * Return all Invoice entity
	 * 
	 */
	public List<Invoice> findAllInvoices(Integer startResult, Integer maxRows);
}