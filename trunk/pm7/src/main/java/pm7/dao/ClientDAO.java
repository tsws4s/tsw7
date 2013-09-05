package pm7.dao;

import java.util.Set;

import org.skyway.spring.util.dao.JpaDao;

import org.springframework.dao.DataAccessException;

import pm7.domain.Client;

/**
 * DAO to manage Client entities.
 * 
 */
public interface ClientDAO extends JpaDao<Client> {

	/**
	 * JPQL Query - findClientByClientName
	 *
	 */
	public Set<Client> findClientByClientName(String clientName) throws DataAccessException;

	/**
	 * JPQL Query - findClientByClientName
	 *
	 */
	public Set<Client> findClientByClientName(String clientName, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findClientByClientId
	 *
	 */
	public Client findClientByClientId(Integer clientId) throws DataAccessException;

	/**
	 * JPQL Query - findClientByClientId
	 *
	 */
	public Client findClientByClientId(Integer clientId, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAllClients
	 *
	 */
	public Set<Client> findAllClients() throws DataAccessException;

	/**
	 * JPQL Query - findAllClients
	 *
	 */
	public Set<Client> findAllClients(int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findClientByZip
	 *
	 */
	public Set<Client> findClientByZip(String zip) throws DataAccessException;

	/**
	 * JPQL Query - findClientByZip
	 *
	 */
	public Set<Client> findClientByZip(String zip, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findClientByWebsiteContaining
	 *
	 */
	public Set<Client> findClientByWebsiteContaining(String website) throws DataAccessException;

	/**
	 * JPQL Query - findClientByWebsiteContaining
	 *
	 */
	public Set<Client> findClientByWebsiteContaining(String website, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findClientByEmailContaining
	 *
	 */
	public Set<Client> findClientByEmailContaining(String email) throws DataAccessException;

	/**
	 * JPQL Query - findClientByEmailContaining
	 *
	 */
	public Set<Client> findClientByEmailContaining(String email, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findClientByCity
	 *
	 */
	public Set<Client> findClientByCity(String city) throws DataAccessException;

	/**
	 * JPQL Query - findClientByCity
	 *
	 */
	public Set<Client> findClientByCity(String city, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findClientByEmail
	 *
	 */
	public Set<Client> findClientByEmail(String email_1) throws DataAccessException;

	/**
	 * JPQL Query - findClientByEmail
	 *
	 */
	public Set<Client> findClientByEmail(String email_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findClientByActiveYn
	 *
	 */
	public Set<Client> findClientByActiveYn(Integer activeYn) throws DataAccessException;

	/**
	 * JPQL Query - findClientByActiveYn
	 *
	 */
	public Set<Client> findClientByActiveYn(Integer activeYn, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findClientByLogoFilenameContaining
	 *
	 */
	public Set<Client> findClientByLogoFilenameContaining(String logoFilename) throws DataAccessException;

	/**
	 * JPQL Query - findClientByLogoFilenameContaining
	 *
	 */
	public Set<Client> findClientByLogoFilenameContaining(String logoFilename, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findClientByAddress
	 *
	 */
	public Set<Client> findClientByAddress(String address) throws DataAccessException;

	/**
	 * JPQL Query - findClientByAddress
	 *
	 */
	public Set<Client> findClientByAddress(String address, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findClientByAddressContaining
	 *
	 */
	public Set<Client> findClientByAddressContaining(String address_1) throws DataAccessException;

	/**
	 * JPQL Query - findClientByAddressContaining
	 *
	 */
	public Set<Client> findClientByAddressContaining(String address_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findClientByState
	 *
	 */
	public Set<Client> findClientByState(String state) throws DataAccessException;

	/**
	 * JPQL Query - findClientByState
	 *
	 */
	public Set<Client> findClientByState(String state, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findClientByWebsite
	 *
	 */
	public Set<Client> findClientByWebsite(String website_1) throws DataAccessException;

	/**
	 * JPQL Query - findClientByWebsite
	 *
	 */
	public Set<Client> findClientByWebsite(String website_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findClientByClientNameContaining
	 *
	 */
	public Set<Client> findClientByClientNameContaining(String clientName_1) throws DataAccessException;

	/**
	 * JPQL Query - findClientByClientNameContaining
	 *
	 */
	public Set<Client> findClientByClientNameContaining(String clientName_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findClientByLogoFilename
	 *
	 */
	public Set<Client> findClientByLogoFilename(String logoFilename_1) throws DataAccessException;

	/**
	 * JPQL Query - findClientByLogoFilename
	 *
	 */
	public Set<Client> findClientByLogoFilename(String logoFilename_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findClientByPrimaryKey
	 *
	 */
	public Client findClientByPrimaryKey(Integer clientId_1) throws DataAccessException;

	/**
	 * JPQL Query - findClientByPrimaryKey
	 *
	 */
	public Client findClientByPrimaryKey(Integer clientId_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findClientByCityContaining
	 *
	 */
	public Set<Client> findClientByCityContaining(String city_1) throws DataAccessException;

	/**
	 * JPQL Query - findClientByCityContaining
	 *
	 */
	public Set<Client> findClientByCityContaining(String city_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findClientByPhone
	 *
	 */
	public Set<Client> findClientByPhone(String phone) throws DataAccessException;

	/**
	 * JPQL Query - findClientByPhone
	 *
	 */
	public Set<Client> findClientByPhone(String phone, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findClientByZipContaining
	 *
	 */
	public Set<Client> findClientByZipContaining(String zip_1) throws DataAccessException;

	/**
	 * JPQL Query - findClientByZipContaining
	 *
	 */
	public Set<Client> findClientByZipContaining(String zip_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findClientByStateContaining
	 *
	 */
	public Set<Client> findClientByStateContaining(String state_1) throws DataAccessException;

	/**
	 * JPQL Query - findClientByStateContaining
	 *
	 */
	public Set<Client> findClientByStateContaining(String state_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findClientByPhoneContaining
	 *
	 */
	public Set<Client> findClientByPhoneContaining(String phone_1) throws DataAccessException;

	/**
	 * JPQL Query - findClientByPhoneContaining
	 *
	 */
	public Set<Client> findClientByPhoneContaining(String phone_1, int startResult, int maxRows) throws DataAccessException;

	public Integer getMaxClientId();
}