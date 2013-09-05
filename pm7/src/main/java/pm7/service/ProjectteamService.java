package pm7.service;

import java.util.List;
import java.util.Set;

import pm7.domain.Account;
import pm7.domain.Person;
import pm7.domain.Project;
import pm7.domain.Projectteam;

/**
 * Spring service that handles CRUD requests for Projectteam entities
 * 
 */
public interface ProjectteamService {

	/**
	 * Delete an existing Account entity
	 * 
	 */
	public Projectteam deleteProjectteamAccount(Integer projectteam_projectTeamId, Integer related_account_accountId);

	/**
	 * Delete an existing Person entity
	 * 
	 */
	public Projectteam deleteProjectteamPerson(Integer projectteam_projectTeamId_1, Integer related_person_personId);

	/**
	 * Save an existing Projectteam entity
	 * 
	 */
	public Projectteam saveProjectteam(Projectteam projectteam);

	/**
	 * Return all Projectteam entity
	 * 
	 */
	public List<Projectteam> findAllProjectteams(Integer startResult, Integer maxRows);

	/**
	 * Return a count of all Projectteam entity
	 * 
	 */
	public Integer countProjectteams();

	/**
	 */
	public Projectteam findProjectteamByPrimaryKey(Integer projectTeamId);

	/**
	 * Delete an existing Project entity
	 * 
	 */
	public Projectteam deleteProjectteamProject(Integer projectteam_projectTeamId_2, Integer related_project_projectId);

	/**
	 * Delete an existing Projectteam entity
	 * 
	 */
	public void deleteProjectteam(Projectteam projectteam_1);

	/**
	 * Save an existing Project entity
	 * 
	 */
	public Projectteam saveProjectteamProject(Integer projectTeamId_1, Project related_project);

	/**
	 * Load an existing Projectteam entity
	 * 
	 */
	public Set<Projectteam> loadProjectteams();

	/**
	 * Save an existing Person entity
	 * 
	 */
	public Projectteam saveProjectteamPerson(Integer projectTeamId_2, Person related_person);

	/**
	 * Save an existing Account entity
	 * 
	 */
	public Projectteam saveProjectteamAccount(Integer projectTeamId_3, Account related_account);
}