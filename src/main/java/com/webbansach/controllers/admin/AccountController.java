package com.webbansach.controllers.admin;

import com.webbansach.dto.UserDTO;
import com.webbansach.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller(value = "accountControllerOfAdmin")
public class AccountController {
    @Autowired
    IUserService userService;

    @RequestMapping(value = "/admin/profile", method = RequestMethod.GET)
    public ModelAndView homePage() {
        UserDTO userDTO = userService.findOneByUserName(SecurityContextHolder.getContext().getAuthentication().getName());
        ModelAndView mav = new ModelAndView("admin_profile", "user", new UserDTO());
        mav.addObject("userDetail", userDTO);
        return mav;
    }

    @RequestMapping(value = "/admin/profile/update", method = RequestMethod.POST)
    public String update(@ModelAttribute("customer") UserDTO userDTO) {
//        userService.saveUser(userDTO);
        return "redirect:/admin/profile";
    }
}
