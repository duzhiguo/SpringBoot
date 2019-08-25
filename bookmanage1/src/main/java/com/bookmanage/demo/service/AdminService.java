package com.bookmanage.demo.service;

import com.bookmanage.demo.Repository.AdminRepository;
import com.bookmanage.demo.dao.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    @Autowired(required = true)
    private AdminRepository adminRepository;
    public boolean verifyAdmin(Admin admin) {

        if (adminRepository.findByAccountAndPassWord(admin.getAccount(), admin.getPassWord()).isEmpty()) {
            return false;
        } else {
            return true;
        }
    }
    public  Admin  selectUserByAccount(String account){
        Admin  user = new Admin();
        user = adminRepository.findByAccount(account);
        return user;
    }
}
