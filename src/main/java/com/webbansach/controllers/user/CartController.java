package com.webbansach.controllers.user;

import com.webbansach.dto.CartDTO;
import com.webbansach.service.ICartService;
import com.webbansach.service.IVoucherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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

    @Autowired
    IVoucherService voucherService;

    @RequestMapping(value = "/gio-hang")
    public ModelAndView showCart(HttpSession session){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication == null || authentication instanceof AnonymousAuthenticationToken){

            return new ModelAndView("login");
        }
        else{

            return new ModelAndView("cart");
        }
    }

    @RequestMapping(value = "/them-vao-gio/{id}", method = RequestMethod.POST)
    public String addToCart(HttpServletRequest request, HttpSession session, @PathVariable long id,
                            @RequestParam("quantity") int quantity){
        HashMap<Long, CartDTO> cart = (HashMap<Long, CartDTO>)session.getAttribute("Cart");
        if(cart == null){
            cart = new HashMap<Long, CartDTO>();
        }
        cart = cartService.addCart(id, quantity, cart);
        session.setAttribute("Cart", cart);
        session.setAttribute("totalPrice", cartService.totalPrice(cart));
        return "redirect:"+request.getHeader("Referer");
    }

    @RequestMapping(value = "/cap-nhat-gio", method = RequestMethod.POST)
    public @ResponseBody ModelAndView updateCart(@RequestParam(value = "myQuantys") int[] quantys, HttpSession session, HttpServletRequest request){
        HashMap<Long, CartDTO> cart = (HashMap<Long, CartDTO>)session.getAttribute("Cart");
        int total_price = (int) session.getAttribute("totalPrice");
        cart = cartService.editCart(quantys, cart);
        total_price = cartService.totalPrice(cart);
        session.setAttribute("Cart", cart);
        session.setAttribute("totalPrice", total_price);
        return new ModelAndView("cart");
    }

    @RequestMapping(value = "/xoa-san-pham-trong-gio-hang/{id}")
    public String removeCart(HttpServletRequest request, HttpSession session, @PathVariable long id){
        HashMap<Long, CartDTO> cart = (HashMap<Long, CartDTO>)session.getAttribute("Cart");
        cartService.deleteItemCart(id, cart);
        return "redirect:"+request.getHeader("Referer");
    }

    @RequestMapping(value = "/ap-dung-voucher", method = RequestMethod.POST)
    public ModelAndView applyVoucher(HttpServletRequest request, HttpSession session, @RequestParam("code") String code){
        ModelAndView mav = new ModelAndView("cart");
        int totalPrice = (int) session.getAttribute("totalPrice");
        int discount = voucherService.getDiscount(code);
        if(discount != 0){
            int newTotalPrice = totalPrice/100 * (100 - discount);
            session.setAttribute("totalPrice", newTotalPrice);
            session.setAttribute("discount", totalPrice - newTotalPrice);
            mav.addObject("message", "Bạn được giảm "+discount+" % tổng giá trị đơn hàng");
        }
        else{
            session.setAttribute("totalPrice", totalPrice);
        }
        return mav;
    }

    @RequestMapping(value = "/huy-voucher", method = RequestMethod.GET)
    public String disableVoucher(HttpSession session){
        int totalPrice = (int) session.getAttribute("totalPrice");
        int discount = (int) session.getAttribute("discount");
        int newTotalPrice = totalPrice*100/(100 - discount);
        session.setAttribute("totalPrice", newTotalPrice);
        return "redirect:/gio-hang";
    }
}
