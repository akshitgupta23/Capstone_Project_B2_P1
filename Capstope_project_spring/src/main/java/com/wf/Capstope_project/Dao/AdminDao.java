package com.wf.Capstope_project.Dao;

import com.wf.Capstope_project.Entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminDao extends JpaRepository<Admin, Long>{
    Admin findByUsernameAndPassword(String username, String password);
}
