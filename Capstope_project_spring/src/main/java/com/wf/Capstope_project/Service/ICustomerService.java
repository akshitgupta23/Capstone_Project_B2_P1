package com.wf.Capstope_project.Service;

import com.wf.Capstope_project.Entity.Customer;
import com.wf.Capstope_project.Response.MessageResponse;

import java.util.List;

public interface ICustomerService {
    boolean isPresent(String customerNo);
    MessageResponse createCustomer(Customer customer);
    List<Customer> displayAllCustomer();
}
