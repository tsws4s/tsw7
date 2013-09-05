//**********************************************************
// ProjectServiceImpl
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
import pm7.dao.ChangerequestDAO;
import pm7.dao.ClientDAO;
import pm7.dao.DefectDAO;
import pm7.dao.FeatureDAO;
import pm7.dao.InvoiceDAO;
import pm7.dao.InvoiceitemDAO;
import pm7.dao.PersonDAO;
import pm7.dao.ProjectDAO;
import pm7.dao.ProjectteamDAO;
import pm7.dao.ProjecttemplateDAO;
import pm7.dao.ReleaseplanDAO;
import pm7.dao.RequirementDAO;
import pm7.dao.StatusupdateDAO;
import pm7.dao.TaskDAO;
import pm7.dao.TestcaseDAO;
import pm7.dao.TestcasestepDAO;
import pm7.dao.TimeentryDAO;

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
import pm7.domain.Projecttemplate;
import pm7.domain.Releaseplan;
import pm7.domain.Requirement;
import pm7.domain.Statusupdate;
import pm7.domain.Task;
import pm7.domain.Testcase;
import pm7.domain.Testcasestep;
import pm7.domain.Timeentry;

/**
 * Spring service that handles CRUD requests for Project entities
 * 
 */

@Service("ProjectService")
@Transactional
public class ProjectServiceImpl implements ProjectService {

	/**
	 * DAO injected by Spring that manages Account entities
	 * 
	 */
	@Autowired
	private AccountDAO accountDAO;

	@Autowired
	private AttachmentDAO attachmentDAO;

	@Autowired
	private ChangerequestDAO changerequestDAO;

	@Autowired
	private ClientDAO clientDAO;

	@Autowired
	private DefectDAO defectDAO;

	@Autowired
	private FeatureDAO featureDAO;

	@Autowired
	private InvoiceDAO invoiceDAO;

	@Autowired
	private InvoiceitemDAO invoiceitemDAO;

	@Autowired
	private PersonDAO personDAO;

	@Autowired
	private ProjectDAO projectDAO;

	@Autowired
	private ProjectteamDAO projectteamDAO;

	@Autowired
	private ProjecttemplateDAO projecttemplateDAO;

	@Autowired
	private ReleaseplanDAO releaseplanDAO;

	@Autowired
	private RequirementDAO requirementDAO;

	@Autowired
	private StatusupdateDAO statusupdateDAO;

	@Autowired
	private TaskDAO taskDAO;

	@Autowired
	private TestcaseDAO testcaseDAO;

	@Autowired
	private TestcasestepDAO testcasestepDAO;

	@Autowired
	private TimeentryDAO timeentryDAO;
	
	/**
	 * Instantiates a new ProjectServiceImpl.
	 *
	 */
	public ProjectServiceImpl() {
	}

	/**
	 * Save an existing Timeentry entity
	 * 
	 */
	@Transactional
	public Project saveProjectTimeentries(Integer projectId, Timeentry related_timeentries) {
		Project project = projectDAO.findProjectByPrimaryKey(projectId, -1, -1);
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

		related_timeentries.setProject(project);
		project.getTimeentries().add(related_timeentries);
		related_timeentries = timeentryDAO.store(related_timeentries);
		timeentryDAO.flush();

		project = projectDAO.store(project);
		projectDAO.flush();

		return project;
	}

	/**
	 * Save an existing Project entity
	 * 
	 */
	@Transactional
	public Project saveProject(Project project, Integer personId, Integer clientId) {
		Project existingProject = projectDAO.findProjectByPrimaryKey(project.getProjectId());

		if (existingProject != null) {
			if (existingProject != project) {
				existingProject.setProjectId(project.getProjectId());
				existingProject.setProjectName(project.getProjectName());
				existingProject.setProjectDesc(project.getProjectDesc());
				existingProject.setProjectType(project.getProjectType());
				existingProject.setStartDate(project.getStartDate());
				existingProject.setDueDate(project.getDueDate());
				existingProject.setCompleteDate(project.getCompleteDate());
				existingProject.setEstimateHrs(project.getEstimateHrs());
				existingProject.setActualHrs(project.getActualHrs());
				existingProject.setHrRate(project.getHrRate());
				existingProject.setPercentComplete(project.getPercentComplete());
				existingProject.setActiveYn(project.getActiveYn());
			}
			project = projectDAO.store(existingProject);
		} else {
			int projectId = projectDAO.getMaxProjectId();
			project.setProjectId(projectId+1);
//			person.setAccount(acct);
			project = projectDAO.store(project);
		}
 
		if(personId!=null && personId>0){
			project.setPersonByFkProjMgrId(personDAO.findPersonByPersonId(personId));
		}
		if(clientId!=null && clientId>0){
			project.setClient(clientDAO.findClientByClientId(clientId));
		}

		projectDAO.flush();
		return project;
		}

