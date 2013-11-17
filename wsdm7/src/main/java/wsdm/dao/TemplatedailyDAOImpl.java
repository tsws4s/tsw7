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

import wsdm.domain.Templatedaily;

/**
 * DAO to manage Templatedaily entities.
 * 
 */
@Repository("TemplatedailyDAO")
@Transactional
public class TemplatedailyDAOImpl extends AbstractJpaDao<Templatedaily>
		implements TemplatedailyDAO {

	/**
	 * Set of entity classes managed by this DAO.  Typically a DAO manages a single entity.
	 *
	 */
	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[] { Templatedaily.class }));

	/**
	 * EntityManager injected by Spring for persistence unit mysql_tsw
	 *
	 */
	@PersistenceContext(unitName = "mysql_tsw")
	private EntityManager entityManager;

	/**
	 * Instantiates a new TemplatedailyDAOImpl
	 *
	 */
	public TemplatedailyDAOImpl() {
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
	 * JPQL Query - findTemplatedailyByDescriptionContaining
	 *
	 */
	@Transactional
	public Set<Templatedaily> findTemplatedailyByDescriptionContaining(String description) throws DataAccessException {

		return findTemplatedailyByDescriptionContaining(description, -1, -1);
	}

	/**
	 * JPQL Query - findTemplatedailyByDescriptionContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Templatedaily> findTemplatedailyByDescriptionContaining(String description, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTemplatedailyByDescriptionContaining", startResult, maxRows, description);
		return new LinkedHashSet<Templatedaily>(query.getResultList());
	}

	/**
	 * JPQL Query - findTemplatedailyByTemplateNameContaining
	 *
	 */
	@Transactional
	public Set<Templatedaily> findTemplatedailyByTemplateNameContaining(String templateName) throws DataAccessException {

		return findTemplatedailyByTemplateNameContaining(templateName, -1, -1);
	}

	/**
	 * JPQL Query - findTemplatedailyByTemplateNameContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Templatedaily> findTemplatedailyByTemplateNameContaining(String templateName, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTemplatedailyByTemplateNameContaining", startResult, maxRows, templateName);
		return new LinkedHashSet<Templatedaily>(query.getResultList());
	}

	/**
	 * JPQL Query - findAllTemplatedailys
	 *
	 */
	@Transactional
	public Set<Templatedaily> findAllTemplatedailys() throws DataAccessException {

		return findAllTemplatedailys(-1, -1);
	}

	/**
	 * JPQL Query - findAllTemplatedailys
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Templatedaily> findAllTemplatedailys(int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAllTemplatedailys", startResult, maxRows);
		return new LinkedHashSet<Templatedaily>(query.getResultList());
	}

	/**
	 * JPQL Query - findTemplatedailyByTemplateName
	 *
	 */
	@Transactional
	public Set<Templatedaily> findTemplatedailyByTemplateName(String templateName) throws DataAccessException {

		return findTemplatedailyByTemplateName(templateName, -1, -1);
	}

	/**
	 * JPQL Query - findTemplatedailyByTemplateName
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Templatedaily> findTemplatedailyByTemplateName(String templateName, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTemplatedailyByTemplateName", startResult, maxRows, templateName);
		return new LinkedHashSet<Templatedaily>(query.getResultList());
	}

	/**
	 * JPQL Query - findTemplatedailyByDailyTemplateId
	 *
	 */
	@Transactional
	public Templatedaily findTemplatedailyByDailyTemplateId(Integer dailyTemplateId) throws DataAccessException {

		return findTemplatedailyByDailyTemplateId(dailyTemplateId, -1, -1);
	}

	/**
	 * JPQL Query - findTemplatedailyByDailyTemplateId
	 *
	 */

	@Transactional
	public Templatedaily findTemplatedailyByDailyTemplateId(Integer dailyTemplateId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findTemplatedailyByDailyTemplateId", startResult, maxRows, dailyTemplateId);
			return (wsdm.domain.Templatedaily) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findTemplatedailyByPrimaryKey
	 *
	 */
	@Transactional
	public Templatedaily findTemplatedailyByPrimaryKey(Integer dailyTemplateId) throws DataAccessException {

		return findTemplatedailyByPrimaryKey(dailyTemplateId, -1, -1);
	}

	/**
	 * JPQL Query - findTemplatedailyByPrimaryKey
	 *
	 */

	@Transactional
	public Templatedaily findTemplatedailyByPrimaryKey(Integer dailyTemplateId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findTemplatedailyByPrimaryKey", startResult, maxRows, dailyTemplateId);
			return (wsdm.domain.Templatedaily) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findTemplatedailyByNumTimeSlots
	 *
	 */
	@Transactional
	public Set<Templatedaily> findTemplatedailyByNumTimeSlots(Integer numTimeSlots) throws DataAccessException {

		return findTemplatedailyByNumTimeSlots(numTimeSlots, -1, -1);
	}

	/**
	 * JPQL Query - findTemplatedailyByNumTimeSlots
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Templatedaily> findTemplatedailyByNumTimeSlots(Integer numTimeSlots, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTemplatedailyByNumTimeSlots", startResult, maxRows, numTimeSlots);
		return new LinkedHashSet<Templatedaily>(query.getResultList());
	}

	/**
	 * JPQL Query - findTemplatedailyByDescription
	 *
	 */
	@Transactional
	public Set<Templatedaily> findTemplatedailyByDescription(String description) throws DataAccessException {

		return findTemplatedailyByDescription(description, -1, -1);
	}

	/**
	 * JPQL Query - findTemplatedailyByDescription
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Templatedaily> findTemplatedailyByDescription(String description, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTemplatedailyByDescription", startResult, maxRows, description);
		return new LinkedHashSet<Templatedaily>(query.getResultList());
	}

	/**
	 * Used to determine whether or not to merge the entity or persist the entity when calling Store
	 * @see store
	 * 
	 *
	 */
	public boolean canBeMerged(Templatedaily entity) {
		return true;
	}
}
