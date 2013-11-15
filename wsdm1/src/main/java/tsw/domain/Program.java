package tsw.domain;

import java.io.Serializable;

import java.lang.StringBuilder;
import java.math.BigDecimal;

import java.util.Calendar;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import javax.xml.bind.annotation.*;

import javax.persistence.*;

import tsw.utils.GameGenerator;

/**
 */

@Entity
@NamedQueries({
		@NamedQuery(name = "findAllPrograms4tsw", query = "select myProgram from Program myProgram where (myProgram.leagueYn = '0') and (tswAcctFK = ?1)"),
		@NamedQuery(name = "findAllLeagues4tsw", query = "select myProgram from Program myProgram where (myProgram.leagueYn = '1') and (tswAcctFK = ?1)"),
		@NamedQuery(name = "findAnyPrograms4tsw", query = "select myProgram from Program myProgram where (tswAcctFK = ?1)"),
		@NamedQuery(name = "findProgramByActiveYn", query = "select myProgram from Program myProgram where myProgram.activeYn = ?1"),
		@NamedQuery(name = "findProgramByEndDate", query = "select myProgram from Program myProgram where myProgram.endDate = ?1"),
		@NamedQuery(name = "findProgramByEndDateAfter", query = "select myProgram from Program myProgram where myProgram.endDate > ?1"),
		@NamedQuery(name = "findProgramByEndDateBefore", query = "select myProgram from Program myProgram where myProgram.endDate < ?1"),
		@NamedQuery(name = "findProgramByGamesPerTeam", query = "select myProgram from Program myProgram where myProgram.gamesPerTeam = ?1"),
		@NamedQuery(name = "findProgramByLeagueYn", query = "select myProgram from Program myProgram where myProgram.leagueYn = ?1"),
		@NamedQuery(name = "findProgramByPrice", query = "select myProgram from Program myProgram where myProgram.price = ?1"),
		@NamedQuery(name = "findProgramByPrimaryKey", query = "select myProgram from Program myProgram where myProgram.programId = ?1"),
		@NamedQuery(name = "findProgramByProgramId", query = "select myProgram from Program myProgram where myProgram.programId = ?1"),
		@NamedQuery(name = "findProgramByProgramName", query = "select myProgram from Program myProgram where tswAcctfk = ?1 and myProgram.programName = ?2"),
		@NamedQuery(name = "findProgramByProgramNameContaining", query = "select myProgram from Program myProgram where myProgram.programName like ?1"),
		@NamedQuery(name = "findProgramByPublishYn", query = "select myProgram from Program myProgram where myProgram.publishYn = ?1"),
		@NamedQuery(name = "findProgramByStartDate", query = "select myProgram from Program myProgram where myProgram.startDate = ?1"),
		@NamedQuery(name = "findProgramByStartDateAfter", query = "select myProgram from Program myProgram where myProgram.startDate > ?1"),
		@NamedQuery(name = "findProgramByStartDateBefore", query = "select myProgram from Program myProgram where myProgram.startDate < ?1"),
		@NamedQuery(name = "findProgramByTotalPaid", query = "select myProgram from Program myProgram where myProgram.totalPaid = ?1"),
		@NamedQuery(name = "findProgramByTotalParticipants", query = "select myProgram from Program myProgram where myProgram.totalParticipants = ?1") })
