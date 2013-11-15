package tsw.dao;

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

import tsw.domain.Customer;
import tsw.domain.Tswacct;
import tsw.service.UsersController;

/**
 * DAO to manage Customer entities.
 * 
 */
@Repository("CustomerDAO")
@Transactional
public class CustomerDAOImpl extends AbstractJpaDao<Customer> implements
		CustomerDAO {
	
	int defaultMaxRows = UsersController.getDefaultMaxRows();

	/**
	 * Set of entity classes managed by this DAO.  Typically a DAO manages a single entity.
	 *
	 */
	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[] { Customer.class }));

	/**
	 * EntityManager injected by Spring for persistence unit tsws4s_4
	 *
	 */
	@PersistenceContext(unitName = "tsws4s_4")
	private EntityManager entityManager;

	/**
	 * Instantiates a new CustomerDAOImpl
	 *
	 */
	public CustomerDAOImpl() {
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
	 * JPQL Query - findAllCustomers
	 *
	 */
	@Transactional
	public Set<Customer> findAllCustomers4tsw(Integer tswId) throws DataAccessException {

		return findAllCustomers4tsw(tswId, -1, defaultMaxRows);
	}

	/**
	 * JPQL Query - findAllCustomers
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Customer> findAllCustomers(int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAllCustomers", startResult, maxRows);
		if(startResult>0){
			query.setFirstResult(startResult);
		}
		query.setMaxResults(maxRows);
		return new LinkedHashSet<Customer>(query.getResultList());
	}
		@SuppressWarnings("unchecked")
		@Transactional
		public Set<Customer> findAllCustomers4tsw(Integer tswId, int startResult, int maxRows) throws DataAccessException {
			Query query = createNamedQuery("findAllCustomers4tsw", startResult, maxRows, tswId);
			if(startResult>0){
				query.setFirstResult(startResult);
			}
			query.setMaxResults(maxRows);
			return new LinkedHashSet<Customer>(query.getResultList());
		}
		
		@Transactional
		public Customer findCustomerByName(Tswacct tswacct, String firstname, String lastname) throws DataAccessException {
			return findCustomerByName(tswacct, firstname, lastname, -1, defaultMaxRows);
		}
		@Transactional
		public Customer findCustomerByName(Tswacct tswacct, String firstname, String lastname, int startResult, int maxRows) throws DataAccessException {
			try {
				Query query = createNamedQuery("findCustomerByName", startResult, maxRows, tswacct.getTswAcctId(), firstname, lastname);
				return (tsw.domain.Customer) query.getSingleResult();
			} catch (NoResultException nre) {
				return null;
			}
		}
		
	/**
	 * JPQL Query - findCustomerByLastname
	 *
	 */
	@Transactional
	public Set<Customer> findCustomerByLastname(String lastname) throws DataAccessException {

		return findCustomerByLastname(lastname, -1, defaultMaxRows);
	}

	/**
	 * JPQL Query - findCustomerByLastname
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Customer> findCustomerByLastname(String lastname, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findCustomerByLastname", startResult, maxRows, lastname);
		return new LinkedHashSet<Customer>(query.getResultList());
	}

	/**
	 * JPQL Query - findCustomerByFirstname
	 *
	 */
	@Transactional
	public Set<Customer> findCustomerByFirstname(String firstname) throws DataAccessException {

		return findCustomerByFirstname(firstname, -1, defaultMaxRows);
	}

	/**
	 * JPQL Query - findCustomerByFirstname
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Customer> findCustomerByFirstname(String firstname, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findCustomerByFirstname", startResult, maxRows, firstname);
		return new LinkedHashSet<Customer>(query.getResultList());
	}

	/**
	 * JPQL Query - findCustomerByPhone
	 *
	 */
	@Transactional
	public Set<Customer> findCustomerByPhone(String phone) throws DataAccessException {

		return findCustomerByPhone(phone, -1, defaultMaxRows);
	}

	/**
	 * JPQL Query - findCustomerByPhone
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Customer> findCustomerByPhone(String phone, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findCustomerByPhone", startResult, maxRows, phone);
		return new LinkedHashSet<Customer>(query.getResultList());
	}

	/**
	 * JPQL Query - findCustomerByZipcodeContaining
	 *
	 */
	@Transactional
	public Set<Customer> findCustomerByZipcodeContaining(String zipcode) throws DataAccessException {

		return findCustomerByZipcodeContaining(zipcode, -1, defaultMaxRows);
	}

	/**
	 * JPQL Query - findCustomerByZipcodeContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Customer> findCustomerByZipcodeContaining(String zipcode, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findCustomerByZipcodeContaining", startResult, maxRows, zipcode);
		return new LinkedHashSet<Customer>(query.getResultList());
	}

	/**
	 * JPQL Query - findCustomerByEmailContaining
	 *
	 */
	@Transactional
	public Set<Customer> findCustomerByEmailContaining(String email) throws DataAccessException {

		return findCustomerByEmailContaining(email, -1, defaultMaxRows);
	}

	/**
	 * JPQL Query - findCustomerByEmailContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Customer> findCustomerByEmailContaining(String email, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findCustomerByEmailContaining", startResult, maxRows, email);
		return new LinkedHashSet<Customer>(query.getResultList());
	}

	/**
	 * JPQL Query - findCustomerByStateContaining
	 *
	 */
	@Transactional
	public Set<Customer> findCustomerByStateContaining(String state) throws DataAccessException {

		return findCustomerByStateContaining(state, -1, defaultMaxRows);
	}

	/**
	 * JPQL Query - findCustomerByStateContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Customer> findCustomerByStateContaining(String state, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findCustomerByStateContaining", startResult, maxRows, state);
		return new LinkedHashSet<Customer>(query.getResultList());
	}

	/**
	 * JPQL Query - findCustomerByCity
	 *
	 */
	@Transactional
	public Set<Customer> findCustomerByCity(String city) throws DataAccessException {

		return findCustomerByCity(city, -1, defaultMaxRows);
	}

	/**
	 * JPQL Query - findCustomerByCity
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Customer> findCustomerByCity(String city, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findCustomerByCity", startResult, maxRows, city);
		return new LinkedHashSet<Customer>(query.getResultList());
	}

	/**
	 * JPQL Query - findCustomerByYearBorn
	 *
	 */
	@Transactional
	public Set<Customer> findCustomerByYearBorn(Integer yearBorn) throws DataAccessException {

		return findCustomerByYearBorn(yearBorn, -1, defaultMaxRows);
	}

	/**
	 * JPQL Query - findCustomerByYearBorn
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Customer> findCustomerByYearBorn(Integer yearBorn, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findCustomerByYearBorn", startResult, maxRows, yearBorn);
		return new LinkedHashSet<Customer>(query.getResultList());
	}

	/**
	 * JPQL Query - findCustomerByLastnameContaining
	 *
	 */
	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Customer> findCustomerByLastnameContaining(String lastname) throws DataAccessException {
		Query query = createNamedQuery("findCustomerByLastnameContaining", -1, defaultMaxRows);
		return new LinkedHashSet<Customer>(query.getResultList());
	}

	/**
	 * JPQL Query - findCustomerByLastnameContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Customer> findCustomerByLastnameContaining4tsw(String lastname, int startResult, int maxRows, Integer tswId) throws DataAccessException {
		Query query = createNamedQuery("findCustomerByLastnameContaining4tsw", startResult, maxRows, lastname, tswId);
		return new LinkedHashSet<Customer>(query.getResultList());
	}

	/**
	 * JPQL Query - findCustomerByZipcode
	 *
	 */
	@Transactional
	public Set<Customer> findCustomerByZipcode(String zipcode) throws DataAccessException {

		return findCustomerByZipcode(zipcode, -1, defaultMaxRows);
	}

	/**
	 * JPQL Query - findCustomerByZipcode
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Customer> findCustomerByZipcode(String zipcode, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findCustomerByZipcode", startResult, maxRows, zipcode);
		return new LinkedHashSet<Customer>(query.getResultList());
	}

	/**
	 * JPQL Query - findCustomerByFirstnameContaining
	 *
	 */
	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Customer> findCustomerByFirstnameContaining(String firstname) throws DataAccessException {
		Query query = createNamedQuery("findCustomerByFirstnameContaining", -1, defaultMaxRows);
		return new LinkedHashSet<Customer>(query.getResultList());
	}

	/**
	 * JPQL Query - findCustomerByFirstnameContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Customer> findCustomerByFirstnameContaining4tsw(String firstname, int startResult, int maxRows, Integer tswId) throws DataAccessException {
		Query query = createNamedQuery("findCustomerByFirstnameContaining4tsw", startResult, maxRows, firstname, tswId);
		return new LinkedHashSet<Customer>(query.getResultList());
	}

	/**
	 * JPQL Query - findCustomerByState
	 *
	 */
	@Transactional
	public Set<Customer> findCustomerByState(String state) throws DataAccessException {

		return findCustomerByState(state, -1, defaultMaxRows);
	}

	/**
	 * JPQL Query - findCustomerByState
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Customer> findCustomerByState(String state, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findCustomerByState", startResult, maxRows, state);
		return new LinkedHashSet<Customer>(query.getResultList());
	}

	/**
	 * JPQL Query - findCustomerByEmail
	 *
	 */
	@Transactional
	public Set<Customer> findCustomerByEmail(String email) throws DataAccessException {

		return findCustomerByEmail(email, -1, defaultMaxRows);
	}

	/**
	 * JPQL Query - findCustomerByEmail
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Customer> findCustomerByEmail(String email, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findCustomerByEmail", startResult, maxRows, email);
		return new LinkedHashSet<Customer>(query.getResultList());
	}

	/**
	 * JPQL Query - findCustomerByPhoneContaining
	 *
	 */
	@Transactional
	public Set<Customer> findCustomerByPhoneContaining(String phone) throws DataAccessException {

		return findCustomerByPhoneContaining(phone, -1, defaultMaxRows);
	}

	/**
	 * JPQL Query - findCustomerByPhoneContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Customer> findCustomerByPhoneContaining(String phone, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findCustomerByPhoneContaining", startResult, maxRows, phone);
		return new LinkedHashSet<Customer>(query.getResultList());
	}

	/**
	 * JPQL Query - findCustomerByPrimaryKey
	 *
	 */
	@Transactional
	public Customer findCustomerByPrimaryKey(Integer customerId) throws DataAccessException {

		return findCustomerByPrimaryKey(customerId, -1, defaultMaxRows);
	}
	
	@Transactional
	public Customer findCustomerByEmailAddr(String email) throws DataAccessException {
		try {
			Query query = createNamedQuery("findCustomerByEmailAddr", -1, defaultMaxRows, email);
			return (tsw.domain.Customer) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}
	
	/**
	 * JPQL Query - findCustomerByPrimaryKey
	 *
	 */

	@Transactional
	public Customer findCustomerByPrimaryKey(Integer customerId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findCustomerByPrimaryKey", startResult, maxRows, customerId);
			return (tsw.domain.Customer) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findCustomerByCustomerId
	 *
	 */
	@Transactional
	public Customer findCustomerByCustomerId(Integer customerId) throws DataAccessException {

		return findCustomerByCustomerId(customerId, -1, defaultMaxRows);
	}

	/**
	 * JPQL Query - findCustomerByCustomerId
	 *
	 */

	@Transactional
	public Customer findCustomerByCustomerId(Integer customerId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findCustomerByCustomerId", startResult, maxRows, customerId);
			return (tsw.domain.Customer) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findCustomerByAddress
	 *
	 */
	@Transactional
	public Set<Customer> findCustomerByAddress(String address) throws DataAccessException {

		return findCustomerByAddress(address, -1, defaultMaxRows);
	}

	/**
	 * JPQL Query - findCustomerByAddress
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Customer> findCustomerByAddress(String address, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findCustomerByAddress", startResult, maxRows, address);
		return new LinkedHashSet<Customer>(query.getResultList());
	}

	/**
	 * JPQL Query - findCustomerByAddressContaining
	 *
	 */
	@Transactional
	public Set<Customer> findCustomerByAddressContaining(String address) throws DataAccessException {

		return findCustomerByAddressContaining(address, -1, defaultMaxRows);
	}

	/**
	 * JPQL Query - findCustomerByAddressContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Customer> findCustomerByAddressContaining(String address, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findCustomerByAddressContaining", startResult, maxRows, address);
		return new LinkedHashSet<Customer>(query.getResultList());
	}

	/**
	 * JPQL Query - findCustomerByCityContaining
	 *
	 */
	@Transactional
	public Set<Customer> findCustomerByCityContaining(String city) throws DataAccessException {

		return findCustomerByCityContaining(city, -1, defaultMaxRows);
	}

	/**
	 * JPQL Query - findCustomerByCityContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Customer> findCustomerByCityContaining(String city, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findCustomerByCityContaining", startResult, maxRows, city);
		return new LinkedHashSet<Customer>(query.getResultList());
	}

	/**
	 * Used to determine whether or not to merge the entity or persist the entity when calling Store
	 * @see store
	 * 
	 *
	 */
	public boolean canBeMerged(Customer entity) {
		return true;
	}

	@Override
	public Integer getMaxCustomerID() {
		Object obj = executeQuerySingleResult("select max(customerId) from Customer");
		return (Integer)obj;
	}
	
}
