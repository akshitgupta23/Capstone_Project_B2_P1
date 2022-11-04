package com.wf.Capstope_project.Entity;

import javax.persistence.*;

@Entity
@Table
public class Branch {
    @Id
    private String branch_id;

    @Column
    private String branch_name;

    @Column
    private String branch_address;

    public Branch(){

    }

    public Branch(String branch_id, String branch_name, String branch_address) {
        this.branch_id = branch_id;
        this.branch_name = branch_name;
        this.branch_address = branch_address;
    }

    public String getBranch_id() {
        return branch_id;
    }

    public void setBranch_id(String branch_id) {
        this.branch_id = branch_id;
    }

    public String getBranch_name() {
        return branch_name;
    }

    public void setBranch_name(String branch_name) {
        this.branch_name = branch_name;
    }

    public String getBranch_address() {
        return branch_address;
    }

    public void setBranch_address(String branch_address) {
        this.branch_address = branch_address;
    }
}
