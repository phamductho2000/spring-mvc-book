package com.webbansach.controllers.user;

import com.webbansach.dto.BookDTO;
import com.webbansach.dto.UserDTO;
import com.webbansach.dto.WishlistDTO;
import com.webbansach.entity.WishlistEntity;
import com.webbansach.repository.WishlistRepository;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Controller(value = "wishlistControllerOfAdmin")
public class WishlistController {
    @Autowired
    IWishlistService wishlistService;

    @Autowired
    WishlistRepository wishlistRepository;

    @Autowired
    IBookService bookService;

    @Autowired
    IUserService userService;

    @RequestMapping(value = "tai-khoan/yeu-thich")
    public ModelAndView show(){
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

    @RequestMapping(value = "/them-vao-yeu-thich", method = RequestMethod.POST)
    @ResponseBody
    public String addToWishlist(@RequestParam(value = "bId") long id){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication == null || authentication instanceof AnonymousAuthenticationToken){

            return "NOT_LOGIN";
        }
        else{
            WishlistDTO wishlist = new WishlistDTO();
            BookDTO book = bookService.findOne(id);
            UserDTO user = userService.findOne(SecurityUtils.getPrincipal().getId());

            WishlistEntity checkWishlist = wishlistRepository.findOneByBookIdAndUserId(book.getId(), user.getId());
            if(checkWishlist == null){
                wishlist.setBook(book);
                wishlist.setUser(user);
                wishlistService.save(wishlist);
                return "SUCCESS";
            }
            else{
                return "EXIST";
            }
        }
    }

    @RequestMapping(value = "/tai-khoan/yeu-thich/xoa/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable(value = "id") long id, HttpServletRequest request){
        wishlistService.remove(id);
        return "redirect:/tai-khoan/yeu-thich";
    }


}
