package com.wf.Capstope_project.Service;

import com.wf.Capstope_project.Dao.AdminDao;
import com.wf.Capstope_project.Entity.Admin;
import com.wf.Capstope_project.Response.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService implements IAdminService{

    @Autowired
    AdminDao adminDao;

    @Override
    public boolean login(Admin UIUser){
        Optional<Admin> user = adminDao.findById(UIUser.getUsername());
        return user.isPresent() && user.get().getPassword().equals(UIUser.getPassword());
    }

    @Override
    public MessageResponse createAdmin(Admin user){
        try{
            if(user!=null){
                if(user.getPassword()!=null && user.getUsername()!=null){
                    Optional<Admin> admin= adminDao.findById(user.getUsername());
                    if(admin.isPresent()){
                        return new MessageResponse(false, 0, "Unsuccessful! Admin username already exists.");
                    }
                    else{
                        adminDao.save(user);
                        return new MessageResponse(true, 1, "Successful! New Admin created.");
                    }
                }
                else{
                    return new MessageResponse(false, 2, "Unsuccessful! Some details for Admin missing.");
                }
            }
            else {
                return new MessageResponse(false, 3, "Unsuccessful! Non empty Admin required.");
            }
        }
        catch (DataAccessException e){

            e.printStackTrace();
            return new MessageResponse(false, 4, "Unsuccessful! Error while saving.");

        }
        catch (Exception e){

            e.printStackTrace();
            return new MessageResponse(false, 5, "Unsuccessful! Error while saving.");
        }
    }

    @Override
    public List<Admin> displayAllAdmin(){
        return adminDao.findAll();
    }
}
