//**********************************************************
// ProjecttemplateServiceImpl
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
import pm7.dao.ProjectDAO;
import pm7.dao.ProjecttemplateDAO;

import pm7.domain.Account;
import pm7.domain.Project;
import pm7.domain.Projecttemplate;

/**
 * Spring service that handles CRUD requests for Projecttemplate entities
 * 
 */

@Service("ProjecttemplateService")
@Transactional
public class ProjecttemplateServiceImpl implements ProjecttemplateService {

	/**
	 * DAO injected by Spring that manages Account entities
	 * 
	 */
	@Autowired
	private AccountDAO accountDAO;

	/**
	 * DAO injected by Spring that manages Project entities
	 * 
	 */
	@Autowired
	private ProjectDAO projectDAO;

	/**
	 * DAO injected by Spring that manages Projecttemplate entities
	 * 
	 */
	@Autowired
	private ProjecttemplateDAO projecttemplateDAO;

	/**
	 * Instantiates a new ProjecttemplateServiceImpl.
	 *
	 */
	public ProjecttemplateServiceImpl() {
	}

	/**
	 * Save an existing Account entity
	 * 
	 */
	@Transactional
	public Projecttemplate saveProjecttemplateAccount(Integer templateId, Account related_account) {
		Projecttemplate projecttemplate = projecttemplateDAO.findProjecttemplateByPrimaryKey(templateId, -1, -1);
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

		projecttemplate.setAccount(related_account);
		projecttemplate = projecttemplateDAO.store(projecttemplate);
		projecttemplateDAO.flush();

		related_account = accountDAO.store(related_account);
		accountDAO.flush();

		return projecttemplate;
	}

	/**
	 * Return all Projecttemplate entity
	 * 
	 */
	@Transactional
	public List<Projecttemplate> findAllProjecttemplates(Integer startResult, Integer maxRows) {
		return new java.util.ArrayList<Projecttemplate>(projecttemplateDAO.findAllProjecttemplates(startResult, maxRows));
	}

	/**
	 * Save an existing Projecttemplate entity
	 * 
	 */
	@Transactional
	public Projecttemplate saveProjecttemplate(Projecttemplate projecttemplate) {
		Projecttemplate existingProjecttemplate = projecttemplateDAO.findProjecttemplateByPrimaryKey(projecttemplate.getTemplateId());

		if (existingProjecttemplate != null) {
			if (existingProjecttemplate != projecttemplate) {
				existingProjecttemplate.setTemplateId(projecttemplate.getTemplateId());
				existingProjecttemplate.setTemplateName(projecttemplate.getTemplateName());
				existingProjecttemplate.setTemplateDesc(projecttemplate.getTemplateDesc());
				existingProjecttemplate.setActiveYn(projecttemplate.getActiveYn());
			}
			projecttemplate = projecttemplateDAO.store(existingProjecttemplate);
		} else {
			int projecttemplateId = projecttemplateDAO.getMaxProjecttemplateId();
			projecttemplate.setTemplateId(projecttemplateId+1);
//			person.setAccount(acct);
			projecttemplate = projecttemplateDAO.store(projecttemplate);
		}
//		if(attachmentId!=null && attachmentId>0){
//			attachment = attachmentDAO.findAccountByPrimaryKey(attachmentId);
//		}		
		projecttemplateDAO.flush();
		return projecttemplate;
		}

	/**
	 */
	@Transactional
	public Projecttemplate findProjecttemplateByPrimaryKey(Integer templateId) {
		return projecttemplateDAO.findProjecttemplateByPrimaryKey(templateId);
	}

	/**
	 * Delete an existing Account entity
	 * 
	 */
	@Transactional
	public Projecttemplate deleteProjecttemplateAccount(Integer projecttemplate_templateId, Integer related_account_accountId) {
		Projecttemplate projecttemplate = projecttemplateDAO.findProjecttemplateByPrimaryKey(projecttemplate_templateId, -1, -1);
		Account related_account = accountDAO.findAccountByPrimaryKey(related_account_accountId, -1, -1);

		projecttemplate.setAccount(null);
		projecttemplate = projecttemplateDAO.store(projecttemplate);
		projecttemplateDAO.flush();

		related_account = accountDAO.store(related_account);
		accountDAO.flush();

		accountDAO.remove(related_account);
		accountDAO.flush();

		return projecttemplate;
	}

	/**
	 * Save an existing Project entity
	 * 
	 */
	@Transactional
	public Projecttemplate saveProjecttemplateProject(Integer templateId, Project related_project) {
		Projecttemplate projecttemplate = projecttemplateDAO.findProjecttemplateByPrimaryKey(templateId, -1, -1);
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

		projecttemplate.setProject(related_project);
		related_project.getProjecttemplates().add(projecttemplate);
		projecttemplate = projecttemplateDAO.store(projecttemplate);
		projecttemplateDAO.flush();

		related_project = projectDAO.store(related_project);
		projectDAO.flush();

		return projecttemplate;
	}

	/**
	 * Delete an existing Project entity
	 * 
	 */
	@Transactional
	public Projecttemplate deleteProjecttemplateProject(Integer projecttemplate_templateId, Integer related_project_projectId) {
		Projecttemplate projecttemplate = projecttemplateDAO.findProjecttemplateByPrimaryKey(projecttemplate_templateId, -1, -1);
		Project related_project = projectDAO.findProjectByPrimaryKey(related_project_projectId, -1, -1);

		projecttemplate.setProject(null);
		related_project.getProjecttemplates().remove(projecttemplate);
		projecttemplate = projecttemplateDAO.store(projecttemplate);
		projecttemplateDAO.flush();

		related_project = projectDAO.store(related_project);
		projectDAO.flush();

		projectDAO.remove(related_project);
		projectDAO.flush();

		return projecttemplate;
	}

	/**
	 * Delete an existing Projecttemplate entity
	 * 
	 */
	@Transactional
	public void deleteProjecttemplate(Projecttemplate projecttemplate) {
		projecttemplateDAO.remove(projecttemplate);
		projecttemplateDAO.flush();
	}

	/**
	 * Return a count of all Projecttemplate entity
	 * 
	 */
	@Transactional
	public Integer countProjecttemplates() {
		return ((Long) projecttemplateDAO.createQuerySingleResult("select count(o) from Projecttemplate o").getSingleResult()).intValue();
	}

	/**
	 * Load an existing Projecttemplate entity
	 * 
	 */
	@Transactional
	public Set<Projecttemplate> loadProjecttemplates() {
		return projecttemplateDAO.findAllProjecttemplates();
	}
}
