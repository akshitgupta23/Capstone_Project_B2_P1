package com.wf.Capstope_project.Service;

import com.wf.Capstope_project.Dao.AccountDao;
import com.wf.Capstope_project.Dao.BranchDao;
import com.wf.Capstope_project.Entity.Branch;
import com.wf.Capstope_project.Response.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BranchService implements IBranchService{

    @Autowired
    BranchDao branchDao;

    @Autowired
    AccountDao accountDao;

    @Override
    public MessageResponse branchRegistration(Branch branch){
        try{
            if(branch!=null){
                if(branch.getBranchId()!= null && branch.getBranchAddress()!=null && branch.getBranchName()!=null){
                    Optional<Branch> branch1 = branchDao.findById(branch.getBranchId());
                    if(branch1.isPresent()){
                        return new MessageResponse(false, 0, "Branch Id already exists");
                    }
                    else {
                        branchDao.save(branch);
                        return new MessageResponse(true, 1, "New Branch created");
                    }
                }
                else{

                    return new MessageResponse(false, 2, "Some of the Branch details are not present");

                }

            }
            else {
                return new MessageResponse(false, 3, "Branch is empty");
            }

        }
        catch (DataAccessException e){
            e.printStackTrace();
            return new MessageResponse(false, 4, "Error while saving in the database");
        }

        catch(Exception e){
            e.printStackTrace();
            return new MessageResponse(false, 5, "Error while saving in the database");
        }

    }

    @Override
    public MessageResponse deleteBranch(Branch branch){
        try{
            if(branch!=null){
                if(branch.getBranchId()!=null){
                    Optional<Branch> branch1 = branchDao.findById(branch.getBranchId());
                    if(branch1.isPresent()&& branch1.get().equals(branch)){
                        branchDao.delete(branch);
                        accountDao.deleteAccountsByBranch(branch);
                        return new MessageResponse(true,0, "Deleted successfully");
                    }
                    else {
                        return new MessageResponse(false, 1, "Branch not present in Database");
                    }
                }
                else {
                    return new MessageResponse(false, 2, "BranchId required");
                }
            }
            else {
                return new MessageResponse(false, 3, "Non Empty Branch required");
            }
        }
        catch (IllegalArgumentException e){

            return new MessageResponse(false, 4, "Error while deleting");

        }
        catch (Exception e){

            return new MessageResponse(false, 5, "Error while deleting");
        }

    }

    @Override
    public List<Branch> displayAllBranches(){
        return branchDao.findAll();
    }
}
