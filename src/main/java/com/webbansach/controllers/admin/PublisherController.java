package com.webbansach.controllers.admin;

import com.webbansach.dto.BookDTO;
import com.webbansach.dto.PublisherDTO;
import com.webbansach.entity.BookEntity;
import com.webbansach.service.IBookService;
import com.webbansach.service.ICategoryService;
import com.webbansach.service.IPublisherService;
import com.webbansach.service.impl.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller(value = "publisherControllerOfAdmin")
public class PublisherController {

    @Autowired
    IPublisherService publisherService;

    @RequestMapping(value = "/admin/publisher", method = RequestMethod.GET)
    public ModelAndView homePage() {
        ModelAndView mav = new ModelAndView("admin_publisher");
        mav.addObject("listPublisher", publisherService.findAll());
        return mav;
    }

    @RequestMapping(value = "/admin/publisher/new", method = RequestMethod.GET)
    public ModelAndView addPage() {
        ModelAndView mav = new ModelAndView("admin_publisher_new", "publisher", new PublisherDTO());
        return mav;
    }

    @RequestMapping(value = "/admin/publisher/save", method = RequestMethod.POST)
    public String saveBook(@ModelAttribute("book") PublisherDTO publisher) {
        publisherService.save(publisher);
        return "redirect:/admin/home/publisher";
    }

    @RequestMapping(value = "/admin/publisher/edit/{id}", method = RequestMethod.GET)
    public ModelAndView editPage(@PathVariable("id") long id) {
        ModelAndView mav = new ModelAndView("admin_publisher_edit", "publisher", new PublisherDTO());
        mav.addObject("publisher", publisherService.findOne(id));
        return mav;
    }

    @RequestMapping(value = "/admin/publisher/update", method = RequestMethod.POST)
    public String updateBook(@ModelAttribute("publisher") PublisherDTO publisher) {
        publisherService.save(publisher);
        return "redirect:/admin/home/publisher";
    }
}
