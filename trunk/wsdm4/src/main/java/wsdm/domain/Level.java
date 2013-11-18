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
		@NamedQuery(name = "findAllLevels", query = "select myLevel from Level myLevel"),
		@NamedQuery(name = "findLevelByLevelId", query = "select myLevel from Level myLevel where myLevel.levelId = ?1"),
		@NamedQuery(name = "findLevelByPrimaryKey", query = "select myLevel from Level myLevel where myLevel.levelId = ?1") })
@Table(catalog = "C324877_tsws4s", name = "Level")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "wsdm4/wsdm/domain", name = "Level")
@XmlRootElement(namespace = "wsdm4/wsdm/domain")
public class Level implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 */

	@Column(name = "levelID", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	@XmlElement
	Integer levelId;
	/**
	 */

	@Column(name = "levelName", length = 75, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String levelName;
	/**
	 */

	@Column(name = "levelCode", length = 15, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String levelCode;
	/**
	 */

	@Column(name = "ageLow")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer ageLow;
	/**
	 */

	@Column(name = "ageHigh")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer ageHigh;
	/**
	 */

	@Column(name = "activeYN")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer activeYn;

	public void setLevelId(Integer levelId) {
		this.levelId = levelId;
	}

	/**
	 */
	public Integer getLevelId() {
		return this.levelId;
	}

	/**
	 */
	public void setLevelName(String levelName) {
		this.levelName = levelName;
	}

	/**
	 */
	public String getLevelName() {
		return this.levelName;
	}

	/**
	 */
	public void setLevelCode(String levelCode) {
		this.levelCode = levelCode;
	}

	/**
	 */
	public String getLevelCode() {
		return this.levelCode;
	}

	/**
	 */
	public void setAgeLow(Integer ageLow) {
		this.ageLow = ageLow;
	}

	/**
	 */
	public Integer getAgeLow() {
		return this.ageLow;
	}

	/**
	 */
	public void setAgeHigh(Integer ageHigh) {
		this.ageHigh = ageHigh;
	}

	/**
	 */
	public Integer getAgeHigh() {
		return this.ageHigh;
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
	public Level() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(Level that) {
		setLevelId(that.getLevelId());
		setLevelName(that.getLevelName());
		setLevelCode(that.getLevelCode());
		setAgeLow(that.getAgeLow());
		setAgeHigh(that.getAgeHigh());
		setActiveYn(that.getActiveYn());
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("levelId=[").append(levelId).append("] ");
		buffer.append("levelName=[").append(levelName).append("] ");
		buffer.append("levelCode=[").append(levelCode).append("] ");
		buffer.append("ageLow=[").append(ageLow).append("] ");
		buffer.append("ageHigh=[").append(ageHigh).append("] ");
		buffer.append("activeYn=[").append(activeYn).append("] ");

		return buffer.toString();
	}

	/**
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (int) (prime * result + ((levelId == null) ? 0 : levelId.hashCode()));
		return result;
	}

	/**
	 */
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof Level))
			return false;
		Level equalCheck = (Level) obj;
		if ((levelId == null && equalCheck.levelId != null) || (levelId != null && equalCheck.levelId == null))
			return false;
		if (levelId != null && !levelId.equals(equalCheck.levelId))
			return false;
		return true;
	}
}
