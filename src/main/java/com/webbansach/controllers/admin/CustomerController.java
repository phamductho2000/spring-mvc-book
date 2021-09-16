package com.webbansach.controllers.admin;

import com.webbansach.dto.UserDTO;
import com.webbansach.service.IRoleService;
import com.webbansach.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;

@Controller(value = "customerControllerOfAdmin")
public class CustomerController {
    @Autowired
    IUserService userService;

    @Autowired
    IRoleService roleService;

    @RequestMapping(value = "/admin/customer", method = RequestMethod.GET)
    public ModelAndView userPage(@RequestParam(value = "page", required = false, defaultValue = "1") int page) {
        ModelAndView mav = new ModelAndView("admin_customer");
        Pageable pageable = new PageRequest(page-1, 8);
        int totalPage = 0;
        int countItem = userService.findAllByRole("USER", null).size();
        if(countItem % 8 == 0){
            totalPage = countItem/8;
        }
        else{
            totalPage = (countItem/8) + 1;
        }
        mav.addObject("ListUser", userService.findAllByRole("USER", pageable));
        mav.addObject("totalPage", totalPage);
        mav.addObject("currentPage", page);
        return mav;
    }

    @RequestMapping(value = "/admin/customer/new", method = RequestMethod.GET)
    public ModelAndView addPage() {
        ModelAndView mav = new ModelAndView("admin_customer_new", "customer", new UserDTO());
        mav.addObject("roles", roleService.findAllRole());
        return mav;
    }

    @RequestMapping(value = "/admin/customer/remove", method = RequestMethod.POST)
    public String removeBook(@RequestParam("currentUrl") String url, @RequestParam("id") long id) {
        userService.remove(id);
        return "redirect:"+url;
    }

    @RequestMapping(value = "/admin/customer/edit/{id}", method = RequestMethod.GET)
    public ModelAndView editPage(@PathVariable("id") long id){
        ModelAndView mav = new ModelAndView("admin_customer_edit", "customer", new UserDTO());
        mav.addObject("user", userService.findOne(id));
        mav.addObject("roles", roleService.findAllRole());
        return mav;
    }

    @RequestMapping(value = "/admin/customer/save", method = RequestMethod.POST)
    public String updateBook(@ModelAttribute("customer") UserDTO userDTO,
                             @RequestParam(value = "file") CommonsMultipartFile commonsMultipartFile) {
        String nameFile = commonsMultipartFile.getOriginalFilename();
        File file = new File("C:\\Users\\tho20\\IdeaProjects\\spring-mvc-book\\src\\main\\webapp\\resources\\book_images", nameFile);
        try {
            commonsMultipartFile.transferTo(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        userDTO.setAvatar(nameFile);
        userService.saveCustomer(userDTO);
        return "redirect:/admin/customer";
    }

    @RequestMapping(value = "/admin/customer/search", method = RequestMethod.POST)
    public ModelAndView search(@RequestParam(name = "key") String key,
                               @RequestParam(value = "page", required = false, defaultValue = "1") int page) {
        ModelAndView mav = new ModelAndView("admin_customer");
        Pageable pageable = new PageRequest(page-1, 8);
        int totalPage = 0;
        int countItem = userService.findAllByName(key, null).size();
        if(countItem % 8 == 0){
            totalPage = countItem/8;
        }
        else{
            totalPage = (countItem/8) + 1;
        }
        mav.addObject("ListUser", userService.findAllByName(key, pageable));
        mav.addObject("totalPage", totalPage);
        mav.addObject("currentPage", page);
        return mav;
    }
}
