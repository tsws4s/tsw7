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

import tsw.domain.Sport;

/**
 * DAO to manage Sport entities.
 * 
 */
@Repository("SportDAO")
@Transactional
public class SportDAOImpl extends AbstractJpaDao<Sport> implements SportDAO {

	/**
	 * Set of entity classes managed by this DAO.  Typically a DAO manages a single entity.
	 *
	 */
	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[] { Sport.class }));

	/**
	 * EntityManager injected by Spring for persistence unit mysql_tsw
	 *
	 */
	@PersistenceContext(unitName = "tsws4s_4")
	private EntityManager entityManager;

	/**
	 * Instantiates a new SportDAOImpl
	 *
	 */
	public SportDAOImpl() {
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
	 * JPQL Query - findSportByNumGamePlayers
	 *
	 */
	@Transactional
	public Set<Sport> findSportByNumGamePlayers(Integer numGamePlayers) throws DataAccessException {

		return findSportByNumGamePlayers(numGamePlayers, -1, -1);
	}

	/**
	 * JPQL Query - findSportByNumGamePlayers
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Sport> findSportByNumGamePlayers(Integer numGamePlayers, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findSportByNumGamePlayers", startResult, maxRows, numGamePlayers);
		return new LinkedHashSet<Sport>(query.getResultList());
	}

	/**
	 * JPQL Query - findAllSports
	 *
	 */
	@Transactional
	public Set<Sport> findAllSports() throws DataAccessException {

		return findAllSports(-1, -1);
	}

	/**
	 * JPQL Query - findAllSports
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Sport> findAllSports(int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAllSports", startResult, maxRows);
		return new LinkedHashSet<Sport>(query.getResultList());
	}

	/**
	 * JPQL Query - findSportBySportName
	 *
	 */
	@Transactional
	public Set<Sport> findSportBySportName(String sportName) throws DataAccessException {

		return findSportBySportName(sportName, -1, -1);
	}

	/**
	 * JPQL Query - findSportBySportName
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Sport> findSportBySportName(String sportName, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findSportBySportName", startResult, maxRows, sportName);
		return new LinkedHashSet<Sport>(query.getResultList());
	}

	/**
	 * JPQL Query - findSportByNumTeamRoster
	 *
	 */
	@Transactional
	public Set<Sport> findSportByNumTeamRoster(Integer numTeamRoster) throws DataAccessException {

		return findSportByNumTeamRoster(numTeamRoster, -1, -1);
	}

	/**
	 * JPQL Query - findSportByNumTeamRoster
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Sport> findSportByNumTeamRoster(Integer numTeamRoster, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findSportByNumTeamRoster", startResult, maxRows, numTeamRoster);
		return new LinkedHashSet<Sport>(query.getResultList());
	}

	/**
	 * JPQL Query - findSportByNormalSeason
	 *
	 */
	@Transactional
	public Set<Sport> findSportByNormalSeason(String normalSeason) throws DataAccessException {

		return findSportByNormalSeason(normalSeason, -1, -1);
	}

	/**
	 * JPQL Query - findSportByNormalSeason
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Sport> findSportByNormalSeason(String normalSeason, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findSportByNormalSeason", startResult, maxRows, normalSeason);
		return new LinkedHashSet<Sport>(query.getResultList());
	}

	/**
	 * JPQL Query - findSportByWikiUrl
	 *
	 */
	@Transactional
	public Set<Sport> findSportByWikiUrl(String wikiUrl) throws DataAccessException {

		return findSportByWikiUrl(wikiUrl, -1, -1);
	}

	/**
	 * JPQL Query - findSportByWikiUrl
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Sport> findSportByWikiUrl(String wikiUrl, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findSportByWikiUrl", startResult, maxRows, wikiUrl);
		return new LinkedHashSet<Sport>(query.getResultList());
	}

	/**
	 * JPQL Query - findSportByPrimaryKey
	 *
	 */
	@Transactional
	public Sport findSportByPrimaryKey(Integer sportId) throws DataAccessException {

		return findSportByPrimaryKey(sportId, -1, -1);
	}

	/**
	 * JPQL Query - findSportByPrimaryKey
	 *
	 */

	@Transactional
	public Sport findSportByPrimaryKey(Integer sportId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findSportByPrimaryKey", startResult, maxRows, sportId);
			return (tsw.domain.Sport) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findSportByActiveYn
	 *
	 */
	@Transactional
	public Set<Sport> findSportByActiveYn(Integer activeYn) throws DataAccessException {

		return findSportByActiveYn(activeYn, -1, -1);
	}

	/**
	 * JPQL Query - findSportByActiveYn
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Sport> findSportByActiveYn(Integer activeYn, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findSportByActiveYn", startResult, maxRows, activeYn);
		return new LinkedHashSet<Sport>(query.getResultList());
	}

	/**
	 * JPQL Query - findSportBySportNameContaining
	 *
	 */
	@Transactional
	public Set<Sport> findSportBySportNameContaining(String sportName) throws DataAccessException {

		return findSportBySportNameContaining(sportName, -1, -1);
	}

	/**
	 * JPQL Query - findSportBySportNameContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Sport> findSportBySportNameContaining(String sportName, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findSportBySportNameContaining", startResult, maxRows, sportName);
		return new LinkedHashSet<Sport>(query.getResultList());
	}

	/**
	 * JPQL Query - findSportByNormalSeasonContaining
	 *
	 */
	@Transactional
	public Set<Sport> findSportByNormalSeasonContaining(String normalSeason) throws DataAccessException {

		return findSportByNormalSeasonContaining(normalSeason, -1, -1);
	}

	/**
	 * JPQL Query - findSportByNormalSeasonContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Sport> findSportByNormalSeasonContaining(String normalSeason, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findSportByNormalSeasonContaining", startResult, maxRows, normalSeason);
		return new LinkedHashSet<Sport>(query.getResultList());
	}

	/**
	 * JPQL Query - findSportBySportId
	 *
	 */
	@Transactional
	public Sport findSportBySportId(Integer sportId) throws DataAccessException {

		return findSportBySportId(sportId, -1, -1);
	}

	/**
	 * JPQL Query - findSportBySportId
	 *
	 */

	@Transactional
	public Sport findSportBySportId(Integer sportId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findSportBySportId", startResult, maxRows, sportId);
			return (tsw.domain.Sport) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findSportByWikiUrlContaining
	 *
	 */
	@Transactional
	public Set<Sport> findSportByWikiUrlContaining(String wikiUrl) throws DataAccessException {

		return findSportByWikiUrlContaining(wikiUrl, -1, -1);
	}

	/**
	 * JPQL Query - findSportByWikiUrlContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Sport> findSportByWikiUrlContaining(String wikiUrl, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findSportByWikiUrlContaining", startResult, maxRows, wikiUrl);
		return new LinkedHashSet<Sport>(query.getResultList());
	}

	/**
	 * Used to determine whether or not to merge the entity or persist the entity when calling Store
	 * @see store
	 * 
	 *
	 */
	public boolean canBeMerged(Sport entity) {
		return true;
	}
}
