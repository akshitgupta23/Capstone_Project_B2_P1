package com.wf.Capstope_project.Service;

import com.wf.Capstope_project.Dao.AccountDao;
import com.wf.Capstope_project.Dao.CustomerDao;
import com.wf.Capstope_project.Entity.Customer;
import com.wf.Capstope_project.Response.MessageResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.dao.DataAccessException;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CustomerServiceTest {

    @Mock
    AccountDao accountDao;

    @Mock
    CustomerDao customerDao;

    @InjectMocks
    @Spy
    CustomerService customerService;

    @Test
    public void isPresentTest(){
        String customerNo = "123";

        doReturn(Optional.empty()).when(customerDao).findById(anyString());
        assertEquals(customerService.isPresent(customerNo), false);
    }

    @Test
    public void createCustomerTestCond1(){
        Customer customer = new Customer();
        customer.setCustomerNo("123");

        doReturn(true).when(customerService).isPresent(anyString());
        MessageResponse messageResponse = new MessageResponse(false, 0, "Unsuccessful! Customer Number already exists.");

        assertEquals(customerService.createCustomer(customer).equals(messageResponse), true);
    }

    @Test
    public void createCustomerTestCond2(){
        Customer customer = new Customer();
        customer.setCustomerNo("123");
        customer.setCustomerCity("Blr");
        customer.setCustomerContactNo("999");
        customer.setDob(new Date(2001, 5, 1));
        customer.setOccupation("TestOccupation");
        customer.setFirstName("Test");
        customer.setMiddleName("Test");
        customer.setLastName("Test");

        doReturn(false).when(customerService).isPresent(anyString());

        doReturn(customer).when(customerDao).save(any(Customer.class));
        MessageResponse messageResponse = new MessageResponse(true, 1, "Successful! ");

        assertEquals(customerService.createCustomer(customer).equals(messageResponse), true);
    }

    @Test
    public void createCustomerTestCond3(){
        Customer customer = new Customer();
        customer.setCustomerNo("123");
        customer.setCustomerContactNo("999");
        customer.setDob(new Date(2001, 5, 1));
        customer.setOccupation("TestOccupation");
        customer.setFirstName("Test");
        customer.setMiddleName("Test");
        customer.setLastName("Test");

        doReturn(false).when(customerService).isPresent(anyString());
        MessageResponse messageResponse = new MessageResponse(false, 2, "Unsuccessful! Invalid Customer details.");

        assertEquals(customerService.createCustomer(customer).equals(messageResponse), true);
    }

    @Test
    public void createCustomerTestCond4(){
        Customer customer = null;

        MessageResponse messageResponse = new MessageResponse(false, 3, "Unsuccessful! Non Empty Customer required");

        assertEquals(customerService.createCustomer(customer).equals(messageResponse), true);
    }

    @Test
    public void createCustomerTestEx1(){
        Customer customer = new Customer();
        customer.setCustomerNo("123");
        customer.setCustomerCity("Blr");
        customer.setCustomerContactNo("999");
        customer.setDob(new Date(2001, 5, 1));
        customer.setOccupation("TestOccupation");
        customer.setFirstName("Test");
        customer.setMiddleName("Test");
        customer.setLastName("Test");

        doThrow(new DataAccessException("Test Reason") {
        }).when(customerService).isPresent(anyString());

        MessageResponse messageResponse = new MessageResponse(false, 4, "Unsuccessful! Error while saving.");

        assertEquals(customerService.createCustomer(customer).equals(messageResponse), true);
    }

    @Test
    public void createCustomerTestEx2(){
        Customer customer = new Customer();
        customer.setCustomerNo("123");
        customer.setCustomerCity("Blr");
        customer.setCustomerContactNo("999");
        customer.setDob(new Date(2001, 5, 1));
        customer.setOccupation("TestOccupation");
        customer.setFirstName("Test");
        customer.setMiddleName("Test");
        customer.setLastName("Test");

        doThrow(new RuntimeException()).when(customerService).isPresent(anyString());
        MessageResponse messageResponse = new MessageResponse(false, 5, "Unsuccessful! Error while saving.");

        assertEquals(customerService.createCustomer(customer).equals(messageResponse), true);
    }

    @Test
    public void displayAllCustomer(){
        List<Customer> customerList = new ArrayList<>();
        doReturn(customerList).when(customerDao).findAll();

        assertEquals(customerService.displayAllCustomer(), customerList);
    }
}
