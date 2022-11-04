package com.wf.Capstope_project.Dao;

import com.wf.Capstope_project.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerDao extends JpaRepository<Customer, String> {

    List<Customer> findAll();

    void delete(Customer customer);

    Customer save(Customer customer);

    void deleteCustomersByBranch_Branch_id(String branch_id);




}