	/**
	 * Delete an existing Project entity
	 * 
	 */
	@Transactional
	public void deleteProject(Project project) {
		projectDAO.remove(project);
		projectDAO.flush();
	}

	/**
	 * Save an existing Projectteam entity
	 * 
	 */
	@Transactional
	public Project saveProjectProjectteams(Integer projectId, Integer personId, Projectteam related_projectteams) {
		Project project = projectDAO.findProjectByPrimaryKey(projectId, -1, -1);
		Projectteam existingprojectteams = projectteamDAO.findProjectteamByPrimaryKey(related_projectteams.getProjectTeamId());

		// copy into the existing record to preserve existing relationships
		if (existingprojectteams != null) {
			existingprojectteams.setProjectTeamId(related_projectteams.getProjectTeamId());
			existingprojectteams.setProjectRole(related_projectteams.getProjectRole());
			existingprojectteams.setPersonProjectEstHrs(related_projectteams.getPersonProjectEstHrs());
			existingprojectteams.setPersonProjectActualHrs(related_projectteams.getPersonProjectActualHrs());
			related_projectteams = existingprojectteams;
		} else {
			int projectteamsId = projectteamDAO.getMaxProjectteamId();
			related_projectteams.setProjectTeamId(projectteamsId+1);
		}
 
		if(personId!=null && personId>0){
			related_projectteams.setPerson(personDAO.findPersonByPersonId(personId));
		}

		related_projectteams.setProject(project);
		project.getProjectteams().add(related_projectteams);
		related_projectteams = projectteamDAO.store(related_projectteams);
		projectteamDAO.flush();

		project = projectDAO.store(project);
		projectDAO.flush();

		return project;
	}

	/**
	 * Delete an existing Changerequest entity
	 * 
	 */
	@Transactional
	public Project deleteProjectChangerequests(Integer project_projectId, Integer related_changerequests_changeId) {
		Changerequest related_changerequests = changerequestDAO.findChangerequestByPrimaryKey(related_changerequests_changeId, -1, -1);

		Project project = projectDAO.findProjectByPrimaryKey(project_projectId, -1, -1);

		related_changerequests.setProject(null);
		project.getChangerequests().remove(related_changerequests);

		changerequestDAO.remove(related_changerequests);
		changerequestDAO.flush();

		return project;
	}

	/**
	 * Return a count of all Project entity
	 * 
	 */
	@Transactional
	public Integer countProjects() {
		return ((Long) projectDAO.createQuerySingleResult("select count(o) from Project o").getSingleResult()).intValue();
	}

	/**
	 * Delete an existing Timeentry entity
	 * 
	 */
	@Transactional
	public Project deleteProjectTimeentries(Integer project_projectId, Integer related_timeentries_timeEntryId) {
		Timeentry related_timeentries = timeentryDAO.findTimeentryByPrimaryKey(related_timeentries_timeEntryId, -1, -1);

		Project project = projectDAO.findProjectByPrimaryKey(project_projectId, -1, -1);

		related_timeentries.setProject(null);
		project.getTimeentries().remove(related_timeentries);

		timeentryDAO.remove(related_timeentries);
		timeentryDAO.flush();

		return project;
	}

	/**
	 * Delete an existing Attachment entity
	 * 
	 */
	@Transactional
	public Project deleteProjectAttachments(Integer project_projectId, Integer related_attachments_attachId) {
		Attachment related_attachments = attachmentDAO.findAttachmentByPrimaryKey(related_attachments_attachId, -1, -1);

		Project project = projectDAO.findProjectByPrimaryKey(project_projectId, -1, -1);

		related_attachments.setProject(null);
		project.getAttachments().remove(related_attachments);

		attachmentDAO.remove(related_attachments);
		attachmentDAO.flush();

		return project;
	}

