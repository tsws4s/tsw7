package tsw.dao;

import java.util.Set;

import org.skyway.spring.util.dao.JpaDao;

import org.springframework.dao.DataAccessException;

import tsw.domain.Sportstattype;

/**
 * DAO to manage Sportstattype entities.
 * 
 */
public interface SportstattypeDAO extends JpaDao<Sportstattype> {

	/**
	 * JPQL Query - findSportstattypeBySportStatTypeId
	 *
	 */
	public Sportstattype findSportstattypeBySportStatTypeId(Integer sportStatTypeId) throws DataAccessException;

	/**
	 * JPQL Query - findSportstattypeBySportStatTypeId
	 *
	 */
	public Sportstattype findSportstattypeBySportStatTypeId(Integer sportStatTypeId, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findSportstattypeBySportStatTypeName
	 *
	 */
	public Set<Sportstattype> findSportstattypeBySportStatTypeName(String sportStatTypeName) throws DataAccessException;

	/**
	 * JPQL Query - findSportstattypeBySportStatTypeName
	 *
	 */
	public Set<Sportstattype> findSportstattypeBySportStatTypeName(String sportStatTypeName, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findSportstattypeBySportStatTypeNameContaining
	 *
	 */
	public Set<Sportstattype> findSportstattypeBySportStatTypeNameContaining(String sportStatTypeName_1) throws DataAccessException;

	/**
	 * JPQL Query - findSportstattypeBySportStatTypeNameContaining
	 *
	 */
	public Set<Sportstattype> findSportstattypeBySportStatTypeNameContaining(String sportStatTypeName_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findSportstattypeByPrimaryKey
	 *
	 */
	public Sportstattype findSportstattypeByPrimaryKey(Integer sportStatTypeId_1) throws DataAccessException;

	/**
	 * JPQL Query - findSportstattypeByPrimaryKey
	 *
	 */
	public Sportstattype findSportstattypeByPrimaryKey(Integer sportStatTypeId_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAllSportstattypes
	 *
	 */
	public Set<Sportstattype> findAllSportstattypes() throws DataAccessException;

	/**
	 * JPQL Query - findAllSportstattypes
	 *
	 */
	public Set<Sportstattype> findAllSportstattypes(int startResult, int maxRows) throws DataAccessException;

}