package com.shine.storage.rest.web;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author : shine
 * @Project: Storage
 * @Description:
 * @date: 2018年10月20日 21:19
 */
@Controller
public class LoginController {

    @RequestMapping({"/", "/index"})
    public String index() {
        return "/index";
    }

    /**
     * 只处理异常信息*/
    @RequestMapping("/login")
    public String login(HttpServletRequest request, Map<String, Object> map) {
        // 登录失败从request中获取shiro处理的异常信息。
        // shiroLoginFailure:就是shiro异常类的全类名.

        String exception = (String) request.getAttribute("shiroLoginFailure");
        String mesg = "";
        if (exception != null) {
            if (UnknownAccountException.class.getName().equals(exception)) {
                mesg = "UnknownAccountException -- > 账号不存在";
            } else if (IncorrectCredentialsException.class.getName().equals(exception)) {
                mesg = "IncorrectCredentialsException -- > 密码不正确";
            } else if ("kaptchaValidateFailed".equals(exception)) {
                mesg = "kaptchaValidateFailed -- > 验证码错误";
            } else if (LockedAccountException.class.getName().equals(exception)) {
                mesg = "LockedAccountException --> 账户被锁";
            } else {
                mesg = "else >> " + exception;
            }
        }
        map.put("msg", mesg);
        return "/login";
    }

    /***/
    @RequestMapping("/403")
    public String unauthorizedRole() {
        System.out.println("------没有权限-------");
        return "403";
    }


    @PostMapping("/login")
    public String login2(String username, String password, HttpServletRequest request, Map<String, Object> map) {
        // 登录失败从request中获取shiro处理的异常信息。
        // shiroLoginFailure:就是shiro异常类的全类名.
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        /*获取当前登录的用户信息*/
        Subject currentUser = SecurityUtils.getSubject();
        if (!currentUser.isAuthenticated()) {
            try {
                subject.login(token);
            } catch (UnknownAccountException e) {
                e.printStackTrace();
                token.clear();
                map.put("msg", "账号不存在");

            } catch (IncorrectCredentialsException e) {
                e.printStackTrace();
                token.clear();
                map.put("msg", "密码不正确");
            } catch (LockedAccountException e) {
                e.printStackTrace();
                token.clear();
                map.put("msg", "账户被锁");
            } catch (ExcessiveAttemptsException eae) {
                eae.printStackTrace();
                token.clear();
                map.put("msg", "超过错误次数");
            }
        }
        if (map.isEmpty())
            return "/index";
        return "/login";
    }
}