	/**
	 * Delete an existing Requirement entity
	 * 
	 */
	@Transactional
	public Project deleteProjectRequirements(Integer project_projectId, Integer related_requirements_reqmtId) {
		Requirement related_requirements = requirementDAO.findRequirementByPrimaryKey(related_requirements_reqmtId, -1, -1);

		Project project = projectDAO.findProjectByPrimaryKey(project_projectId, -1, -1);

		related_requirements.setProject(null);
		project.getRequirements().remove(related_requirements);

		requirementDAO.remove(related_requirements);
		requirementDAO.flush();

		return project;
	}

	/**
	 * Save an existing Releaseplan entity
	 * 
	 */
	@Transactional
	public Project saveProjectReleaseplans(Integer projectId, Releaseplan related_releaseplans) {
		Project project = projectDAO.findProjectByPrimaryKey(projectId, -1, -1);
		Releaseplan existingreleaseplans = releaseplanDAO.findReleaseplanByPrimaryKey(related_releaseplans.getReleaseId());

		// copy into the existing record to preserve existing relationships
		if (existingreleaseplans != null) {
			existingreleaseplans.setReleaseId(related_releaseplans.getReleaseId());
			existingreleaseplans.setReleaseCode(related_releaseplans.getReleaseCode());
			existingreleaseplans.setReleaseName(related_releaseplans.getReleaseName());
			existingreleaseplans.setReleaseDescription(related_releaseplans.getReleaseDescription());
			existingreleaseplans.setReleaseDate(related_releaseplans.getReleaseDate());
			related_releaseplans = existingreleaseplans;
		} else {
			related_releaseplans = releaseplanDAO.store(related_releaseplans);
			releaseplanDAO.flush();
		}

		related_releaseplans.setProject(project);
		project.getReleaseplans().add(related_releaseplans);
		related_releaseplans = releaseplanDAO.store(related_releaseplans);
		releaseplanDAO.flush();

		project = projectDAO.store(project);
		projectDAO.flush();

		return project;
	}

	/**
	 * Delete an existing Statusupdate entity
	 * 
	 */
	@Transactional
	public Project deleteProjectStatusupdates(Integer project_projectId, Integer related_statusupdates_statusId) {
		Statusupdate related_statusupdates = statusupdateDAO.findStatusupdateByPrimaryKey(related_statusupdates_statusId, -1, -1);

		Project project = projectDAO.findProjectByPrimaryKey(project_projectId, -1, -1);

		related_statusupdates.setProject(null);
		project.getStatusupdates().remove(related_statusupdates);

		statusupdateDAO.remove(related_statusupdates);
		statusupdateDAO.flush();

		return project;
	}

	/**
	 * Save an existing Person entity
	 * 
	 */
	@Transactional
	public Project saveProjectPersonByFkContactPersonId(Integer projectId, Person related_personbyfkcontactpersonid) {
		Project project = projectDAO.findProjectByPrimaryKey(projectId, -1, -1);
		Person existingpersonByFkContactPersonId = personDAO.findPersonByPrimaryKey(related_personbyfkcontactpersonid.getPersonId());

		// copy into the existing record to preserve existing relationships
		if (existingpersonByFkContactPersonId != null) {
			existingpersonByFkContactPersonId.setPersonId(related_personbyfkcontactpersonid.getPersonId());
			existingpersonByFkContactPersonId.setFirstname(related_personbyfkcontactpersonid.getFirstname());
			existingpersonByFkContactPersonId.setLastname(related_personbyfkcontactpersonid.getLastname());
			existingpersonByFkContactPersonId.setPhone(related_personbyfkcontactpersonid.getPhone());
			existingpersonByFkContactPersonId.setEmail(related_personbyfkcontactpersonid.getEmail());
			existingpersonByFkContactPersonId.setDefaultProjectRole(related_personbyfkcontactpersonid.getDefaultProjectRole());
			existingpersonByFkContactPersonId.setAddress(related_personbyfkcontactpersonid.getAddress());
			existingpersonByFkContactPersonId.setCity(related_personbyfkcontactpersonid.getCity());
			existingpersonByFkContactPersonId.setState(related_personbyfkcontactpersonid.getState());
			existingpersonByFkContactPersonId.setZip(related_personbyfkcontactpersonid.getZip());
			existingpersonByFkContactPersonId.setActiveYn(related_personbyfkcontactpersonid.getActiveYn());
			related_personbyfkcontactpersonid = existingpersonByFkContactPersonId;
		} else {
			related_personbyfkcontactpersonid = personDAO.store(related_personbyfkcontactpersonid);
			personDAO.flush();
		}

		project.setPersonByFkContactPersonId(related_personbyfkcontactpersonid);
		related_personbyfkcontactpersonid.getProjectsForFkContactPersonId().add(project);
		project = projectDAO.store(project);
		projectDAO.flush();

		related_personbyfkcontactpersonid = personDAO.store(related_personbyfkcontactpersonid);
		personDAO.flush();

		return project;
	}

