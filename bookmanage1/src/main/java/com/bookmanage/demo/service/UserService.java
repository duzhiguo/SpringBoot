package com.bookmanage.demo.service;

import com.bookmanage.demo.Repository.UserRepository;
import com.bookmanage.demo.dao.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired(required=true)
    private UserRepository userRepository;

    public boolean verifyUser(User user) {

        if (userRepository.findByAccountAndPassWord(user.getAccount(), user.getPassWord()).isEmpty()) {
            return false;
        } else {

            return true;
        }
    }
    public String registerUser(User user) {
        System.out.println(user.toString());
        if (userRepository.findByName(user.getName()).isEmpty()) {
            userRepository.save(user);
            return "用户名  " + user.getName() + " 注册成功 ";

        } else {

            return "用户名 " + user.getName() + "已被占用！";
        }

    }
    public  User  selectUserByAccount(String account){
         User user = new User();
         user = userRepository.findByAccount(account);
         return user;
    }


}
