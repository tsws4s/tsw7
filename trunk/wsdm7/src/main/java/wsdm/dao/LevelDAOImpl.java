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

import wsdm.domain.Level;

/**
 * DAO to manage Level entities.
 * 
 */
@Repository("LevelDAO")
@Transactional
public class LevelDAOImpl extends AbstractJpaDao<Level> implements LevelDAO {

	/**
	 * Set of entity classes managed by this DAO.  Typically a DAO manages a single entity.
	 *
	 */
	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[] { Level.class }));

	/**
	 * EntityManager injected by Spring for persistence unit mysql_tsw
	 *
	 */
	@PersistenceContext(unitName = "mysql_tsw")
	private EntityManager entityManager;

	/**
	 * Instantiates a new LevelDAOImpl
	 *
	 */
	public LevelDAOImpl() {
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
	 * JPQL Query - findLevelByPrimaryKey
	 *
	 */
	@Transactional
	public Level findLevelByPrimaryKey(Integer levelId) throws DataAccessException {

		return findLevelByPrimaryKey(levelId, -1, -1);
	}

	/**
	 * JPQL Query - findLevelByPrimaryKey
	 *
	 */

	@Transactional
	public Level findLevelByPrimaryKey(Integer levelId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findLevelByPrimaryKey", startResult, maxRows, levelId);
			return (wsdm.domain.Level) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findAllLevels
	 *
	 */
	@Transactional
	public Set<Level> findAllLevels() throws DataAccessException {

		return findAllLevels(-1, -1);
	}

	/**
	 * JPQL Query - findAllLevels
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Level> findAllLevels(int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAllLevels", startResult, maxRows);
		return new LinkedHashSet<Level>(query.getResultList());
	}

	/**
	 * Used to determine whether or not to merge the entity or persist the entity when calling Store
	 * @see store
	 * 
	 *
	 */
	public boolean canBeMerged(Level entity) {
		return true;
	}
}
