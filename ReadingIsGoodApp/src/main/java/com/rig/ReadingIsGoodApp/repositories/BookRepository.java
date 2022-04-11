package com.rig.ReadingIsGoodApp.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.rig.ReadingIsGoodApp.models.Book;

public interface BookRepository extends MongoRepository<Book, String> {
	Book findBookById(String id);
}
