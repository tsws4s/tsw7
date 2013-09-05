//**********************************************************
// PersonServiceImpl
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
import pm7.dao.AttachmentDAO;
import pm7.dao.ClientDAO;
import pm7.dao.PersonDAO;
import pm7.dao.ProjectDAO;
import pm7.dao.ProjectteamDAO;
import pm7.dao.StatusupdateDAO;
import pm7.dao.TaskDAO;
import pm7.dao.TimeentryDAO;

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

@Service("PersonService")
@Transactional
public class PersonServiceImpl implements PersonService {

	/**
	 * DAO injected by Spring that manages Account entities
	 * 
	 */
	@Autowired
	private AccountDAO accountDAO;

	/**
	 * DAO injected by Spring that manages Attachment entities
	 * 
	 */
	@Autowired
	private AttachmentDAO attachmentDAO;

	/**
	 * DAO injected by Spring that manages Client entities
	 * 
	 */
	@Autowired
	private ClientDAO clientDAO;

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
	 * DAO injected by Spring that manages Projectteam entities
	 * 
	 */
	@Autowired
	private ProjectteamDAO projectteamDAO;

	/**
	 * DAO injected by Spring that manages Statusupdate entities
	 * 
	 */
	@Autowired
	private StatusupdateDAO statusupdateDAO;

	/**
	 * DAO injected by Spring that manages Task entities
	 * 
	 */
	@Autowired
	private TaskDAO taskDAO;

	/**
	 * DAO injected by Spring that manages Timeentry entities
	 * 
	 */
	@Autowired
	private TimeentryDAO timeentryDAO;

	/**
	 * Instantiates a new PersonServiceImpl.
	 *
	 */
	public PersonServiceImpl() {
	}

	/**
	 */
	@Transactional
	public Person findPersonByPrimaryKey(Integer personId) {
		return personDAO.findPersonByPrimaryKey(personId);
	}

	/**
	 * Save an existing Timeentry entity
	 * 
	 */
	@Transactional
	public Person savePersonTimeentries(Integer personId, Timeentry related_timeentries) {
		Person person = personDAO.findPersonByPrimaryKey(personId, -1, -1);
		Timeentry existingtimeentries = timeentryDAO.findTimeentryByPrimaryKey(related_timeentries.getTimeEntryId());

		// copy into the existing record to preserve existing relationships
		if (existingtimeentries != null) {
			existingtimeentries.setTimeEntryId(related_timeentries.getTimeEntryId());
			existingtimeentries.setTimeHrs(related_timeentries.getTimeHrs());
			existingtimeentries.setRateAmt(related_timeentries.getRateAmt());
			existingtimeentries.setDate(related_timeentries.getDate());
			existingtimeentries.setDescription(related_timeentries.getDescription());
			related_timeentries = existingtimeentries;
		} else {
			related_timeentries = timeentryDAO.store(related_timeentries);
			timeentryDAO.flush();
		}

		related_timeentries.setPerson(person);
		person.getTimeentries().add(related_timeentries);
		related_timeentries = timeentryDAO.store(related_timeentries);
		timeentryDAO.flush();
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

		person = personDAO.store(person);
		personDAO.flush();

		return person;
	}

	/**
	 * Delete an existing Client entity
	 * 
	 */
	@Transactional
	public Person deletePersonClient(Integer person_personId, Integer related_client_clientId) {
		Person person = personDAO.findPersonByPrimaryKey(person_personId, -1, -1);
		Client related_client = clientDAO.findClientByPrimaryKey(related_client_clientId, -1, -1);

		person.setClient(null);
		related_client.getPersons().remove(person);
		person = personDAO.store(person);
		personDAO.flush();

		related_client = clientDAO.store(related_client);
		clientDAO.flush();

		clientDAO.remove(related_client);
		clientDAO.flush();

		return person;
	}

