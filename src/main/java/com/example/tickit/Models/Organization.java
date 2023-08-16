package com.example.tickit.Models;

public class Organization {
    private int organization_id;
    private String organizationName;

    public int getOrganization_id() {
        return organization_id;
    }

    public void setOrganization_id(int organization_id) {
        this.organization_id = organization_id;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getOrganizationLocation() {
        return organizationLocation;
    }

    public void setOrganizationLocation(String organizationLocation) {
        this.organizationLocation = organizationLocation;
    }

    private String organizationLocation;

    public Organization(int organization_id, String organizationName, String organizationLocation) {
        this.organization_id = organization_id;
        this.organizationName = organizationName;
        this.organizationLocation = organizationLocation;
    }
}
