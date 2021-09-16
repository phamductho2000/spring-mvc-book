package com.webbansach.controllers.user;

import com.webbansach.dto.BookDTO;
import com.webbansach.dto.UserDTO;
import com.webbansach.dto.WishlistDTO;
import com.webbansach.service.IBookService;

import com.webbansach.service.IUserService;
import com.webbansach.service.IWishlistService;
import com.webbansach.util.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Controller(value = "wishlistControllerOfAdmin")
public class WishlistController {
    @Autowired
    IWishlistService wishlistService;

    @Autowired
    IBookService bookService;

    @Autowired
    IUserService userService;

    @RequestMapping(value = "/yeu-thich")
    public ModelAndView show(HttpSession session){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication == null || authentication instanceof AnonymousAuthenticationToken){

            ModelAndView mav = new ModelAndView("login");
            return mav;
        }
        else{
            ModelAndView mav = new ModelAndView("wishlist");
            long id = SecurityUtils.getPrincipal().getId();
            mav.addObject("wishlist", wishlistService.findAllByUserEntityId(id, null));
            return mav;
        }

    }

    @RequestMapping(value = "/them-vao-yeu-thich/{bId}", method = RequestMethod.GET)
    public String addToWishlist(@PathVariable(value = "bId") long id,
                                HttpServletRequest request,
                                HttpSession session){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication == null || authentication instanceof AnonymousAuthenticationToken){

            return "redirect:/dang-nhap";
        }
        else{
            WishlistDTO wishlist = new WishlistDTO();
            BookDTO book = bookService.findOne(id);
            UserDTO user = userService.findOne(SecurityUtils.getPrincipal().getId());
            wishlist.setBook(book);
            wishlist.setUser(user);
            wishlistService.save(wishlist);
        }
       return "redirect:/trang-chu";
    }

    @RequestMapping(value = "/yeu-thich/xoa/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable(value = "id") long id, HttpServletRequest request){

        wishlistService.remove(id);
        return "redirect:/yeu-thich";
    }


}
