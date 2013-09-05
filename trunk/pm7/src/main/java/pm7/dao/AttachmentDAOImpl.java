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

import pm7.domain.Attachment;

/**
 * DAO to manage Attachment entities.
 * 
 */
@Repository("AttachmentDAO")
@Transactional
public class AttachmentDAOImpl extends AbstractJpaDao<Attachment> implements
		AttachmentDAO {

	/**
	 * Set of entity classes managed by this DAO.  Typically a DAO manages a single entity.
	 *
	 */
	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[] { Attachment.class }));

	/**
	 * EntityManager injected by Spring for persistence unit mySql_pm7
	 *
	 */
	@PersistenceContext(unitName = "mySql_pm7")
	private EntityManager entityManager;

	/**
	 * Instantiates a new AttachmentDAOImpl
	 *
	 */
	public AttachmentDAOImpl() {
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
	 * JPQL Query - findAllAttachments
	 *
	 */
	@Transactional
	public Set<Attachment> findAllAttachments() throws DataAccessException {

		return findAllAttachments(-1, -1);
	}

	/**
	 * JPQL Query - findAllAttachments
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Attachment> findAllAttachments(int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAllAttachments", startResult, maxRows);
		return new LinkedHashSet<Attachment>(query.getResultList());
	}

	/**
	 * JPQL Query - findAttachmentByAttachmentType
	 *
	 */
	@Transactional
	public Set<Attachment> findAttachmentByAttachmentType(String attachmentType) throws DataAccessException {

		return findAttachmentByAttachmentType(attachmentType, -1, -1);
	}

	/**
	 * JPQL Query - findAttachmentByAttachmentType
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Attachment> findAttachmentByAttachmentType(String attachmentType, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAttachmentByAttachmentType", startResult, maxRows, attachmentType);
		return new LinkedHashSet<Attachment>(query.getResultList());
	}

	/**
	 * JPQL Query - findAttachmentByAttachmentTypeContaining
	 *
	 */
	@Transactional
	public Set<Attachment> findAttachmentByAttachmentTypeContaining(String attachmentType) throws DataAccessException {

		return findAttachmentByAttachmentTypeContaining(attachmentType, -1, -1);
	}

	/**
	 * JPQL Query - findAttachmentByAttachmentTypeContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Attachment> findAttachmentByAttachmentTypeContaining(String attachmentType, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAttachmentByAttachmentTypeContaining", startResult, maxRows, attachmentType);
		return new LinkedHashSet<Attachment>(query.getResultList());
	}

	/**
	 * JPQL Query - findAttachmentByAttachId
	 *
	 */
	@Transactional
	public Attachment findAttachmentByAttachId(Integer attachId) throws DataAccessException {

		return findAttachmentByAttachId(attachId, -1, -1);
	}

	/**
	 * JPQL Query - findAttachmentByAttachId
	 *
	 */

	@Transactional
	public Attachment findAttachmentByAttachId(Integer attachId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findAttachmentByAttachId", startResult, maxRows, attachId);
			return (pm7.domain.Attachment) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findAttachmentByAttachmentUrl
	 *
	 */
	@Transactional
	public Set<Attachment> findAttachmentByAttachmentUrl(String attachmentUrl) throws DataAccessException {

		return findAttachmentByAttachmentUrl(attachmentUrl, -1, -1);
	}

	/**
	 * JPQL Query - findAttachmentByAttachmentUrl
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Attachment> findAttachmentByAttachmentUrl(String attachmentUrl, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAttachmentByAttachmentUrl", startResult, maxRows, attachmentUrl);
		return new LinkedHashSet<Attachment>(query.getResultList());
	}

	/**
	 * JPQL Query - findAttachmentByPrimaryKey
	 *
	 */
	@Transactional
	public Attachment findAttachmentByPrimaryKey(Integer attachId) throws DataAccessException {

		return findAttachmentByPrimaryKey(attachId, -1, -1);
	}

	/**
	 * JPQL Query - findAttachmentByPrimaryKey
	 *
	 */

	@Transactional
	public Attachment findAttachmentByPrimaryKey(Integer attachId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findAttachmentByPrimaryKey", startResult, maxRows, attachId);
			return (pm7.domain.Attachment) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findAttachmentByAttachmentUrlContaining
	 *
	 */
	@Transactional
	public Set<Attachment> findAttachmentByAttachmentUrlContaining(String attachmentUrl) throws DataAccessException {

		return findAttachmentByAttachmentUrlContaining(attachmentUrl, -1, -1);
	}

	/**
	 * JPQL Query - findAttachmentByAttachmentUrlContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Attachment> findAttachmentByAttachmentUrlContaining(String attachmentUrl, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAttachmentByAttachmentUrlContaining", startResult, maxRows, attachmentUrl);
		return new LinkedHashSet<Attachment>(query.getResultList());
	}

	/**
	 * Used to determine whether or not to merge the entity or persist the entity when calling Store
	 * @see store
	 * 
	 *
	 */
	public boolean canBeMerged(Attachment entity) {
		return true;
	}
	
	public Integer getMaxAttachmentId() {
		Object obj = executeQuerySingleResult("select max(attachmentId) from Attachment");
		if(obj!=null){
			return (Integer)obj;
		}
		return 0;
	}
}
