package pm7.dao;

import java.math.BigDecimal;

import java.util.Calendar;
import java.util.Set;

import org.skyway.spring.util.dao.JpaDao;

import org.springframework.dao.DataAccessException;

import pm7.domain.Invoice;

/**
 * DAO to manage Invoice entities.
 * 
 */
public interface InvoiceDAO extends JpaDao<Invoice> {

	/**
	 * JPQL Query - findInvoiceByStatus
	 *
	 */
	public Set<Invoice> findInvoiceByStatus(String status) throws DataAccessException;

	/**
	 * JPQL Query - findInvoiceByStatus
	 *
	 */
	public Set<Invoice> findInvoiceByStatus(String status, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findInvoiceByBalanceAmt
	 *
	 */
	public Set<Invoice> findInvoiceByBalanceAmt(java.math.BigDecimal balanceAmt) throws DataAccessException;

	/**
	 * JPQL Query - findInvoiceByBalanceAmt
	 *
	 */
	public Set<Invoice> findInvoiceByBalanceAmt(BigDecimal balanceAmt, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findInvoiceByInvoiceId
	 *
	 */
	public Invoice findInvoiceByInvoiceId(Integer invoiceId) throws DataAccessException;

	/**
	 * JPQL Query - findInvoiceByInvoiceId
	 *
	 */
	public Invoice findInvoiceByInvoiceId(Integer invoiceId, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findInvoiceByInvoiceDesc
	 *
	 */
	public Set<Invoice> findInvoiceByInvoiceDesc(String invoiceDesc) throws DataAccessException;

	/**
	 * JPQL Query - findInvoiceByInvoiceDesc
	 *
	 */
	public Set<Invoice> findInvoiceByInvoiceDesc(String invoiceDesc, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findInvoiceByPaidAmt
	 *
	 */
	public Set<Invoice> findInvoiceByPaidAmt(java.math.BigDecimal paidAmt) throws DataAccessException;

	/**
	 * JPQL Query - findInvoiceByPaidAmt
	 *
	 */
	public Set<Invoice> findInvoiceByPaidAmt(BigDecimal paidAmt, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findInvoiceByLogoFilename
	 *
	 */
	public Set<Invoice> findInvoiceByLogoFilename(String logoFilename) throws DataAccessException;

	/**
	 * JPQL Query - findInvoiceByLogoFilename
	 *
	 */
	public Set<Invoice> findInvoiceByLogoFilename(String logoFilename, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findInvoiceByExpensesAmt
	 *
	 */
	public Set<Invoice> findInvoiceByExpensesAmt(java.math.BigDecimal expensesAmt) throws DataAccessException;

	/**
	 * JPQL Query - findInvoiceByExpensesAmt
	 *
	 */
	public Set<Invoice> findInvoiceByExpensesAmt(BigDecimal expensesAmt, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findInvoiceByPaymentSched
	 *
	 */
	public Set<Invoice> findInvoiceByPaymentSched(String paymentSched) throws DataAccessException;

	/**
	 * JPQL Query - findInvoiceByPaymentSched
	 *
	 */
	public Set<Invoice> findInvoiceByPaymentSched(String paymentSched, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findInvoiceByPaymentSchedContaining
	 *
	 */
	public Set<Invoice> findInvoiceByPaymentSchedContaining(String paymentSched_1) throws DataAccessException;

	/**
	 * JPQL Query - findInvoiceByPaymentSchedContaining
	 *
	 */
	public Set<Invoice> findInvoiceByPaymentSchedContaining(String paymentSched_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findInvoiceByPrimaryKey
	 *
	 */
	public Invoice findInvoiceByPrimaryKey(Integer invoiceId_1) throws DataAccessException;

	/**
	 * JPQL Query - findInvoiceByPrimaryKey
	 *
	 */
	public Invoice findInvoiceByPrimaryKey(Integer invoiceId_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findInvoiceByInvoiceDate
	 *
	 */
	public Set<Invoice> findInvoiceByInvoiceDate(java.util.Calendar invoiceDate) throws DataAccessException;

	/**
	 * JPQL Query - findInvoiceByInvoiceDate
	 *
	 */
	public Set<Invoice> findInvoiceByInvoiceDate(Calendar invoiceDate, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findInvoiceByMessage
	 *
	 */
	public Set<Invoice> findInvoiceByMessage(String message) throws DataAccessException;

	/**
	 * JPQL Query - findInvoiceByMessage
	 *
	 */
	public Set<Invoice> findInvoiceByMessage(String message, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findInvoiceByActiveYn
	 *
	 */
	public Set<Invoice> findInvoiceByActiveYn(Integer activeYn) throws DataAccessException;

	/**
	 * JPQL Query - findInvoiceByActiveYn
	 *
	 */
	public Set<Invoice> findInvoiceByActiveYn(Integer activeYn, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findInvoiceByStatusContaining
	 *
	 */
	public Set<Invoice> findInvoiceByStatusContaining(String status_1) throws DataAccessException;

	/**
	 * JPQL Query - findInvoiceByStatusContaining
	 *
	 */
	public Set<Invoice> findInvoiceByStatusContaining(String status_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findInvoiceByTotalAmt
	 *
	 */
	public Set<Invoice> findInvoiceByTotalAmt(java.math.BigDecimal totalAmt) throws DataAccessException;

	/**
	 * JPQL Query - findInvoiceByTotalAmt
	 *
	 */
	public Set<Invoice> findInvoiceByTotalAmt(BigDecimal totalAmt, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findInvoiceByInvoiceDescContaining
	 *
	 */
	public Set<Invoice> findInvoiceByInvoiceDescContaining(String invoiceDesc_1) throws DataAccessException;

	/**
	 * JPQL Query - findInvoiceByInvoiceDescContaining
	 *
	 */
	public Set<Invoice> findInvoiceByInvoiceDescContaining(String invoiceDesc_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findInvoiceByBilledHrs
	 *
	 */
	public Set<Invoice> findInvoiceByBilledHrs(Integer billedHrs) throws DataAccessException;

	/**
	 * JPQL Query - findInvoiceByBilledHrs
	 *
	 */
	public Set<Invoice> findInvoiceByBilledHrs(Integer billedHrs, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findInvoiceByDiscountAmt
	 *
	 */
	public Set<Invoice> findInvoiceByDiscountAmt(java.math.BigDecimal discountAmt) throws DataAccessException;

	/**
	 * JPQL Query - findInvoiceByDiscountAmt
	 *
	 */
	public Set<Invoice> findInvoiceByDiscountAmt(BigDecimal discountAmt, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findInvoiceByInvoiceNumber
	 *
	 */
	public Set<Invoice> findInvoiceByInvoiceNumber(Integer invoiceNumber) throws DataAccessException;

	/**
	 * JPQL Query - findInvoiceByInvoiceNumber
	 *
	 */
	public Set<Invoice> findInvoiceByInvoiceNumber(Integer invoiceNumber, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAllInvoices
	 *
	 */
	public Set<Invoice> findAllInvoices() throws DataAccessException;

	/**
	 * JPQL Query - findAllInvoices
	 *
	 */
	public Set<Invoice> findAllInvoices(int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findInvoiceByMessageContaining
	 *
	 */
	public Set<Invoice> findInvoiceByMessageContaining(String message_1) throws DataAccessException;

	/**
	 * JPQL Query - findInvoiceByMessageContaining
	 *
	 */
	public Set<Invoice> findInvoiceByMessageContaining(String message_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findInvoiceByTaxesAmt
	 *
	 */
	public Set<Invoice> findInvoiceByTaxesAmt(java.math.BigDecimal taxesAmt) throws DataAccessException;

	/**
	 * JPQL Query - findInvoiceByTaxesAmt
	 *
	 */
	public Set<Invoice> findInvoiceByTaxesAmt(BigDecimal taxesAmt, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findInvoiceByBilledRate
	 *
	 */
	public Set<Invoice> findInvoiceByBilledRate(java.math.BigDecimal billedRate) throws DataAccessException;

	/**
	 * JPQL Query - findInvoiceByBilledRate
	 *
	 */
	public Set<Invoice> findInvoiceByBilledRate(BigDecimal billedRate, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findInvoiceByItemsAmt
	 *
	 */
	public Set<Invoice> findInvoiceByItemsAmt(java.math.BigDecimal itemsAmt) throws DataAccessException;

	/**
	 * JPQL Query - findInvoiceByItemsAmt
	 *
	 */
	public Set<Invoice> findInvoiceByItemsAmt(BigDecimal itemsAmt, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findInvoiceByLogoFilenameContaining
	 *
	 */
	public Set<Invoice> findInvoiceByLogoFilenameContaining(String logoFilename_1) throws DataAccessException;

	/**
	 * JPQL Query - findInvoiceByLogoFilenameContaining
	 *
	 */
	public Set<Invoice> findInvoiceByLogoFilenameContaining(String logoFilename_1, int startResult, int maxRows) throws DataAccessException;

	public Integer getMaxInvoiceId();
}