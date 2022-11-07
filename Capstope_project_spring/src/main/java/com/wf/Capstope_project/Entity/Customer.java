package com.wf.Capstope_project.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table(name = "customer_master")
public class Customer {

    @Id
    @Column(name = "customer_no")
    private String customerNo;

    @Column
    private String firstName;

    @Column
    private String middleName;

    @Column
    private String lastName;

    @Column(name = "customer_city")
    private String customerCity;

    @Column(name = "customer_contact_no")
    private String customerContactNo;

    @Column
    private String occupation;

    @Column(name = "customer_date_of_birth")
    private Date dob;

    public Customer(){}

    public Customer(String customer_no, String firstName,
                    String middleName, String lastName,
                    String customerCity,
                    String customerContactNo,
                    String occupation,
                    Date dob) {
        this.customerNo = customerNo;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.customerCity = customerCity;
        this.customerContactNo = customerContactNo;
        this.occupation = occupation;
        this.dob = dob;
    }

    public String getCustomerNo() {
        return customerNo;
    }

    public void setCustomer_no(String customerNo) {
        this.customerNo = customerNo;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstname) {
        this.firstName = firstname;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middlename) {
        this.middleName = middlename;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastname) {
        this.lastName = lastname;
    }

    public String getCustomerCity() {
        return customerCity;
    }

    public void setCustomerCity(String customerCity) {
        this.customerCity = customerCity;
    }

    public String getCustomerContactNo() {
        return customerContactNo;
    }

    public void setCustomerContactNo(String customerContactNo) {
        this.customerContactNo = customerContactNo;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }
}