	/**
	 * Save an existing Task entity
	 * 
	 */
	@Transactional
	public Person savePersonTasks(Integer personId, Task related_tasks) {
		Person person = personDAO.findPersonByPrimaryKey(personId, -1, -1);
		Task existingtasks = taskDAO.findTaskByPrimaryKey(related_tasks.getTaskId());

		// copy into the existing record to preserve existing relationships
		if (existingtasks != null) {
			existingtasks.setTaskId(related_tasks.getTaskId());
			existingtasks.setStatus(related_tasks.getStatus());
			existingtasks.setTaskName(related_tasks.getTaskName());
			existingtasks.setTaskDescription(related_tasks.getTaskDescription());
			existingtasks.setStartDate(related_tasks.getStartDate());
			existingtasks.setTargetDate(related_tasks.getTargetDate());
			existingtasks.setCompleteDate(related_tasks.getCompleteDate());
			existingtasks.setPercentComplete(related_tasks.getPercentComplete());
			existingtasks.setEstimateHrs(related_tasks.getEstimateHrs());
			existingtasks.setActualHrs(related_tasks.getActualHrs());
			existingtasks.setTaskType(related_tasks.getTaskType());
			related_tasks = existingtasks;
		} else {
			related_tasks = taskDAO.store(related_tasks);
			taskDAO.flush();
		}

		related_tasks.setPerson(person);
		person.getTasks().add(related_tasks);
		related_tasks = taskDAO.store(related_tasks);
		taskDAO.flush();
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

		person = personDAO.store(person);
		personDAO.flush();

		return person;
	}

	/**
	 * Load an existing Person entity
	 * 
	 */
	@Transactional
	public Set<Person> loadPersons() {
		return personDAO.findAllPersons();
	}

	/**
	 * Save an existing Statusupdate entity
	 * 
	 */
	@Transactional
	public Person savePersonStatusupdates(Integer personId, Statusupdate related_statusupdates) {
		Person person = personDAO.findPersonByPrimaryKey(personId, -1, -1);
		Statusupdate existingstatusupdates = statusupdateDAO.findStatusupdateByPrimaryKey(related_statusupdates.getStatusId());

		// copy into the existing record to preserve existing relationships
		if (existingstatusupdates != null) {
			existingstatusupdates.setStatusId(related_statusupdates.getStatusId());
			existingstatusupdates.setStatusDate(related_statusupdates.getStatusDate());
			existingstatusupdates.setStatusUpdateDesc(related_statusupdates.getStatusUpdateDesc());
			existingstatusupdates.setEstHrsLeft(related_statusupdates.getEstHrsLeft());
			existingstatusupdates.setRiskGyr(related_statusupdates.getRiskGyr());
			related_statusupdates = existingstatusupdates;
		} else {
			related_statusupdates = statusupdateDAO.store(related_statusupdates);
			statusupdateDAO.flush();
		}

		related_statusupdates.setPerson(person);
		person.getStatusupdates().add(related_statusupdates);
		related_statusupdates = statusupdateDAO.store(related_statusupdates);
		statusupdateDAO.flush();
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

		person = personDAO.store(person);
		personDAO.flush();

		return person;
	}

	/**
	 * Save an existing Attachment entity
	 * 
	 */
	@Transactional
	public Person savePersonAttachments(Integer personId, Attachment related_attachments) {
		Person person = personDAO.findPersonByPrimaryKey(personId, -1, -1);
		Attachment existingattachments = attachmentDAO.findAttachmentByPrimaryKey(related_attachments.getAttachId());

		// copy into the existing record to preserve existing relationships
		if (existingattachments != null) {
			existingattachments.setAttachId(related_attachments.getAttachId());
			existingattachments.setAttachmentType(related_attachments.getAttachmentType());
			existingattachments.setAttachmentUrl(related_attachments.getAttachmentUrl());
			related_attachments = existingattachments;
		} else {
			related_attachments = attachmentDAO.store(related_attachments);
			attachmentDAO.flush();
		}

		related_attachments.setPerson(person);
		person.getAttachments().add(related_attachments);
		related_attachments = attachmentDAO.store(related_attachments);
		attachmentDAO.flush();

		person = personDAO.store(person);
		personDAO.flush();

		return person;
	}

