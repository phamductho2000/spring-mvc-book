package com.webbansach.controllers.user;

import com.webbansach.dto.BookDTO;
import com.webbansach.service.IBookService;
import com.webbansach.service.IReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.awt.print.Pageable;
import java.util.List;

@Controller(value = "productControllerOfUser")
public class ProductController {
    @Autowired
    IBookService bookService;

    @Autowired
    IReviewService reviewService;

    @RequestMapping(value = "/{nameProduct}/id={id}", method = RequestMethod.GET)
    public ModelAndView homePage(@PathVariable String nameProduct, @PathVariable("id") long id) {
        ModelAndView mav = new ModelAndView("product");
        BookDTO book = bookService.findOne(id);
        List<BookDTO> books = bookService.findAllByCateId(book.getCategory_id(), null);
        mav.addObject("book", book);
        mav.addObject("listBook", books);
        mav.addObject("lstReviews", reviewService.findAllByBookId(id, null));
        return mav;
    }
}
