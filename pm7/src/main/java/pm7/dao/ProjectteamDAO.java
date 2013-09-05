package pm7.dao;

import java.util.Set;

import org.skyway.spring.util.dao.JpaDao;

import org.springframework.dao.DataAccessException;

import pm7.domain.Projectteam;

/**
 * DAO to manage Projectteam entities.
 * 
 */
public interface ProjectteamDAO extends JpaDao<Projectteam> {

	/**
	 * JPQL Query - findProjectteamByProjectRole
	 *
	 */
	public Set<Projectteam> findProjectteamByProjectRole(String projectRole) throws DataAccessException;

	/**
	 * JPQL Query - findProjectteamByProjectRole
	 *
	 */
	public Set<Projectteam> findProjectteamByProjectRole(String projectRole, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAllProjectteams
	 *
	 */
	public Set<Projectteam> findAllProjectteams() throws DataAccessException;

	/**
	 * JPQL Query - findAllProjectteams
	 *
	 */
	public Set<Projectteam> findAllProjectteams(int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findProjectteamByPersonProjectActualHrs
	 *
	 */
	public Set<Projectteam> findProjectteamByPersonProjectActualHrs(Integer personProjectActualHrs) throws DataAccessException;

	/**
	 * JPQL Query - findProjectteamByPersonProjectActualHrs
	 *
	 */
	public Set<Projectteam> findProjectteamByPersonProjectActualHrs(Integer personProjectActualHrs, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findProjectteamByPersonProjectEstHrs
	 *
	 */
	public Set<Projectteam> findProjectteamByPersonProjectEstHrs(Integer personProjectEstHrs) throws DataAccessException;

	/**
	 * JPQL Query - findProjectteamByPersonProjectEstHrs
	 *
	 */
	public Set<Projectteam> findProjectteamByPersonProjectEstHrs(Integer personProjectEstHrs, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findProjectteamByProjectTeamId
	 *
	 */
	public Projectteam findProjectteamByProjectTeamId(Integer projectTeamId) throws DataAccessException;

	/**
	 * JPQL Query - findProjectteamByProjectTeamId
	 *
	 */
	public Projectteam findProjectteamByProjectTeamId(Integer projectTeamId, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findProjectteamByProjectRoleContaining
	 *
	 */
	public Set<Projectteam> findProjectteamByProjectRoleContaining(String projectRole_1) throws DataAccessException;

	/**
	 * JPQL Query - findProjectteamByProjectRoleContaining
	 *
	 */
	public Set<Projectteam> findProjectteamByProjectRoleContaining(String projectRole_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findProjectteamByPrimaryKey
	 *
	 */
	public Projectteam findProjectteamByPrimaryKey(Integer projectTeamId_1) throws DataAccessException;

	/**
	 * JPQL Query - findProjectteamByPrimaryKey
	 *
	 */
	public Projectteam findProjectteamByPrimaryKey(Integer projectTeamId_1, int startResult, int maxRows) throws DataAccessException;

	public Integer getMaxProjectteamId();
}