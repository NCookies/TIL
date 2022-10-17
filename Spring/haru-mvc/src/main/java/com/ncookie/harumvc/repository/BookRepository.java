package com.ncookie.harumvc.repository;

import com.ncookie.harumvc.domain.Book;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.Optional;

@Repository
public class BookRepository {

    private final EntityManager em;

    public BookRepository(EntityManager em) {
        this.em = em;
    }

    public Book save(Book book) {
        em.persist(book);
        return book;
    }

    public Optional<Book> findById(Long id) {
        Book book = em.find(Book.class, id);
        return Optional.ofNullable(book);
    }

    public void remove(Long id) {
        Optional<Book> oBook = findById(id);
        oBook.ifPresent(em::remove);
    }
}
