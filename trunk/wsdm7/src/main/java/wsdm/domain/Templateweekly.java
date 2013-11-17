package wsdm.domain;

import java.io.Serializable;

import java.lang.StringBuilder;

import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import javax.xml.bind.annotation.*;

import javax.persistence.*;

/**
 */

@Entity
@NamedQueries({
		@NamedQuery(name = "findAllTemplateweeklys", query = "select myTemplateweekly from Templateweekly myTemplateweekly"),
		@NamedQuery(name = "findTemplateweeklyByDescription", query = "select myTemplateweekly from Templateweekly myTemplateweekly where myTemplateweekly.description = ?1"),
		@NamedQuery(name = "findTemplateweeklyByDescriptionContaining", query = "select myTemplateweekly from Templateweekly myTemplateweekly where myTemplateweekly.description like ?1"),
		@NamedQuery(name = "findTemplateweeklyByFriDailyFk", query = "select myTemplateweekly from Templateweekly myTemplateweekly where myTemplateweekly.friDailyFk = ?1"),
		@NamedQuery(name = "findTemplateweeklyByMonDailyFk", query = "select myTemplateweekly from Templateweekly myTemplateweekly where myTemplateweekly.monDailyFk = ?1"),
		@NamedQuery(name = "findTemplateweeklyByPrimaryKey", query = "select myTemplateweekly from Templateweekly myTemplateweekly where myTemplateweekly.weeklyTemplateId = ?1"),
		@NamedQuery(name = "findTemplateweeklyBySatDailyFk", query = "select myTemplateweekly from Templateweekly myTemplateweekly where myTemplateweekly.satDailyFk = ?1"),
		@NamedQuery(name = "findTemplateweeklyBySunDailyFk", query = "select myTemplateweekly from Templateweekly myTemplateweekly where myTemplateweekly.sunDailyFk = ?1"),
		@NamedQuery(name = "findTemplateweeklyByTemplateName", query = "select myTemplateweekly from Templateweekly myTemplateweekly where myTemplateweekly.templateName = ?1"),
		@NamedQuery(name = "findTemplateweeklyByTemplateNameContaining", query = "select myTemplateweekly from Templateweekly myTemplateweekly where myTemplateweekly.templateName like ?1"),
		@NamedQuery(name = "findTemplateweeklyByThuDailyFk", query = "select myTemplateweekly from Templateweekly myTemplateweekly where myTemplateweekly.thuDailyFk = ?1"),
		@NamedQuery(name = "findTemplateweeklyByTueDailyFk", query = "select myTemplateweekly from Templateweekly myTemplateweekly where myTemplateweekly.tueDailyFk = ?1"),
		@NamedQuery(name = "findTemplateweeklyByWedDailyFk", query = "select myTemplateweekly from Templateweekly myTemplateweekly where myTemplateweekly.wedDailyFk = ?1"),
		@NamedQuery(name = "findTemplateweeklyByWeeklyTemplateId", query = "select myTemplateweekly from Templateweekly myTemplateweekly where myTemplateweekly.weeklyTemplateId = ?1") })
