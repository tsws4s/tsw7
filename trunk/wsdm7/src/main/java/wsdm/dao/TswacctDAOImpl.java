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

import wsdm.domain.Tswacct;

/**
 * DAO to manage Tswacct entities.
 * 
 */
@Repository("TswacctDAO")
@Transactional
public class TswacctDAOImpl extends AbstractJpaDao<Tswacct> implements
		TswacctDAO {

	/**
	 * Set of entity classes managed by this DAO.  Typically a DAO manages a single entity.
	 *
	 */
	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[] { Tswacct.class }));

	/**
	 * EntityManager injected by Spring for persistence unit mysql_tsw
	 *
	 */
	@PersistenceContext(unitName = "mysql_tsw")
	private EntityManager entityManager;

	/**
	 * Instantiates a new TswacctDAOImpl
	 *
	 */
	public TswacctDAOImpl() {
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
	 * JPQL Query - findTswacctByPrimaryKey
	 *
	 */
	@Transactional
	public Tswacct findTswacctByPrimaryKey(Integer tswAcctId) throws DataAccessException {

		return findTswacctByPrimaryKey(tswAcctId, -1, -1);
	}

	/**
	 * JPQL Query - findTswacctByPrimaryKey
	 *
	 */

	@Transactional
	public Tswacct findTswacctByPrimaryKey(Integer tswAcctId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findTswacctByPrimaryKey", startResult, maxRows, tswAcctId);
			return (wsdm.domain.Tswacct) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findAllTswaccts
	 *
	 */
	@Transactional
	public Set<Tswacct> findAllTswaccts() throws DataAccessException {

		return findAllTswaccts(-1, -1);
	}

	/**
	 * JPQL Query - findAllTswaccts
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Tswacct> findAllTswaccts(int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAllTswaccts", startResult, maxRows);
		return new LinkedHashSet<Tswacct>(query.getResultList());
	}

	/**
	 * Used to determine whether or not to merge the entity or persist the entity when calling Store
	 * @see store
	 * 
	 *
	 */
	public boolean canBeMerged(Tswacct entity) {
		return true;
	}
}
