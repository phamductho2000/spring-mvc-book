package com.webbansach.controllers.admin;

import com.webbansach.dto.OrderDTO;
import com.webbansach.service.IOrderService;
import com.webbansach.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller(value = "homeControllerOfAdmin")
public class HomeController {

    @Autowired
    IOrderService orderService;

    @Autowired
    IUserService userService;

    @RequestMapping(value = "/admin/home", method = RequestMethod.GET)
    public ModelAndView homePage() {
        ModelAndView mav = new ModelAndView("admin_home");
        List<OrderDTO> orderDTOList = orderService.findAllByStatus(1, null);
        int totalIncome = orderService.getTotalPriceOptionsOrder(orderDTOList);
        mav.addObject("countNewOrder", orderService.findAllNewOrder(null).size());
        mav.addObject("countNewUser", userService.findAllByCurrentDay(null).size());
        mav.addObject("totalIncome", totalIncome);
        return mav;
    }

}