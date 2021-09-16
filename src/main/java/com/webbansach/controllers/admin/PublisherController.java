package com.webbansach.controllers.admin;

import com.webbansach.dto.PublisherDTO;
import com.webbansach.service.IPublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller(value = "publisherControllerOfAdmin")
public class PublisherController {

    @Autowired
    IPublisherService publisherService;

    @RequestMapping(value = "/admin/publisher", method = RequestMethod.GET)
    public ModelAndView homePage(@RequestParam(value = "page", required = false, defaultValue = "1") int page) {
        ModelAndView mav = new ModelAndView("admin_publisher");
        Pageable pageable = new PageRequest(page-1, 8);
        int totalPage = 0;
        if((publisherService.getTotalItem() % 8) == 0){
            totalPage = publisherService.getTotalItem()/8;
        }
        else{
            totalPage = (publisherService.getTotalItem()/8) + 1;
        }
        mav.addObject("listPublisher", publisherService.findAll(pageable));
        mav.addObject("totalPage", totalPage);
        mav.addObject("currentPage", page);
        return mav;
    }

    @RequestMapping(value = "/admin/publisher/new", method = RequestMethod.GET)
    public ModelAndView addPage() {
        ModelAndView mav = new ModelAndView("admin_publisher_new", "publisher", new PublisherDTO());
        return mav;
    }

    @RequestMapping(value = "/admin/publisher/remove", method = RequestMethod.POST)
    public String removePage(@RequestParam("currentUrl") String url, @RequestParam("id") long id) {
        publisherService.remove(id);
        return "redirect:"+url;
    }

    @RequestMapping(value = "/admin/publisher/save", method = RequestMethod.POST)
    public String saveBook(@ModelAttribute("book") PublisherDTO publisher) {
        publisherService.save(publisher);
        return "redirect:/admin/publisher";
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
        return "redirect:/admin/publisher";
    }

    @RequestMapping(value = "/admin/publisher/search", method = RequestMethod.POST)
    public ModelAndView search(@RequestParam("name") String name,
                               @RequestParam("address") String address,
                               @RequestParam(value = "page", required = false, defaultValue = "1") int page) {
        ModelAndView mav = new ModelAndView("admin_publisher");
        Pageable pageable = new PageRequest(page-1, 8);
        int totalPage = 0;
        int countItem = publisherService.search(name, address, null).size();
        if((countItem % 8) == 0){
            totalPage = countItem/8;
        }
        else{
            totalPage = (countItem/8) + 1;
        }
        mav.addObject("listPublisher", publisherService.search(name, address, pageable));
        mav.addObject("totalPage", totalPage);
        mav.addObject("currentPage", page);
        return mav;
    }
}
