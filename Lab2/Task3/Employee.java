// Generate a toString method for the Employee class that formats id, name, and email into a single string
package com.example.employeeservice;
import java.util.Objects;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.UUID;

public class Employee {
    private static final Logger LOGGER = Logger.getLogger(Employee.class.getName());
    
    private String id;
    private String name;
    private String email;

    // Constructor
    public Employee(String name, String email) {
        this.id = UUID.randomUUID().toString(); // Generate a unique ID
        this.name = name;
        this.email = email;
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    // toString method
    @Override
    public String toString() {
        return "Employee{id='" + id + "', name='" + name + "', email='" + email + "'}";
    }

    // Equals and hashCode methods
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return Objects.equals(id, employee.id) &&
               Objects.equals(name, employee.name) &&
               Objects.equals(email, employee.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email);
    }
}