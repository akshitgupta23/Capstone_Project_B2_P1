package com.wf.Capstope_project.Service;

import com.wf.Capstope_project.Dao.AdminDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    AdminDao adminDao;
}
