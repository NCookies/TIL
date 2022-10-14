package com.ncookie.harumvc.controller;

import com.ncookie.harumvc.domain.Book;
import com.ncookie.harumvc.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BookController {
    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ModelAndView create() {
        return new ModelAndView("book/create");
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ModelAndView createPost(@RequestParam BookForm bookForm) {
        ModelAndView mav = new ModelAndView();
        Book book = new Book();
        book.setTitle(bookForm.getTitle());
        book.setCategory(bookForm.getCategory());
        book.setPrice(bookForm.getPrice());

        long bookId = this.bookService.create(book);

        if (bookId == 0) {
            mav.setViewName("redirect:/create");
        } else {
            mav.setViewName("redirect:/detail?bookId=" + bookId);
        }

        return mav;
    }
}
