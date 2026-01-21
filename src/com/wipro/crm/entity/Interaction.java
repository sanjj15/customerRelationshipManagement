package com.wipro.crm.entity;

public class Interaction {

    private String interactionId;
    private String customerId;
    private String date;
    private String notes;

    public Interaction(String interactionId, String customerId, String date, String notes) {
        this.interactionId = interactionId;
        this.customerId = customerId;
        this.date = date;
        this.notes = notes;
    }

    public String getInteractionId() {
        return interactionId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getDate() {
        return date;
    }

    public String getNotes() {
        return notes;
    }
}
