package com.webbansach.controllers.user;

import com.webbansach.dto.BookDTO;
import com.webbansach.service.IBookService;
import com.webbansach.service.IPublisherService;
import com.webbansach.service.IReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller(value = "shopControllerOfUser")
public class ShopController {

    @Autowired
    IBookService bookService;

    @Autowired
    IPublisherService publisherService;

    @Autowired
    IReviewService reviewService;

    @RequestMapping(value = "/{nameCate}/{id}", method = RequestMethod.GET)
    public ModelAndView homePage(@PathVariable("nameCate") String nameCate,
                           @PathVariable("id") int cateId,
                           @RequestParam(value = "page", required = false, defaultValue = "1") int page,
                           @RequestParam(value = "limit", defaultValue = "16") int limit,
                           @RequestParam(value = "sort", required = false, defaultValue = "default") String sort,
                           @RequestParam(value = "publisher", required = false, defaultValue = "0") int publisher,
                           @RequestParam(value = "price_range", required = false, defaultValue = "0") int price_range) {
        ModelAndView mav = new ModelAndView("shop");
        Pageable pageable = new PageRequest(page-1, limit);
        int totalPage = 0;
        int min = 0, max = 0;
        if(price_range == 1){
            min = 0;
            max = 150000;
        }
        if(price_range == 2){
            min = 150000;
            max = 300000;
        }
        if(price_range == 3){
            min = 300000;
            max = 500000;
        }
        if(price_range == 4){
            min = 500000;
            max = 0;
        }
        if(sort.equals("desc_price")){
            pageable = new PageRequest(page-1, limit, Sort.Direction.DESC, "price");
        }
        if(sort.equals("asc_price")){
            pageable = new PageRequest(page-1, limit, Sort.Direction.ASC, "price");
        }
        if(sort.equals("desc_new")){
            pageable = new PageRequest(page-1, limit, Sort.Direction.DESC, "createdDate");
        }
        if(sort.equals("desc_discount")){
            pageable = new PageRequest(page-1, limit, Sort.Direction.DESC, "discount");
        }
        List<BookDTO> bookDTOList = bookService.search(cateId, publisher, min, max, pageable);
        int countItem = bookService.search(cateId, publisher, min, max, null).size();
        if((countItem % limit) == 0){
            totalPage = countItem / limit;
        }
        else{
            totalPage = (countItem / limit) + 1;
        }
        mav.addObject("listBook", bookDTOList);
        mav.addObject("listPublisher", publisherService.findAllByCateId(cateId, null));
        mav.addObject("nameCate", nameCate);
        mav.addObject("cateId", cateId);
        mav.addObject("totalPage", totalPage);
        mav.addObject("currentPage", page);
        return mav;

    }

}