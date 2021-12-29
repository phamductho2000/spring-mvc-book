package com.webbansach.controllers.user;

import com.webbansach.dto.MessageResponse;
import com.webbansach.dto.OrderDTO;
import com.webbansach.dto.ReviewDTO;
import com.webbansach.dto.UserDTO;
import com.webbansach.entity.PasswordResetTokenEntity;
import com.webbansach.entity.UserEntity;
import com.webbansach.repository.UserRepository;
import com.webbansach.service.IOrderService;
import com.webbansach.service.IPasswordResetTokenService;
import com.webbansach.service.IReviewService;
import com.webbansach.service.IUserService;
import com.webbansach.util.SecurityUtils;
import com.webbansach.util.UrlUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.UUID;


@Controller(value = "userControllerOfUser")
public class UserController {
    @Autowired
    private IUserService userService;

    @Autowired
    private IOrderService orderService;

    @Autowired
    private IReviewService reviewService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private IPasswordResetTokenService passwordResetTokenService;


    @RequestMapping(value = "/dang-nhap", method = RequestMethod.GET)
    public ModelAndView loginPage() {
        ModelAndView mav = new ModelAndView("login");
        return mav;
    }

    @RequestMapping(value = "/dang-ky", method = RequestMethod.POST)
    public ModelAndView registerUser(@RequestParam(value = "register-user") String user,
                               @RequestParam(value = "register-password") String password) {
        ModelAndView mav = new ModelAndView("login");
        UserEntity userEntity = userRepository.findOneByUsername(user);
        if(userEntity != null){
            mav.addObject("messageError", "Tên đăng nhập đã tồn tại");
            return mav;
        }
        else{
            userService.registerUser(user, password);
            mav.addObject("messageSuccess", "Đăng ký thành công");
            return mav;
        }
    }

    @RequestMapping(value = "/dang-xuat", method = RequestMethod.GET)
    public String logoutUser(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/trang-chu";
    }

    @RequestMapping(value = "/login-failure", method = RequestMethod.GET)
    @ResponseBody
    public String loginFailure() {
        return "LOGIN_FAILURE";
    }


    @RequestMapping(value = "/tai-khoan/don-hang", method = RequestMethod.GET)
    public ModelAndView orderPage(@RequestParam(value = "page", required = false, defaultValue = "1") int page,
                                  @RequestParam(value = "limit", defaultValue = "16") int limit) {

        ModelAndView mav = new ModelAndView("order");
        Pageable pageable = new PageRequest(page-1, limit, Sort.Direction.DESC, "createdDate");
        int totalPage = 0;
        long userId = SecurityUtils.getPrincipal().getId();
        int countItem = orderService.findAllByUserId(userId, null).size();
        if((countItem % limit) == 0){
            totalPage = countItem / limit;
        }
        else{
            totalPage = (countItem / limit) + 1;
        }
        mav.addObject("lstOrder", orderService.findAllByUserId(userId, pageable));
        mav.addObject("totalPage", totalPage);
        mav.addObject("currentPage", page);
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
        user.setStatus(1);
        userService.saveCustomer(user);
        SecurityUtils.getPrincipal().setFullName(user.getName());
        return "redirect:/tai-khoan/thong-tin";
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
        return "redirect:/tai-khoan/don-hang";
    }

    @RequestMapping(value = "/tai-khoan/don-hang/huy/{id}", method = RequestMethod.GET)
    public String cancelOrder(@PathVariable(value = "id") long id) {
        OrderDTO orderDTO = orderService.findOne(id);
        orderDTO.setStatus(3);
        orderService.save(orderDTO);
        return "redirect:/tai-khoan/don-hang";
    }

    @RequestMapping(value = "/forgot-password", method = RequestMethod.GET)
    public ModelAndView forgotPasswordPage() {
       ModelAndView mav = new ModelAndView("forgot_password");
       return mav;
    }

    @RequestMapping(value = "/forgot-password", method = RequestMethod.POST)
    public ModelAndView forgotPassword(@RequestParam("emailReset") String emailReset,
                                   HttpServletRequest request) throws UnsupportedEncodingException, MessagingException {
        ModelAndView mav = new ModelAndView("forgot_password");
        UserDTO user = userService.findOneByEmail(emailReset);
        MessageResponse message = new MessageResponse();
        if(user == null){
            mav.addObject("message", "Could not find any account with the email");
        }
        else {
            String token = UUID.randomUUID().toString();
            userService.createPasswordResetTokenForUser(user, token);
            String resetPasswordLink = UrlUtils.getSiteUrl(request) + "/change-password?token=" + token;
            userService.sendEmailToResetPassword(user.getEmail(), resetPasswordLink);
            mav.addObject("message", "We have sent a reset password link to your email. Please check.");
        }
        return mav;
    }

    @RequestMapping(value = "/change-password", method = RequestMethod.GET)
    public ModelAndView changePasswordPage(@Param(value = "token") String token){
        PasswordResetTokenEntity passwordResetTokenEntity = passwordResetTokenService.findByToken(token);
        ModelAndView mav = new ModelAndView();
        if(passwordResetTokenEntity == null){
            mav.setViewName("404");
            return mav;
        }
        mav.setViewName("change_password");
        mav.addObject("token", token);
        return mav;
    }

    @RequestMapping(value = "/change-password", method = RequestMethod.POST)
    public ModelAndView changePassword(@RequestParam("new-password") String password,
                                 @RequestParam("re-password") String rePassword,
                                 @RequestParam(value = "token", required = false) String token){
        PasswordResetTokenEntity passwordResetTokenEntity = passwordResetTokenService.findByToken(token);
        userService.updatePassword(passwordResetTokenEntity.getUser().getId(), password);
        ModelAndView mav = new ModelAndView("change_password");
        mav.addObject("message", "Success");
        return mav;
    }
}
