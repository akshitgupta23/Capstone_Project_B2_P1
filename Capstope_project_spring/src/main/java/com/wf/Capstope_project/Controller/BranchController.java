package com.wf.Capstope_project.Controller;

import com.wf.Capstope_project.Entity.Branch;
import com.wf.Capstope_project.Response.MessageResponse;
import com.wf.Capstope_project.Service.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/branch")
@CrossOrigin(origins = "http://localhost:3000")
public class BranchController {

    @Autowired
    BranchService branchService;

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping(value = "/registration", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MessageResponse> branchRegistration(@RequestBody Branch branch){

        return new ResponseEntity<>(branchService.branchRegistration(branch), HttpStatus.OK);
    }

    @PostMapping(value = "/displayAll")
    public ResponseEntity<List<Branch>> displayAllBranches(){
        return new ResponseEntity<>(branchService.displayAllBranches(), HttpStatus.OK);
    }

    @PostMapping(value = "/deleteBranch",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MessageResponse> deleteBranch( @RequestBody Branch branch){
        return new ResponseEntity<>(branchService.deleteBranch(branch), HttpStatus.OK);
    }

}
