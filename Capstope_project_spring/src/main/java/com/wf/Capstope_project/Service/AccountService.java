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
        if(account.getAccountType().equalsIgnoreCase("savings")||account.getAccountType().equalsIgnoreCase("current"))
        {
            String customerNo=account.getCustomer().getCustomerNo();
            Optional<Customer> user = customerDao.findById(customerNo);
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
