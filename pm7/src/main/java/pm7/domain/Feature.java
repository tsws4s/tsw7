package pm7.domain;

import java.io.Serializable;

import java.lang.StringBuilder;

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
		@NamedQuery(name = "findAllFeatures", query = "select myFeature from Feature myFeature"),
		@NamedQuery(name = "findFeatureByFeatureCode", query = "select myFeature from Feature myFeature where myFeature.featureCode = ?1"),
		@NamedQuery(name = "findFeatureByFeatureCodeContaining", query = "select myFeature from Feature myFeature where myFeature.featureCode like ?1"),
		@NamedQuery(name = "findFeatureByFeatureId", query = "select myFeature from Feature myFeature where myFeature.featureId = ?1"),
		@NamedQuery(name = "findFeatureByFeatureName", query = "select myFeature from Feature myFeature where myFeature.featureName = ?1"),
		@NamedQuery(name = "findFeatureByFeatureNameContaining", query = "select myFeature from Feature myFeature where myFeature.featureName like ?1"),
		@NamedQuery(name = "findFeatureByFeaturePriority", query = "select myFeature from Feature myFeature where myFeature.featurePriority = ?1"),
		@NamedQuery(name = "findFeatureByFeaturePriorityContaining", query = "select myFeature from Feature myFeature where myFeature.featurePriority like ?1"),
		@NamedQuery(name = "findFeatureByPrimaryKey", query = "select myFeature from Feature myFeature where myFeature.featureId = ?1") })
@Table(catalog = "C324877_project_mgt", name = "Feature")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "pm7/pm7/domain", name = "Feature")
@XmlRootElement(namespace = "pm7/pm7/domain")
public class Feature implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 */

	@Column(name = "featureId", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	@XmlElement
	Integer featureId;
	/**
	 */

	@Column(name = "featureCode", length = 10)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String featureCode;
	/**
	 */

	@Column(name = "featureName", length = 150)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String featureName;
	/**
	 */

	@Column(name = "featurePriority", length = 20)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String featurePriority;

	/**
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "FK_releaseId", referencedColumnName = "releaseId") })
	@XmlTransient
	Releaseplan releaseplan;
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
	@OneToMany(mappedBy = "feature", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<pm7.domain.Changerequest> changerequests;
	/**
	 */
	@OneToMany(mappedBy = "feature", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<pm7.domain.Requirement> requirements;

	/**
	 */
	public void setFeatureId(Integer featureId) {
		this.featureId = featureId;
	}

	/**
	 */
	public Integer getFeatureId() {
		return this.featureId;
	}

	/**
	 */
	public void setFeatureCode(String featureCode) {
		this.featureCode = featureCode;
	}

	/**
	 */
	public String getFeatureCode() {
		return this.featureCode;
	}

	/**
	 */
	public void setFeatureName(String featureName) {
		this.featureName = featureName;
	}

	/**
	 */
	public String getFeatureName() {
		return this.featureName;
	}

	/**
	 */
	public void setFeaturePriority(String featurePriority) {
		this.featurePriority = featurePriority;
	}

	/**
	 */
	public String getFeaturePriority() {
		return this.featurePriority;
	}

	/**
	 */
	public void setReleaseplan(Releaseplan releaseplan) {
		this.releaseplan = releaseplan;
	}

	/**
	 */
	public Releaseplan getReleaseplan() {
		return releaseplan;
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
	public Feature() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(Feature that) {
		setFeatureId(that.getFeatureId());
		setFeatureCode(that.getFeatureCode());
		setFeatureName(that.getFeatureName());
		setFeaturePriority(that.getFeaturePriority());
		setReleaseplan(that.getReleaseplan());
		setAccount(that.getAccount());
		setProject(that.getProject());
		setChangerequests(new java.util.LinkedHashSet<pm7.domain.Changerequest>(that.getChangerequests()));
		setRequirements(new java.util.LinkedHashSet<pm7.domain.Requirement>(that.getRequirements()));
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("featureId=[").append(featureId).append("] ");
		buffer.append("featureCode=[").append(featureCode).append("] ");
		buffer.append("featureName=[").append(featureName).append("] ");
		buffer.append("featurePriority=[").append(featurePriority).append("] ");

		return buffer.toString();
	}

	/**
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (int) (prime * result + ((featureId == null) ? 0 : featureId.hashCode()));
		return result;
	}

	/**
	 */
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof Feature))
			return false;
		Feature equalCheck = (Feature) obj;
		if ((featureId == null && equalCheck.featureId != null) || (featureId != null && equalCheck.featureId == null))
			return false;
		if (featureId != null && !featureId.equals(equalCheck.featureId))
			return false;
		return true;
	}
}
