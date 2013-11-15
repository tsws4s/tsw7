package tsw.dao;

import java.util.Set;

import org.skyway.spring.util.dao.JpaDao;

import org.springframework.dao.DataAccessException;

import tsw.domain.Resource;
import tsw.domain.Tswacct;

/**
 * DAO to manage Resource entities.
 * 
 */
public interface ResourceDAO extends JpaDao<Resource> {

	/**
	 * JPQL Query - findResourceByResourceType
	 *
	 */
	public Set<Resource> findResourceByResourceType(String resourceType) throws DataAccessException;

	/**
	 * JPQL Query - findResourceByResourceType
	 *
	 */
	public Set<Resource> findResourceByResourceType(String resourceType, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findResourceByPrimaryKey
	 *
	 */
	public Resource findResourceByPrimaryKey(Integer resourceId) throws DataAccessException;

	/**
	 * JPQL Query - findResourceByPrimaryKey
	 *
	 */
	public Resource findResourceByPrimaryKey(Integer resourceId, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findResourceByResourceTypeContaining
	 *
	 */
	public Set<Resource> findResourceByResourceTypeContaining(String resourceType_1) throws DataAccessException;

	/**
	 * JPQL Query - findResourceByResourceTypeContaining
	 *
	 */
	public Set<Resource> findResourceByResourceTypeContaining(String resourceType_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findResourceByResourceNameContaining
	 *
	 */
	public Set<Resource> findResourceByResourceNameContaining(String resourceName) throws DataAccessException;

	/**
	 * JPQL Query - findResourceByResourceNameContaining
	 *
	 */
	public Set<Resource> findResourceByResourceNameContaining(String resourceName, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findResourceByNotes
	 *
	 */
	public Set<Resource> findResourceByNotes(String notes) throws DataAccessException;

	/**
	 * JPQL Query - findResourceByNotes
	 *
	 */
	public Set<Resource> findResourceByNotes(String notes, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findResourceByResourceId
	 *
	 */
	public Resource findResourceByResourceId(Integer resourceId_1) throws DataAccessException;

	/**
	 * JPQL Query - findResourceByResourceId
	 *
	 */
	public Resource findResourceByResourceId(Integer resourceId_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAllResources
	 *
	 */
	public Set<Resource> findAllResources4tsw(Integer tswId) throws DataAccessException;

	/**
	 * JPQL Query - findAllResources
	 *
	 */
	public Set<Resource> findAllResources4tsw(Integer tswId, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findResourceByNotesContaining
	 *
	 */
	public Set<Resource> findResourceByNotesContaining(String notes_1) throws DataAccessException;

	/**
	 * JPQL Query - findResourceByNotesContaining
	 *
	 */
	public Set<Resource> findResourceByNotesContaining(String notes_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findResourceByResourceName
	 *
	 */
	public Resource findResourceByResourceName(Tswacct tswacct, String resourceName_1) throws DataAccessException;

	/**
	 * JPQL Query - findResourceByResourceName
	 *
	 */
	public Resource findResourceByResourceName(Tswacct tswacct, String resourceName_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findResourceByActiveYn
	 *
	 */
	public Set<Resource> findResourceByActiveYn(Integer activeYn) throws DataAccessException;

	/**
	 * JPQL Query - findResourceByActiveYn
	 *
	 */
	public Set<Resource> findResourceByActiveYn(Integer activeYn, int startResult, int maxRows) throws DataAccessException;

	Integer getMaxResourceID();

}