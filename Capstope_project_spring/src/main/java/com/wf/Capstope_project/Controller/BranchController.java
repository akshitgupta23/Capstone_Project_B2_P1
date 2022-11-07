package com.wf.Capstope_project.Controller;

import com.wf.Capstope_project.Entity.Branch;
import com.wf.Capstope_project.Response.BranchRegistrationResponse;
import com.wf.Capstope_project.Service.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping("/branch")
public class BranchController {

    @Autowired
    BranchService branchService;

    @PostMapping(value = "/registration", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BranchRegistrationResponse> branchRegistration(HttpServletRequest httpServletRequest, @RequestBody Branch branch){

        return new ResponseEntity<BranchRegistrationResponse>(branchService.branchRegistration(branch), HttpStatus.OK);
    }
}
