package wsdm.dao;

import java.math.BigDecimal;

import java.util.Calendar;
import java.util.Set;

import org.skyway.spring.util.dao.JpaDao;

import org.springframework.dao.DataAccessException;

import wsdm.domain.Employee;

/**
 * DAO to manage Employee entities.
 * 
 */
public interface EmployeeDAO extends JpaDao<Employee> {

	/**
	 * JPQL Query - findEmployeeByFirstname
	 *
	 */
	public Set<Employee> findEmployeeByFirstname(String firstname) throws DataAccessException;

	/**
	 * JPQL Query - findEmployeeByFirstname
	 *
	 */
	public Set<Employee> findEmployeeByFirstname(String firstname, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findEmployeeByLastname
	 *
	 */
	public Set<Employee> findEmployeeByLastname(String lastname) throws DataAccessException;

	/**
	 * JPQL Query - findEmployeeByLastname
	 *
	 */
	public Set<Employee> findEmployeeByLastname(String lastname, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findEmployeeByBirthdateBefore
	 *
	 */
	public Set<Employee> findEmployeeByBirthdateBefore(java.util.Calendar birthdate) throws DataAccessException;

	/**
	 * JPQL Query - findEmployeeByBirthdateBefore
	 *
	 */
	public Set<Employee> findEmployeeByBirthdateBefore(Calendar birthdate, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findEmployeeByEmployeeId
	 *
	 */
	public Employee findEmployeeByEmployeeId(Integer employeeId) throws DataAccessException;

	/**
	 * JPQL Query - findEmployeeByEmployeeId
	 *
	 */
	public Employee findEmployeeByEmployeeId(Integer employeeId, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findEmployeeByFirstnameContaining
	 *
	 */
	public Set<Employee> findEmployeeByFirstnameContaining(String firstname_1) throws DataAccessException;

	/**
	 * JPQL Query - findEmployeeByFirstnameContaining
	 *
	 */
	public Set<Employee> findEmployeeByFirstnameContaining(String firstname_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findEmployeeByPrimaryKey
	 *
	 */
	public Employee findEmployeeByPrimaryKey(Integer employeeId_1) throws DataAccessException;

	/**
	 * JPQL Query - findEmployeeByPrimaryKey
	 *
	 */
	public Employee findEmployeeByPrimaryKey(Integer employeeId_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findEmployeeBySalary
	 *
	 */
	public Set<Employee> findEmployeeBySalary(java.math.BigDecimal salary) throws DataAccessException;

	/**
	 * JPQL Query - findEmployeeBySalary
	 *
	 */
	public Set<Employee> findEmployeeBySalary(BigDecimal salary, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findEmployeeByBirthdate
	 *
	 */
	public Set<Employee> findEmployeeByBirthdate(java.util.Calendar birthdate_1) throws DataAccessException;

	/**
	 * JPQL Query - findEmployeeByBirthdate
	 *
	 */
	public Set<Employee> findEmployeeByBirthdate(Calendar birthdate_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findEmployeeByLastnameContaining
	 *
	 */
	public Set<Employee> findEmployeeByLastnameContaining(String lastname_1) throws DataAccessException;

	/**
	 * JPQL Query - findEmployeeByLastnameContaining
	 *
	 */
	public Set<Employee> findEmployeeByLastnameContaining(String lastname_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findEmployeeByBirthdateAfter
	 *
	 */
	public Set<Employee> findEmployeeByBirthdateAfter(java.util.Calendar birthdate_2) throws DataAccessException;

	/**
	 * JPQL Query - findEmployeeByBirthdateAfter
	 *
	 */
	public Set<Employee> findEmployeeByBirthdateAfter(Calendar birthdate_2, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAllEmployees
	 *
	 */
	public Set<Employee> findAllEmployees() throws DataAccessException;

	/**
	 * JPQL Query - findAllEmployees
	 *
	 */
	public Set<Employee> findAllEmployees(int startResult, int maxRows) throws DataAccessException;

}