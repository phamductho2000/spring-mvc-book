package com.webbansach.controllers.user;

import com.webbansach.service.IBookService;
import com.webbansach.service.ICategoryService;
import com.webbansach.service.IPublisherService;
import com.webbansach.service.impl.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
    public ModelAndView homePage(@PathVariable String nameCate, @PathVariable("id") long id) {
        ModelAndView mav = new ModelAndView("shop");
        Pageable pageable = new PageRequest(0, 4);
        mav.addObject("listBook", bookService.findAllByCateId(id, pageable));
        mav.addObject("listPublisher", publisherService.findAll());
        mav.addObject("totalItem", bookService.getTotalItem()/4);
        mav.addObject("nameCate", nameCate);
        mav.addObject("cateId", id);
        return mav;
    }


    @RequestMapping(value = "/trang-chu/{nameCate}/{id}/page={page}", method = RequestMethod.GET)
    public ModelAndView homePage1(@PathVariable String nameCate, @PathVariable("id") long id, @PathVariable("page") int page) {
        ModelAndView mav = new ModelAndView("shop");
        Pageable pageable = new PageRequest(page-1, 4);
        mav.addObject("listBook", bookService.findAllByCateId(id, pageable));
        mav.addObject("listPublisher", publisherService.findAll());
        mav.addObject("totalItem", bookService.getTotalItem()/4);
        mav.addObject("nameCate", nameCate);
        mav.addObject("cateId", id);
        return mav;
    }
}