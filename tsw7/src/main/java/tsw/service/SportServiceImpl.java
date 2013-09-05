package tsw.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import tsw.dao.ProgramDAO;
import tsw.dao.SportDAO;
import tsw.dao.SportpositionDAO;
import tsw.dao.SportstattypeDAO;

import tsw.domain.Program;
import tsw.domain.Sport;
import tsw.domain.Sportposition;
import tsw.domain.Sportstattype;

/**
 * Spring service that handles CRUD requests for Sport entities
 * 
 */

@Service("SportService")
@Transactional
public class SportServiceImpl implements SportService {

	/**
	 * DAO injected by Spring that manages Program entities
	 * 
	 */
	@Autowired
	private ProgramDAO programDAO;

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
	 * DAO injected by Spring that manages Sportstattype entities
	 * 
	 */
	@Autowired
	private SportstattypeDAO sportstattypeDAO;

	/**
	 * Instantiates a new SportServiceImpl.
	 *
	 */
	public SportServiceImpl() {
	}

	/**
	 * Return all Sport entity
	 * 
	 */
	@Transactional
	public List<Sport> findAllSports(Integer startResult, Integer maxRows) {
		return new java.util.ArrayList<Sport>(sportDAO.findAllSports(startResult, maxRows));
	}

	/**
	 * Save an existing Sportstattype entity
	 * 
	 */
	@Transactional
	public Sport saveSportSportstattypes(Integer sportId, Sportstattype related_sportstattypes) {
		Sport sport = sportDAO.findSportByPrimaryKey(sportId, -1, -1);
		Sportstattype existingsportstattypes = sportstattypeDAO.findSportstattypeByPrimaryKey(related_sportstattypes.getSportStatTypeId());

		// copy into the existing record to preserve existing relationships
		if (existingsportstattypes != null) {
			existingsportstattypes.setSportStatTypeId(related_sportstattypes.getSportStatTypeId());
			existingsportstattypes.setSportStatTypeName(related_sportstattypes.getSportStatTypeName());
			related_sportstattypes = existingsportstattypes;
		} else {
			related_sportstattypes = sportstattypeDAO.store(related_sportstattypes);
			sportstattypeDAO.flush();
		}

		related_sportstattypes.setSport(sport);
		sport.getSportstattypes().add(related_sportstattypes);
		related_sportstattypes = sportstattypeDAO.store(related_sportstattypes);
		sportstattypeDAO.flush();

		sport = sportDAO.store(sport);
		sportDAO.flush();

		return sport;
	}

	/**
	 * Delete an existing Sport entity
	 * 
	 */
	@Transactional
	public void deleteSport(Sport sport) {
		sportDAO.remove(sport);
		sportDAO.flush();
	}

	/**
	 * Save an existing Program entity
	 * 
	 */
	@Transactional
	public Sport saveSportPrograms(Integer sportId, Program related_programs) {
		Sport sport = sportDAO.findSportByPrimaryKey(sportId, -1, -1);
		Program existingprograms = programDAO.findProgramByPrimaryKey(related_programs.getProgramId());

		// copy into the existing record to preserve existing relationships
		if (existingprograms != null) {
			existingprograms.setProgramId(related_programs.getProgramId());
			existingprograms.setProgramName(related_programs.getProgramName());
			existingprograms.setCustomer(related_programs.getCustomer());
			existingprograms.setPrice(related_programs.getPrice());
			existingprograms.setStartDate(related_programs.getStartDate());
			existingprograms.setEndDate(related_programs.getEndDate());
			existingprograms.setLevel(related_programs.getLevel());
			existingprograms.setActiveYn(related_programs.getActiveYn());
			existingprograms.setPublishYn(related_programs.getPublishYn());
			existingprograms.setTotalPaid(related_programs.getTotalPaid());
			existingprograms.setTotalParticipants(related_programs.getTotalParticipants());
			existingprograms.setGamesPerTeam(related_programs.getGamesPerTeam());
			existingprograms.setLeagueYn(related_programs.getLeagueYn());
			existingprograms.setResource(related_programs.getResource());
			related_programs = existingprograms;
		} else {
			related_programs = programDAO.store(related_programs);
			programDAO.flush();
		}

		related_programs.setSport(sport);
		sport.getPrograms().add(related_programs);
		related_programs = programDAO.store(related_programs);
		programDAO.flush();

		sport = sportDAO.store(sport);
		sportDAO.flush();

		return sport;
	}

