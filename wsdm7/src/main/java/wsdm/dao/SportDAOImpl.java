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

import wsdm.domain.Sport;

/**
 * DAO to manage Sport entities.
 * 
 */
@Repository("SportDAO")
@Transactional
public class SportDAOImpl extends AbstractJpaDao<Sport> implements SportDAO {

	/**
	 * Set of entity classes managed by this DAO.  Typically a DAO manages a single entity.
	 *
	 */
	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[] { Sport.class }));

	/**
	 * EntityManager injected by Spring for persistence unit mysql_tsw
	 *
	 */
	@PersistenceContext(unitName = "mysql_tsw")
	private EntityManager entityManager;

	/**
	 * Instantiates a new SportDAOImpl
	 *
	 */
	public SportDAOImpl() {
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
	 * JPQL Query - findSportByPrimaryKey
	 *
	 */
	@Transactional
	public Sport findSportByPrimaryKey(Integer sportId) throws DataAccessException {

		return findSportByPrimaryKey(sportId, -1, -1);
	}

	/**
	 * JPQL Query - findSportByPrimaryKey
	 *
	 */

	@Transactional
	public Sport findSportByPrimaryKey(Integer sportId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findSportByPrimaryKey", startResult, maxRows, sportId);
			return (wsdm.domain.Sport) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findAllSports
	 *
	 */
	@Transactional
	public Set<Sport> findAllSports() throws DataAccessException {

		return findAllSports(-1, -1);
	}

	/**
	 * JPQL Query - findAllSports
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Sport> findAllSports(int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAllSports", startResult, maxRows);
		return new LinkedHashSet<Sport>(query.getResultList());
	}

	/**
	 * Used to determine whether or not to merge the entity or persist the entity when calling Store
	 * @see store
	 * 
	 *
	 */
	public boolean canBeMerged(Sport entity) {
		return true;
	}
}
