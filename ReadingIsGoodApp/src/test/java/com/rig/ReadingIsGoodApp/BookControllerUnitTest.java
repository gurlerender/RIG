package com.rig.ReadingIsGoodApp;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.rig.ReadingIsGoodApp.models.Book;
import com.rig.ReadingIsGoodApp.service.BookService;

@SpringBootTest
public class BookControllerUnitTest {
	@Autowired
	 private BookService bookService;
	 
	 @Test
	 public void saveBookTest() {
		 bookService.saveBook(new Book("Test 5", "Test Aut", BigDecimal.valueOf(22), "TL", 72));
	 }
	 
	 @Test
	 public void updateBookTest() {
		 Book book = new Book("","",BigDecimal.valueOf(44),"",502);
		 book.setId("6252cf5d1caxs85765e5132c7");
		 book.setStock(513);
		 bookService.updateBookStock(book);
	 }
}
