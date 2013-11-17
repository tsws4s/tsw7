package wsdm.service;

import java.util.List;
import java.util.Set;

import wsdm.domain.Customer;
import wsdm.domain.Event;
import wsdm.domain.Game;
import wsdm.domain.Participant;
import wsdm.domain.Price;
import wsdm.domain.Program;
import wsdm.domain.Programresource;
import wsdm.domain.Resource;
import wsdm.domain.Sport;
import wsdm.domain.Team;
import wsdm.domain.Teamplayers;
import wsdm.domain.Tswacct;

/**
 * Spring service that handles CRUD requests for Program entities
 * 
 */
public interface ProgramService {

	/**
	 * Save an existing Program entity
	 * 
	 */
	public void saveProgram(Program program);

	/**
	 * Save an existing Customer entity
	 * 
	 */
	public Program saveProgramCustomer(Integer programId, Customer related_customer);

	/**
	 * Save an existing Event entity
	 * 
	 */
	public Program saveProgramEvents(Integer programId_1, Event related_events);

	/**
	 * Save an existing Price entity
	 * 
	 */
	public Program saveProgramPrice(Integer programId_2, Price related_price);

	/**
	 * Save an existing Resource entity
	 * 
	 */
	public Program saveProgramResource(Integer programId_3, Resource related_resource);

	/**
	 * Delete an existing Game entity
	 * 
	 */
	public Program deleteProgramGames(Integer program_programId, Integer related_games_gameId);

	/**
	 * Save an existing Tswacct entity
	 * 
	 */
	public Program saveProgramTswacct(Integer programId_4, Tswacct related_tswacct);

	/**
	 * Return a count of all Program entity
	 * 
	 */
	public Integer countPrograms();

	/**
	 * Save an existing Sport entity
	 * 
	 */
	public Program saveProgramSport(Integer programId_5, Sport related_sport);

	/**
	 * Save an existing Participant entity
	 * 
	 */
	public Program saveProgramParticipants(Integer programId_6, Participant related_participants);

	/**
	 * Delete an existing Resource entity
	 * 
	 */
	public Program deleteProgramResource(Integer program_programId_1, Integer related_resource_resourceId);

	/**
	 * Load an existing Program entity
	 * 
	 */
	public Set<Program> loadPrograms();

	/**
	 * Delete an existing Programresource entity
	 * 
	 */
	public Program deleteProgramProgramresources(Integer program_programId_2, Integer related_programresources_programResourceId);

	/**
	 * Save an existing Game entity
	 * 
	 */
	public Program saveProgramGames(Integer programId_7, Game related_games);

	/**
	 * Delete an existing Tswacct entity
	 * 
	 */
	public Program deleteProgramTswacct(Integer program_programId_3, Integer related_tswacct_tswAcctId);

	/**
	 * Save an existing Team entity
	 * 
	 */
	public Program saveProgramTeams(Integer programId_8, Team related_teams);

	/**
	 * Delete an existing Program entity
	 * 
	 */
	public void deleteProgram(Program program_1);

	/**
	 * Delete an existing Participant entity
	 * 
	 */
	public Program deleteProgramParticipants(Integer program_programId_4, Integer related_participants_participantId);

	/**
	 * Delete an existing Customer entity
	 * 
	 */
	public Program deleteProgramCustomer(Integer program_programId_5, Integer related_customer_customerId);

	/**
	 */
	public Program findProgramByPrimaryKey(Integer programId_9);

	/**
	 * Save an existing Teamplayers entity
	 * 
	 */
	public Program saveProgramTeamplayerses(Integer programId_10, Teamplayers related_teamplayerses);

	/**
	 * Delete an existing Event entity
	 * 
	 */
	public Program deleteProgramEvents(Integer program_programId_6, Integer related_events_eventId);

	/**
	 * Delete an existing Teamplayers entity
	 * 
	 */
	public Program deleteProgramTeamplayerses(Integer program_programId_7, Integer related_teamplayerses_teamPlayersId);

	/**
	 * Return all Program entity
	 * 
	 */
	public List<Program> findAllPrograms(Integer startResult, Integer maxRows);

	/**
	 * Save an existing Programresource entity
	 * 
	 */
	public Program saveProgramProgramresources(Integer programId_11, Programresource related_programresources);

	/**
	 * Delete an existing Price entity
	 * 
	 */
	public Program deleteProgramPrice(Integer program_programId_8, Integer related_price_priceId);

	/**
	 * Delete an existing Team entity
	 * 
	 */
	public Program deleteProgramTeams(Integer program_programId_9, Integer related_teams_teamId);

	/**
	 * Delete an existing Sport entity
	 * 
	 */
	public Program deleteProgramSport(Integer program_programId_10, Integer related_sport_sportId);
}