package wsdm.dao;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.skyway.spring.util.dao.AbstractJpaDao;

import org.springframework.stereotype.Repository;

import org.springframework.transaction.annotation.Transactional;

import wsdm.domain.Sportposition;

/**
 * DAO to manage Sportposition entities.
 * 
 */
@Repository("SportpositionDAO")
@Transactional
public class SportpositionDAOImpl extends AbstractJpaDao<Sportposition>
		implements SportpositionDAO {

	/**
	 * Set of entity classes managed by this DAO.  Typically a DAO manages a single entity.
	 *
	 */
	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[] { Sportposition.class }));

	/**
	 * EntityManager injected by Spring for persistence unit mysql_tsw
	 *
	 */
	@PersistenceContext(unitName = "mysql_tsw")
	private EntityManager entityManager;

	/**
	 * Instantiates a new SportpositionDAOImpl
	 *
	 */
	public SportpositionDAOImpl() {
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
	 * Used to determine whether or not to merge the entity or persist the entity when calling Store
	 * @see store
	 * 
	 *
	 */
	public boolean canBeMerged(Sportposition entity) {
		return true;
	}
}
