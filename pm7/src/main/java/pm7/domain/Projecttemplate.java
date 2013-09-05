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
		@NamedQuery(name = "findAllProjecttemplates", query = "select myProjecttemplate from Projecttemplate myProjecttemplate"),
		@NamedQuery(name = "findProjecttemplateByActiveYn", query = "select myProjecttemplate from Projecttemplate myProjecttemplate where myProjecttemplate.activeYn = ?1"),
		@NamedQuery(name = "findProjecttemplateByPrimaryKey", query = "select myProjecttemplate from Projecttemplate myProjecttemplate where myProjecttemplate.templateId = ?1"),
		@NamedQuery(name = "findProjecttemplateByTemplateDesc", query = "select myProjecttemplate from Projecttemplate myProjecttemplate where myProjecttemplate.templateDesc = ?1"),
		@NamedQuery(name = "findProjecttemplateByTemplateDescContaining", query = "select myProjecttemplate from Projecttemplate myProjecttemplate where myProjecttemplate.templateDesc like ?1"),
		@NamedQuery(name = "findProjecttemplateByTemplateId", query = "select myProjecttemplate from Projecttemplate myProjecttemplate where myProjecttemplate.templateId = ?1"),
		@NamedQuery(name = "findProjecttemplateByTemplateName", query = "select myProjecttemplate from Projecttemplate myProjecttemplate where myProjecttemplate.templateName = ?1"),
		@NamedQuery(name = "findProjecttemplateByTemplateNameContaining", query = "select myProjecttemplate from Projecttemplate myProjecttemplate where myProjecttemplate.templateName like ?1") })
@Table(catalog = "C324877_project_mgt", name = "ProjectTemplate")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "pm7/pm7/domain", name = "Projecttemplate")
public class Projecttemplate implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 */

	@Column(name = "templateId", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	@XmlElement
	Integer templateId;
	/**
	 */

	@Column(name = "templateName", length = 45)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String templateName;
	/**
	 */

	@Column(name = "templateDesc", length = 245)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String templateDesc;
	/**
	 */

	@Column(name = "activeYN")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer activeYn;

	/**
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "FK_accountId", referencedColumnName = "accountId") })
	@XmlTransient
	Account account;
	/**
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "FK_projectId", referencedColumnName = "projectId") })
	@XmlTransient
	Project project;

	/**
	 */
	public void setTemplateId(Integer templateId) {
		this.templateId = templateId;
	}

	/**
	 */
	public Integer getTemplateId() {
		return this.templateId;
	}

	/**
	 */
	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}

	/**
	 */
	public String getTemplateName() {
		return this.templateName;
	}

	/**
	 */
	public void setTemplateDesc(String templateDesc) {
		this.templateDesc = templateDesc;
	}

	/**
	 */
	public String getTemplateDesc() {
		return this.templateDesc;
	}

	/**
	 */
	public void setActiveYn(Integer activeYn) {
		this.activeYn = activeYn;
	}

	/**
	 */
	public Integer getActiveYn() {
		return this.activeYn;
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
	public Projecttemplate() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(Projecttemplate that) {
		setTemplateId(that.getTemplateId());
		setTemplateName(that.getTemplateName());
		setTemplateDesc(that.getTemplateDesc());
		setActiveYn(that.getActiveYn());
		setAccount(that.getAccount());
		setProject(that.getProject());
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("templateId=[").append(templateId).append("] ");
		buffer.append("templateName=[").append(templateName).append("] ");
		buffer.append("templateDesc=[").append(templateDesc).append("] ");
		buffer.append("activeYn=[").append(activeYn).append("] ");

		return buffer.toString();
	}

	/**
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (int) (prime * result + ((templateId == null) ? 0 : templateId.hashCode()));
		return result;
	}

	/**
	 */
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof Projecttemplate))
			return false;
		Projecttemplate equalCheck = (Projecttemplate) obj;
		if ((templateId == null && equalCheck.templateId != null) || (templateId != null && equalCheck.templateId == null))
			return false;
		if (templateId != null && !templateId.equals(equalCheck.templateId))
			return false;
		return true;
	}
}
