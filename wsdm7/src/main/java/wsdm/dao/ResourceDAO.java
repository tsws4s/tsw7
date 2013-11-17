package wsdm.dao;

import java.util.Set;

import org.skyway.spring.util.dao.JpaDao;

import org.springframework.dao.DataAccessException;

import wsdm.domain.Resource;

/**
 * DAO to manage Resource entities.
 * 
 */
public interface ResourceDAO extends JpaDao<Resource> {

	/**
	 * JPQL Query - findResourceByState
	 *
	 */
	public Set<Resource> findResourceByState(String state) throws DataAccessException;

	/**
	 * JPQL Query - findResourceByState
	 *
	 */
	public Set<Resource> findResourceByState(String state, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findResourceByNotesContaining
	 *
	 */
	public Set<Resource> findResourceByNotesContaining(String notes) throws DataAccessException;

	/**
	 * JPQL Query - findResourceByNotesContaining
	 *
	 */
	public Set<Resource> findResourceByNotesContaining(String notes, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findResourceByPhoneContaining
	 *
	 */
	public Set<Resource> findResourceByPhoneContaining(String phone) throws DataAccessException;

	/**
	 * JPQL Query - findResourceByPhoneContaining
	 *
	 */
	public Set<Resource> findResourceByPhoneContaining(String phone, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findResourceByPrimaryKey
	 *
	 */
	public Resource findResourceByPrimaryKey(Integer resourceId) throws DataAccessException;

	/**
	 * JPQL Query - findResourceByPrimaryKey
	 *
	 */
	public Resource findResourceByPrimaryKey(Integer resourceId, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findResourceByAddress
	 *
	 */
	public Set<Resource> findResourceByAddress(String address) throws DataAccessException;

	/**
	 * JPQL Query - findResourceByAddress
	 *
	 */
	public Set<Resource> findResourceByAddress(String address, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findResourceByEmail
	 *
	 */
	public Set<Resource> findResourceByEmail(String email) throws DataAccessException;

	/**
	 * JPQL Query - findResourceByEmail
	 *
	 */
	public Set<Resource> findResourceByEmail(String email, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findResourceByResourceId
	 *
	 */
	public Resource findResourceByResourceId(Integer resourceId_1) throws DataAccessException;

	/**
	 * JPQL Query - findResourceByResourceId
	 *
	 */
	public Resource findResourceByResourceId(Integer resourceId_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findResourceByPhone
	 *
	 */
	public Set<Resource> findResourceByPhone(String phone_1) throws DataAccessException;

	/**
	 * JPQL Query - findResourceByPhone
	 *
	 */
	public Set<Resource> findResourceByPhone(String phone_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findResourceByCity
	 *
	 */
	public Set<Resource> findResourceByCity(String city) throws DataAccessException;

	/**
	 * JPQL Query - findResourceByCity
	 *
	 */
	public Set<Resource> findResourceByCity(String city, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findResourceByStateContaining
	 *
	 */
	public Set<Resource> findResourceByStateContaining(String state_1) throws DataAccessException;

	/**
	 * JPQL Query - findResourceByStateContaining
	 *
	 */
	public Set<Resource> findResourceByStateContaining(String state_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findResourceByResourceNameContaining
	 *
	 */
	public Set<Resource> findResourceByResourceNameContaining(String resourceName) throws DataAccessException;

	/**
	 * JPQL Query - findResourceByResourceNameContaining
	 *
	 */
	public Set<Resource> findResourceByResourceNameContaining(String resourceName, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findResourceByResourceName
	 *
	 */
	public Set<Resource> findResourceByResourceName(String resourceName_1) throws DataAccessException;

	/**
	 * JPQL Query - findResourceByResourceName
	 *
	 */
	public Set<Resource> findResourceByResourceName(String resourceName_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findResourceByZipcodeContaining
	 *
	 */
	public Set<Resource> findResourceByZipcodeContaining(String zipcode) throws DataAccessException;

	/**
	 * JPQL Query - findResourceByZipcodeContaining
	 *
	 */
	public Set<Resource> findResourceByZipcodeContaining(String zipcode, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findResourceByResourceTypeContaining
	 *
	 */
	public Set<Resource> findResourceByResourceTypeContaining(String resourceType) throws DataAccessException;

	/**
	 * JPQL Query - findResourceByResourceTypeContaining
	 *
	 */
	public Set<Resource> findResourceByResourceTypeContaining(String resourceType, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAllResources
	 *
	 */
	public Set<Resource> findAllResources() throws DataAccessException;

	/**
	 * JPQL Query - findAllResources
	 *
	 */
	public Set<Resource> findAllResources(int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findResourceByActiveYn
	 *
	 */
	public Set<Resource> findResourceByActiveYn(Integer activeYn) throws DataAccessException;

	/**
	 * JPQL Query - findResourceByActiveYn
	 *
	 */
	public Set<Resource> findResourceByActiveYn(Integer activeYn, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findResourceByNotes
	 *
	 */
	public Set<Resource> findResourceByNotes(String notes_1) throws DataAccessException;

	/**
	 * JPQL Query - findResourceByNotes
	 *
	 */
	public Set<Resource> findResourceByNotes(String notes_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findResourceByResourceType
	 *
	 */
	public Set<Resource> findResourceByResourceType(String resourceType_1) throws DataAccessException;

	/**
	 * JPQL Query - findResourceByResourceType
	 *
	 */
	public Set<Resource> findResourceByResourceType(String resourceType_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findResourceByEmailContaining
	 *
	 */
	public Set<Resource> findResourceByEmailContaining(String email_1) throws DataAccessException;

	/**
	 * JPQL Query - findResourceByEmailContaining
	 *
	 */
	public Set<Resource> findResourceByEmailContaining(String email_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findResourceByAddressContaining
	 *
	 */
	public Set<Resource> findResourceByAddressContaining(String address_1) throws DataAccessException;

	/**
	 * JPQL Query - findResourceByAddressContaining
	 *
	 */
	public Set<Resource> findResourceByAddressContaining(String address_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findResourceByZipcode
	 *
	 */
	public Set<Resource> findResourceByZipcode(String zipcode_1) throws DataAccessException;

	/**
	 * JPQL Query - findResourceByZipcode
	 *
	 */
	public Set<Resource> findResourceByZipcode(String zipcode_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findResourceByCityContaining
	 *
	 */
	public Set<Resource> findResourceByCityContaining(String city_1) throws DataAccessException;

	/**
	 * JPQL Query - findResourceByCityContaining
	 *
	 */
	public Set<Resource> findResourceByCityContaining(String city_1, int startResult, int maxRows) throws DataAccessException;

}