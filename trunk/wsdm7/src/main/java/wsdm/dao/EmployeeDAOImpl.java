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

import wsdm.domain.Employee;

/**
 * DAO to manage Employee entities.
 * 
 */
@Repository("EmployeeDAO")
@Transactional
public class EmployeeDAOImpl extends AbstractJpaDao<Employee> implements
		EmployeeDAO {

	/**
	 * Set of entity classes managed by this DAO.  Typically a DAO manages a single entity.
	 *
	 */
	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[] { Employee.class }));

	/**
	 * EntityManager injected by Spring for persistence unit mysql_tsw
	 *
	 */
	@PersistenceContext(unitName = "mysql_tsw")
	private EntityManager entityManager;

	/**
	 * Instantiates a new EmployeeDAOImpl
	 *
	 */
	public EmployeeDAOImpl() {
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
	 * JPQL Query - findEmployeeByFirstname
	 *
	 */
	@Transactional
	public Set<Employee> findEmployeeByFirstname(String firstname) throws DataAccessException {

		return findEmployeeByFirstname(firstname, -1, -1);
	}

	/**
	 * JPQL Query - findEmployeeByFirstname
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Employee> findEmployeeByFirstname(String firstname, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findEmployeeByFirstname", startResult, maxRows, firstname);
		return new LinkedHashSet<Employee>(query.getResultList());
	}

	/**
	 * JPQL Query - findEmployeeByLastname
	 *
	 */
	@Transactional
	public Set<Employee> findEmployeeByLastname(String lastname) throws DataAccessException {

		return findEmployeeByLastname(lastname, -1, -1);
	}

	/**
	 * JPQL Query - findEmployeeByLastname
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Employee> findEmployeeByLastname(String lastname, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findEmployeeByLastname", startResult, maxRows, lastname);
		return new LinkedHashSet<Employee>(query.getResultList());
	}

	/**
	 * JPQL Query - findEmployeeByBirthdateBefore
	 *
	 */
	@Transactional
	public Set<Employee> findEmployeeByBirthdateBefore(java.util.Calendar birthdate) throws DataAccessException {

		return findEmployeeByBirthdateBefore(birthdate, -1, -1);
	}

	/**
	 * JPQL Query - findEmployeeByBirthdateBefore
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Employee> findEmployeeByBirthdateBefore(java.util.Calendar birthdate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findEmployeeByBirthdateBefore", startResult, maxRows, birthdate);
		return new LinkedHashSet<Employee>(query.getResultList());
	}

	/**
	 * JPQL Query - findEmployeeByEmployeeId
	 *
	 */
	@Transactional
	public Employee findEmployeeByEmployeeId(Integer employeeId) throws DataAccessException {

		return findEmployeeByEmployeeId(employeeId, -1, -1);
	}

	/**
	 * JPQL Query - findEmployeeByEmployeeId
	 *
	 */

	@Transactional
	public Employee findEmployeeByEmployeeId(Integer employeeId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findEmployeeByEmployeeId", startResult, maxRows, employeeId);
			return (wsdm.domain.Employee) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findEmployeeByFirstnameContaining
	 *
	 */
	@Transactional
	public Set<Employee> findEmployeeByFirstnameContaining(String firstname) throws DataAccessException {

		return findEmployeeByFirstnameContaining(firstname, -1, -1);
	}

	/**
	 * JPQL Query - findEmployeeByFirstnameContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Employee> findEmployeeByFirstnameContaining(String firstname, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findEmployeeByFirstnameContaining", startResult, maxRows, firstname);
		return new LinkedHashSet<Employee>(query.getResultList());
	}

	/**
	 * JPQL Query - findEmployeeByPrimaryKey
	 *
	 */
	@Transactional
	public Employee findEmployeeByPrimaryKey(Integer employeeId) throws DataAccessException {

		return findEmployeeByPrimaryKey(employeeId, -1, -1);
	}

	/**
	 * JPQL Query - findEmployeeByPrimaryKey
	 *
	 */

	@Transactional
	public Employee findEmployeeByPrimaryKey(Integer employeeId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findEmployeeByPrimaryKey", startResult, maxRows, employeeId);
			return (wsdm.domain.Employee) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findEmployeeBySalary
	 *
	 */
	@Transactional
	public Set<Employee> findEmployeeBySalary(java.math.BigDecimal salary) throws DataAccessException {

		return findEmployeeBySalary(salary, -1, -1);
	}

	/**
	 * JPQL Query - findEmployeeBySalary
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Employee> findEmployeeBySalary(java.math.BigDecimal salary, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findEmployeeBySalary", startResult, maxRows, salary);
		return new LinkedHashSet<Employee>(query.getResultList());
	}

	/**
	 * JPQL Query - findEmployeeByBirthdate
	 *
	 */
	@Transactional
	public Set<Employee> findEmployeeByBirthdate(java.util.Calendar birthdate) throws DataAccessException {

		return findEmployeeByBirthdate(birthdate, -1, -1);
	}

	/**
	 * JPQL Query - findEmployeeByBirthdate
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Employee> findEmployeeByBirthdate(java.util.Calendar birthdate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findEmployeeByBirthdate", startResult, maxRows, birthdate);
		return new LinkedHashSet<Employee>(query.getResultList());
	}

	/**
	 * JPQL Query - findEmployeeByLastnameContaining
	 *
	 */
	@Transactional
	public Set<Employee> findEmployeeByLastnameContaining(String lastname) throws DataAccessException {

		return findEmployeeByLastnameContaining(lastname, -1, -1);
	}

	/**
	 * JPQL Query - findEmployeeByLastnameContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Employee> findEmployeeByLastnameContaining(String lastname, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findEmployeeByLastnameContaining", startResult, maxRows, lastname);
		return new LinkedHashSet<Employee>(query.getResultList());
	}

	/**
	 * JPQL Query - findEmployeeByBirthdateAfter
	 *
	 */
	@Transactional
	public Set<Employee> findEmployeeByBirthdateAfter(java.util.Calendar birthdate) throws DataAccessException {

		return findEmployeeByBirthdateAfter(birthdate, -1, -1);
	}

	/**
	 * JPQL Query - findEmployeeByBirthdateAfter
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Employee> findEmployeeByBirthdateAfter(java.util.Calendar birthdate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findEmployeeByBirthdateAfter", startResult, maxRows, birthdate);
		return new LinkedHashSet<Employee>(query.getResultList());
	}

	/**
	 * JPQL Query - findAllEmployees
	 *
	 */
	@Transactional
	public Set<Employee> findAllEmployees() throws DataAccessException {

		return findAllEmployees(-1, -1);
	}

	/**
	 * JPQL Query - findAllEmployees
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Employee> findAllEmployees(int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAllEmployees", startResult, maxRows);
		return new LinkedHashSet<Employee>(query.getResultList());
	}

	/**
	 * Used to determine whether or not to merge the entity or persist the entity when calling Store
	 * @see store
	 * 
	 *
	 */
	public boolean canBeMerged(Employee entity) {
		return true;
	}
}
