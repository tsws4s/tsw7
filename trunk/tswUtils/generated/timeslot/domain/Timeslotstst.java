package timeslot.domain;

import java.io.Serializable;

import java.lang.StringBuilder;

import java.util.Calendar;

import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import org.joda.time.DateTime;
import org.skyway.spring.util.databinding.TypeConversionUtils;

import javax.xml.bind.annotation.*;

import javax.persistence.*;

/**
 */

@Entity
@NamedQueries({
		@NamedQuery(name = "findAllTimeslotststs", query = "select myTimeslotstst from Timeslotstst myTimeslotstst"),
		@NamedQuery(name = "findTimeslotststByActiveYn", query = "select myTimeslotstst from Timeslotstst myTimeslotstst where myTimeslotstst.activeYn = ?1"),
		@NamedQuery(name = "findTimeslotststByBelongsToResId", query = "select myTimeslotstst from Timeslotstst myTimeslotstst where myTimeslotstst.belongsToResId = ?1"),
		@NamedQuery(name = "findTimeslotststByConcessionWkrCustFk", query = "select myTimeslotstst from Timeslotstst myTimeslotstst where myTimeslotstst.concessionWkrCustFk = ?1"),
		@NamedQuery(name = "findTimeslotststByCustDisplay", query = "select myTimeslotstst from Timeslotstst myTimeslotstst where myTimeslotstst.custDisplay = ?1"),
		@NamedQuery(name = "findTimeslotststByCustDisplayContaining", query = "select myTimeslotstst from Timeslotstst myTimeslotstst where myTimeslotstst.custDisplay like ?1"),
		@NamedQuery(name = "findTimeslotststByCustFk", query = "select myTimeslotstst from Timeslotstst myTimeslotstst where myTimeslotstst.custFk = ?1"),
		@NamedQuery(name = "findTimeslotststByDate", query = "select myTimeslotstst from Timeslotstst myTimeslotstst where myTimeslotstst.date = ?1"),
		@NamedQuery(name = "findTimeslotststByDateAfter", query = "select myTimeslotstst from Timeslotstst myTimeslotstst where myTimeslotstst.date > ?1"),
		@NamedQuery(name = "findTimeslotststByDateBefore", query = "select myTimeslotstst from Timeslotstst myTimeslotstst where myTimeslotstst.date < ?1"),
		@NamedQuery(name = "findTimeslotststByEnd", query = "select myTimeslotstst from Timeslotstst myTimeslotstst where myTimeslotstst.end = ?1"),
		@NamedQuery(name = "findTimeslotststByGameFk", query = "select myTimeslotstst from Timeslotstst myTimeslotstst where myTimeslotstst.gameFk = ?1"),
		@NamedQuery(name = "findTimeslotststByModifiedByUserFk", query = "select myTimeslotstst from Timeslotstst myTimeslotstst where myTimeslotstst.modifiedByUserFk = ?1"),
		@NamedQuery(name = "findTimeslotststByModifiedLast", query = "select myTimeslotstst from Timeslotstst myTimeslotstst where myTimeslotstst.modifiedLast = ?1"),
		@NamedQuery(name = "findTimeslotststByOfficeWkrCustFk", query = "select myTimeslotstst from Timeslotstst myTimeslotstst where myTimeslotstst.officeWkrCustFk = ?1"),
		@NamedQuery(name = "findTimeslotststByPriceLevel", query = "select myTimeslotstst from Timeslotstst myTimeslotstst where myTimeslotstst.priceLevel = ?1"),
		@NamedQuery(name = "findTimeslotststByPriceLevelContaining", query = "select myTimeslotstst from Timeslotstst myTimeslotstst where myTimeslotstst.priceLevel like ?1"),
		@NamedQuery(name = "findTimeslotststByPrimaryKey", query = "select myTimeslotstst from Timeslotstst myTimeslotstst where myTimeslotstst.timeslotId = ?1"),
		@NamedQuery(name = "findTimeslotststByProgramFk", query = "select myTimeslotstst from Timeslotstst myTimeslotstst where myTimeslotstst.programFk = ?1"),
		@NamedQuery(name = "findTimeslotststByStart", query = "select myTimeslotstst from Timeslotstst myTimeslotstst where myTimeslotstst.start = ?1"),
		@NamedQuery(name = "findTimeslotststByT3sFk", query = "select myTimeslotstst from Timeslotstst myTimeslotstst where myTimeslotstst.t3sFk = ?1"),
		@NamedQuery(name = "findTimeslotststByTimeslot", query = "select myTimeslotstst from Timeslotstst myTimeslotstst where myTimeslotstst.timeslot = ?1"),
		@NamedQuery(name = "findTimeslotststByTimeslotId", query = "select myTimeslotstst from Timeslotstst myTimeslotstst where myTimeslotstst.timeslotId = ?1"),
		@NamedQuery(name = "findTimeslotststByZamOperatorCustFk", query = "select myTimeslotstst from Timeslotstst myTimeslotstst where myTimeslotstst.zamOperatorCustFk = ?1") })
