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

import wsdm.domain.Customer;

/**
 * DAO to manage Customer entities.
 * 
 */
@Repository("CustomerDAO")
@Transactional
public class CustomerDAOImpl extends AbstractJpaDao<Customer> implements
		CustomerDAO {

	/**
	 * Set of entity classes managed by this DAO.  Typically a DAO manages a single entity.
	 *
	 */
	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[] { Customer.class }));

	/**
	 * EntityManager injected by Spring for persistence unit mysql_tsw
	 *
	 */
	@PersistenceContext(unitName = "mysql_tsw")
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
	 * JPQL Query - findCustomerByLastnameContaining
	 *
	 */
	@Transactional
	public Set<Customer> findCustomerByLastnameContaining(String lastname) throws DataAccessException {

		return findCustomerByLastnameContaining(lastname, -1, -1);
	}

	/**
	 * JPQL Query - findCustomerByLastnameContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Customer> findCustomerByLastnameContaining(String lastname, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findCustomerByLastnameContaining", startResult, maxRows, lastname);
		return new LinkedHashSet<Customer>(query.getResultList());
	}

	/**
	 * JPQL Query - findCustomerByYearBorn
	 *
	 */
	@Transactional
	public Set<Customer> findCustomerByYearBorn(Integer yearBorn) throws DataAccessException {

		return findCustomerByYearBorn(yearBorn, -1, -1);
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
	 * JPQL Query - findCustomerByCustomerId
	 *
	 */
	@Transactional
	public Customer findCustomerByCustomerId(Integer customerId) throws DataAccessException {

		return findCustomerByCustomerId(customerId, -1, -1);
	}

	/**
	 * JPQL Query - findCustomerByCustomerId
	 *
	 */

	@Transactional
	public Customer findCustomerByCustomerId(Integer customerId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findCustomerByCustomerId", startResult, maxRows, customerId);
			return (wsdm.domain.Customer) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findCustomerByZipcodeContaining
	 *
	 */
	@Transactional
	public Set<Customer> findCustomerByZipcodeContaining(String zipcode) throws DataAccessException {

		return findCustomerByZipcodeContaining(zipcode, -1, -1);
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
	 * JPQL Query - findCustomerByPhone
	 *
	 */
	@Transactional
	public Set<Customer> findCustomerByPhone(String phone) throws DataAccessException {

		return findCustomerByPhone(phone, -1, -1);
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
	 * JPQL Query - findCustomerByCityContaining
	 *
	 */
	@Transactional
	public Set<Customer> findCustomerByCityContaining(String city) throws DataAccessException {

		return findCustomerByCityContaining(city, -1, -1);
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
	 * JPQL Query - findCustomerByAddress
	 *
	 */
	@Transactional
	public Set<Customer> findCustomerByAddress(String address) throws DataAccessException {

		return findCustomerByAddress(address, -1, -1);
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
	 * JPQL Query - findCustomerByPasswordContaining
	 *
	 */
	@Transactional
	public Set<Customer> findCustomerByPasswordContaining(String password) throws DataAccessException {

		return findCustomerByPasswordContaining(password, -1, -1);
	}

	/**
	 * JPQL Query - findCustomerByPasswordContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Customer> findCustomerByPasswordContaining(String password, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findCustomerByPasswordContaining", startResult, maxRows, password);
		return new LinkedHashSet<Customer>(query.getResultList());
	}

	/**
	 * JPQL Query - findCustomerByFirstnameContaining
	 *
	 */
	@Transactional
	public Set<Customer> findCustomerByFirstnameContaining(String firstname) throws DataAccessException {

		return findCustomerByFirstnameContaining(firstname, -1, -1);
	}

	/**
	 * JPQL Query - findCustomerByFirstnameContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Customer> findCustomerByFirstnameContaining(String firstname, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findCustomerByFirstnameContaining", startResult, maxRows, firstname);
		return new LinkedHashSet<Customer>(query.getResultList());
	}

	/**
	 * JPQL Query - findCustomerByPhoneContaining
	 *
	 */
	@Transactional
	public Set<Customer> findCustomerByPhoneContaining(String phone) throws DataAccessException {

		return findCustomerByPhoneContaining(phone, -1, -1);
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
	 * JPQL Query - findCustomerByEmail
	 *
	 */
	@Transactional
	public Set<Customer> findCustomerByEmail(String email) throws DataAccessException {

		return findCustomerByEmail(email, -1, -1);
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
	 * JPQL Query - findCustomerByCity
	 *
	 */
	@Transactional
	public Set<Customer> findCustomerByCity(String city) throws DataAccessException {

		return findCustomerByCity(city, -1, -1);
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
	 * JPQL Query - findCustomerByLastname
	 *
	 */
	@Transactional
	public Set<Customer> findCustomerByLastname(String lastname) throws DataAccessException {

		return findCustomerByLastname(lastname, -1, -1);
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

		return findCustomerByFirstname(firstname, -1, -1);
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
	 * JPQL Query - findCustomerByState
	 *
	 */
	@Transactional
	public Set<Customer> findCustomerByState(String state) throws DataAccessException {

		return findCustomerByState(state, -1, -1);
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
	 * JPQL Query - findCustomerBySelectTheme
	 *
	 */
	@Transactional
	public Set<Customer> findCustomerBySelectTheme(String selectTheme) throws DataAccessException {

		return findCustomerBySelectTheme(selectTheme, -1, -1);
	}

	/**
	 * JPQL Query - findCustomerBySelectTheme
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Customer> findCustomerBySelectTheme(String selectTheme, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findCustomerBySelectTheme", startResult, maxRows, selectTheme);
		return new LinkedHashSet<Customer>(query.getResultList());
	}

	/**
	 * JPQL Query - findCustomerByStateContaining
	 *
	 */
	@Transactional
	public Set<Customer> findCustomerByStateContaining(String state) throws DataAccessException {

		return findCustomerByStateContaining(state, -1, -1);
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
	 * JPQL Query - findCustomerByEmailContaining
	 *
	 */
	@Transactional
	public Set<Customer> findCustomerByEmailContaining(String email) throws DataAccessException {

		return findCustomerByEmailContaining(email, -1, -1);
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
	 * JPQL Query - findCustomerByActiveYn
	 *
	 */
	@Transactional
	public Set<Customer> findCustomerByActiveYn(Integer activeYn) throws DataAccessException {

		return findCustomerByActiveYn(activeYn, -1, -1);
	}

	/**
	 * JPQL Query - findCustomerByActiveYn
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Customer> findCustomerByActiveYn(Integer activeYn, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findCustomerByActiveYn", startResult, maxRows, activeYn);
		return new LinkedHashSet<Customer>(query.getResultList());
	}

	/**
	 * JPQL Query - findCustomerByAddrSameAsFamily
	 *
	 */
	@Transactional
	public Set<Customer> findCustomerByAddrSameAsFamily(Integer addrSameAsFamily) throws DataAccessException {

		return findCustomerByAddrSameAsFamily(addrSameAsFamily, -1, -1);
	}

	/**
	 * JPQL Query - findCustomerByAddrSameAsFamily
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Customer> findCustomerByAddrSameAsFamily(Integer addrSameAsFamily, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findCustomerByAddrSameAsFamily", startResult, maxRows, addrSameAsFamily);
		return new LinkedHashSet<Customer>(query.getResultList());
	}

	/**
	 * JPQL Query - findCustomerByPrimaryKey
	 *
	 */
	@Transactional
	public Customer findCustomerByPrimaryKey(Integer customerId) throws DataAccessException {

		return findCustomerByPrimaryKey(customerId, -1, -1);
	}

	/**
	 * JPQL Query - findCustomerByPrimaryKey
	 *
	 */

	@Transactional
	public Customer findCustomerByPrimaryKey(Integer customerId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findCustomerByPrimaryKey", startResult, maxRows, customerId);
			return (wsdm.domain.Customer) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findAllCustomers
	 *
	 */
	@Transactional
	public Set<Customer> findAllCustomers() throws DataAccessException {

		return findAllCustomers(-1, -1);
	}

	/**
	 * JPQL Query - findAllCustomers
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Customer> findAllCustomers(int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAllCustomers", startResult, maxRows);
		return new LinkedHashSet<Customer>(query.getResultList());
	}

	/**
	 * JPQL Query - findCustomerByAdminYn
	 *
	 */
	@Transactional
	public Set<Customer> findCustomerByAdminYn(Integer adminYn) throws DataAccessException {

		return findCustomerByAdminYn(adminYn, -1, -1);
	}

	/**
	 * JPQL Query - findCustomerByAdminYn
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Customer> findCustomerByAdminYn(Integer adminYn, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findCustomerByAdminYn", startResult, maxRows, adminYn);
		return new LinkedHashSet<Customer>(query.getResultList());
	}

	/**
	 * JPQL Query - findCustomerByPassword
	 *
	 */
	@Transactional
	public Set<Customer> findCustomerByPassword(String password) throws DataAccessException {

		return findCustomerByPassword(password, -1, -1);
	}

	/**
	 * JPQL Query - findCustomerByPassword
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Customer> findCustomerByPassword(String password, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findCustomerByPassword", startResult, maxRows, password);
		return new LinkedHashSet<Customer>(query.getResultList());
	}

	/**
	 * JPQL Query - findCustomerByAddressContaining
	 *
	 */
	@Transactional
	public Set<Customer> findCustomerByAddressContaining(String address) throws DataAccessException {

		return findCustomerByAddressContaining(address, -1, -1);
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
	 * JPQL Query - findCustomerByZipcode
	 *
	 */
	@Transactional
	public Set<Customer> findCustomerByZipcode(String zipcode) throws DataAccessException {

		return findCustomerByZipcode(zipcode, -1, -1);
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
	 * JPQL Query - findCustomerBySelectThemeContaining
	 *
	 */
	@Transactional
	public Set<Customer> findCustomerBySelectThemeContaining(String selectTheme) throws DataAccessException {

		return findCustomerBySelectThemeContaining(selectTheme, -1, -1);
	}

	/**
	 * JPQL Query - findCustomerBySelectThemeContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Customer> findCustomerBySelectThemeContaining(String selectTheme, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findCustomerBySelectThemeContaining", startResult, maxRows, selectTheme);
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
}
