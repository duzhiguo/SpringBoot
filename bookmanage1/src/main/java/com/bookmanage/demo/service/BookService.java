package com.bookmanage.demo.service;

import com.bookmanage.demo.Repository.BookRepository;
import com.bookmanage.demo.dao.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class BookService {
    @Autowired(required = true)
    private BookRepository bookRepository;
    public   List  showAllBook(){
        List<Book> bookByBname = bookRepository.findAll();
        return bookByBname;
    }
    public List searchBook( String bname) {
        List<Book> books =  bookRepository.findBookByBname(bname);

        return  books;
    }
    public boolean addbook(Book book){
       if (bookRepository.findAllByBnameAndAndPublisherAndAndBno(book.getBname(),book.getPublisher(),book.getBno()).isEmpty())
       {
           SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");//设置日期格式
           String time = df.format(new Date());
           book.setBtime(time);
           bookRepository.save(book);

           return true;
       }
       else {
           return false;
       }

    }

    /**
     * 增加一个
     * @param book
     * @return
     */
    public int addNumber(Book book){

        int a = bookRepository.updateAddBookNum(book.getPublisher(),book.getBname(),book.getBno());
        return a;
    }
    public int subtractNumber(Book book){

        int a = bookRepository.updateSubtractBookNum(book.getPublisher(),book.getBname(),book.getBno());
        return a;
    }
}