@Table(catalog = "C324877_t3sportsTST", name = "timeslotsTST")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "tswUtils/timeslot/domain", name = "Timeslotstst")
public class Timeslotstst implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 */

	@Column(name = "timeslot_id", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	@XmlElement
	Integer timeslotId;
	/**
	 */

	@Column(name = "timeslot")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer timeslot;
	/**
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "date")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Calendar date;
	/**
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "start")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Calendar start;
	/**
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "end")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Calendar end;
	/**
	 */

	@Column(name = "priceLevel", length = 25)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String priceLevel;
	/**
	 */

	@Column(name = "cust_display", length = 150)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String custDisplay;
	/**
	 */

	@Column(name = "cust_fk")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer custFk;
	/**
	 */

	@Column(name = "game_fk")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer gameFk;
	/**
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "modified_last")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Calendar modifiedLast;
	/**
	 */

	@Column(name = "modified_by_user_fk")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer modifiedByUserFk;
	/**
	 */

	@Column(name = "zam_operator_cust_fk")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer zamOperatorCustFk;
	/**
	 */

	@Column(name = "active_yn")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer activeYn;
	/**
	 */

	@Column(name = "concession_wkr_cust_fk")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer concessionWkrCustFk;
	/**
	 */

	@Column(name = "office_wkr_cust_fk")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer officeWkrCustFk;
	/**
	 */

	@Column(name = "t3s_fk")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer t3sFk;
	/**
	 */

	@Column(name = "belongsTo_res_id")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer belongsToResId;
	/**
	 */

	@Column(name = "program_fk")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer programFk;

	/**
	 */
	public void setTimeslotId(Integer timeslotId) {
		this.timeslotId = timeslotId;
	}

	/**
	 */
	public Integer getTimeslotId() {
		return this.timeslotId;
	}

	/**
	 */
	public void setTimeslot(Integer timeslot) {
		this.timeslot = timeslot;
	}

	/**
	 */
	public Integer getTimeslot() {
		return this.timeslot;
	}

	/**
	 */
	public void setDate(Calendar date) {
		this.date = date;
	}

	/**
	 */
	public Calendar getDate() {
		return this.date;
	}

	/**
	 */
	public void setStart(Calendar start) {
		TypeConversionUtils.clearDateFields(start);
		this.start = start;
	}

	/**
	 */
	public Calendar getStart() {
		return this.start;
	}

	/**
	 */
	public void setEnd(Calendar end) {
		TypeConversionUtils.clearDateFields(end);
		this.end = end;
	}

	/**
	 */
	public Calendar getEnd() {
		return this.end;
	}

	/**
	 */
	public void setPriceLevel(String priceLevel) {
		this.priceLevel = priceLevel;
	}

	/**
	 */
	public String getPriceLevel() {
		return this.priceLevel;
	}

	/**
	 */
	public void setCustDisplay(String custDisplay) {
		this.custDisplay = custDisplay;
	}

	/**
	 */
	public String getCustDisplay() {
		return this.custDisplay;
	}

	/**
	 */
	public void setCustFk(Integer custFk) {
		this.custFk = custFk;
	}

	/**
	 */
	public Integer getCustFk() {
		return this.custFk;
	}

	/**
	 */
	public void setGameFk(Integer gameFk) {
		this.gameFk = gameFk;
	}

	/**
	 */
	public Integer getGameFk() {
		return this.gameFk;
	}

	/**
	 */
	public void setModifiedLast(Calendar modifiedLast) {
		this.modifiedLast = modifiedLast;
	}

	/**
	 */
	public Calendar getModifiedLast() {
		return this.modifiedLast;
	}

	/**
	 */
	public void setModifiedByUserFk(Integer modifiedByUserFk) {
		this.modifiedByUserFk = modifiedByUserFk;
	}

	/**
	 */
	public Integer getModifiedByUserFk() {
		return this.modifiedByUserFk;
	}

	/**
	 */
	public void setZamOperatorCustFk(Integer zamOperatorCustFk) {
		this.zamOperatorCustFk = zamOperatorCustFk;
	}

	/**
	 */
	public Integer getZamOperatorCustFk() {
		return this.zamOperatorCustFk;
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
	public void setConcessionWkrCustFk(Integer concessionWkrCustFk) {
		this.concessionWkrCustFk = concessionWkrCustFk;
	}

	/**
	 */
	public Integer getConcessionWkrCustFk() {
		return this.concessionWkrCustFk;
	}

	/**
	 */
	public void setOfficeWkrCustFk(Integer officeWkrCustFk) {
		this.officeWkrCustFk = officeWkrCustFk;
	}

	/**
	 */
	public Integer getOfficeWkrCustFk() {
		return this.officeWkrCustFk;
	}

	/**
	 */
	public void setT3sFk(Integer t3sFk) {
		this.t3sFk = t3sFk;
	}

	/**
	 */
	public Integer getT3sFk() {
		return this.t3sFk;
	}

	/**
	 */
	public void setBelongsToResId(Integer belongsToResId) {
		this.belongsToResId = belongsToResId;
	}

	/**
	 */
	public Integer getBelongsToResId() {
		return this.belongsToResId;
	}

	/**
	 */
	public void setProgramFk(Integer programFk) {
		this.programFk = programFk;
	}

	/**
	 */
	public Integer getProgramFk() {
		return this.programFk;
	}

	/**
	 */
	public Timeslotstst() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(Timeslotstst that) {
		setTimeslotId(that.getTimeslotId());
		setTimeslot(that.getTimeslot());
		setDate(that.getDate());
		setStart(that.getStart());
		setEnd(that.getEnd());
		setPriceLevel(that.getPriceLevel());
		setCustDisplay(that.getCustDisplay());
		setCustFk(that.getCustFk());
		setGameFk(that.getGameFk());
		setModifiedLast(that.getModifiedLast());
		setModifiedByUserFk(that.getModifiedByUserFk());
		setZamOperatorCustFk(that.getZamOperatorCustFk());
		setActiveYn(that.getActiveYn());
		setConcessionWkrCustFk(that.getConcessionWkrCustFk());
		setOfficeWkrCustFk(that.getOfficeWkrCustFk());
		setT3sFk(that.getT3sFk());
		setBelongsToResId(that.getBelongsToResId());
		setProgramFk(that.getProgramFk());
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("timeslotId=[").append(timeslotId).append("] ");
		buffer.append("timeslot=[").append(timeslot).append("] ");
		buffer.append("date=[").append(DateUtil.formatDate(date, DateUtil.FORMAT_YYYY_MM_DD)).append("] ");
		buffer.append("start=[").append(DateUtil.formatDate(start, DateUtil.FORMAT_HH_MM_SS)).append("] ");
		buffer.append("end=[").append(DateUtil.formatDate(end, DateUtil.FORMAT_HH_MM_SS)).append("] ");
		buffer.append("priceLevel=[").append(priceLevel).append("] ");
		buffer.append("custDisplay=[").append(custDisplay).append("] ");
		buffer.append("custFk=[").append(custFk).append("] ");
		buffer.append("gameFk=[").append(gameFk).append("] ");
		buffer.append("modifiedLast=[").append(DateUtil.formatDate(modifiedLast, DateUtil.FORMAT_YYYY_MM_DD)).append("] ");
		buffer.append("modifiedByUserFk=[").append(modifiedByUserFk).append("] ");
		buffer.append("zamOperatorCustFk=[").append(zamOperatorCustFk).append("] ");
		buffer.append("activeYn=[").append(activeYn).append("] ");
		buffer.append("concessionWkrCustFk=[").append(concessionWkrCustFk).append("] ");
		buffer.append("officeWkrCustFk=[").append(officeWkrCustFk).append("] ");
		buffer.append("t3sFk=[").append(t3sFk).append("] ");
		buffer.append("belongsToResId=[").append(belongsToResId).append("] ");
		buffer.append("programFk=[").append(programFk).append("] ");

		return buffer.toString();
	}

	/**
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (int) (prime * result + ((timeslotId == null) ? 0 : timeslotId.hashCode()));
		return result;
	}

	/**
	 */
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof Timeslotstst))
			return false;
		Timeslotstst equalCheck = (Timeslotstst) obj;
		if ((timeslotId == null && equalCheck.timeslotId != null) || (timeslotId != null && equalCheck.timeslotId == null))
			return false;
		if (timeslotId != null && !timeslotId.equals(equalCheck.timeslotId))
			return false;
		return true;
	}
	
	
	public String getSQLinsertStmt(DButils db, int nextId){
		String insertStmt = "INSERT INTO "+db.getDb_name()+"."+db.getTbl();
		insertStmt+="(`timeslot_id`,`timeslot`,`date`,`start`,`end`,`priceLevel`,`cust_display`,`cust_fk`,`game_fk`,";
		insertStmt+="`modified_last`,`modified_by_user_fk`,`zam_operator_cust_fk`,`active_yn`,";
		insertStmt+="`concession_wkr_cust_fk`,`office_wkr_cust_fk`,`t3s_fk`,`belongsTo_res_id`,`program_fk`) VALUES ";

		insertStmt+="("+nextId+","+this.timeslot+","+getSQLdate(this.date)+","+getSQLtime(this.start)+","+getSQLtime(this.end);
		insertStmt+=",'"+this.priceLevel+"','',NULL,NULL,"+getSQLdateTime(null)+",7,NULL,1,NULL,NULL,1,1,NULL);";		
		return insertStmt;
	}
	String getSQLdate(Calendar dt){
		if(dt==null){
			DateTime dtDt = DateUtil.parseDateString("2013-02-14");
			dt=dtDt.toGregorianCalendar();
		}
		String strDt = DateUtil.formatDate(dt, DateUtil.FORMAT_YYYY_MM_DD);
		return "'"+strDt+"'";
	}
	String getSQLdateTime(Calendar dt){
		if(dt==null){
			DateTime dtDt = DateUtil.parseDateString("2013-02-14 06:00:00");
			dt=dtDt.toGregorianCalendar();
		}
		String strDt = DateUtil.formatDate(dt, DateUtil.FORMAT_YYYY_MM_DD_HH_MM_SS);
		return "'"+strDt+"'";
	}
	String getSQLtime(Calendar tm){
		if(tm==null){
			DateTime dtDt = DateUtil.parseDateString("06:00:00");
			tm=dtDt.toGregorianCalendar();
		}
		String strTm = DateUtil.formatDate(tm, DateUtil.FORMAT_HH_MM_SS);
		return "'"+strTm+"'";
	}

}
