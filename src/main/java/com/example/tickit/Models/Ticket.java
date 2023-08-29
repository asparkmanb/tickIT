package com.example.tickit.Models;

public class Ticket {

    public Ticket(int ticketID, String user, String priority, String email, String title, String location, String category, String description, int organizationID, String assignedTo, String status) {
        this.ticketID = ticketID;
        this.user = user;
        this.priority = priority;
        this.email = email;
        this.title = title;
        this.location = location;
        this.category = category;
        this.description = description;
        this.organizationID = organizationID;
        this.assignedTo = assignedTo;
        this.status = status;
    }

    private int ticketID;
    private String user;
    private String priority;
    private String email;
    private String title;
    private String location;
    private String category;
    private String description;
    private int organizationID;
    private String assignedTo;
    private String status;

    public int getTicketID() {
        return ticketID;
    }

    public void setTicketID(int ticketID) {
        this.ticketID = ticketID;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getOrganizationID() {
        return organizationID;
    }

    public void setOrganizationID(int organizationID) {
        this.organizationID = organizationID;
    }

    public String getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
