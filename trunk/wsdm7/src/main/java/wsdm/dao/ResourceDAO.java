package wsdm.dao;

import java.util.Set;

import org.skyway.spring.util.dao.JpaDao;

import org.springframework.dao.DataAccessException;

import wsdm.domain.Resource;

/**
 * DAO to manage Resource entities.
 * 
 */
public interface ResourceDAO extends JpaDao<Resource> {

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
	 * JPQL Query - findAllResources
	 *
	 */
	public Set<Resource> findAllResources() throws DataAccessException;

	/**
	 * JPQL Query - findAllResources
	 *
	 */
	public Set<Resource> findAllResources(int startResult, int maxRows) throws DataAccessException;

}