	/**
	 * Save an existing Requirement entity
	 * 
	 */
	@Transactional
	public Project saveProjectRequirements(Integer projectId, Requirement related_requirements) {
		Project project = projectDAO.findProjectByPrimaryKey(projectId, -1, -1);
		Requirement existingrequirements = requirementDAO.findRequirementByPrimaryKey(related_requirements.getReqmtId());

		// copy into the existing record to preserve existing relationships
		if (existingrequirements != null) {
			existingrequirements.setReqmtId(related_requirements.getReqmtId());
			existingrequirements.setStatus(related_requirements.getStatus());
			existingrequirements.setReqmtPriority(related_requirements.getReqmtPriority());
			existingrequirements.setReqmtCode(related_requirements.getReqmtCode());
			existingrequirements.setReqmtName(related_requirements.getReqmtName());
			existingrequirements.setReqmtStoryDescription(related_requirements.getReqmtStoryDescription());
			related_requirements = existingrequirements;
		} else {
			related_requirements = requirementDAO.store(related_requirements);
			requirementDAO.flush();
		}

		related_requirements.setProject(project);
		project.getRequirements().add(related_requirements);
		related_requirements = requirementDAO.store(related_requirements);
		requirementDAO.flush();

		project = projectDAO.store(project);
		projectDAO.flush();

		return project;
	}

	/**
	 * Delete an existing Account entity
	 * 
	 */
	@Transactional
	public Project deleteProjectAccount(Integer project_projectId, Integer related_account_accountId) {
		Project project = projectDAO.findProjectByPrimaryKey(project_projectId, -1, -1);
		Account related_account = accountDAO.findAccountByPrimaryKey(related_account_accountId, -1, -1);

		project.setAccount(null);
		project = projectDAO.store(project);
		projectDAO.flush();

		related_account = accountDAO.store(related_account);
		accountDAO.flush();

		accountDAO.remove(related_account);
		accountDAO.flush();

		return project;
	}

	/**
	 * Delete an existing Task entity
	 * 
	 */
	@Transactional
	public Project deleteProjectTasks(Integer project_projectId, Integer related_tasks_taskId) {
		Task related_tasks = taskDAO.findTaskByPrimaryKey(related_tasks_taskId, -1, -1);

		Project project = projectDAO.findProjectByPrimaryKey(project_projectId, -1, -1);

		related_tasks.setProject(null);
		project.getTasks().remove(related_tasks);

		taskDAO.remove(related_tasks);
		taskDAO.flush();

		return project;
	}

	/**
	 * Delete an existing Releaseplan entity
	 * 
	 */
	@Transactional
	public Project deleteProjectReleaseplans(Integer project_projectId, Integer related_releaseplans_releaseId) {
		Releaseplan related_releaseplans = releaseplanDAO.findReleaseplanByPrimaryKey(related_releaseplans_releaseId, -1, -1);

		Project project = projectDAO.findProjectByPrimaryKey(project_projectId, -1, -1);

		related_releaseplans.setProject(null);
		project.getReleaseplans().remove(related_releaseplans);

		releaseplanDAO.remove(related_releaseplans);
		releaseplanDAO.flush();

		return project;
	}

	/**
	 * Return all Project entity
	 * 
	 */
	@Transactional
	public List<Project> findAllProjects(Integer startResult, Integer maxRows) {
		return new java.util.ArrayList<Project>(projectDAO.findAllProjects(startResult, maxRows));
	}

	/**
	 * Save an existing Attachment entity
	 * 
	 */
	@Transactional
	public Project saveProjectAttachments(Integer projectId, Attachment related_attachments) {
		Project project = projectDAO.findProjectByPrimaryKey(projectId, -1, -1);
		Attachment existingattachments = attachmentDAO.findAttachmentByPrimaryKey(related_attachments.getAttachId());

		// copy into the existing record to preserve existing relationships
		if (existingattachments != null) {
			existingattachments.setAttachId(related_attachments.getAttachId());
			existingattachments.setAttachmentType(related_attachments.getAttachmentType());
			existingattachments.setAttachmentUrl(related_attachments.getAttachmentUrl());
			related_attachments = existingattachments;
		} else {
			int attachmentId = attachmentDAO.getMaxAttachmentId();
			related_attachments.setAttachId(attachmentId+1);
			related_attachments = attachmentDAO.store(related_attachments);
			attachmentDAO.flush();
		}

		related_attachments.setProject(project);
		project.getAttachments().add(related_attachments);
		related_attachments = attachmentDAO.store(related_attachments);
		attachmentDAO.flush();

		project = projectDAO.store(project);
		projectDAO.flush();

		return project;
	}

