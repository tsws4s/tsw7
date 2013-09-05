package tsw.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import tsw.dao.LevelDAO;
import tsw.dao.ProgramDAO;
import tsw.dao.TeamDAO;
import tsw.dao.TeamplayersDAO;
import tsw.dao.TswacctDAO;

import tsw.domain.Level;
import tsw.domain.Program;
import tsw.domain.Team;
import tsw.domain.Teamplayers;
import tsw.domain.Tswacct;
import tsw.web.UsersController;

/**
 * Spring service that handles CRUD requests for Level entities
 * 
 */

@Service("LevelService")
@Transactional
public class LevelServiceImpl implements LevelService {
	
	int defaultMaxRows = UsersController.getDefaultMaxRows();

	/**
	 * DAO injected by Spring that manages Level entities
	 * 
	 */
	@Autowired
	private LevelDAO levelDAO;

	/**
	 * DAO injected by Spring that manages Program entities
	 * 
	 */
	@Autowired
	private ProgramDAO programDAO;

	/**
	 * DAO injected by Spring that manages Team entities
	 * 
	 */
	@Autowired
	private TeamDAO teamDAO;

	/**
	 * DAO injected by Spring that manages Teamplayers entities
	 * 
	 */
	@Autowired
	private TeamplayersDAO teamplayersDAO;

	/**
	 * DAO injected by Spring that manages Tswacct entities
	 * 
	 */
	@Autowired
	private TswacctDAO tswacctDAO;

	/**
	 * Instantiates a new LevelServiceImpl.
	 *
	 */
	public LevelServiceImpl() {
	}

	/**
	 * Return a count of all Level entity
	 * 
	 */
	@Transactional
	public Integer countLevels() {
		return ((Long) levelDAO.createQuerySingleResult("select count(o) from Level o").getSingleResult()).intValue();
	}

	/**
	 * Save an existing Team entity
	 * 
	 */
	@Transactional
	public Level saveLevelTeams(Integer levelId, Team related_teams) {
		Level level = levelDAO.findLevelByPrimaryKey(levelId, -1, defaultMaxRows);
		Team existingteams = teamDAO.findTeamByPrimaryKey(related_teams.getTeamId());

		// copy into the existing record to preserve existing relationships
		if (existingteams != null) {
			existingteams.setTeamId(related_teams.getTeamId());
			existingteams.setTeamName(related_teams.getTeamName());
			existingteams.setAmtPaid(related_teams.getAmtPaid());
			existingteams.setWins(related_teams.getWins());
			existingteams.setLosses(related_teams.getLosses());
			existingteams.setTies(related_teams.getTies());
			existingteams.setGroup3(related_teams.getGroup3());
			existingteams.setColor(related_teams.getColor());
			existingteams.setPublishYn(related_teams.getPublishYn());
			existingteams.setActiveYn(related_teams.getActiveYn());
			existingteams.setNotes(related_teams.getNotes());
			related_teams = existingteams;
		} else {
			related_teams = teamDAO.store(related_teams);
			teamDAO.flush();
		}

		related_teams.setLevel(level);
		level.getTeams().add(related_teams);
		related_teams = teamDAO.store(related_teams);
		teamDAO.flush();

		level = levelDAO.store(level);
		levelDAO.flush();

		return level;
	}

	/**
	 * Return all Level entity
	 * 
	 */
	@Transactional
	public List<Level> findAllLevels4tsw(Tswacct tswacct, Integer startResult, Integer maxRows) {
		return new java.util.ArrayList<Level>(levelDAO.findAllLevels4tsw(tswacct.getTswAcctId(), startResult, maxRows));
	}

	/**
	 * Load an existing Level entity
	 * 
	 */
	@Transactional
	public Set<Level> loadLevels4tsw(Tswacct tswacct) {
		return levelDAO.findAllLevels4tsw(tswacct.getTswAcctId());
	}
	public Set<Level> loadLevels4tsw(Tswacct tswacct, int from) {
		return levelDAO.findAllLevels4tsw(tswacct.getTswAcctId(), from, defaultMaxRows);
	}
	
