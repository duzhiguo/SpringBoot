package com.bookmanage.demo.control;


import com.bookmanage.demo.Repository.BookRepository;
import com.bookmanage.demo.dao.Admin;
import com.bookmanage.demo.service.AdminService;
import com.bookmanage.demo.service.BookService;
import com.bookmanage.demo.service.BookUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@EnableAutoConfiguration
public class AdminControl {
    @Autowired(required = true)
    private BookService bookService;
    @Autowired(required = true)
    private BookRepository bookRepository;
    @Autowired(required = true)
    private BookUserService bookUserService;
    @Autowired(required = true)
    private AdminService adminService;


    @RequestMapping("/admin")
    String admin(){
        return "admin";
    }
    @RequestMapping("/adminlogin")
    String adminlogin(Admin admin, HttpSession session){
        System.out.println(admin.toString());
        boolean verify = adminService.verifyAdmin(admin);
        if (verify) {
            admin = adminService.selectUserByAccount(admin.getAccount());
            System.out.println(admin.toString()+"管理员验证密码");

            // model.addAttribute("name", user.getName());
            //model.addAttribute("password", user.getPassWord());
            session.setAttribute("name",admin.getName());
            session.setAttribute("account",admin.getAccount());

            return "redirect:/welcome";
        } else {
            return "redirect:/notVerify";
        }

    }


}
