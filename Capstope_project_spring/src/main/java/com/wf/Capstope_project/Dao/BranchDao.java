package com.wf.Capstope_project.Dao;

import com.wf.Capstope_project.Entity.Branch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BranchDao extends JpaRepository<Branch, String> {

    List<Branch> findAll();

    void delete(Branch branch);

    Branch save(Branch branch);

    Optional<Branch> findById(String branchId);
}
