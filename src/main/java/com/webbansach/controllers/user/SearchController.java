package com.webbansach.controllers.user;

import com.webbansach.service.IBookService;
import com.webbansach.service.IPublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller(value = "searchControllerOfAdmin")
public class SearchController {
    @Autowired
    IBookService bookService;

    @Autowired
    IPublisherService publisherService;

    @RequestMapping(value = "/tim-kiem", method = RequestMethod.GET)
    public ModelAndView searchPage(@RequestParam("key") String key,
                                   @RequestParam(value = "page", required = false, defaultValue = "1") int page) {
        ModelAndView mav = new ModelAndView("search");
        Pageable pageable = new PageRequest(page-1, 16);
        int totalPage = 0;
        int countItem = bookService.findByKey(key, null).size();
        if((countItem % 16) == 0){
            totalPage = countItem/16;
        }
        else{
            totalPage = (countItem/16) + 1;
        }
        mav.addObject("listBook", bookService.findByKey(key, pageable));
        mav.addObject("totalItem", countItem);
        mav.addObject("totalPage", totalPage);
        mav.addObject("currentPage", page);
        mav.addObject("keySearch", key);
        return mav;
    }

}
