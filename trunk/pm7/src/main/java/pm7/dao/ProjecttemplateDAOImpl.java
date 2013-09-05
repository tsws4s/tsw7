package pm7.dao;

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

import pm7.domain.Projecttemplate;

/**
 * DAO to manage Projecttemplate entities.
 * 
 */
@Repository("ProjecttemplateDAO")
@Transactional
public class ProjecttemplateDAOImpl extends AbstractJpaDao<Projecttemplate>
		implements ProjecttemplateDAO {

	/**
	 * Set of entity classes managed by this DAO.  Typically a DAO manages a single entity.
	 *
	 */
	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[] { Projecttemplate.class }));

	/**
	 * EntityManager injected by Spring for persistence unit mySql_pm7
	 *
	 */
	@PersistenceContext(unitName = "mySql_pm7")
	private EntityManager entityManager;

	/**
	 * Instantiates a new ProjecttemplateDAOImpl
	 *
	 */
	public ProjecttemplateDAOImpl() {
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
	 * JPQL Query - findProjecttemplateByTemplateName
	 *
	 */
	@Transactional
	public Set<Projecttemplate> findProjecttemplateByTemplateName(String templateName) throws DataAccessException {

		return findProjecttemplateByTemplateName(templateName, -1, -1);
	}

	/**
	 * JPQL Query - findProjecttemplateByTemplateName
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Projecttemplate> findProjecttemplateByTemplateName(String templateName, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findProjecttemplateByTemplateName", startResult, maxRows, templateName);
		return new LinkedHashSet<Projecttemplate>(query.getResultList());
	}

	/**
	 * JPQL Query - findProjecttemplateByPrimaryKey
	 *
	 */
	@Transactional
	public Projecttemplate findProjecttemplateByPrimaryKey(Integer templateId) throws DataAccessException {

		return findProjecttemplateByPrimaryKey(templateId, -1, -1);
	}

	/**
	 * JPQL Query - findProjecttemplateByPrimaryKey
	 *
	 */

	@Transactional
	public Projecttemplate findProjecttemplateByPrimaryKey(Integer templateId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findProjecttemplateByPrimaryKey", startResult, maxRows, templateId);
			return (pm7.domain.Projecttemplate) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findProjecttemplateByTemplateNameContaining
	 *
	 */
	@Transactional
	public Set<Projecttemplate> findProjecttemplateByTemplateNameContaining(String templateName) throws DataAccessException {

		return findProjecttemplateByTemplateNameContaining(templateName, -1, -1);
	}

	/**
	 * JPQL Query - findProjecttemplateByTemplateNameContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Projecttemplate> findProjecttemplateByTemplateNameContaining(String templateName, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findProjecttemplateByTemplateNameContaining", startResult, maxRows, templateName);
		return new LinkedHashSet<Projecttemplate>(query.getResultList());
	}

	/**
	 * JPQL Query - findProjecttemplateByTemplateId
	 *
	 */
	@Transactional
	public Projecttemplate findProjecttemplateByTemplateId(Integer templateId) throws DataAccessException {

		return findProjecttemplateByTemplateId(templateId, -1, -1);
	}

	/**
	 * JPQL Query - findProjecttemplateByTemplateId
	 *
	 */

	@Transactional
	public Projecttemplate findProjecttemplateByTemplateId(Integer templateId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findProjecttemplateByTemplateId", startResult, maxRows, templateId);
			return (pm7.domain.Projecttemplate) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findProjecttemplateByTemplateDesc
	 *
	 */
	@Transactional
	public Set<Projecttemplate> findProjecttemplateByTemplateDesc(String templateDesc) throws DataAccessException {

		return findProjecttemplateByTemplateDesc(templateDesc, -1, -1);
	}

	/**
	 * JPQL Query - findProjecttemplateByTemplateDesc
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Projecttemplate> findProjecttemplateByTemplateDesc(String templateDesc, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findProjecttemplateByTemplateDesc", startResult, maxRows, templateDesc);
		return new LinkedHashSet<Projecttemplate>(query.getResultList());
	}

	/**
	 * JPQL Query - findProjecttemplateByTemplateDescContaining
	 *
	 */
	@Transactional
	public Set<Projecttemplate> findProjecttemplateByTemplateDescContaining(String templateDesc) throws DataAccessException {

		return findProjecttemplateByTemplateDescContaining(templateDesc, -1, -1);
	}

	/**
	 * JPQL Query - findProjecttemplateByTemplateDescContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Projecttemplate> findProjecttemplateByTemplateDescContaining(String templateDesc, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findProjecttemplateByTemplateDescContaining", startResult, maxRows, templateDesc);
		return new LinkedHashSet<Projecttemplate>(query.getResultList());
	}

	/**
	 * JPQL Query - findProjecttemplateByActiveYn
	 *
	 */
	@Transactional
	public Set<Projecttemplate> findProjecttemplateByActiveYn(Integer activeYn) throws DataAccessException {

		return findProjecttemplateByActiveYn(activeYn, -1, -1);
	}

	/**
	 * JPQL Query - findProjecttemplateByActiveYn
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Projecttemplate> findProjecttemplateByActiveYn(Integer activeYn, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findProjecttemplateByActiveYn", startResult, maxRows, activeYn);
		return new LinkedHashSet<Projecttemplate>(query.getResultList());
	}

	/**
	 * JPQL Query - findAllProjecttemplates
	 *
	 */
	@Transactional
	public Set<Projecttemplate> findAllProjecttemplates() throws DataAccessException {

		return findAllProjecttemplates(-1, -1);
	}

	/**
	 * JPQL Query - findAllProjecttemplates
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Projecttemplate> findAllProjecttemplates(int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAllProjecttemplates", startResult, maxRows);
		return new LinkedHashSet<Projecttemplate>(query.getResultList());
	}

	/**
	 * Used to determine whether or not to merge the entity or persist the entity when calling Store
	 * @see store
	 * 
	 *
	 */
	public boolean canBeMerged(Projecttemplate entity) {
		return true;
	}
	
	public Integer getMaxProjecttemplateId() {
		Object obj = executeQuerySingleResult("select max(projectTemplateId) from Projecttemplate");
		if(obj!=null){
			return (Integer)obj;
		}
		return 0;
	}
}
