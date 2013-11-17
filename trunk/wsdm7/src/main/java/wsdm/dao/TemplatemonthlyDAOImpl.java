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

import wsdm.domain.Templatemonthly;

/**
 * DAO to manage Templatemonthly entities.
 * 
 */
@Repository("TemplatemonthlyDAO")
@Transactional
public class TemplatemonthlyDAOImpl extends AbstractJpaDao<Templatemonthly>
		implements TemplatemonthlyDAO {

	/**
	 * Set of entity classes managed by this DAO.  Typically a DAO manages a single entity.
	 *
	 */
	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[] { Templatemonthly.class }));

	/**
	 * EntityManager injected by Spring for persistence unit mysql_tsw
	 *
	 */
	@PersistenceContext(unitName = "mysql_tsw")
	private EntityManager entityManager;

	/**
	 * Instantiates a new TemplatemonthlyDAOImpl
	 *
	 */
	public TemplatemonthlyDAOImpl() {
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
	 * JPQL Query - findAllTemplatemonthlys
	 *
	 */
	@Transactional
	public Set<Templatemonthly> findAllTemplatemonthlys() throws DataAccessException {

		return findAllTemplatemonthlys(-1, -1);
	}

	/**
	 * JPQL Query - findAllTemplatemonthlys
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Templatemonthly> findAllTemplatemonthlys(int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAllTemplatemonthlys", startResult, maxRows);
		return new LinkedHashSet<Templatemonthly>(query.getResultList());
	}

	/**
	 * JPQL Query - findTemplatemonthlyByTemplateNameContaining
	 *
	 */
	@Transactional
	public Set<Templatemonthly> findTemplatemonthlyByTemplateNameContaining(String templateName) throws DataAccessException {

		return findTemplatemonthlyByTemplateNameContaining(templateName, -1, -1);
	}

	/**
	 * JPQL Query - findTemplatemonthlyByTemplateNameContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Templatemonthly> findTemplatemonthlyByTemplateNameContaining(String templateName, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTemplatemonthlyByTemplateNameContaining", startResult, maxRows, templateName);
		return new LinkedHashSet<Templatemonthly>(query.getResultList());
	}

	/**
	 * JPQL Query - findTemplatemonthlyByWeek2fk
	 *
	 */
	@Transactional
	public Set<Templatemonthly> findTemplatemonthlyByWeek2fk(Integer week2fk) throws DataAccessException {

		return findTemplatemonthlyByWeek2fk(week2fk, -1, -1);
	}

	/**
	 * JPQL Query - findTemplatemonthlyByWeek2fk
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Templatemonthly> findTemplatemonthlyByWeek2fk(Integer week2fk, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTemplatemonthlyByWeek2fk", startResult, maxRows, week2fk);
		return new LinkedHashSet<Templatemonthly>(query.getResultList());
	}

	/**
	 * JPQL Query - findTemplatemonthlyByDescription
	 *
	 */
	@Transactional
	public Set<Templatemonthly> findTemplatemonthlyByDescription(String description) throws DataAccessException {

		return findTemplatemonthlyByDescription(description, -1, -1);
	}

	/**
	 * JPQL Query - findTemplatemonthlyByDescription
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Templatemonthly> findTemplatemonthlyByDescription(String description, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTemplatemonthlyByDescription", startResult, maxRows, description);
		return new LinkedHashSet<Templatemonthly>(query.getResultList());
	}

	/**
	 * JPQL Query - findTemplatemonthlyByTemplateName
	 *
	 */
	@Transactional
	public Set<Templatemonthly> findTemplatemonthlyByTemplateName(String templateName) throws DataAccessException {

		return findTemplatemonthlyByTemplateName(templateName, -1, -1);
	}

	/**
	 * JPQL Query - findTemplatemonthlyByTemplateName
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Templatemonthly> findTemplatemonthlyByTemplateName(String templateName, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTemplatemonthlyByTemplateName", startResult, maxRows, templateName);
		return new LinkedHashSet<Templatemonthly>(query.getResultList());
	}

	/**
	 * JPQL Query - findTemplatemonthlyByWeek3fk
	 *
	 */
	@Transactional
	public Set<Templatemonthly> findTemplatemonthlyByWeek3fk(Integer week3fk) throws DataAccessException {

		return findTemplatemonthlyByWeek3fk(week3fk, -1, -1);
	}

	/**
	 * JPQL Query - findTemplatemonthlyByWeek3fk
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Templatemonthly> findTemplatemonthlyByWeek3fk(Integer week3fk, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTemplatemonthlyByWeek3fk", startResult, maxRows, week3fk);
		return new LinkedHashSet<Templatemonthly>(query.getResultList());
	}

	/**
	 * JPQL Query - findTemplatemonthlyByDescriptionContaining
	 *
	 */
	@Transactional
	public Set<Templatemonthly> findTemplatemonthlyByDescriptionContaining(String description) throws DataAccessException {

		return findTemplatemonthlyByDescriptionContaining(description, -1, -1);
	}

	/**
	 * JPQL Query - findTemplatemonthlyByDescriptionContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Templatemonthly> findTemplatemonthlyByDescriptionContaining(String description, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTemplatemonthlyByDescriptionContaining", startResult, maxRows, description);
		return new LinkedHashSet<Templatemonthly>(query.getResultList());
	}

	/**
	 * JPQL Query - findTemplatemonthlyByPrimaryKey
	 *
	 */
	@Transactional
	public Templatemonthly findTemplatemonthlyByPrimaryKey(Integer monthlyTemplateId) throws DataAccessException {

		return findTemplatemonthlyByPrimaryKey(monthlyTemplateId, -1, -1);
	}

	/**
	 * JPQL Query - findTemplatemonthlyByPrimaryKey
	 *
	 */

	@Transactional
	public Templatemonthly findTemplatemonthlyByPrimaryKey(Integer monthlyTemplateId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findTemplatemonthlyByPrimaryKey", startResult, maxRows, monthlyTemplateId);
			return (wsdm.domain.Templatemonthly) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findTemplatemonthlyByWeek4fk
	 *
	 */
	@Transactional
	public Set<Templatemonthly> findTemplatemonthlyByWeek4fk(Integer week4fk) throws DataAccessException {

		return findTemplatemonthlyByWeek4fk(week4fk, -1, -1);
	}

	/**
	 * JPQL Query - findTemplatemonthlyByWeek4fk
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Templatemonthly> findTemplatemonthlyByWeek4fk(Integer week4fk, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTemplatemonthlyByWeek4fk", startResult, maxRows, week4fk);
		return new LinkedHashSet<Templatemonthly>(query.getResultList());
	}

	/**
	 * JPQL Query - findTemplatemonthlyByWeek1fk
	 *
	 */
	@Transactional
	public Set<Templatemonthly> findTemplatemonthlyByWeek1fk(Integer week1fk) throws DataAccessException {

		return findTemplatemonthlyByWeek1fk(week1fk, -1, -1);
	}

	/**
	 * JPQL Query - findTemplatemonthlyByWeek1fk
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Templatemonthly> findTemplatemonthlyByWeek1fk(Integer week1fk, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTemplatemonthlyByWeek1fk", startResult, maxRows, week1fk);
		return new LinkedHashSet<Templatemonthly>(query.getResultList());
	}

	/**
	 * JPQL Query - findTemplatemonthlyByMonthlyTemplateId
	 *
	 */
	@Transactional
	public Templatemonthly findTemplatemonthlyByMonthlyTemplateId(Integer monthlyTemplateId) throws DataAccessException {

		return findTemplatemonthlyByMonthlyTemplateId(monthlyTemplateId, -1, -1);
	}

	/**
	 * JPQL Query - findTemplatemonthlyByMonthlyTemplateId
	 *
	 */

	@Transactional
	public Templatemonthly findTemplatemonthlyByMonthlyTemplateId(Integer monthlyTemplateId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findTemplatemonthlyByMonthlyTemplateId", startResult, maxRows, monthlyTemplateId);
			return (wsdm.domain.Templatemonthly) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findTemplatemonthlyByWeek5fk
	 *
	 */
	@Transactional
	public Set<Templatemonthly> findTemplatemonthlyByWeek5fk(Integer week5fk) throws DataAccessException {

		return findTemplatemonthlyByWeek5fk(week5fk, -1, -1);
	}

	/**
	 * JPQL Query - findTemplatemonthlyByWeek5fk
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Templatemonthly> findTemplatemonthlyByWeek5fk(Integer week5fk, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTemplatemonthlyByWeek5fk", startResult, maxRows, week5fk);
		return new LinkedHashSet<Templatemonthly>(query.getResultList());
	}

	/**
	 * Used to determine whether or not to merge the entity or persist the entity when calling Store
	 * @see store
	 * 
	 *
	 */
	public boolean canBeMerged(Templatemonthly entity) {
		return true;
	}
}
