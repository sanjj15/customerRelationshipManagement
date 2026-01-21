package com.wipro.crm.main; 
 
import java.util.ArrayList; 
import com.wipro.crm.entity.*; 
import com.wipro.crm.service.CRMService; 
import com.wipro.crm.util.*; 
 
public class Main { 
    public static void main(String[] args) { 
 
        ArrayList<Customer> customers = new ArrayList<>(); 
        customers.add(new Customer("C001", "Arjun", "arjun@mail.com", "NEW")); 
        customers.add(new Customer("C002", "Megha", "megha@mail.com", "IN_PROGRESS")); 
 
        ArrayList<Interaction> interactions = new ArrayList<>(); 
 
        CRMService service = new CRMService(customers, interactions); 
 
        try { 
            System.out.println("--- Adding Customer ---"); 
            service.addCustomer(new Customer("C003", "Rahul", "rahul@mail.com", "NEW")); 
 
            System.out.println("\n--- Updating Status ---"); 
            service.updateCustomerStatus("C002", "CLOSED"); 
 
            System.out.println("\n--- Logging Interaction ---"); 
            service.logInteraction("C001", "2025-07-15", "Discussed pricing options."); 
 
            System.out.println("\n--- Customer Interactions (C001) ---"); 
            for (Interaction i : service.getCustomerInteractions("C001")) { 
                System.out.println(i.getNotes()); 
            } 
 
            System.out.println("\n--- All Customers ---"); 
            service.displayAllCustomers(); 
 
            System.out.println("\n--- Deleting Customer C003 ---"); 
            service.deleteCustomer("C003"); 
 
        } catch (CustomerExistsException | CustomerNotFoundException | 
                 InteractionOperationException ex) { 
        	System.out.println(ex); 
        	}
        catch (Exception ex) { 
        	System.out.println("Unexpected Error: " + ex); 
        	} 
        } 
    }