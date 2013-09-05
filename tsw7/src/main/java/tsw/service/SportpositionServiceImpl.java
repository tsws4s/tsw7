package tsw.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import tsw.dao.SportDAO;
import tsw.dao.SportpositionDAO;

import tsw.domain.Sport;
import tsw.domain.Sportposition;

/**
 * Spring service that handles CRUD requests for Sportposition entities
 * 
 */

@Service("SportpositionService")
@Transactional
public class SportpositionServiceImpl implements SportpositionService {

	/**
	 * DAO injected by Spring that manages Sport entities
	 * 
	 */
	@Autowired
	private SportDAO sportDAO;

	/**
	 * DAO injected by Spring that manages Sportposition entities
	 * 
	 */
	@Autowired
	private SportpositionDAO sportpositionDAO;

	/**
	 * Instantiates a new SportpositionServiceImpl.
	 *
	 */
	public SportpositionServiceImpl() {
	}

	/**
	 * Save an existing Sport entity
	 * 
	 */
	@Transactional
	public Sportposition saveSportpositionSport(Integer sportPositionId, Sport related_sport) {
		Sportposition sportposition = sportpositionDAO.findSportpositionByPrimaryKey(sportPositionId, -1, -1);
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

		sportposition.setSport(related_sport);
		related_sport.getSportpositions().add(sportposition);
		sportposition = sportpositionDAO.store(sportposition);
		sportpositionDAO.flush();

		related_sport = sportDAO.store(related_sport);
		sportDAO.flush();

		return sportposition;
	}

	/**
	 * Delete an existing Sport entity
	 * 
	 */
	@Transactional
	public Sportposition deleteSportpositionSport(Integer sportposition_sportPositionId, Integer related_sport_sportId) {
		Sportposition sportposition = sportpositionDAO.findSportpositionByPrimaryKey(sportposition_sportPositionId, -1, -1);
		Sport related_sport = sportDAO.findSportByPrimaryKey(related_sport_sportId, -1, -1);

		sportposition.setSport(null);
		related_sport.getSportpositions().remove(sportposition);
		sportposition = sportpositionDAO.store(sportposition);
		sportpositionDAO.flush();

		related_sport = sportDAO.store(related_sport);
		sportDAO.flush();

		sportDAO.remove(related_sport);
		sportDAO.flush();

		return sportposition;
	}

	/**
	 * Save an existing Sportposition entity
	 * 
	 */
	@Transactional
	public void saveSportposition(Sportposition sportposition) {
		Sportposition existingSportposition = sportpositionDAO.findSportpositionByPrimaryKey(sportposition.getSportPositionId());

		if (existingSportposition != null) {
			if (existingSportposition != sportposition) {
				existingSportposition.setSportPositionId(sportposition.getSportPositionId());
				existingSportposition.setSportPositionName(sportposition.getSportPositionName());
				existingSportposition.setNumGamePlayers(sportposition.getNumGamePlayers());
				existingSportposition.setNumTeamPlayers(sportposition.getNumTeamPlayers());
			}
			sportposition = sportpositionDAO.store(existingSportposition);
		} else {
			sportposition = sportpositionDAO.store(sportposition);
		}
		sportpositionDAO.flush();
	}

	/**
	 */
	@Transactional
	public Sportposition findSportpositionByPrimaryKey(Integer sportPositionId) {
		return sportpositionDAO.findSportpositionByPrimaryKey(sportPositionId);
	}

	/**
	 * Return a count of all Sportposition entity
	 * 
	 */
	@Transactional
	public Integer countSportpositions() {
		return ((Long) sportpositionDAO.createQuerySingleResult("select count(o) from Sportposition o").getSingleResult()).intValue();
	}

	/**
	 * Return all Sportposition entity
	 * 
	 */
	@Transactional
	public List<Sportposition> findAllSportpositions(Integer startResult, Integer maxRows) {
		return new java.util.ArrayList<Sportposition>(sportpositionDAO.findAllSportpositions(startResult, maxRows));
	}
	@Transactional
	public List<Sportposition> findAllSportpositionsForSport(Integer startResult, int maxRows, Integer sportId) {
		return new java.util.ArrayList<Sportposition>(sportpositionDAO.findAllSportpositionsForSport(startResult, maxRows, sportId));
	}

	/**
	 * Load an existing Sportposition entity
	 * 
	 */
	@Transactional
	public Set<Sportposition> loadSportpositions() {
		return sportpositionDAO.findAllSportpositions();
	}

	/**
	 * Delete an existing Sportposition entity
	 * 
	 */
	@Transactional
	public void deleteSportposition(Sportposition sportposition) {
		sportpositionDAO.remove(sportposition);
		sportpositionDAO.flush();
	}
}
