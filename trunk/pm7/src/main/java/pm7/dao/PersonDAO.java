package pm7.dao;

import java.util.Set;

import org.skyway.spring.util.dao.JpaDao;

import org.springframework.dao.DataAccessException;

import pm7.domain.Person;

/**
 * DAO to manage Person entities.
 * 
 */
public interface PersonDAO extends JpaDao<Person> {

	/**
	 * JPQL Query - findPersonByPersonId
	 *
	 */
	public Person findPersonByPersonId(Integer personId) throws DataAccessException;

	/**
	 * JPQL Query - findPersonByPersonId
	 *
	 */
	public Person findPersonByPersonId(Integer personId, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findPersonByFirstnameContaining
	 *
	 */
	public Set<Person> findPersonByFirstnameContaining(String firstname) throws DataAccessException;

	/**
	 * JPQL Query - findPersonByFirstnameContaining
	 *
	 */
	public Set<Person> findPersonByFirstnameContaining(String firstname, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findPersonByDefaultProjectRole
	 *
	 */
	public Set<Person> findPersonByDefaultProjectRole(String defaultProjectRole) throws DataAccessException;

	/**
	 * JPQL Query - findPersonByDefaultProjectRole
	 *
	 */
	public Set<Person> findPersonByDefaultProjectRole(String defaultProjectRole, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findPersonByPhone
	 *
	 */
	public Set<Person> findPersonByPhone(String phone) throws DataAccessException;

	/**
	 * JPQL Query - findPersonByPhone
	 *
	 */
	public Set<Person> findPersonByPhone(String phone, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findPersonByActiveYn
	 *
	 */
	public Set<Person> findPersonByActiveYn(Integer activeYn) throws DataAccessException;

	/**
	 * JPQL Query - findPersonByActiveYn
	 *
	 */
	public Set<Person> findPersonByActiveYn(Integer activeYn, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findPersonByZip
	 *
	 */
	public Set<Person> findPersonByZip(String zip) throws DataAccessException;

	/**
	 * JPQL Query - findPersonByZip
	 *
	 */
	public Set<Person> findPersonByZip(String zip, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAllPersons
	 *
	 */
	public Set<Person> findAllPersons() throws DataAccessException;

	/**
	 * JPQL Query - findAllPersons
	 *
	 */
	public Set<Person> findAllPersons(int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findPersonByCity
	 *
	 */
	public Set<Person> findPersonByCity(String city) throws DataAccessException;

	/**
	 * JPQL Query - findPersonByCity
	 *
	 */
	public Set<Person> findPersonByCity(String city, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findPersonByAddress
	 *
	 */
	public Set<Person> findPersonByAddress(String address) throws DataAccessException;

	/**
	 * JPQL Query - findPersonByAddress
	 *
	 */
	public Set<Person> findPersonByAddress(String address, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findPersonByLastnameContaining
	 *
	 */
	public Set<Person> findPersonByLastnameContaining(String lastname) throws DataAccessException;

	/**
	 * JPQL Query - findPersonByLastnameContaining
	 *
	 */
	public Set<Person> findPersonByLastnameContaining(String lastname, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findPersonByEmail
	 *
	 */
	public Set<Person> findPersonByEmail(String email) throws DataAccessException;

	/**
	 * JPQL Query - findPersonByEmail
	 *
	 */
	public Set<Person> findPersonByEmail(String email, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findPersonByCityContaining
	 *
	 */
	public Set<Person> findPersonByCityContaining(String city_1) throws DataAccessException;

	/**
	 * JPQL Query - findPersonByCityContaining
	 *
	 */
	public Set<Person> findPersonByCityContaining(String city_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findPersonByDefaultProjectRoleContaining
	 *
	 */
	public Set<Person> findPersonByDefaultProjectRoleContaining(String defaultProjectRole_1) throws DataAccessException;

	/**
	 * JPQL Query - findPersonByDefaultProjectRoleContaining
	 *
	 */
	public Set<Person> findPersonByDefaultProjectRoleContaining(String defaultProjectRole_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findPersonByPhoneContaining
	 *
	 */
	public Set<Person> findPersonByPhoneContaining(String phone_1) throws DataAccessException;

	/**
	 * JPQL Query - findPersonByPhoneContaining
	 *
	 */
	public Set<Person> findPersonByPhoneContaining(String phone_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findPersonByEmailContaining
	 *
	 */
	public Set<Person> findPersonByEmailContaining(String email_1) throws DataAccessException;

	/**
	 * JPQL Query - findPersonByEmailContaining
	 *
	 */
	public Set<Person> findPersonByEmailContaining(String email_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findPersonByLastname
	 *
	 */
	public Set<Person> findPersonByLastname(String lastname_1) throws DataAccessException;

	/**
	 * JPQL Query - findPersonByLastname
	 *
	 */
	public Set<Person> findPersonByLastname(String lastname_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findPersonByPrimaryKey
	 *
	 */
	public Person findPersonByPrimaryKey(Integer personId_1) throws DataAccessException;

	/**
	 * JPQL Query - findPersonByPrimaryKey
	 *
	 */
	public Person findPersonByPrimaryKey(Integer personId_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findPersonByZipContaining
	 *
	 */
	public Set<Person> findPersonByZipContaining(String zip_1) throws DataAccessException;

	/**
	 * JPQL Query - findPersonByZipContaining
	 *
	 */
	public Set<Person> findPersonByZipContaining(String zip_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findPersonByFirstname
	 *
	 */
	public Set<Person> findPersonByFirstname(String firstname_1) throws DataAccessException;

	/**
	 * JPQL Query - findPersonByFirstname
	 *
	 */
	public Set<Person> findPersonByFirstname(String firstname_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findPersonByStateContaining
	 *
	 */
	public Set<Person> findPersonByStateContaining(String state) throws DataAccessException;

	/**
	 * JPQL Query - findPersonByStateContaining
	 *
	 */
	public Set<Person> findPersonByStateContaining(String state, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findPersonByAddressContaining
	 *
	 */
	public Set<Person> findPersonByAddressContaining(String address_1) throws DataAccessException;

	/**
	 * JPQL Query - findPersonByAddressContaining
	 *
	 */
	public Set<Person> findPersonByAddressContaining(String address_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findPersonByState
	 *
	 */
	public Set<Person> findPersonByState(String state_1) throws DataAccessException;

	/**
	 * JPQL Query - findPersonByState
	 *
	 */
	public Set<Person> findPersonByState(String state_1, int startResult, int maxRows) throws DataAccessException;

	public Integer getMaxPersonId();
}