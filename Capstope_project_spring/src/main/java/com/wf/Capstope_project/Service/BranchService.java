package com.wf.Capstope_project.Service;

import com.wf.Capstope_project.Dao.BranchDao;
import com.wf.Capstope_project.Entity.Branch;
import com.wf.Capstope_project.Response.BranchRegistrationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class BranchService {

    @Autowired
    BranchDao branchDao;

    public BranchRegistrationResponse branchRegistration(Branch branch){
        try{
            if(branch!=null){
                if(branch.getBranch_id()!= null && branch.getBranch_address()!=null && branch.getBranch_name()!=null){
                    Optional<Branch> branch1 = branchDao.findById(branch.getBranch_id());
                    if(branch1.isPresent()){
                        return new BranchRegistrationResponse(false, 0, "Branch Id already exists");
                    }
                    else {
                        branchDao.save(branch);
                        return new BranchRegistrationResponse(true, 1, "New Branch created");
                    }
                }
                else{

                    return new BranchRegistrationResponse(false, 2, "Some of the Branch details are not present");

                }

            }
            else {
                return new BranchRegistrationResponse(false, 3, "Branch is empty");
            }

        }
        catch (DataAccessException e){
            e.printStackTrace();
            return new BranchRegistrationResponse(false, 4, "Error while saving in the database");
        }

    }

    //public BranchRegistrationResponse branchDeletion()
}
