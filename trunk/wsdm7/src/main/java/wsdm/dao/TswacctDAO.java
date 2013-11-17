package wsdm.dao;

import java.util.Set;

import org.skyway.spring.util.dao.JpaDao;

import org.springframework.dao.DataAccessException;

import wsdm.domain.Tswacct;

/**
 * DAO to manage Tswacct entities.
 * 
 */
public interface TswacctDAO extends JpaDao<Tswacct> {

	/**
	 * JPQL Query - findTswacctByPrimaryKey
	 *
	 */
	public Tswacct findTswacctByPrimaryKey(Integer tswAcctId) throws DataAccessException;

	/**
	 * JPQL Query - findTswacctByPrimaryKey
	 *
	 */
	public Tswacct findTswacctByPrimaryKey(Integer tswAcctId, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAllTswaccts
	 *
	 */
	public Set<Tswacct> findAllTswaccts() throws DataAccessException;

	/**
	 * JPQL Query - findAllTswaccts
	 *
	 */
	public Set<Tswacct> findAllTswaccts(int startResult, int maxRows) throws DataAccessException;

}