	/**
	 * Save an existing Person entity
	 * 
	 */
	@Transactional
	public Person savePerson(Person person) {
		Person existingPerson = personDAO.findPersonByPrimaryKey(person.getPersonId());

		if (existingPerson != null) {
			if (existingPerson != person) {
				existingPerson.setPersonId(person.getPersonId());
				existingPerson.setFirstname(person.getFirstname());
				existingPerson.setLastname(person.getLastname());
				existingPerson.setPhone(person.getPhone());
				existingPerson.setEmail(person.getEmail());
				existingPerson.setDefaultProjectRole(person.getDefaultProjectRole());
				existingPerson.setAddress(person.getAddress());
				existingPerson.setCity(person.getCity());
				existingPerson.setState(person.getState());
				existingPerson.setZip(person.getZip());
				existingPerson.setActiveYn(person.getActiveYn());
			}
			person = personDAO.store(existingPerson);
		} else {
			int personId = personDAO.getMaxPersonId();
			person.setPersonId(personId+1);
//			person.setAccount(acct);
			person = personDAO.store(person);
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
		personDAO.flush();
		return person;
		}

	/**
	 * Save an existing Project entity
	 * 
	 */
	@Transactional
	public Person savePersonProjectsForFkProjMgrId(Integer personId, Project related_projectsforfkprojmgrid) {
		Person person = personDAO.findPersonByPrimaryKey(personId, -1, -1);
		Project existingprojectsForFkProjMgrId = projectDAO.findProjectByPrimaryKey(related_projectsforfkprojmgrid.getProjectId());

		// copy into the existing record to preserve existing relationships
		if (existingprojectsForFkProjMgrId != null) {
			existingprojectsForFkProjMgrId.setProjectId(related_projectsforfkprojmgrid.getProjectId());
			existingprojectsForFkProjMgrId.setProjectName(related_projectsforfkprojmgrid.getProjectName());
			existingprojectsForFkProjMgrId.setProjectDesc(related_projectsforfkprojmgrid.getProjectDesc());
			existingprojectsForFkProjMgrId.setProjectType(related_projectsforfkprojmgrid.getProjectType());
			existingprojectsForFkProjMgrId.setStartDate(related_projectsforfkprojmgrid.getStartDate());
			existingprojectsForFkProjMgrId.setDueDate(related_projectsforfkprojmgrid.getDueDate());
			existingprojectsForFkProjMgrId.setCompleteDate(related_projectsforfkprojmgrid.getCompleteDate());
			existingprojectsForFkProjMgrId.setEstimateHrs(related_projectsforfkprojmgrid.getEstimateHrs());
			existingprojectsForFkProjMgrId.setActualHrs(related_projectsforfkprojmgrid.getActualHrs());
			existingprojectsForFkProjMgrId.setHrRate(related_projectsforfkprojmgrid.getHrRate());
			existingprojectsForFkProjMgrId.setActiveYn(related_projectsforfkprojmgrid.getActiveYn());
			related_projectsforfkprojmgrid = existingprojectsForFkProjMgrId;
		} else {
			related_projectsforfkprojmgrid = projectDAO.store(related_projectsforfkprojmgrid);
			projectDAO.flush();
		}

		related_projectsforfkprojmgrid.setPersonByFkContactPersonId(person);
		person.getProjectsForFkContactPersonId().add(related_projectsforfkprojmgrid);
		related_projectsforfkprojmgrid = projectDAO.store(related_projectsforfkprojmgrid);
		projectDAO.flush();

		person = personDAO.store(person);
		personDAO.flush();

		return person;
	}

	/**
	 * Delete an existing Client entity
	 * 
	 */
	@Transactional
	public Person deletePersonClients(Integer person_personId, Integer related_clients_clientId) {
		Client related_clients = clientDAO.findClientByPrimaryKey(related_clients_clientId, -1, -1);

		Person person = personDAO.findPersonByPrimaryKey(person_personId, -1, -1);

		related_clients.setPerson(null);
		person.getClients().remove(related_clients);

		clientDAO.remove(related_clients);
		clientDAO.flush();

		return person;
	}

	/**
	 * Delete an existing Timeentry entity
	 * 
	 */
	@Transactional
	public Person deletePersonTimeentries(Integer person_personId, Integer related_timeentries_timeEntryId) {
		Timeentry related_timeentries = timeentryDAO.findTimeentryByPrimaryKey(related_timeentries_timeEntryId, -1, -1);

		Person person = personDAO.findPersonByPrimaryKey(person_personId, -1, -1);

		related_timeentries.setPerson(null);
		person.getTimeentries().remove(related_timeentries);

		timeentryDAO.remove(related_timeentries);
		timeentryDAO.flush();

		return person;
	}

	/**
	 * Return all Person entity
	 * 
	 */
	@Transactional
	public List<Person> findAllPersons(Integer startResult, Integer maxRows) {
		return new java.util.ArrayList<Person>(personDAO.findAllPersons(startResult, maxRows));
	}

	/**
	 * Delete an existing Task entity
	 * 
	 */
	@Transactional
	public Person deletePersonTasks(Integer person_personId, Integer related_tasks_taskId) {
		Task related_tasks = taskDAO.findTaskByPrimaryKey(related_tasks_taskId, -1, -1);

		Person person = personDAO.findPersonByPrimaryKey(person_personId, -1, -1);

		related_tasks.setPerson(null);
		person.getTasks().remove(related_tasks);

		taskDAO.remove(related_tasks);
		taskDAO.flush();

		return person;
	}

	/**
	 * Delete an existing Attachment entity
	 * 
	 */
	@Transactional
	public Person deletePersonAttachments(Integer person_personId, Integer related_attachments_attachId) {
		Attachment related_attachments = attachmentDAO.findAttachmentByPrimaryKey(related_attachments_attachId, -1, -1);

		Person person = personDAO.findPersonByPrimaryKey(person_personId, -1, -1);

		related_attachments.setPerson(null);
		person.getAttachments().remove(related_attachments);

		attachmentDAO.remove(related_attachments);
		attachmentDAO.flush();

		return person;
	}

	/**
	 * Save an existing Client entity
	 * 
	 */
	@Transactional
	public Person savePersonClient(Integer personId, Client related_client) {
		Person person = personDAO.findPersonByPrimaryKey(personId, -1, -1);
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

		person.setClient(related_client);
		related_client.getPersons().add(person);
		person = personDAO.store(person);
		personDAO.flush();

		related_client = clientDAO.store(related_client);
		clientDAO.flush();

		return person;
	}

	/**
	 * Return a count of all Person entity
	 * 
	 */
	@Transactional
	public Integer countPersons() {
		return ((Long) personDAO.createQuerySingleResult("select count(o) from Person o").getSingleResult()).intValue();
	}

	/**
	 * Delete an existing Project entity
	 * 
	 */
	@Transactional
	public Person deletePersonProjectsForFkContactPersonId(Integer person_personId, Integer related_projectsforfkcontactpersonid_projectId) {
		Project related_projectsforfkcontactpersonid = projectDAO.findProjectByPrimaryKey(related_projectsforfkcontactpersonid_projectId, -1, -1);

		Person person = personDAO.findPersonByPrimaryKey(person_personId, -1, -1);

		related_projectsforfkcontactpersonid.setPersonByFkContactPersonId(null);
		person.getProjectsForFkContactPersonId().remove(related_projectsforfkcontactpersonid);

		projectDAO.remove(related_projectsforfkcontactpersonid);
		projectDAO.flush();

		return person;
	}

	/**
	 * Save an existing Account entity
	 * 
	 */
	@Transactional
	public Person savePersonAccount(Integer personId, Account related_account) {
		Person person = personDAO.findPersonByPrimaryKey(personId, -1, -1);
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

		person.setAccount(related_account);
		person = personDAO.store(person);
		personDAO.flush();

		related_account = accountDAO.store(related_account);
		accountDAO.flush();

		return person;
	}

	/**
	 * Delete an existing Projectteam entity
	 * 
	 */
	@Transactional
	public Person deletePersonProjectteams(Integer person_personId, Integer related_projectteams_projectTeamId) {
		Projectteam related_projectteams = projectteamDAO.findProjectteamByPrimaryKey(related_projectteams_projectTeamId, -1, -1);

		Person person = personDAO.findPersonByPrimaryKey(person_personId, -1, -1);

		related_projectteams.setPerson(null);
		person.getProjectteams().remove(related_projectteams);

		projectteamDAO.remove(related_projectteams);
		projectteamDAO.flush();

		return person;
	}

	/**
	 * Delete an existing Project entity
	 * 
	 */
	@Transactional
	public Person deletePersonProjectsForFkProjMgrId(Integer person_personId, Integer related_projectsforfkprojmgrid_projectId) {
		Project related_projectsforfkprojmgrid = projectDAO.findProjectByPrimaryKey(related_projectsforfkprojmgrid_projectId, -1, -1);

		Person person = personDAO.findPersonByPrimaryKey(person_personId, -1, -1);

		related_projectsforfkprojmgrid.setPersonByFkContactPersonId(null);
		person.getProjectsForFkContactPersonId().remove(related_projectsforfkprojmgrid);

		projectDAO.remove(related_projectsforfkprojmgrid);
		projectDAO.flush();

		return person;
	}

	/**
	 * Save an existing Client entity
	 * 
	 */
	@Transactional
	public Person savePersonClients(Integer personId, Client related_clients) {
		Person person = personDAO.findPersonByPrimaryKey(personId, -1, -1);
		Client existingclients = clientDAO.findClientByPrimaryKey(related_clients.getClientId());

		// copy into the existing record to preserve existing relationships
		if (existingclients != null) {
			existingclients.setClientId(related_clients.getClientId());
			existingclients.setClientName(related_clients.getClientName());
			existingclients.setPhone(related_clients.getPhone());
			existingclients.setEmail(related_clients.getEmail());
			existingclients.setWebsite(related_clients.getWebsite());
			existingclients.setAddress(related_clients.getAddress());
			existingclients.setCity(related_clients.getCity());
			existingclients.setState(related_clients.getState());
			existingclients.setZip(related_clients.getZip());
			existingclients.setLogoFilename(related_clients.getLogoFilename());
			existingclients.setActiveYn(related_clients.getActiveYn());
			related_clients = existingclients;
		} else {
			related_clients = clientDAO.store(related_clients);
			clientDAO.flush();
		}

		related_clients.setPerson(person);
		person.getClients().add(related_clients);
		related_clients = clientDAO.store(related_clients);
		clientDAO.flush();

		person = personDAO.store(person);
		personDAO.flush();

		return person;
	}

	/**
	 * Save an existing Project entity
	 * 
	 */
	@Transactional
	public Person savePersonProjectsForFkContactPersonId(Integer personId, Project related_projectsforfkcontactpersonid) {
		Person person = personDAO.findPersonByPrimaryKey(personId, -1, -1);
		Project existingprojectsForFkContactPersonId = projectDAO.findProjectByPrimaryKey(related_projectsforfkcontactpersonid.getProjectId());

		// copy into the existing record to preserve existing relationships
		if (existingprojectsForFkContactPersonId != null) {
			existingprojectsForFkContactPersonId.setProjectId(related_projectsforfkcontactpersonid.getProjectId());
			existingprojectsForFkContactPersonId.setProjectName(related_projectsforfkcontactpersonid.getProjectName());
			existingprojectsForFkContactPersonId.setProjectDesc(related_projectsforfkcontactpersonid.getProjectDesc());
			existingprojectsForFkContactPersonId.setProjectType(related_projectsforfkcontactpersonid.getProjectType());
			existingprojectsForFkContactPersonId.setStartDate(related_projectsforfkcontactpersonid.getStartDate());
			existingprojectsForFkContactPersonId.setDueDate(related_projectsforfkcontactpersonid.getDueDate());
			existingprojectsForFkContactPersonId.setCompleteDate(related_projectsforfkcontactpersonid.getCompleteDate());
			existingprojectsForFkContactPersonId.setEstimateHrs(related_projectsforfkcontactpersonid.getEstimateHrs());
			existingprojectsForFkContactPersonId.setActualHrs(related_projectsforfkcontactpersonid.getActualHrs());
			existingprojectsForFkContactPersonId.setHrRate(related_projectsforfkcontactpersonid.getHrRate());
			existingprojectsForFkContactPersonId.setActiveYn(related_projectsforfkcontactpersonid.getActiveYn());
			related_projectsforfkcontactpersonid = existingprojectsForFkContactPersonId;
		} else {
			related_projectsforfkcontactpersonid = projectDAO.store(related_projectsforfkcontactpersonid);
			projectDAO.flush();
		}

		related_projectsforfkcontactpersonid.setPersonByFkContactPersonId(person);
		person.getProjectsForFkContactPersonId().add(related_projectsforfkcontactpersonid);
		related_projectsforfkcontactpersonid = projectDAO.store(related_projectsforfkcontactpersonid);
		projectDAO.flush();

		person = personDAO.store(person);
		personDAO.flush();

		return person;
	}

	/**
	 * Delete an existing Account entity
	 * 
	 */
	@Transactional
	public Person deletePersonAccount(Integer person_personId, Integer related_account_accountId) {
		Person person = personDAO.findPersonByPrimaryKey(person_personId, -1, -1);
		Account related_account = accountDAO.findAccountByPrimaryKey(related_account_accountId, -1, -1);

		person.setAccount(null);
		person = personDAO.store(person);
		personDAO.flush();

		related_account = accountDAO.store(related_account);
		accountDAO.flush();

		accountDAO.remove(related_account);
		accountDAO.flush();

		return person;
	}

	/**
	 * Save an existing Account entity
	 * 
	 */
	@Transactional
	public Person savePersonAccounts(Integer personId, Account related_accounts) {
		Person person = personDAO.findPersonByPrimaryKey(personId, -1, -1);
		Account existingaccounts = accountDAO.findAccountByPrimaryKey(related_accounts.getAccountId());

		// copy into the existing record to preserve existing relationships
		if (existingaccounts != null) {
			existingaccounts.setAccountId(related_accounts.getAccountId());
			existingaccounts.setAccountName(related_accounts.getAccountName());
			existingaccounts.setExpireDate(related_accounts.getExpireDate());
			related_accounts = existingaccounts;
		}

		related_accounts.setPerson(person);
		person.getAccounts().add(related_accounts);
		related_accounts = accountDAO.store(related_accounts);
		accountDAO.flush();

		person = personDAO.store(person);
		personDAO.flush();

		return person;
	}

	/**
	 * Delete an existing Account entity
	 * 
	 */
	@Transactional
	public Person deletePersonAccounts(Integer person_personId, Integer related_accounts_accountId) {
		Account related_accounts = accountDAO.findAccountByPrimaryKey(related_accounts_accountId, -1, -1);

		Person person = personDAO.findPersonByPrimaryKey(person_personId, -1, -1);

		related_accounts.setPerson(null);
		person.getAccounts().remove(related_accounts);

		accountDAO.remove(related_accounts);
		accountDAO.flush();

		return person;
	}

	/**
	 * Delete an existing Statusupdate entity
	 * 
	 */
	@Transactional
	public Person deletePersonStatusupdates(Integer person_personId, Integer related_statusupdates_statusId) {
		Statusupdate related_statusupdates = statusupdateDAO.findStatusupdateByPrimaryKey(related_statusupdates_statusId, -1, -1);

		Person person = personDAO.findPersonByPrimaryKey(person_personId, -1, -1);

		related_statusupdates.setPerson(null);
		person.getStatusupdates().remove(related_statusupdates);

		statusupdateDAO.remove(related_statusupdates);
		statusupdateDAO.flush();

		return person;
	}

	/**
	 * Delete an existing Person entity
	 * 
	 */
	@Transactional
	public void deletePerson(Person person) {
		personDAO.remove(person);
		personDAO.flush();
	}

	/**
	 * Save an existing Projectteam entity
	 * 
	 */
	@Transactional
	public Person savePersonProjectteams(Integer personId, Projectteam related_projectteams) {
		Person person = personDAO.findPersonByPrimaryKey(personId, -1, -1);
		Projectteam existingprojectteams = projectteamDAO.findProjectteamByPrimaryKey(related_projectteams.getProjectTeamId());

		// copy into the existing record to preserve existing relationships
		if (existingprojectteams != null) {
			existingprojectteams.setProjectTeamId(related_projectteams.getProjectTeamId());
			existingprojectteams.setProjectRole(related_projectteams.getProjectRole());
			existingprojectteams.setPersonProjectEstHrs(related_projectteams.getPersonProjectEstHrs());
			existingprojectteams.setPersonProjectActualHrs(related_projectteams.getPersonProjectActualHrs());
			related_projectteams = existingprojectteams;
		} else {
			related_projectteams = projectteamDAO.store(related_projectteams);
			projectteamDAO.flush();
		}

		related_projectteams.setPerson(person);
		person.getProjectteams().add(related_projectteams);
		related_projectteams = projectteamDAO.store(related_projectteams);
		projectteamDAO.flush();

		person = personDAO.store(person);
		personDAO.flush();

		return person;
	}
}
