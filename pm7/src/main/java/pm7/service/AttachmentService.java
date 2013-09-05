package pm7.service;

import java.util.List;
import java.util.Set;

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
public interface AttachmentService {

	/**
	 * Save an existing Project entity
	 * 
	 */
	public Attachment saveAttachmentProject(Integer attachId, Project related_project);

	/**
	 * Delete an existing Attachment entity
	 * 
	 */
	public void deleteAttachment(Attachment attachment);

	/**
	 * Load an existing Attachment entity
	 * 
	 */
	public Set<Attachment> loadAttachments();

	/**
	 * Return a count of all Attachment entity
	 * 
	 */
	public Integer countAttachments();

	/**
	 * Return all Attachment entity
	 * 
	 */
	public List<Attachment> findAllAttachments(Integer startResult, Integer maxRows);

	/**
	 * Save an existing Testcase entity
	 * 
	 */
	public Attachment saveAttachmentTestcase(Integer attachId_1, Testcase related_testcase);

	/**
	 * Save an existing Statusupdate entity
	 * 
	 */
	public Attachment saveAttachmentStatusupdate(Integer attachId_2, Statusupdate related_statusupdate);

	/**
	 * Delete an existing Changerequest entity
	 * 
	 */
	public Attachment deleteAttachmentChangerequest(Integer attachment_attachId, Integer related_changerequest_changeId);

	/**
	 * Save an existing Changerequest entity
	 * 
	 */
	public Attachment saveAttachmentChangerequest(Integer attachId_3, Changerequest related_changerequest);

	/**
	 * Delete an existing Statusupdate entity
	 * 
	 */
	public Attachment deleteAttachmentStatusupdate(Integer attachment_attachId_1, Integer related_statusupdate_statusId);

	/**
	 * Delete an existing Requirement entity
	 * 
	 */
	public Attachment deleteAttachmentRequirement(Integer attachment_attachId_2, Integer related_requirement_reqmtId);

	/**
	 * Save an existing Account entity
	 * 
	 */
	public Attachment saveAttachmentAccount(Integer attachId_4, Account related_account);

	/**
	 * Delete an existing Project entity
	 * 
	 */
	public Attachment deleteAttachmentProject(Integer attachment_attachId_3, Integer related_project_projectId);

	/**
	 * Save an existing Defect entity
	 * 
	 */
	public Attachment saveAttachmentDefect(Integer attachId_5, Defect related_defect);

	/**
	 * Save an existing Person entity
	 * 
	 */
	public Attachment saveAttachmentPerson(Integer attachId_6, Person related_person);

	/**
	 * Save an existing Attachment entity
	 * 
	 */
	public Attachment saveAttachment(Attachment attachment_1);

	/**
	 * Delete an existing Defect entity
	 * 
	 */
	public Attachment deleteAttachmentDefect(Integer attachment_attachId_4, Integer related_defect_defectId);

	/**
	 * Delete an existing Account entity
	 * 
	 */
	public Attachment deleteAttachmentAccount(Integer attachment_attachId_5, Integer related_account_accountId);

	/**
	 * Delete an existing Person entity
	 * 
	 */
	public Attachment deleteAttachmentPerson(Integer attachment_attachId_6, Integer related_person_personId);

	/**
	 * Save an existing Requirement entity
	 * 
	 */
	public Attachment saveAttachmentRequirement(Integer attachId_7, Requirement related_requirement);

	/**
	 * Delete an existing Testcase entity
	 * 
	 */
	public Attachment deleteAttachmentTestcase(Integer attachment_attachId_7, Integer related_testcase_testId);

	/**
	 */
	public Attachment findAttachmentByPrimaryKey(Integer attachId_8);
}