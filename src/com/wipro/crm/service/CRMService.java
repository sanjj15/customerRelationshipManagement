package com.wipro.crm.service;

import java.util.ArrayList;
import com.wipro.crm.entity.*;
import com.wipro.crm.util.*;

public class CRMService {

    private ArrayList<Customer> customers;
    private ArrayList<Interaction> interactions;

    public CRMService(ArrayList<Customer> customers, ArrayList<Interaction> interactions) {
        this.customers = customers;
        this.interactions = interactions;
    }

    public void addCustomer(Customer customer) throws CustomerExistsException {
        for (Customer c : customers) {
            if (c.getCustomerId().equals(customer.getCustomerId())) {
                throw new CustomerExistsException("Customer already exists");
            }
        }
        customers.add(customer);
    }

    public Customer searchCustomer(String customerId) throws CustomerNotFoundException {
        for (Customer c : customers) {
            if (c.getCustomerId().equals(customerId)) {
                return c;
            }
        }
        throw new CustomerNotFoundException("Customer not found");
    }

    public void updateCustomerStatus(String customerId, String newStatus)
            throws CustomerNotFoundException {
        Customer c = searchCustomer(customerId);
        c.setStatus(newStatus);
    }

    public void logInteraction(String customerId, String date, String notes)
            throws InteractionOperationException {

        if (notes == null || notes.isEmpty()) {
            throw new InteractionOperationException("Notes cannot be empty");
        }

        String interactionId = "I" + (interactions.size() + 1);
        interactions.add(new Interaction(interactionId, customerId, date, notes));
    }

    public ArrayList<Interaction> getCustomerInteractions(String customerId) {
        ArrayList<Interaction> result = new ArrayList<>();
        for (Interaction i : interactions) {
            if (i.getCustomerId().equals(customerId)) {
                result.add(i);
            }
        }
        return result;
    }

    public void deleteCustomer(String customerId) throws CustomerNotFoundException {
        Customer c = searchCustomer(customerId);
        customers.remove(c);
        interactions.removeIf(i -> i.getCustomerId().equals(customerId));
    }

    public void displayAllCustomers() {
        for (Customer c : customers) {
            System.out.println(c.getCustomerId() + " " +
                               c.getName() + " " +
                               c.getEmail() + " " +
                               c.getStatus());
        }
    }
}
