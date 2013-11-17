package wsdm.dao;

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

import wsdm.domain.Price;

/**
 * DAO to manage Price entities.
 * 
 */
@Repository("PriceDAO")
@Transactional
public class PriceDAOImpl extends AbstractJpaDao<Price> implements PriceDAO {

	/**
	 * Set of entity classes managed by this DAO.  Typically a DAO manages a single entity.
	 *
	 */
	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[] { Price.class }));

	/**
	 * EntityManager injected by Spring for persistence unit mysql_tsw
	 *
	 */
	@PersistenceContext(unitName = "mysql_tsw")
	private EntityManager entityManager;

	/**
	 * Instantiates a new PriceDAOImpl
	 *
	 */
	public PriceDAOImpl() {
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
	 * JPQL Query - findPriceByPriceColorContaining
	 *
	 */
	@Transactional
	public Set<Price> findPriceByPriceColorContaining(String priceColor) throws DataAccessException {

		return findPriceByPriceColorContaining(priceColor, -1, -1);
	}

	/**
	 * JPQL Query - findPriceByPriceColorContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Price> findPriceByPriceColorContaining(String priceColor, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findPriceByPriceColorContaining", startResult, maxRows, priceColor);
		return new LinkedHashSet<Price>(query.getResultList());
	}

	/**
	 * JPQL Query - findPriceByDescription
	 *
	 */
	@Transactional
	public Set<Price> findPriceByDescription(String description) throws DataAccessException {

		return findPriceByDescription(description, -1, -1);
	}

	/**
	 * JPQL Query - findPriceByDescription
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Price> findPriceByDescription(String description, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findPriceByDescription", startResult, maxRows, description);
		return new LinkedHashSet<Price>(query.getResultList());
	}

	/**
	 * JPQL Query - findPriceByPriceId
	 *
	 */
	@Transactional
	public Price findPriceByPriceId(Integer priceId) throws DataAccessException {

		return findPriceByPriceId(priceId, -1, -1);
	}

	/**
	 * JPQL Query - findPriceByPriceId
	 *
	 */

	@Transactional
	public Price findPriceByPriceId(Integer priceId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findPriceByPriceId", startResult, maxRows, priceId);
			return (wsdm.domain.Price) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findPriceByDescriptionContaining
	 *
	 */
	@Transactional
	public Set<Price> findPriceByDescriptionContaining(String description) throws DataAccessException {

		return findPriceByDescriptionContaining(description, -1, -1);
	}

	/**
	 * JPQL Query - findPriceByDescriptionContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Price> findPriceByDescriptionContaining(String description, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findPriceByDescriptionContaining", startResult, maxRows, description);
		return new LinkedHashSet<Price>(query.getResultList());
	}

	/**
	 * JPQL Query - findPriceByPriceColor
	 *
	 */
	@Transactional
	public Set<Price> findPriceByPriceColor(String priceColor) throws DataAccessException {

		return findPriceByPriceColor(priceColor, -1, -1);
	}

	/**
	 * JPQL Query - findPriceByPriceColor
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Price> findPriceByPriceColor(String priceColor, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findPriceByPriceColor", startResult, maxRows, priceColor);
		return new LinkedHashSet<Price>(query.getResultList());
	}

	/**
	 * JPQL Query - findPriceByPriceCategoryContaining
	 *
	 */
	@Transactional
	public Set<Price> findPriceByPriceCategoryContaining(String priceCategory) throws DataAccessException {

		return findPriceByPriceCategoryContaining(priceCategory, -1, -1);
	}

	/**
	 * JPQL Query - findPriceByPriceCategoryContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Price> findPriceByPriceCategoryContaining(String priceCategory, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findPriceByPriceCategoryContaining", startResult, maxRows, priceCategory);
		return new LinkedHashSet<Price>(query.getResultList());
	}

	/**
	 * JPQL Query - findPriceByPriceCategory
	 *
	 */
	@Transactional
	public Set<Price> findPriceByPriceCategory(String priceCategory) throws DataAccessException {

		return findPriceByPriceCategory(priceCategory, -1, -1);
	}

	/**
	 * JPQL Query - findPriceByPriceCategory
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Price> findPriceByPriceCategory(String priceCategory, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findPriceByPriceCategory", startResult, maxRows, priceCategory);
		return new LinkedHashSet<Price>(query.getResultList());
	}

	/**
	 * JPQL Query - findPriceByPriceField
	 *
	 */
	@Transactional
	public Set<Price> findPriceByPriceField(java.math.BigDecimal priceField) throws DataAccessException {

		return findPriceByPriceField(priceField, -1, -1);
	}

	/**
	 * JPQL Query - findPriceByPriceField
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Price> findPriceByPriceField(java.math.BigDecimal priceField, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findPriceByPriceField", startResult, maxRows, priceField);
		return new LinkedHashSet<Price>(query.getResultList());
	}

	/**
	 * JPQL Query - findAllPrices
	 *
	 */
	@Transactional
	public Set<Price> findAllPrices() throws DataAccessException {

		return findAllPrices(-1, -1);
	}

	/**
	 * JPQL Query - findAllPrices
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Price> findAllPrices(int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAllPrices", startResult, maxRows);
		return new LinkedHashSet<Price>(query.getResultList());
	}

	/**
	 * JPQL Query - findPriceByPrimaryKey
	 *
	 */
	@Transactional
	public Price findPriceByPrimaryKey(Integer priceId) throws DataAccessException {

		return findPriceByPrimaryKey(priceId, -1, -1);
	}

	/**
	 * JPQL Query - findPriceByPrimaryKey
	 *
	 */

	@Transactional
	public Price findPriceByPrimaryKey(Integer priceId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findPriceByPrimaryKey", startResult, maxRows, priceId);
			return (wsdm.domain.Price) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * Used to determine whether or not to merge the entity or persist the entity when calling Store
	 * @see store
	 * 
	 *
	 */
	public boolean canBeMerged(Price entity) {
		return true;
	}
}
