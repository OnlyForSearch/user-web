package cn.fengyu.ssm.web.login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @author fengyu
 * @since 2016-01-22
 */
@Controller
@RequestMapping("/login")
public class LoginController {
    @RequestMapping("/login")
    public String login(HttpSession session ,String username,String password)throws Exception{
        session.setAttribute("username", username);


        return "redirect:/items/queryItems";
    }

    @RequestMapping("/logout")
    public String logout(HttpSession httpSession) throws Exception{
        httpSession.invalidate();
        return "redirect:/items/queryItems";
    }

}
