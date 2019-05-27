package com.infinitusBooks.searchBooks.services;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.infinitusBooks.searchBooks.models.Book;
import com.infinitusBooks.searchBooks.models.User;
import com.infinitusBooks.searchBooks.repositories.BookRepository;
import com.infinitusBooks.searchBooks.repositories.UserRepository;

@Service("bookService")
public class BookService {
	
	 // Larissa - Classe que implementa os métodos instânciados a partir 
		// do Repositório que utiliza a biblioteca JPA 
	
	private BookRepository bookRepository;
	private UserRepository userRepository; 

	@Autowired
	public BookService(BookRepository bookRepository, UserRepository userRepository) {
		this.bookRepository = bookRepository;
		this.userRepository = userRepository; 
	} 
	
	public void saveBook(@PathVariable("id") Long id, Book book) {
		User user = userRepository.getOne(id); 
		book.setUser(user);			
		bookRepository.save(book); 
	}
	
	public List<Book> searchBooks() {
		List<Book> books = new ArrayList<Book>();
		for (Book book : bookRepository.searchBooks()) {
			if(book.getAvailable().equals("Y")) {
				book.setAvailable("Disponível");
				books.add(book);
			} else {
				book.setAvailable("Indisponível");
				books.add(book);
			}
		}
		return books;
	}
	
	public List<Book> searchBooksById(Long userId) {
		List<Book> books = new ArrayList<Book>();
		books = bookRepository.searchBooksById(userId);
		return books;		
	}
	 
}
