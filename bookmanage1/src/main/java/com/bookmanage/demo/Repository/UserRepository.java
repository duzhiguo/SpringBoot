package com.bookmanage.demo.Repository;

import com.bookmanage.demo.dao.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    public List<User> findByName(String name);

    public List<User> findByNameAndPassWord(String name, String password);

    public List<User> findByAccountAndPassWord(String account, String password);

    public User findByAccount(String account);



}
