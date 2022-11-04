package com.wf.Capstope_project.Service;

import com.wf.Capstope_project.Dao.AdminDao;
import com.wf.Capstope_project.Entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdminService {

    @Autowired
    AdminDao adminDao;

    public boolean login(Admin UIUser){
        Optional<Admin> user = adminDao.findById(UIUser.getUser_id());
        if(user.isPresent() && user.get().getPassword().equals(UIUser.getPassword()))
        {
            return true;
        }
        return false;
    }
}
