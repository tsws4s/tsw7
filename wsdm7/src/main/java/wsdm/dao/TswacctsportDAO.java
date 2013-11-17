package wsdm.dao;

import java.util.Set;

import org.skyway.spring.util.dao.JpaDao;

import org.springframework.dao.DataAccessException;

import wsdm.domain.Tswacctsport;

/**
 * DAO to manage Tswacctsport entities.
 * 
 */
public interface TswacctsportDAO extends JpaDao<Tswacctsport> {

	/**
	 * JPQL Query - findAllTswacctsports
	 *
	 */
	public Set<Tswacctsport> findAllTswacctsports() throws DataAccessException;

	/**
	 * JPQL Query - findAllTswacctsports
	 *
	 */
	public Set<Tswacctsport> findAllTswacctsports(int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTswacctsportByNumPrograms
	 *
	 */
	public Set<Tswacctsport> findTswacctsportByNumPrograms(Integer numPrograms) throws DataAccessException;

	/**
	 * JPQL Query - findTswacctsportByNumPrograms
	 *
	 */
	public Set<Tswacctsport> findTswacctsportByNumPrograms(Integer numPrograms, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTswacctsportByTswAcctSportId
	 *
	 */
	public Tswacctsport findTswacctsportByTswAcctSportId(Integer tswAcctSportId) throws DataAccessException;

	/**
	 * JPQL Query - findTswacctsportByTswAcctSportId
	 *
	 */
	public Tswacctsport findTswacctsportByTswAcctSportId(Integer tswAcctSportId, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTswacctsportBySportFk
	 *
	 */
	public Set<Tswacctsport> findTswacctsportBySportFk(Integer sportFk) throws DataAccessException;

	/**
	 * JPQL Query - findTswacctsportBySportFk
	 *
	 */
	public Set<Tswacctsport> findTswacctsportBySportFk(Integer sportFk, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTswacctsportByPrimaryKey
	 *
	 */
	public Tswacctsport findTswacctsportByPrimaryKey(Integer tswAcctSportId_1) throws DataAccessException;

	/**
	 * JPQL Query - findTswacctsportByPrimaryKey
	 *
	 */
	public Tswacctsport findTswacctsportByPrimaryKey(Integer tswAcctSportId_1, int startResult, int maxRows) throws DataAccessException;

}