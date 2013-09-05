package timeslot.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import timeslot.dao.TimeslotststDAO;

import timeslot.domain.Timeslotstst;

/**
 * Spring service that handles CRUD requests for Timeslotstst entities
 * 
 */

@Service("TimeslotststService")
@Transactional
public class TimeslotststServiceImpl implements TimeslotststService {

	/**
	 * DAO injected by Spring that manages Timeslotstst entities
	 * 
	 */
	@Autowired
	private TimeslotststDAO timeslotststDAO;

	/**
	 * Instantiates a new TimeslotststServiceImpl.
	 *
	 */
	public TimeslotststServiceImpl() {
	}

	/**
	 * Save an existing Timeslotstst entity
	 * 
	 */
	@Transactional
	public void saveTimeslotstst(Timeslotstst timeslotstst) {
		Timeslotstst existingTimeslotstst = timeslotststDAO.findTimeslotststByPrimaryKey(timeslotstst.getTimeslotId());

		if (existingTimeslotstst != null) {
			if (existingTimeslotstst != timeslotstst) {
				existingTimeslotstst.setTimeslotId(timeslotstst.getTimeslotId());
				existingTimeslotstst.setTimeslot(timeslotstst.getTimeslot());
				existingTimeslotstst.setDate(timeslotstst.getDate());
				existingTimeslotstst.setStart(timeslotstst.getStart());
				existingTimeslotstst.setEnd(timeslotstst.getEnd());
				existingTimeslotstst.setPriceLevel(timeslotstst.getPriceLevel());
				existingTimeslotstst.setCustDisplay(timeslotstst.getCustDisplay());
				existingTimeslotstst.setCustFk(timeslotstst.getCustFk());
				existingTimeslotstst.setGameFk(timeslotstst.getGameFk());
				existingTimeslotstst.setModifiedLast(timeslotstst.getModifiedLast());
				existingTimeslotstst.setModifiedByUserFk(timeslotstst.getModifiedByUserFk());
				existingTimeslotstst.setZamOperatorCustFk(timeslotstst.getZamOperatorCustFk());
				existingTimeslotstst.setActiveYn(timeslotstst.getActiveYn());
				existingTimeslotstst.setConcessionWkrCustFk(timeslotstst.getConcessionWkrCustFk());
				existingTimeslotstst.setOfficeWkrCustFk(timeslotstst.getOfficeWkrCustFk());
				existingTimeslotstst.setT3sFk(timeslotstst.getT3sFk());
				existingTimeslotstst.setBelongsToResId(timeslotstst.getBelongsToResId());
				existingTimeslotstst.setProgramFk(timeslotstst.getProgramFk());
			}
			timeslotstst = timeslotststDAO.store(existingTimeslotstst);
		} else {
			timeslotstst = timeslotststDAO.store(timeslotstst);
		}
		timeslotststDAO.flush();
	}

	/**
	 * Delete an existing Timeslotstst entity
	 * 
	 */
	@Transactional
	public void deleteTimeslotstst(Timeslotstst timeslotstst) {
		timeslotststDAO.remove(timeslotstst);
		timeslotststDAO.flush();
	}

	/**
	 * Return all Timeslotstst entity
	 * 
	 */
	@Transactional
	public List<Timeslotstst> findAllTimeslotststs(Integer startResult, Integer maxRows) {
		return new java.util.ArrayList<Timeslotstst>(timeslotststDAO.findAllTimeslotststs(startResult, maxRows));
	}

	/**
	 */
	@Transactional
	public Timeslotstst findTimeslotststByPrimaryKey(Integer timeslotId) {
		return timeslotststDAO.findTimeslotststByPrimaryKey(timeslotId);
	}

	/**
	 * Return a count of all Timeslotstst entity
	 * 
	 */
	@Transactional
	public Integer countTimeslotststs() {
		return ((Long) timeslotststDAO.createQuerySingleResult("select count(o) from Timeslotstst o").getSingleResult()).intValue();
	}

	/**
	 * Load an existing Timeslotstst entity
	 * 
	 */
	@Transactional
	public Set<Timeslotstst> loadTimeslotststs() {
		return timeslotststDAO.findAllTimeslotststs();
	}
}
