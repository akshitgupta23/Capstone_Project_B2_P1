package com.wf.Capstope_project.Controller;

import com.wf.Capstope_project.Entity.Account;
import com.wf.Capstope_project.Entity.Admin;
import com.wf.Capstope_project.Service.AccountService;
import com.wf.Capstope_project.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    AccountService accountService;

    @GetMapping("/create")
    public ResponseEntity<Object> create(@RequestBody Account account){
        if(accountService.create(account)){
            return ResponseEntity.status(HttpStatus.CREATED).body("Created successfully");
        }
        return ResponseEntity.status(HttpStatus.NOT_MODIFIED).body("Creation unsuccessful!");
    }

}
