package pm7.service;

import java.util.List;
import java.util.Set;

import pm7.domain.Account;
import pm7.domain.Project;
import pm7.domain.Projecttemplate;

/**
 * Spring service that handles CRUD requests for Projecttemplate entities
 * 
 */
public interface ProjecttemplateService {

	/**
	 * Save an existing Account entity
	 * 
	 */
	public Projecttemplate saveProjecttemplateAccount(Integer templateId, Account related_account);

	/**
	 * Return all Projecttemplate entity
	 * 
	 */
	public List<Projecttemplate> findAllProjecttemplates(Integer startResult, Integer maxRows);

	/**
	 * Save an existing Projecttemplate entity
	 * 
	 */
	public Projecttemplate saveProjecttemplate(Projecttemplate projecttemplate);

	/**
	 */
	public Projecttemplate findProjecttemplateByPrimaryKey(Integer templateId_1);

	/**
	 * Delete an existing Account entity
	 * 
	 */
	public Projecttemplate deleteProjecttemplateAccount(Integer projecttemplate_templateId, Integer related_account_accountId);

	/**
	 * Save an existing Project entity
	 * 
	 */
	public Projecttemplate saveProjecttemplateProject(Integer templateId_2, Project related_project);

	/**
	 * Delete an existing Project entity
	 * 
	 */
	public Projecttemplate deleteProjecttemplateProject(Integer projecttemplate_templateId_1, Integer related_project_projectId);

	/**
	 * Delete an existing Projecttemplate entity
	 * 
	 */
	public void deleteProjecttemplate(Projecttemplate projecttemplate_1);

	/**
	 * Return a count of all Projecttemplate entity
	 * 
	 */
	public Integer countProjecttemplates();

	/**
	 * Load an existing Projecttemplate entity
	 * 
	 */
	public Set<Projecttemplate> loadProjecttemplates();
}