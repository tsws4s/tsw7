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
		@NamedQuery(name = "findAllProjectteams", query = "select myProjectteam from Projectteam myProjectteam"),
		@NamedQuery(name = "findProjectteamByPersonProjectActualHrs", query = "select myProjectteam from Projectteam myProjectteam where myProjectteam.personProjectActualHrs = ?1"),
		@NamedQuery(name = "findProjectteamByPersonProjectEstHrs", query = "select myProjectteam from Projectteam myProjectteam where myProjectteam.personProjectEstHrs = ?1"),
		@NamedQuery(name = "findProjectteamByPrimaryKey", query = "select myProjectteam from Projectteam myProjectteam where myProjectteam.projectTeamId = ?1"),
		@NamedQuery(name = "findProjectteamByProjectRole", query = "select myProjectteam from Projectteam myProjectteam where myProjectteam.projectRole = ?1"),
		@NamedQuery(name = "findProjectteamByProjectRoleContaining", query = "select myProjectteam from Projectteam myProjectteam where myProjectteam.projectRole like ?1"),
		@NamedQuery(name = "findProjectteamByProjectTeamId", query = "select myProjectteam from Projectteam myProjectteam where myProjectteam.projectTeamId = ?1") })
@Table(catalog = "C324877_project_mgt", name = "ProjectTeam")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "pm7/pm7/domain", name = "Projectteam")
public class Projectteam implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 */

	@Column(name = "projectTeamId", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	@XmlElement
	Integer projectTeamId;
	/**
	 */

	@Column(name = "projectRole", length = 50)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String projectRole;
	/**
	 */

	@Column(name = "personProjectEstHrs")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer personProjectEstHrs;
	/**
	 */

	@Column(name = "personProjectActualHrs")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer personProjectActualHrs;

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
	@JoinColumns({ @JoinColumn(name = "FK_projectId", referencedColumnName = "projectId") })
	@XmlTransient
	Project project;

	/**
	 */
	public void setProjectTeamId(Integer projectTeamId) {
		this.projectTeamId = projectTeamId;
	}

	/**
	 */
	public Integer getProjectTeamId() {
		return this.projectTeamId;
	}

	/**
	 */
	public void setProjectRole(String projectRole) {
		this.projectRole = projectRole;
	}

	/**
	 */
	public String getProjectRole() {
		return this.projectRole;
	}

	/**
	 */
	public void setPersonProjectEstHrs(Integer personProjectEstHrs) {
		this.personProjectEstHrs = personProjectEstHrs;
	}

	/**
	 */
	public Integer getPersonProjectEstHrs() {
		return this.personProjectEstHrs;
	}

	/**
	 */
	public void setPersonProjectActualHrs(Integer personProjectActualHrs) {
		this.personProjectActualHrs = personProjectActualHrs;
	}

	/**
	 */
	public Integer getPersonProjectActualHrs() {
		return this.personProjectActualHrs;
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
	public Projectteam() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(Projectteam that) {
		setProjectTeamId(that.getProjectTeamId());
		setProjectRole(that.getProjectRole());
		setPersonProjectEstHrs(that.getPersonProjectEstHrs());
		setPersonProjectActualHrs(that.getPersonProjectActualHrs());
		setPerson(that.getPerson());
		setAccount(that.getAccount());
		setProject(that.getProject());
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("projectTeamId=[").append(projectTeamId).append("] ");
		buffer.append("projectRole=[").append(projectRole).append("] ");
		buffer.append("personProjectEstHrs=[").append(personProjectEstHrs).append("] ");
		buffer.append("personProjectActualHrs=[").append(personProjectActualHrs).append("] ");

		return buffer.toString();
	}

	/**
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (int) (prime * result + ((projectTeamId == null) ? 0 : projectTeamId.hashCode()));
		return result;
	}

	/**
	 */
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof Projectteam))
			return false;
		Projectteam equalCheck = (Projectteam) obj;
		if ((projectTeamId == null && equalCheck.projectTeamId != null) || (projectTeamId != null && equalCheck.projectTeamId == null))
			return false;
		if (projectTeamId != null && !projectTeamId.equals(equalCheck.projectTeamId))
			return false;
		return true;
	}
}
