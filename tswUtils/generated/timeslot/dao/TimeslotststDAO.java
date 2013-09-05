package timeslot.dao;

import java.util.Calendar;
import java.util.Set;

import org.skyway.spring.util.dao.JpaDao;

import org.springframework.dao.DataAccessException;

import timeslot.domain.Timeslotstst;

/**
 * DAO to manage Timeslotstst entities.
 * 
 */
public interface TimeslotststDAO extends JpaDao<Timeslotstst> {

	/**
	 * JPQL Query - findTimeslotststByTimeslotId
	 *
	 */
	public Timeslotstst findTimeslotststByTimeslotId(Integer timeslotId) throws DataAccessException;

	/**
	 * JPQL Query - findTimeslotststByTimeslotId
	 *
	 */
	public Timeslotstst findTimeslotststByTimeslotId(Integer timeslotId, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTimeslotststByStart
	 *
	 */
	public Set<Timeslotstst> findTimeslotststByStart(java.util.Calendar start) throws DataAccessException;

	/**
	 * JPQL Query - findTimeslotststByStart
	 *
	 */
	public Set<Timeslotstst> findTimeslotststByStart(Calendar start, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTimeslotststByT3sFk
	 *
	 */
	public Set<Timeslotstst> findTimeslotststByT3sFk(Integer t3sFk) throws DataAccessException;

	/**
	 * JPQL Query - findTimeslotststByT3sFk
	 *
	 */
	public Set<Timeslotstst> findTimeslotststByT3sFk(Integer t3sFk, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTimeslotststByPriceLevelContaining
	 *
	 */
	public Set<Timeslotstst> findTimeslotststByPriceLevelContaining(String priceLevel) throws DataAccessException;

	/**
	 * JPQL Query - findTimeslotststByPriceLevelContaining
	 *
	 */
	public Set<Timeslotstst> findTimeslotststByPriceLevelContaining(String priceLevel, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTimeslotststByModifiedLast
	 *
	 */
	public Set<Timeslotstst> findTimeslotststByModifiedLast(java.util.Calendar modifiedLast) throws DataAccessException;

	/**
	 * JPQL Query - findTimeslotststByModifiedLast
	 *
	 */
	public Set<Timeslotstst> findTimeslotststByModifiedLast(Calendar modifiedLast, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTimeslotststByTimeslot
	 *
	 */
	public Set<Timeslotstst> findTimeslotststByTimeslot(Integer timeslot) throws DataAccessException;

	/**
	 * JPQL Query - findTimeslotststByTimeslot
	 *
	 */
	public Set<Timeslotstst> findTimeslotststByTimeslot(Integer timeslot, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTimeslotststByConcessionWkrCustFk
	 *
	 */
	public Set<Timeslotstst> findTimeslotststByConcessionWkrCustFk(Integer concessionWkrCustFk) throws DataAccessException;

	/**
	 * JPQL Query - findTimeslotststByConcessionWkrCustFk
	 *
	 */
	public Set<Timeslotstst> findTimeslotststByConcessionWkrCustFk(Integer concessionWkrCustFk, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTimeslotststByOfficeWkrCustFk
	 *
	 */
	public Set<Timeslotstst> findTimeslotststByOfficeWkrCustFk(Integer officeWkrCustFk) throws DataAccessException;

	/**
	 * JPQL Query - findTimeslotststByOfficeWkrCustFk
	 *
	 */
	public Set<Timeslotstst> findTimeslotststByOfficeWkrCustFk(Integer officeWkrCustFk, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTimeslotststByDateAfter
	 *
	 */
	public Set<Timeslotstst> findTimeslotststByDateAfter(java.util.Calendar date) throws DataAccessException;

	/**
	 * JPQL Query - findTimeslotststByDateAfter
	 *
	 */
	public Set<Timeslotstst> findTimeslotststByDateAfter(Calendar date, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTimeslotststByActiveYn
	 *
	 */
	public Set<Timeslotstst> findTimeslotststByActiveYn(Integer activeYn) throws DataAccessException;

	/**
	 * JPQL Query - findTimeslotststByActiveYn
	 *
	 */
	public Set<Timeslotstst> findTimeslotststByActiveYn(Integer activeYn, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTimeslotststByCustFk
	 *
	 */
	public Set<Timeslotstst> findTimeslotststByCustFk(Integer custFk) throws DataAccessException;

	/**
	 * JPQL Query - findTimeslotststByCustFk
	 *
	 */
	public Set<Timeslotstst> findTimeslotststByCustFk(Integer custFk, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTimeslotststByEnd
	 *
	 */
	public Set<Timeslotstst> findTimeslotststByEnd(java.util.Calendar end) throws DataAccessException;

	/**
	 * JPQL Query - findTimeslotststByEnd
	 *
	 */
	public Set<Timeslotstst> findTimeslotststByEnd(Calendar end, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTimeslotststByCustDisplay
	 *
	 */
	public Set<Timeslotstst> findTimeslotststByCustDisplay(String custDisplay) throws DataAccessException;

	/**
	 * JPQL Query - findTimeslotststByCustDisplay
	 *
	 */
	public Set<Timeslotstst> findTimeslotststByCustDisplay(String custDisplay, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAllTimeslotststs
	 *
	 */
	public Set<Timeslotstst> findAllTimeslotststs() throws DataAccessException;

	/**
	 * JPQL Query - findAllTimeslotststs
	 *
	 */
	public Set<Timeslotstst> findAllTimeslotststs(int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTimeslotststByBelongsToResId
	 *
	 */
	public Set<Timeslotstst> findTimeslotststByBelongsToResId(Integer belongsToResId) throws DataAccessException;

	/**
	 * JPQL Query - findTimeslotststByBelongsToResId
	 *
	 */
	public Set<Timeslotstst> findTimeslotststByBelongsToResId(Integer belongsToResId, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTimeslotststByProgramFk
	 *
	 */
	public Set<Timeslotstst> findTimeslotststByProgramFk(Integer programFk) throws DataAccessException;

	/**
	 * JPQL Query - findTimeslotststByProgramFk
	 *
	 */
	public Set<Timeslotstst> findTimeslotststByProgramFk(Integer programFk, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTimeslotststByPrimaryKey
	 *
	 */
	public Timeslotstst findTimeslotststByPrimaryKey(Integer timeslotId_1) throws DataAccessException;

	/**
	 * JPQL Query - findTimeslotststByPrimaryKey
	 *
	 */
	public Timeslotstst findTimeslotststByPrimaryKey(Integer timeslotId_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTimeslotststByCustDisplayContaining
	 *
	 */
	public Set<Timeslotstst> findTimeslotststByCustDisplayContaining(String custDisplay_1) throws DataAccessException;

	/**
	 * JPQL Query - findTimeslotststByCustDisplayContaining
	 *
	 */
	public Set<Timeslotstst> findTimeslotststByCustDisplayContaining(String custDisplay_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTimeslotststByPriceLevel
	 *
	 */
	public Set<Timeslotstst> findTimeslotststByPriceLevel(String priceLevel_1) throws DataAccessException;

	/**
	 * JPQL Query - findTimeslotststByPriceLevel
	 *
	 */
	public Set<Timeslotstst> findTimeslotststByPriceLevel(String priceLevel_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTimeslotststByDateBefore
	 *
	 */
	public Set<Timeslotstst> findTimeslotststByDateBefore(java.util.Calendar date_1) throws DataAccessException;

	/**
	 * JPQL Query - findTimeslotststByDateBefore
	 *
	 */
	public Set<Timeslotstst> findTimeslotststByDateBefore(Calendar date_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTimeslotststByGameFk
	 *
	 */
	public Set<Timeslotstst> findTimeslotststByGameFk(Integer gameFk) throws DataAccessException;

	/**
	 * JPQL Query - findTimeslotststByGameFk
	 *
	 */
	public Set<Timeslotstst> findTimeslotststByGameFk(Integer gameFk, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTimeslotststByModifiedByUserFk
	 *
	 */
	public Set<Timeslotstst> findTimeslotststByModifiedByUserFk(Integer modifiedByUserFk) throws DataAccessException;

	/**
	 * JPQL Query - findTimeslotststByModifiedByUserFk
	 *
	 */
	public Set<Timeslotstst> findTimeslotststByModifiedByUserFk(Integer modifiedByUserFk, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTimeslotststByZamOperatorCustFk
	 *
	 */
	public Set<Timeslotstst> findTimeslotststByZamOperatorCustFk(Integer zamOperatorCustFk) throws DataAccessException;

	/**
	 * JPQL Query - findTimeslotststByZamOperatorCustFk
	 *
	 */
	public Set<Timeslotstst> findTimeslotststByZamOperatorCustFk(Integer zamOperatorCustFk, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTimeslotststByDate
	 *
	 */
	public Set<Timeslotstst> findTimeslotststByDate(java.util.Calendar date_2) throws DataAccessException;

	/**
	 * JPQL Query - findTimeslotststByDate
	 *
	 */
	public Set<Timeslotstst> findTimeslotststByDate(Calendar date_2, int startResult, int maxRows) throws DataAccessException;

}