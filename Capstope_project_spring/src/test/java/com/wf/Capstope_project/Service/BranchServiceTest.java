package com.wf.Capstope_project.Service;

import com.wf.Capstope_project.Dao.AccountDao;
import com.wf.Capstope_project.Dao.BranchDao;
import com.wf.Capstope_project.Entity.Branch;
import com.wf.Capstope_project.Response.MessageResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.dao.DataAccessException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class BranchServiceTest {

    @Mock
    BranchDao branchDao;

    @Mock
    AccountDao accountDao;

    @InjectMocks
    BranchService branchService;

    @Test
    public void branchRegistrationTestCond1(){

        Branch branch = new Branch("123", "TestName", "TestAddress");
        doReturn(Optional.of(branch)).when(branchDao).findById(anyString());

        MessageResponse messageResponse = new MessageResponse(false, 0, "Branch Id already exists");

        assertTrue(branchService.branchRegistration(branch).equals(messageResponse));
    }

    @Test
    public void branchRegistrationTestCond2(){

        Branch branch = new Branch("123", "TestName", "TestAddress");
        doReturn(Optional.empty()).when(branchDao).findById(anyString());

        when(branchDao.save(any(Branch.class))).thenReturn(branch);

        MessageResponse messageResponse = new MessageResponse(true, 1, "New Branch created");

        assertEquals(branchService.branchRegistration(branch).equals(messageResponse), true);
    }

    @Test
    public void branchRegistrationTestCond3(){

        Branch branch = new Branch("123", null, null);

        MessageResponse messageResponse = new MessageResponse(false, 2, "Some of the Branch details are not present");

        assertEquals(branchService.branchRegistration(branch).equals(messageResponse), true);
    }

    @Test
    public void branchRegistrationTestCond4(){

        MessageResponse messageResponse = new MessageResponse(false, 3, "Branch is empty");

        assertEquals(branchService.branchRegistration(null), messageResponse);
    }

    @Test
    public void branchRegistrationTestEx1(){

        Branch branch = new Branch("123", "TestName", "TestAddress");

        when(branchDao.findById(anyString())).thenThrow(new DataAccessException("Test Reason") {
        });

        MessageResponse messageResponse = new MessageResponse(false, 4, "Error while saving in the database");

        assertEquals(branchService.branchRegistration(branch).equals(messageResponse), true);

    }

    @Test
    public void branchRegistrationTestEx2(){

        Branch branch = new Branch("123", "TestName", "TestAddress");

        when(branchDao.findById(anyString())).thenThrow(new RuntimeException());

        MessageResponse messageResponse = new MessageResponse(false, 5, "Error while saving in the database");

        assertEquals(branchService.branchRegistration(branch).equals(messageResponse), true);

    }


    @Test
    public void deleteBranchTestCond1(){

        Branch branch = new Branch("123", "TestName", "TestAddress");
        doReturn(Optional.of(branch)).when(branchDao).findById(anyString());

        doNothing().when(branchDao).delete(any(Branch.class));
        doNothing().when(accountDao).deleteAccountsByBranch(any(Branch.class));

        MessageResponse messageResponse = new MessageResponse(true,0, "Deleted successfully");

        assertTrue(branchService.deleteBranch(branch).equals(messageResponse));
    }

    @Test
    public void deleteBranchTestCond2(){

        Branch branch = new Branch("123", "TestName", "TestAddress");
        doReturn(Optional.empty()).when(branchDao).findById(anyString());

        MessageResponse messageResponse = new MessageResponse(false, 1, "Branch not present in Database");

        assertEquals(branchService.deleteBranch(branch).equals(messageResponse), true);
    }

    @Test
    public void deleteBranchTestCond3(){

        Branch branch = new Branch(null, "TestBranch", null);

        MessageResponse messageResponse = new MessageResponse(false, 2, "BranchId required");

        assertEquals(branchService.deleteBranch(branch).equals(messageResponse), true);
    }

    @Test
    public void deleteBranchTestCond4(){

        MessageResponse messageResponse = new MessageResponse(false, 3, "Non Empty Branch required");

        assertEquals(branchService.deleteBranch(null), messageResponse);
    }

    @Test
    public void deleteBranchTestEx1(){

        Branch branch = new Branch("123", "TestName", "TestAddress");

        when(branchDao.findById(anyString())).thenThrow(new IllegalArgumentException());

        MessageResponse messageResponse = new MessageResponse(false, 4, "Error while deleting");

        assertEquals(branchService.deleteBranch(branch).equals(messageResponse), true);

    }

    @Test
    public void deleteBranchTestEx2(){

        Branch branch = new Branch("123", "TestName", "TestAddress");

        when(branchDao.findById(anyString())).thenThrow(new RuntimeException());

        MessageResponse messageResponse = new MessageResponse(false, 5, "Error while deleting");

        assertEquals(branchService.deleteBranch(branch).equals(messageResponse), true);

    }

    @Test
    public void displayAllBranchesTest(){
        List<Branch> branchList = new ArrayList<>();
        doReturn(branchList).when(branchDao).findAll();

        assertEquals(branchService.displayAllBranches(), branchList);
    }


}
