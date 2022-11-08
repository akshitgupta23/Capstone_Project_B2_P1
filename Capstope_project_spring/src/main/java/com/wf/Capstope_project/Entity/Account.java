package com.wf.Capstope_project.Entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "account_master")
public class Account {
    @Id
    @Column(name = "acount_no")
    private String accountNo;

    @ManyToOne(optional = false)
    @JoinColumn(name = "customer_number")
    private Customer customer;

    @ManyToOne(optional = false)
    @JoinColumn(name = "branch_id")
    private Branch branch;

    @Column(name = "opening_balance")
    private int openingBalance;

    @Column(name = "opening_date")
    private Date openingDate;

    @Column(name = "account_type")
    private String accountType;

    @Column(name = "account_status")
    private String accountStatus;

    public Account(){

    }
    public Account(String accountNo, Customer customer, Branch branch, int openingBalance, Date openingDate, String accountType, String accountStatus) {
        this.accountNo = accountNo;
        this.customer = customer;
        this.branch = branch;
        this.openingBalance = openingBalance;
        this.openingDate = openingDate;
        this.accountType = accountType;
        this.accountStatus = accountStatus;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String account_no) {
        this.accountNo = account_no;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    public int getOpeningBalance() {
        return openingBalance;
    }

    public void setOpeningBalance(int opening_balance) {
        this.openingBalance = opening_balance;
    }

    public Date getOpeningDate() {
        return openingDate;
    }

    public void setOpeningDate(Date opening_date) {
        this.openingDate = opening_date;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String account_type) {
        this.accountType = account_type;
    }

    public String getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(String account_status) {
        this.accountStatus = account_status;
    }
}

