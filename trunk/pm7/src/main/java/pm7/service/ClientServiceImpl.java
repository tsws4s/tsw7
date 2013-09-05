//**********************************************************
// ClientServiceImpl
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
import pm7.dao.PersonDAO;
import pm7.dao.ProjectDAO;

import pm7.domain.Account;
import pm7.domain.Client;
import pm7.domain.Invoice;
import pm7.domain.Person;
import pm7.domain.Project;

/**
 * Spring service that handles CRUD requests for Client entities
 * 
 */

@Service("ClientService")
@Transactional
public class ClientServiceImpl implements ClientService {

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
	 * Instantiates a new ClientServiceImpl.
	 *
	 */
	public ClientServiceImpl() {
	}

	/**
	 * Delete an existing Client entity
	 * 
	 */
	@Transactional
	public void deleteClient(Client client) {
		clientDAO.remove(client);
		clientDAO.flush();
	}

	/**
	 * Save an existing Person entity
	 * 
	 */
	@Transactional
	public Client saveClientPerson(Integer clientId, Person related_person) {
		Client client = clientDAO.findClientByPrimaryKey(clientId, -1, -1);
		Person existingperson = personDAO.findPersonByPrimaryKey(related_person.getPersonId());

		// copy into the existing record to preserve existing relationships
		if (existingperson != null) {
			existingperson.setPersonId(related_person.getPersonId());
			existingperson.setFirstname(related_person.getFirstname());
			existingperson.setLastname(related_person.getLastname());
			existingperson.setPhone(related_person.getPhone());
			existingperson.setEmail(related_person.getEmail());
			existingperson.setDefaultProjectRole(related_person.getDefaultProjectRole());
			existingperson.setAddress(related_person.getAddress());
			existingperson.setCity(related_person.getCity());
			existingperson.setState(related_person.getState());
			existingperson.setZip(related_person.getZip());
			existingperson.setActiveYn(related_person.getActiveYn());
			related_person = existingperson;
		} else {
			related_person = personDAO.store(related_person);
			personDAO.flush();
		}

		client.setPerson(related_person);
		related_person.getClients().add(client);
		client = clientDAO.store(client);
		clientDAO.flush();

		related_person = personDAO.store(related_person);
		personDAO.flush();

		return client;
	}

	/**
	 * Save an existing Project entity
	 * 
	 */
	@Transactional
	public Client saveClientProjects(Integer clientId, Project related_projects) {
		Client client = clientDAO.findClientByPrimaryKey(clientId, -1, -1);
		Project existingprojects = projectDAO.findProjectByPrimaryKey(related_projects.getProjectId());

		// copy into the existing record to preserve existing relationships
		if (existingprojects != null) {
			existingprojects.setProjectId(related_projects.getProjectId());
			existingprojects.setProjectName(related_projects.getProjectName());
			existingprojects.setProjectDesc(related_projects.getProjectDesc());
			existingprojects.setProjectType(related_projects.getProjectType());
			existingprojects.setStartDate(related_projects.getStartDate());
			existingprojects.setDueDate(related_projects.getDueDate());
			existingprojects.setCompleteDate(related_projects.getCompleteDate());
			existingprojects.setEstimateHrs(related_projects.getEstimateHrs());
			existingprojects.setActualHrs(related_projects.getActualHrs());
			existingprojects.setHrRate(related_projects.getHrRate());
			existingprojects.setActiveYn(related_projects.getActiveYn());
			related_projects = existingprojects;
		} else {
			related_projects = projectDAO.store(related_projects);
			projectDAO.flush();
		}

		related_projects.setClient(client);
		client.getProjects().add(related_projects);
		related_projects = projectDAO.store(related_projects);
		projectDAO.flush();

		client = clientDAO.store(client);
		clientDAO.flush();

		return client;
	}

	/**
	 * Delete an existing Account entity
	 * 
	 */
	@Transactional
	public Client deleteClientAccount(Integer client_clientId, Integer related_account_accountId) {
		Client client = clientDAO.findClientByPrimaryKey(client_clientId, -1, -1);
		Account related_account = accountDAO.findAccountByPrimaryKey(related_account_accountId, -1, -1);

		client.setAccount(null);
		client = clientDAO.store(client);
		clientDAO.flush();

		related_account = accountDAO.store(related_account);
		accountDAO.flush();

		accountDAO.remove(related_account);
		accountDAO.flush();

		return client;
	}

