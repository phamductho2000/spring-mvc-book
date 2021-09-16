package com.webbansach.controllers.user;

import com.webbansach.dto.CartDTO;
import com.webbansach.service.ICartService;
import com.webbansach.service.ICheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

@Controller(value = "checkoutControllerOfAdmin")
public class CheckoutController {
    @Autowired
    ICartService cartService;

    @Autowired
    ICheckoutService checkoutService;

    @RequestMapping(value = "/thanh-toan", method = RequestMethod.GET)
    public ModelAndView homePage( HttpSession session) {
        ModelAndView mav = new ModelAndView("checkout");
        int total_price = (int) session.getAttribute("totalPrice");
        total_price = total_price + 30000;
        session.setAttribute("totalPrice", total_price);
        return mav;
    }

    @RequestMapping(value = "/dat-hang", method = RequestMethod.POST)
    public ModelAndView order(@RequestParam("userId") long userId, HttpSession session) {
        HashMap<Long, CartDTO> cart = (HashMap<Long, CartDTO>)session.getAttribute("Cart");
        int totalPrice = (int) session.getAttribute("totalPrice");
        checkoutService.saveOrder(cart, userId, totalPrice);
        List<CartDTO> listCart = new ArrayList<>();
        Set<Long> keySet = cart.keySet();
        for (Long key : keySet) {
            listCart.add(cart.get(key));
        }
        session.removeAttribute("Cart");
        session.removeAttribute("totalPrice");
        ModelAndView mav = new ModelAndView("order_success");
        mav.addObject("listCart", listCart);
        mav.addObject("totalPrice", totalPrice);
        return mav;
    }
}