	/**
	 * Save an existing Tswacct entity
	 * 
	 */
	@Transactional
	public Level saveLevelTswacct(Integer levelId, Tswacct related_tswacct) {
		Level level = levelDAO.findLevelByPrimaryKey(levelId, -1, defaultMaxRows);
		Tswacct existingtswacct = tswacctDAO.findTswacctByPrimaryKey(related_tswacct.getTswAcctId());

		// copy into the existing record to preserve existing relationships
		if (existingtswacct != null) {
			existingtswacct.setTswAcctId(related_tswacct.getTswAcctId());
			existingtswacct.setAcctName(related_tswacct.getAcctName());
			existingtswacct.setSubscrType(related_tswacct.getSubscrType());
			existingtswacct.setAmtPaid(related_tswacct.getAmtPaid());
			existingtswacct.setEstablishDate(related_tswacct.getEstablishDate());
			existingtswacct.setExpireDate(related_tswacct.getExpireDate());
			existingtswacct.setActiveYn(related_tswacct.getActiveYn());
			related_tswacct = existingtswacct;
		} else {
			related_tswacct = tswacctDAO.store(related_tswacct);
			tswacctDAO.flush();
		}

		level.setTswacct(related_tswacct);
		related_tswacct.getLevels().add(level);
		level = levelDAO.store(level);
		levelDAO.flush();

		related_tswacct = tswacctDAO.store(related_tswacct);
		tswacctDAO.flush();

		return level;
	}

	/**
	 * Save an existing Program entity
	 * 
	 */
	@Transactional
	public Level saveLevelPrograms(Integer levelId, Program related_programs) {
		Level level = levelDAO.findLevelByPrimaryKey(levelId, -1, defaultMaxRows);
		Program existingprograms = programDAO.findProgramByPrimaryKey(related_programs.getProgramId());

		// copy into the existing record to preserve existing relationships
		if (existingprograms != null) {
			existingprograms.setProgramId(related_programs.getProgramId());
			existingprograms.setProgramName(related_programs.getProgramName());
			existingprograms.setPrice(related_programs.getPrice());
			existingprograms.setStartDate(related_programs.getStartDate());
			existingprograms.setEndDate(related_programs.getEndDate());
			existingprograms.setActiveYn(related_programs.getActiveYn());
			existingprograms.setPublishYn(related_programs.getPublishYn());
			existingprograms.setTotalPaid(related_programs.getTotalPaid());
			existingprograms.setTotalParticipants(related_programs.getTotalParticipants());
			existingprograms.setGamesPerTeam(related_programs.getGamesPerTeam());
			existingprograms.setLeagueYn(related_programs.getLeagueYn());
			related_programs = existingprograms;
		} else {
			related_programs = programDAO.store(related_programs);
			programDAO.flush();
		}

		related_programs.setLevel(level);
		level.getPrograms().add(related_programs);
		related_programs = programDAO.store(related_programs);
		programDAO.flush();

		level = levelDAO.store(level);
		levelDAO.flush();

		return level;
	}

	/**
	 * Delete an existing Teamplayers entity
	 * 
	 */
	@Transactional
	public Level deleteLevelTeamplayerses(Integer level_levelId, Integer related_teamplayerses_teamPlayersId) {
		Teamplayers related_teamplayerses = teamplayersDAO.findTeamplayersByPrimaryKey(related_teamplayerses_teamPlayersId, -1, defaultMaxRows);

		Level level = levelDAO.findLevelByPrimaryKey(level_levelId, -1, defaultMaxRows);

		related_teamplayerses.setLevel(null);
		level.getTeamplayerses().remove(related_teamplayerses);

		teamplayersDAO.remove(related_teamplayerses);
		teamplayersDAO.flush();

		return level;
	}

	/**
	 */
	@Transactional
	public Level findLevelByPrimaryKey(Integer levelId) {
		return levelDAO.findLevelByPrimaryKey(levelId);
	}

	/**
	 * Save an existing Level entity
	 * 
	 */
	@Transactional
	public void saveLevel(Tswacct tswacct, Level level) {
		Level existingLevel = levelDAO.findLevelByPrimaryKey(level.getLevelId());

		if (existingLevel != null) {
			if (existingLevel != level) {
				existingLevel.setLevelId(level.getLevelId());
				existingLevel.setLevelName(level.getLevelName());
				existingLevel.setLevelCode(level.getLevelCode());
				existingLevel.setAgeLow(level.getAgeLow());
				existingLevel.setAgeHigh(level.getAgeHigh());
				existingLevel.setActiveYn(level.getActiveYn());
			}
			level = levelDAO.store(existingLevel);
		} else {
			int levId = levelDAO.getMaxLevelID();
			level.setLevelId(levId+1);
			level.setTswacct(tswacct);
			level = levelDAO.store(level);
		}
		levelDAO.flush();
	}

