package com.webbansach.controllers.user;

import com.webbansach.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller(value = "homeControllerOfUser")
public class HomeController {

    @Autowired
    IBookService bookService;

    @RequestMapping(value = "/trang-chu", method = RequestMethod.GET)
    public ModelAndView homePage() {
        ModelAndView mav = new ModelAndView("home");
        mav.addObject("listBooksNew", bookService.findAllNew(new PageRequest(0, 10, Sort.Direction.DESC, "createdDate")));
        mav.addObject("listBooksFeature", bookService.findAllFeature(new PageRequest(0, 10)));
        mav.addObject("listBooksTopSell", bookService.findAll(new PageRequest(0, 10, Sort.Direction.DESC, "discount")));
        return mav;
    }

    @RequestMapping(value = "/xem-nhanh/id={id}", method = RequestMethod.GET)
    public ModelAndView quickViewPage(@PathVariable("id") long id) {
        ModelAndView mav = new ModelAndView("quick_view");
        mav.addObject("book", bookService.findOne(id));
        return mav;
    }
}