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

import pm7.domain.Invoiceitem;

/**
 * DAO to manage Invoiceitem entities.
 * 
 */
@Repository("InvoiceitemDAO")
@Transactional
public class InvoiceitemDAOImpl extends AbstractJpaDao<Invoiceitem> implements
		InvoiceitemDAO {

	/**
	 * Set of entity classes managed by this DAO.  Typically a DAO manages a single entity.
	 *
	 */
	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[] { Invoiceitem.class }));

	/**
	 * EntityManager injected by Spring for persistence unit mySql_pm7
	 *
	 */
	@PersistenceContext(unitName = "mySql_pm7")
	private EntityManager entityManager;

	/**
	 * Instantiates a new InvoiceitemDAOImpl
	 *
	 */
	public InvoiceitemDAOImpl() {
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
	 * JPQL Query - findAllInvoiceitems
	 *
	 */
	@Transactional
	public Set<Invoiceitem> findAllInvoiceitems() throws DataAccessException {

		return findAllInvoiceitems(-1, -1);
	}

	/**
	 * JPQL Query - findAllInvoiceitems
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Invoiceitem> findAllInvoiceitems(int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAllInvoiceitems", startResult, maxRows);
		return new LinkedHashSet<Invoiceitem>(query.getResultList());
	}

	/**
	 * JPQL Query - findInvoiceitemByPrimaryKey
	 *
	 */
	@Transactional
	public Invoiceitem findInvoiceitemByPrimaryKey(Integer invoiceItemId) throws DataAccessException {

		return findInvoiceitemByPrimaryKey(invoiceItemId, -1, -1);
	}

	/**
	 * JPQL Query - findInvoiceitemByPrimaryKey
	 *
	 */

	@Transactional
	public Invoiceitem findInvoiceitemByPrimaryKey(Integer invoiceItemId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findInvoiceitemByPrimaryKey", startResult, maxRows, invoiceItemId);
			return (pm7.domain.Invoiceitem) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findInvoiceitemByItemAmt
	 *
	 */
	@Transactional
	public Set<Invoiceitem> findInvoiceitemByItemAmt(java.math.BigDecimal itemAmt) throws DataAccessException {

		return findInvoiceitemByItemAmt(itemAmt, -1, -1);
	}

	/**
	 * JPQL Query - findInvoiceitemByItemAmt
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Invoiceitem> findInvoiceitemByItemAmt(java.math.BigDecimal itemAmt, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findInvoiceitemByItemAmt", startResult, maxRows, itemAmt);
		return new LinkedHashSet<Invoiceitem>(query.getResultList());
	}

	/**
	 * JPQL Query - findInvoiceitemByInvoiceItemDescContaining
	 *
	 */
	@Transactional
	public Set<Invoiceitem> findInvoiceitemByInvoiceItemDescContaining(String invoiceItemDesc) throws DataAccessException {

		return findInvoiceitemByInvoiceItemDescContaining(invoiceItemDesc, -1, -1);
	}

	/**
	 * JPQL Query - findInvoiceitemByInvoiceItemDescContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Invoiceitem> findInvoiceitemByInvoiceItemDescContaining(String invoiceItemDesc, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findInvoiceitemByInvoiceItemDescContaining", startResult, maxRows, invoiceItemDesc);
		return new LinkedHashSet<Invoiceitem>(query.getResultList());
	}

	/**
	 * JPQL Query - findInvoiceitemByProjectExpenseYn
	 *
	 */
	@Transactional
	public Set<Invoiceitem> findInvoiceitemByProjectExpenseYn(Integer projectExpenseYn) throws DataAccessException {

		return findInvoiceitemByProjectExpenseYn(projectExpenseYn, -1, -1);
	}

	/**
	 * JPQL Query - findInvoiceitemByProjectExpenseYn
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Invoiceitem> findInvoiceitemByProjectExpenseYn(Integer projectExpenseYn, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findInvoiceitemByProjectExpenseYn", startResult, maxRows, projectExpenseYn);
		return new LinkedHashSet<Invoiceitem>(query.getResultList());
	}

	/**
	 * JPQL Query - findInvoiceitemByInvoiceItemId
	 *
	 */
	@Transactional
	public Invoiceitem findInvoiceitemByInvoiceItemId(Integer invoiceItemId) throws DataAccessException {

		return findInvoiceitemByInvoiceItemId(invoiceItemId, -1, -1);
	}

	/**
	 * JPQL Query - findInvoiceitemByInvoiceItemId
	 *
	 */

	@Transactional
	public Invoiceitem findInvoiceitemByInvoiceItemId(Integer invoiceItemId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findInvoiceitemByInvoiceItemId", startResult, maxRows, invoiceItemId);
			return (pm7.domain.Invoiceitem) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findInvoiceitemByInvoiceItemDesc
	 *
	 */
	@Transactional
	public Set<Invoiceitem> findInvoiceitemByInvoiceItemDesc(String invoiceItemDesc) throws DataAccessException {

		return findInvoiceitemByInvoiceItemDesc(invoiceItemDesc, -1, -1);
	}

	/**
	 * JPQL Query - findInvoiceitemByInvoiceItemDesc
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Invoiceitem> findInvoiceitemByInvoiceItemDesc(String invoiceItemDesc, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findInvoiceitemByInvoiceItemDesc", startResult, maxRows, invoiceItemDesc);
		return new LinkedHashSet<Invoiceitem>(query.getResultList());
	}

	/**
	 * Used to determine whether or not to merge the entity or persist the entity when calling Store
	 * @see store
	 * 
	 *
	 */
	public boolean canBeMerged(Invoiceitem entity) {
		return true;
	}
	
	public Integer getMaxInvoiceitemId() {
		Object obj = executeQuerySingleResult("select max(invoiceItemId) from Invoiceitem");
		if(obj!=null){
			return (Integer)obj;
		}
		return 0;
	}
}
