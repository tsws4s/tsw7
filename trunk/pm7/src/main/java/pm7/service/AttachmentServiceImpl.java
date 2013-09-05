//**********************************************************
// AttachmentServiceImpl
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
import pm7.dao.ChangerequestDAO;
import pm7.dao.DefectDAO;
import pm7.dao.PersonDAO;
import pm7.dao.ProjectDAO;
import pm7.dao.RequirementDAO;
import pm7.dao.StatusupdateDAO;
import pm7.dao.TestcaseDAO;

import pm7.domain.Account;
import pm7.domain.Attachment;
import pm7.domain.Changerequest;
import pm7.domain.Defect;
import pm7.domain.Person;
import pm7.domain.Project;
import pm7.domain.Requirement;
import pm7.domain.Statusupdate;
import pm7.domain.Testcase;

/**
 * Spring service that handles CRUD requests for Attachment entities
 * 
 */

@Service("AttachmentService")
@Transactional
public class AttachmentServiceImpl implements AttachmentService {

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
	 * DAO injected by Spring that manages Changerequest entities
	 * 
	 */
	@Autowired
	private ChangerequestDAO changerequestDAO;

	/**
	 * DAO injected by Spring that manages Defect entities
	 * 
	 */
	@Autowired
	private DefectDAO defectDAO;

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
	 * DAO injected by Spring that manages Requirement entities
	 * 
	 */
	@Autowired
	private RequirementDAO requirementDAO;

	/**
	 * DAO injected by Spring that manages Statusupdate entities
	 * 
	 */
	@Autowired
	private StatusupdateDAO statusupdateDAO;

	/**
	 * DAO injected by Spring that manages Testcase entities
	 * 
	 */
	@Autowired
	private TestcaseDAO testcaseDAO;

	/**
	 * Instantiates a new AttachmentServiceImpl.
	 *
	 */
	public AttachmentServiceImpl() {
	}

	/**
	 * Save an existing Project entity
	 * 
	 */
	@Transactional
	public Attachment saveAttachmentProject(Integer attachId, Project related_project) {
		Attachment attachment = attachmentDAO.findAttachmentByPrimaryKey(attachId, -1, -1);
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

		attachment.setProject(related_project);
		related_project.getAttachments().add(attachment);
		attachment = attachmentDAO.store(attachment);
		attachmentDAO.flush();

		related_project = projectDAO.store(related_project);
		projectDAO.flush();

		return attachment;
	}

	/**
	 * Delete an existing Attachment entity
	 * 
	 */
	@Transactional
	public void deleteAttachment(Attachment attachment) {
		attachmentDAO.remove(attachment);
		attachmentDAO.flush();
	}

	/**
	 * Load an existing Attachment entity
	 * 
	 */
	@Transactional
	public Set<Attachment> loadAttachments() {
		return attachmentDAO.findAllAttachments();
	}

	/**
	 * Return a count of all Attachment entity
	 * 
	 */
	@Transactional
	public Integer countAttachments() {
		return ((Long) attachmentDAO.createQuerySingleResult("select count(o) from Attachment o").getSingleResult()).intValue();
	}

	/**
	 * Return all Attachment entity
	 * 
	 */
	@Transactional
	public List<Attachment> findAllAttachments(Integer startResult, Integer maxRows) {
		return new java.util.ArrayList<Attachment>(attachmentDAO.findAllAttachments(startResult, maxRows));
	}

	/**
	 * Save an existing Testcase entity
	 * 
	 */
	@Transactional
	public Attachment saveAttachmentTestcase(Integer attachId, Testcase related_testcase) {
		Attachment attachment = attachmentDAO.findAttachmentByPrimaryKey(attachId, -1, -1);
		Testcase existingtestcase = testcaseDAO.findTestcaseByPrimaryKey(related_testcase.getTestId());

		// copy into the existing record to preserve existing relationships
		if (existingtestcase != null) {
			existingtestcase.setTestId(related_testcase.getTestId());
			existingtestcase.setPassFail(related_testcase.getPassFail());
			existingtestcase.setTestCaseCode(related_testcase.getTestCaseCode());
			existingtestcase.setTestName(related_testcase.getTestName());
			existingtestcase.setTestDescription(related_testcase.getTestDescription());
			existingtestcase.setTestSetup(related_testcase.getTestSetup());
			related_testcase = existingtestcase;
		} else {
			related_testcase = testcaseDAO.store(related_testcase);
			testcaseDAO.flush();
		}

		attachment.setTestcase(related_testcase);
		related_testcase.getAttachments().add(attachment);
		attachment = attachmentDAO.store(attachment);
		attachmentDAO.flush();

		related_testcase = testcaseDAO.store(related_testcase);
		testcaseDAO.flush();

		return attachment;
	}

