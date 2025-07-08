package lab3_20250708.src.main.java.com.example.usermanagement.exception;

public class EntityNotFoundException extends RuntimeException {
    public EntityNotFoundException(String message) {
        super(message);
    }
} 