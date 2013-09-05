//**********************************************************
// InvoiceServiceImpl
// 
// Author: TODO: update developer's name in comment header
// Creation date: 06/22/2013
//
// Copyright (C) 2013  Team Sportsware
//*********************************************************

package pm7.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

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

/**
 * Spring service that handles CRUD requests for Invoice entities
 * 
 */

@Service("InvoiceService")
@Transactional
public class InvoiceServiceImpl implements InvoiceService {

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
	 * Instantiates a new InvoiceServiceImpl.
	 *
	 */
	public InvoiceServiceImpl() {
	}

	/**
	 * Delete an existing Account entity
	 * 
	 */
	@Transactional
	public Invoice deleteInvoiceAccount(Integer invoice_invoiceId, Integer related_account_accountId) {
		Invoice invoice = invoiceDAO.findInvoiceByPrimaryKey(invoice_invoiceId, -1, -1);
		Account related_account = accountDAO.findAccountByPrimaryKey(related_account_accountId, -1, -1);

		invoice.setAccount(null);
		invoice = invoiceDAO.store(invoice);
		invoiceDAO.flush();

		related_account = accountDAO.store(related_account);
		accountDAO.flush();

		accountDAO.remove(related_account);
		accountDAO.flush();

		return invoice;
	}

	/**
	 * Delete an existing Invoice entity
	 * 
	 */
	@Transactional
	public void deleteInvoice(Invoice invoice) {
		invoiceDAO.remove(invoice);
		invoiceDAO.flush();
	}

	/**
	 * Save an existing Client entity
	 * 
	 */
	@Transactional
	public Invoice saveInvoiceClient(Integer invoiceId, Client related_client) {
		Invoice invoice = invoiceDAO.findInvoiceByPrimaryKey(invoiceId, -1, -1);
		Client existingclient = clientDAO.findClientByPrimaryKey(related_client.getClientId());

		// copy into the existing record to preserve existing relationships
		if (existingclient != null) {
			existingclient.setClientId(related_client.getClientId());
			existingclient.setClientName(related_client.getClientName());
			existingclient.setPhone(related_client.getPhone());
			existingclient.setEmail(related_client.getEmail());
			existingclient.setWebsite(related_client.getWebsite());
			existingclient.setAddress(related_client.getAddress());
			existingclient.setCity(related_client.getCity());
			existingclient.setState(related_client.getState());
			existingclient.setZip(related_client.getZip());
			existingclient.setLogoFilename(related_client.getLogoFilename());
			existingclient.setActiveYn(related_client.getActiveYn());
			related_client = existingclient;
		} else {
			related_client = clientDAO.store(related_client);
			clientDAO.flush();
		}

		invoice.setClient(related_client);
		related_client.getInvoices().add(invoice);
		invoice = invoiceDAO.store(invoice);
		invoiceDAO.flush();
		/**
		if(resourceId!=null && resourceId>0){
			program.setResource(resourceDAO.findResourceByResourceId(resourceId));
		}
		if(levelId!=null && levelId>0){
			program.setLevel(levelDAO.findLevelByLevelId(levelId));
		}
		if(coordId!=null && coordId>0){
			program.setCustomer(customerDAO.findCustomerByPrimaryKey(coordId));
		}
		if(priceId!=null && priceId>0){
			program.setPrice(priceDAO.findPriceByPrimaryKey(priceId));
		}
		if(sportId!=null && sportId>0){
			program.setSport(sportDAO.findSportByPrimaryKey(sportId));
		}
		 **/

		related_client = clientDAO.store(related_client);
		clientDAO.flush();

		return invoice;
	}

	/**
	 * Save an existing Project entity
	 * 
	 */
	@Transactional
	public Invoice saveInvoiceProject(Integer invoiceId, Project related_project) {
		Invoice invoice = invoiceDAO.findInvoiceByPrimaryKey(invoiceId, -1, -1);
		Project existingproject = projectDAO.findProjectByPrimaryKey(related_project.getProjectId());

		// copy into the existing record to preserve existing relationships
		if (existingproject != null) {
			existingproject.setProjectId(related_project.getProjectId());
			existingproject.setProjectName(related_project.getProjectName());
			existingproject.setProjectDesc(related_project.getProjectDesc());
			existingproject.setProjectType(related_project.getProjectType());
			existingproject.setStartDate(related_project.getStartDate());
			existingproject.setDueDate(related_project.getDueDate());
			existingproject.setCompleteDate(related_project.getCompleteDate());
			existingproject.setEstimateHrs(related_project.getEstimateHrs());
			existingproject.setActualHrs(related_project.getActualHrs());
			existingproject.setHrRate(related_project.getHrRate());
			existingproject.setActiveYn(related_project.getActiveYn());
			related_project = existingproject;
		} else {
			related_project = projectDAO.store(related_project);
			projectDAO.flush();
		}

		invoice.setProject(related_project);
		related_project.getInvoices().add(invoice);
		invoice = invoiceDAO.store(invoice);
		invoiceDAO.flush();
		/**
		if(resourceId!=null && resourceId>0){
			program.setResource(resourceDAO.findResourceByResourceId(resourceId));
		}
		if(levelId!=null && levelId>0){
			program.setLevel(levelDAO.findLevelByLevelId(levelId));
		}
		if(coordId!=null && coordId>0){
			program.setCustomer(customerDAO.findCustomerByPrimaryKey(coordId));
		}
		if(priceId!=null && priceId>0){
			program.setPrice(priceDAO.findPriceByPrimaryKey(priceId));
		}
		if(sportId!=null && sportId>0){
			program.setSport(sportDAO.findSportByPrimaryKey(sportId));
		}
		 **/

		related_project = projectDAO.store(related_project);
		projectDAO.flush();

		return invoice;
	}

