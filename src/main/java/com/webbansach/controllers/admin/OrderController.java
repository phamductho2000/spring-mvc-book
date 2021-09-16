package com.webbansach.controllers.admin;

import com.webbansach.dto.OrderDTO;
import com.webbansach.service.IBookService;
import com.webbansach.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.text.ParseException;

@Controller(value = "orderControllerOfAdmin")
public class OrderController {
    @Autowired
    IOrderService orderService;

    @Autowired
    IBookService bookService;

    @RequestMapping(value = "/admin/order", method = RequestMethod.GET)
    public ModelAndView homePage(@RequestParam(value = "page", required = false, defaultValue = "1") int page) {
        ModelAndView mav = new ModelAndView("admin_order");
        Pageable pageable = new PageRequest(page-1, 8);
        int totalPage = 0;
        if((orderService.getTotalItem() % 8) == 0){
            totalPage = orderService.getTotalItem()/8;
        }
        else{
            totalPage = (orderService.getTotalItem()/8) + 1;
        }
        mav.addObject("listOrder", orderService.findAll(pageable));
        mav.addObject("totalPage", totalPage);
        mav.addObject("currentPage", page);
        return mav;
    }

    @RequestMapping(value = "/admin/order/detail/{orderId}", method = RequestMethod.GET)
    public ModelAndView detailPage(@PathVariable("orderId") long orderId) {
        ModelAndView mav = new ModelAndView("admin_order_detail");
        mav.addObject("Order", orderService.findOne(orderId));
        mav.addObject("listDetailOrder", orderService.findAllDetailOrder(orderId));
        return mav;
    }

    @RequestMapping(value = "/admin/order/update", method = RequestMethod.POST)
    public String update(@RequestParam("statusOrder") int status,
                               @RequestParam("id") long id) {
        OrderDTO orderDTO = orderService.findOne(id);
        orderDTO.setStatus(status);
        orderService.save(orderDTO);
        return "redirect:/admin/order";
    }


    @RequestMapping(value = "/admin/order/search", method = RequestMethod.POST)
    public ModelAndView searchBook(@RequestParam(name = "id", defaultValue = "0") int id,
                                   @RequestParam(name = "status") int status,
                                   @RequestParam(name = "startDate", defaultValue = "") String startDate,
                                   @RequestParam(name = "endDate", defaultValue = "") String endDate,
                                   @RequestParam(name = "page", required = false) int page) throws ParseException {
        ModelAndView mav = new ModelAndView("admin_order");


        mav.addObject("listOrder", orderService.search(id, status, startDate, endDate ,null));
        return mav;
    }

}
