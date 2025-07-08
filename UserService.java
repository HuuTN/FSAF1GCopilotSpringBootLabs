// Create a validateEmail method that checks if the email matches a valid regex pattern
//// Add logging to the validateEmail method to log valid and invalid email checks
package com.example.service;

public class UserService {
    public boolean validateEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        return email.matches(emailRegex);
    }
}