package com.webbansach.controllers.admin;

import com.webbansach.dto.BookDTO;
import com.webbansach.service.IBookService;
import com.webbansach.service.ICategoryService;
import com.webbansach.service.IPublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;

@Controller(value = "bookControllerOfAdmin")
public class BookController {

    @Autowired
    IBookService bookService;

    @Autowired
    ICategoryService categoryService;

    @Autowired
    IPublisherService publisherService;

    @RequestMapping(value = "/admin/book", method = RequestMethod.GET)
    public ModelAndView homePage(@RequestParam(value = "page", required = false, defaultValue = "1") int page) {
        ModelAndView mav = new ModelAndView("admin_book");
        Pageable pageable = new PageRequest(page-1, 8);
        int totalPage = 0;
        if((bookService.getTotalItem() % 8) == 0){
            totalPage = bookService.getTotalItem()/8;
        }
        else{
            totalPage = (bookService.getTotalItem()/8) + 1;
        }
        mav.addObject("listBook", bookService.findAll(pageable));
        mav.addObject("listCategory", categoryService.findAll());
        mav.addObject("listPublisher", publisherService.findAll());
        mav.addObject("totalPage", totalPage);
        mav.addObject("currentPage", page);
        return mav;
    }

    @RequestMapping(value = "/admin/book/new", method = RequestMethod.GET)
    public ModelAndView addPage() {
        ModelAndView mav = new ModelAndView("admin_book_new", "book", new BookDTO());
        mav.addObject("listCategoryName", categoryService.findAll());
        mav.addObject("listPublisherName", publisherService.findAll());
        mav.addObject("totalItem", bookService.getTotalItem());
        return mav;
    }

    @RequestMapping(value = "/admin/book/save", method = RequestMethod.POST)
    public String saveBook(@ModelAttribute("book") BookDTO book,
                           @RequestParam(value = "file")CommonsMultipartFile commonsMultipartFile,
                           @RequestParam(value = "des")String des,
                           @RequestParam(value = "shortDes")String shortDes)  {
        String nameFile = commonsMultipartFile.getOriginalFilename();
        File file = new File("C:\\Users\\tho20\\IdeaProjects\\spring-mvc-book\\src\\main\\webapp\\resources\\book_images", nameFile);
        try {
            commonsMultipartFile.transferTo(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        book.setImage(nameFile);
        book.setShortDes(shortDes);
        book.setDescription(des);
        bookService.save(book);
        return "redirect:/admin/book";
    }

    @RequestMapping(value = "/admin/book/remove", method = RequestMethod.POST)
    public String removeBook(@RequestParam("currentUrl") String url, @RequestParam("id") long id) {
        bookService.remove(id);
        return "redirect:"+url;
    }

    @RequestMapping(value = "/admin/book/removeByIds", method = RequestMethod.POST)
    public String removeBooks(@RequestParam("currentUrl") String url, @RequestParam("ids") Long[] ids) {
        bookService.remove(ids);
        return "redirect:"+url;
    }

    @RequestMapping(value = "/admin/book/detail/{id}", method = RequestMethod.GET)
    public ModelAndView detailBook(@PathVariable("id") long id) {
        ModelAndView mav = new ModelAndView("admin_book_detail");
        mav.addObject("book", bookService.findOne(id));
        return mav;
    }

    @RequestMapping(value = "/admin/book/edit/{id}/{pId}/{cId}", method = RequestMethod.GET)
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

    @RequestMapping(value = "/admin/book/search", method = RequestMethod.POST)
    public ModelAndView searchBook(@RequestParam(name = "categoryId" ) int category,
                                   @RequestParam(name = "publisherId") int publisher,
                                   @RequestParam(name = "statusBook" ) int statusBook,
                                   @RequestParam(name = "nameOrId", defaultValue = "") String nameOrId,
                                   @RequestParam(name = "page", required = false) int page) {
        ModelAndView mav = new ModelAndView("admin_book");
        Pageable pageable = new PageRequest(page-1, 8);
        int totalPage = 0;
        int countItem = bookService.searchBook(nameOrId, statusBook, category, publisher, null).size();
        if((countItem % 8) == 0){
            totalPage = countItem/8;
        }
        else{
            totalPage = (countItem/8) + 1;
        }
        mav.addObject("listBook", bookService.searchBook(nameOrId, statusBook, category, publisher, pageable));
        mav.addObject("listCategory", categoryService.findAll());
        mav.addObject("listPublisher", publisherService.findAll());
        mav.addObject("totalPage", totalPage);
        mav.addObject("currentPage", page);
        return mav;
    }

}
