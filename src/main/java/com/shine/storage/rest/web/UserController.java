package com.shine.storage.rest.web;

import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author : shine
 * @Project: Storage
 * @Description:
 * @date: 2018年10月20日 21:19
 */
@Controller
//@RequestMapping("/api/user")
public class UserController {

    @RequestMapping({"/","/index"})
    public String index(){
        return "/index";
    }

    /*只处理异常信息*/
    @RequestMapping("/login")
    public String login(HttpServletRequest request, Map<String, Object> map) {
        // 登录失败从request中获取shiro处理的异常信息。
        // shiroLoginFailure:就是shiro异常类的全类名.

        String exception = (String) request.getAttribute("shiroLoginFailure");
        String mesg = "";
        if (exception!=null){
            if (UnknownAccountException.class.getName().equals(exception)){
                mesg = "UnknownAccountException -- > 账号不存在";
            }else if (IncorrectCredentialsException.class.getName().equals(exception)){
                mesg = "IncorrectCredentialsException -- > 密码不正确";
            }else if ("kaptchaValidateFailed".equals(exception)){
                mesg = "kaptchaValidateFailed -- > 验证码错误";
            }else {
                mesg = "else >> "+exception;
            }
        }
        map.put("msg",mesg);
        return "/login";
    }

    /**/
    @RequestMapping("/403")
    public String unauthorizedRole(){
        System.out.println("------没有权限-------");
        return "403";
    }
}
