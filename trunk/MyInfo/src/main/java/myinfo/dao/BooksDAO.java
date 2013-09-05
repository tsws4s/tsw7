package myinfo.dao;

import java.math.BigDecimal;

import java.util.Calendar;
import java.util.Set;

import myinfo.domain.Books;

import org.skyway.spring.util.dao.JpaDao;

import org.springframework.dao.DataAccessException;

/**
 * DAO to manage Books entities.
 * 
 */
public interface BooksDAO extends JpaDao<Books> {

	/**
	 * JPQL Query - findAllBookss
	 *
	 */
	public Set<Books> findAllBookss() throws DataAccessException;

	/**
	 * JPQL Query - findAllBookss
	 *
	 */
	public Set<Books> findAllBookss(int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findBooksByUserFk
	 *
	 */
	public Set<Books> findBooksByUserFk(Integer userFk) throws DataAccessException;

	/**
	 * JPQL Query - findBooksByUserFk
	 *
	 */
	public Set<Books> findBooksByUserFk(Integer userFk, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findBooksByBookId
	 *
	 */
	public Books findBooksByBookId(Integer bookId) throws DataAccessException;

	/**
	 * JPQL Query - findBooksByBookId
	 *
	 */
	public Books findBooksByBookId(Integer bookId, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findBooksByFormatContaining
	 *
	 */
	public Set<Books> findBooksByFormatContaining(String format) throws DataAccessException;

	/**
	 * JPQL Query - findBooksByFormatContaining
	 *
	 */
	public Set<Books> findBooksByFormatContaining(String format, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findBooksByAsinIsbn
	 *
	 */
	public Set<Books> findBooksByAsinIsbn(String asinIsbn) throws DataAccessException;

	/**
	 * JPQL Query - findBooksByAsinIsbn
	 *
	 */
	public Set<Books> findBooksByAsinIsbn(String asinIsbn, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findBooksByReleaseDateAfter
	 *
	 */
	public Set<Books> findBooksByReleaseDateAfter(java.util.Calendar releaseDate) throws DataAccessException;

	/**
	 * JPQL Query - findBooksByReleaseDateAfter
	 *
	 */
	public Set<Books> findBooksByReleaseDateAfter(Calendar releaseDate, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findBooksByReleaseDateBefore
	 *
	 */
	public Set<Books> findBooksByReleaseDateBefore(java.util.Calendar releaseDate_1) throws DataAccessException;

	/**
	 * JPQL Query - findBooksByReleaseDateBefore
	 *
	 */
	public Set<Books> findBooksByReleaseDateBefore(Calendar releaseDate_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findBooksByAuthor
	 *
	 */
	public Set<Books> findBooksByAuthor(String author) throws DataAccessException;

	/**
	 * JPQL Query - findBooksByAuthor
	 *
	 */
	public Set<Books> findBooksByAuthor(String author, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findBooksByFormat
	 *
	 */
	public Set<Books> findBooksByFormat(String format_1) throws DataAccessException;

	/**
	 * JPQL Query - findBooksByFormat
	 *
	 */
	public Set<Books> findBooksByFormat(String format_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findBooksByPrice
	 *
	 */
	public Set<Books> findBooksByPrice(java.math.BigDecimal price) throws DataAccessException;

	/**
	 * JPQL Query - findBooksByPrice
	 *
	 */
	public Set<Books> findBooksByPrice(BigDecimal price, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findBooksByOrderDateAfter
	 *
	 */
	public Set<Books> findBooksByOrderDateAfter(java.util.Calendar orderDate) throws DataAccessException;

	/**
	 * JPQL Query - findBooksByOrderDateAfter
	 *
	 */
	public Set<Books> findBooksByOrderDateAfter(Calendar orderDate, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findBooksByAsinIsbnContaining
	 *
	 */
	public Set<Books> findBooksByAsinIsbnContaining(String asinIsbn_1) throws DataAccessException;

	/**
	 * JPQL Query - findBooksByAsinIsbnContaining
	 *
	 */
	public Set<Books> findBooksByAsinIsbnContaining(String asinIsbn_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findBooksByOrderDateBefore
	 *
	 */
	public Set<Books> findBooksByOrderDateBefore(java.util.Calendar orderDate_1) throws DataAccessException;

	/**
	 * JPQL Query - findBooksByOrderDateBefore
	 *
	 */
	public Set<Books> findBooksByOrderDateBefore(Calendar orderDate_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findBooksByPrimaryKey
	 *
	 */
	public Books findBooksByPrimaryKey(Integer bookId_1) throws DataAccessException;

	/**
	 * JPQL Query - findBooksByPrimaryKey
	 *
	 */
	public Books findBooksByPrimaryKey(Integer bookId_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findBooksByTitle
	 *
	 */
	public Set<Books> findBooksByTitle(String title) throws DataAccessException;

	/**
	 * JPQL Query - findBooksByTitle
	 *
	 */
	public Set<Books> findBooksByTitle(String title, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findBooksByOrderDate
	 *
	 */
	public Set<Books> findBooksByOrderDate(java.util.Calendar orderDate_2) throws DataAccessException;

	/**
	 * JPQL Query - findBooksByOrderDate
	 *
	 */
	public Set<Books> findBooksByOrderDate(Calendar orderDate_2, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findBooksByAuthorContaining
	 *
	 */
	public Set<Books> findBooksByAuthorContaining(String author_1) throws DataAccessException;

	/**
	 * JPQL Query - findBooksByAuthorContaining
	 *
	 */
	public Set<Books> findBooksByAuthorContaining(String author_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findBooksByTitleContaining
	 *
	 */
	public Set<Books> findBooksByTitleContaining(String title_1) throws DataAccessException;

	/**
	 * JPQL Query - findBooksByTitleContaining
	 *
	 */
	public Set<Books> findBooksByTitleContaining(String title_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findBooksByReleaseDate
	 *
	 */
	public Set<Books> findBooksByReleaseDate(java.util.Calendar releaseDate_2) throws DataAccessException;

	/**
	 * JPQL Query - findBooksByReleaseDate
	 *
	 */
	public Set<Books> findBooksByReleaseDate(Calendar releaseDate_2, int startResult, int maxRows) throws DataAccessException;

}