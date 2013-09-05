//**********************************************************
// TimeentryServiceImpl
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
import pm7.dao.PersonDAO;
import pm7.dao.ProjectDAO;
import pm7.dao.TaskDAO;
import pm7.dao.TimeentryDAO;

import pm7.domain.Account;
import pm7.domain.Person;
import pm7.domain.Project;
import pm7.domain.Task;
import pm7.domain.Timeentry;

/**
 * Spring service that handles CRUD requests for Timeentry entities
 * 
 */

@Service("TimeentryService")
@Transactional
public class TimeentryServiceImpl implements TimeentryService {

	/**
	 * DAO injected by Spring that manages Account entities
	 * 
	 */
	@Autowired
	private AccountDAO accountDAO;

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
	 * Instantiates a new TimeentryServiceImpl.
	 *
	 */
	public TimeentryServiceImpl() {
	}

	/**
	 * Delete an existing Person entity
	 * 
	 */
	@Transactional
	public Timeentry deleteTimeentryPerson(Integer timeentry_timeEntryId, Integer related_person_personId) {
		Timeentry timeentry = timeentryDAO.findTimeentryByPrimaryKey(timeentry_timeEntryId, -1, -1);
		Person related_person = personDAO.findPersonByPrimaryKey(related_person_personId, -1, -1);

		timeentry.setPerson(null);
		related_person.getTimeentries().remove(timeentry);
		timeentry = timeentryDAO.store(timeentry);
		timeentryDAO.flush();

		related_person = personDAO.store(related_person);
		personDAO.flush();

		personDAO.remove(related_person);
		personDAO.flush();

		return timeentry;
	}

	/**
	 * Save an existing Project entity
	 * 
	 */
	@Transactional
	public Timeentry saveTimeentryProject(Integer timeEntryId, Project related_project) {
		Timeentry timeentry = timeentryDAO.findTimeentryByPrimaryKey(timeEntryId, -1, -1);
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

		timeentry.setProject(related_project);
		related_project.getTimeentries().add(timeentry);
		timeentry = timeentryDAO.store(timeentry);
		timeentryDAO.flush();

		related_project = projectDAO.store(related_project);
		projectDAO.flush();

		return timeentry;
	}

	/**
	 * Return a count of all Timeentry entity
	 * 
	 */
	@Transactional
	public Integer countTimeentrys() {
		return ((Long) timeentryDAO.createQuerySingleResult("select count(o) from Timeentry o").getSingleResult()).intValue();
	}

