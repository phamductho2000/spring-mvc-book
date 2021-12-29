package com.webbansach.controllers.admin;


import com.webbansach.dto.ContactDTO;
import com.webbansach.service.IContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;



@Controller(value = "settingControllerOfAdmin")
public class SettingController {

    @Autowired
    IContactService contactService;

    @RequestMapping(value = "/admin/setting", method = RequestMethod.GET)
    public ModelAndView homePage() {
        ModelAndView mav = new ModelAndView("admin_contact", "contact", new ContactDTO());
        mav.addObject("contact", contactService.findOne());
        return mav;
    }

    @RequestMapping(value = "/admin/setting/update", method = RequestMethod.POST)
    public String update(@ModelAttribute("contact") ContactDTO contact) {
        contactService.save(contact);
        return "redirect:/admin/setting";
    }
}