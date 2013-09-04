package tsw.service;

import java.util.Calendar;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import tsw.dao.fcEventDAO;

import tsw.domain.Resource;
import tsw.domain.Tswacct;
import tsw.domain.fcEvent;
import tsw.web.UsersController;

/**
 * Spring service that handles CRUD requests for fcEvent entities
 * 
 */

@Service("fcEventService")
@Transactional
public class fcEventServiceImpl implements fcEventService {
	
	int defaultMaxRows = UsersController.getDefaultMaxRows();

	/**
	 * DAO injected by Spring that manages fcEvent entities
	 * 
	 */
	@Autowired
	private fcEventDAO fcEventDAO;

	/**
	 * Instantiates a new fcEventServiceImpl.
	 *
	 */
	public fcEventServiceImpl() {
	}

	/**
	 * Return a count of all fcEvent entity
	 * 
	 */
	@Transactional
	public Integer countfcEvents() {
		return ((Long) fcEventDAO.createQuerySingleResult("select count(o) from fcEvent o").getSingleResult()).intValue();
	}

	/**
	 * Load an existing fcEvent entity
	 * 
	 */
	@Transactional
	public Set<fcEvent> loadfcEvents4tsw(Tswacct tswacct) {
		return fcEventDAO.findAllfcEvents4tsw(tswacct.getTswAcctId());
	}
	@Transactional
	public Set<fcEvent> loadfcEvents4tswResource(Tswacct tswacct,Resource res) {
		return fcEventDAO.findAllfcEvents4tswResource(tswacct.getTswAcctId(),res.getResourceId());
	}
	
	@Transactional
	public Set<fcEvent> loadfcEvents(Integer resource_id, Calendar afterDate, Calendar beforeDate) {
		return (Set<fcEvent>) fcEventDAO.findfcEventByResourceDateAfterBefore(resource_id, afterDate, beforeDate);
	}

	/**
	 * Return all fcEvent entity
	 * 
	 */
	@Transactional
	public List<fcEvent> findAllfcEvents4tsw(Tswacct tswacct, Integer startResult, Integer maxRows) {
		return new java.util.ArrayList<fcEvent>(fcEventDAO.findAllfcEvents4tsw(tswacct.getTswAcctId(), startResult, maxRows));
	}
	@Transactional
	public List<fcEvent> findAllfcEvents4tswResource(Tswacct tswacct, Resource res, Integer startResult, Integer maxRows) {
		return new java.util.ArrayList<fcEvent>(fcEventDAO.findAllfcEvents4tswResource(tswacct.getTswAcctId(), res.getResourceId(), startResult, maxRows));
	}	
	/**
	 */
	@Transactional
	public fcEvent findfcEventByPrimaryKey(Integer id) {
		return fcEventDAO.findfcEventByPrimaryKey(id);
	}

	/**
	 * Delete an existing fcEvent entity
	 * 
	 */
	@Transactional
	public void deletefcEvent(fcEvent fcEvent) {
		fcEventDAO.remove(fcEvent);
		fcEventDAO.flush();
	}

	/**
	 * Save an existing fcEvent entity
	 * 
	 */
	@Transactional
	public void savefcEvent(fcEvent fcEvent) {
		fcEvent existingfcEvent = fcEventDAO.findfcEventByPrimaryKey(fcEvent.getId());

		if (existingfcEvent != null) {
			if (existingfcEvent != fcEvent) {
				existingfcEvent.setId(fcEvent.getId());
				existingfcEvent.setTitle(fcEvent.getTitle());
				existingfcEvent.setAllDay(fcEvent.getAllDay());
				existingfcEvent.setStart(fcEvent.getStartOrig());
				existingfcEvent.setEnd(fcEvent.getEndOrig());
				existingfcEvent.setUrl(fcEvent.getUrl());
				existingfcEvent.setClassName(fcEvent.getClassName());
				existingfcEvent.setEditable(fcEvent.getEditable());
				existingfcEvent.setColor(fcEvent.getColor());
			}
			fcEvent = fcEventDAO.store(existingfcEvent);
		} else {
			fcEvent = fcEventDAO.store(fcEvent);
		}
		fcEventDAO.flush();
	}
}
