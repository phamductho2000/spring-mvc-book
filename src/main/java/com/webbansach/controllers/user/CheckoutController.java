package com.webbansach.controllers.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller(value = "checkoutControllerOfAdmin")
public class CheckoutController {
    @RequestMapping(value = "/thanh-toan", method = RequestMethod.GET)
    public ModelAndView homePage() {
        ModelAndView mav = new ModelAndView("checkout");
        return mav;
    }
}
