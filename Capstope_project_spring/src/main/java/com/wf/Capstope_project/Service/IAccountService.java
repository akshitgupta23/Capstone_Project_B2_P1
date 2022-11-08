package com.wf.Capstope_project.Service;

import com.wf.Capstope_project.Entity.Account;
import com.wf.Capstope_project.Response.MessageResponse;

import java.util.List;

public interface IAccountService {

    MessageResponse create(Account account);
    List<Account> displayAllAccounts();
}
