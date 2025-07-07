// Create a validateEmail method that checks if the email mathces a valid regex pattern
package com.example.userservice;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.logging.Logger;

public class UserService {
    private static final Logger LOGGER = Logger.getLogger(UserService.class.getName());

    // Regex pattern for validating email addresses
    private static final String EMAIL_REGEX = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
    private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);

    /**
     * Validates if the provided email matches the regex pattern.
     *
     * @param email the email to validate
     * @return true if the email is valid, false otherwise
     */
    public boolean validateEmail(String email) {
        if (email == null || email.isEmpty()) {
            LOGGER.warning("Email validation failed: email is null or empty");
            return false;
        }
        Matcher matcher = EMAIL_PATTERN.matcher(email);
        boolean isValid = matcher.matches();
        if (isValid) {
            LOGGER.info("Valid email checked: " + email);
        } else {
            LOGGER.warning("Invalid email checked: " + email);
        }
        return isValid;
    }
}