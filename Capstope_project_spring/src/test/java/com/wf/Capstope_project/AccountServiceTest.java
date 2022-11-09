package com.wf.Capstope_project.Service;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
import java.util.Optional;

import com.wf.Capstope_project.Dao.BranchDao;
import com.wf.Capstope_project.Dao.CustomerDao;
import com.wf.Capstope_project.Entity.Branch;
import com.wf.Capstope_project.Entity.Customer;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.wf.Capstope_project.Dao.AccountDao;
import com.wf.Capstope_project.Entity.Account;
import com.wf.Capstope_project.Response.MessageResponse;
import com.wf.Capstope_project.Service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;

public class AccountServiceTest {

    @InjectMocks
    Account account;

    @Mock
    protected AccountService accountService;

    @Mock
    AccountDao accountDao;

    @Mock
    CustomerDao customerDao;

    @Mock
    BranchDao branchDao;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void displayAllAccountsTest()
    {
        List<Account> list = new ArrayList<Account>();

        Account empOne = new Account("1",new Customer("145","","","","","","",new Date(2000, 11, 21)),
                new Branch("1234","Chrompet","Chennai"),
                500,new Date(2000, 11, 21),"savings","active");
        Account empTwo = new Account("1",new Customer("145","","","","","","",new Date(2000, 11, 21)),
                new Branch("1234","Chrompet","Chennai"),
                500,new Date(2000, 11, 21),"savings","active");

        list.add(empOne);
        list.add(empTwo);

        when(accountService.displayAllAccounts()).thenReturn(list);

        //test
        List<Account> empList = accountService.displayAllAccounts();

        assertEquals(2, empList.size());
        verify(accountService, times(1)).displayAllAccounts();
    }

    @Test
    public void createTest()
    {
        Account acc = new Account("1",new Customer("145","","","","","","",new Date(2000, 11, 21)),
                new Branch("1234","Chrompet","Chennai"),
                500,new Date(2000, 11, 21),"savings","active");



        accountService.create(acc);
        assertThat(this.customerDao.findById(acc.getCustomer().getCustomerNo()).isPresent());
        assertThat(branchDao.findById(acc.getBranch().getBranchId()).isPresent());
        verify(accountService, times(1)).create(acc);
    }

}
