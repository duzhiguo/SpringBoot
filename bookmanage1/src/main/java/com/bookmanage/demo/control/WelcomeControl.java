package com.bookmanage.demo.control;

import com.bookmanage.demo.dao.User;
import com.bookmanage.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@EnableAutoConfiguration
public class WelcomeControl {

    @Autowired(required = true)
    private UserService userService;

    @RequestMapping("/welcome")
    String welcome(Model model) {
        model.addAttribute("user", new User());
        return "welcome";
    }
    @RequestMapping("/meserror")
    String meserror(Model model) {

        return "welcome";
    }
    @RequestMapping("/success")
    String success(Model model) {

        return "welcome";
    }
//    @RequestMapping("/404")
//    String  errorTest(Model model) {
//
//        return "404_error";
//    }


    @RequestMapping("/index")
    String index(Model model) {

        return "index";
    }

}
