package com.ncookie.harumvc.repository;

import com.ncookie.harumvc.domain.Book;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.Map;
import java.util.Optional;

@Repository
public class BookRepository {

    private final EntityManager em;

    public BookRepository(EntityManager em) {
        this.em = em;
    }

    public Book insert(Book book) {
        em.persist(book);
        return book;
    }

    public Optional<Book> findById(Long id) {
        Book book = em.find(Book.class, id);
        return Optional.ofNullable(book);
    }
}
