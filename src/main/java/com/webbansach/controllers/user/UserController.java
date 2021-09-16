package com.webbansach.controllers.user;

import com.webbansach.dto.OrderDTO;
import com.webbansach.dto.ReviewDTO;
import com.webbansach.dto.UserDTO;
import com.webbansach.service.IOrderService;
import com.webbansach.service.IReviewService;
import com.webbansach.service.IUserService;
import com.webbansach.util.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;


@Controller(value = "userControllerOfUser")
public class UserController {
    @Autowired
    IUserService userService;

    @Autowired
    IOrderService orderService;

    @Autowired
    IReviewService reviewService;


    @RequestMapping(value = "/dang-nhap", method = RequestMethod.GET)
    public ModelAndView loginPage() {
        ModelAndView mav = new ModelAndView("login");
        return mav;
    }

    @RequestMapping(value = "/dang-ky", method = RequestMethod.POST)
    public String registerUser(@RequestParam(value = "register-user") String user,
                               @RequestParam(value = "register-password") String password) {
        userService.registerUser(user, password);
        return "redirect:/trang-chu";
    }
    @RequestMapping(value = "/dang-xuat", method = RequestMethod.GET)
    public String logoutUser(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/trang-chu";
    }


    @RequestMapping(value = "/tai-khoan/don-hang", method = RequestMethod.GET)
    public ModelAndView orderPage() {
        ModelAndView mav = new ModelAndView("order");
        long userId = SecurityUtils.getPrincipal().getId();
        mav.addObject("lstOrder", orderService.findAllByUserId(userId, null));
        return mav;
    }

    @RequestMapping(value = "tai-khoan/chi-tiet-don-hang/{orderId}", method = RequestMethod.GET)
    public ModelAndView detailOrderPage(@PathVariable(value = "orderId") long orderId) {
        ModelAndView mav = new ModelAndView("detail_order");
        mav.addObject("listDetailOrder", orderService.findAllDetailOrder(orderId));
        mav.addObject("Order", orderService.findOne(orderId));
        return mav;
    }

    @RequestMapping(value = "/tai-khoan/thong-tin", method = RequestMethod.GET)
    public ModelAndView accountPage() {
        UserDTO userDTO = userService.findOneByUserName(SecurityContextHolder.getContext().getAuthentication().getName());
        ModelAndView mav = new ModelAndView("account", "user", new UserDTO());
        mav.addObject("userDetail", userDTO);
        return mav;
    }

    @RequestMapping(value = "tai-khoan/cap-nhat", method = RequestMethod.POST)
    public String updateAccount(@ModelAttribute("user") UserDTO user,
                                @RequestParam(value = "imgAvatar") CommonsMultipartFile commonsMultipartFile) {
        String nameFile = commonsMultipartFile.getOriginalFilename();
        File file = new File("C:\\Users\\tho20\\IdeaProjects\\spring-mvc-book\\src\\main\\webapp\\resources\\book_images", nameFile);
        try {
            commonsMultipartFile.transferTo(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        user.setAvatar(nameFile);
        userService.saveCustomer(user);
        SecurityUtils.getPrincipal().setFullName(user.getName());
        return "redirect:/tai-khoan";
    }

    @RequestMapping(value = "/danh-gia", method = RequestMethod.POST)
    public String reviewProduct(@RequestParam(value = "content") String content,
                                @RequestParam(value = "rate") int rate,
                                @RequestParam(value = "productId") long productId) {
        long idUser = SecurityUtils.getPrincipal().getId();
        ReviewDTO reviewDTO = new ReviewDTO();
        reviewDTO.setContent(content);
        reviewDTO.setRate(rate);
        reviewDTO.setBookId(productId);
        reviewDTO.setUserId(idUser);
        reviewService.save(reviewDTO);
        return "redirect:/tai-khoan";
    }

    @RequestMapping(value = "/tai-khoan/don-hang/huy/{id}", method = RequestMethod.GET)
    public String cancelOrder(@PathVariable(value = "id") long id) {
        OrderDTO orderDTO = orderService.findOne(id);
        orderDTO.setStatus(3);
        orderService.save(orderDTO);
        return "redirect:/tai-khoan/don-hang";
    }
}