@Table(catalog = "tsws4s_4", name = "Program")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "tsw7/tsw/domain", name = "Program")
@XmlRootElement(namespace = "tsw7/tsw/domain")
public class Program implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 */

	@Column(name = "programID", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	@XmlElement
	Integer programId;
	/**
	 */

	@Column(name = "programName", length = 155)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String programName;

	/**
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "startDate")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Calendar startDate;
	/**
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "endDate")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Calendar endDate;
	/**
	 */

	@Column(name = "activeYN")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer activeYn;
	/**
	 */

	@Column(name = "publishYN")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer publishYn;
	/**
	 */
	
	@Column(name = "totalPaid", scale = 2, precision = 32)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	BigDecimal totalPaid;
	/**
	 */

	@Column(name = "totalParticipants")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer totalParticipants;
	/**
	 */
	@Column(name = "gamesPerTeam")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer gamesPerTeam;

	@Column(name = "gameMins")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer gameMins;	

	/**
	 */
	@Column(name = "leagueYN")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer leagueYn;

	/**
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "resourceFK", referencedColumnName = "resourceID") })
	@XmlTransient
	Resource resource;

	/**
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "levelFK", referencedColumnName = "levelID") })
	@XmlTransient
	Level level;
	/**
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "tswAcctFK", referencedColumnName = "tswAcctID") })
	@XmlTransient
	Tswacct tswacct;
	/**
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "pgmCoordFK", referencedColumnName = "customerID") })
	@XmlTransient
	Customer customer;
		
	/**
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "priceFK", referencedColumnName = "priceId") })
	@XmlTransient
	Price price;
	
	/**
	 */
	@OneToMany(mappedBy = "program", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<tsw.domain.Participant> participants;
	/**
	 */
	@OneToMany(mappedBy = "program", fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<tsw.domain.Teamplayers> teamplayerses;
	/**
	 */
	@OneToMany(mappedBy = "program", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<tsw.domain.Game> games;
	/**
	 */
	@OneToMany(mappedBy = "program", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<tsw.domain.Team> teams;
	/**
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "sportFK", referencedColumnName = "sportId") })
	@XmlTransient
	Sport sport;
	/**
	 */
	@OneToMany(mappedBy = "program", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<tsw.domain.Programresource> programresources;
	
	/**
	 */
	public void setProgramId(Integer programId) {
		this.programId = programId;
	}

	/**
	 */
	public Integer getProgramId() {
		return this.programId;
	}

	/**
	 */
	public void setProgramresources(Set<Programresource> programresources) {
		this.programresources = programresources;
	}

	/**
	 */
	public Set<Programresource> getProgramresources() {
		if (programresources == null) {
			programresources = new java.util.LinkedHashSet<tsw.domain.Programresource>();
		}
		return programresources;
	}
	/**
	 */
	public void setProgramName(String programName) {
		this.programName = programName;
	}

	/**
	 */
	public String getProgramName() {
		return this.programName;
	}

	public Resource getResource() {
		return resource;
	}

	public void setResource(Resource resource) {
		this.resource = resource;
	}

	public Price getPrice() {
		return price;
	}

	public void setPrice(Price price) {
		this.price = price;
	}
	/**
	 */
	public void setSport(Sport sport) {
		this.sport = sport;
	}

	/**
	 */
	public Sport getSport() {
		return sport;
	}
	/**
	 */
	public void setStartDate(Calendar startDate) {
		this.startDate = startDate;
	}

	/**
	 */
	public Calendar getStartDate() {
		return this.startDate;
	}

	/**
	 */
	public void setEndDate(Calendar endDate) {
		this.endDate = endDate;
	}

	/**
	 */
	public Calendar getEndDate() {
		return this.endDate;
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
	public void setPublishYn(Integer publishYn) {
		this.publishYn = publishYn;
	}

	/**
	 */
	public Integer getPublishYn() {
		return this.publishYn;
	}

	/**
	 */
	public void setTotalPaid(BigDecimal totalPaid) {
		this.totalPaid = totalPaid;
	}

	/**
	 */
	public BigDecimal getTotalPaid() {
		return this.totalPaid;
	}

	/**
	 */
	public void setTotalParticipants(Integer totalParticipants) {
		this.totalParticipants = totalParticipants;
	}

	/**
	 */
	public Integer getTotalParticipants() {
		return this.totalParticipants;
	}

	/**
	 */
	public void setGamesPerTeam(Integer gamesPerTeam) {
		this.gamesPerTeam = gamesPerTeam;
	}

	/**
	 */
	public Integer getGamesPerTeam() {
		return this.gamesPerTeam;
	}

	public Integer getGameMins() {
		return gameMins;
	}

	public void setGameMins(Integer gameMins) {
		this.gameMins = gameMins;
	}
	
	/**
	 */
	public void setLeagueYn(Integer leagueYn) {
		this.leagueYn = leagueYn;
	}

	/**
	 */
	public Integer getLeagueYn() {
		return this.leagueYn;
	}

	/**
	 */
	public void setLevel(Level level) {
		this.level = level;
	}

	/**
	 */
	public Level getLevel() {
		return level;
	}

	/**
	 */
	public void setTswacct(Tswacct tswacct) {
		this.tswacct = tswacct;
	}

	/**
	 */
	public Tswacct getTswacct() {
		return tswacct;
	}

	/**
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	/**
	 */
	public Customer getCustomer() {
		return customer;
	}

	/**
	 */
	public void setParticipants(Set<Participant> participants) {
		this.participants = participants;
	}

	/**
	 */
	public Set<Participant> getParticipants() {
		if (participants == null) {
			participants = new java.util.LinkedHashSet<tsw.domain.Participant>();
		}
		return participants;
	}

	/**
	 */
	public void setTeamplayerses(Set<Teamplayers> teamplayerses) {
		this.teamplayerses = teamplayerses;
	}

	/**
	 */
	public Set<Teamplayers> getTeamplayerses() {
		if (teamplayerses == null) {
			teamplayerses = new java.util.LinkedHashSet<tsw.domain.Teamplayers>();
		}
		return teamplayerses;
	}

	/**
	 */
	public void setGames(Set<Game> games) {
		this.games = games;
	}

	/**
	 */
	public Set<Game> getGames() {
		if (games == null) {
			games = new java.util.LinkedHashSet<tsw.domain.Game>();
		}
		return games;
	}

	/**
	 */
	public void setTeams(Set<Team> teams) {
		this.teams = teams;
	}

	/**
	 */
	public Set<Team> getTeams() {
		if (teams == null) {
			teams = new java.util.LinkedHashSet<tsw.domain.Team>();
		}
		return teams;
	}

	/**
	 */
	public Program() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(Program that) {
		setProgramId(that.getProgramId());
		setProgramName(that.getProgramName());
		setPrice(that.getPrice());
		setStartDate(that.getStartDate());
		setEndDate(that.getEndDate());
		setActiveYn(that.getActiveYn());
		setPublishYn(that.getPublishYn());
		setTotalPaid(that.getTotalPaid());
		setTotalParticipants(that.getTotalParticipants());
		setGamesPerTeam(that.getGamesPerTeam());
		setLeagueYn(that.getLeagueYn());
		setLevel(that.getLevel());
		setTswacct(that.getTswacct());
		setCustomer(that.getCustomer());
		setParticipants(new java.util.LinkedHashSet<tsw.domain.Participant>(that.getParticipants()));
		setTeamplayerses(new java.util.LinkedHashSet<tsw.domain.Teamplayers>(that.getTeamplayerses()));
		setProgramresources(new java.util.LinkedHashSet<tsw.domain.Programresource>(that.getProgramresources()));
		setGames(new java.util.LinkedHashSet<tsw.domain.Game>(that.getGames()));
		setTeams(new java.util.LinkedHashSet<tsw.domain.Team>(that.getTeams()));
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("programId=[").append(programId).append("] ");
		buffer.append("programName=[").append(programName).append("] ");
		buffer.append("price=[").append(price).append("] ");
		buffer.append("startDate=[").append(startDate).append("] ");
		buffer.append("endDate=[").append(endDate).append("] ");
		buffer.append("activeYn=[").append(activeYn).append("] ");
		buffer.append("publishYn=[").append(publishYn).append("] ");
		buffer.append("totalPaid=[").append(totalPaid).append("] ");
		buffer.append("totalParticipants=[").append(totalParticipants).append("] ");
		buffer.append("gamesPerTeam=[").append(gamesPerTeam).append("] ");
		buffer.append("leagueYn=[").append(leagueYn).append("] ");

		return buffer.toString();
	}

	/**
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (int) (prime * result + ((programId == null) ? 0 : programId.hashCode()));
		return result;
	}

	/**
	 */
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof Program))
			return false;
		Program equalCheck = (Program) obj;
		if ((programId == null && equalCheck.programId != null) || (programId != null && equalCheck.programId == null))
			return false;
		if (programId != null && !programId.equals(equalCheck.programId))
			return false;
		return true;
	}

	public ProgGenGames generateGames() {
		ProgGenGames pgmGenGames = new ProgGenGames();
		pgmGenGames.setProgramId(getProgramId());
		Integer resId = null;
		if(getResource()!=null){
			resId = getResource().getResourceId();
		}
		System.out.println("Program.generateGames");
		pgmGenGames.setGengamesList(GameGenerator.generateGamePairings(resId, getTeams(), getGamesPerTeam()));
	
		return pgmGenGames;
	}

}