	/**
	 * Delete an existing Team entity
	 * 
	 */
	@Transactional
	public Level deleteLevelTeams(Integer level_levelId, Integer related_teams_teamId) {
		Team related_teams = teamDAO.findTeamByPrimaryKey(related_teams_teamId, -1, defaultMaxRows);

		Level level = levelDAO.findLevelByPrimaryKey(level_levelId, -1, defaultMaxRows);

		related_teams.setLevel(null);
		level.getTeams().remove(related_teams);

		teamDAO.remove(related_teams);
		teamDAO.flush();

		return level;
	}

	/**
	 * Delete an existing Level entity
	 * 
	 */
	@Transactional
	public void deleteLevel(Level level) {
		levelDAO.remove(level);
		levelDAO.flush();
	}

	/**
	 * Delete an existing Program entity
	 * 
	 */
	@Transactional
	public Level deleteLevelPrograms(Integer level_levelId, Integer related_programs_programId) {
		Program related_programs = programDAO.findProgramByPrimaryKey(related_programs_programId, -1, defaultMaxRows);

		Level level = levelDAO.findLevelByPrimaryKey(level_levelId, -1, defaultMaxRows);

		related_programs.setLevel(null);
		level.getPrograms().remove(related_programs);

		programDAO.remove(related_programs);
		programDAO.flush();

		return level;
	}

	/**
	 * Save an existing Teamplayers entity
	 * 
	 */
	@Transactional
	public Level saveLevelTeamplayerses(Integer levelId, Teamplayers related_teamplayerses) {
		Level level = levelDAO.findLevelByPrimaryKey(levelId, -1, defaultMaxRows);
		Teamplayers existingteamplayerses = teamplayersDAO.findTeamplayersByPrimaryKey(related_teamplayerses.getTeamPlayersId());

		// copy into the existing record to preserve existing relationships
		if (existingteamplayerses != null) {
			existingteamplayerses.setTeamPlayersId(related_teamplayerses.getTeamPlayersId());
			existingteamplayerses.setAmtPaid(related_teamplayerses.getAmtPaid());
			existingteamplayerses.setNotes(related_teamplayerses.getNotes());
			existingteamplayerses.setGroup2(related_teamplayerses.getGroup2());
			existingteamplayerses.setSignedWaiverYn(related_teamplayerses.getSignedWaiverYn());
			existingteamplayerses.setActiveYn(related_teamplayerses.getActiveYn());
			related_teamplayerses = existingteamplayerses;
		} else {
			related_teamplayerses = teamplayersDAO.store(related_teamplayerses);
			teamplayersDAO.flush();
		}

		related_teamplayerses.setLevel(level);
		level.getTeamplayerses().add(related_teamplayerses);
		related_teamplayerses = teamplayersDAO.store(related_teamplayerses);
		teamplayersDAO.flush();

		level = levelDAO.store(level);
		levelDAO.flush();

		return level;
	}

	/**
	 * Delete an existing Tswacct entity
	 * 
	 */
	@Transactional
	public Level deleteLevelTswacct(Integer level_levelId, Integer related_tswacct_tswAcctId) {
		Level level = levelDAO.findLevelByPrimaryKey(level_levelId, -1, defaultMaxRows);
		Tswacct related_tswacct = tswacctDAO.findTswacctByPrimaryKey(related_tswacct_tswAcctId, -1, defaultMaxRows);

		level.setTswacct(null);
		related_tswacct.getLevels().remove(level);
		level = levelDAO.store(level);
		levelDAO.flush();

		related_tswacct = tswacctDAO.store(related_tswacct);
		tswacctDAO.flush();

		tswacctDAO.remove(related_tswacct);
		tswacctDAO.flush();

		return level;
	}

	@Override
	public Integer getLevelCount4tsw(Tswacct tswacct) {
		int tswId = tswacct.getTswAcctId();
		return ((Long) levelDAO.createQuerySingleResult("select count(levelId) from Level o where tswAcctFk = '"+tswId+"'").getSingleResult()).intValue();
	}
}
