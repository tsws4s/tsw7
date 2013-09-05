package pm7.dao;

import java.math.BigDecimal;

import java.util.Set;

import org.skyway.spring.util.dao.JpaDao;

import org.springframework.dao.DataAccessException;

import pm7.domain.Invoiceitem;

/**
 * DAO to manage Invoiceitem entities.
 * 
 */
public interface InvoiceitemDAO extends JpaDao<Invoiceitem> {

	/**
	 * JPQL Query - findAllInvoiceitems
	 *
	 */
	public Set<Invoiceitem> findAllInvoiceitems() throws DataAccessException;

	/**
	 * JPQL Query - findAllInvoiceitems
	 *
	 */
	public Set<Invoiceitem> findAllInvoiceitems(int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findInvoiceitemByPrimaryKey
	 *
	 */
	public Invoiceitem findInvoiceitemByPrimaryKey(Integer invoiceItemId) throws DataAccessException;

	/**
	 * JPQL Query - findInvoiceitemByPrimaryKey
	 *
	 */
	public Invoiceitem findInvoiceitemByPrimaryKey(Integer invoiceItemId, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findInvoiceitemByItemAmt
	 *
	 */
	public Set<Invoiceitem> findInvoiceitemByItemAmt(java.math.BigDecimal itemAmt) throws DataAccessException;

	/**
	 * JPQL Query - findInvoiceitemByItemAmt
	 *
	 */
	public Set<Invoiceitem> findInvoiceitemByItemAmt(BigDecimal itemAmt, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findInvoiceitemByInvoiceItemDescContaining
	 *
	 */
	public Set<Invoiceitem> findInvoiceitemByInvoiceItemDescContaining(String invoiceItemDesc) throws DataAccessException;

	/**
	 * JPQL Query - findInvoiceitemByInvoiceItemDescContaining
	 *
	 */
	public Set<Invoiceitem> findInvoiceitemByInvoiceItemDescContaining(String invoiceItemDesc, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findInvoiceitemByProjectExpenseYn
	 *
	 */
	public Set<Invoiceitem> findInvoiceitemByProjectExpenseYn(Integer projectExpenseYn) throws DataAccessException;

	/**
	 * JPQL Query - findInvoiceitemByProjectExpenseYn
	 *
	 */
	public Set<Invoiceitem> findInvoiceitemByProjectExpenseYn(Integer projectExpenseYn, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findInvoiceitemByInvoiceItemId
	 *
	 */
	public Invoiceitem findInvoiceitemByInvoiceItemId(Integer invoiceItemId_1) throws DataAccessException;

	/**
	 * JPQL Query - findInvoiceitemByInvoiceItemId
	 *
	 */
	public Invoiceitem findInvoiceitemByInvoiceItemId(Integer invoiceItemId_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findInvoiceitemByInvoiceItemDesc
	 *
	 */
	public Set<Invoiceitem> findInvoiceitemByInvoiceItemDesc(String invoiceItemDesc_1) throws DataAccessException;

	/**
	 * JPQL Query - findInvoiceitemByInvoiceItemDesc
	 *
	 */
	public Set<Invoiceitem> findInvoiceitemByInvoiceItemDesc(String invoiceItemDesc_1, int startResult, int maxRows) throws DataAccessException;

	public Integer getMaxInvoiceitemId();
}