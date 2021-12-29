package com.webbansach.controllers.user;

import com.webbansach.dto.CartDTO;
import com.webbansach.dto.PaymentDTO;
import com.webbansach.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

    @Autowired
    IBookService bookService;

    @Autowired
    IPaymentMomoService paymentMomoService;

    @Autowired
    IPaymentService paymentService;

    @Autowired
    IPaymentVnpayService paymentVnpayService;

    @RequestMapping(value = "/thanh-toan", method = RequestMethod.GET)
    public ModelAndView homePage( HttpSession session) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication == null || authentication instanceof AnonymousAuthenticationToken){

            return new ModelAndView("login");
        }
        else{
            ModelAndView mav = new ModelAndView("checkout");
            int total_price = (int) session.getAttribute("totalPrice");
            total_price = total_price + 30000;
            session.setAttribute("totalPrice", total_price);
            return mav;
        }
    }

    @RequestMapping(value = "/dat-hang", method = RequestMethod.POST)
    public ModelAndView order(@RequestParam("userId") long userId,
                              HttpSession session,
                              @RequestParam("optionPayments") String optionPayments) {
        HashMap<Long, CartDTO> cart = (HashMap<Long, CartDTO>)session.getAttribute("Cart");
        int totalPrice = (int) session.getAttribute("totalPrice");
        if(optionPayments.equals("COD")){
            checkoutService.saveOrder(cart, userId, optionPayments, totalPrice);
        }
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

    @RequestMapping(value = "/momo", method = RequestMethod.POST)
    public String sendRequestToMoMo(@RequestParam("userId") long userId,
                              HttpSession session,
                              @RequestParam("optionPayments") String optionPayments) throws Exception {
        HashMap<Long, CartDTO> cart = (HashMap<Long, CartDTO>)session.getAttribute("Cart");
        int totalPrice = (int) session.getAttribute("totalPrice");
        long orderId = checkoutService.saveOrderReturnId(cart, userId, optionPayments, totalPrice);
        String responsePayUrl = paymentMomoService.sendRequest(orderId, totalPrice);
        return "redirect:" + responsePayUrl;
    }

    @RequestMapping(value = "/vnpay", method = RequestMethod.POST)
    public String sendRequestToVnPay(@RequestParam("userId") long userId,
                                     HttpSession session,
                                     @RequestParam("optionPayments") String optionPayments,
                                     HttpServletRequest request) throws Exception {
        HashMap<Long, CartDTO> cart = (HashMap<Long, CartDTO>)session.getAttribute("Cart");
        int totalPrice = (int) session.getAttribute("totalPrice");
        long orderId = checkoutService.saveOrderReturnId(cart, userId, optionPayments, totalPrice);
        String responsePayUrl = paymentVnpayService.sendRequest(orderId, totalPrice, request);
        return "redirect:" + responsePayUrl;

    }

    @RequestMapping(value = "/VnPayIPN", method = RequestMethod.GET)
    public void dataVnPayResponse(HttpServletResponse response, HttpServletRequest request) {
       String responseVnPay = request.getQueryString();
       System.out.println(responseVnPay);
       System.out.println("Đã nhận được");
    }

    @RequestMapping(value = "/VnPayReturn", method = RequestMethod.GET)
    public ModelAndView VnPayReturn() {
        ModelAndView mav = new ModelAndView("order_success");
        return mav;
    }

    @RequestMapping(value = "/thanh-cong", method = RequestMethod.GET)
    public ModelAndView returnUrl() {
        ModelAndView mav = new ModelAndView("order_success");
        return mav;
    }

    @RequestMapping(value = "/thanh-cong", method = RequestMethod.POST)
    public String notifyUrl() {
        return "Ok";
    }
}
