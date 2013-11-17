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

import wsdm.domain.Tswacctsport;

/**
 * DAO to manage Tswacctsport entities.
 * 
 */
@Repository("TswacctsportDAO")
@Transactional
public class TswacctsportDAOImpl extends AbstractJpaDao<Tswacctsport> implements
		TswacctsportDAO {

	/**
	 * Set of entity classes managed by this DAO.  Typically a DAO manages a single entity.
	 *
	 */
	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[] { Tswacctsport.class }));

	/**
	 * EntityManager injected by Spring for persistence unit mysql_tsw
	 *
	 */
	@PersistenceContext(unitName = "mysql_tsw")
	private EntityManager entityManager;

	/**
	 * Instantiates a new TswacctsportDAOImpl
	 *
	 */
	public TswacctsportDAOImpl() {
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
	 * JPQL Query - findAllTswacctsports
	 *
	 */
	@Transactional
	public Set<Tswacctsport> findAllTswacctsports() throws DataAccessException {

		return findAllTswacctsports(-1, -1);
	}

	/**
	 * JPQL Query - findAllTswacctsports
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Tswacctsport> findAllTswacctsports(int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAllTswacctsports", startResult, maxRows);
		return new LinkedHashSet<Tswacctsport>(query.getResultList());
	}

	/**
	 * JPQL Query - findTswacctsportByNumPrograms
	 *
	 */
	@Transactional
	public Set<Tswacctsport> findTswacctsportByNumPrograms(Integer numPrograms) throws DataAccessException {

		return findTswacctsportByNumPrograms(numPrograms, -1, -1);
	}

	/**
	 * JPQL Query - findTswacctsportByNumPrograms
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Tswacctsport> findTswacctsportByNumPrograms(Integer numPrograms, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTswacctsportByNumPrograms", startResult, maxRows, numPrograms);
		return new LinkedHashSet<Tswacctsport>(query.getResultList());
	}

	/**
	 * JPQL Query - findTswacctsportByTswAcctSportId
	 *
	 */
	@Transactional
	public Tswacctsport findTswacctsportByTswAcctSportId(Integer tswAcctSportId) throws DataAccessException {

		return findTswacctsportByTswAcctSportId(tswAcctSportId, -1, -1);
	}

	/**
	 * JPQL Query - findTswacctsportByTswAcctSportId
	 *
	 */

	@Transactional
	public Tswacctsport findTswacctsportByTswAcctSportId(Integer tswAcctSportId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findTswacctsportByTswAcctSportId", startResult, maxRows, tswAcctSportId);
			return (wsdm.domain.Tswacctsport) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findTswacctsportBySportFk
	 *
	 */
	@Transactional
	public Set<Tswacctsport> findTswacctsportBySportFk(Integer sportFk) throws DataAccessException {

		return findTswacctsportBySportFk(sportFk, -1, -1);
	}

	/**
	 * JPQL Query - findTswacctsportBySportFk
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Tswacctsport> findTswacctsportBySportFk(Integer sportFk, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTswacctsportBySportFk", startResult, maxRows, sportFk);
		return new LinkedHashSet<Tswacctsport>(query.getResultList());
	}

	/**
	 * JPQL Query - findTswacctsportByPrimaryKey
	 *
	 */
	@Transactional
	public Tswacctsport findTswacctsportByPrimaryKey(Integer tswAcctSportId) throws DataAccessException {

		return findTswacctsportByPrimaryKey(tswAcctSportId, -1, -1);
	}

	/**
	 * JPQL Query - findTswacctsportByPrimaryKey
	 *
	 */

	@Transactional
	public Tswacctsport findTswacctsportByPrimaryKey(Integer tswAcctSportId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findTswacctsportByPrimaryKey", startResult, maxRows, tswAcctSportId);
			return (wsdm.domain.Tswacctsport) query.getSingleResult();
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
	public boolean canBeMerged(Tswacctsport entity) {
		return true;
	}
}