	/**
	 * Save an existing Invoice entity
	 * 
	 */
	@Transactional
	public Client saveClientInvoices(Integer clientId, Invoice related_invoices) {
		Client client = clientDAO.findClientByPrimaryKey(clientId, -1, -1);
		Invoice existinginvoices = invoiceDAO.findInvoiceByPrimaryKey(related_invoices.getInvoiceId());

		// copy into the existing record to preserve existing relationships
		if (existinginvoices != null) {
			existinginvoices.setInvoiceId(related_invoices.getInvoiceId());
			existinginvoices.setInvoiceNumber(related_invoices.getInvoiceNumber());
			existinginvoices.setInvoiceDate(related_invoices.getInvoiceDate());
			existinginvoices.setInvoiceDesc(related_invoices.getInvoiceDesc());
			existinginvoices.setStatus(related_invoices.getStatus());
			existinginvoices.setPaymentSched(related_invoices.getPaymentSched());
			existinginvoices.setBilledRate(related_invoices.getBilledRate());
			existinginvoices.setDiscountAmt(related_invoices.getDiscountAmt());
			existinginvoices.setTaxesAmt(related_invoices.getTaxesAmt());
			existinginvoices.setTotalAmt(related_invoices.getTotalAmt());
			existinginvoices.setPaidAmt(related_invoices.getPaidAmt());
			existinginvoices.setBalanceAmt(related_invoices.getBalanceAmt());
			existinginvoices.setMessage(related_invoices.getMessage());
			existinginvoices.setBilledHrs(related_invoices.getBilledHrs());
			existinginvoices.setExpensesAmt(related_invoices.getExpensesAmt());
			existinginvoices.setItemsAmt(related_invoices.getItemsAmt());
			existinginvoices.setLogoFilename(related_invoices.getLogoFilename());
			existinginvoices.setActiveYn(related_invoices.getActiveYn());
			related_invoices = existinginvoices;
		} else {
			related_invoices = invoiceDAO.store(related_invoices);
			invoiceDAO.flush();
		}

		related_invoices.setClient(client);
		client.getInvoices().add(related_invoices);
		related_invoices = invoiceDAO.store(related_invoices);
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

		client = clientDAO.store(client);
		clientDAO.flush();

		return client;
	}

	/**
	 * Delete an existing Project entity
	 * 
	 */
	@Transactional
	public Client deleteClientProjects(Integer client_clientId, Integer related_projects_projectId) {
		Project related_projects = projectDAO.findProjectByPrimaryKey(related_projects_projectId, -1, -1);

		Client client = clientDAO.findClientByPrimaryKey(client_clientId, -1, -1);

		related_projects.setClient(null);
		client.getProjects().remove(related_projects);

		projectDAO.remove(related_projects);
		projectDAO.flush();

		return client;
	}

	/**
	 * Return all Client entity
	 * 
	 */
	@Transactional
	public List<Client> findAllClients(Integer startResult, Integer maxRows) {
		return new java.util.ArrayList<Client>(clientDAO.findAllClients(startResult, maxRows));
	}

	/**
	 * Delete an existing Person entity
	 * 
	 */
	@Transactional
	public Client deleteClientPersons(Integer client_clientId, Integer related_persons_personId) {
		Person related_persons = personDAO.findPersonByPrimaryKey(related_persons_personId, -1, -1);

		Client client = clientDAO.findClientByPrimaryKey(client_clientId, -1, -1);

		related_persons.setClient(null);
		client.getPersons().remove(related_persons);

		personDAO.remove(related_persons);
		personDAO.flush();

		return client;
	}

	/**
	 * Save an existing Account entity
	 * 
	 */
	@Transactional
	public Client saveClientAccount(Integer clientId, Account related_account) {
		Client client = clientDAO.findClientByPrimaryKey(clientId, -1, -1);
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

		client.setAccount(related_account);
		client = clientDAO.store(client);
		clientDAO.flush();

		related_account = accountDAO.store(related_account);
		accountDAO.flush();

		return client;
	}

