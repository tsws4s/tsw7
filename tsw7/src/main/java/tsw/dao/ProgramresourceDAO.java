package tsw.dao;

import java.util.Set;

import org.skyway.spring.util.dao.JpaDao;

import org.springframework.dao.DataAccessException;

import tsw.domain.Programresource;

/**
 * DAO to manage Programresource entities.
 * 
 */
public interface ProgramresourceDAO extends JpaDao<Programresource> {

	/**
	 * JPQL Query - findAllProgramresources
	 *
	 */
	public Set<Programresource> findAllProgramresources() throws DataAccessException;

	/**
	 * JPQL Query - findAllProgramresources
	 *
	 */
	public Set<Programresource> findAllProgramresources(int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findProgramresourceByResourceFk
	 *
	 */
	public Set<Programresource> findProgramresourceByResourceFk(Integer resourceFk) throws DataAccessException;

	/**
	 * JPQL Query - findProgramresourceByResourceFk
	 *
	 */
	public Set<Programresource> findProgramresourceByResourceFk(Integer resourceFk, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findProgramresourceByProgramResourceId
	 *
	 */
	public Programresource findProgramresourceByProgramResourceId(Integer programResourceId) throws DataAccessException;

	/**
	 * JPQL Query - findProgramresourceByProgramResourceId
	 *
	 */
	public Programresource findProgramresourceByProgramResourceId(Integer programResourceId, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findProgramresourceByResourcePriceFk
	 *
	 */
	public Set<Programresource> findProgramresourceByResourcePriceFk(Integer resourcePriceFk) throws DataAccessException;

	/**
	 * JPQL Query - findProgramresourceByResourcePriceFk
	 *
	 */
	public Set<Programresource> findProgramresourceByResourcePriceFk(Integer resourcePriceFk, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findProgramresourceByPrimaryKey
	 *
	 */
	public Programresource findProgramresourceByPrimaryKey(Integer programResourceId_1) throws DataAccessException;

	/**
	 * JPQL Query - findProgramresourceByPrimaryKey
	 *
	 */
	public Programresource findProgramresourceByPrimaryKey(Integer programResourceId_1, int startResult, int maxRows) throws DataAccessException;

	public Integer getMaxProgramResourceId();
}