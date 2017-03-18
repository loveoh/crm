package com.kaishengit.util;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by loveoh on 2017/3/15.
 */
public class IPUtil {

    public static String getIp(HttpServletRequest request){
       String ip = request.getRemoteAddr();
        if ("0:0:0:0:0:0:0:1".equals(ip)){
            ip = "127.0.0.1";
        }
        return ip;
    }
}