	/**
	 * Delete an existing Sportstattype entity
	 * 
	 */
	@Transactional
	public Sport deleteSportSportstattypes(Integer sport_sportId, Integer related_sportstattypes_sportStatTypeId) {
		Sportstattype related_sportstattypes = sportstattypeDAO.findSportstattypeByPrimaryKey(related_sportstattypes_sportStatTypeId, -1, -1);

		Sport sport = sportDAO.findSportByPrimaryKey(sport_sportId, -1, -1);

		related_sportstattypes.setSport(null);
		sport.getSportstattypes().remove(related_sportstattypes);

		sportstattypeDAO.remove(related_sportstattypes);
		sportstattypeDAO.flush();

		return sport;
	}

	/**
	 * Delete an existing Program entity
	 * 
	 */
	@Transactional
	public Sport deleteSportPrograms(Integer sport_sportId, Integer related_programs_programId) {
		Program related_programs = programDAO.findProgramByPrimaryKey(related_programs_programId, -1, -1);

		Sport sport = sportDAO.findSportByPrimaryKey(sport_sportId, -1, -1);

		related_programs.setSport(null);
		sport.getPrograms().remove(related_programs);

		programDAO.remove(related_programs);
		programDAO.flush();

		return sport;
	}

	/**
	 * Delete an existing Sportposition entity
	 * 
	 */
	@Transactional
	public Sport deleteSportSportpositions(Integer sport_sportId, Integer related_sportpositions_sportPositionId) {
		Sportposition related_sportpositions = sportpositionDAO.findSportpositionByPrimaryKey(related_sportpositions_sportPositionId, -1, -1);

		Sport sport = sportDAO.findSportByPrimaryKey(sport_sportId, -1, -1);

		related_sportpositions.setSport(null);
		sport.getSportpositions().remove(related_sportpositions);

		sportpositionDAO.remove(related_sportpositions);
		sportpositionDAO.flush();

		return sport;
	}

	/**
	 * Load an existing Sport entity
	 * 
	 */
	@Transactional
	public Set<Sport> loadSports() {
		return sportDAO.findAllSports();
	}

	/**
	 * Save an existing Sportposition entity
	 * 
	 */
	@Transactional
	public Sport saveSportSportpositions(Integer sportId, Sportposition related_sportpositions) {
		Sport sport = sportDAO.findSportByPrimaryKey(sportId, -1, -1);
		Sportposition existingsportpositions = sportpositionDAO.findSportpositionByPrimaryKey(related_sportpositions.getSportPositionId());

		// copy into the existing record to preserve existing relationships
		if (existingsportpositions != null) {
			existingsportpositions.setSportPositionId(related_sportpositions.getSportPositionId());
			existingsportpositions.setSportPositionName(related_sportpositions.getSportPositionName());
			existingsportpositions.setNumGamePlayers(related_sportpositions.getNumGamePlayers());
			existingsportpositions.setNumTeamPlayers(related_sportpositions.getNumTeamPlayers());
			related_sportpositions = existingsportpositions;
		} else {
			related_sportpositions = sportpositionDAO.store(related_sportpositions);
			sportpositionDAO.flush();
		}

		related_sportpositions.setSport(sport);
		sport.getSportpositions().add(related_sportpositions);
		related_sportpositions = sportpositionDAO.store(related_sportpositions);
		sportpositionDAO.flush();

		sport = sportDAO.store(sport);
		sportDAO.flush();

		return sport;
	}

	/**
	 * Return a count of all Sport entity
	 * 
	 */
	@Transactional
	public Integer countSports() {
		return ((Long) sportDAO.createQuerySingleResult("select count(o) from Sport o").getSingleResult()).intValue();
	}

	/**
	 * Save an existing Sport entity
	 * 
	 */
	@Transactional
	public void saveSport(Sport sport) {
		Sport existingSport = sportDAO.findSportByPrimaryKey(sport.getSportId());

		if (existingSport != null) {
			if (existingSport != sport) {
				existingSport.setSportId(sport.getSportId());
				existingSport.setSportName(sport.getSportName());
				existingSport.setWikiUrl(sport.getWikiUrl());
				existingSport.setActiveYn(sport.getActiveYn());
				existingSport.setNumGamePlayers(sport.getNumGamePlayers());
				existingSport.setNumTeamRoster(sport.getNumTeamRoster());
				existingSport.setNormalSeason(sport.getNormalSeason());
			}
			sport = sportDAO.store(existingSport);
		} else {
			sport = sportDAO.store(sport);
		}
		sportDAO.flush();
	}

	/**
	 */
	@Transactional
	public Sport findSportByPrimaryKey(Integer sportId) {
		return sportDAO.findSportByPrimaryKey(sportId);
	}
}