	/**
	 * Save an existing Statusupdate entity
	 * 
	 */
	@Transactional
	public Attachment saveAttachmentStatusupdate(Integer attachId, Statusupdate related_statusupdate) {
		Attachment attachment = attachmentDAO.findAttachmentByPrimaryKey(attachId, -1, -1);
		Statusupdate existingstatusupdate = statusupdateDAO.findStatusupdateByPrimaryKey(related_statusupdate.getStatusId());

		// copy into the existing record to preserve existing relationships
		if (existingstatusupdate != null) {
			existingstatusupdate.setStatusId(related_statusupdate.getStatusId());
			existingstatusupdate.setStatusDate(related_statusupdate.getStatusDate());
			existingstatusupdate.setStatusUpdateDesc(related_statusupdate.getStatusUpdateDesc());
			existingstatusupdate.setEstHrsLeft(related_statusupdate.getEstHrsLeft());
			existingstatusupdate.setRiskGyr(related_statusupdate.getRiskGyr());
			related_statusupdate = existingstatusupdate;
		} else {
			related_statusupdate = statusupdateDAO.store(related_statusupdate);
			statusupdateDAO.flush();
		}

		attachment.setStatusupdate(related_statusupdate);
		related_statusupdate.getAttachments().add(attachment);
		attachment = attachmentDAO.store(attachment);
		attachmentDAO.flush();

		related_statusupdate = statusupdateDAO.store(related_statusupdate);
		statusupdateDAO.flush();

		return attachment;
	}

	/**
	 * Delete an existing Changerequest entity
	 * 
	 */
	@Transactional
	public Attachment deleteAttachmentChangerequest(Integer attachment_attachId, Integer related_changerequest_changeId) {
		Attachment attachment = attachmentDAO.findAttachmentByPrimaryKey(attachment_attachId, -1, -1);
		Changerequest related_changerequest = changerequestDAO.findChangerequestByPrimaryKey(related_changerequest_changeId, -1, -1);

		attachment.setChangerequest(null);
		related_changerequest.getAttachments().remove(attachment);
		attachment = attachmentDAO.store(attachment);
		attachmentDAO.flush();

		related_changerequest = changerequestDAO.store(related_changerequest);
		changerequestDAO.flush();

		changerequestDAO.remove(related_changerequest);
		changerequestDAO.flush();

		return attachment;
	}

	/**
	 * Save an existing Changerequest entity
	 * 
	 */
	@Transactional
	public Attachment saveAttachmentChangerequest(Integer attachId, Changerequest related_changerequest) {
		Attachment attachment = attachmentDAO.findAttachmentByPrimaryKey(attachId, -1, -1);
		Changerequest existingchangerequest = changerequestDAO.findChangerequestByPrimaryKey(related_changerequest.getChangeId());

		// copy into the existing record to preserve existing relationships
		if (existingchangerequest != null) {
			existingchangerequest.setChangeId(related_changerequest.getChangeId());
			existingchangerequest.setStatus(related_changerequest.getStatus());
			existingchangerequest.setChangePriority(related_changerequest.getChangePriority());
			existingchangerequest.setChangeCode(related_changerequest.getChangeCode());
			existingchangerequest.setChangeName(related_changerequest.getChangeName());
			existingchangerequest.setChangeDescription(related_changerequest.getChangeDescription());
			related_changerequest = existingchangerequest;
		} else {
			related_changerequest = changerequestDAO.store(related_changerequest);
			changerequestDAO.flush();
		}

		attachment.setChangerequest(related_changerequest);
		related_changerequest.getAttachments().add(attachment);
		attachment = attachmentDAO.store(attachment);
		attachmentDAO.flush();

		related_changerequest = changerequestDAO.store(related_changerequest);
		changerequestDAO.flush();

		return attachment;
	}

	/**
	 * Delete an existing Statusupdate entity
	 * 
	 */
	@Transactional
	public Attachment deleteAttachmentStatusupdate(Integer attachment_attachId, Integer related_statusupdate_statusId) {
		Attachment attachment = attachmentDAO.findAttachmentByPrimaryKey(attachment_attachId, -1, -1);
		Statusupdate related_statusupdate = statusupdateDAO.findStatusupdateByPrimaryKey(related_statusupdate_statusId, -1, -1);

		attachment.setStatusupdate(null);
		related_statusupdate.getAttachments().remove(attachment);
		attachment = attachmentDAO.store(attachment);
		attachmentDAO.flush();

		related_statusupdate = statusupdateDAO.store(related_statusupdate);
		statusupdateDAO.flush();

		statusupdateDAO.remove(related_statusupdate);
		statusupdateDAO.flush();

		return attachment;
	}

