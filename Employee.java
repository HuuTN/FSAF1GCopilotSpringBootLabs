// Generate a toString method for the Employee class that formats id, name, and email into a single string
public class Employee {
    private int id;
    private String name;
    private String email;

    public Employee(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
// Create a thread-safe counter class that uses synchronized methods for incrementing and retrieving the count
public class Counter {
    private int count = 0;

    public synchronized void increment() {
        count++;
    }

    public synchronized int getCount() {
        return count;
    }
}