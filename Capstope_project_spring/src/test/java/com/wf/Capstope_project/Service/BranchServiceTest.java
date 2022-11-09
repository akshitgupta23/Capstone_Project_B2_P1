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

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

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


    @Test(expected = Exception.class)
    public void branchRegistrationTestEx2(){

        Branch branch = new Branch("123", "TestName", "TestAddress");

        when(branchDao.findById(anyString())).thenThrow(any(Exception.class));

        MessageResponse messageResponse = new MessageResponse(false, 5, "Error while saving in the database");

        assertEquals(branchService.branchRegistration(branch), messageResponse);

    }


}
