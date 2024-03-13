package com.example.insurance.model;

public class BranchResponse {
    private Long branchId;
    private String name;
    private String location;
    private String contactPerson;
    private String contactNumber;

    // Constructors, getters, and setters
    public BranchResponse(Long branchId, String name, String location, String contactPerson, String contactNumber) {
        this.branchId = branchId;
        this.name = name;
        this.location = location;
        this.contactPerson = contactPerson;
        this.contactNumber = contactNumber;
    }

    public Long getBranchId() {
        return branchId;
    }

    public void setBranchId(Long branchId) {
        this.branchId = branchId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }
}
