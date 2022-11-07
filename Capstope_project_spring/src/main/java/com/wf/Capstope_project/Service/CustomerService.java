package com.wf.Capstope_project.Service;

import com.wf.Capstope_project.Dao.AccountDao;
import com.wf.Capstope_project.Dao.CustomerDao;
import com.wf.Capstope_project.Entity.Admin;
import com.wf.Capstope_project.Entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    AccountDao accountDao;
    static CustomerDao customerDao;

    public static boolean isPresent(String customer_no) {
        Optional<Customer> user = customerDao.findById(customer_no);
        if(user.isPresent())
        {
            return true;
        }
        return false;
    }
}