	/**
	 * Delete an existing Invoice entity
	 * 
	 */
	@Transactional
	public Client deleteClientInvoices(Integer client_clientId, Integer related_invoices_invoiceId) {
		Invoice related_invoices = invoiceDAO.findInvoiceByPrimaryKey(related_invoices_invoiceId, -1, -1);

		Client client = clientDAO.findClientByPrimaryKey(client_clientId, -1, -1);

		related_invoices.setClient(null);
		client.getInvoices().remove(related_invoices);

		invoiceDAO.remove(related_invoices);
		invoiceDAO.flush();

		return client;
	}

	/**
	 * Save an existing Client entity
	 * 
	 */
	@Transactional
	public Client saveClient(Client client) {
		Client existingClient = clientDAO.findClientByPrimaryKey(client.getClientId());

		if (existingClient != null) {
			if (existingClient != client) {
				existingClient.setClientId(client.getClientId());
				existingClient.setClientName(client.getClientName());
				existingClient.setPhone(client.getPhone());
				existingClient.setEmail(client.getEmail());
				existingClient.setWebsite(client.getWebsite());
				existingClient.setAddress(client.getAddress());
				existingClient.setCity(client.getCity());
				existingClient.setState(client.getState());
				existingClient.setZip(client.getZip());
				existingClient.setLogoFilename(client.getLogoFilename());
				existingClient.setActiveYn(client.getActiveYn());
			}
			client = clientDAO.store(existingClient);
		} else {
			int clientId = clientDAO.getMaxClientId();
			client.setClientId(clientId+1);
//			client.setAccount(acct);
			client = clientDAO.store(client);
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
		clientDAO.flush();
		return client;
		}

	/**
	 * Load an existing Client entity
	 * 
	 */
	@Transactional
	public Set<Client> loadClients() {
		return clientDAO.findAllClients();
	}

	/**
	 * Delete an existing Person entity
	 * 
	 */
	@Transactional
	public Client deleteClientPerson(Integer client_clientId, Integer related_person_personId) {
		Client client = clientDAO.findClientByPrimaryKey(client_clientId, -1, -1);
		Person related_person = personDAO.findPersonByPrimaryKey(related_person_personId, -1, -1);

		client.setPerson(null);
		related_person.getClients().remove(client);
		client = clientDAO.store(client);
		clientDAO.flush();

		related_person = personDAO.store(related_person);
		personDAO.flush();

		personDAO.remove(related_person);
		personDAO.flush();

		return client;
	}

	/**
	 */
	@Transactional
	public Client findClientByPrimaryKey(Integer clientId) {
		return clientDAO.findClientByPrimaryKey(clientId);
	}

	/**
	 * Save an existing Person entity
	 * 
	 */
	@Transactional
	public Client saveClientPersons(Integer clientId, Person related_persons) {
		Client client = clientDAO.findClientByPrimaryKey(clientId, -1, -1);
		Person existingpersons = personDAO.findPersonByPrimaryKey(related_persons.getPersonId());

		// copy into the existing record to preserve existing relationships
		if (existingpersons != null) {
			existingpersons.setPersonId(related_persons.getPersonId());
			existingpersons.setFirstname(related_persons.getFirstname());
			existingpersons.setLastname(related_persons.getLastname());
			existingpersons.setPhone(related_persons.getPhone());
			existingpersons.setEmail(related_persons.getEmail());
			existingpersons.setDefaultProjectRole(related_persons.getDefaultProjectRole());
			existingpersons.setAddress(related_persons.getAddress());
			existingpersons.setCity(related_persons.getCity());
			existingpersons.setState(related_persons.getState());
			existingpersons.setZip(related_persons.getZip());
			existingpersons.setActiveYn(related_persons.getActiveYn());
			related_persons = existingpersons;
		} else {
			related_persons = personDAO.store(related_persons);
			personDAO.flush();
		}

		related_persons.setClient(client);
		client.getPersons().add(related_persons);
		related_persons = personDAO.store(related_persons);
		personDAO.flush();

		client = clientDAO.store(client);
		clientDAO.flush();

		return client;
	}

	/**
	 * Return a count of all Client entity
	 * 
	 */
	@Transactional
	public Integer countClients() {
		return ((Long) clientDAO.createQuerySingleResult("select count(o) from Client o").getSingleResult()).intValue();
	}
}
