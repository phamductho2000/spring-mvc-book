package com.webbansach.controllers.user;

import com.webbansach.service.IContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller(value = "contactControllerOfUser")
public class ContactController {

    @Autowired
    IContactService contactService;

    @RequestMapping(value = "/lien-he", method = RequestMethod.GET)
    public ModelAndView homePage() {
        ModelAndView mav = new ModelAndView("contact");
        mav.addObject("contact", contactService.findOne());
        return mav;
    }


}