//**********************************************************
// InvoiceitemServiceImpl
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
import pm7.dao.InvoiceDAO;
import pm7.dao.InvoiceitemDAO;
import pm7.dao.ProjectDAO;

import pm7.domain.Account;
import pm7.domain.Invoice;
import pm7.domain.Invoiceitem;
import pm7.domain.Project;

/**
 * Spring service that handles CRUD requests for Invoiceitem entities
 * 
 */

@Service("InvoiceitemService")
@Transactional
public class InvoiceitemServiceImpl implements InvoiceitemService {

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
	 * Instantiates a new InvoiceitemServiceImpl.
	 *
	 */
	public InvoiceitemServiceImpl() {
	}

	/**
	 * Save an existing Account entity
	 * 
	 */
	@Transactional
	public Invoiceitem saveInvoiceitemAccount(Integer invoiceItemId, Account related_account) {
		Invoiceitem invoiceitem = invoiceitemDAO.findInvoiceitemByPrimaryKey(invoiceItemId, -1, -1);
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

		invoiceitem.setAccount(related_account);
		invoiceitem = invoiceitemDAO.store(invoiceitem);
		invoiceitemDAO.flush();

		related_account = accountDAO.store(related_account);
		accountDAO.flush();

		return invoiceitem;
	}

	/**
	 */
	@Transactional
	public Invoiceitem findInvoiceitemByPrimaryKey(Integer invoiceItemId) {
		return invoiceitemDAO.findInvoiceitemByPrimaryKey(invoiceItemId);
	}

	/**
	 * Load an existing Invoiceitem entity
	 * 
	 */
	@Transactional
	public Set<Invoiceitem> loadInvoiceitems() {
		return invoiceitemDAO.findAllInvoiceitems();
	}

	/**
	 * Return a count of all Invoiceitem entity
	 * 
	 */
	@Transactional
	public Integer countInvoiceitems() {
		return ((Long) invoiceitemDAO.createQuerySingleResult("select count(o) from Invoiceitem o").getSingleResult()).intValue();
	}

	/**
	 * Save an existing Project entity
	 * 
	 */
	@Transactional
	public Invoiceitem saveInvoiceitemProject(Integer invoiceItemId, Project related_project) {
		Invoiceitem invoiceitem = invoiceitemDAO.findInvoiceitemByPrimaryKey(invoiceItemId, -1, -1);
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

		invoiceitem.setProject(related_project);
		related_project.getInvoiceitems().add(invoiceitem);
		invoiceitem = invoiceitemDAO.store(invoiceitem);
		invoiceitemDAO.flush();

		related_project = projectDAO.store(related_project);
		projectDAO.flush();

		return invoiceitem;
	}

	/**
	 * Return all Invoiceitem entity
	 * 
	 */
	@Transactional
	public List<Invoiceitem> findAllInvoiceitems(Integer startResult, Integer maxRows) {
		return new java.util.ArrayList<Invoiceitem>(invoiceitemDAO.findAllInvoiceitems(startResult, maxRows));
	}

	/**
	 * Delete an existing Invoice entity
	 * 
	 */
	@Transactional
	public Invoiceitem deleteInvoiceitemInvoice(Integer invoiceitem_invoiceItemId, Integer related_invoice_invoiceId) {
		Invoiceitem invoiceitem = invoiceitemDAO.findInvoiceitemByPrimaryKey(invoiceitem_invoiceItemId, -1, -1);
		Invoice related_invoice = invoiceDAO.findInvoiceByPrimaryKey(related_invoice_invoiceId, -1, -1);

		invoiceitem.setInvoice(null);
		related_invoice.getInvoiceitems().remove(invoiceitem);
		invoiceitem = invoiceitemDAO.store(invoiceitem);
		invoiceitemDAO.flush();

		related_invoice = invoiceDAO.store(related_invoice);
		invoiceDAO.flush();

		invoiceDAO.remove(related_invoice);
		invoiceDAO.flush();

		return invoiceitem;
	}

	/**
	 * Delete an existing Invoiceitem entity
	 * 
	 */
	@Transactional
	public void deleteInvoiceitem(Invoiceitem invoiceitem) {
		invoiceitemDAO.remove(invoiceitem);
		invoiceitemDAO.flush();
	}

