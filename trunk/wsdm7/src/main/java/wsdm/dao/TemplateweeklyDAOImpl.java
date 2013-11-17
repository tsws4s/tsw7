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

import wsdm.domain.Templateweekly;

/**
 * DAO to manage Templateweekly entities.
 * 
 */
@Repository("TemplateweeklyDAO")
@Transactional
public class TemplateweeklyDAOImpl extends AbstractJpaDao<Templateweekly>
		implements TemplateweeklyDAO {

	/**
	 * Set of entity classes managed by this DAO.  Typically a DAO manages a single entity.
	 *
	 */
	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[] { Templateweekly.class }));

	/**
	 * EntityManager injected by Spring for persistence unit mysql_tsw
	 *
	 */
	@PersistenceContext(unitName = "mysql_tsw")
	private EntityManager entityManager;

	/**
	 * Instantiates a new TemplateweeklyDAOImpl
	 *
	 */
	public TemplateweeklyDAOImpl() {
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
	 * JPQL Query - findTemplateweeklyBySatDailyFk
	 *
	 */
	@Transactional
	public Set<Templateweekly> findTemplateweeklyBySatDailyFk(Integer satDailyFk) throws DataAccessException {

		return findTemplateweeklyBySatDailyFk(satDailyFk, -1, -1);
	}

	/**
	 * JPQL Query - findTemplateweeklyBySatDailyFk
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Templateweekly> findTemplateweeklyBySatDailyFk(Integer satDailyFk, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTemplateweeklyBySatDailyFk", startResult, maxRows, satDailyFk);
		return new LinkedHashSet<Templateweekly>(query.getResultList());
	}

	/**
	 * JPQL Query - findTemplateweeklyByDescriptionContaining
	 *
	 */
	@Transactional
	public Set<Templateweekly> findTemplateweeklyByDescriptionContaining(String description) throws DataAccessException {

		return findTemplateweeklyByDescriptionContaining(description, -1, -1);
	}

	/**
	 * JPQL Query - findTemplateweeklyByDescriptionContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Templateweekly> findTemplateweeklyByDescriptionContaining(String description, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTemplateweeklyByDescriptionContaining", startResult, maxRows, description);
		return new LinkedHashSet<Templateweekly>(query.getResultList());
	}

	/**
	 * JPQL Query - findTemplateweeklyByTemplateNameContaining
	 *
	 */
	@Transactional
	public Set<Templateweekly> findTemplateweeklyByTemplateNameContaining(String templateName) throws DataAccessException {

		return findTemplateweeklyByTemplateNameContaining(templateName, -1, -1);
	}

	/**
	 * JPQL Query - findTemplateweeklyByTemplateNameContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Templateweekly> findTemplateweeklyByTemplateNameContaining(String templateName, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTemplateweeklyByTemplateNameContaining", startResult, maxRows, templateName);
		return new LinkedHashSet<Templateweekly>(query.getResultList());
	}

	/**
	 * JPQL Query - findAllTemplateweeklys
	 *
	 */
	@Transactional
	public Set<Templateweekly> findAllTemplateweeklys() throws DataAccessException {

		return findAllTemplateweeklys(-1, -1);
	}

	/**
	 * JPQL Query - findAllTemplateweeklys
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Templateweekly> findAllTemplateweeklys(int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAllTemplateweeklys", startResult, maxRows);
		return new LinkedHashSet<Templateweekly>(query.getResultList());
	}

	/**
	 * JPQL Query - findTemplateweeklyByTemplateName
	 *
	 */
	@Transactional
	public Set<Templateweekly> findTemplateweeklyByTemplateName(String templateName) throws DataAccessException {

		return findTemplateweeklyByTemplateName(templateName, -1, -1);
	}

	/**
	 * JPQL Query - findTemplateweeklyByTemplateName
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Templateweekly> findTemplateweeklyByTemplateName(String templateName, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTemplateweeklyByTemplateName", startResult, maxRows, templateName);
		return new LinkedHashSet<Templateweekly>(query.getResultList());
	}

	/**
	 * JPQL Query - findTemplateweeklyBySunDailyFk
	 *
	 */
	@Transactional
	public Set<Templateweekly> findTemplateweeklyBySunDailyFk(Integer sunDailyFk) throws DataAccessException {

		return findTemplateweeklyBySunDailyFk(sunDailyFk, -1, -1);
	}

	/**
	 * JPQL Query - findTemplateweeklyBySunDailyFk
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Templateweekly> findTemplateweeklyBySunDailyFk(Integer sunDailyFk, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTemplateweeklyBySunDailyFk", startResult, maxRows, sunDailyFk);
		return new LinkedHashSet<Templateweekly>(query.getResultList());
	}

	/**
	 * JPQL Query - findTemplateweeklyByDescription
	 *
	 */
	@Transactional
	public Set<Templateweekly> findTemplateweeklyByDescription(String description) throws DataAccessException {

		return findTemplateweeklyByDescription(description, -1, -1);
	}

	/**
	 * JPQL Query - findTemplateweeklyByDescription
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Templateweekly> findTemplateweeklyByDescription(String description, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTemplateweeklyByDescription", startResult, maxRows, description);
		return new LinkedHashSet<Templateweekly>(query.getResultList());
	}

	/**
	 * JPQL Query - findTemplateweeklyByFriDailyFk
	 *
	 */
	@Transactional
	public Set<Templateweekly> findTemplateweeklyByFriDailyFk(Integer friDailyFk) throws DataAccessException {

		return findTemplateweeklyByFriDailyFk(friDailyFk, -1, -1);
	}

	/**
	 * JPQL Query - findTemplateweeklyByFriDailyFk
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Templateweekly> findTemplateweeklyByFriDailyFk(Integer friDailyFk, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTemplateweeklyByFriDailyFk", startResult, maxRows, friDailyFk);
		return new LinkedHashSet<Templateweekly>(query.getResultList());
	}

	/**
	 * JPQL Query - findTemplateweeklyByWedDailyFk
	 *
	 */
	@Transactional
	public Set<Templateweekly> findTemplateweeklyByWedDailyFk(Integer wedDailyFk) throws DataAccessException {

		return findTemplateweeklyByWedDailyFk(wedDailyFk, -1, -1);
	}

	/**
	 * JPQL Query - findTemplateweeklyByWedDailyFk
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Templateweekly> findTemplateweeklyByWedDailyFk(Integer wedDailyFk, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTemplateweeklyByWedDailyFk", startResult, maxRows, wedDailyFk);
		return new LinkedHashSet<Templateweekly>(query.getResultList());
	}

	/**
	 * JPQL Query - findTemplateweeklyByThuDailyFk
	 *
	 */
	@Transactional
	public Set<Templateweekly> findTemplateweeklyByThuDailyFk(Integer thuDailyFk) throws DataAccessException {

		return findTemplateweeklyByThuDailyFk(thuDailyFk, -1, -1);
	}

	/**
	 * JPQL Query - findTemplateweeklyByThuDailyFk
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Templateweekly> findTemplateweeklyByThuDailyFk(Integer thuDailyFk, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTemplateweeklyByThuDailyFk", startResult, maxRows, thuDailyFk);
		return new LinkedHashSet<Templateweekly>(query.getResultList());
	}

	/**
	 * JPQL Query - findTemplateweeklyByMonDailyFk
	 *
	 */
	@Transactional
	public Set<Templateweekly> findTemplateweeklyByMonDailyFk(Integer monDailyFk) throws DataAccessException {

		return findTemplateweeklyByMonDailyFk(monDailyFk, -1, -1);
	}

	/**
	 * JPQL Query - findTemplateweeklyByMonDailyFk
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Templateweekly> findTemplateweeklyByMonDailyFk(Integer monDailyFk, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTemplateweeklyByMonDailyFk", startResult, maxRows, monDailyFk);
		return new LinkedHashSet<Templateweekly>(query.getResultList());
	}

	/**
	 * JPQL Query - findTemplateweeklyByTueDailyFk
	 *
	 */
	@Transactional
	public Set<Templateweekly> findTemplateweeklyByTueDailyFk(Integer tueDailyFk) throws DataAccessException {

		return findTemplateweeklyByTueDailyFk(tueDailyFk, -1, -1);
	}

	/**
	 * JPQL Query - findTemplateweeklyByTueDailyFk
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Templateweekly> findTemplateweeklyByTueDailyFk(Integer tueDailyFk, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTemplateweeklyByTueDailyFk", startResult, maxRows, tueDailyFk);
		return new LinkedHashSet<Templateweekly>(query.getResultList());
	}

	/**
	 * JPQL Query - findTemplateweeklyByWeeklyTemplateId
	 *
	 */
	@Transactional
	public Templateweekly findTemplateweeklyByWeeklyTemplateId(Integer weeklyTemplateId) throws DataAccessException {

		return findTemplateweeklyByWeeklyTemplateId(weeklyTemplateId, -1, -1);
	}

	/**
	 * JPQL Query - findTemplateweeklyByWeeklyTemplateId
	 *
	 */

	@Transactional
	public Templateweekly findTemplateweeklyByWeeklyTemplateId(Integer weeklyTemplateId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findTemplateweeklyByWeeklyTemplateId", startResult, maxRows, weeklyTemplateId);
			return (wsdm.domain.Templateweekly) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findTemplateweeklyByPrimaryKey
	 *
	 */
	@Transactional
	public Templateweekly findTemplateweeklyByPrimaryKey(Integer weeklyTemplateId) throws DataAccessException {

		return findTemplateweeklyByPrimaryKey(weeklyTemplateId, -1, -1);
	}

	/**
	 * JPQL Query - findTemplateweeklyByPrimaryKey
	 *
	 */

	@Transactional
	public Templateweekly findTemplateweeklyByPrimaryKey(Integer weeklyTemplateId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findTemplateweeklyByPrimaryKey", startResult, maxRows, weeklyTemplateId);
			return (wsdm.domain.Templateweekly) query.getSingleResult();
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
	public boolean canBeMerged(Templateweekly entity) {
		return true;
	}
}
