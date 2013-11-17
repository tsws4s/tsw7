package wsdm.dao;

import java.util.Set;

import org.skyway.spring.util.dao.JpaDao;

import org.springframework.dao.DataAccessException;

import wsdm.domain.Customer;

/**
 * DAO to manage Customer entities.
 * 
 */
public interface CustomerDAO extends JpaDao<Customer> {

	/**
	 * JPQL Query - findCustomerByLastnameContaining
	 *
	 */
	public Set<Customer> findCustomerByLastnameContaining(String lastname) throws DataAccessException;

	/**
	 * JPQL Query - findCustomerByLastnameContaining
	 *
	 */
	public Set<Customer> findCustomerByLastnameContaining(String lastname, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findCustomerByPassword
	 *
	 */
	public Set<Customer> findCustomerByPassword(String password) throws DataAccessException;

	/**
	 * JPQL Query - findCustomerByPassword
	 *
	 */
	public Set<Customer> findCustomerByPassword(String password, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findCustomerByEmail
	 *
	 */
	public Set<Customer> findCustomerByEmail(String email) throws DataAccessException;

	/**
	 * JPQL Query - findCustomerByEmail
	 *
	 */
	public Set<Customer> findCustomerByEmail(String email, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findCustomerByEmailContaining
	 *
	 */
	public Set<Customer> findCustomerByEmailContaining(String email_1) throws DataAccessException;

	/**
	 * JPQL Query - findCustomerByEmailContaining
	 *
	 */
	public Set<Customer> findCustomerByEmailContaining(String email_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findCustomerByZipcodeContaining
	 *
	 */
	public Set<Customer> findCustomerByZipcodeContaining(String zipcode) throws DataAccessException;

	/**
	 * JPQL Query - findCustomerByZipcodeContaining
	 *
	 */
	public Set<Customer> findCustomerByZipcodeContaining(String zipcode, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAllCustomers
	 *
	 */
	public Set<Customer> findAllCustomers() throws DataAccessException;

	/**
	 * JPQL Query - findAllCustomers
	 *
	 */
	public Set<Customer> findAllCustomers(int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findCustomerBySelectThemeContaining
	 *
	 */
	public Set<Customer> findCustomerBySelectThemeContaining(String selectTheme) throws DataAccessException;

	/**
	 * JPQL Query - findCustomerBySelectThemeContaining
	 *
	 */
	public Set<Customer> findCustomerBySelectThemeContaining(String selectTheme, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findCustomerByAddrSameAsFamily
	 *
	 */
	public Set<Customer> findCustomerByAddrSameAsFamily(Integer addrSameAsFamily) throws DataAccessException;

	/**
	 * JPQL Query - findCustomerByAddrSameAsFamily
	 *
	 */
	public Set<Customer> findCustomerByAddrSameAsFamily(Integer addrSameAsFamily, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findCustomerByPasswordContaining
	 *
	 */
	public Set<Customer> findCustomerByPasswordContaining(String password_1) throws DataAccessException;

	/**
	 * JPQL Query - findCustomerByPasswordContaining
	 *
	 */
	public Set<Customer> findCustomerByPasswordContaining(String password_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findCustomerByFirstnameContaining
	 *
	 */
	public Set<Customer> findCustomerByFirstnameContaining(String firstname) throws DataAccessException;

	/**
	 * JPQL Query - findCustomerByFirstnameContaining
	 *
	 */
	public Set<Customer> findCustomerByFirstnameContaining(String firstname, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findCustomerByAddressContaining
	 *
	 */
	public Set<Customer> findCustomerByAddressContaining(String address) throws DataAccessException;

	/**
	 * JPQL Query - findCustomerByAddressContaining
	 *
	 */
	public Set<Customer> findCustomerByAddressContaining(String address, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findCustomerByLastname
	 *
	 */
	public Set<Customer> findCustomerByLastname(String lastname_1) throws DataAccessException;

	/**
	 * JPQL Query - findCustomerByLastname
	 *
	 */
	public Set<Customer> findCustomerByLastname(String lastname_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findCustomerByCityContaining
	 *
	 */
	public Set<Customer> findCustomerByCityContaining(String city) throws DataAccessException;

	/**
	 * JPQL Query - findCustomerByCityContaining
	 *
	 */
	public Set<Customer> findCustomerByCityContaining(String city, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findCustomerByActiveYn
	 *
	 */
	public Set<Customer> findCustomerByActiveYn(Integer activeYn) throws DataAccessException;

	/**
	 * JPQL Query - findCustomerByActiveYn
	 *
	 */
	public Set<Customer> findCustomerByActiveYn(Integer activeYn, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findCustomerByCity
	 *
	 */
	public Set<Customer> findCustomerByCity(String city_1) throws DataAccessException;

	/**
	 * JPQL Query - findCustomerByCity
	 *
	 */
	public Set<Customer> findCustomerByCity(String city_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findCustomerByPrimaryKey
	 *
	 */
	public Customer findCustomerByPrimaryKey(Integer customerId) throws DataAccessException;

	/**
	 * JPQL Query - findCustomerByPrimaryKey
	 *
	 */
	public Customer findCustomerByPrimaryKey(Integer customerId, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findCustomerByAdminYn
	 *
	 */
	public Set<Customer> findCustomerByAdminYn(Integer adminYn) throws DataAccessException;

	/**
	 * JPQL Query - findCustomerByAdminYn
	 *
	 */
	public Set<Customer> findCustomerByAdminYn(Integer adminYn, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findCustomerByPhone
	 *
	 */
	public Set<Customer> findCustomerByPhone(String phone) throws DataAccessException;

	/**
	 * JPQL Query - findCustomerByPhone
	 *
	 */
	public Set<Customer> findCustomerByPhone(String phone, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findCustomerByCustomerId
	 *
	 */
	public Customer findCustomerByCustomerId(Integer customerId_1) throws DataAccessException;

	/**
	 * JPQL Query - findCustomerByCustomerId
	 *
	 */
	public Customer findCustomerByCustomerId(Integer customerId_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findCustomerByState
	 *
	 */
	public Set<Customer> findCustomerByState(String state) throws DataAccessException;

	/**
	 * JPQL Query - findCustomerByState
	 *
	 */
	public Set<Customer> findCustomerByState(String state, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findCustomerByYearBorn
	 *
	 */
	public Set<Customer> findCustomerByYearBorn(Integer yearBorn) throws DataAccessException;

	/**
	 * JPQL Query - findCustomerByYearBorn
	 *
	 */
	public Set<Customer> findCustomerByYearBorn(Integer yearBorn, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findCustomerByPhoneContaining
	 *
	 */
	public Set<Customer> findCustomerByPhoneContaining(String phone_1) throws DataAccessException;

	/**
	 * JPQL Query - findCustomerByPhoneContaining
	 *
	 */
	public Set<Customer> findCustomerByPhoneContaining(String phone_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findCustomerBySelectTheme
	 *
	 */
	public Set<Customer> findCustomerBySelectTheme(String selectTheme_1) throws DataAccessException;

	/**
	 * JPQL Query - findCustomerBySelectTheme
	 *
	 */
	public Set<Customer> findCustomerBySelectTheme(String selectTheme_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findCustomerByAddress
	 *
	 */
	public Set<Customer> findCustomerByAddress(String address_1) throws DataAccessException;

	/**
	 * JPQL Query - findCustomerByAddress
	 *
	 */
	public Set<Customer> findCustomerByAddress(String address_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findCustomerByStateContaining
	 *
	 */
	public Set<Customer> findCustomerByStateContaining(String state_1) throws DataAccessException;

	/**
	 * JPQL Query - findCustomerByStateContaining
	 *
	 */
	public Set<Customer> findCustomerByStateContaining(String state_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findCustomerByZipcode
	 *
	 */
	public Set<Customer> findCustomerByZipcode(String zipcode_1) throws DataAccessException;

	/**
	 * JPQL Query - findCustomerByZipcode
	 *
	 */
	public Set<Customer> findCustomerByZipcode(String zipcode_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findCustomerByFirstname
	 *
	 */
	public Set<Customer> findCustomerByFirstname(String firstname_1) throws DataAccessException;

	/**
	 * JPQL Query - findCustomerByFirstname
	 *
	 */
	public Set<Customer> findCustomerByFirstname(String firstname_1, int startResult, int maxRows) throws DataAccessException;

}