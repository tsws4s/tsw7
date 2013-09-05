package pm7.domain;

import java.io.Serializable;

import java.lang.StringBuilder;

import java.util.Calendar;
import java.util.LinkedHashSet;
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
		@NamedQuery(name = "findAllReleaseplans", query = "select myReleaseplan from Releaseplan myReleaseplan"),
		@NamedQuery(name = "findReleaseplanByPrimaryKey", query = "select myReleaseplan from Releaseplan myReleaseplan where myReleaseplan.releaseId = ?1"),
		@NamedQuery(name = "findReleaseplanByReleaseCode", query = "select myReleaseplan from Releaseplan myReleaseplan where myReleaseplan.releaseCode = ?1"),
		@NamedQuery(name = "findReleaseplanByReleaseCodeContaining", query = "select myReleaseplan from Releaseplan myReleaseplan where myReleaseplan.releaseCode like ?1"),
		@NamedQuery(name = "findReleaseplanByReleaseDate", query = "select myReleaseplan from Releaseplan myReleaseplan where myReleaseplan.releaseDate = ?1"),
		@NamedQuery(name = "findReleaseplanByReleaseDateAfter", query = "select myReleaseplan from Releaseplan myReleaseplan where myReleaseplan.releaseDate > ?1"),
		@NamedQuery(name = "findReleaseplanByReleaseDateBefore", query = "select myReleaseplan from Releaseplan myReleaseplan where myReleaseplan.releaseDate < ?1"),
		@NamedQuery(name = "findReleaseplanByReleaseDescription", query = "select myReleaseplan from Releaseplan myReleaseplan where myReleaseplan.releaseDescription = ?1"),
		@NamedQuery(name = "findReleaseplanByReleaseDescriptionContaining", query = "select myReleaseplan from Releaseplan myReleaseplan where myReleaseplan.releaseDescription like ?1"),
		@NamedQuery(name = "findReleaseplanByReleaseId", query = "select myReleaseplan from Releaseplan myReleaseplan where myReleaseplan.releaseId = ?1"),
		@NamedQuery(name = "findReleaseplanByReleaseName", query = "select myReleaseplan from Releaseplan myReleaseplan where myReleaseplan.releaseName = ?1"),
		@NamedQuery(name = "findReleaseplanByReleaseNameContaining", query = "select myReleaseplan from Releaseplan myReleaseplan where myReleaseplan.releaseName like ?1") })
