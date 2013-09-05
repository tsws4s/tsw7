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

import pm7.domain.Person;

/**
 * DAO to manage Person entities.
 * 
 */
@Repository("PersonDAO")
@Transactional
public class PersonDAOImpl extends AbstractJpaDao<Person> implements PersonDAO {

	/**
	 * Set of entity classes managed by this DAO.  Typically a DAO manages a single entity.
	 *
	 */
	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[] { Person.class }));

	/**
	 * EntityManager injected by Spring for persistence unit mySql_pm7
	 *
	 */
	@PersistenceContext(unitName = "mySql_pm7")
	private EntityManager entityManager;

	/**
	 * Instantiates a new PersonDAOImpl
	 *
	 */
	public PersonDAOImpl() {
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
	 * JPQL Query - findPersonByPersonId
	 *
	 */
	@Transactional
	public Person findPersonByPersonId(Integer personId) throws DataAccessException {

		return findPersonByPersonId(personId, -1, -1);
	}

	/**
	 * JPQL Query - findPersonByPersonId
	 *
	 */

	@Transactional
	public Person findPersonByPersonId(Integer personId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findPersonByPersonId", startResult, maxRows, personId);
			return (pm7.domain.Person) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findPersonByFirstnameContaining
	 *
	 */
	@Transactional
	public Set<Person> findPersonByFirstnameContaining(String firstname) throws DataAccessException {

		return findPersonByFirstnameContaining(firstname, -1, -1);
	}

	/**
	 * JPQL Query - findPersonByFirstnameContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Person> findPersonByFirstnameContaining(String firstname, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findPersonByFirstnameContaining", startResult, maxRows, firstname);
		return new LinkedHashSet<Person>(query.getResultList());
	}

	/**
	 * JPQL Query - findPersonByDefaultProjectRole
	 *
	 */
	@Transactional
	public Set<Person> findPersonByDefaultProjectRole(String defaultProjectRole) throws DataAccessException {

		return findPersonByDefaultProjectRole(defaultProjectRole, -1, -1);
	}

	/**
	 * JPQL Query - findPersonByDefaultProjectRole
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Person> findPersonByDefaultProjectRole(String defaultProjectRole, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findPersonByDefaultProjectRole", startResult, maxRows, defaultProjectRole);
		return new LinkedHashSet<Person>(query.getResultList());
	}

	/**
	 * JPQL Query - findPersonByPhone
	 *
	 */
	@Transactional
	public Set<Person> findPersonByPhone(String phone) throws DataAccessException {

		return findPersonByPhone(phone, -1, -1);
	}

	/**
	 * JPQL Query - findPersonByPhone
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Person> findPersonByPhone(String phone, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findPersonByPhone", startResult, maxRows, phone);
		return new LinkedHashSet<Person>(query.getResultList());
	}

	/**
	 * JPQL Query - findPersonByActiveYn
	 *
	 */
	@Transactional
	public Set<Person> findPersonByActiveYn(Integer activeYn) throws DataAccessException {

		return findPersonByActiveYn(activeYn, -1, -1);
	}

	/**
	 * JPQL Query - findPersonByActiveYn
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Person> findPersonByActiveYn(Integer activeYn, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findPersonByActiveYn", startResult, maxRows, activeYn);
		return new LinkedHashSet<Person>(query.getResultList());
	}

	/**
	 * JPQL Query - findPersonByZip
	 *
	 */
	@Transactional
	public Set<Person> findPersonByZip(String zip) throws DataAccessException {

		return findPersonByZip(zip, -1, -1);
	}

	/**
	 * JPQL Query - findPersonByZip
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Person> findPersonByZip(String zip, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findPersonByZip", startResult, maxRows, zip);
		return new LinkedHashSet<Person>(query.getResultList());
	}

	/**
	 * JPQL Query - findAllPersons
	 *
	 */
	@Transactional
	public Set<Person> findAllPersons() throws DataAccessException {

		return findAllPersons(-1, -1);
	}

	/**
	 * JPQL Query - findAllPersons
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Person> findAllPersons(int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAllPersons", startResult, maxRows);
		return new LinkedHashSet<Person>(query.getResultList());
	}

	/**
	 * JPQL Query - findPersonByCity
	 *
	 */
	@Transactional
	public Set<Person> findPersonByCity(String city) throws DataAccessException {

		return findPersonByCity(city, -1, -1);
	}

	/**
	 * JPQL Query - findPersonByCity
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Person> findPersonByCity(String city, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findPersonByCity", startResult, maxRows, city);
		return new LinkedHashSet<Person>(query.getResultList());
	}

	/**
	 * JPQL Query - findPersonByAddress
	 *
	 */
	@Transactional
	public Set<Person> findPersonByAddress(String address) throws DataAccessException {

		return findPersonByAddress(address, -1, -1);
	}

	/**
	 * JPQL Query - findPersonByAddress
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Person> findPersonByAddress(String address, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findPersonByAddress", startResult, maxRows, address);
		return new LinkedHashSet<Person>(query.getResultList());
	}

	/**
	 * JPQL Query - findPersonByLastnameContaining
	 *
	 */
	@Transactional
	public Set<Person> findPersonByLastnameContaining(String lastname) throws DataAccessException {

		return findPersonByLastnameContaining(lastname, -1, -1);
	}

	/**
	 * JPQL Query - findPersonByLastnameContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Person> findPersonByLastnameContaining(String lastname, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findPersonByLastnameContaining", startResult, maxRows, lastname);
		return new LinkedHashSet<Person>(query.getResultList());
	}

	/**
	 * JPQL Query - findPersonByEmail
	 *
	 */
	@Transactional
	public Set<Person> findPersonByEmail(String email) throws DataAccessException {

		return findPersonByEmail(email, -1, -1);
	}

	/**
	 * JPQL Query - findPersonByEmail
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Person> findPersonByEmail(String email, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findPersonByEmail", startResult, maxRows, email);
		return new LinkedHashSet<Person>(query.getResultList());
	}

	/**
	 * JPQL Query - findPersonByCityContaining
	 *
	 */
	@Transactional
	public Set<Person> findPersonByCityContaining(String city) throws DataAccessException {

		return findPersonByCityContaining(city, -1, -1);
	}

	/**
	 * JPQL Query - findPersonByCityContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Person> findPersonByCityContaining(String city, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findPersonByCityContaining", startResult, maxRows, city);
		return new LinkedHashSet<Person>(query.getResultList());
	}

	/**
	 * JPQL Query - findPersonByDefaultProjectRoleContaining
	 *
	 */
	@Transactional
	public Set<Person> findPersonByDefaultProjectRoleContaining(String defaultProjectRole) throws DataAccessException {

		return findPersonByDefaultProjectRoleContaining(defaultProjectRole, -1, -1);
	}

	/**
	 * JPQL Query - findPersonByDefaultProjectRoleContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Person> findPersonByDefaultProjectRoleContaining(String defaultProjectRole, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findPersonByDefaultProjectRoleContaining", startResult, maxRows, defaultProjectRole);
		return new LinkedHashSet<Person>(query.getResultList());
	}

	/**
	 * JPQL Query - findPersonByPhoneContaining
	 *
	 */
	@Transactional
	public Set<Person> findPersonByPhoneContaining(String phone) throws DataAccessException {

		return findPersonByPhoneContaining(phone, -1, -1);
	}

	/**
	 * JPQL Query - findPersonByPhoneContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Person> findPersonByPhoneContaining(String phone, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findPersonByPhoneContaining", startResult, maxRows, phone);
		return new LinkedHashSet<Person>(query.getResultList());
	}

	/**
	 * JPQL Query - findPersonByEmailContaining
	 *
	 */
	@Transactional
	public Set<Person> findPersonByEmailContaining(String email) throws DataAccessException {

		return findPersonByEmailContaining(email, -1, -1);
	}

	/**
	 * JPQL Query - findPersonByEmailContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Person> findPersonByEmailContaining(String email, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findPersonByEmailContaining", startResult, maxRows, email);
		return new LinkedHashSet<Person>(query.getResultList());
	}

	/**
	 * JPQL Query - findPersonByLastname
	 *
	 */
	@Transactional
	public Set<Person> findPersonByLastname(String lastname) throws DataAccessException {

		return findPersonByLastname(lastname, -1, -1);
	}

	/**
	 * JPQL Query - findPersonByLastname
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Person> findPersonByLastname(String lastname, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findPersonByLastname", startResult, maxRows, lastname);
		return new LinkedHashSet<Person>(query.getResultList());
	}

	/**
	 * JPQL Query - findPersonByPrimaryKey
	 *
	 */
	@Transactional
	public Person findPersonByPrimaryKey(Integer personId) throws DataAccessException {

		return findPersonByPrimaryKey(personId, -1, -1);
	}

	/**
	 * JPQL Query - findPersonByPrimaryKey
	 *
	 */

	@Transactional
	public Person findPersonByPrimaryKey(Integer personId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findPersonByPrimaryKey", startResult, maxRows, personId);
			return (pm7.domain.Person) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findPersonByZipContaining
	 *
	 */
	@Transactional
	public Set<Person> findPersonByZipContaining(String zip) throws DataAccessException {

		return findPersonByZipContaining(zip, -1, -1);
	}

	/**
	 * JPQL Query - findPersonByZipContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Person> findPersonByZipContaining(String zip, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findPersonByZipContaining", startResult, maxRows, zip);
		return new LinkedHashSet<Person>(query.getResultList());
	}

	/**
	 * JPQL Query - findPersonByFirstname
	 *
	 */
	@Transactional
	public Set<Person> findPersonByFirstname(String firstname) throws DataAccessException {

		return findPersonByFirstname(firstname, -1, -1);
	}

	/**
	 * JPQL Query - findPersonByFirstname
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Person> findPersonByFirstname(String firstname, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findPersonByFirstname", startResult, maxRows, firstname);
		return new LinkedHashSet<Person>(query.getResultList());
	}

	/**
	 * JPQL Query - findPersonByStateContaining
	 *
	 */
	@Transactional
	public Set<Person> findPersonByStateContaining(String state) throws DataAccessException {

		return findPersonByStateContaining(state, -1, -1);
	}

	/**
	 * JPQL Query - findPersonByStateContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Person> findPersonByStateContaining(String state, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findPersonByStateContaining", startResult, maxRows, state);
		return new LinkedHashSet<Person>(query.getResultList());
	}

	/**
	 * JPQL Query - findPersonByAddressContaining
	 *
	 */
	@Transactional
	public Set<Person> findPersonByAddressContaining(String address) throws DataAccessException {

		return findPersonByAddressContaining(address, -1, -1);
	}

	/**
	 * JPQL Query - findPersonByAddressContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Person> findPersonByAddressContaining(String address, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findPersonByAddressContaining", startResult, maxRows, address);
		return new LinkedHashSet<Person>(query.getResultList());
	}

	/**
	 * JPQL Query - findPersonByState
	 *
	 */
	@Transactional
	public Set<Person> findPersonByState(String state) throws DataAccessException {

		return findPersonByState(state, -1, -1);
	}

	/**
	 * JPQL Query - findPersonByState
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Person> findPersonByState(String state, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findPersonByState", startResult, maxRows, state);
		return new LinkedHashSet<Person>(query.getResultList());
	}

	/**
	 * Used to determine whether or not to merge the entity or persist the entity when calling Store
	 * @see store
	 * 
	 *
	 */
	public boolean canBeMerged(Person entity) {
		return true;
	}
	
	public Integer getMaxPersonId() {
		Object obj = executeQuerySingleResult("select max(personId) from Person");
		if(obj!=null){
			return (Integer)obj;
		}
		return 0;
	}
}
