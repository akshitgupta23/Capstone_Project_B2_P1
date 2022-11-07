package com.wf.Capstope_project.Entity;

import javax.persistence.*;

@Entity
@Table(name = "branch_master")
public class Branch {
    @Id
    @Column(name = "branch_id")
    private String branchId;

    @Column(name = "branch_name")
    private String branchName;

    @Column(name = "branch_address")
    private String branchAddress;

    public Branch(){

    }

    public Branch(String branchId, String branchName, String branchAddress) {
        this.branchId = branchId;
        this.branchName = branchName;
        this.branchAddress = branchAddress;
    }

    public String getBranchId() {
        return branchId;
    }

    public void setBranchId(String branch_id) {
        this.branchId = branch_id;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branch_name) {
        this.branchName = branch_name;
    }

    public String getBranchAddress() {
        return branchAddress;
    }

    public void setBranchAddress(String branch_address) {
        this.branchAddress = branch_address;
    }
}
