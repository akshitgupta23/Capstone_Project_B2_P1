package com.wf.Capstope_project.Controller;

import com.wf.Capstope_project.Entity.Account;
import com.wf.Capstope_project.Service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    AccountService accountService;

    @PostMapping("/create")
    public ResponseEntity<Object> create(@RequestBody Account account){
        int status =accountService.create(account);
        if(status == 0)
            return ResponseEntity.status(HttpStatus.CREATED).body("Created successfully");
        else if(status ==1)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Creation unsuccessful! Invalid customer number.");
        else if(status ==2 )
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Creation unsuccessful! Invalid account type.");
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Creation unsuccessful!");

    }

}
