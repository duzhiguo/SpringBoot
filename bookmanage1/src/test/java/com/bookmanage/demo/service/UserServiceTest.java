package com.bookmanage.demo.service;

import com.bookmanage.demo.Repository.BookUserRepository;
import com.bookmanage.demo.dao.BookUser;
import com.bookmanage.demo.dao.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {
    @Autowired(required = true)
    //private UserRepository userRepository;
   // private BookRepository bookRepository;
   private BookUserRepository bookUserRepository;


    @Test

    public void test() {
        String acc = "20160804";
        User user = new User("李四", acc, "123");
        BookUser ouserbok = new BookUser("王五","组成原理",1);
        List<BookUser> books  =  this.bookUserRepository.findAllByNameAndBname("张三", "网络原理");
        int a  =  this.bookUserRepository.deleteUserBook("张三", "网络原理");
        System.out.println(books+"boouser" +a );
         //int a = bookRepository.updateAddBookNum("张三", "网络原理","2016011");
        // System.out.println(a +"测试 啊书法书法大师法师");
        //BookUser bookUser = new BookUser("张三", "体育", 1);
        // BookUserService bookUserService = new BookUserService();
        // bookUserService.insertNews(bookUser);
        //bookUserRepository.save(bookUser);

//        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");//设置日期格式
//        System.out.println(df.format(new Date()));
//        System.out.println();
//        //System.out.println(user.toString());
//
//        for (Book book : this.bookRepository.findAll()){
//
//            System.out.println(book);
//        }
//
//            System.out.println(this.bookRepository.findAll().getClass().getName());
        //  this.userRepository.save(user);
        //  System.out.println(this.userRepository.findByName("张三"));

        //userRepository.save(new User("李四", "20160804", "123"));
        //List<User> use = this.userRepository.findByAccountAndPassWord("20160803", "123");
        /// System.out.println(use +" user :  ///");
    }

}