// Create a validateEmail method that checks if the email matches a valid regex pattern
public class UserService {
    public boolean validateEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
        return email.matches(emailRegex);
    }
// Add logging to the validateEmail method to log valid and invalid email checks
    public void logEmailValidation(String email) {
        if (validateEmail(email)) {
            System.out.println("Valid email: " + email);
        } else {
            System.out.println("Invalid email: " + email);
        }
    }
}