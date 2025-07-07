package lab_20250707;
import java.util.logging.Logger;
public class UserService {
    private static final Logger logger = Logger.getLogger(UserService.class.getName());

    public boolean validateEmail(String email) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        boolean isValid = email != null && email.matches(emailRegex);

        if (isValid) {
            logger.info("Valid email: " + email);
        } else {
            logger.warning("Invalid email: " + email);
        }

        return isValid;
    }
}