	/**
	 * Save an existing Invoiceitem entity
	 * 
	 */
	@Transactional
	public Invoiceitem saveInvoiceitem(Invoiceitem invoiceitem) {
		Invoiceitem existingInvoiceitem = invoiceitemDAO.findInvoiceitemByPrimaryKey(invoiceitem.getInvoiceItemId());

		if (existingInvoiceitem != null) {
			if (existingInvoiceitem != invoiceitem) {
				existingInvoiceitem.setInvoiceItemId(invoiceitem.getInvoiceItemId());
				existingInvoiceitem.setInvoiceItemDesc(invoiceitem.getInvoiceItemDesc());
				existingInvoiceitem.setItemAmt(invoiceitem.getItemAmt());
				existingInvoiceitem.setProjectExpenseYn(invoiceitem.getProjectExpenseYn());
			}
			invoiceitem = invoiceitemDAO.store(existingInvoiceitem);
		} else {
			int invoiceitemId = invoiceitemDAO.getMaxInvoiceitemId();
			invoiceitem.setInvoiceItemId(invoiceitemId+1);
//			feature.setAccount(acct);
			invoiceitem = invoiceitemDAO.store(invoiceitem);
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
		invoiceitemDAO.flush();
		return invoiceitem;
		}

	/**
	 * Delete an existing Project entity
	 * 
	 */
	@Transactional
	public Invoiceitem deleteInvoiceitemProject(Integer invoiceitem_invoiceItemId, Integer related_project_projectId) {
		Invoiceitem invoiceitem = invoiceitemDAO.findInvoiceitemByPrimaryKey(invoiceitem_invoiceItemId, -1, -1);
		Project related_project = projectDAO.findProjectByPrimaryKey(related_project_projectId, -1, -1);

		invoiceitem.setProject(null);
		related_project.getInvoiceitems().remove(invoiceitem);
		invoiceitem = invoiceitemDAO.store(invoiceitem);
		invoiceitemDAO.flush();

		related_project = projectDAO.store(related_project);
		projectDAO.flush();

		projectDAO.remove(related_project);
		projectDAO.flush();

		return invoiceitem;
	}

	/**
	 * Delete an existing Account entity
	 * 
	 */
	@Transactional
	public Invoiceitem deleteInvoiceitemAccount(Integer invoiceitem_invoiceItemId, Integer related_account_accountId) {
		Invoiceitem invoiceitem = invoiceitemDAO.findInvoiceitemByPrimaryKey(invoiceitem_invoiceItemId, -1, -1);
		Account related_account = accountDAO.findAccountByPrimaryKey(related_account_accountId, -1, -1);

		invoiceitem.setAccount(null);
		invoiceitem = invoiceitemDAO.store(invoiceitem);
		invoiceitemDAO.flush();

		related_account = accountDAO.store(related_account);
		accountDAO.flush();

		accountDAO.remove(related_account);
		accountDAO.flush();

		return invoiceitem;
	}

	/**
	 * Save an existing Invoice entity
	 * 
	 */
	@Transactional
	public Invoiceitem saveInvoiceitemInvoice(Integer invoiceItemId, Invoice related_invoice) {
		Invoiceitem invoiceitem = invoiceitemDAO.findInvoiceitemByPrimaryKey(invoiceItemId, -1, -1);
		Invoice existinginvoice = invoiceDAO.findInvoiceByPrimaryKey(related_invoice.getInvoiceId());

		// copy into the existing record to preserve existing relationships
		if (existinginvoice != null) {
			existinginvoice.setInvoiceId(related_invoice.getInvoiceId());
			existinginvoice.setInvoiceNumber(related_invoice.getInvoiceNumber());
			existinginvoice.setInvoiceDate(related_invoice.getInvoiceDate());
			existinginvoice.setInvoiceDesc(related_invoice.getInvoiceDesc());
			existinginvoice.setStatus(related_invoice.getStatus());
			existinginvoice.setPaymentSched(related_invoice.getPaymentSched());
			existinginvoice.setBilledRate(related_invoice.getBilledRate());
			existinginvoice.setDiscountAmt(related_invoice.getDiscountAmt());
			existinginvoice.setTaxesAmt(related_invoice.getTaxesAmt());
			existinginvoice.setTotalAmt(related_invoice.getTotalAmt());
			existinginvoice.setPaidAmt(related_invoice.getPaidAmt());
			existinginvoice.setBalanceAmt(related_invoice.getBalanceAmt());
			existinginvoice.setMessage(related_invoice.getMessage());
			existinginvoice.setBilledHrs(related_invoice.getBilledHrs());
			existinginvoice.setExpensesAmt(related_invoice.getExpensesAmt());
			existinginvoice.setItemsAmt(related_invoice.getItemsAmt());
			existinginvoice.setLogoFilename(related_invoice.getLogoFilename());
			existinginvoice.setActiveYn(related_invoice.getActiveYn());
			related_invoice = existinginvoice;
		} else {
			related_invoice = invoiceDAO.store(related_invoice);
			invoiceDAO.flush();
		}

		invoiceitem.setInvoice(related_invoice);
		related_invoice.getInvoiceitems().add(invoiceitem);
		invoiceitem = invoiceitemDAO.store(invoiceitem);
		invoiceitemDAO.flush();

		related_invoice = invoiceDAO.store(related_invoice);
		invoiceDAO.flush();

		return invoiceitem;
	}
}
