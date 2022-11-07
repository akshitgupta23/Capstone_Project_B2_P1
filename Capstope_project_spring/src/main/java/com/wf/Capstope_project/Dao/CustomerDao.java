package com.wf.Capstope_project.Dao;

import com.wf.Capstope_project.Entity.Branch;
import com.wf.Capstope_project.Entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerDao extends JpaRepository<Account, String> {

    List<Account> findAll();

    void delete(Account customer);

    Account save(Account customer);

    void deleteCustomersByBranch(Branch branch);




}
