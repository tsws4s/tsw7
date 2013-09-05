package pm7.service;

import java.util.List;
import java.util.Set;

import pm7.domain.Account;
import pm7.domain.Attachment;
import pm7.domain.Client;
import pm7.domain.Person;
import pm7.domain.Project;
import pm7.domain.Projectteam;
import pm7.domain.Statusupdate;
import pm7.domain.Task;
import pm7.domain.Timeentry;

/**
 * Spring service that handles CRUD requests for Person entities
 * 
 */
public interface PersonService {

	/**
	 */
	public Person findPersonByPrimaryKey(Integer personId);

	/**
	 * Save an existing Timeentry entity
	 * 
	 */
	public Person savePersonTimeentries(Integer personId_1, Timeentry related_timeentries);

	/**
	 * Delete an existing Client entity
	 * 
	 */
	public Person deletePersonClient(Integer person_personId, Integer related_client_clientId);

	/**
	 * Save an existing Task entity
	 * 
	 */
	public Person savePersonTasks(Integer personId_2, Task related_tasks);

	/**
	 * Load an existing Person entity
	 * 
	 */
	public Set<Person> loadPersons();

	/**
	 * Save an existing Statusupdate entity
	 * 
	 */
	public Person savePersonStatusupdates(Integer personId_3, Statusupdate related_statusupdates);

	/**
	 * Save an existing Attachment entity
	 * 
	 */
	public Person savePersonAttachments(Integer personId_4, Attachment related_attachments);

	/**
	 * Save an existing Person entity
	 * 
	 */
	public Person savePerson(Person person);

	/**
	 * Save an existing Project entity
	 * 
	 */
	public Person savePersonProjectsForFkProjMgrId(Integer personId_5, Project related_projectsforfkprojmgrid);

	/**
	 * Delete an existing Client entity
	 * 
	 */
	public Person deletePersonClients(Integer person_personId_1, Integer related_clients_clientId);

	/**
	 * Delete an existing Timeentry entity
	 * 
	 */
	public Person deletePersonTimeentries(Integer person_personId_2, Integer related_timeentries_timeEntryId);

	/**
	 * Return all Person entity
	 * 
	 */
	public List<Person> findAllPersons(Integer startResult, Integer maxRows);

	/**
	 * Delete an existing Task entity
	 * 
	 */
	public Person deletePersonTasks(Integer person_personId_3, Integer related_tasks_taskId);

	/**
	 * Delete an existing Attachment entity
	 * 
	 */
	public Person deletePersonAttachments(Integer person_personId_4, Integer related_attachments_attachId);

	/**
	 * Save an existing Client entity
	 * 
	 */
	public Person savePersonClient(Integer personId_6, Client related_client);

	/**
	 * Return a count of all Person entity
	 * 
	 */
	public Integer countPersons();

	/**
	 * Delete an existing Project entity
	 * 
	 */
	public Person deletePersonProjectsForFkContactPersonId(Integer person_personId_5, Integer related_projectsforfkcontactpersonid_projectId);

	/**
	 * Save an existing Account entity
	 * 
	 */
	public Person savePersonAccount(Integer personId_7, Account related_account);

	/**
	 * Delete an existing Projectteam entity
	 * 
	 */
	public Person deletePersonProjectteams(Integer person_personId_6, Integer related_projectteams_projectTeamId);

	/**
	 * Delete an existing Project entity
	 * 
	 */
	public Person deletePersonProjectsForFkProjMgrId(Integer person_personId_7, Integer related_projectsforfkprojmgrid_projectId);

	/**
	 * Save an existing Client entity
	 * 
	 */
	public Person savePersonClients(Integer personId_8, Client related_clients);

	/**
	 * Save an existing Project entity
	 * 
	 */
	public Person savePersonProjectsForFkContactPersonId(Integer personId_9, Project related_projectsforfkcontactpersonid);

	/**
	 * Delete an existing Account entity
	 * 
	 */
	public Person deletePersonAccount(Integer person_personId_8, Integer related_account_accountId);

	/**
	 * Save an existing Account entity
	 * 
	 */
	public Person savePersonAccounts(Integer personId_10, Account related_accounts);

	/**
	 * Delete an existing Account entity
	 * 
	 */
	public Person deletePersonAccounts(Integer person_personId_9, Integer related_accounts_accountId);

	/**
	 * Delete an existing Statusupdate entity
	 * 
	 */
	public Person deletePersonStatusupdates(Integer person_personId_10, Integer related_statusupdates_statusId);

	/**
	 * Delete an existing Person entity
	 * 
	 */
	public void deletePerson(Person person_1);

	/**
	 * Save an existing Projectteam entity
	 * 
	 */
	public Person savePersonProjectteams(Integer personId_11, Projectteam related_projectteams);
}