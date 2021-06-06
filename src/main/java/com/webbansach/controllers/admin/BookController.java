package com.webbansach.controllers.admin;

import com.webbansach.dto.BookDTO;
import com.webbansach.service.IBookService;
import com.webbansach.service.ICategoryService;
import com.webbansach.service.IPublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller(value = "bookControllerOfAdmin")
public class BookController {

    @Autowired
    IBookService bookService;

    @Autowired
    ICategoryService categoryService;

    @Autowired
    IPublisherService publisherService;

    @RequestMapping(value = "/admin/home/book", method = RequestMethod.GET)
    public ModelAndView homePage() {
        ModelAndView mav = new ModelAndView("admin_book");
        mav.addObject("listBook", bookService.findAll());
        return mav;
    }

    @RequestMapping(value = "/admin/home/book/new", method = RequestMethod.GET)
    public ModelAndView addPage() {
        ModelAndView mav = new ModelAndView("admin_book_new", "book", new BookDTO());
        mav.addObject("listCategoryName", categoryService.findAll());
        mav.addObject("listPublisherName", publisherService.findAll());
        return mav;
    }

    @RequestMapping(value = "/admin/home/book/save", method = RequestMethod.POST)
    public String saveBook(@ModelAttribute("book") BookDTO book) {
        bookService.save(book);
        return "redirect:/admin/home/book";
    }

    @RequestMapping(value = "/admin/home/book/detail/{id}", method = RequestMethod.GET)
    public ModelAndView removeBook(@PathVariable("id") long id) {
        ModelAndView mav = new ModelAndView("admin_book");
        bookService.remove(id);
        return mav;
    }

    @RequestMapping(value = "/admin/home/book/edit/{id}/{pId}/{cId}", method = RequestMethod.GET)
    public ModelAndView editPage(@PathVariable("id") long id,
                                 @PathVariable("pId") long pId,
                                 @PathVariable("cId") long cId) {
        ModelAndView mav = new ModelAndView("admin_book_edit", "book", new BookDTO());
        mav.addObject("book", bookService.findOne(id));
        mav.addObject("listCategory", categoryService.findAll());
        mav.addObject("listPublisher", publisherService.findAll());
        mav.addObject("cName", categoryService.getNameById(cId));
        mav.addObject("pName", publisherService.getNameById(pId));
        return mav;
    }

    @RequestMapping(value = "/admin/home/book/update", method = RequestMethod.POST)
    public String updateBook(@ModelAttribute("book") BookDTO book) {
        bookService.save(book);
        return "redirect:/admin/home/book";
    }

    @RequestMapping(value = "/admin/home/book/search", method = RequestMethod.POST)
    public ModelAndView searchBook(@RequestParam(name = "key") String key) {
        System.out.println(key);

       return new ModelAndView("admin_book");
    }
}
