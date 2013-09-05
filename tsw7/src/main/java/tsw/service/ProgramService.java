package tsw.service;

import java.util.List;
import java.util.Set;

import tsw.domain.Customer;
import tsw.domain.Game;
import tsw.domain.Level;
import tsw.domain.Participant;
import tsw.domain.Program;
import tsw.domain.Programresource;
import tsw.domain.Sport;
import tsw.domain.Team;
import tsw.domain.Teamplayers;
import tsw.domain.Tswacct;
import tsw.domain.Users;

/**
 * Spring service that handles CRUD requests for Program entities
 * 
 */
public interface ProgramService {

	/**
	 * Load an existing Program entity
	 * 
	 */
	public Set<Program> loadPrograms4tsw(Tswacct tswacct);
	public Set<Program> loadPrograms4tsw(Tswacct tswacct, int from);
	public Set<Program> loadAnyPrograms4tsw(Tswacct tswacct, int from);

	/**
	 * Load an existing League entity
	 * 
	 */
	public Set<Program> loadLeagues4tsw(Tswacct tswacct);
	public Set<Program> loadLeagues4tsw(Tswacct tswacct, int from);

	
	public Integer getProgramsCount4tsw(Tswacct tswacct);
	
	public Integer getLeaguesCount4tsw(Tswacct tswacct);
	
	/**
	 * Save an existing Participant entity
	 * 
	 */
	public Program saveProgramParticipants(Tswacct tswacct, Integer programId, Integer selected_id4, Participant related_participants);

	/**
	 * Delete an existing Game entity
	 * 
	 */
	public Program deleteProgramGames(Integer program_programId, Integer related_games_gameId);

	/**
	 * Save an existing Tswacct entity
	 * 
	 */
	public Program saveProgramTswacct(Integer programId_2, Tswacct related_tswacct);

	/**
	 * Delete an existing Level entity
	 * 
	 */
	public Program deleteProgramLevel(Integer program_programId_1, Integer related_level_levelId);

	/**
	 * Save an existing Game entity
	 * 
	 */
	public Game saveProgramGames(Tswacct tswacct, Integer programId_3, Integer homeTeamId, Integer visitorTeamId, Integer refId, Integer resIdKey, Game related_games);

	/**
	 * Save an existing Teamplayers entity
	 * 
	 */
	public Program saveProgramTeamplayerses(Integer programId_4, Teamplayers related_teamplayerses);

	/**
	 * Return a count of all Program entity
	 * 
	 */
	public Integer countPrograms();

	/**
	 * Save an existing Level entity
	 * 
	 */
	public Program saveProgramLevel(Integer programId_6, Level related_level);

	/**
	 * Save an existing Customer entity
	 * 
	 */
	public Program saveProgramCustomer(Integer programId_7, Customer related_customer);

	/**
	 * Delete an existing Participant entity
	 * 
	 */
	public Program deleteProgramParticipants(Integer program_programId_2, Integer related_participants_participantId);

	/**
	 * Delete an existing Customer entity
	 * 
	 */
	public Program deleteProgramCustomer(Integer program_programId_3, Integer related_customer_customerId);

	/**
	 * Delete an existing Teamplayers entity
	 * 
	 */
	public Program deleteProgramTeamplayerses(Integer program_programId_4, Integer related_teamplayerses_teamPlayersId);

	/**
	 */
	public Program findProgramByPrimaryKey(Integer programId_8);
	
	public Program findProgramByProgramName(Tswacct tswacct, String programName);

	/**
	 * Delete an existing Tswacct entity
	 * 
	 */
	public Program deleteProgramTswacct(Integer program_programId_6, Integer related_tswacct_tswAcctId);

	/**
	 * Delete an existing Team entity
	 * 
	 */
	public Program deleteProgramTeams(Integer program_programId_7, Integer related_teams_teamId);

	/**
	 * Delete an existing Program entity
	 * 
	 */
	public void deleteProgram(Program program);

	/**
	 * Save an existing Team entity
	 * @param selected_id5 
	 * @param selected_id4 
	 * @param selected_id1 
	 * 
	 */
	public Program saveProgramTeams(Tswacct tswacct, Integer programId_9, Integer selected_id1, Integer selected_id4, Integer selected_id5, Team related_teams);

	/**
	 * Return all Program entity
	 * 
	 */
	public List<Program> findAllPrograms4tsw(Tswacct tswacct, Integer startResult, Integer maxRows);
	/**
	 * Return all League entity
	 * 
	 */
	public List<Program> findAllLeagues4tsw(Tswacct tswacct, Integer startResult, Integer maxRows);

	/**
	 * Save an existing Program entity
	 * @param selected_id4 
	 * @param selected_id1 
	 * 
	 */
	public void saveProgram(Users user4session, Program program_1, Integer selected_id1, Integer selected_id4, Integer selected_id8, Integer selected_id11, Integer selected_sport_id1);
	
	public Object getProgramTeamsCount(Integer programId);
	public Program updateTeamCounts(Program parent_program);
	public Program updateParticipantCounts(Program parent_program);
	public Team updateTeamStandings(Team team);
	public Program saveProgramSport(Integer programId_2, Sport related_sport);
	public Program deleteProgramProgramresources(Integer program_programId_2, Integer related_programresources_programResourceId);
	public Program deleteProgramSport(Integer program_programId_4, Integer related_sport_sportId);
	public Program saveProgramProgramresources(Integer programId_5, Programresource related_programresources);
}