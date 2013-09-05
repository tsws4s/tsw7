package pm7.domain;

import java.io.Serializable;

import java.lang.StringBuilder;

import java.util.Set;

import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import javax.xml.bind.annotation.*;

import javax.persistence.*;

/**
 */

@Entity
@NamedQueries({
		@NamedQuery(name = "findAllAttachments", query = "select myAttachment from Attachment myAttachment"),
		@NamedQuery(name = "findAttachmentByAttachId", query = "select myAttachment from Attachment myAttachment where myAttachment.attachId = ?1"),
		@NamedQuery(name = "findAttachmentByAttachmentType", query = "select myAttachment from Attachment myAttachment where myAttachment.attachmentType = ?1"),
		@NamedQuery(name = "findAttachmentByAttachmentTypeContaining", query = "select myAttachment from Attachment myAttachment where myAttachment.attachmentType like ?1"),
		@NamedQuery(name = "findAttachmentByAttachmentUrl", query = "select myAttachment from Attachment myAttachment where myAttachment.attachmentUrl = ?1"),
		@NamedQuery(name = "findAttachmentByAttachmentUrlContaining", query = "select myAttachment from Attachment myAttachment where myAttachment.attachmentUrl like ?1"),
		@NamedQuery(name = "findAttachmentByPrimaryKey", query = "select myAttachment from Attachment myAttachment where myAttachment.attachId = ?1") })
@Table(catalog = "C324877_project_mgt", name = "Attachment")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "pm7/pm7/domain", name = "Attachment")
public class Attachment implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 */

	@Column(name = "attachId", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	@XmlElement
	Integer attachId;
	/**
	 */

	@Column(name = "attachmentType", length = 20)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String attachmentType;
	/**
	 */

	@Column(name = "attachmentURL", length = 240)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String attachmentUrl;

	/**
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "FK_testId", referencedColumnName = "testId") })
	@XmlTransient
	Testcase testcase;
	/**
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "FK_personId", referencedColumnName = "personId") })
	@XmlTransient
	Person person;
	/**
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "FK_accountId", referencedColumnName = "accountId") })
	@XmlTransient
	Account account;
	/**
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "FK_changeId", referencedColumnName = "changeId") })
	@XmlTransient
	Changerequest changerequest;
	/**
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "FK_defectId", referencedColumnName = "defectId") })
	@XmlTransient
	Defect defect;
	/**
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "FK_reqmtId", referencedColumnName = "reqmtId") })
	@XmlTransient
	Requirement requirement;
	/**
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "FK_statusId", referencedColumnName = "statusId") })
	@XmlTransient
	Statusupdate statusupdate;
	/**
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "FK_projectId", referencedColumnName = "projectId") })
	@XmlTransient
	Project project;

	/**
	 */
	public void setAttachId(Integer attachId) {
		this.attachId = attachId;
	}

	/**
	 */
	public Integer getAttachId() {
		return this.attachId;
	}

	/**
	 */
	public void setAttachmentType(String attachmentType) {
		this.attachmentType = attachmentType;
	}

	/**
	 */
	public String getAttachmentType() {
		return this.attachmentType;
	}

	/**
	 */
	public void setAttachmentUrl(String attachmentUrl) {
		this.attachmentUrl = attachmentUrl;
	}

	/**
	 */
	public String getAttachmentUrl() {
		return this.attachmentUrl;
	}

	/**
	 */
	public void setTestcase(Testcase testcase) {
		this.testcase = testcase;
	}

	/**
	 */
	public Testcase getTestcase() {
		return testcase;
	}

	/**
	 */
	public void setPerson(Person person) {
		this.person = person;
	}

	/**
	 */
	public Person getPerson() {
		return person;
	}

	/**
	 */
	public void setAccount(Account account) {
		this.account = account;
	}

	/**
	 */
	public Account getAccount() {
		return account;
	}

	/**
	 */
	public void setChangerequest(Changerequest changerequest) {
		this.changerequest = changerequest;
	}

	/**
	 */
	public Changerequest getChangerequest() {
		return changerequest;
	}

	/**
	 */
	public void setDefect(Defect defect) {
		this.defect = defect;
	}

	/**
	 */
	public Defect getDefect() {
		return defect;
	}

	/**
	 */
	public void setRequirement(Requirement requirement) {
		this.requirement = requirement;
	}

	/**
	 */
	public Requirement getRequirement() {
		return requirement;
	}

	/**
	 */
	public void setStatusupdate(Statusupdate statusupdate) {
		this.statusupdate = statusupdate;
	}

	/**
	 */
	public Statusupdate getStatusupdate() {
		return statusupdate;
	}

	/**
	 */
	public void setProject(Project project) {
		this.project = project;
	}

	/**
	 */
	public Project getProject() {
		return project;
	}

	/**
	 */
	public Attachment() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(Attachment that) {
		setAttachId(that.getAttachId());
		setAttachmentType(that.getAttachmentType());
		setAttachmentUrl(that.getAttachmentUrl());
		setTestcase(that.getTestcase());
		setPerson(that.getPerson());
		setAccount(that.getAccount());
		setChangerequest(that.getChangerequest());
		setDefect(that.getDefect());
		setRequirement(that.getRequirement());
		setStatusupdate(that.getStatusupdate());
		setProject(that.getProject());
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("attachId=[").append(attachId).append("] ");
		buffer.append("attachmentType=[").append(attachmentType).append("] ");
		buffer.append("attachmentUrl=[").append(attachmentUrl).append("] ");

		return buffer.toString();
	}

	/**
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (int) (prime * result + ((attachId == null) ? 0 : attachId.hashCode()));
		return result;
	}

	/**
	 */
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof Attachment))
			return false;
		Attachment equalCheck = (Attachment) obj;
		if ((attachId == null && equalCheck.attachId != null) || (attachId != null && equalCheck.attachId == null))
			return false;
		if (attachId != null && !attachId.equals(equalCheck.attachId))
			return false;
		return true;
	}
}