	/**
	 * Delete an existing Requirement entity
	 * 
	 */
	@Transactional
	public Attachment deleteAttachmentRequirement(Integer attachment_attachId, Integer related_requirement_reqmtId) {
		Attachment attachment = attachmentDAO.findAttachmentByPrimaryKey(attachment_attachId, -1, -1);
		Requirement related_requirement = requirementDAO.findRequirementByPrimaryKey(related_requirement_reqmtId, -1, -1);

		attachment.setRequirement(null);
		related_requirement.getAttachments().remove(attachment);
		attachment = attachmentDAO.store(attachment);
		attachmentDAO.flush();

		related_requirement = requirementDAO.store(related_requirement);
		requirementDAO.flush();

		requirementDAO.remove(related_requirement);
		requirementDAO.flush();

		return attachment;
	}

	/**
	 * Save an existing Account entity
	 * 
	 */
	@Transactional
	public Attachment saveAttachmentAccount(Integer attachId, Account related_account) {
		Attachment attachment = attachmentDAO.findAttachmentByPrimaryKey(attachId, -1, -1);
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

		attachment.setAccount(related_account);
		attachment = attachmentDAO.store(attachment);
		attachmentDAO.flush();

		related_account = accountDAO.store(related_account);
		accountDAO.flush();

		return attachment;
	}

	/**
	 * Delete an existing Project entity
	 * 
	 */
	@Transactional
	public Attachment deleteAttachmentProject(Integer attachment_attachId, Integer related_project_projectId) {
		Attachment attachment = attachmentDAO.findAttachmentByPrimaryKey(attachment_attachId, -1, -1);
		Project related_project = projectDAO.findProjectByPrimaryKey(related_project_projectId, -1, -1);

		attachment.setProject(null);
		related_project.getAttachments().remove(attachment);
		attachment = attachmentDAO.store(attachment);
		attachmentDAO.flush();

		related_project = projectDAO.store(related_project);
		projectDAO.flush();

		projectDAO.remove(related_project);
		projectDAO.flush();

		return attachment;
	}

	/**
	 * Save an existing Defect entity
	 * 
	 */
	@Transactional
	public Attachment saveAttachmentDefect(Integer attachId, Defect related_defect) {
		Attachment attachment = attachmentDAO.findAttachmentByPrimaryKey(attachId, -1, -1);
		Defect existingdefect = defectDAO.findDefectByPrimaryKey(related_defect.getDefectId());

		// copy into the existing record to preserve existing relationships
		if (existingdefect != null) {
			existingdefect.setDefectId(related_defect.getDefectId());
			existingdefect.setStatus(related_defect.getStatus());
			existingdefect.setDefectPriority(related_defect.getDefectPriority());
			existingdefect.setDefectName(related_defect.getDefectName());
			existingdefect.setDefectDescriptin(related_defect.getDefectDescriptin());
			related_defect = existingdefect;
		} else {
			related_defect = defectDAO.store(related_defect);
			defectDAO.flush();
		}

		attachment.setDefect(related_defect);
		related_defect.getAttachments().add(attachment);
		attachment = attachmentDAO.store(attachment);
		attachmentDAO.flush();

		related_defect = defectDAO.store(related_defect);
		defectDAO.flush();

		return attachment;
	}

	/**
	 * Save an existing Person entity
	 * 
	 */
	@Transactional
	public Attachment saveAttachmentPerson(Integer attachId, Person related_person) {
		Attachment attachment = attachmentDAO.findAttachmentByPrimaryKey(attachId, -1, -1);
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

		attachment.setPerson(related_person);
		related_person.getAttachments().add(attachment);
		attachment = attachmentDAO.store(attachment);
		attachmentDAO.flush();

		related_person = personDAO.store(related_person);
		personDAO.flush();

		return attachment;
	}

	/**
	 * Save an existing Attachment entity
	 * 
	 */
	@Transactional
	public Attachment saveAttachment(Attachment attachment) {
		Attachment existingAttachment = attachmentDAO.findAttachmentByPrimaryKey(attachment.getAttachId());

		if (existingAttachment != null) {
			if (existingAttachment != attachment) {
				existingAttachment.setAttachId(attachment.getAttachId());
				existingAttachment.setAttachmentType(attachment.getAttachmentType());
				existingAttachment.setAttachmentUrl(attachment.getAttachmentUrl());
			}
			attachment = attachmentDAO.store(existingAttachment);

	} else {
		int attachmentId = attachmentDAO.getMaxAttachmentId();
		attachment.setAttachId(attachmentId+1);
//		attachment.setAccount(acct);
		attachment = attachmentDAO.store(attachment);
	}
//	if(attachmentId!=null && attachmentId>0){
//		attachment = attachmentDAO.findAccountByPrimaryKey(attachmentId);
//	}		
		attachmentDAO.flush();
	return attachment;
	}

