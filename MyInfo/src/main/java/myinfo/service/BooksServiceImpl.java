//**********************************************************
// BooksServiceImpl
// 
// Author: TODO: update developer's name in comment header
// Creation date: 03/04/2013
//
// Copyright (C) 2013  Team Sportsware
//*********************************************************

package myinfo.service;

import java.util.List;
import java.util.Set;

import myinfo.dao.BooksDAO;

import myinfo.domain.Books;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

/**
 * Spring service that handles CRUD requests for Books entities
 * 
 */

@Service("BooksService")
@Transactional
public class BooksServiceImpl implements BooksService {

	/**
	 * DAO injected by Spring that manages Books entities
	 * 
	 */
	@Autowired
	private BooksDAO booksDAO;

	/**
	 * Instantiates a new BooksServiceImpl.
	 *
	 */
	public BooksServiceImpl() {
	}

	/**
	 * Delete an existing Books entity
	 * 
	 */
	@Transactional
	public void deleteBooks(Books books) {
		booksDAO.remove(books);
		booksDAO.flush();
	}

	/**
	 * Save an existing Books entity
	 * 
	 */
	@Transactional
	public void saveBooks(Books books) {
		Books existingBooks = booksDAO.findBooksByPrimaryKey(books.getBookId());

		if (existingBooks != null) {
			if (existingBooks != books) {
				existingBooks.setBookId(books.getBookId());
				existingBooks.setOrderDate(books.getOrderDate());
				existingBooks.setTitle(books.getTitle());
				existingBooks.setFormat(books.getFormat());
				existingBooks.setAsinIsbn(books.getAsinIsbn());
				existingBooks.setAuthor(books.getAuthor());
				existingBooks.setReleaseDate(books.getReleaseDate());
				existingBooks.setPrice(books.getPrice());
				existingBooks.setUserFk(books.getUserFk());
			}
			books = booksDAO.store(existingBooks);
		} else {
			books = booksDAO.store(books);
		}
		booksDAO.flush();
	}

	/**
	 * Return all Books entity
	 * 
	 */
	@Transactional
	public List<Books> findAllBookss(Integer startResult, Integer maxRows) {
		return new java.util.ArrayList<Books>(booksDAO.findAllBookss(startResult, maxRows));
	}

	/**
	 */
	@Transactional
	public Books findBooksByPrimaryKey(Integer bookId) {
		return booksDAO.findBooksByPrimaryKey(bookId);
	}

	/**
	 * Return a count of all Books entity
	 * 
	 */
	@Transactional
	public Integer countBookss() {
		return ((Long) booksDAO.createQuerySingleResult("select count(o) from Books o").getSingleResult()).intValue();
	}

	/**
	 * Load an existing Books entity
	 * 
	 */
	@Transactional
	public Set<Books> loadBookss() {
		return booksDAO.findAllBookss();
	}
}
