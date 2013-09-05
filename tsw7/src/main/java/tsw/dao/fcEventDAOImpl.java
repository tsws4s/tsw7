package tsw.dao;

import java.util.Arrays;
import java.util.Calendar;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.joda.time.MutableDateTime;
import org.skyway.spring.util.dao.AbstractJpaDao;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import tsw.domain.fcEvent;
import tsw.web.UsersController;

/**
 * DAO to manage fcEvent entities.
 * 
 */
@Repository("fcEventDAO")
@Transactional
public class fcEventDAOImpl extends AbstractJpaDao<fcEvent> implements
		fcEventDAO {
	
	int defaultMaxRows = UsersController.getDefaultMaxRows();

	/**
	 * Set of entity classes managed by this DAO.  Typically a DAO manages a single entity.
	 *
	 */
	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[] { fcEvent.class }));

	/**
	 * EntityManager injected by Spring for persistence unit tsws4s_4
	 *
	 */
	@PersistenceContext(unitName = "tsws4s_4")
	private EntityManager entityManager;
	
	/**
	 * Instantiates a new fcEventDAOImpl
	 *
	 */
	public fcEventDAOImpl() {
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
	 * JPQL Query - findfcEventByTitleContaining
	 *
	 */
	@Transactional
	public Set<fcEvent> findfcEventByTitleContaining(String title) throws DataAccessException {

		return findfcEventByTitleContaining(title, -1, defaultMaxRows);
	}

	/**
	 * JPQL Query - findfcEventByTitleContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<fcEvent> findfcEventByTitleContaining(String title, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findfcEventByTitleContaining", startResult, maxRows, title);
		return new LinkedHashSet<fcEvent>(query.getResultList());
	}

	/**
	 * JPQL Query - findAllfcEvents
	 *
	 */
	@Transactional
	public Set<fcEvent> findAllfcEvents4tsw(Integer tswId) throws DataAccessException {
		return findAllfcEvents4tsw(tswId, -1, defaultMaxRows);
	}
	@Transactional
	public Set<fcEvent> findAllfcEvents4tswResource(Integer tswId,Integer resId) throws DataAccessException {
		return findAllfcEvents4tswResource(tswId, resId, -1, defaultMaxRows);
	}

	/**
	 * JPQL Query - findAllfcEvents
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<fcEvent> findAllfcEvents4tsw(Integer tswId, int startResult, int maxRows) throws DataAccessException {
		// TODO: [assignedTo] (Calendar-Hi) Add filter for events...Resource, League Games
		Query query = createNamedQuery("findAllfcEvents4tsw", startResult, maxRows, tswId);
		return new LinkedHashSet<fcEvent>(query.getResultList());
	}
	@SuppressWarnings("unchecked")
	@Transactional
	public Set<fcEvent> findAllfcEvents4tswResource(Integer tswId, Integer resId, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAllfcEvents4tswResource", startResult, maxRows, tswId, resId);
		Set<fcEvent> result = new LinkedHashSet<fcEvent>(query.getResultList());
		return result;
	}
	
	/**
	 * JPQL Query - findfcEventByUrl
	 *
	 */
	@Transactional
	public Set<fcEvent> findfcEventByUrl(String url) throws DataAccessException {

		return findfcEventByUrl(url, -1, defaultMaxRows);
	}

	/**
	 * JPQL Query - findfcEventByUrl
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<fcEvent> findfcEventByUrl(String url, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findfcEventByUrl", startResult, maxRows, url);
		return new LinkedHashSet<fcEvent>(query.getResultList());
	}

	/**
	 * JPQL Query - findfcEventByEnd
	 *
	 */
	@Transactional
	public Set<fcEvent> findfcEventByEnd(java.util.Calendar end) throws DataAccessException {

		return findfcEventByEnd(end, -1, defaultMaxRows);
	}

	/**
	 * JPQL Query - findfcEventByEnd
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<fcEvent> findfcEventByEnd(java.util.Calendar end, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findfcEventByEnd", startResult, maxRows, end);
		return new LinkedHashSet<fcEvent>(query.getResultList());
	}
	
	/**
	 * JPQL Query - findfcEventByUrlContaining
	 *
	 */
	@Transactional
	public Set<fcEvent> findfcEventByUrlContaining(String url) throws DataAccessException {

		return findfcEventByUrlContaining(url, -1, defaultMaxRows);
	}

	/**
	 * JPQL Query - findfcEventByUrlContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<fcEvent> findfcEventByUrlContaining(String url, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findfcEventByUrlContaining", startResult, maxRows, url);
		return new LinkedHashSet<fcEvent>(query.getResultList());
	}

	/**
	 * JPQL Query - findfcEventByTitle
	 *
	 */
	@Transactional
	public Set<fcEvent> findfcEventByTitle(String title) throws DataAccessException {

		return findfcEventByTitle(title, -1, defaultMaxRows);
	}

	/**
	 * JPQL Query - findfcEventByTitle
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<fcEvent> findfcEventByTitle(String title, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findfcEventByTitle", startResult, maxRows, title);
		return new LinkedHashSet<fcEvent>(query.getResultList());
	}

	/**
	 * JPQL Query - findfcEventByAllDay
	 *
	 */
	@Transactional
	public Set<fcEvent> findfcEventByAllDay(Boolean allDay) throws DataAccessException {

		return findfcEventByAllDay(allDay, -1, defaultMaxRows);
	}

	/**
	 * JPQL Query - findfcEventByAllDay
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<fcEvent> findfcEventByAllDay(Boolean allDay, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findfcEventByAllDay", startResult, maxRows, allDay);
		return new LinkedHashSet<fcEvent>(query.getResultList());
	}

	/**
	 * JPQL Query - findfcEventByClassNameContaining
	 *
	 */
	@Transactional
	public Set<fcEvent> findfcEventByClassNameContaining(String className) throws DataAccessException {

		return findfcEventByClassNameContaining(className, -1, defaultMaxRows);
	}

	/**
	 * JPQL Query - findfcEventByClassNameContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<fcEvent> findfcEventByClassNameContaining(String className, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findfcEventByClassNameContaining", startResult, maxRows, className);
		return new LinkedHashSet<fcEvent>(query.getResultList());
	}

	/**
	 * JPQL Query - findfcEventByColorContaining
	 *
	 */
	@Transactional
	public Set<fcEvent> findfcEventByColorContaining(String color) throws DataAccessException {

		return findfcEventByColorContaining(color, -1, defaultMaxRows);
	}

	/**
	 * JPQL Query - findfcEventByColorContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<fcEvent> findfcEventByColorContaining(String color, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findfcEventByColorContaining", startResult, maxRows, color);
		return new LinkedHashSet<fcEvent>(query.getResultList());
	}


	/**
	 * JPQL Query - findfcEventByClassName
	 *
	 */
	@Transactional
	public Set<fcEvent> findfcEventByClassName(String className) throws DataAccessException {

		return findfcEventByClassName(className, -1, defaultMaxRows);
	}

	/**
	 * JPQL Query - findfcEventByClassName
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<fcEvent> findfcEventByClassName(String className, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findfcEventByClassName", startResult, maxRows, className);
		return new LinkedHashSet<fcEvent>(query.getResultList());
	}

	/**
	 * JPQL Query - findfcEventByTextColor
	 *
	 */
	@Transactional
	public Set<fcEvent> findfcEventByTextColor(String textColor) throws DataAccessException {

		return findfcEventByTextColor(textColor, -1, defaultMaxRows);
	}

	/**
	 * JPQL Query - findfcEventByTextColor
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<fcEvent> findfcEventByTextColor(String textColor, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findfcEventByTextColor", startResult, maxRows, textColor);
		return new LinkedHashSet<fcEvent>(query.getResultList());
	}

	/**
	 * JPQL Query - findfcEventByEditable
	 *
	 */
	@Transactional
	public Set<fcEvent> findfcEventByEditable(Boolean editable) throws DataAccessException {

		return findfcEventByEditable(editable, -1, defaultMaxRows);
	}

	/**
	 * JPQL Query - findfcEventByEditable
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<fcEvent> findfcEventByEditable(Boolean editable, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findfcEventByEditable", startResult, maxRows, editable);
		return new LinkedHashSet<fcEvent>(query.getResultList());
	}

	/**
	 * JPQL Query - findfcEventByColor
	 *
	 */
	@Transactional
	public Set<fcEvent> findfcEventByColor(String color) throws DataAccessException {

		return findfcEventByColor(color, -1, defaultMaxRows);
	}

	/**
	 * JPQL Query - findfcEventByColor
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<fcEvent> findfcEventByColor(String color, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findfcEventByColor", startResult, maxRows, color);
		return new LinkedHashSet<fcEvent>(query.getResultList());
	}

	/**
	 * JPQL Query - findfcEventByPrimaryKey
	 *
	 */
	@Transactional
	public fcEvent findfcEventByPrimaryKey(Integer id) throws DataAccessException {

		return findfcEventByPrimaryKey(id, -1, defaultMaxRows);
	}

	/**
	 * JPQL Query - findfcEventByPrimaryKey
	 *
	 */

	@Transactional
	public fcEvent findfcEventByPrimaryKey(Integer id, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findfcEventByPrimaryKey", startResult, maxRows, id);
			return (tsw.domain.fcEvent) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findfcEventByStart
	 *
	 */
	@Transactional
	public Set<fcEvent> findfcEventByStart(java.util.Calendar start) throws DataAccessException {

		return findfcEventByStart(start, -1, defaultMaxRows);
	}

	/**
	 * JPQL Query - findfcEventByStart
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<fcEvent> findfcEventByStart(java.util.Calendar start, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findfcEventByStart", startResult, maxRows, start);
		return new LinkedHashSet<fcEvent>(query.getResultList());
	}

	/**
	 * JPQL Query - findfcEventById
	 *
	 */
	@Transactional
	public fcEvent findfcEventById(Integer id) throws DataAccessException {

		return findfcEventById(id, -1, defaultMaxRows);
	}

	/**
	 * JPQL Query - findfcEventById
	 *
	 */

	@Transactional
	public fcEvent findfcEventById(Integer id, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findfcEventById", startResult, maxRows, id);
			return (tsw.domain.fcEvent) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}
	@Transactional
	public Set<fcEvent> findfcEventByResourceDateAfterBefore(Integer resource_id, Calendar afterDate, Calendar beforeDate) throws DataAccessException {
		return findfcEventByResourceDateAfterBefore(resource_id, afterDate, beforeDate, -1, defaultMaxRows);
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public Set<fcEvent> findfcEventByResourceDateAfterBefore(Integer resourceId, Calendar afterDate, Calendar beforeDate, int startResult, int maxRows) throws DataAccessException {
		if(resourceId==null){
//			resourceId=tswacctDAO.getSessionConfig().getDefaultResourceId();
		}
		if(afterDate==null){
			MutableDateTime dt = MutableDateTime.now();
			dt.setDayOfMonth(1);
			dt.addDays(-1);
			afterDate = dt.toGregorianCalendar();			
		}
		if(beforeDate==null){
			MutableDateTime dt = MutableDateTime.now();
			dt.addDays(1);
			beforeDate = dt.toGregorianCalendar();			
		}
		Query query = createNamedQuery("findfcEventByDateAfterBefore", startResult, maxRows, resourceId, afterDate, beforeDate);
		return new LinkedHashSet<fcEvent>(query.getResultList());
	}
	
	/**
	 * Used to determine whether or not to merge the entity or persist the entity when calling Store
	 * @see store
	 * 
	 *
	 */
	public boolean canBeMerged(fcEvent entity) {
		return true;
	}
}
