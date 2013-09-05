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

import pm7.domain.Client;

/**
 * DAO to manage Client entities.
 * 
 */
@Repository("ClientDAO")
@Transactional
public class ClientDAOImpl extends AbstractJpaDao<Client> implements ClientDAO {

	/**
	 * Set of entity classes managed by this DAO.  Typically a DAO manages a single entity.
	 *
	 */
	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[] { Client.class }));

	/**
	 * EntityManager injected by Spring for persistence unit mySql_pm7
	 *
	 */
	@PersistenceContext(unitName = "mySql_pm7")
	private EntityManager entityManager;

	/**
	 * Instantiates a new ClientDAOImpl
	 *
	 */
	public ClientDAOImpl() {
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
	 * JPQL Query - findClientByClientName
	 *
	 */
	@Transactional
	public Set<Client> findClientByClientName(String clientName) throws DataAccessException {

		return findClientByClientName(clientName, -1, -1);
	}

	/**
	 * JPQL Query - findClientByClientName
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Client> findClientByClientName(String clientName, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findClientByClientName", startResult, maxRows, clientName);
		return new LinkedHashSet<Client>(query.getResultList());
	}

	/**
	 * JPQL Query - findClientByClientId
	 *
	 */
	@Transactional
	public Client findClientByClientId(Integer clientId) throws DataAccessException {

		return findClientByClientId(clientId, -1, -1);
	}

	/**
	 * JPQL Query - findClientByClientId
	 *
	 */

	@Transactional
	public Client findClientByClientId(Integer clientId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findClientByClientId", startResult, maxRows, clientId);
			return (pm7.domain.Client) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findAllClients
	 *
	 */
	@Transactional
	public Set<Client> findAllClients() throws DataAccessException {

		return findAllClients(-1, -1);
	}

	/**
	 * JPQL Query - findAllClients
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Client> findAllClients(int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAllClients", startResult, maxRows);
		return new LinkedHashSet<Client>(query.getResultList());
	}

	/**
	 * JPQL Query - findClientByZip
	 *
	 */
	@Transactional
	public Set<Client> findClientByZip(String zip) throws DataAccessException {

		return findClientByZip(zip, -1, -1);
	}

	/**
	 * JPQL Query - findClientByZip
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Client> findClientByZip(String zip, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findClientByZip", startResult, maxRows, zip);
		return new LinkedHashSet<Client>(query.getResultList());
	}

	/**
	 * JPQL Query - findClientByWebsiteContaining
	 *
	 */
	@Transactional
	public Set<Client> findClientByWebsiteContaining(String website) throws DataAccessException {

		return findClientByWebsiteContaining(website, -1, -1);
	}

	/**
	 * JPQL Query - findClientByWebsiteContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Client> findClientByWebsiteContaining(String website, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findClientByWebsiteContaining", startResult, maxRows, website);
		return new LinkedHashSet<Client>(query.getResultList());
	}

	/**
	 * JPQL Query - findClientByEmailContaining
	 *
	 */
	@Transactional
	public Set<Client> findClientByEmailContaining(String email) throws DataAccessException {

		return findClientByEmailContaining(email, -1, -1);
	}

	/**
	 * JPQL Query - findClientByEmailContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Client> findClientByEmailContaining(String email, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findClientByEmailContaining", startResult, maxRows, email);
		return new LinkedHashSet<Client>(query.getResultList());
	}

	/**
	 * JPQL Query - findClientByCity
	 *
	 */
	@Transactional
	public Set<Client> findClientByCity(String city) throws DataAccessException {

		return findClientByCity(city, -1, -1);
	}

	/**
	 * JPQL Query - findClientByCity
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Client> findClientByCity(String city, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findClientByCity", startResult, maxRows, city);
		return new LinkedHashSet<Client>(query.getResultList());
	}

	/**
	 * JPQL Query - findClientByEmail
	 *
	 */
	@Transactional
	public Set<Client> findClientByEmail(String email) throws DataAccessException {

		return findClientByEmail(email, -1, -1);
	}

	/**
	 * JPQL Query - findClientByEmail
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Client> findClientByEmail(String email, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findClientByEmail", startResult, maxRows, email);
		return new LinkedHashSet<Client>(query.getResultList());
	}

	/**
	 * JPQL Query - findClientByActiveYn
	 *
	 */
	@Transactional
	public Set<Client> findClientByActiveYn(Integer activeYn) throws DataAccessException {

		return findClientByActiveYn(activeYn, -1, -1);
	}

	/**
	 * JPQL Query - findClientByActiveYn
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Client> findClientByActiveYn(Integer activeYn, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findClientByActiveYn", startResult, maxRows, activeYn);
		return new LinkedHashSet<Client>(query.getResultList());
	}

	/**
	 * JPQL Query - findClientByLogoFilenameContaining
	 *
	 */
	@Transactional
	public Set<Client> findClientByLogoFilenameContaining(String logoFilename) throws DataAccessException {

		return findClientByLogoFilenameContaining(logoFilename, -1, -1);
	}

	/**
	 * JPQL Query - findClientByLogoFilenameContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Client> findClientByLogoFilenameContaining(String logoFilename, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findClientByLogoFilenameContaining", startResult, maxRows, logoFilename);
		return new LinkedHashSet<Client>(query.getResultList());
	}

	/**
	 * JPQL Query - findClientByAddress
	 *
	 */
	@Transactional
	public Set<Client> findClientByAddress(String address) throws DataAccessException {

		return findClientByAddress(address, -1, -1);
	}

	/**
	 * JPQL Query - findClientByAddress
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Client> findClientByAddress(String address, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findClientByAddress", startResult, maxRows, address);
		return new LinkedHashSet<Client>(query.getResultList());
	}

	/**
	 * JPQL Query - findClientByAddressContaining
	 *
	 */
	@Transactional
	public Set<Client> findClientByAddressContaining(String address) throws DataAccessException {

		return findClientByAddressContaining(address, -1, -1);
	}

	/**
	 * JPQL Query - findClientByAddressContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Client> findClientByAddressContaining(String address, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findClientByAddressContaining", startResult, maxRows, address);
		return new LinkedHashSet<Client>(query.getResultList());
	}

	/**
	 * JPQL Query - findClientByState
	 *
	 */
	@Transactional
	public Set<Client> findClientByState(String state) throws DataAccessException {

		return findClientByState(state, -1, -1);
	}

	/**
	 * JPQL Query - findClientByState
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Client> findClientByState(String state, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findClientByState", startResult, maxRows, state);
		return new LinkedHashSet<Client>(query.getResultList());
	}

	/**
	 * JPQL Query - findClientByWebsite
	 *
	 */
	@Transactional
	public Set<Client> findClientByWebsite(String website) throws DataAccessException {

		return findClientByWebsite(website, -1, -1);
	}

	/**
	 * JPQL Query - findClientByWebsite
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Client> findClientByWebsite(String website, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findClientByWebsite", startResult, maxRows, website);
		return new LinkedHashSet<Client>(query.getResultList());
	}

	/**
	 * JPQL Query - findClientByClientNameContaining
	 *
	 */
	@Transactional
	public Set<Client> findClientByClientNameContaining(String clientName) throws DataAccessException {

		return findClientByClientNameContaining(clientName, -1, -1);
	}

	/**
	 * JPQL Query - findClientByClientNameContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Client> findClientByClientNameContaining(String clientName, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findClientByClientNameContaining", startResult, maxRows, clientName);
		return new LinkedHashSet<Client>(query.getResultList());
	}

	/**
	 * JPQL Query - findClientByLogoFilename
	 *
	 */
	@Transactional
	public Set<Client> findClientByLogoFilename(String logoFilename) throws DataAccessException {

		return findClientByLogoFilename(logoFilename, -1, -1);
	}

	/**
	 * JPQL Query - findClientByLogoFilename
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Client> findClientByLogoFilename(String logoFilename, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findClientByLogoFilename", startResult, maxRows, logoFilename);
		return new LinkedHashSet<Client>(query.getResultList());
	}

	/**
	 * JPQL Query - findClientByPrimaryKey
	 *
	 */
	@Transactional
	public Client findClientByPrimaryKey(Integer clientId) throws DataAccessException {

		return findClientByPrimaryKey(clientId, -1, -1);
	}

	/**
	 * JPQL Query - findClientByPrimaryKey
	 *
	 */

	@Transactional
	public Client findClientByPrimaryKey(Integer clientId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findClientByPrimaryKey", startResult, maxRows, clientId);
			return (pm7.domain.Client) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findClientByCityContaining
	 *
	 */
	@Transactional
	public Set<Client> findClientByCityContaining(String city) throws DataAccessException {

		return findClientByCityContaining(city, -1, -1);
	}

	/**
	 * JPQL Query - findClientByCityContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Client> findClientByCityContaining(String city, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findClientByCityContaining", startResult, maxRows, city);
		return new LinkedHashSet<Client>(query.getResultList());
	}

	/**
	 * JPQL Query - findClientByPhone
	 *
	 */
	@Transactional
	public Set<Client> findClientByPhone(String phone) throws DataAccessException {

		return findClientByPhone(phone, -1, -1);
	}

	/**
	 * JPQL Query - findClientByPhone
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Client> findClientByPhone(String phone, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findClientByPhone", startResult, maxRows, phone);
		return new LinkedHashSet<Client>(query.getResultList());
	}

	/**
	 * JPQL Query - findClientByZipContaining
	 *
	 */
	@Transactional
	public Set<Client> findClientByZipContaining(String zip) throws DataAccessException {

		return findClientByZipContaining(zip, -1, -1);
	}

	/**
	 * JPQL Query - findClientByZipContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Client> findClientByZipContaining(String zip, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findClientByZipContaining", startResult, maxRows, zip);
		return new LinkedHashSet<Client>(query.getResultList());
	}

	/**
	 * JPQL Query - findClientByStateContaining
	 *
	 */
	@Transactional
	public Set<Client> findClientByStateContaining(String state) throws DataAccessException {

		return findClientByStateContaining(state, -1, -1);
	}

	/**
	 * JPQL Query - findClientByStateContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Client> findClientByStateContaining(String state, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findClientByStateContaining", startResult, maxRows, state);
		return new LinkedHashSet<Client>(query.getResultList());
	}

	/**
	 * JPQL Query - findClientByPhoneContaining
	 *
	 */
	@Transactional
	public Set<Client> findClientByPhoneContaining(String phone) throws DataAccessException {

		return findClientByPhoneContaining(phone, -1, -1);
	}

	/**
	 * JPQL Query - findClientByPhoneContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Client> findClientByPhoneContaining(String phone, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findClientByPhoneContaining", startResult, maxRows, phone);
		return new LinkedHashSet<Client>(query.getResultList());
	}

	/**
	 * Used to determine whether or not to merge the entity or persist the entity when calling Store
	 * @see store
	 * 
	 *
	 */
	public boolean canBeMerged(Client entity) {
		return true;
	}
	
	public Integer getMaxClientId() {
		Object obj = executeQuerySingleResult("select max(clientId) from Client");
		if(obj!=null){
			return (Integer)obj;
		}
		return 0;
	}
}