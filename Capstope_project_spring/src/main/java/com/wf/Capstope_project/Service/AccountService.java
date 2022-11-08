package com.wf.Capstope_project.Service;

import com.wf.Capstope_project.Dao.AccountDao;
import com.wf.Capstope_project.Dao.BranchDao;
import com.wf.Capstope_project.Dao.CustomerDao;
import com.wf.Capstope_project.Entity.Account;
import com.wf.Capstope_project.Entity.Branch;
import com.wf.Capstope_project.Entity.Customer;
import com.wf.Capstope_project.Response.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    AccountDao accountDao;

    @Autowired
    CustomerDao customerDao;

    @Autowired
    BranchDao branchDao;

    public MessageResponse create(Account account) {
        try{
            if(account!=null){
                if(account.getAccountType().equalsIgnoreCase("savings")||account.getAccountType().equalsIgnoreCase("current"))
                {
                    String customerNo=account.getCustomer().getCustomerNo();
                    Optional<Customer> user = customerDao.findById(customerNo);
                    Optional<Branch> branch = branchDao.findById(account.getBranch().getBranchId());
                    if(user.isPresent() && branch.isPresent())
                    {
                        accountDao.save(account);
                        return new MessageResponse(true, 0, "Created successfully");
                    }
                    else if(branch.isPresent())
                    {
                        return new MessageResponse(false, 1, "Creation unsuccessful! Invalid customer number.");
                    }
                    else {
                        return new MessageResponse(false, 2, "Creation unsuccessful! Invalid Branch Id.");
                    }
                }
                else
                    return new MessageResponse(false, 3, "Creation unsuccessful! Invalid account type.");
            }
            return new MessageResponse(false, 4, "Creation unsuccessful!");
        }
        catch (DataAccessException e){
            e.printStackTrace();
            return new MessageResponse(false, 5, "Error while saving the data.");
        }
        catch (Exception e){
            e.printStackTrace();
            return new MessageResponse(false, 6, "Error while saving the data.");
        }
    }
}
