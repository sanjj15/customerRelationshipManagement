package com.wipro.crm.entity;

public class Customer {

    private String customerId;
    private String name;
    private String email;
    private String status;

    public Customer(String customerId, String name, String email, String status) {
        this.customerId = customerId;
        this.name = name;
        this.email = email;
        this.status = status;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
