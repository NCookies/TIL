package com.ncookie.harumvc.controller;

import com.ncookie.harumvc.domain.Book;
import com.ncookie.harumvc.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

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
    public ModelAndView createPost(BookForm bookForm) {
        ModelAndView mav = new ModelAndView();
        Book book = new Book();

        System.out.println(bookForm.toString());

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

    @RequestMapping(value = "detail", method = RequestMethod.GET)
    public String bookDetail(@RequestParam(value = "bookId") String id, Model model) {
        Book book = bookService.findOne(Long.parseLong(id)).get();

        model.addAttribute("book", book);

        return "book/detail";
    }
}
