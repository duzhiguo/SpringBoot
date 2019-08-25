package com.bookmanage.demo.Repository;

import com.bookmanage.demo.dao.BookUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface BookUserRepository extends JpaRepository<BookUser, Long> {


    public List<BookUser> findAllByNameAndBname(String name, String Bname);

    @Modifying
    @Transactional
    @Query(value = "insert into  bookuser(name,bname,bnumber,time) values (?1,?2,?3,?4)", nativeQuery = true)
    public int updateUserBook(String name, String bname, int bnumber, String time);

    @Modifying
    @Transactional
    @Query(value = "delete  from bookuser where name =?1 and bname =?2", nativeQuery = true)
    public int deleteUserBook(String name, String bname);

    public List<BookUser> findAllByBnameAndName(String Bname, String name);

    public List<BookUser> findAllByName(String name);

}
