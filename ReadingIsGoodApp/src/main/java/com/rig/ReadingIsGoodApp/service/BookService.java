package com.rig.ReadingIsGoodApp.service;



import java.util.List;

import org.springframework.stereotype.Service;

import com.rig.ReadingIsGoodApp.helper.Constants;
import com.rig.ReadingIsGoodApp.models.Book;
import com.rig.ReadingIsGoodApp.repositories.BookRepository;
import com.rig.ReadingIsGoodApp.serviceparam.ServiceResponse;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class BookService {
	
	private final BookRepository bookRepository;
	
	public ServiceResponse<Book> saveBook(Book book) {
		bookRepository.insert(book);
		return new ServiceResponse<Book>(true, Constants.NEW_BOOK_ADDED,book);
    }
	
	public ServiceResponse<Book> updateBookStock(Book book) {
		Book currentBook = bookRepository.findBookById(book.getId());
		if(currentBook == null) {
			return new ServiceResponse<Book>(false, Constants.BOOK_NOT_FOUND,book);
		}
		currentBook.setStock(book.getStock());
		bookRepository.save(currentBook);
		return new ServiceResponse<Book>(true, Constants.STOCK_UPDATED,currentBook);
    }
	
	public void reduceStocks(List<Book> bookList) {
		for(Book book : bookList) {
			bookRepository.save(book);
		}
	}
	
	public Book findBookById(String id) {
		Book book = bookRepository.findBookById(id);
		return book;
	}
	
	
}