	/**
	 * Delete an existing Person entity
	 * 
	 */
	@Transactional
	public Project deleteProjectPersonByFkProjMgrId(Integer project_projectId, Integer related_personbyfkprojmgrid_personId) {
		Project project = projectDAO.findProjectByPrimaryKey(project_projectId, -1, -1);
		Person related_personbyfkprojmgrid = personDAO.findPersonByPrimaryKey(related_personbyfkprojmgrid_personId, -1, -1);

		project.setPersonByFkProjMgrId(null);
		related_personbyfkprojmgrid.getProjectsForFkProjMgrId().remove(project);
		project = projectDAO.store(project);
		projectDAO.flush();

		related_personbyfkprojmgrid = personDAO.store(related_personbyfkprojmgrid);
		personDAO.flush();

		personDAO.remove(related_personbyfkprojmgrid);
		personDAO.flush();

		return project;
	}

	/**
	 * Delete an existing Feature entity
	 * 
	 */
	@Transactional
	public Project deleteProjectFeatures(Integer project_projectId, Integer related_features_featureId) {
		Feature related_features = featureDAO.findFeatureByPrimaryKey(related_features_featureId, -1, -1);

		Project project = projectDAO.findProjectByPrimaryKey(project_projectId, -1, -1);

		related_features.setProject(null);
		project.getFeatures().remove(related_features);

		featureDAO.remove(related_features);
		featureDAO.flush();

		return project;
	}

	/**
	 * Save an existing Statusupdate entity
	 * 
	 */
	@Transactional
	public Project saveProjectStatusupdates(Integer projectId, Statusupdate related_statusupdates) {
		Project project = projectDAO.findProjectByPrimaryKey(projectId, -1, -1);
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
			int statusupdateId = statusupdateDAO.getMaxStatusupdateId();
			related_statusupdates.setStatusId(statusupdateId+1);
			related_statusupdates = statusupdateDAO.store(related_statusupdates);
			statusupdateDAO.flush();
		}

		related_statusupdates.setProject(project);
		project.getStatusupdates().add(related_statusupdates);
		related_statusupdates = statusupdateDAO.store(related_statusupdates);
		statusupdateDAO.flush();

		project = projectDAO.store(project);
		projectDAO.flush();

