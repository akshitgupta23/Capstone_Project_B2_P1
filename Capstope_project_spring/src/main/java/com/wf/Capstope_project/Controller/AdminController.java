package com.wf.Capstope_project.Controller;

import com.wf.Capstope_project.Entity.Admin;
import com.wf.Capstope_project.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")

public class AdminController {

    @Autowired
    AdminService adminService;

    @GetMapping("/login")
    public ResponseEntity<Object> login(@RequestBody Admin user){
        System.out.print(user);
        if(adminService.login(user)){
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("Valid User");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Invalid User");
    }

}
