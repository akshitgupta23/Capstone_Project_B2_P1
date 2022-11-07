package com.wf.Capstope_project.Service;

import com.wf.Capstope_project.Dao.AccountDao;
import com.wf.Capstope_project.Dao.CustomerDao;
import com.wf.Capstope_project.Entity.Account;
import com.wf.Capstope_project.Entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    AccountDao accountDao;

    @Autowired
    CustomerDao customerDao;
    public int create(Account account) {
        if(account!=null){
        if(account.getAccount_type().equalsIgnoreCase("savings")||account.getAccount_type().equalsIgnoreCase("current"))
        {
            String customer_no=account.getCustomer_no();
            Optional<Customer> user = customerDao.findById(customer_no);
            if(user.isPresent())
            {
                account=accountDao.save(account);
                return 0;
            }
            else
            {
                return 1;
            }
        }
        else
            return 2;
        }
        return 3;
    }
}
