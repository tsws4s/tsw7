package pm7.dao;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.skyway.spring.util.dao.AbstractJpaDao;

import org.springframework.dao.DataAccessException;

import org.springframework.stereotype.Repository;

import org.springframework.transaction.annotation.Transactional;

import pm7.domain.Invoice;

/**
 * DAO to manage Invoice entities.
 * 
 */
@Repository("InvoiceDAO")
@Transactional
public class InvoiceDAOImpl extends AbstractJpaDao<Invoice> implements
		InvoiceDAO {

	/**
	 * Set of entity classes managed by this DAO.  Typically a DAO manages a single entity.
	 *
	 */
	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[] { Invoice.class }));

	/**
	 * EntityManager injected by Spring for persistence unit mySql_pm7
	 *
	 */
	@PersistenceContext(unitName = "mySql_pm7")
	private EntityManager entityManager;

	/**
	 * Instantiates a new InvoiceDAOImpl
	 *
	 */
	public InvoiceDAOImpl() {
		super();
	}

	/**
	 * Get the entity manager that manages persistence unit 
	 *
	 */
	public EntityManager getEntityManager() {
		return entityManager;
	}

	/**
	 * Returns the set of entity classes managed by this DAO.
	 *
	 */
	public Set<Class<?>> getTypes() {
		return dataTypes;
	}

	/**
	 * JPQL Query - findInvoiceByStatus
	 *
	 */
	@Transactional
	public Set<Invoice> findInvoiceByStatus(String status) throws DataAccessException {

		return findInvoiceByStatus(status, -1, -1);
	}

	/**
	 * JPQL Query - findInvoiceByStatus
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Invoice> findInvoiceByStatus(String status, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findInvoiceByStatus", startResult, maxRows, status);
		return new LinkedHashSet<Invoice>(query.getResultList());
	}

	/**
	 * JPQL Query - findInvoiceByBalanceAmt
	 *
	 */
	@Transactional
	public Set<Invoice> findInvoiceByBalanceAmt(java.math.BigDecimal balanceAmt) throws DataAccessException {

		return findInvoiceByBalanceAmt(balanceAmt, -1, -1);
	}

	/**
	 * JPQL Query - findInvoiceByBalanceAmt
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Invoice> findInvoiceByBalanceAmt(java.math.BigDecimal balanceAmt, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findInvoiceByBalanceAmt", startResult, maxRows, balanceAmt);
		return new LinkedHashSet<Invoice>(query.getResultList());
	}

	/**
	 * JPQL Query - findInvoiceByInvoiceId
	 *
	 */
	@Transactional
	public Invoice findInvoiceByInvoiceId(Integer invoiceId) throws DataAccessException {

		return findInvoiceByInvoiceId(invoiceId, -1, -1);
	}

	/**
	 * JPQL Query - findInvoiceByInvoiceId
	 *
	 */

	@Transactional
	public Invoice findInvoiceByInvoiceId(Integer invoiceId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findInvoiceByInvoiceId", startResult, maxRows, invoiceId);
			return (pm7.domain.Invoice) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findInvoiceByInvoiceDesc
	 *
	 */
	@Transactional
	public Set<Invoice> findInvoiceByInvoiceDesc(String invoiceDesc) throws DataAccessException {

		return findInvoiceByInvoiceDesc(invoiceDesc, -1, -1);
	}

	/**
	 * JPQL Query - findInvoiceByInvoiceDesc
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Invoice> findInvoiceByInvoiceDesc(String invoiceDesc, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findInvoiceByInvoiceDesc", startResult, maxRows, invoiceDesc);
		return new LinkedHashSet<Invoice>(query.getResultList());
	}

	/**
	 * JPQL Query - findInvoiceByPaidAmt
	 *
	 */
	@Transactional
	public Set<Invoice> findInvoiceByPaidAmt(java.math.BigDecimal paidAmt) throws DataAccessException {

		return findInvoiceByPaidAmt(paidAmt, -1, -1);
	}

	/**
	 * JPQL Query - findInvoiceByPaidAmt
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Invoice> findInvoiceByPaidAmt(java.math.BigDecimal paidAmt, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findInvoiceByPaidAmt", startResult, maxRows, paidAmt);
		return new LinkedHashSet<Invoice>(query.getResultList());
	}

	/**
	 * JPQL Query - findInvoiceByLogoFilename
	 *
	 */
	@Transactional
	public Set<Invoice> findInvoiceByLogoFilename(String logoFilename) throws DataAccessException {

		return findInvoiceByLogoFilename(logoFilename, -1, -1);
	}

	/**
	 * JPQL Query - findInvoiceByLogoFilename
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Invoice> findInvoiceByLogoFilename(String logoFilename, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findInvoiceByLogoFilename", startResult, maxRows, logoFilename);
		return new LinkedHashSet<Invoice>(query.getResultList());
	}

	/**
	 * JPQL Query - findInvoiceByExpensesAmt
	 *
	 */
	@Transactional
	public Set<Invoice> findInvoiceByExpensesAmt(java.math.BigDecimal expensesAmt) throws DataAccessException {

		return findInvoiceByExpensesAmt(expensesAmt, -1, -1);
	}

	/**
	 * JPQL Query - findInvoiceByExpensesAmt
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Invoice> findInvoiceByExpensesAmt(java.math.BigDecimal expensesAmt, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findInvoiceByExpensesAmt", startResult, maxRows, expensesAmt);
		return new LinkedHashSet<Invoice>(query.getResultList());
	}

	/**
	 * JPQL Query - findInvoiceByPaymentSched
	 *
	 */
	@Transactional
	public Set<Invoice> findInvoiceByPaymentSched(String paymentSched) throws DataAccessException {

		return findInvoiceByPaymentSched(paymentSched, -1, -1);
	}

	/**
	 * JPQL Query - findInvoiceByPaymentSched
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Invoice> findInvoiceByPaymentSched(String paymentSched, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findInvoiceByPaymentSched", startResult, maxRows, paymentSched);
		return new LinkedHashSet<Invoice>(query.getResultList());
	}

	/**
	 * JPQL Query - findInvoiceByPaymentSchedContaining
	 *
	 */
	@Transactional
	public Set<Invoice> findInvoiceByPaymentSchedContaining(String paymentSched) throws DataAccessException {

		return findInvoiceByPaymentSchedContaining(paymentSched, -1, -1);
	}

	/**
	 * JPQL Query - findInvoiceByPaymentSchedContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Invoice> findInvoiceByPaymentSchedContaining(String paymentSched, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findInvoiceByPaymentSchedContaining", startResult, maxRows, paymentSched);
		return new LinkedHashSet<Invoice>(query.getResultList());
	}

	/**
	 * JPQL Query - findInvoiceByPrimaryKey
	 *
	 */
	@Transactional
	public Invoice findInvoiceByPrimaryKey(Integer invoiceId) throws DataAccessException {

		return findInvoiceByPrimaryKey(invoiceId, -1, -1);
	}

	/**
	 * JPQL Query - findInvoiceByPrimaryKey
	 *
	 */

	@Transactional
	public Invoice findInvoiceByPrimaryKey(Integer invoiceId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findInvoiceByPrimaryKey", startResult, maxRows, invoiceId);
			return (pm7.domain.Invoice) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findInvoiceByInvoiceDate
	 *
	 */
	@Transactional
	public Set<Invoice> findInvoiceByInvoiceDate(java.util.Calendar invoiceDate) throws DataAccessException {

		return findInvoiceByInvoiceDate(invoiceDate, -1, -1);
	}

	/**
	 * JPQL Query - findInvoiceByInvoiceDate
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Invoice> findInvoiceByInvoiceDate(java.util.Calendar invoiceDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findInvoiceByInvoiceDate", startResult, maxRows, invoiceDate);
		return new LinkedHashSet<Invoice>(query.getResultList());
	}

	/**
	 * JPQL Query - findInvoiceByMessage
	 *
	 */
	@Transactional
	public Set<Invoice> findInvoiceByMessage(String message) throws DataAccessException {

		return findInvoiceByMessage(message, -1, -1);
	}

	/**
	 * JPQL Query - findInvoiceByMessage
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Invoice> findInvoiceByMessage(String message, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findInvoiceByMessage", startResult, maxRows, message);
		return new LinkedHashSet<Invoice>(query.getResultList());
	}

	/**
	 * JPQL Query - findInvoiceByActiveYn
	 *
	 */
	@Transactional
	public Set<Invoice> findInvoiceByActiveYn(Integer activeYn) throws DataAccessException {

		return findInvoiceByActiveYn(activeYn, -1, -1);
	}

	/**
	 * JPQL Query - findInvoiceByActiveYn
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Invoice> findInvoiceByActiveYn(Integer activeYn, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findInvoiceByActiveYn", startResult, maxRows, activeYn);
		return new LinkedHashSet<Invoice>(query.getResultList());
	}

	/**
	 * JPQL Query - findInvoiceByStatusContaining
	 *
	 */
	@Transactional
	public Set<Invoice> findInvoiceByStatusContaining(String status) throws DataAccessException {

		return findInvoiceByStatusContaining(status, -1, -1);
	}

	/**
	 * JPQL Query - findInvoiceByStatusContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Invoice> findInvoiceByStatusContaining(String status, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findInvoiceByStatusContaining", startResult, maxRows, status);
		return new LinkedHashSet<Invoice>(query.getResultList());
	}

	/**
	 * JPQL Query - findInvoiceByTotalAmt
	 *
	 */
	@Transactional
	public Set<Invoice> findInvoiceByTotalAmt(java.math.BigDecimal totalAmt) throws DataAccessException {

		return findInvoiceByTotalAmt(totalAmt, -1, -1);
	}

	/**
	 * JPQL Query - findInvoiceByTotalAmt
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Invoice> findInvoiceByTotalAmt(java.math.BigDecimal totalAmt, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findInvoiceByTotalAmt", startResult, maxRows, totalAmt);
		return new LinkedHashSet<Invoice>(query.getResultList());
	}

	/**
	 * JPQL Query - findInvoiceByInvoiceDescContaining
	 *
	 */
	@Transactional
	public Set<Invoice> findInvoiceByInvoiceDescContaining(String invoiceDesc) throws DataAccessException {

		return findInvoiceByInvoiceDescContaining(invoiceDesc, -1, -1);
	}

	/**
	 * JPQL Query - findInvoiceByInvoiceDescContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Invoice> findInvoiceByInvoiceDescContaining(String invoiceDesc, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findInvoiceByInvoiceDescContaining", startResult, maxRows, invoiceDesc);
		return new LinkedHashSet<Invoice>(query.getResultList());
	}

	/**
	 * JPQL Query - findInvoiceByBilledHrs
	 *
	 */
	@Transactional
	public Set<Invoice> findInvoiceByBilledHrs(Integer billedHrs) throws DataAccessException {

		return findInvoiceByBilledHrs(billedHrs, -1, -1);
	}

	/**
	 * JPQL Query - findInvoiceByBilledHrs
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Invoice> findInvoiceByBilledHrs(Integer billedHrs, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findInvoiceByBilledHrs", startResult, maxRows, billedHrs);
		return new LinkedHashSet<Invoice>(query.getResultList());
	}

	/**
	 * JPQL Query - findInvoiceByDiscountAmt
	 *
	 */
	@Transactional
	public Set<Invoice> findInvoiceByDiscountAmt(java.math.BigDecimal discountAmt) throws DataAccessException {

		return findInvoiceByDiscountAmt(discountAmt, -1, -1);
	}

	/**
	 * JPQL Query - findInvoiceByDiscountAmt
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Invoice> findInvoiceByDiscountAmt(java.math.BigDecimal discountAmt, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findInvoiceByDiscountAmt", startResult, maxRows, discountAmt);
		return new LinkedHashSet<Invoice>(query.getResultList());
	}

	/**
	 * JPQL Query - findInvoiceByInvoiceNumber
	 *
	 */
	@Transactional
	public Set<Invoice> findInvoiceByInvoiceNumber(Integer invoiceNumber) throws DataAccessException {

		return findInvoiceByInvoiceNumber(invoiceNumber, -1, -1);
	}

	/**
	 * JPQL Query - findInvoiceByInvoiceNumber
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Invoice> findInvoiceByInvoiceNumber(Integer invoiceNumber, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findInvoiceByInvoiceNumber", startResult, maxRows, invoiceNumber);
		return new LinkedHashSet<Invoice>(query.getResultList());
	}

	/**
	 * JPQL Query - findAllInvoices
	 *
	 */
	@Transactional
	public Set<Invoice> findAllInvoices() throws DataAccessException {

		return findAllInvoices(-1, -1);
	}

	/**
	 * JPQL Query - findAllInvoices
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Invoice> findAllInvoices(int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAllInvoices", startResult, maxRows);
		return new LinkedHashSet<Invoice>(query.getResultList());
	}

	/**
	 * JPQL Query - findInvoiceByMessageContaining
	 *
	 */
	@Transactional
	public Set<Invoice> findInvoiceByMessageContaining(String message) throws DataAccessException {

		return findInvoiceByMessageContaining(message, -1, -1);
	}

	/**
	 * JPQL Query - findInvoiceByMessageContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Invoice> findInvoiceByMessageContaining(String message, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findInvoiceByMessageContaining", startResult, maxRows, message);
		return new LinkedHashSet<Invoice>(query.getResultList());
	}

	/**
	 * JPQL Query - findInvoiceByTaxesAmt
	 *
	 */
	@Transactional
	public Set<Invoice> findInvoiceByTaxesAmt(java.math.BigDecimal taxesAmt) throws DataAccessException {

		return findInvoiceByTaxesAmt(taxesAmt, -1, -1);
	}

	/**
	 * JPQL Query - findInvoiceByTaxesAmt
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Invoice> findInvoiceByTaxesAmt(java.math.BigDecimal taxesAmt, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findInvoiceByTaxesAmt", startResult, maxRows, taxesAmt);
		return new LinkedHashSet<Invoice>(query.getResultList());
	}

	/**
	 * JPQL Query - findInvoiceByBilledRate
	 *
	 */
	@Transactional
	public Set<Invoice> findInvoiceByBilledRate(java.math.BigDecimal billedRate) throws DataAccessException {

		return findInvoiceByBilledRate(billedRate, -1, -1);
	}

	/**
	 * JPQL Query - findInvoiceByBilledRate
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Invoice> findInvoiceByBilledRate(java.math.BigDecimal billedRate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findInvoiceByBilledRate", startResult, maxRows, billedRate);
		return new LinkedHashSet<Invoice>(query.getResultList());
	}

	/**
	 * JPQL Query - findInvoiceByItemsAmt
	 *
	 */
	@Transactional
	public Set<Invoice> findInvoiceByItemsAmt(java.math.BigDecimal itemsAmt) throws DataAccessException {

		return findInvoiceByItemsAmt(itemsAmt, -1, -1);
	}

	/**
	 * JPQL Query - findInvoiceByItemsAmt
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Invoice> findInvoiceByItemsAmt(java.math.BigDecimal itemsAmt, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findInvoiceByItemsAmt", startResult, maxRows, itemsAmt);
		return new LinkedHashSet<Invoice>(query.getResultList());
	}

	/**
	 * JPQL Query - findInvoiceByLogoFilenameContaining
	 *
	 */
	@Transactional
	public Set<Invoice> findInvoiceByLogoFilenameContaining(String logoFilename) throws DataAccessException {

		return findInvoiceByLogoFilenameContaining(logoFilename, -1, -1);
	}

	/**
	 * JPQL Query - findInvoiceByLogoFilenameContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Invoice> findInvoiceByLogoFilenameContaining(String logoFilename, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findInvoiceByLogoFilenameContaining", startResult, maxRows, logoFilename);
		return new LinkedHashSet<Invoice>(query.getResultList());
	}

	/**
	 * Used to determine whether or not to merge the entity or persist the entity when calling Store
	 * @see store
	 * 
	 *
	 */
	public boolean canBeMerged(Invoice entity) {
		return true;
	}
	
	public Integer getMaxInvoiceId() {
		Object obj = executeQuerySingleResult("select max(invoiceId) from Invoice");
		if(obj!=null){
			return (Integer)obj;
		}
		return 0;
	}
}
