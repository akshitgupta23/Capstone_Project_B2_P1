package com.wf.Capstope_project.Controller;

import com.wf.Capstope_project.Entity.Customer;
import com.wf.Capstope_project.Response.MessageResponse;
import com.wf.Capstope_project.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/createCustomer")
    public ResponseEntity<MessageResponse> createCustomer(@RequestBody Customer customer){
        return new ResponseEntity<>(customerService.createCustomer(customer), HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/displayAll")
    public ResponseEntity<List<Customer>> displayAll(){
        return new ResponseEntity<>(customerService.displayAllCustomer(), HttpStatus.OK);
    }
}
