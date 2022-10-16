package com.ncookie.harumvc.service;

import com.ncookie.harumvc.domain.Book;
import com.ncookie.harumvc.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Service
@Transactional
public class BookService {

    private final BookRepository repository;

    @Autowired
    public BookService(BookRepository repository) {
        this.repository = repository;
    }

    public long create(Book book) {
        repository.insert(book);
        return book.getBook_id();
    }
}