@Table(catalog = "C324877_project_mgt", name = "ReleasePlan")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "pm7/pm7/domain", name = "Releaseplan")
@XmlRootElement(namespace = "pm7/pm7/domain")
public class Releaseplan implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 */

	@Column(name = "releaseId", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	@XmlElement
	Integer releaseId;
	/**
	 */

	@Column(name = "releaseCode", length = 10)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String releaseCode;
	/**
	 */

	@Column(name = "releaseName", length = 150)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String releaseName;
	/**
	 */

	@Column(name = "releaseDescription", length = 240)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String releaseDescription;
	/**
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "releaseDate")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Calendar releaseDate;

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
	@OneToMany(mappedBy = "releaseplan", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<pm7.domain.Feature> features;
	/**
	 */
	@OneToMany(mappedBy = "releaseplan", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<pm7.domain.Defect> defects;
	/**
	 */
	@OneToMany(mappedBy = "releaseplan", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<pm7.domain.Requirement> requirements;
	/**
	 */
	@OneToMany(mappedBy = "releaseplan", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<pm7.domain.Statusupdate> statusupdates;
	/**
	 */
	@OneToMany(mappedBy = "releaseplan", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<pm7.domain.Changerequest> changerequests;

	/**
	 */
	public void setReleaseId(Integer releaseId) {
		this.releaseId = releaseId;
	}

	/**
	 */
	public Integer getReleaseId() {
		return this.releaseId;
	}

	/**
	 */
	public void setReleaseCode(String releaseCode) {
		this.releaseCode = releaseCode;
	}

	/**
	 */
	public String getReleaseCode() {
		return this.releaseCode;
	}

	/**
	 */
	public void setReleaseName(String releaseName) {
		this.releaseName = releaseName;
	}

	/**
	 */
	public String getReleaseName() {
		return this.releaseName;
	}

	/**
	 */
	public void setReleaseDescription(String releaseDescription) {
		this.releaseDescription = releaseDescription;
	}

	/**
	 */
	public String getReleaseDescription() {
		return this.releaseDescription;
	}

	/**
	 */
	public void setReleaseDate(Calendar releaseDate) {
		this.releaseDate = releaseDate;
	}

	/**
	 */
	public Calendar getReleaseDate() {
		return this.releaseDate;
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
	public void setFeatures(Set<Feature> features) {
		this.features = features;
	}

	/**
	 */
	public Set<Feature> getFeatures() {
		if (features == null) {
			features = new java.util.LinkedHashSet<pm7.domain.Feature>();
		}
		return features;
	}

	/**
	 */
	public void setDefects(Set<Defect> defects) {
		this.defects = defects;
	}

	/**
	 */
	public Set<Defect> getDefects() {
		if (defects == null) {
			defects = new java.util.LinkedHashSet<pm7.domain.Defect>();
		}
		return defects;
	}

	/**
	 */
	public void setRequirements(Set<Requirement> requirements) {
		this.requirements = requirements;
	}

	/**
	 */
	public Set<Requirement> getRequirements() {
		if (requirements == null) {
			requirements = new java.util.LinkedHashSet<pm7.domain.Requirement>();
		}
		return requirements;
	}

	/**
	 */
	public void setStatusupdates(Set<Statusupdate> statusupdates) {
		this.statusupdates = statusupdates;
	}

	/**
	 */
	public Set<Statusupdate> getStatusupdates() {
		if (statusupdates == null) {
			statusupdates = new java.util.LinkedHashSet<pm7.domain.Statusupdate>();
		}
		return statusupdates;
	}

	/**
	 */
	public void setChangerequests(Set<Changerequest> changerequests) {
		this.changerequests = changerequests;
	}

	/**
	 */
	public Set<Changerequest> getChangerequests() {
		if (changerequests == null) {
			changerequests = new java.util.LinkedHashSet<pm7.domain.Changerequest>();
		}
		return changerequests;
	}

	/**
	 */
	public Releaseplan() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(Releaseplan that) {
		setReleaseId(that.getReleaseId());
		setReleaseCode(that.getReleaseCode());
		setReleaseName(that.getReleaseName());
		setReleaseDescription(that.getReleaseDescription());
		setReleaseDate(that.getReleaseDate());
		setAccount(that.getAccount());
		setProject(that.getProject());
		setFeatures(new java.util.LinkedHashSet<pm7.domain.Feature>(that.getFeatures()));
		setDefects(new java.util.LinkedHashSet<pm7.domain.Defect>(that.getDefects()));
		setRequirements(new java.util.LinkedHashSet<pm7.domain.Requirement>(that.getRequirements()));
		setStatusupdates(new java.util.LinkedHashSet<pm7.domain.Statusupdate>(that.getStatusupdates()));
		setChangerequests(new java.util.LinkedHashSet<pm7.domain.Changerequest>(that.getChangerequests()));
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("releaseId=[").append(releaseId).append("] ");
		buffer.append("releaseCode=[").append(releaseCode).append("] ");
		buffer.append("releaseName=[").append(releaseName).append("] ");
		buffer.append("releaseDescription=[").append(releaseDescription).append("] ");
		buffer.append("releaseDate=[").append(releaseDate).append("] ");

		return buffer.toString();
	}

	/**
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (int) (prime * result + ((releaseId == null) ? 0 : releaseId.hashCode()));
		return result;
	}

	/**
	 */
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof Releaseplan))
			return false;
		Releaseplan equalCheck = (Releaseplan) obj;
		if ((releaseId == null && equalCheck.releaseId != null) || (releaseId != null && equalCheck.releaseId == null))
			return false;
		if (releaseId != null && !releaseId.equals(equalCheck.releaseId))
			return false;
		return true;
	}
}
