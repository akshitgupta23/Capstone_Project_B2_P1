package com.wf.Capstope_project.Service;

import com.wf.Capstope_project.Entity.Branch;
import com.wf.Capstope_project.Response.MessageResponse;

import java.util.List;

public interface IBranchService {
    MessageResponse branchRegistration(Branch branch);
    MessageResponse deleteBranch(Branch branch);
    List<Branch> displayAllBranches();
}
