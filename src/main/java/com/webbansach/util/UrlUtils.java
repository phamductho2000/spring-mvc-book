package com.webbansach.util;

import javax.servlet.http.HttpServletRequest;

public class UrlUtils {

    public static String getSiteUrl(HttpServletRequest request){
        String siteUrl = request.getRequestURL().toString();
        return siteUrl.replace(request.getServletPath(), "");
    }
}
