package com.wf.Capstope_project.Controller;

import com.wf.Capstope_project.Entity.Account;
import com.wf.Capstope_project.Response.MessageResponse;
import com.wf.Capstope_project.Service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/account")
public class AccountController {
    @Autowired
    AccountService accountService;

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/create")
    public ResponseEntity<MessageResponse> create(@RequestBody Account account){
        return new ResponseEntity<>(accountService.create(account), HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/displayAll")
    public ResponseEntity<List<Account>> displayAll(){
        return new ResponseEntity<>(accountService.displayAllAccounts(), HttpStatus.OK);
    }

}
