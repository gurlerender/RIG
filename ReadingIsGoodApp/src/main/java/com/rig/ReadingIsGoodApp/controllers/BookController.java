package com.rig.ReadingIsGoodApp.controllers;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rig.ReadingIsGoodApp.models.Book;
import com.rig.ReadingIsGoodApp.service.BookService;
import com.rig.ReadingIsGoodApp.serviceparam.ServiceResponse;

@RestController
@RequestMapping("/api/books")
public class BookController {
	
	private final BookService bookService;
	
	public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    @RequestMapping("/saveBook")
    public ServiceResponse<Book> saveBook(@RequestBody Book book) {
    	ServiceResponse<Book> response = bookService.saveBook(book);
        return response;
	}
    
    @PostMapping
    @RequestMapping("/updateBookStock")
    public ServiceResponse<Book> updateBookStock(@RequestBody Book book) {
    	ServiceResponse<Book> response = bookService.updateBookStock(book);
        return response;
	}
}
