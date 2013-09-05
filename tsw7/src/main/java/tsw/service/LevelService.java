package tsw.service;

import java.util.List;
import java.util.Set;

import tsw.domain.Level;
import tsw.domain.Program;
import tsw.domain.Team;
import tsw.domain.Teamplayers;
import tsw.domain.Tswacct;

/**
 * Spring service that handles CRUD requests for Level entities
 * 
 */
public interface LevelService {

	/**
	 * Return a count of all Level entity
	 * 
	 */
	public Integer countLevels();
	
	public Integer getLevelCount4tsw(Tswacct tswacct);

	/**
	 * Save an existing Team entity
	 * 
	 */
	public Level saveLevelTeams(Integer levelId, Team related_teams);

	/**
	 * Return all Level entity
	 * 
	 */
	public List<Level> findAllLevels4tsw(Tswacct tswacct, Integer startResult, Integer maxRows);

	/**
	 * Load an existing Level entity
	 * 
	 */
	public Set<Level> loadLevels4tsw(Tswacct tswacct);
	
	public Set<Level> loadLevels4tsw(Tswacct tswacct, int from);

	/**
	 * Save an existing Tswacct entity
	 * 
	 */
	public Level saveLevelTswacct(Integer levelId_1, Tswacct related_tswacct);

	/**
	 * Save an existing Program entity
	 * 
	 */
	public Level saveLevelPrograms(Integer levelId_2, Program related_programs);

	/**
	 * Delete an existing Teamplayers entity
	 * 
	 */
	public Level deleteLevelTeamplayerses(Integer level_levelId, Integer related_teamplayerses_teamPlayersId);

	/**
	 */
	public Level findLevelByPrimaryKey(Integer levelId_3);

	/**
	 * Save an existing Level entity
	 * 
	 */
	public void saveLevel(Tswacct tswacct, Level level);

	/**
	 * Delete an existing Team entity
	 * 
	 */
	public Level deleteLevelTeams(Integer level_levelId_1, Integer related_teams_teamId);

	/**
	 * Delete an existing Level entity
	 * 
	 */
	public void deleteLevel(Level level_1);

	/**
	 * Delete an existing Program entity
	 * 
	 */
	public Level deleteLevelPrograms(Integer level_levelId_2, Integer related_programs_programId);

	/**
	 * Save an existing Teamplayers entity
	 * 
	 */
	public Level saveLevelTeamplayerses(Integer levelId_4, Teamplayers related_teamplayerses);

	/**
	 * Delete an existing Tswacct entity
	 * 
	 */
	public Level deleteLevelTswacct(Integer level_levelId_3, Integer related_tswacct_tswAcctId);
}