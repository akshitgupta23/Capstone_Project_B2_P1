package com.wf.Capstope_project.Entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table
public class Account {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int account_no;

    @Column
    private String customer_no;


    @Column
    private int branch;

    @Column
    private int opening_balance;

    @Column
    private Date opening_date;

    @Column
    private String account_type;

    @Column
    private String account_status;

    public Account(){

    }
    public Account(int account_no, String customer_no, int branch, int opening_balance, Date opening_date, String account_type, String account_status) {
        this.account_no = account_no;
        this.customer_no = customer_no;
        this.branch = branch;
        this.opening_balance = opening_balance;
        this.opening_date = opening_date;
        this.account_type = account_type;
        this.account_status = account_status;
    }

    public int getAccount_no() {
        return account_no;
    }

    public void setAccount_no(int account_no) {
        this.account_no = account_no;
    }

    public String getCustomer_no() {
        return customer_no;
    }

    public void setCustomer_no(String customer_no) {
        this.customer_no = customer_no;
    }

    public int getBranch() {
        return branch;
    }

    public void setBranch(int branch) {
        this.branch = branch;
    }

    public int getOpening_balance() {
        return opening_balance;
    }

    public void setOpening_balance(int opening_balance) {
        this.opening_balance = opening_balance;
    }

    public Date getOpening_date() {
        return opening_date;
    }

    public void setOpening_date(Date opening_date) {
        this.opening_date = opening_date;
    }

    public String getAccount_type() {
        return account_type;
    }

    public void setAccount_type(String account_type) {
        this.account_type = account_type;
    }

    public String getAccount_status() {
        return account_status;
    }

    public void setAccount_status(String account_status) {
        this.account_status = account_status;
    }
}package com.wf.Capstope_project.Entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table
public class Account {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int account_no;

    @Column
    private String customer_no;


    @Column
    private int branch;

    @Column
    private int opening_balance;

    @Column
    private Date opening_date;

    @Column
    private String account_type;

    @Column
    private String account_status;

    public Account(){

    }
    public Account(int account_no, String customer_no, int branch, int opening_balance, Date opening_date, String account_type, String account_status) {
        this.account_no = account_no;
        this.customer_no = customer_no;
        this.branch = branch;
        this.opening_balance = opening_balance;
        this.opening_date = opening_date;
        this.account_type = account_type;
        this.account_status = account_status;
    }

    public int getAccount_no() {
        return account_no;
    }

    public void setAccount_no(int account_no) {
        this.account_no = account_no;
    }

    public String getCustomer_no() {
        return customer_no;
    }

    public void setCustomer_no(String customer_no) {
        this.customer_no = customer_no;
    }

    public int getBranch() {
        return branch;
    }

    public void setBranch(int branch) {
        this.branch = branch;
    }

    public int getOpening_balance() {
        return opening_balance;
    }

    public void setOpening_balance(int opening_balance) {
        this.opening_balance = opening_balance;
    }

    public Date getOpening_date() {
        return opening_date;
    }

    public void setOpening_date(Date opening_date) {
        this.opening_date = opening_date;
    }

    public String getAccount_type() {
        return account_type;
    }

    public void setAccount_type(String account_type) {
        this.account_type = account_type;
    }

    public String getAccount_status() {
        return account_status;
    }

    public void setAccount_status(String account_status) {
        this.account_status = account_status;
    }
}
