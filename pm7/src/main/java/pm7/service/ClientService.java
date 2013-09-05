package pm7.service;

import java.util.List;
import java.util.Set;

import pm7.domain.Account;
import pm7.domain.Client;
import pm7.domain.Invoice;
import pm7.domain.Person;
import pm7.domain.Project;

/**
 * Spring service that handles CRUD requests for Client entities
 * 
 */
public interface ClientService {

	/**
	 * Delete an existing Client entity
	 * 
	 */
	public void deleteClient(Client client);

	/**
	 * Save an existing Person entity
	 * 
	 */
	public Client saveClientPerson(Integer clientId, Person related_person);

	/**
	 * Save an existing Project entity
	 * 
	 */
	public Client saveClientProjects(Integer clientId_1, Project related_projects);

	/**
	 * Delete an existing Account entity
	 * 
	 */
	public Client deleteClientAccount(Integer client_clientId, Integer related_account_accountId);

	/**
	 * Save an existing Invoice entity
	 * 
	 */
	public Client saveClientInvoices(Integer clientId_2, Invoice related_invoices);

	/**
	 * Delete an existing Project entity
	 * 
	 */
	public Client deleteClientProjects(Integer client_clientId_1, Integer related_projects_projectId);

	/**
	 * Return all Client entity
	 * 
	 */
	public List<Client> findAllClients(Integer startResult, Integer maxRows);

	/**
	 * Delete an existing Person entity
	 * 
	 */
	public Client deleteClientPersons(Integer client_clientId_2, Integer related_persons_personId);

	/**
	 * Save an existing Account entity
	 * 
	 */
	public Client saveClientAccount(Integer clientId_3, Account related_account);

	/**
	 * Delete an existing Invoice entity
	 * 
	 */
	public Client deleteClientInvoices(Integer client_clientId_3, Integer related_invoices_invoiceId);

	/**
	 * Save an existing Client entity
	 * 
	 */
	public Client saveClient(Client client_1);

	/**
	 * Load an existing Client entity
	 * 
	 */
	public Set<Client> loadClients();

	/**
	 * Delete an existing Person entity
	 * 
	 */
	public Client deleteClientPerson(Integer client_clientId_4, Integer related_person_personId);

	/**
	 */
	public Client findClientByPrimaryKey(Integer clientId_4);

	/**
	 * Save an existing Person entity
	 * 
	 */
	public Client saveClientPersons(Integer clientId_5, Person related_persons);

	/**
	 * Return a count of all Client entity
	 * 
	 */
	public Integer countClients();
}