package com.webbansach.controllers.user;

import com.webbansach.dto.CartDTO;
import com.webbansach.service.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Controller(value = "cartControllerOfAdmin")
public class CartController {
    @Autowired
    ICartService cartService;

    @RequestMapping(value = "/gio-hang")
    public ModelAndView showCart(){
        ModelAndView mav = new ModelAndView("cart");
        return mav;
    }

    @RequestMapping(value = "/them-vao-gio/{id}")
    public String addToCart(HttpServletRequest request, HttpSession session, @PathVariable long id){
        HashMap<Long, CartDTO> cart = (HashMap<Long, CartDTO>)session.getAttribute("Cart");
        if(cart == null){
            cart = new HashMap<Long, CartDTO>();
        }
        cart = cartService.addCart(id, cart);
        session.setAttribute("Cart", cart);
        session.setAttribute("totalPrice", cartService.totalPrice(cart));
        return "redirect:"+request.getHeader("Referer");
    }

    @RequestMapping(value = "/cap-nhat-gio", method = RequestMethod.POST)
    public @ResponseBody ModelAndView updateCart(@RequestParam(value = "myQuantys") int[] quantys, HttpSession session, HttpServletRequest request){
        HashMap<Long, CartDTO> cart = (HashMap<Long, CartDTO>)session.getAttribute("Cart");
        cart = cartService.editCart(quantys, cart);
        return new ModelAndView("cart");
    }

    @RequestMapping(value = "/xoa-san-pham-trong-gio-hang/{id}")
    public String removeCart(HttpServletRequest request, HttpSession session, @PathVariable long id){
        HashMap<Long, CartDTO> cart = (HashMap<Long, CartDTO>)session.getAttribute("Cart");
        cartService.deleteItemCart(id, cart);
        return "redirect:"+request.getHeader("Referer");
    }
}
