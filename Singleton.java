// Implement Singleton Design Pattern with lazy initialization and thread safety using synchronized block.
public class Singleton {
    private static Singleton instance;  // Private static instance variable
    private Singleton() {
        // Private constructor to prevent instantiation
    }

    // Public method to provide access to the instance
    public static Singleton getInstance() {
        if (instance == null) {  // Check if instance is null
            synchronized (Singleton.class) {  // Synchronize on the class object
                if (instance == null) {  // Double-check to ensure thread safety
                    instance = new Singleton();  // Create the instance
                }
            }
        }
        return instance;  // Return the singleton instance
    }  
}