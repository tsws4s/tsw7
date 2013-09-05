package tsw.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import tsw.dao.SportDAO;
import tsw.dao.SportstattypeDAO;

import tsw.domain.Sport;
import tsw.domain.Sportstattype;

/**
 * Spring service that handles CRUD requests for Sportstattype entities
 * 
 */

@Service("SportstattypeService")
@Transactional
public class SportstattypeServiceImpl implements SportstattypeService {

	/**
	 * DAO injected by Spring that manages Sport entities
	 * 
	 */
	@Autowired
	private SportDAO sportDAO;

	/**
	 * DAO injected by Spring that manages Sportstattype entities
	 * 
	 */
	@Autowired
	private SportstattypeDAO sportstattypeDAO;

	/**
	 * Instantiates a new SportstattypeServiceImpl.
	 *
	 */
	public SportstattypeServiceImpl() {
	}

	/**
	 * Load an existing Sportstattype entity
	 * 
	 */
	@Transactional
	public Set<Sportstattype> loadSportstattypes() {
		return sportstattypeDAO.findAllSportstattypes();
	}

	/**
	 * Return all Sportstattype entity
	 * 
	 */
	@Transactional
	public List<Sportstattype> findAllSportstattypes(Integer startResult, Integer maxRows) {
		return new java.util.ArrayList<Sportstattype>(sportstattypeDAO.findAllSportstattypes(startResult, maxRows));
	}

	/**
	 * Return a count of all Sportstattype entity
	 * 
	 */
	@Transactional
	public Integer countSportstattypes() {
		return ((Long) sportstattypeDAO.createQuerySingleResult("select count(o) from Sportstattype o").getSingleResult()).intValue();
	}

	/**
	 * Save an existing Sportstattype entity
	 * 
	 */
	@Transactional
	public void saveSportstattype(Sportstattype sportstattype) {
		Sportstattype existingSportstattype = sportstattypeDAO.findSportstattypeByPrimaryKey(sportstattype.getSportStatTypeId());

		if (existingSportstattype != null) {
			if (existingSportstattype != sportstattype) {
				existingSportstattype.setSportStatTypeId(sportstattype.getSportStatTypeId());
				existingSportstattype.setSportStatTypeName(sportstattype.getSportStatTypeName());
			}
			sportstattype = sportstattypeDAO.store(existingSportstattype);
		} else {
			sportstattype = sportstattypeDAO.store(sportstattype);
		}
		sportstattypeDAO.flush();
	}

	/**
	 * Save an existing Sport entity
	 * 
	 */
	@Transactional
	public Sportstattype saveSportstattypeSport(Integer sportStatTypeId, Sport related_sport) {
		Sportstattype sportstattype = sportstattypeDAO.findSportstattypeByPrimaryKey(sportStatTypeId, -1, -1);
		Sport existingsport = sportDAO.findSportByPrimaryKey(related_sport.getSportId());

		// copy into the existing record to preserve existing relationships
		if (existingsport != null) {
			existingsport.setSportId(related_sport.getSportId());
			existingsport.setSportName(related_sport.getSportName());
			existingsport.setWikiUrl(related_sport.getWikiUrl());
			existingsport.setActiveYn(related_sport.getActiveYn());
			existingsport.setNumGamePlayers(related_sport.getNumGamePlayers());
			existingsport.setNumTeamRoster(related_sport.getNumTeamRoster());
			existingsport.setNormalSeason(related_sport.getNormalSeason());
			related_sport = existingsport;
		} else {
			related_sport = sportDAO.store(related_sport);
			sportDAO.flush();
		}

		sportstattype.setSport(related_sport);
		related_sport.getSportstattypes().add(sportstattype);
		sportstattype = sportstattypeDAO.store(sportstattype);
		sportstattypeDAO.flush();

		related_sport = sportDAO.store(related_sport);
		sportDAO.flush();

		return sportstattype;
	}

	/**
	 * Delete an existing Sport entity
	 * 
	 */
	@Transactional
	public Sportstattype deleteSportstattypeSport(Integer sportstattype_sportStatTypeId, Integer related_sport_sportId) {
		Sportstattype sportstattype = sportstattypeDAO.findSportstattypeByPrimaryKey(sportstattype_sportStatTypeId, -1, -1);
		Sport related_sport = sportDAO.findSportByPrimaryKey(related_sport_sportId, -1, -1);

		sportstattype.setSport(null);
		related_sport.getSportstattypes().remove(sportstattype);
		sportstattype = sportstattypeDAO.store(sportstattype);
		sportstattypeDAO.flush();

		related_sport = sportDAO.store(related_sport);
		sportDAO.flush();

		sportDAO.remove(related_sport);
		sportDAO.flush();

		return sportstattype;
	}

	/**
	 * Delete an existing Sportstattype entity
	 * 
	 */
	@Transactional
	public void deleteSportstattype(Sportstattype sportstattype) {
		sportstattypeDAO.remove(sportstattype);
		sportstattypeDAO.flush();
	}

	/**
	 */
	@Transactional
	public Sportstattype findSportstattypeByPrimaryKey(Integer sportStatTypeId) {
		return sportstattypeDAO.findSportstattypeByPrimaryKey(sportStatTypeId);
	}
}
