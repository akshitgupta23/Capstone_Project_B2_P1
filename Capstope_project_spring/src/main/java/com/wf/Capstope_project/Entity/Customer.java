package com.wf.Capstope_project.Entity;

import net.bytebuddy.build.ToStringPlugin;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table
public class Customer {
    @Id
    private String account_no;

    @Column
    private String customer_no;

    @Column
    private String branch_id;

    @Column
    private int opening_balance;

    @Column
    private Date opening_date;

    @Column
    private String account_type;

    @Column
    private String account_status;

    public Customer(String account_no, String customer_no, String branch_id, int opening_balance, Date opening_date, String account_type, String account_status) {
        this.account_no = account_no;
        this.customer_no = customer_no;
        this.branch_id = branch_id;
        this.opening_balance = opening_balance;
        this.opening_date = opening_date;
        this.account_type = account_type;
        this.account_status = account_status;
    }

    public String getAccount_no() {
        return account_no;
    }

    public void setAccount_no(String account_no) {
        this.account_no = account_no;
    }

    public String getCustomer_no() {
        return customer_no;
    }

    public void setCustomer_no(String customer_no) {
        this.customer_no = customer_no;
    }

    public String getBranch_id() {
        return branch_id;
    }

    public void setBranch_id(String branch_id) {
        this.branch_id = branch_id;
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