	/**
	 * Save an existing Account entity
	 * 
	 */
	@Transactional
	public Invoice saveInvoiceAccount(Integer invoiceId, Account related_account) {
		Invoice invoice = invoiceDAO.findInvoiceByPrimaryKey(invoiceId, -1, -1);
		Account existingaccount = accountDAO.findAccountByPrimaryKey(related_account.getAccountId());

		// copy into the existing record to preserve existing relationships
		if (existingaccount != null) {
			existingaccount.setAccountId(related_account.getAccountId());
			existingaccount.setAccountName(related_account.getAccountName());
			existingaccount.setExpireDate(related_account.getExpireDate());
			related_account = existingaccount;
		} else {
			related_account = accountDAO.store(related_account);
			accountDAO.flush();
		}

		invoice.setAccount(related_account);
		invoice = invoiceDAO.store(invoice);
		invoiceDAO.flush();

		related_account = accountDAO.store(related_account);
		accountDAO.flush();

		return invoice;
	}

	/**
	 * Load an existing Invoice entity
	 * 
	 */
	@Transactional
	public Set<Invoice> loadInvoices() {
		return invoiceDAO.findAllInvoices();
	}

	/**
	 * Save an existing Invoiceitem entity
	 * 
	 */
	@Transactional
	public Invoice saveInvoiceInvoiceitems(Integer invoiceId, Invoiceitem related_invoiceitems) {
		Invoice invoice = invoiceDAO.findInvoiceByPrimaryKey(invoiceId, -1, -1);
		Invoiceitem existinginvoiceitems = invoiceitemDAO.findInvoiceitemByPrimaryKey(related_invoiceitems.getInvoiceItemId());

		// copy into the existing record to preserve existing relationships
		if (existinginvoiceitems != null) {
			existinginvoiceitems.setInvoiceItemId(related_invoiceitems.getInvoiceItemId());
			existinginvoiceitems.setInvoiceItemDesc(related_invoiceitems.getInvoiceItemDesc());
			existinginvoiceitems.setItemAmt(related_invoiceitems.getItemAmt());
			existinginvoiceitems.setProjectExpenseYn(related_invoiceitems.getProjectExpenseYn());
			related_invoiceitems = existinginvoiceitems;
		} else {
			related_invoiceitems = invoiceitemDAO.store(related_invoiceitems);
			invoiceitemDAO.flush();
		}

		related_invoiceitems.setInvoice(invoice);
		invoice.getInvoiceitems().add(related_invoiceitems);
		related_invoiceitems = invoiceitemDAO.store(related_invoiceitems);
		invoiceitemDAO.flush();
		/**
		if(resourceId!=null && resourceId>0){
			program.setResource(resourceDAO.findResourceByResourceId(resourceId));
		}
		if(levelId!=null && levelId>0){
			program.setLevel(levelDAO.findLevelByLevelId(levelId));
		}
		if(coordId!=null && coordId>0){
			program.setCustomer(customerDAO.findCustomerByPrimaryKey(coordId));
		}
		if(priceId!=null && priceId>0){
			program.setPrice(priceDAO.findPriceByPrimaryKey(priceId));
		}
		if(sportId!=null && sportId>0){
			program.setSport(sportDAO.findSportByPrimaryKey(sportId));
		}
		 **/

		invoice = invoiceDAO.store(invoice);
		invoiceDAO.flush();

		return invoice;
	}

	/**
	 * Return a count of all Invoice entity
	 * 
	 */
	@Transactional
	public Integer countInvoices() {
		return ((Long) invoiceDAO.createQuerySingleResult("select count(o) from Invoice o").getSingleResult()).intValue();
	}

	/**
	 * Delete an existing Invoiceitem entity
	 * 
	 */
	@Transactional
	public Invoice deleteInvoiceInvoiceitems(Integer invoice_invoiceId, Integer related_invoiceitems_invoiceItemId) {
		Invoiceitem related_invoiceitems = invoiceitemDAO.findInvoiceitemByPrimaryKey(related_invoiceitems_invoiceItemId, -1, -1);

		Invoice invoice = invoiceDAO.findInvoiceByPrimaryKey(invoice_invoiceId, -1, -1);

		related_invoiceitems.setInvoice(null);
		invoice.getInvoiceitems().remove(related_invoiceitems);

		invoiceitemDAO.remove(related_invoiceitems);
		invoiceitemDAO.flush();

		return invoice;
	}

