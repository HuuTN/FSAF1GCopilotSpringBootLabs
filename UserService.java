import java.util.logging.Logger;

public class UserService {
    private static final Logger logger = Logger.getLogger(UserService.class.getName());

    public static boolean validateEmail(String email) {
        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        boolean isValid = email != null && email.matches(regex);
        if (isValid) {
            logger.info("Valid email checked: " + email);
        } else {
            logger.warning("Invalid email checked: " + email);
        }
        return isValid;
    }
}