		return project;
	}

	/**
	 * Delete an existing Invoice entity
	 * 
	 */
	@Transactional
	public Project deleteProjectInvoices(Integer project_projectId, Integer related_invoices_invoiceId) {
		Invoice related_invoices = invoiceDAO.findInvoiceByPrimaryKey(related_invoices_invoiceId, -1, -1);

		Project project = projectDAO.findProjectByPrimaryKey(project_projectId, -1, -1);

		related_invoices.setProject(null);
		project.getInvoices().remove(related_invoices);

		invoiceDAO.remove(related_invoices);
		invoiceDAO.flush();

		return project;
	}

	/**
	 * Delete an existing Person entity
	 * 
	 */
	@Transactional
	public Project deleteProjectPersonByFkContactPersonId(Integer project_projectId, Integer related_personbyfkcontactpersonid_personId) {
		Project project = projectDAO.findProjectByPrimaryKey(project_projectId, -1, -1);
		Person related_personbyfkcontactpersonid = personDAO.findPersonByPrimaryKey(related_personbyfkcontactpersonid_personId, -1, -1);

		project.setPersonByFkContactPersonId(null);
		related_personbyfkcontactpersonid.getProjectsForFkContactPersonId().remove(project);
		project = projectDAO.store(project);
		projectDAO.flush();

		related_personbyfkcontactpersonid = personDAO.store(related_personbyfkcontactpersonid);
		personDAO.flush();

		personDAO.remove(related_personbyfkcontactpersonid);
		personDAO.flush();

		return project;
	}

	/**
	 * Delete an existing Testcasestep entity
	 * 
	 */
	@Transactional
	public Project deleteProjectTestcasesteps(Integer project_projectId, Integer related_testcasesteps_testStepId) {
		Testcasestep related_testcasesteps = testcasestepDAO.findTestcasestepByPrimaryKey(related_testcasesteps_testStepId, -1, -1);

		Project project = projectDAO.findProjectByPrimaryKey(project_projectId, -1, -1);

		related_testcasesteps.setProject(null);
		project.getTestcasesteps().remove(related_testcasesteps);

		testcasestepDAO.remove(related_testcasesteps);
		testcasestepDAO.flush();

		return project;
	}

	/**
	 * Save an existing Invoiceitem entity
	 * 
	 */
	@Transactional
	public Project saveProjectInvoiceitems(Integer projectId, Invoiceitem related_invoiceitems) {
		Project project = projectDAO.findProjectByPrimaryKey(projectId, -1, -1);
		Invoiceitem existinginvoiceitems = invoiceitemDAO.findInvoiceitemByPrimaryKey(related_invoiceitems.getInvoiceItemId());

		// copy into the existing record to preserve existing relationships
		if (existinginvoiceitems != null) {
			existinginvoiceitems.setInvoiceItemId(related_invoiceitems.getInvoiceItemId());
			existinginvoiceitems.setInvoiceItemDesc(related_invoiceitems.getInvoiceItemDesc());
			existinginvoiceitems.setItemAmt(related_invoiceitems.getItemAmt());
			existinginvoiceitems.setProjectExpenseYn(related_invoiceitems.getProjectExpenseYn());
			related_invoiceitems = existinginvoiceitems;
		} else {
			related_invoiceitems = invoiceitemDAO.store(related_invoiceitems);
			invoiceitemDAO.flush();
		}

		related_invoiceitems.setProject(project);
		project.getInvoiceitems().add(related_invoiceitems);
		related_invoiceitems = invoiceitemDAO.store(related_invoiceitems);
		invoiceitemDAO.flush();

		project = projectDAO.store(project);
		projectDAO.flush();

		return project;
	}

	/**
	 * Delete an existing Defect entity
	 * 
	 */
	@Transactional
	public Project deleteProjectDefects(Integer project_projectId, Integer related_defects_defectId) {
		Defect related_defects = defectDAO.findDefectByPrimaryKey(related_defects_defectId, -1, -1);

		Project project = projectDAO.findProjectByPrimaryKey(project_projectId, -1, -1);

		related_defects.setProject(null);
		project.getDefects().remove(related_defects);

		defectDAO.remove(related_defects);
		defectDAO.flush();

		return project;
	}

	/**
	 * Save an existing Invoice entity
	 * 
	 */
	@Transactional
	public Project saveProjectInvoices(Integer projectId, Invoice related_invoices) {
		Project project = projectDAO.findProjectByPrimaryKey(projectId, -1, -1);
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

		related_invoices.setProject(project);
		project.getInvoices().add(related_invoices);
		related_invoices = invoiceDAO.store(related_invoices);
		invoiceDAO.flush();

		project = projectDAO.store(project);
		projectDAO.flush();

		return project;
	}

	/**
	 * Save an existing Feature entity
	 * 
	 */
	@Transactional
	public Project saveProjectFeatures(Integer projectId, Feature related_features) {
		Project project = projectDAO.findProjectByPrimaryKey(projectId, -1, -1);
		Feature existingfeatures = featureDAO.findFeatureByPrimaryKey(related_features.getFeatureId());

		// copy into the existing record to preserve existing relationships
		if (existingfeatures != null) {
			existingfeatures.setFeatureId(related_features.getFeatureId());
			existingfeatures.setFeatureCode(related_features.getFeatureCode());
			existingfeatures.setFeatureName(related_features.getFeatureName());
			existingfeatures.setFeaturePriority(related_features.getFeaturePriority());
			related_features = existingfeatures;
		} else {
			related_features = featureDAO.store(related_features);
			featureDAO.flush();
		}

		related_features.setProject(project);
		project.getFeatures().add(related_features);
		related_features = featureDAO.store(related_features);
		featureDAO.flush();

		project = projectDAO.store(project);
		projectDAO.flush();

		return project;
	}

	/**
	 * Save an existing Account entity
	 * 
	 */
	@Transactional
	public Project saveProjectAccount(Integer projectId, Account related_account) {
		Project project = projectDAO.findProjectByPrimaryKey(projectId, -1, -1);
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

		project.setAccount(related_account);
		project = projectDAO.store(project);
		projectDAO.flush();

		related_account = accountDAO.store(related_account);
		accountDAO.flush();

		return project;
	}

	/**
	 * Save an existing Changerequest entity
	 * 
	 */
	@Transactional
	public Project saveProjectChangerequests(Integer projectId, Changerequest related_changerequests) {
		Project project = projectDAO.findProjectByPrimaryKey(projectId, -1, -1);
		Changerequest existingchangerequests = changerequestDAO.findChangerequestByPrimaryKey(related_changerequests.getChangeId());

		// copy into the existing record to preserve existing relationships
		if (existingchangerequests != null) {
			existingchangerequests.setChangeId(related_changerequests.getChangeId());
			existingchangerequests.setStatus(related_changerequests.getStatus());
			existingchangerequests.setChangePriority(related_changerequests.getChangePriority());
			existingchangerequests.setChangeCode(related_changerequests.getChangeCode());
			existingchangerequests.setChangeName(related_changerequests.getChangeName());
			existingchangerequests.setChangeDescription(related_changerequests.getChangeDescription());
			related_changerequests = existingchangerequests;
		} else {
			related_changerequests = changerequestDAO.store(related_changerequests);
			changerequestDAO.flush();
		}

		related_changerequests.setProject(project);
		project.getChangerequests().add(related_changerequests);
		related_changerequests = changerequestDAO.store(related_changerequests);
		changerequestDAO.flush();

		project = projectDAO.store(project);
		projectDAO.flush();

		return project;
	}

	/**
	 * Load an existing Project entity
	 * 
	 */
	@Transactional
	public Set<Project> loadProjects() {
		return projectDAO.findAllProjects();
	}

	/**
	 * Save an existing Client entity
	 * 
	 */
	@Transactional
	public Project saveProjectClient(Integer projectId, Client related_client) {
		Project project = projectDAO.findProjectByPrimaryKey(projectId, -1, -1);
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

		project.setClient(related_client);
		related_client.getProjects().add(project);
		project = projectDAO.store(project);
		projectDAO.flush();

		related_client = clientDAO.store(related_client);
		clientDAO.flush();

		return project;
	}

	/**
	 * Delete an existing Projectteam entity
	 * 
	 */
	@Transactional
	public Project deleteProjectProjectteams(Integer project_projectId, Integer related_projectteams_projectTeamId) {
		Projectteam related_projectteams = projectteamDAO.findProjectteamByPrimaryKey(related_projectteams_projectTeamId, -1, -1);

		Project project = projectDAO.findProjectByPrimaryKey(project_projectId, -1, -1);

		related_projectteams.setProject(null);
		project.getProjectteams().remove(related_projectteams);

		projectteamDAO.remove(related_projectteams);
		projectteamDAO.flush();

		return project;
	}


	/**
	 * Delete an existing Invoiceitem entity
	 * 
	 */
	@Transactional
	public Project deleteProjectInvoiceitems(Integer project_projectId, Integer related_invoiceitems_invoiceItemId) {
		Invoiceitem related_invoiceitems = invoiceitemDAO.findInvoiceitemByPrimaryKey(related_invoiceitems_invoiceItemId, -1, -1);

		Project project = projectDAO.findProjectByPrimaryKey(project_projectId, -1, -1);

		related_invoiceitems.setProject(null);
		project.getInvoiceitems().remove(related_invoiceitems);

		invoiceitemDAO.remove(related_invoiceitems);
		invoiceitemDAO.flush();

		return project;
	}

	/**
	 * Save an existing Defect entity
	 * 
	 */
	@Transactional
	public Project saveProjectDefects(Integer projectId, Defect related_defects) {
		Project project = projectDAO.findProjectByPrimaryKey(projectId, -1, -1);
		Defect existingdefects = defectDAO.findDefectByPrimaryKey(related_defects.getDefectId());

		// copy into the existing record to preserve existing relationships
		if (existingdefects != null) {
			existingdefects.setDefectId(related_defects.getDefectId());
			existingdefects.setStatus(related_defects.getStatus());
			existingdefects.setDefectPriority(related_defects.getDefectPriority());
			existingdefects.setDefectName(related_defects.getDefectName());
			existingdefects.setDefectDescriptin(related_defects.getDefectDescriptin());
			related_defects = existingdefects;
		} else {
			related_defects = defectDAO.store(related_defects);
			defectDAO.flush();
		}

		related_defects.setProject(project);
		project.getDefects().add(related_defects);
		related_defects = defectDAO.store(related_defects);
		defectDAO.flush();

		project = projectDAO.store(project);
		projectDAO.flush();

		return project;
	}


	/**
	 * Delete an existing Testcase entity
	 * 
	 */
	@Transactional
	public Project deleteProjectTestcases(Integer project_projectId, Integer related_testcases_testId) {
		Testcase related_testcases = testcaseDAO.findTestcaseByPrimaryKey(related_testcases_testId, -1, -1);

		Project project = projectDAO.findProjectByPrimaryKey(project_projectId, -1, -1);

		related_testcases.setProject(null);
		project.getTestcases().remove(related_testcases);

		testcaseDAO.remove(related_testcases);
		testcaseDAO.flush();

		return project;
	}

	/**
	 * Save an existing Task entity
	 * 
	 */
	@Transactional
	public Project saveProjectTasks(Integer projectId, Task related_tasks) {
		Project project = projectDAO.findProjectByPrimaryKey(projectId, -1, -1);
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
			int taskId = taskDAO.getMaxTaskId();
			related_tasks.setTaskId(taskId+1);
			related_tasks = taskDAO.store(related_tasks);
			taskDAO.flush();
		}

		related_tasks.setProject(project);
		project.getTasks().add(related_tasks);
		related_tasks = taskDAO.store(related_tasks);
		taskDAO.flush();

		project = projectDAO.store(project);
		projectDAO.flush();

		return project;
	}

	/**
	 * Delete an existing Client entity
	 * 
	 */
	@Transactional
	public Project deleteProjectClient(Integer project_projectId, Integer related_client_clientId) {
		Project project = projectDAO.findProjectByPrimaryKey(project_projectId, -1, -1);
		Client related_client = clientDAO.findClientByPrimaryKey(related_client_clientId, -1, -1);

		project.setClient(null);
		related_client.getProjects().remove(project);
		project = projectDAO.store(project);
		projectDAO.flush();

		related_client = clientDAO.store(related_client);
		clientDAO.flush();

		clientDAO.remove(related_client);
		clientDAO.flush();

		return project;
	}

	/**
	 * Save an existing Testcase entity
	 * 
	 */
	@Transactional
	public Project saveProjectTestcases(Integer projectId, Testcase related_testcases) {
		Project project = projectDAO.findProjectByPrimaryKey(projectId, -1, -1);
		Testcase existingtestcases = testcaseDAO.findTestcaseByPrimaryKey(related_testcases.getTestId());

		// copy into the existing record to preserve existing relationships
		if (existingtestcases != null) {
			existingtestcases.setTestId(related_testcases.getTestId());
			existingtestcases.setPassFail(related_testcases.getPassFail());
			existingtestcases.setTestCaseCode(related_testcases.getTestCaseCode());
			existingtestcases.setTestName(related_testcases.getTestName());
			existingtestcases.setTestDescription(related_testcases.getTestDescription());
			existingtestcases.setTestSetup(related_testcases.getTestSetup());
			related_testcases = existingtestcases;
		} else {
			related_testcases = testcaseDAO.store(related_testcases);
			testcaseDAO.flush();
		}

		related_testcases.setProject(project);
		project.getTestcases().add(related_testcases);
		related_testcases = testcaseDAO.store(related_testcases);
		testcaseDAO.flush();

		project = projectDAO.store(project);
		projectDAO.flush();

		return project;
	}

	/**
	 * Delete an existing Projecttemplate entity
	 * 
	 */
	@Transactional
	public Project deleteProjectProjecttemplates(Integer project_projectId, Integer related_projecttemplates_templateId) {
		Projecttemplate related_projecttemplates = projecttemplateDAO.findProjecttemplateByPrimaryKey(related_projecttemplates_templateId, -1, -1);

		Project project = projectDAO.findProjectByPrimaryKey(project_projectId, -1, -1);

		related_projecttemplates.setProject(null);
		project.getProjecttemplates().remove(related_projecttemplates);

		projecttemplateDAO.remove(related_projecttemplates);
		projecttemplateDAO.flush();

		return project;
	}

	/**
	 */
	@Transactional
	public Project findProjectByPrimaryKey(Integer projectId) {
		return projectDAO.findProjectByPrimaryKey(projectId);
	}
}
