package com.bookmanage.demo.control;


import com.bookmanage.demo.Repository.BookRepository;
import com.bookmanage.demo.Repository.BookUserRepository;
import com.bookmanage.demo.dao.Book;
import com.bookmanage.demo.dao.BookUser;
import com.bookmanage.demo.service.BookService;
import com.bookmanage.demo.service.BookUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@EnableAutoConfiguration
public class BookControl {
    @Autowired(required = true)
    private BookService bookService;
    @Autowired(required = true)
    private BookRepository bookRepository;
    @Autowired(required = true)
    private BookUserService bookUserService;
    @Autowired(required = true)
    private BookUserRepository bookUserRepository;
    /**
            返回全部书籍
     */
    @RequestMapping("/allbook")
   String allbook(Model model) {
        List books = new ArrayList();
        for ( Book book : bookRepository.findAll()){
            books.add(book);
           // System.out.println(book.toString());
        }

        model.addAttribute("books",books);
        return "allbook";
    }
//    @RequestMapping("/index")
//    String index(){
//        System.out.println("index 测试");
//        return "index";
//    }
    @RequestMapping("/search")
    String search(){
        System.out.println("search 测试");
        return "search";
    }
    @RequestMapping("/searchBook")
    String searchBook(Book book,Model model){
        //Book book1 = bookService.searchBook(book.getBname());
        List book1 = new ArrayList();
        for(Object book2 : bookService.searchBook(book.getBname())){
            book2 = (Book)book2;
            book1.add(book2);
            System.out.println(book2);
        }
        model.addAttribute("searbook",book1);

        return "search";
    }

    /**
     *
     * 添加书籍
     */
    @RequestMapping("/addbook")
    String addbook(){
        //System.out.println("sear 测试");
        return "addbook";
    }
    @RequestMapping("/addbookForm")
    String addbookForm(Book book, HttpSession session,Model model){

         String user =(String)session.getAttribute("name");
         book.setPublisher(user);
          if (bookService.addbook(book)){
              return "allbook";
          }
         // bookRepository.save(book);
        else {
             model.addAttribute("mes","存在相同的书目请重新添加");
              return "meserror";
          }

    }
    /**
     *
     * 借书
     */
    @RequestMapping("/borrow")
    String borrow(){
        //System.out.println("sear 测试");
        return "borrow";
    }
    @RequestMapping("/borrowbook")
    String borrowbook(Book book, HttpSession session,Model model) {
        String user = (String) session.getAttribute("name");

        BookUser bookUser = new BookUser(user, book.getBname(), 1);
        bookUser.setName(user);
        //System.out.println(book.toString()+"bowrrow 测试");
        if (bookUserService.vertiy(bookUser.getBname(), bookUser.getName())) {
            if (bookService.subtractNumber(book) == 1) {


                System.out.println(bookUser.toString() + "bow ");

                boolean flag = bookUserService.insertNews(bookUser);
                System.out.println(flag + "借书成功");
                model.addAttribute("mes", "借阅书籍成功");
                return "success";

            }
        } else {
            model.addAttribute("mes", "借阅书目错误请重新挑选");
            return "meserror";
        }
        return null;
    }




        /**
         *  recover
         *  还书
         */
        @RequestMapping("/recover")
        String recover(){
            //System.out.println("sear 测试");
            return "recover";
        }
        @RequestMapping("/recoverbook")
    String recoverbook(Book book, HttpSession session,Model model) {
            if (bookService.addNumber(book) == 1) {
                String user = (String) session.getAttribute("name");
                BookUser bookUser = new BookUser(user, book.getBname(), 1);
                bookUser.setName(user);

                System.out.println(bookUser.toString() + "return book");
                boolean flag = bookUserService.delettNews(bookUser);
                System.out.println(flag + "还书");
                model.addAttribute("mes", "还书籍成功");
                return "success";
            } else {
                model.addAttribute("mes", "还书目错误(每个人只能借阅相同书籍一本)请重新还 或者联系管理员");
                return "meserror";

            }
        }

    @RequestMapping("/person")
    String person(Model model,HttpSession session) {

            String name = (String) session.getAttribute("name");
            String account =(String)session.getAttribute("account");
            if(account.length()>4) {
                List bookUsers = new ArrayList();
                for (Object bookU : bookUserService.showAllBookUer(name)) {
                    bookU = (BookUser) bookU;
                    bookUsers.add(bookU);
                    // System.out.println(book.toString());
                }

                model.addAttribute("bookuser", bookUsers);
            }
            else {

                    List bookUsers = new ArrayList();
                    for (Object bookU : bookUserRepository.findAll()) {
                        bookU = (BookUser) bookU;
                        bookUsers.add(bookU);
                        // System.out.println(book.toString());
                    }

                    model.addAttribute("bookuser", bookUsers);
            }

            return "person";
        }
    @RequestMapping("/recommend")
    String recommend(Model model,HttpSession session){
        String name = (String) session.getAttribute("name");
        List bookUsers = new ArrayList();
        String bookName = null;
        for (Object bookU : bookUserService.showAllBookUer(name)) {
            bookU = (BookUser) bookU;
            bookName = ((BookUser) bookU).getBname();
            break;
        }
        List book = new ArrayList();
        for(Object book2 : bookService.searchBook(bookName)){
            book2 = (Book)book2;
            book.add(book2);
            System.out.println(book2);
        }
        model.addAttribute("recommentbook",book);

            return "recommend";
    }
}
