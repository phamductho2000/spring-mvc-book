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

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller(value = "bookControllerOfAdmin")
public class BookController {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    IBookService bookService;

    @Autowired
    ICategoryService categoryService;

    @Autowired
    IPublisherService publisherService;

    @RequestMapping(value = "/admin/book", method = RequestMethod.GET)
    public ModelAndView homePage(@RequestParam(value = "page", required = false, defaultValue = "1") int page,
                                 @RequestParam(value = "limit", defaultValue = "10") int limit) {
        ModelAndView mav = new ModelAndView("admin_book");
        Pageable pageable = new PageRequest(page-1, limit);
        int totalPage = 0;
        if((bookService.getTotalItem() % limit) == 0){
            totalPage = bookService.getTotalItem()/limit;
        }
        else{
            totalPage = (bookService.getTotalItem()/limit) + 1;
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
    public String save(@ModelAttribute("book") BookDTO book,
                           @RequestParam(value = "file")CommonsMultipartFile commonsMultipartFile,
                           @RequestParam(value = "des")String des,
                           @RequestParam(value = "shortDes")String shortDes)  {
        String nameFile = commonsMultipartFile.getOriginalFilename();
        String realPathtoUploads =  request.getServletContext().getRealPath("/resources/book_images");
        try {
            if(! new File(realPathtoUploads).exists())
            {
                new File(realPathtoUploads).mkdir();
            } else {
                File file = new File(realPathtoUploads, nameFile);
                commonsMultipartFile.transferTo(file);
                book.setImage(nameFile);
                book.setShortDes(shortDes);
                book.setDescription(des);
                bookService.save(book);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "redirect:/admin/book";
    }

    @RequestMapping(value = "/admin/book/remove", method = RequestMethod.POST)
    public String remove(@RequestParam("currentUrl") String url, @RequestParam("id") long id) {
        bookService.remove(id);
        return "redirect:"+url;
    }

    @RequestMapping(value = "/admin/book/removeByIds", method = RequestMethod.POST)
    public String removes(@RequestParam("currentUrl") String url, @RequestParam("ids") Long[] ids) {
        bookService.remove(ids);
        return "redirect:"+url;
    }

    @RequestMapping(value = "/admin/book/detail/{id}", method = RequestMethod.GET)
    public ModelAndView detailPage(@PathVariable("id") long id) {
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

    @RequestMapping(value = "/admin/book/search", method = RequestMethod.GET)
    public ModelAndView search(@RequestParam(value = "page", required = false, defaultValue = "1") int page,
                               @RequestParam(value = "limit", defaultValue = "10") int limit,
                               @RequestParam(name = "category_id", required = false, defaultValue = "0") int cateId,
                               @RequestParam(name = "publisher_id", required = false, defaultValue = "0") int publisherId,
                               @RequestParam(name = "status", required = false, defaultValue = "-1") int status,
                               @RequestParam(name = "name", required = false, defaultValue = "default") String name) {
        ModelAndView mav = new ModelAndView("admin_book");
        Pageable pageable = new PageRequest(page-1, limit);
        int totalPage = 0;
        List<BookDTO> bookDTOList = bookService.searchBook(name, status, cateId, publisherId, pageable);
        int countItem = bookService.searchBook(name, status, cateId, publisherId, null).size();
        if((countItem % limit) == 0){
            totalPage = countItem / limit;
        }
        else{
            totalPage = (countItem / limit) + 1;
        }
        mav.addObject("listBook", bookDTOList);
        mav.addObject("listCategory", categoryService.findAll());
        mav.addObject("listPublisher", publisherService.findAll());
        mav.addObject("totalPage", totalPage);
        mav.addObject("currentPage", page);
        return mav;
    }

}
