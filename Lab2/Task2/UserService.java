import java.util.regex.Pattern;
import java.util.logging.Logger;

public class UserService {
    private static final Logger logger = Logger.getLogger(UserService.class.getName());

    public boolean validateEmail(String email) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$";
        Pattern pattern = Pattern.compile(emailRegex);
        boolean isValid = pattern.matcher(email).matches();

        if (isValid) {
            logger.info("Valid email: " + email);
        } else {
            logger.warning("Invalid email: " + email);
        }

        return isValid;
    }
}