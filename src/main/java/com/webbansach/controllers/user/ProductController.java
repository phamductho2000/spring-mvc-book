package com.webbansach.controllers.user;

import com.webbansach.service.IBookService;
import com.webbansach.service.ICategoryService;
import com.webbansach.service.IPublisherService;
import com.webbansach.service.impl.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller(value = "productControllerOfUser")
public class ProductController {

    @Autowired
    IBookService bookService;

    @Autowired
    IPublisherService publisherService;


    @RequestMapping(value = "/trang-chu/{nameCate}/{id}", method = RequestMethod.GET)
    public ModelAndView homePage(@PathVariable String nameCate, @PathVariable long id) {
        ModelAndView mav = new ModelAndView("shop");
        mav.addObject("listBook", bookService.findAllByCateId(id));
        mav.addObject("listPublisher", publisherService.findAll());
        return mav;
    }
}