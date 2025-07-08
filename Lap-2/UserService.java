public class UserService {
// Add logging to the validateEmail method to log valid and invalid email checks
    private static final org.apache.logging.log4j.Logger logger = org.apache.logging.log4j.LogManager.getLogger(UserService.class);

    /**
     * Validates the email format.
     *
     * @param email the email to validate
     * @return true if the email is valid, false otherwise
     */
    public boolean validateEmailWithLogging(String email) {
        boolean isValid = validateEmail(email);
        if (isValid) {
            logger.info("Valid email: {}", email);
        } else {
            logger.warn("Invalid email: {}", email);
        }
        return isValid;
    }
// Create a validateEmail method that checks if the email matches a valid regex pattern
    public boolean validateEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        return email.matches(emailRegex);
    }

}
