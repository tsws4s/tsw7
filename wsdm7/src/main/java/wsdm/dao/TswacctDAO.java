package wsdm.dao;

import java.math.BigDecimal;

import java.util.Calendar;
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
	 * JPQL Query - findTswacctByAmtPaid
	 *
	 */
	public Set<Tswacct> findTswacctByAmtPaid(java.math.BigDecimal amtPaid) throws DataAccessException;

	/**
	 * JPQL Query - findTswacctByAmtPaid
	 *
	 */
	public Set<Tswacct> findTswacctByAmtPaid(BigDecimal amtPaid, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTswacctByExpireDateBefore
	 *
	 */
	public Set<Tswacct> findTswacctByExpireDateBefore(java.util.Calendar expireDate) throws DataAccessException;

	/**
	 * JPQL Query - findTswacctByExpireDateBefore
	 *
	 */
	public Set<Tswacct> findTswacctByExpireDateBefore(Calendar expireDate, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTswacctByAcctName
	 *
	 */
	public Set<Tswacct> findTswacctByAcctName(String acctName) throws DataAccessException;

	/**
	 * JPQL Query - findTswacctByAcctName
	 *
	 */
	public Set<Tswacct> findTswacctByAcctName(String acctName, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTswacctByEstablishDateBefore
	 *
	 */
	public Set<Tswacct> findTswacctByEstablishDateBefore(java.util.Calendar establishDate) throws DataAccessException;

	/**
	 * JPQL Query - findTswacctByEstablishDateBefore
	 *
	 */
	public Set<Tswacct> findTswacctByEstablishDateBefore(Calendar establishDate, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTswacctByEstablishDate
	 *
	 */
	public Set<Tswacct> findTswacctByEstablishDate(java.util.Calendar establishDate_1) throws DataAccessException;

	/**
	 * JPQL Query - findTswacctByEstablishDate
	 *
	 */
	public Set<Tswacct> findTswacctByEstablishDate(Calendar establishDate_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTswacctByActiveYn
	 *
	 */
	public Set<Tswacct> findTswacctByActiveYn(Integer activeYn) throws DataAccessException;

	/**
	 * JPQL Query - findTswacctByActiveYn
	 *
	 */
	public Set<Tswacct> findTswacctByActiveYn(Integer activeYn, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTswacctByAcctNameContaining
	 *
	 */
	public Set<Tswacct> findTswacctByAcctNameContaining(String acctName_1) throws DataAccessException;

	/**
	 * JPQL Query - findTswacctByAcctNameContaining
	 *
	 */
	public Set<Tswacct> findTswacctByAcctNameContaining(String acctName_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTswacctByExpireDateAfter
	 *
	 */
	public Set<Tswacct> findTswacctByExpireDateAfter(java.util.Calendar expireDate_1) throws DataAccessException;

	/**
	 * JPQL Query - findTswacctByExpireDateAfter
	 *
	 */
	public Set<Tswacct> findTswacctByExpireDateAfter(Calendar expireDate_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTswacctByEstablishDateAfter
	 *
	 */
	public Set<Tswacct> findTswacctByEstablishDateAfter(java.util.Calendar establishDate_2) throws DataAccessException;

	/**
	 * JPQL Query - findTswacctByEstablishDateAfter
	 *
	 */
	public Set<Tswacct> findTswacctByEstablishDateAfter(Calendar establishDate_2, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTswacctByTswAcctId
	 *
	 */
	public Tswacct findTswacctByTswAcctId(Integer tswAcctId) throws DataAccessException;

	/**
	 * JPQL Query - findTswacctByTswAcctId
	 *
	 */
	public Tswacct findTswacctByTswAcctId(Integer tswAcctId, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTswacctByPrimaryKey
	 *
	 */
	public Tswacct findTswacctByPrimaryKey(Integer tswAcctId_1) throws DataAccessException;

	/**
	 * JPQL Query - findTswacctByPrimaryKey
	 *
	 */
	public Tswacct findTswacctByPrimaryKey(Integer tswAcctId_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTswacctByExpireDate
	 *
	 */
	public Set<Tswacct> findTswacctByExpireDate(java.util.Calendar expireDate_2) throws DataAccessException;

	/**
	 * JPQL Query - findTswacctByExpireDate
	 *
	 */
	public Set<Tswacct> findTswacctByExpireDate(Calendar expireDate_2, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTswacctBySubscrTypeContaining
	 *
	 */
	public Set<Tswacct> findTswacctBySubscrTypeContaining(String subscrType) throws DataAccessException;

	/**
	 * JPQL Query - findTswacctBySubscrTypeContaining
	 *
	 */
	public Set<Tswacct> findTswacctBySubscrTypeContaining(String subscrType, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTswacctBySubscrType
	 *
	 */
	public Set<Tswacct> findTswacctBySubscrType(String subscrType_1) throws DataAccessException;

	/**
	 * JPQL Query - findTswacctBySubscrType
	 *
	 */
	public Set<Tswacct> findTswacctBySubscrType(String subscrType_1, int startResult, int maxRows) throws DataAccessException;

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