	/**
	 * Delete an existing Client entity
	 * 
	 */
	@Transactional
	public Invoice deleteInvoiceClient(Integer invoice_invoiceId, Integer related_client_clientId) {
		Invoice invoice = invoiceDAO.findInvoiceByPrimaryKey(invoice_invoiceId, -1, -1);
		Client related_client = clientDAO.findClientByPrimaryKey(related_client_clientId, -1, -1);

		invoice.setClient(null);
		related_client.getInvoices().remove(invoice);
		invoice = invoiceDAO.store(invoice);
		invoiceDAO.flush();

		related_client = clientDAO.store(related_client);
		clientDAO.flush();

		clientDAO.remove(related_client);
		clientDAO.flush();

		return invoice;
	}

	/**
	 */
	@Transactional
	public Invoice findInvoiceByPrimaryKey(Integer invoiceId) {
		return invoiceDAO.findInvoiceByPrimaryKey(invoiceId);
	}

	/**
	 * Delete an existing Project entity
	 * 
	 */
	@Transactional
	public Invoice deleteInvoiceProject(Integer invoice_invoiceId, Integer related_project_projectId) {
		Invoice invoice = invoiceDAO.findInvoiceByPrimaryKey(invoice_invoiceId, -1, -1);
		Project related_project = projectDAO.findProjectByPrimaryKey(related_project_projectId, -1, -1);

		invoice.setProject(null);
		related_project.getInvoices().remove(invoice);
		invoice = invoiceDAO.store(invoice);
		invoiceDAO.flush();

		related_project = projectDAO.store(related_project);
		projectDAO.flush();

		projectDAO.remove(related_project);
		projectDAO.flush();

		return invoice;
	}

	/**
	 * Save an existing Invoice entity
	 * 
	 */
	@Transactional
	public Invoice saveInvoice(Invoice invoice) {
		Invoice existingInvoice = invoiceDAO.findInvoiceByPrimaryKey(invoice.getInvoiceId());

		if (existingInvoice != null) {
			if (existingInvoice != invoice) {
				existingInvoice.setInvoiceId(invoice.getInvoiceId());
				existingInvoice.setInvoiceNumber(invoice.getInvoiceNumber());
				existingInvoice.setInvoiceDate(invoice.getInvoiceDate());
				existingInvoice.setInvoiceDesc(invoice.getInvoiceDesc());
				existingInvoice.setStatus(invoice.getStatus());
				existingInvoice.setPaymentSched(invoice.getPaymentSched());
				existingInvoice.setBilledRate(invoice.getBilledRate());
				existingInvoice.setDiscountAmt(invoice.getDiscountAmt());
				existingInvoice.setTaxesAmt(invoice.getTaxesAmt());
				existingInvoice.setTotalAmt(invoice.getTotalAmt());
				existingInvoice.setPaidAmt(invoice.getPaidAmt());
				existingInvoice.setBalanceAmt(invoice.getBalanceAmt());
				existingInvoice.setMessage(invoice.getMessage());
				existingInvoice.setBilledHrs(invoice.getBilledHrs());
				existingInvoice.setExpensesAmt(invoice.getExpensesAmt());
				existingInvoice.setItemsAmt(invoice.getItemsAmt());
				existingInvoice.setLogoFilename(invoice.getLogoFilename());
				existingInvoice.setActiveYn(invoice.getActiveYn());
			}
			invoice = invoiceDAO.store(existingInvoice);
		} else {
			int invoiceId = invoiceDAO.getMaxInvoiceId();
			invoice.setInvoiceId(invoiceId+1);
//			invoice.setAccount(acct);
			invoice = invoiceDAO.store(invoice);
		}
//		if(attachmentId!=null && attachmentId>0){
//			attachment = attachmentDAO.findAccountByPrimaryKey(attachmentId);
//		}		
		/**
		if(resourceId!=null && resourceId>0){
			program.setResource(resourceDAO.findResourceByResourceId(resourceId));
		}
		if(levelId!=null && levelId>0){
			program.setLevel(levelDAO.findLevelByLevelId(levelId));
		}
		if(coordId!=null && coordId>0){
			program.setCustomer(customerDAO.findCustomerByPrimaryKey(coordId));
		}
		if(priceId!=null && priceId>0){
			program.setPrice(priceDAO.findPriceByPrimaryKey(priceId));
		}
		if(sportId!=null && sportId>0){
			program.setSport(sportDAO.findSportByPrimaryKey(sportId));
		}
		 **/
		invoiceDAO.flush();
		return invoice;
		}

	/**
	 * Return all Invoice entity
	 * 
	 */
	@Transactional
	public List<Invoice> findAllInvoices(Integer startResult, Integer maxRows) {
		return new java.util.ArrayList<Invoice>(invoiceDAO.findAllInvoices(startResult, maxRows));
	}
}
