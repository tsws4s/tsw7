package myinfo.service;

import java.util.List;
import java.util.Set;

import myinfo.domain.Books;

/**
 * Spring service that handles CRUD requests for Books entities
 * 
 */
public interface BooksService {

	/**
	 * Delete an existing Books entity
	 * 
	 */
	public void deleteBooks(Books books);

	/**
	 * Save an existing Books entity
	 * 
	 */
	public void saveBooks(Books books_1);

	/**
	 * Return all Books entity
	 * 
	 */
	public List<Books> findAllBookss(Integer startResult, Integer maxRows);

	/**
	 */
	public Books findBooksByPrimaryKey(Integer bookId);

	/**
	 * Return a count of all Books entity
	 * 
	 */
	public Integer countBookss();

	/**
	 * Load an existing Books entity
	 * 
	 */
	public Set<Books> loadBookss();
}