package com.yk.vote.controller;

import com.yk.vote.po.User;
import com.yk.vote.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/userRegister", method = { RequestMethod.POST } )
    public String userRegister(Model model, @RequestParam(value = "userName") String userName, @RequestParam(value = "password") String password,
                               @RequestParam(value = "confirmPassword") String confirmPassword) throws Exception {
        User user = userService.queryUserByUsername(userName);
        if(userName == null || userName.equals("") || password == null || password.equals("") || !password.equals(confirmPassword) || user != null) {
            model.addAttribute("status", "failed");
            return "register";
        } else {
            userService.saveUser(new User(userName, password));
            return "reg_success";
        }
    }

    @RequestMapping(value = "/userLogin", method = { RequestMethod.POST } )
    public String userLogin(Model model, HttpSession session, @RequestParam(value = "userName") String userName, @RequestParam(value = "password") String password) throws Exception {
        User user = userService.queryUser(new User(userName, password));
        if(user == null) {
            model.addAttribute("status", "failed");
            return "login";
        } else {
            session.setAttribute("currentUser", user);
            return "redirect:/queryAllVotes";
        }
    }
}
