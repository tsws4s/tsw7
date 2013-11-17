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
	 * Used to determine whether or not to merge the entity or persist the entity when calling Store
	 * @see store
	 * 
	 *
	 */
	public boolean canBeMerged(Price entity) {
		return true;
	}
}
