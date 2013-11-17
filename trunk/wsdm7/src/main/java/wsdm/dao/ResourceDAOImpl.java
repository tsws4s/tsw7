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

import wsdm.domain.Resource;

/**
 * DAO to manage Resource entities.
 * 
 */
@Repository("ResourceDAO")
@Transactional
public class ResourceDAOImpl extends AbstractJpaDao<Resource> implements
		ResourceDAO {

	/**
	 * Set of entity classes managed by this DAO.  Typically a DAO manages a single entity.
	 *
	 */
	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[] { Resource.class }));

	/**
	 * EntityManager injected by Spring for persistence unit mysql_tsw
	 *
	 */
	@PersistenceContext(unitName = "mysql_tsw")
	private EntityManager entityManager;

	/**
	 * Instantiates a new ResourceDAOImpl
	 *
	 */
	public ResourceDAOImpl() {
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
	 * JPQL Query - findResourceByState
	 *
	 */
	@Transactional
	public Set<Resource> findResourceByState(String state) throws DataAccessException {

		return findResourceByState(state, -1, -1);
	}

	/**
	 * JPQL Query - findResourceByState
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Resource> findResourceByState(String state, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findResourceByState", startResult, maxRows, state);
		return new LinkedHashSet<Resource>(query.getResultList());
	}

	/**
	 * JPQL Query - findResourceByNotesContaining
	 *
	 */
	@Transactional
	public Set<Resource> findResourceByNotesContaining(String notes) throws DataAccessException {

		return findResourceByNotesContaining(notes, -1, -1);
	}

	/**
	 * JPQL Query - findResourceByNotesContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Resource> findResourceByNotesContaining(String notes, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findResourceByNotesContaining", startResult, maxRows, notes);
		return new LinkedHashSet<Resource>(query.getResultList());
	}

	/**
	 * JPQL Query - findResourceByPhoneContaining
	 *
	 */
	@Transactional
	public Set<Resource> findResourceByPhoneContaining(String phone) throws DataAccessException {

		return findResourceByPhoneContaining(phone, -1, -1);
	}

	/**
	 * JPQL Query - findResourceByPhoneContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Resource> findResourceByPhoneContaining(String phone, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findResourceByPhoneContaining", startResult, maxRows, phone);
		return new LinkedHashSet<Resource>(query.getResultList());
	}

	/**
	 * JPQL Query - findResourceByPrimaryKey
	 *
	 */
	@Transactional
	public Resource findResourceByPrimaryKey(Integer resourceId) throws DataAccessException {

		return findResourceByPrimaryKey(resourceId, -1, -1);
	}

	/**
	 * JPQL Query - findResourceByPrimaryKey
	 *
	 */

	@Transactional
	public Resource findResourceByPrimaryKey(Integer resourceId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findResourceByPrimaryKey", startResult, maxRows, resourceId);
			return (wsdm.domain.Resource) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findResourceByAddress
	 *
	 */
	@Transactional
	public Set<Resource> findResourceByAddress(String address) throws DataAccessException {

		return findResourceByAddress(address, -1, -1);
	}

	/**
	 * JPQL Query - findResourceByAddress
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Resource> findResourceByAddress(String address, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findResourceByAddress", startResult, maxRows, address);
		return new LinkedHashSet<Resource>(query.getResultList());
	}

	/**
	 * JPQL Query - findResourceByEmail
	 *
	 */
	@Transactional
	public Set<Resource> findResourceByEmail(String email) throws DataAccessException {

		return findResourceByEmail(email, -1, -1);
	}

	/**
	 * JPQL Query - findResourceByEmail
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Resource> findResourceByEmail(String email, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findResourceByEmail", startResult, maxRows, email);
		return new LinkedHashSet<Resource>(query.getResultList());
	}

	/**
	 * JPQL Query - findResourceByResourceId
	 *
	 */
	@Transactional
	public Resource findResourceByResourceId(Integer resourceId) throws DataAccessException {

		return findResourceByResourceId(resourceId, -1, -1);
	}

	/**
	 * JPQL Query - findResourceByResourceId
	 *
	 */

	@Transactional
	public Resource findResourceByResourceId(Integer resourceId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findResourceByResourceId", startResult, maxRows, resourceId);
			return (wsdm.domain.Resource) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findResourceByPhone
	 *
	 */
	@Transactional
	public Set<Resource> findResourceByPhone(String phone) throws DataAccessException {

		return findResourceByPhone(phone, -1, -1);
	}

	/**
	 * JPQL Query - findResourceByPhone
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Resource> findResourceByPhone(String phone, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findResourceByPhone", startResult, maxRows, phone);
		return new LinkedHashSet<Resource>(query.getResultList());
	}

	/**
	 * JPQL Query - findResourceByCity
	 *
	 */
	@Transactional
	public Set<Resource> findResourceByCity(String city) throws DataAccessException {

		return findResourceByCity(city, -1, -1);
	}

	/**
	 * JPQL Query - findResourceByCity
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Resource> findResourceByCity(String city, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findResourceByCity", startResult, maxRows, city);
		return new LinkedHashSet<Resource>(query.getResultList());
	}

	/**
	 * JPQL Query - findResourceByStateContaining
	 *
	 */
	@Transactional
	public Set<Resource> findResourceByStateContaining(String state) throws DataAccessException {

		return findResourceByStateContaining(state, -1, -1);
	}

	/**
	 * JPQL Query - findResourceByStateContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Resource> findResourceByStateContaining(String state, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findResourceByStateContaining", startResult, maxRows, state);
		return new LinkedHashSet<Resource>(query.getResultList());
	}

	/**
	 * JPQL Query - findResourceByResourceNameContaining
	 *
	 */
	@Transactional
	public Set<Resource> findResourceByResourceNameContaining(String resourceName) throws DataAccessException {

		return findResourceByResourceNameContaining(resourceName, -1, -1);
	}

	/**
	 * JPQL Query - findResourceByResourceNameContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Resource> findResourceByResourceNameContaining(String resourceName, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findResourceByResourceNameContaining", startResult, maxRows, resourceName);
		return new LinkedHashSet<Resource>(query.getResultList());
	}

	/**
	 * JPQL Query - findResourceByResourceName
	 *
	 */
	@Transactional
	public Set<Resource> findResourceByResourceName(String resourceName) throws DataAccessException {

		return findResourceByResourceName(resourceName, -1, -1);
	}

	/**
	 * JPQL Query - findResourceByResourceName
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Resource> findResourceByResourceName(String resourceName, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findResourceByResourceName", startResult, maxRows, resourceName);
		return new LinkedHashSet<Resource>(query.getResultList());
	}

	/**
	 * JPQL Query - findResourceByZipcodeContaining
	 *
	 */
	@Transactional
	public Set<Resource> findResourceByZipcodeContaining(String zipcode) throws DataAccessException {

		return findResourceByZipcodeContaining(zipcode, -1, -1);
	}

	/**
	 * JPQL Query - findResourceByZipcodeContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Resource> findResourceByZipcodeContaining(String zipcode, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findResourceByZipcodeContaining", startResult, maxRows, zipcode);
		return new LinkedHashSet<Resource>(query.getResultList());
	}

	/**
	 * JPQL Query - findResourceByResourceTypeContaining
	 *
	 */
	@Transactional
	public Set<Resource> findResourceByResourceTypeContaining(String resourceType) throws DataAccessException {

		return findResourceByResourceTypeContaining(resourceType, -1, -1);
	}

	/**
	 * JPQL Query - findResourceByResourceTypeContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Resource> findResourceByResourceTypeContaining(String resourceType, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findResourceByResourceTypeContaining", startResult, maxRows, resourceType);
		return new LinkedHashSet<Resource>(query.getResultList());
	}

	/**
	 * JPQL Query - findAllResources
	 *
	 */
	@Transactional
	public Set<Resource> findAllResources() throws DataAccessException {

		return findAllResources(-1, -1);
	}

	/**
	 * JPQL Query - findAllResources
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Resource> findAllResources(int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAllResources", startResult, maxRows);
		return new LinkedHashSet<Resource>(query.getResultList());
	}

	/**
	 * JPQL Query - findResourceByActiveYn
	 *
	 */
	@Transactional
	public Set<Resource> findResourceByActiveYn(Integer activeYn) throws DataAccessException {

		return findResourceByActiveYn(activeYn, -1, -1);
	}

	/**
	 * JPQL Query - findResourceByActiveYn
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Resource> findResourceByActiveYn(Integer activeYn, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findResourceByActiveYn", startResult, maxRows, activeYn);
		return new LinkedHashSet<Resource>(query.getResultList());
	}

	/**
	 * JPQL Query - findResourceByNotes
	 *
	 */
	@Transactional
	public Set<Resource> findResourceByNotes(String notes) throws DataAccessException {

		return findResourceByNotes(notes, -1, -1);
	}

	/**
	 * JPQL Query - findResourceByNotes
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Resource> findResourceByNotes(String notes, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findResourceByNotes", startResult, maxRows, notes);
		return new LinkedHashSet<Resource>(query.getResultList());
	}

	/**
	 * JPQL Query - findResourceByResourceType
	 *
	 */
	@Transactional
	public Set<Resource> findResourceByResourceType(String resourceType) throws DataAccessException {

		return findResourceByResourceType(resourceType, -1, -1);
	}

	/**
	 * JPQL Query - findResourceByResourceType
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Resource> findResourceByResourceType(String resourceType, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findResourceByResourceType", startResult, maxRows, resourceType);
		return new LinkedHashSet<Resource>(query.getResultList());
	}

	/**
	 * JPQL Query - findResourceByEmailContaining
	 *
	 */
	@Transactional
	public Set<Resource> findResourceByEmailContaining(String email) throws DataAccessException {

		return findResourceByEmailContaining(email, -1, -1);
	}

	/**
	 * JPQL Query - findResourceByEmailContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Resource> findResourceByEmailContaining(String email, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findResourceByEmailContaining", startResult, maxRows, email);
		return new LinkedHashSet<Resource>(query.getResultList());
	}

	/**
	 * JPQL Query - findResourceByAddressContaining
	 *
	 */
	@Transactional
	public Set<Resource> findResourceByAddressContaining(String address) throws DataAccessException {

		return findResourceByAddressContaining(address, -1, -1);
	}

	/**
	 * JPQL Query - findResourceByAddressContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Resource> findResourceByAddressContaining(String address, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findResourceByAddressContaining", startResult, maxRows, address);
		return new LinkedHashSet<Resource>(query.getResultList());
	}

	/**
	 * JPQL Query - findResourceByZipcode
	 *
	 */
	@Transactional
	public Set<Resource> findResourceByZipcode(String zipcode) throws DataAccessException {

		return findResourceByZipcode(zipcode, -1, -1);
	}

	/**
	 * JPQL Query - findResourceByZipcode
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Resource> findResourceByZipcode(String zipcode, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findResourceByZipcode", startResult, maxRows, zipcode);
		return new LinkedHashSet<Resource>(query.getResultList());
	}

	/**
	 * JPQL Query - findResourceByCityContaining
	 *
	 */
	@Transactional
	public Set<Resource> findResourceByCityContaining(String city) throws DataAccessException {

		return findResourceByCityContaining(city, -1, -1);
	}

	/**
	 * JPQL Query - findResourceByCityContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Resource> findResourceByCityContaining(String city, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findResourceByCityContaining", startResult, maxRows, city);
		return new LinkedHashSet<Resource>(query.getResultList());
	}

	/**
	 * Used to determine whether or not to merge the entity or persist the entity when calling Store
	 * @see store
	 * 
	 *
	 */
	public boolean canBeMerged(Resource entity) {
		return true;
	}
}
