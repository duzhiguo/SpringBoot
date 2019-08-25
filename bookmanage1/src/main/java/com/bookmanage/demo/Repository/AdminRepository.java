package com.bookmanage.demo.Repository;

import com.bookmanage.demo.dao.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
    public List<Admin> findByAccountAndPassWord(String account, String password);

    public Admin findByAccount(String account);
}