	/**
	 * Save an existing Timeentry entity
	 * 
	 */
	@Transactional
	public Timeentry saveTimeentry(Timeentry timeentry) {
		Timeentry existingTimeentry = timeentryDAO.findTimeentryByPrimaryKey(timeentry.getTimeEntryId());

		if (existingTimeentry != null) {
			if (existingTimeentry != timeentry) {
				existingTimeentry.setTimeEntryId(timeentry.getTimeEntryId());
				existingTimeentry.setTimeHrs(timeentry.getTimeHrs());
				existingTimeentry.setRateAmt(timeentry.getRateAmt());
				existingTimeentry.setDate(timeentry.getDate());
				existingTimeentry.setDescription(timeentry.getDescription());
			}
			timeentry = timeentryDAO.store(existingTimeentry);
		} else {
			int timeentryId = timeentryDAO.getMaxTimeentryId();
			timeentry.setTimeEntryId(timeentryId+1);
//			person.setAccount(acct);
			timeentry = timeentryDAO.store(timeentry);
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
		timeentryDAO.flush();
		return timeentry;
		}

	/**
	 * Save an existing Account entity
	 * 
	 */
	@Transactional
	public Timeentry saveTimeentryAccount(Integer timeEntryId, Account related_account) {
		Timeentry timeentry = timeentryDAO.findTimeentryByPrimaryKey(timeEntryId, -1, -1);
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

		timeentry.setAccount(related_account);
		timeentry = timeentryDAO.store(timeentry);
		timeentryDAO.flush();

		related_account = accountDAO.store(related_account);
		accountDAO.flush();

		return timeentry;
	}

	/**
	 * Load an existing Timeentry entity
	 * 
	 */
	@Transactional
	public Set<Timeentry> loadTimeentrys() {
		return timeentryDAO.findAllTimeentrys();
	}

	/**
	 * Save an existing Person entity
	 * 
	 */
	@Transactional
	public Timeentry saveTimeentryPerson(Integer timeEntryId, Person related_person) {
		Timeentry timeentry = timeentryDAO.findTimeentryByPrimaryKey(timeEntryId, -1, -1);
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

		timeentry.setPerson(related_person);
		related_person.getTimeentries().add(timeentry);
		timeentry = timeentryDAO.store(timeentry);
		timeentryDAO.flush();

		related_person = personDAO.store(related_person);
		personDAO.flush();

		return timeentry;
	}

	/**
	 * Delete an existing Project entity
	 * 
	 */
	@Transactional
	public Timeentry deleteTimeentryProject(Integer timeentry_timeEntryId, Integer related_project_projectId) {
		Timeentry timeentry = timeentryDAO.findTimeentryByPrimaryKey(timeentry_timeEntryId, -1, -1);
		Project related_project = projectDAO.findProjectByPrimaryKey(related_project_projectId, -1, -1);

		timeentry.setProject(null);
		related_project.getTimeentries().remove(timeentry);
		timeentry = timeentryDAO.store(timeentry);
		timeentryDAO.flush();

		related_project = projectDAO.store(related_project);
		projectDAO.flush();

		projectDAO.remove(related_project);
		projectDAO.flush();

		return timeentry;
	}

	/**
	 * Delete an existing Task entity
	 * 
	 */
	@Transactional
	public Timeentry deleteTimeentryTask(Integer timeentry_timeEntryId, Integer related_task_taskId) {
		Timeentry timeentry = timeentryDAO.findTimeentryByPrimaryKey(timeentry_timeEntryId, -1, -1);
		Task related_task = taskDAO.findTaskByPrimaryKey(related_task_taskId, -1, -1);

		timeentry.setTask(null);
		related_task.getTimeentries().remove(timeentry);
		timeentry = timeentryDAO.store(timeentry);
		timeentryDAO.flush();

		related_task = taskDAO.store(related_task);
		taskDAO.flush();

		taskDAO.remove(related_task);
		taskDAO.flush();

		return timeentry;
	}

	/**
	 * Save an existing Task entity
	 * 
	 */
	@Transactional
	public Timeentry saveTimeentryTask(Integer timeEntryId, Task related_task) {
		Timeentry timeentry = timeentryDAO.findTimeentryByPrimaryKey(timeEntryId, -1, -1);
		Task existingtask = taskDAO.findTaskByPrimaryKey(related_task.getTaskId());

		// copy into the existing record to preserve existing relationships
		if (existingtask != null) {
			existingtask.setTaskId(related_task.getTaskId());
			existingtask.setStatus(related_task.getStatus());
			existingtask.setTaskName(related_task.getTaskName());
			existingtask.setTaskDescription(related_task.getTaskDescription());
			existingtask.setStartDate(related_task.getStartDate());
			existingtask.setTargetDate(related_task.getTargetDate());
			existingtask.setCompleteDate(related_task.getCompleteDate());
			existingtask.setPercentComplete(related_task.getPercentComplete());
			existingtask.setEstimateHrs(related_task.getEstimateHrs());
			existingtask.setActualHrs(related_task.getActualHrs());
			existingtask.setTaskType(related_task.getTaskType());
			related_task = existingtask;
		} else {
			related_task = taskDAO.store(related_task);
			taskDAO.flush();
		}

		timeentry.setTask(related_task);
		related_task.getTimeentries().add(timeentry);
		timeentry = timeentryDAO.store(timeentry);
		timeentryDAO.flush();

		related_task = taskDAO.store(related_task);
		taskDAO.flush();

		return timeentry;
	}

	/**
	 * Delete an existing Account entity
	 * 
	 */
	@Transactional
	public Timeentry deleteTimeentryAccount(Integer timeentry_timeEntryId, Integer related_account_accountId) {
		Timeentry timeentry = timeentryDAO.findTimeentryByPrimaryKey(timeentry_timeEntryId, -1, -1);
		Account related_account = accountDAO.findAccountByPrimaryKey(related_account_accountId, -1, -1);

		timeentry.setAccount(null);
		timeentry = timeentryDAO.store(timeentry);
		timeentryDAO.flush();

		related_account = accountDAO.store(related_account);
		accountDAO.flush();

		accountDAO.remove(related_account);
		accountDAO.flush();

		return timeentry;
	}

	/**
	 * Return all Timeentry entity
	 * 
	 */
	@Transactional
	public List<Timeentry> findAllTimeentrys(Integer startResult, Integer maxRows) {
		return new java.util.ArrayList<Timeentry>(timeentryDAO.findAllTimeentrys(startResult, maxRows));
	}

	/**
	 */
	@Transactional
	public Timeentry findTimeentryByPrimaryKey(Integer timeEntryId) {
		return timeentryDAO.findTimeentryByPrimaryKey(timeEntryId);
	}

	/**
	 * Delete an existing Timeentry entity
	 * 
	 */
	@Transactional
	public void deleteTimeentry(Timeentry timeentry) {
		timeentryDAO.remove(timeentry);
		timeentryDAO.flush();
	}
}
