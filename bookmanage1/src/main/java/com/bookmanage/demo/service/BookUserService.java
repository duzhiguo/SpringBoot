package com.bookmanage.demo.service;

import com.bookmanage.demo.Repository.BookUserRepository;
import com.bookmanage.demo.dao.BookUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookUserService {

    @Autowired(required = true)
    private BookUserRepository bookUserRepository;

    public boolean insertNews(BookUser bookUser) {
        if (bookUserRepository.findAllByNameAndBname(bookUser.getName(), bookUser.getBname()).isEmpty()) {

            System.out.println(bookUser.toString()+"service");
            bookUserRepository.updateUserBook(bookUser.getName(), bookUser.getBname(), bookUser.getBnumber(), bookUser.getTime());
            // String name, String bname, int bnumber, String time)updateUserBook(bookUser.getName(), bookUser.getBname(), bookUser.getBnumber(), bookUser.getTime());//
            return true;
        }
        else {
            return false;
        }
    }
    public boolean delettNews(BookUser bookUser) {
        System.out.println(bookUser.toString()+" delet");
        if (bookUserRepository.findAllByNameAndBname(bookUser.getName(), bookUser.getBname())!=null) {

            System.out.println(bookUser.toString()+"service");
           // bookUserRepository.delete(bookUser);
            bookUserRepository.deleteUserBook(bookUser.getName(), bookUser.getBname());
            // String name, String bname, int bnumber, String time)updateUserBook(bookUser.getName(), bookUser.getBname(), bookUser.getBnumber(), bookUser.getTime());//
            return true;
        }
        else {
            return false;
        }
    }
    public  boolean vertiy(String Bname,String name){
        boolean flag =false;
        if(bookUserRepository.findAllByBnameAndName(Bname, name).isEmpty()){
            flag=true;
        }
        return flag;
    }
    public   List  showAllBookUer(String name){
        List<BookUser> bookUsers = bookUserRepository.findAllByName(name);
        return bookUsers;
    }

}
