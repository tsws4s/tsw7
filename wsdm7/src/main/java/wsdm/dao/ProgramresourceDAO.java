package wsdm.dao;

import java.util.Set;

import org.skyway.spring.util.dao.JpaDao;

import org.springframework.dao.DataAccessException;

import wsdm.domain.Programresource;

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
	 * JPQL Query - findProgramresourceByPrimaryKey
	 *
	 */
	public Programresource findProgramresourceByPrimaryKey(Integer programResourceId) throws DataAccessException;

	/**
	 * JPQL Query - findProgramresourceByPrimaryKey
	 *
	 */
	public Programresource findProgramresourceByPrimaryKey(Integer programResourceId, int startResult, int maxRows) throws DataAccessException;

}