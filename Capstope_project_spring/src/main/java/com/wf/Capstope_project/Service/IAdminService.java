package com.wf.Capstope_project.Service;

import com.wf.Capstope_project.Entity.Admin;
import com.wf.Capstope_project.Response.MessageResponse;

import java.util.List;

public interface IAdminService {
    boolean login(Admin UIUser);
    MessageResponse createAdmin(Admin user);
    List<Admin> displayAllAdmin();
}
