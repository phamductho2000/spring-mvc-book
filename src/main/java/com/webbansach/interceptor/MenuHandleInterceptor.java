package com.webbansach.interceptor;

import com.webbansach.service.ICategoryService;
import com.webbansach.service.IContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MenuHandleInterceptor implements HandlerInterceptor {

    @Autowired
    private ICategoryService categoryService;

    @Autowired
    private IContactService contactService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        request.setAttribute("menu", categoryService.findAllByStatus(1, null));
        request.setAttribute("contact", contactService.findOne());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
    }

}