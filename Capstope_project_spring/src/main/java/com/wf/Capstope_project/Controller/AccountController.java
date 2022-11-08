package com.wf.Capstope_project.Controller;

import com.wf.Capstope_project.Entity.Account;
import com.wf.Capstope_project.Response.MessageResponse;
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
    public ResponseEntity<MessageResponse> create(@RequestBody Account account){
        return new ResponseEntity<>(accountService.create(account), HttpStatus.OK);
        /*int status =accountService.create(account);
        if(status == 0)
            return ResponseEntity.status(HttpStatus.CREATED).body("");
        else if(status ==1)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("");
        else if(status ==2 )
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("");
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("");*/

    }

}
