package myinfo.dao;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import myinfo.domain.Books;

import org.skyway.spring.util.dao.AbstractJpaDao;

import org.springframework.dao.DataAccessException;

import org.springframework.stereotype.Repository;

import org.springframework.transaction.annotation.Transactional;

/**
 * DAO to manage Books entities.
 * 
 */
@Repository("BooksDAO")
@Transactional
public class BooksDAOImpl extends AbstractJpaDao<Books> implements BooksDAO {

	/**
	 * Set of entity classes managed by this DAO.  Typically a DAO manages a single entity.
	 *
	 */
	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[] { Books.class }));

	/**
	 * EntityManager injected by Spring for persistence unit mySQL_myInfo
	 *
	 */
	@PersistenceContext(unitName = "mySQL_myInfo")
	private EntityManager entityManager;

	/**
	 * Instantiates a new BooksDAOImpl
	 *
	 */
	public BooksDAOImpl() {
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
	 * JPQL Query - findAllBookss
	 *
	 */
	@Transactional
	public Set<Books> findAllBookss() throws DataAccessException {

		return findAllBookss(-1, -1);
	}

	/**
	 * JPQL Query - findAllBookss
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Books> findAllBookss(int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAllBookss", startResult, maxRows);
		return new LinkedHashSet<Books>(query.getResultList());
	}

	/**
	 * JPQL Query - findBooksByUserFk
	 *
	 */
	@Transactional
	public Set<Books> findBooksByUserFk(Integer userFk) throws DataAccessException {

		return findBooksByUserFk(userFk, -1, -1);
	}

	/**
	 * JPQL Query - findBooksByUserFk
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Books> findBooksByUserFk(Integer userFk, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findBooksByUserFk", startResult, maxRows, userFk);
		return new LinkedHashSet<Books>(query.getResultList());
	}

	/**
	 * JPQL Query - findBooksByBookId
	 *
	 */
	@Transactional
	public Books findBooksByBookId(Integer bookId) throws DataAccessException {

		return findBooksByBookId(bookId, -1, -1);
	}

	/**
	 * JPQL Query - findBooksByBookId
	 *
	 */

	@Transactional
	public Books findBooksByBookId(Integer bookId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findBooksByBookId", startResult, maxRows, bookId);
			return (myinfo.domain.Books) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findBooksByFormatContaining
	 *
	 */
	@Transactional
	public Set<Books> findBooksByFormatContaining(String format) throws DataAccessException {

		return findBooksByFormatContaining(format, -1, -1);
	}

	/**
	 * JPQL Query - findBooksByFormatContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Books> findBooksByFormatContaining(String format, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findBooksByFormatContaining", startResult, maxRows, format);
		return new LinkedHashSet<Books>(query.getResultList());
	}

	/**
	 * JPQL Query - findBooksByAsinIsbn
	 *
	 */
	@Transactional
	public Set<Books> findBooksByAsinIsbn(String asinIsbn) throws DataAccessException {

		return findBooksByAsinIsbn(asinIsbn, -1, -1);
	}

	/**
	 * JPQL Query - findBooksByAsinIsbn
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Books> findBooksByAsinIsbn(String asinIsbn, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findBooksByAsinIsbn", startResult, maxRows, asinIsbn);
		return new LinkedHashSet<Books>(query.getResultList());
	}

	/**
	 * JPQL Query - findBooksByReleaseDateAfter
	 *
	 */
	@Transactional
	public Set<Books> findBooksByReleaseDateAfter(java.util.Calendar releaseDate) throws DataAccessException {

		return findBooksByReleaseDateAfter(releaseDate, -1, -1);
	}

	/**
	 * JPQL Query - findBooksByReleaseDateAfter
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Books> findBooksByReleaseDateAfter(java.util.Calendar releaseDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findBooksByReleaseDateAfter", startResult, maxRows, releaseDate);
		return new LinkedHashSet<Books>(query.getResultList());
	}

	/**
	 * JPQL Query - findBooksByReleaseDateBefore
	 *
	 */
	@Transactional
	public Set<Books> findBooksByReleaseDateBefore(java.util.Calendar releaseDate) throws DataAccessException {

		return findBooksByReleaseDateBefore(releaseDate, -1, -1);
	}

	/**
	 * JPQL Query - findBooksByReleaseDateBefore
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Books> findBooksByReleaseDateBefore(java.util.Calendar releaseDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findBooksByReleaseDateBefore", startResult, maxRows, releaseDate);
		return new LinkedHashSet<Books>(query.getResultList());
	}

	/**
	 * JPQL Query - findBooksByAuthor
	 *
	 */
	@Transactional
	public Set<Books> findBooksByAuthor(String author) throws DataAccessException {

		return findBooksByAuthor(author, -1, -1);
	}

	/**
	 * JPQL Query - findBooksByAuthor
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Books> findBooksByAuthor(String author, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findBooksByAuthor", startResult, maxRows, author);
		return new LinkedHashSet<Books>(query.getResultList());
	}

	/**
	 * JPQL Query - findBooksByFormat
	 *
	 */
	@Transactional
	public Set<Books> findBooksByFormat(String format) throws DataAccessException {

		return findBooksByFormat(format, -1, -1);
	}

	/**
	 * JPQL Query - findBooksByFormat
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Books> findBooksByFormat(String format, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findBooksByFormat", startResult, maxRows, format);
		return new LinkedHashSet<Books>(query.getResultList());
	}

	/**
	 * JPQL Query - findBooksByPrice
	 *
	 */
	@Transactional
	public Set<Books> findBooksByPrice(java.math.BigDecimal price) throws DataAccessException {

		return findBooksByPrice(price, -1, -1);
	}

	/**
	 * JPQL Query - findBooksByPrice
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Books> findBooksByPrice(java.math.BigDecimal price, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findBooksByPrice", startResult, maxRows, price);
		return new LinkedHashSet<Books>(query.getResultList());
	}

	/**
	 * JPQL Query - findBooksByOrderDateAfter
	 *
	 */
	@Transactional
	public Set<Books> findBooksByOrderDateAfter(java.util.Calendar orderDate) throws DataAccessException {

		return findBooksByOrderDateAfter(orderDate, -1, -1);
	}

	/**
	 * JPQL Query - findBooksByOrderDateAfter
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Books> findBooksByOrderDateAfter(java.util.Calendar orderDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findBooksByOrderDateAfter", startResult, maxRows, orderDate);
		return new LinkedHashSet<Books>(query.getResultList());
	}

	/**
	 * JPQL Query - findBooksByAsinIsbnContaining
	 *
	 */
	@Transactional
	public Set<Books> findBooksByAsinIsbnContaining(String asinIsbn) throws DataAccessException {

		return findBooksByAsinIsbnContaining(asinIsbn, -1, -1);
	}

	/**
	 * JPQL Query - findBooksByAsinIsbnContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Books> findBooksByAsinIsbnContaining(String asinIsbn, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findBooksByAsinIsbnContaining", startResult, maxRows, asinIsbn);
		return new LinkedHashSet<Books>(query.getResultList());
	}

	/**
	 * JPQL Query - findBooksByOrderDateBefore
	 *
	 */
	@Transactional
	public Set<Books> findBooksByOrderDateBefore(java.util.Calendar orderDate) throws DataAccessException {

		return findBooksByOrderDateBefore(orderDate, -1, -1);
	}

	/**
	 * JPQL Query - findBooksByOrderDateBefore
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Books> findBooksByOrderDateBefore(java.util.Calendar orderDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findBooksByOrderDateBefore", startResult, maxRows, orderDate);
		return new LinkedHashSet<Books>(query.getResultList());
	}

	/**
	 * JPQL Query - findBooksByPrimaryKey
	 *
	 */
	@Transactional
	public Books findBooksByPrimaryKey(Integer bookId) throws DataAccessException {

		return findBooksByPrimaryKey(bookId, -1, -1);
	}

	/**
	 * JPQL Query - findBooksByPrimaryKey
	 *
	 */

	@Transactional
	public Books findBooksByPrimaryKey(Integer bookId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findBooksByPrimaryKey", startResult, maxRows, bookId);
			return (myinfo.domain.Books) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findBooksByTitle
	 *
	 */
	@Transactional
	public Set<Books> findBooksByTitle(String title) throws DataAccessException {

		return findBooksByTitle(title, -1, -1);
	}

	/**
	 * JPQL Query - findBooksByTitle
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Books> findBooksByTitle(String title, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findBooksByTitle", startResult, maxRows, title);
		return new LinkedHashSet<Books>(query.getResultList());
	}

	/**
	 * JPQL Query - findBooksByOrderDate
	 *
	 */
	@Transactional
	public Set<Books> findBooksByOrderDate(java.util.Calendar orderDate) throws DataAccessException {

		return findBooksByOrderDate(orderDate, -1, -1);
	}

	/**
	 * JPQL Query - findBooksByOrderDate
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Books> findBooksByOrderDate(java.util.Calendar orderDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findBooksByOrderDate", startResult, maxRows, orderDate);
		return new LinkedHashSet<Books>(query.getResultList());
	}

	/**
	 * JPQL Query - findBooksByAuthorContaining
	 *
	 */
	@Transactional
	public Set<Books> findBooksByAuthorContaining(String author) throws DataAccessException {

		return findBooksByAuthorContaining(author, -1, -1);
	}

	/**
	 * JPQL Query - findBooksByAuthorContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Books> findBooksByAuthorContaining(String author, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findBooksByAuthorContaining", startResult, maxRows, author);
		return new LinkedHashSet<Books>(query.getResultList());
	}

	/**
	 * JPQL Query - findBooksByTitleContaining
	 *
	 */
	@Transactional
	public Set<Books> findBooksByTitleContaining(String title) throws DataAccessException {

		return findBooksByTitleContaining(title, -1, -1);
	}

	/**
	 * JPQL Query - findBooksByTitleContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Books> findBooksByTitleContaining(String title, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findBooksByTitleContaining", startResult, maxRows, title);
		return new LinkedHashSet<Books>(query.getResultList());
	}

	/**
	 * JPQL Query - findBooksByReleaseDate
	 *
	 */
	@Transactional
	public Set<Books> findBooksByReleaseDate(java.util.Calendar releaseDate) throws DataAccessException {

		return findBooksByReleaseDate(releaseDate, -1, -1);
	}

	/**
	 * JPQL Query - findBooksByReleaseDate
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Books> findBooksByReleaseDate(java.util.Calendar releaseDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findBooksByReleaseDate", startResult, maxRows, releaseDate);
		return new LinkedHashSet<Books>(query.getResultList());
	}

	/**
	 * Used to determine whether or not to merge the entity or persist the entity when calling Store
	 * @see store
	 * 
	 *
	 */
	public boolean canBeMerged(Books entity) {
		return true;
	}
}