	/**
	 * Delete an existing Defect entity
	 * 
	 */
	@Transactional
	public Attachment deleteAttachmentDefect(Integer attachment_attachId, Integer related_defect_defectId) {
		Attachment attachment = attachmentDAO.findAttachmentByPrimaryKey(attachment_attachId, -1, -1);
		Defect related_defect = defectDAO.findDefectByPrimaryKey(related_defect_defectId, -1, -1);

		attachment.setDefect(null);
		related_defect.getAttachments().remove(attachment);
		attachment = attachmentDAO.store(attachment);
		attachmentDAO.flush();

		related_defect = defectDAO.store(related_defect);
		defectDAO.flush();

		defectDAO.remove(related_defect);
		defectDAO.flush();

		return attachment;
	}

	/**
	 * Delete an existing Account entity
	 * 
	 */
	@Transactional
	public Attachment deleteAttachmentAccount(Integer attachment_attachId, Integer related_account_accountId) {
		Attachment attachment = attachmentDAO.findAttachmentByPrimaryKey(attachment_attachId, -1, -1);
		Account related_account = accountDAO.findAccountByPrimaryKey(related_account_accountId, -1, -1);

		attachment.setAccount(null);
		attachment = attachmentDAO.store(attachment);
		attachmentDAO.flush();

		related_account = accountDAO.store(related_account);
		accountDAO.flush();

		accountDAO.remove(related_account);
		accountDAO.flush();

		return attachment;
	}

	/**
	 * Delete an existing Person entity
	 * 
	 */
	@Transactional
	public Attachment deleteAttachmentPerson(Integer attachment_attachId, Integer related_person_personId) {
		Attachment attachment = attachmentDAO.findAttachmentByPrimaryKey(attachment_attachId, -1, -1);
		Person related_person = personDAO.findPersonByPrimaryKey(related_person_personId, -1, -1);

		attachment.setPerson(null);
		related_person.getAttachments().remove(attachment);
		attachment = attachmentDAO.store(attachment);
		attachmentDAO.flush();

		related_person = personDAO.store(related_person);
		personDAO.flush();

		personDAO.remove(related_person);
		personDAO.flush();

		return attachment;
	}

	/**
	 * Save an existing Requirement entity
	 * 
	 */
	@Transactional
	public Attachment saveAttachmentRequirement(Integer attachId, Requirement related_requirement) {
		Attachment attachment = attachmentDAO.findAttachmentByPrimaryKey(attachId, -1, -1);
		Requirement existingrequirement = requirementDAO.findRequirementByPrimaryKey(related_requirement.getReqmtId());

		// copy into the existing record to preserve existing relationships
		if (existingrequirement != null) {
			existingrequirement.setReqmtId(related_requirement.getReqmtId());
			existingrequirement.setStatus(related_requirement.getStatus());
			existingrequirement.setReqmtPriority(related_requirement.getReqmtPriority());
			existingrequirement.setReqmtCode(related_requirement.getReqmtCode());
			existingrequirement.setReqmtName(related_requirement.getReqmtName());
			existingrequirement.setReqmtStoryDescription(related_requirement.getReqmtStoryDescription());
			related_requirement = existingrequirement;
		} else {
			related_requirement = requirementDAO.store(related_requirement);
			requirementDAO.flush();
		}

		attachment.setRequirement(related_requirement);
		related_requirement.getAttachments().add(attachment);
		attachment = attachmentDAO.store(attachment);
		attachmentDAO.flush();

		related_requirement = requirementDAO.store(related_requirement);
		requirementDAO.flush();

		return attachment;
	}

	/**
	 * Delete an existing Testcase entity
	 * 
	 */
	@Transactional
	public Attachment deleteAttachmentTestcase(Integer attachment_attachId, Integer related_testcase_testId) {
		Attachment attachment = attachmentDAO.findAttachmentByPrimaryKey(attachment_attachId, -1, -1);
		Testcase related_testcase = testcaseDAO.findTestcaseByPrimaryKey(related_testcase_testId, -1, -1);

		attachment.setTestcase(null);
		related_testcase.getAttachments().remove(attachment);
		attachment = attachmentDAO.store(attachment);
		attachmentDAO.flush();

		related_testcase = testcaseDAO.store(related_testcase);
		testcaseDAO.flush();

		testcaseDAO.remove(related_testcase);
		testcaseDAO.flush();

		return attachment;
	}

	/**
	 */
	@Transactional
	public Attachment findAttachmentByPrimaryKey(Integer attachId) {
		return attachmentDAO.findAttachmentByPrimaryKey(attachId);
	}
}
