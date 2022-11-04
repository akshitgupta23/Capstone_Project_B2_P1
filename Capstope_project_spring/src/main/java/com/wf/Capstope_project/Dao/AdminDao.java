package com.wf.Capstope_project.Dao;

import com.wf.Capstope_project.Entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.CrudMethodMetadata;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdminDao extends JpaRepository<Admin, String> {
    Optional<Admin> findById(String username);
}
