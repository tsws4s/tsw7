package wsdm.domain;

import java.io.Serializable;

import java.lang.StringBuilder;

import java.math.BigDecimal;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import javax.xml.bind.annotation.*;

import javax.persistence.*;

/**
 */

@Entity
@NamedQueries({
		@NamedQuery(name = "findAllParticipants", query = "select myParticipant from Participant myParticipant"),
		@NamedQuery(name = "findParticipantByPrimaryKey", query = "select myParticipant from Participant myParticipant where myParticipant.participantId = ?1") })
@Table(catalog = "C324877_tsws4s", name = "Participant")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "wsdm4/wsdm/domain", name = "Participant")
public class Participant implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 */

	@Column(name = "participantID", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	@XmlElement
	Integer participantId;
	/**
	 */

	@Column(name = "amtPaid", scale = 2, precision = 32)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	BigDecimal amtPaid;
	/**
	 */

	@Column(name = "notes", length = 250)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String notes;
	/**
	 */

	@Column(name = "group1", length = 20)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String group1;
	/**
	 */

	@Column(name = "signedWaiverYN")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer signedWaiverYn;
	/**
	 */
	
	@Column(name = "customerFK")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer customerFK;
	/**
	 */
	
	@Column(name = "programFK")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer programFK;
	/**
	 */
	
	@Column(name = "tswAcctFK")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer tswAcctFK;
	/**
	 */
	
	@Column(name = "activeYN")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer activeYn;

	public void setParticipantId(Integer participantId) {
		this.participantId = participantId;
	}

	/**
	 */
	public Integer getParticipantId() {
		return this.participantId;
	}

	/**
	 */
	public void setAmtPaid(BigDecimal amtPaid) {
		this.amtPaid = amtPaid;
	}

	/**
	 */
	public BigDecimal getAmtPaid() {
		return this.amtPaid;
	}

	/**
	 */
	public void setNotes(String notes) {
		this.notes = notes;
	}

	/**
	 */
	public String getNotes() {
		return this.notes;
	}

	/**
	 */
	public void setGroup1(String group1) {
		this.group1 = group1;
	}

	/**
	 */
	public String getGroup1() {
		return this.group1;
	}

	/**
	 */
	public void setSignedWaiverYn(Integer signedWaiverYn) {
		this.signedWaiverYn = signedWaiverYn;
	}

	/**
	 */
	public Integer getSignedWaiverYn() {
		return this.signedWaiverYn;
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

	public Integer getCustomerFK() {
		return customerFK;
	}

	public void setCustomerFK(Integer customerFK) {
		this.customerFK = customerFK;
	}

	public Integer getProgramFK() {
		return programFK;
	}

	public void setProgramFK(Integer programFK) {
		this.programFK = programFK;
	}

	public Integer getTswAcctFK() {
		return tswAcctFK;
	}

	public void setTswAcctFK(Integer tswAcctFK) {
		this.tswAcctFK = tswAcctFK;
	}

	public Participant() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(Participant that) {
		setParticipantId(that.getParticipantId());
		setAmtPaid(that.getAmtPaid());
		setNotes(that.getNotes());
		setGroup1(that.getGroup1());
		setSignedWaiverYn(that.getSignedWaiverYn());
		setActiveYn(that.getActiveYn());
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("participantId=[").append(participantId).append("] ");
		buffer.append("amtPaid=[").append(amtPaid).append("] ");
		buffer.append("notes=[").append(notes).append("] ");
		buffer.append("group1=[").append(group1).append("] ");
		buffer.append("signedWaiverYn=[").append(signedWaiverYn).append("] ");
		buffer.append("activeYn=[").append(activeYn).append("] ");

		return buffer.toString();
	}

	/**
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (int) (prime * result + ((participantId == null) ? 0 : participantId.hashCode()));
		return result;
	}

	/**
	 */
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof Participant))
			return false;
		Participant equalCheck = (Participant) obj;
		if ((participantId == null && equalCheck.participantId != null) || (participantId != null && equalCheck.participantId == null))
			return false;
		if (participantId != null && !participantId.equals(equalCheck.participantId))
			return false;
		return true;
	}
}
