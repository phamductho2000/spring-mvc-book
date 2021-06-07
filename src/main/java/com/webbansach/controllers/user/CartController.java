package com.webbansach.controllers.user;

import com.webbansach.dto.CartDTO;
import com.webbansach.service.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;

@Controller(value = "cartControllerOfAdmin")
public class CartController {
    @Autowired
    ICartService cartService;

    @RequestMapping(value = "/trang-chu/them-vao-gio/{id}")
    public String addToCart(HttpServletRequest request, HttpSession session, @PathVariable long id){
        HashMap<Long, CartDTO> cart = (HashMap<Long, CartDTO>)session.getAttribute("Cart");
        if(cart == null){
            cart = new HashMap<Long, CartDTO>();
        }
        cart = cartService.addCart(id, cart);
        session.setAttribute("Cart", cart);
        return "redirect:"+request.getHeader("Referer");
    }
}
