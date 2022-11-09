package com.wf.Capstope_project.Service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.wf.Capstope_project.Dao.AdminDao;
import com.wf.Capstope_project.Entity.Admin;
import com.wf.Capstope_project.Response.MessageResponse;
import com.wf.Capstope_project.Service.AdminService;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class AdminServiceTest {

    @InjectMocks
    AdminService adminService;

    @Mock
    AdminDao dao;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void displayAllAdmin()
    {
        List<Admin> list = new ArrayList<Admin>();
        Admin empOne = new Admin("John", "John");
        Admin empTwo = new Admin("Alex", "kolenchiski");
        Admin empThree = new Admin("Steve", "Waugh");

        list.add(empOne);
        list.add(empTwo);
        list.add(empThree);

        when(dao.findAll()).thenReturn(list);

        //test
        List<Admin> empList = adminService.displayAllAdmin();

        assertEquals(3, empList.size());
        verify(dao, times(1)).findAll();
    }

    @Test
    public void login()
    {
        when(dao.findById("Peter")).thenReturn(Optional.of(new Admin("Peter", "123")));

        assertEquals(true, adminService.login(new Admin("Peter", "123")));
    }

}
