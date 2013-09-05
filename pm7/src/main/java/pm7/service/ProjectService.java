package pm7.service;

import java.util.List;
import java.util.Set;

import pm7.domain.Account;
import pm7.domain.Attachment;
import pm7.domain.Changerequest;
import pm7.domain.Client;
import pm7.domain.Defect;
import pm7.domain.Feature;
import pm7.domain.Invoice;
import pm7.domain.Invoiceitem;
import pm7.domain.Person;
import pm7.domain.Project;
import pm7.domain.Projectteam;
import pm7.domain.Releaseplan;
import pm7.domain.Requirement;
import pm7.domain.Statusupdate;
import pm7.domain.Task;
import pm7.domain.Testcase;
import pm7.domain.Timeentry;

/**
 * Spring service that handles CRUD requests for Project entities
 * 
 */
public interface ProjectService {

	/**
	 * Save an existing Timeentry entity
	 * 
	 */
	public Project saveProjectTimeentries(Integer projectId, Timeentry related_timeentries);

	/**
	 * Save an existing Project entity
	 * 
	 */
	public Project saveProject(Project project, Integer selected_id1, Integer selected_id2);

	/**
	 * Delete an existing Project entity
	 * 
	 */
	public void deleteProject(Project project_1);

	/**
	 * Save an existing Projectteam entity
	 * 
	 */
	public Project saveProjectProjectteams(Integer projectId_1, Integer selected_id1, Projectteam related_projectteams);

	/**
	 * Delete an existing Changerequest entity
	 * 
	 */
	public Project deleteProjectChangerequests(Integer project_projectId, Integer related_changerequests_changeId);

	/**
	 * Return a count of all Project entity
	 * 
	 */
	public Integer countProjects();

	/**
	 * Delete an existing Timeentry entity
	 * 
	 */
	public Project deleteProjectTimeentries(Integer project_projectId_1, Integer related_timeentries_timeEntryId);

	/**
	 * Delete an existing Attachment entity
	 * 
	 */
	public Project deleteProjectAttachments(Integer project_projectId_2, Integer related_attachments_attachId);

	/**
	 * Delete an existing Requirement entity
	 * 
	 */
	public Project deleteProjectRequirements(Integer project_projectId_3, Integer related_requirements_reqmtId);

	/**
	 * Save an existing Releaseplan entity
	 * 
	 */
	public Project saveProjectReleaseplans(Integer projectId_2, Releaseplan related_releaseplans);

	/**
	 * Delete an existing Statusupdate entity
	 * 
	 */
	public Project deleteProjectStatusupdates(Integer project_projectId_4, Integer related_statusupdates_statusId);

	/**
	 * Save an existing Person entity
	 * 
	 */
	public Project saveProjectPersonByFkContactPersonId(Integer projectId_3, Person related_personbyfkcontactpersonid);

	/**
	 * Save an existing Requirement entity
	 * 
	 */
	public Project saveProjectRequirements(Integer projectId_4, Requirement related_requirements);

	/**
	 * Delete an existing Account entity
	 * 
	 */
	public Project deleteProjectAccount(Integer project_projectId_5, Integer related_account_accountId);

	/**
	 * Delete an existing Task entity
	 * 
	 */
	public Project deleteProjectTasks(Integer project_projectId_6, Integer related_tasks_taskId);

	/**
	 * Delete an existing Releaseplan entity
	 * 
	 */
	public Project deleteProjectReleaseplans(Integer project_projectId_7, Integer related_releaseplans_releaseId);

	/**
	 * Return all Project entity
	 * 
	 */
	public List<Project> findAllProjects(Integer startResult, Integer maxRows);

	/**
	 * Save an existing Attachment entity
	 * 
	 */
	public Project saveProjectAttachments(Integer projectId_5, Attachment related_attachments);

	/**
	 * Delete an existing Person entity
	 * 
	 */
	public Project deleteProjectPersonByFkProjMgrId(Integer project_projectId_8, Integer related_personbyfkprojmgrid_personId);

	/**
	 * Delete an existing Feature entity
	 * 
	 */
	public Project deleteProjectFeatures(Integer project_projectId_9, Integer related_features_featureId);

	/**
	 * Save an existing Statusupdate entity
	 * 
	 */
	public Project saveProjectStatusupdates(Integer projectId_6, Statusupdate related_statusupdates);

	/**
	 * Delete an existing Invoice entity
	 * 
	 */
	public Project deleteProjectInvoices(Integer project_projectId_10, Integer related_invoices_invoiceId);

	/**
	 * Delete an existing Person entity
	 * 
	 */
	public Project deleteProjectPersonByFkContactPersonId(Integer project_projectId_11, Integer related_personbyfkcontactpersonid_personId);

	/**
	 * Delete an existing Testcasestep entity
	 * 
	 */
	public Project deleteProjectTestcasesteps(Integer project_projectId_12, Integer related_testcasesteps_testStepId);

	/**
	 * Save an existing Invoiceitem entity
	 * 
	 */
	public Project saveProjectInvoiceitems(Integer projectId_7, Invoiceitem related_invoiceitems);

	/**
	 * Delete an existing Defect entity
	 * 
	 */
	public Project deleteProjectDefects(Integer project_projectId_13, Integer related_defects_defectId);

	/**
	 * Save an existing Invoice entity
	 * 
	 */
	public Project saveProjectInvoices(Integer projectId_8, Invoice related_invoices);

	/**
	 * Save an existing Feature entity
	 * 
	 */
	public Project saveProjectFeatures(Integer projectId_9, Feature related_features);

	/**
	 * Save an existing Account entity
	 * 
	 */
	public Project saveProjectAccount(Integer projectId_10, Account related_account);

	/**
	 * Save an existing Changerequest entity
	 * 
	 */
	public Project saveProjectChangerequests(Integer projectId_11, Changerequest related_changerequests);

	/**
	 * Load an existing Project entity
	 * 
	 */
	public Set<Project> loadProjects();

	/**
	 * Save an existing Client entity
	 * 
	 */
	public Project saveProjectClient(Integer projectId_12, Client related_client);

	/**
	 * Delete an existing Projectteam entity
	 * 
	 */
	public Project deleteProjectProjectteams(Integer project_projectId_14, Integer related_projectteams_projectTeamId);


	/**
	 * Delete an existing Invoiceitem entity
	 * 
	 */
	public Project deleteProjectInvoiceitems(Integer project_projectId_15, Integer related_invoiceitems_invoiceItemId);

	/**
	 * Save an existing Defect entity
	 * 
	 */
	public Project saveProjectDefects(Integer projectId_15, Defect related_defects);



	/**
	 * Delete an existing Testcase entity
	 * 
	 */
	public Project deleteProjectTestcases(Integer project_projectId_16, Integer related_testcases_testId);

	/**
	 * Save an existing Task entity
	 * 
	 */
	public Project saveProjectTasks(Integer projectId_17, Task related_tasks);

	/**
	 * Delete an existing Client entity
	 * 
	 */
	public Project deleteProjectClient(Integer project_projectId_17, Integer related_client_clientId);

	/**
	 * Save an existing Testcase entity
	 * 
	 */
	public Project saveProjectTestcases(Integer projectId_18, Testcase related_testcases);

	/**
	 * Delete an existing Projecttemplate entity
	 * 
	 */
	public Project deleteProjectProjecttemplates(Integer project_projectId_18, Integer related_projecttemplates_templateId);

	/**
	 */
	public Project findProjectByPrimaryKey(Integer projectId_19);
}