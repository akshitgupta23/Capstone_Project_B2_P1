package com.wf.Capstope_project.Service;

import com.wf.Capstope_project.Dao.AccountDao;
import com.wf.Capstope_project.Dao.CustomerDao;
import com.wf.Capstope_project.Entity.Customer;
import com.wf.Capstope_project.Response.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService implements ICustomerService{
    @Autowired
    AccountDao accountDao;
    @Autowired
    CustomerDao customerDao;

    @Override
    public boolean isPresent(String customerNo) {
        Optional<Customer> user = customerDao.findById(customerNo);
        return user.isPresent();
    }

    @Override
    public MessageResponse createCustomer(Customer customer){
        try{
            if(customer!=null){
                if(isPresent(customer.getCustomerNo())){
                    return new MessageResponse(false, 0, "Unsuccessful! Customer Number already exists.");
                }
                else {
                    if(customer.isValid()){
                        customerDao.save(customer);
                        return new MessageResponse(true, 1, "Successful! ");
                    }
                    else {
                        return new MessageResponse(false, 2, "Unsuccessful! Invalid Customer details.");
                    }
                }
            }
            else {
                return new MessageResponse(false, 3, "Unsuccessful! Non Empty Customer required");
            }
        }
        catch (DataAccessException e){

            e.printStackTrace();
            return new MessageResponse(false, 4, "Unsuccessful! Error while saving.");

        }
        catch (Exception e){

            e.printStackTrace();
            return new MessageResponse(false, 5, "Unsuccessful! Error while saving.");

        }
    }

    @Override
    public List<Customer> displayAllCustomer(){
        return customerDao.findAll();
    }
}
