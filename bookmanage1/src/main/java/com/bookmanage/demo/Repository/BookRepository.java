package com.bookmanage.demo.Repository;

import com.bookmanage.demo.dao.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    public List<Book> findBookByBname(String bname);

    public List<Book> findAllByBnameAndAndPublisherAndAndBno(String bname, String publisher, String bno);

    @Modifying
    @Transactional
    @Query(value = "update book set bnumber = bnumber+1 where publisher =?1 and bname =?2 and bno =?3", nativeQuery = true)
    public int updateAddBookNum(String publisher, String bname, String bno);

    @Modifying
    @Transactional
    @Query(value = "update book set bnumber = bnumber-1 where publisher =?1 and bname =?2 and bno =?3", nativeQuery = true)
    public int updateSubtractBookNum(String publisher, String bname, String bno);


}
