//**********************************************************
// ProjectteamServiceImpl
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
import pm7.dao.ProjectteamDAO;

import pm7.domain.Account;
import pm7.domain.Person;
import pm7.domain.Project;
import pm7.domain.Projectteam;

/**
 * Spring service that handles CRUD requests for Projectteam entities
 * 
 */

@Service("ProjectteamService")
@Transactional
public class ProjectteamServiceImpl implements ProjectteamService {

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
	 * DAO injected by Spring that manages Projectteam entities
	 * 
	 */
	@Autowired
	private ProjectteamDAO projectteamDAO;

	/**
	 * Instantiates a new ProjectteamServiceImpl.
	 *
	 */
	public ProjectteamServiceImpl() {
	}

	/**
	 * Delete an existing Account entity
	 * 
	 */
	@Transactional
	public Projectteam deleteProjectteamAccount(Integer projectteam_projectTeamId, Integer related_account_accountId) {
		Projectteam projectteam = projectteamDAO.findProjectteamByPrimaryKey(projectteam_projectTeamId, -1, -1);
		Account related_account = accountDAO.findAccountByPrimaryKey(related_account_accountId, -1, -1);

		projectteam.setAccount(null);
		projectteam = projectteamDAO.store(projectteam);
		projectteamDAO.flush();

		related_account = accountDAO.store(related_account);
		accountDAO.flush();

		accountDAO.remove(related_account);
		accountDAO.flush();

		return projectteam;
	}

	/**
	 * Delete an existing Person entity
	 * 
	 */
	@Transactional
	public Projectteam deleteProjectteamPerson(Integer projectteam_projectTeamId, Integer related_person_personId) {
		Projectteam projectteam = projectteamDAO.findProjectteamByPrimaryKey(projectteam_projectTeamId, -1, -1);
		Person related_person = personDAO.findPersonByPrimaryKey(related_person_personId, -1, -1);

		projectteam.setPerson(null);
		related_person.getProjectteams().remove(projectteam);
		projectteam = projectteamDAO.store(projectteam);
		projectteamDAO.flush();

		related_person = personDAO.store(related_person);
		personDAO.flush();

		personDAO.remove(related_person);
		personDAO.flush();

		return projectteam;
	}

	/**
	 * Save an existing Projectteam entity
	 * 
	 */
	@Transactional
	public Projectteam saveProjectteam(Projectteam projectteam) {
		Projectteam existingProjectteam = projectteamDAO.findProjectteamByPrimaryKey(projectteam.getProjectTeamId());

		if (existingProjectteam != null) {
			if (existingProjectteam != projectteam) {
				existingProjectteam.setProjectTeamId(projectteam.getProjectTeamId());
				existingProjectteam.setProjectRole(projectteam.getProjectRole());
				existingProjectteam.setPersonProjectEstHrs(projectteam.getPersonProjectEstHrs());
				existingProjectteam.setPersonProjectActualHrs(projectteam.getPersonProjectActualHrs());
			}
			projectteam = projectteamDAO.store(existingProjectteam);
		} else {
			int projectteamId = projectteamDAO.getMaxProjectteamId();
			projectteam.setProjectTeamId(projectteamId+1);
//			person.setAccount(acct);
			projectteam = projectteamDAO.store(projectteam);
		}
//		if(attachmentId!=null && attachmentId>0){
//			attachment = attachmentDAO.findAccountByPrimaryKey(attachmentId);
//		}		
		projectteamDAO.flush();
		return projectteam;
		}

	/**
	 * Return all Projectteam entity
	 * 
	 */
	@Transactional
	public List<Projectteam> findAllProjectteams(Integer startResult, Integer maxRows) {
		return new java.util.ArrayList<Projectteam>(projectteamDAO.findAllProjectteams(startResult, maxRows));
	}

	/**
	 * Return a count of all Projectteam entity
	 * 
	 */
	@Transactional
	public Integer countProjectteams() {
		return ((Long) projectteamDAO.createQuerySingleResult("select count(o) from Projectteam o").getSingleResult()).intValue();
	}

	/**
	 */
	@Transactional
	public Projectteam findProjectteamByPrimaryKey(Integer projectTeamId) {
		return projectteamDAO.findProjectteamByPrimaryKey(projectTeamId);
	}

	/**
	 * Delete an existing Project entity
	 * 
	 */
	@Transactional
	public Projectteam deleteProjectteamProject(Integer projectteam_projectTeamId, Integer related_project_projectId) {
		Projectteam projectteam = projectteamDAO.findProjectteamByPrimaryKey(projectteam_projectTeamId, -1, -1);
		Project related_project = projectDAO.findProjectByPrimaryKey(related_project_projectId, -1, -1);

		projectteam.setProject(null);
		related_project.getProjectteams().remove(projectteam);
		projectteam = projectteamDAO.store(projectteam);
		projectteamDAO.flush();

		related_project = projectDAO.store(related_project);
		projectDAO.flush();

		projectDAO.remove(related_project);
		projectDAO.flush();

		return projectteam;
	}

	/**
	 * Delete an existing Projectteam entity
	 * 
	 */
	@Transactional
	public void deleteProjectteam(Projectteam projectteam) {
		projectteamDAO.remove(projectteam);
		projectteamDAO.flush();
	}

	/**
	 * Save an existing Project entity
	 * 
	 */
	@Transactional
	public Projectteam saveProjectteamProject(Integer projectTeamId, Project related_project) {
		Projectteam projectteam = projectteamDAO.findProjectteamByPrimaryKey(projectTeamId, -1, -1);
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

		projectteam.setProject(related_project);
		related_project.getProjectteams().add(projectteam);
		projectteam = projectteamDAO.store(projectteam);
		projectteamDAO.flush();

		related_project = projectDAO.store(related_project);
		projectDAO.flush();

		return projectteam;
	}

	/**
	 * Load an existing Projectteam entity
	 * 
	 */
	@Transactional
	public Set<Projectteam> loadProjectteams() {
		return projectteamDAO.findAllProjectteams();
	}

	/**
	 * Save an existing Person entity
	 * 
	 */
	@Transactional
	public Projectteam saveProjectteamPerson(Integer projectTeamId, Person related_person) {
		Projectteam projectteam = projectteamDAO.findProjectteamByPrimaryKey(projectTeamId, -1, -1);
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

		projectteam.setPerson(related_person);
		related_person.getProjectteams().add(projectteam);
		projectteam = projectteamDAO.store(projectteam);
		projectteamDAO.flush();

		related_person = personDAO.store(related_person);
		personDAO.flush();

		return projectteam;
	}

	/**
	 * Save an existing Account entity
	 * 
	 */
	@Transactional
	public Projectteam saveProjectteamAccount(Integer projectTeamId, Account related_account) {
		Projectteam projectteam = projectteamDAO.findProjectteamByPrimaryKey(projectTeamId, -1, -1);
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

		projectteam.setAccount(related_account);
		projectteam = projectteamDAO.store(projectteam);
		projectteamDAO.flush();

		related_account = accountDAO.store(related_account);
		accountDAO.flush();

		return projectteam;
	}
}