@Table(catalog = "C324877_tsws4s", name = "TemplateWeekly")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "wsdm7/wsdm/domain", name = "Templateweekly")
public class Templateweekly implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 */

	@Column(name = "weeklyTemplateId", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	@XmlElement
	Integer weeklyTemplateId;
	/**
	 */

	@Column(name = "templateName", length = 45)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String templateName;
	/**
	 */

	@Column(name = "description", length = 235)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String description;
	/**
	 */

	@Column(name = "sun_dailyFK")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer sunDailyFk;
	/**
	 */

	@Column(name = "mon_dailyFK")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer monDailyFk;
	/**
	 */

	@Column(name = "tue_dailyFK")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer tueDailyFk;
	/**
	 */

	@Column(name = "wed_dailyFK")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer wedDailyFk;
	/**
	 */

	@Column(name = "thu_dailyFK")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer thuDailyFk;
	/**
	 */

	@Column(name = "fri_dailyFK")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer friDailyFk;
	/**
	 */

	@Column(name = "sat_dailyFK")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer satDailyFk;

	/**
	 */
	public void setWeeklyTemplateId(Integer weeklyTemplateId) {
		this.weeklyTemplateId = weeklyTemplateId;
	}

	/**
	 */
	public Integer getWeeklyTemplateId() {
		return this.weeklyTemplateId;
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
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 */
	public String getDescription() {
		return this.description;
	}

	/**
	 */
	public void setSunDailyFk(Integer sunDailyFk) {
		this.sunDailyFk = sunDailyFk;
	}

	/**
	 */
	public Integer getSunDailyFk() {
		return this.sunDailyFk;
	}

	/**
	 */
	public void setMonDailyFk(Integer monDailyFk) {
		this.monDailyFk = monDailyFk;
	}

	/**
	 */
	public Integer getMonDailyFk() {
		return this.monDailyFk;
	}

	/**
	 */
	public void setTueDailyFk(Integer tueDailyFk) {
		this.tueDailyFk = tueDailyFk;
	}

	/**
	 */
	public Integer getTueDailyFk() {
		return this.tueDailyFk;
	}

	/**
	 */
	public void setWedDailyFk(Integer wedDailyFk) {
		this.wedDailyFk = wedDailyFk;
	}

	/**
	 */
	public Integer getWedDailyFk() {
		return this.wedDailyFk;
	}

	/**
	 */
	public void setThuDailyFk(Integer thuDailyFk) {
		this.thuDailyFk = thuDailyFk;
	}

	/**
	 */
	public Integer getThuDailyFk() {
		return this.thuDailyFk;
	}

	/**
	 */
	public void setFriDailyFk(Integer friDailyFk) {
		this.friDailyFk = friDailyFk;
	}

	/**
	 */
	public Integer getFriDailyFk() {
		return this.friDailyFk;
	}

	/**
	 */
	public void setSatDailyFk(Integer satDailyFk) {
		this.satDailyFk = satDailyFk;
	}

	/**
	 */
	public Integer getSatDailyFk() {
		return this.satDailyFk;
	}

	/**
	 */
	public Templateweekly() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(Templateweekly that) {
		setWeeklyTemplateId(that.getWeeklyTemplateId());
		setTemplateName(that.getTemplateName());
		setDescription(that.getDescription());
		setSunDailyFk(that.getSunDailyFk());
		setMonDailyFk(that.getMonDailyFk());
		setTueDailyFk(that.getTueDailyFk());
		setWedDailyFk(that.getWedDailyFk());
		setThuDailyFk(that.getThuDailyFk());
		setFriDailyFk(that.getFriDailyFk());
		setSatDailyFk(that.getSatDailyFk());
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("weeklyTemplateId=[").append(weeklyTemplateId).append("] ");
		buffer.append("templateName=[").append(templateName).append("] ");
		buffer.append("description=[").append(description).append("] ");
		buffer.append("sunDailyFk=[").append(sunDailyFk).append("] ");
		buffer.append("monDailyFk=[").append(monDailyFk).append("] ");
		buffer.append("tueDailyFk=[").append(tueDailyFk).append("] ");
		buffer.append("wedDailyFk=[").append(wedDailyFk).append("] ");
		buffer.append("thuDailyFk=[").append(thuDailyFk).append("] ");
		buffer.append("friDailyFk=[").append(friDailyFk).append("] ");
		buffer.append("satDailyFk=[").append(satDailyFk).append("] ");

		return buffer.toString();
	}

	/**
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (int) (prime * result + ((weeklyTemplateId == null) ? 0 : weeklyTemplateId.hashCode()));
		return result;
	}

	/**
	 */
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof Templateweekly))
			return false;
		Templateweekly equalCheck = (Templateweekly) obj;
		if ((weeklyTemplateId == null && equalCheck.weeklyTemplateId != null) || (weeklyTemplateId != null && equalCheck.weeklyTemplateId == null))
			return false;
		if (weeklyTemplateId != null && !weeklyTemplateId.equals(equalCheck.weeklyTemplateId))
			return false;
		return true;
	}
}
