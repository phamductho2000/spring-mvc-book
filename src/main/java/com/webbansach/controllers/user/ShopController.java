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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
                                 @PathVariable("id") long id,
                                 @RequestParam(value = "page", required = false, defaultValue = "1") int page) {

        ModelAndView mav = new ModelAndView("shop");
        Pageable pageable = new PageRequest(page-1, 8);
        int totalPage = 0;
        int countItem = bookService.getTotalItemByCateId(id);
        if((countItem % 8) == 0){
            totalPage = countItem/8;
        }
        else{
            totalPage = (countItem/8) + 1;
        }
        mav.addObject("listBook", bookService.findAllByCateId(id, pageable));
        mav.addObject("listPublisher", publisherService.findAll());
        mav.addObject("nameCate", nameCate);
        mav.addObject("cateId", id);
        mav.addObject("totalPage", totalPage);
        mav.addObject("currentPage", page);
        return mav;
    }

    @RequestMapping(value = "/{nameCate}/{id}/sort", method = RequestMethod.POST)
    public ModelAndView sortProduct(@PathVariable("nameCate") String nameCate,
                                 @PathVariable("id") long id,
                                 @RequestParam(value = "page", required = false, defaultValue = "1") int page,
                                 @RequestParam(value = "sort", required = false, defaultValue = "default") String sort) {

        ModelAndView mav = new ModelAndView("shop");
        Pageable pageable = new PageRequest(page-1, 8);
        List<BookDTO> listBook = new ArrayList<>();
        int totalPage = 0;
        int countItem = bookService.getTotalItemByCateId(id);

        if(sort.equals("sort_des_price")){
            pageable = new PageRequest(page-1, 8, Sort.Direction.DESC, "price");
        }
        if(sort.equals("sort_asc_price")){
            pageable = new PageRequest(page-1, 8, Sort.Direction.ASC, "price");
        }
        if(sort.equals("sort_new")){
            pageable = new PageRequest(page-1, 8, Sort.Direction.DESC, "createdDate");
        }
        if(sort.equals("sort_discount")){
            pageable = new PageRequest(page-1, 8, Sort.Direction.DESC, "discount");
        }
        listBook = bookService.findAllByCateId(id, pageable);
        if(sort.equals("sort_feature")){
            pageable = new PageRequest(page-1, 8);
            listBook = bookService.findAllFeature(pageable);
        }

        if((countItem % 8) == 0){
            totalPage = countItem/8;
        }
        else{
            totalPage = (countItem/8) + 1;
        }
        mav.addObject("listBook", listBook);
        mav.addObject("listPublisher", publisherService.findAll());
        mav.addObject("nameCate", nameCate);
        mav.addObject("cateId", id);
        mav.addObject("totalPage", totalPage);
        mav.addObject("currentPage", page);
        return mav;
    }

    @RequestMapping(value = "/{nameCate}/{id}/search_byMoney", method = RequestMethod.POST)
    public ModelAndView searchByMoney(@PathVariable("nameCate") String nameCate,
                                      @PathVariable("id") long id,
                                      @RequestParam(value = "startMoney") int startMoney,
                                      @RequestParam(value = "endMoney") int endMoney,
                                      @RequestParam(value = "page", required = false, defaultValue = "1") int page){
        ModelAndView mav = new ModelAndView("shop");
        Pageable pageable = new PageRequest(page-1, 8);
        int totalPage = 0;
        int countItem = bookService.searchByMoney(id, startMoney, endMoney, null).size();
        if((countItem % 8) == 0){
            totalPage = countItem/8;
        }
        else{
            totalPage = (countItem/8) + 1;
        }
        mav.addObject("listBook", bookService.searchByMoney(id, startMoney, endMoney, pageable));
        mav.addObject("listPublisher", publisherService.findAll());
        mav.addObject("nameCate", nameCate);
        mav.addObject("cateId", id);
        mav.addObject("totalPage", totalPage);
        mav.addObject("currentPage", page);
        return mav;
    }

    @RequestMapping(value = "/{nameCate}/{id}/search_byPublisher", method = RequestMethod.POST)
    public ModelAndView searchByPublisher(@PathVariable("nameCate") String nameCate,
                                      @PathVariable("id") long id,
                                      @RequestParam(value = "pubId") long pubId,
                                      @RequestParam(value = "page", required = false, defaultValue = "1") int page){
        ModelAndView mav = new ModelAndView("shop");
        Pageable pageable = new PageRequest(page-1, 8);
        int totalPage = 0;
        int countItem = bookService.findAllByPublIdandCateId(pubId, id,null).size();
        if((countItem % 8) == 0){
            totalPage = countItem/8;
        }
        else{
            totalPage = (countItem/8) + 1;
        }
        mav.addObject("listBook", bookService.findAllByPublIdandCateId(pubId, id, pageable));
        mav.addObject("listPublisher", publisherService.findAll());
        mav.addObject("nameCate", nameCate);
        mav.addObject("cateId", id);
        mav.addObject("totalPage", totalPage);
        mav.addObject("currentPage", page);
        return mav;
    }

}